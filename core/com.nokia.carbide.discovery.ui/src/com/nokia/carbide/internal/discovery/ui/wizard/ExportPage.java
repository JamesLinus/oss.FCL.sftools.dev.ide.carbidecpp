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


package com.nokia.carbide.internal.discovery.ui.wizard;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.progress.UIJob;

import com.nokia.carbide.discovery.ui.Messages;
import com.nokia.cpp.internal.api.utils.ui.BrowseDialogUtils;

/**
 * Page in export wizard
 */
class ExportPage extends AbstractImportExportPage {

	private File file;
	private Collection<FeatureInfo> featureInfos;
	private static String saveAsParent;

	protected ExportPage() {
		super("ExportPage"); //$NON-NLS-1$
		setTitle(Messages.ExportPage_Title);
		setDescription(Messages.ExportPage_Description);
	}

	public void createControl(Composite parent) {
		super.createControl(parent);
		Composite composite = (Composite) getControl();
		
        createViewerGroup(composite, Messages.ExportPage_ViewerGroupLabel);
		createBrowseGroup(composite, Messages.ExportPage_BrowseGroupLabel);
		
        featureInfos = new ArrayList<FeatureInfo>();
        
        setPageComplete(validatePage());
	}
	
	@Override
	protected void createViewerGroup(Composite parent, String labelText) {
		super.createViewerGroup(parent, labelText);

		viewer.addCheckStateListener(new ICheckStateListener() {
			public void checkStateChanged(CheckStateChangedEvent event) {
				setPageComplete(validatePage());
			}
		});
		startGetInputJob();
		updateViewer();
	}
	
	@Override
	protected void createBrowseGroup(Composite parent, String labelText) {
		super.createBrowseGroup(parent, labelText);
		
		if (saveAsParent == null)
			saveAsParent = System.getProperty("user.home"); //$NON-NLS-1$
		pathText.setText(new Path(saveAsParent).append("exportedFeatures.xml").toOSString()); //$NON-NLS-1$
        browseButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog dialog =  new FileDialog(getShell(), SWT.SAVE);
				dialog.setText(Messages.ExportPage_FileDialogText);
				BrowseDialogUtils.initializeFrom(dialog, pathText.getText());
				dialog.setOverwrite(true); // prompt for overwrite
				String path = dialog.open();
				if (path != null) {
					IPath saveAsPath = new Path(path);
					saveAsParent = saveAsPath.removeLastSegments(1).toString();
					pathText.setText(saveAsPath.toOSString());
				}
			}
        });
	}

	private void startGetInputJob() {
		UIJob j = new UIJob(Messages.ExportPage_GetFeaturesJobName) {
			@Override
			public IStatus runInUIThread(IProgressMonitor monitor) {
				viewer.setInput(P2Utils.getInstalledFeatures(monitor));
				updateViewer();
				return Status.OK_STATUS;
			} 
		};
		j.schedule();
	}
	
	protected boolean validatePage() {
		setErrorMessage(null);
		if (viewer.getTable().getItemCount() == 0) {
			setErrorMessage(Messages.ExportPage_NoFeaturesError);
			return false;
		}
		if (viewer.getCheckedElements().length == 0) {
			setErrorMessage(Messages.ExportPage_NoFeaturesSelectedError);
			return false;
		}
		
		IPath path = new Path(pathText.getText());
		file = path.toFile();
		if (!file.isAbsolute()) {
			setErrorMessage(Messages.ExportPage_NoFileError);
			return false;
		}
		if (file.exists()) {
			setMessage(Messages.ExportPage_FileOverwriteWarning, DialogPage.WARNING);
		}
		
		return true;
	}

	public File getFile() {
		return file;
	}

	public Collection<FeatureInfo> getFeatureInfos() {
		featureInfos.clear();
		for (Object o : viewer.getCheckedElements()) {
			featureInfos.add((FeatureInfo) o);
		}
		return featureInfos;
	}

}
