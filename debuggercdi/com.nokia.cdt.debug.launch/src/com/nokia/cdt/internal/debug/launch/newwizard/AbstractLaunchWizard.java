/*
* Copyright (c) 2010 Nokia Corporation and/or its subsidiary(-ies).
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

package com.nokia.cdt.internal.debug.launch.newwizard;

import java.text.MessageFormat;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IPageChangedListener;
import org.eclipse.jface.dialogs.PageChangedEvent;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.wizard.IWizardContainer;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import com.nokia.carbide.cpp.ui.CarbideUIPlugin;
import com.nokia.carbide.cpp.ui.ICarbideSharedImages;
import com.nokia.cdt.internal.debug.launch.LaunchPlugin;
import com.nokia.cdt.internal.debug.launch.wizard.ILaunchCreationWizard;
import com.nokia.cdt.internal.debug.launch.wizard.LaunchOptions;

/**
 * New launch wizard for Carbide 3.0.
 * 
 * See https://xdabug001.ext.nokia.com/bugzilla/show_bug.cgi?id=10419
 */
public abstract class AbstractLaunchWizard extends Wizard implements ILaunchCreationWizard {
	 
	protected IWizardData launchData;
	private AbstractUnifiedLaunchOptionsPage mainPage;
	private Button advancedButton;
	private boolean advancedEdit;
	private IPageChangedListener pageChangedListener;
	private boolean hasFinished;
	
	public AbstractLaunchWizard(LaunchOptions launchOptions, String title) {
		launchData = createWizardData(launchOptions);
		mainPage = createMainPage(launchData); 
		mainPage.initializeSettings();
		setWindowTitle(title);
    }

	protected abstract AbstractUnifiedLaunchOptionsPage createMainPage(IWizardData data);
	
	protected abstract IWizardData createWizardData(LaunchOptions options);

	@Override
	public void addPages() {
		addPage(mainPage);
	}
	
	@Override
	public void setContainer(final IWizardContainer wizardContainer) {
		super.setContainer(wizardContainer);
		
		// Thanks, JFace, for making it so hard to know when the UI is ready
		if (wizardContainer instanceof WizardDialog && advancedButton == null) {
			pageChangedListener = new IPageChangedListener() {
				
				public void pageChanged(PageChangedEvent event) {
					addAdvancedButton();
					((WizardDialog)getContainer()).removePageChangedListener(pageChangedListener);
				}
			};
			((WizardDialog)wizardContainer).addPageChangedListener(pageChangedListener);
		}
	}

	protected void addAdvancedButton() {
		if (advancedButton == null) {
			Composite parent = (Composite) ((Dialog) getContainer()).buttonBar;
			if (parent != null) {
				
				advancedButton = new Button(parent, SWT.CHECK);
				GridDataFactory.swtDefaults().align(SWT.LEFT, SWT.CENTER).indent(6, 0).applyTo(advancedButton);
				((GridLayout) parent.getLayout()).numColumns++;
				advancedButton.moveBelow(parent.getChildren()[0]);
				
				advancedButton.setText(Messages.getString("LaunchWizard.AdvancedLabel")); //$NON-NLS-1$
				advancedButton.setToolTipText(MessageFormat.format(
						Messages.getString("LaunchWizard.AdvancedTip"), //$NON-NLS-1$
						launchData.getModeLabel()));
				advancedButton.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						updateDebugEditButton();
					}
				});
			}
			
			// Thanks, JFace, for deleting validation messages on the first display
			mainPage.validatePage();
			updateDebugEditButton();
		}
	}
	
	@Override
	public boolean canFinish() {
		if (advancedEdit)
			return true;
		return super.canFinish();
	}	

	protected void updateDebugEditButton() {
		Button finishButton = findFinishButton();
		if (finishButton != null) {
			advancedEdit = advancedButton.getSelection();
			if (advancedEdit) {
				finishButton.setText(Messages.getString("LaunchWizard.EditLabel")); //$NON-NLS-1$
				finishButton.setToolTipText(Messages.getString("LaunchWizard.EditTip")); //$NON-NLS-1$
				getContainer().updateButtons();
			} else {
				finishButton.setText(launchData.getModeLabel());
				finishButton.setToolTipText(Messages.getString("LaunchWizard.FinishTip")); //$NON-NLS-1$
				getContainer().updateButtons();
			}
		}
	}

	/**
	 * Thanks, SWT and JFace, for making this so difficult
	 * @return the Finish button
	 */
	private Button findFinishButton() {
		if (getContainer() instanceof Dialog) {
			return findFinishButton((Composite) ((Dialog) getContainer()).buttonBar);
		}
		return null;
	}

	/**
	 * @param buttonBar
	 * @return
	 */
	private Button findFinishButton(Composite parent) {
		for (Control kid : parent.getChildren()) {
			if (kid instanceof Button) {
				if (kid.getData() instanceof Integer && (Integer) kid.getData() == IDialogConstants.FINISH_ID) {
					return (Button) kid;
				}
			}
			else if (kid instanceof Composite) {
				Button button = findFinishButton((Composite) kid);
				if (button != null)
					return button;
			}
		}
		return null;
	}

	@Override
	public boolean performFinish() {
		hasFinished = true;
		return true;
	}

	public boolean shouldOpenLaunchConfigurationDialog() {
		return hasFinished && advancedEdit;
	}

	public ILaunchConfigurationWorkingCopy getLaunchConfiguration() {
		if (!hasFinished)
			return null;
		
		ILaunchConfigurationWorkingCopy config = null;
		try {
			config = launchData.createConfiguration();
		} catch (CoreException e) {
			LaunchPlugin.log(e);
		}
		
		return config;
	}

	public void init() {
		setDefaultPageImageDescriptor(CarbideUIPlugin.getSharedImages().getImageDescriptor(ICarbideSharedImages.IMG_NEW_LAUNCH_CONFIG_WIZARD_BANNER));
	}

	public int openWizard(Shell shell) {
		WizardDialog dialog = new WizardDialog(shell, this);
		return dialog.open();
	}
}
