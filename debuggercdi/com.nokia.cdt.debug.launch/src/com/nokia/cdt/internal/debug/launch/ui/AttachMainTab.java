/*
* Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies).
* All rights reserved.
* This component and the accompanying materials are made available
* under the terms of the License "Eclipse Public License v1.0"
* which accompanies this distribution, and is available
* at the URL "http://www.eclipse.org/legal/epl-v10.html".
*
* Initial Contributors:
* Nokia Corporation - initial contribution.
*
* Contributors:
*
* Description: 
*
*/
package com.nokia.cdt.internal.debug.launch.ui;

import com.freescale.cdt.debug.cw.core.RemoteConnectionsTRKHelper;
import com.nokia.carbide.remoteconnections.RemoteConnectionsActivator;
import com.nokia.carbide.remoteconnections.interfaces.IClientServiceSiteUI2;
import com.nokia.carbide.remoteconnections.interfaces.IClientServiceSiteUI2.IListener;
import com.nokia.cdt.internal.debug.launch.LaunchPlugin;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

public class AttachMainTab extends CarbideMainTab {

	protected Label remoteLabel;
	protected Text remoteText;
	protected Label argsLabel;
	protected Text argsText;
	protected String connection;
	protected IClientServiceSiteUI2 clientSiteUI;
	
	public AttachMainTab() {
		super(DONT_CHECK_PROGRAM);
	}

	public void createControl(Composite parent) {
		Composite comp = new Composite(parent, SWT.NONE);
		setControl(comp);
		
		LaunchPlugin.getDefault().getWorkbench().getHelpSystem().setHelp(getControl(), LaunchTabHelpIds.ATTACH_MAIN);
		
		GridLayout topLayout = new GridLayout();
		comp.setLayout(topLayout);

		createVerticalSpacer(comp, 1);
		createProjectGroup(comp, 1);

		fProjLabel.setToolTipText(Messages.getString("RunModeMainTab.8")); //$NON-NLS-1$
		fProjText.setToolTipText(Messages.getString("RunModeMainTab.8")); //$NON-NLS-1$

		createVerticalSpacer(comp, 1);
		clientSiteUI = RemoteConnectionsActivator.getConnectionsManager().getClientSiteUI2(
				LaunchPlugin.getRunModeDebugService());
		clientSiteUI.createComposite(comp);
		clientSiteUI.addListener(new IListener() {
			public void connectionSelected() {
				connection = clientSiteUI.getSelectedConnection();
				updateLaunchConfigurationDialog();
			}
		});
		
		createVerticalSpacer(comp, 1);
		if (wantsTerminalOption() /*&& ProcessFactory.supportesTerminal()*/) {
			createTerminalOption(comp, 1);
			createVerticalSpacer(comp, 1);
		}
		createBuildOptionGroup(comp, 1);
	}

	public void setDefaults(ILaunchConfigurationWorkingCopy config) {
	}

	public void initializeFrom(ILaunchConfiguration config) {
		super.initializeFrom(config);
		try {
	        if (!RemoteConnectionsTRKHelper.configUsesConnectionAttribute(config)) {
	        	config = RemoteConnectionsTRKHelper.attemptUpdateLaunchConfiguration(config.getWorkingCopy());
	        }
			connection = RemoteConnectionsTRKHelper.getConnectionIdFromConfig(config);
		} catch (CoreException e) {
		}
		if (connection != null)
			clientSiteUI.selectConnection(connection);
		else {
			connection = clientSiteUI.getSelectedConnection();
		}
	}

	public void performApply(ILaunchConfigurationWorkingCopy config) {
		super.performApply(config);
		if (connection != null) {
			config.setAttribute(RemoteConnectionsTRKHelper.CONNECTION_ATTRIBUTE, connection);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#isValid(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	public boolean isValid(ILaunchConfiguration config) {
		boolean result = super.isValid(config);
		if (result) {
			IStatus status = clientSiteUI.getSelectionStatus();
			if (!status.isOK()) {
				// unfortunately, no way to display a warning here...
				setErrorMessage(status.getMessage());
				result = status.getSeverity() != IStatus.ERROR;
			}
		}
		return result;
	}

}
