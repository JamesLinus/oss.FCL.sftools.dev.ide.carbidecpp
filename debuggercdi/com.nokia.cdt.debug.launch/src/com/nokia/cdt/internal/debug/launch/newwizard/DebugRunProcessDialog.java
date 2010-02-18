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

import java.io.File;
import java.text.MessageFormat;
import java.util.List;

import org.eclipse.cdt.core.model.CoreModel;
import org.eclipse.cdt.core.settings.model.CProjectDescriptionEvent;
import org.eclipse.cdt.core.settings.model.ICProjectDescriptionListener;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.PreferencesUtil;

import com.nokia.carbide.cdt.builder.CarbideBuilderPlugin;
import com.nokia.carbide.cdt.builder.project.ICarbideBuildConfiguration;
import com.nokia.carbide.cdt.builder.project.ICarbideProjectInfo;
import com.nokia.carbide.cdt.builder.project.ISISBuilderInfo;
import com.nokia.cdt.internal.debug.launch.newwizard.LaunchWizardData.EExeSelection;
import com.nokia.cpp.internal.api.utils.core.PathUtils;
import com.nokia.cpp.internal.api.utils.ui.BrowseDialogUtils;

/**
 *	This dialog allows in-depth configuration of the debug/run process options.
 */
public class DebugRunProcessDialog extends AbstractLaunchSettingsDialog implements ICProjectDescriptionListener {
	private ComboViewer projectExecutableViewer;
	private Text remoteProgramEntry;
	private Button projectExecutableRadioButton;
	private Button remoteExecutableRadioButton;
	private Button attachToProcessRadioButton;
	
	private Label packageInfoLabel;
	private Button installPackageCheckbox;
	private Combo sisFile;
	private Text sisEdit;
	private Button sisBrowse;
	private Composite installPackageUI;
	
	protected DebugRunProcessDialog(Shell shell, LaunchWizardData data) {
		super(shell, data);
	}

	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.Dialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = initDialogArea(parent, 
				MessageFormat.format(Messages.getString("DebugRunProcessDialog.ChangeProcessMsg"), data.getModeLabel()), //$NON-NLS-1$
				data.isDebug() ? LaunchWizardHelpIds.WIZARD_DIALOG_CHANGE_DEBUG_PROCESS : 
					LaunchWizardHelpIds.WIZARD_DIALOG_CHANGE_RUN_PROCESS);


		createProcessSelector(composite);
		
		Label sep = new Label(composite, SWT.NONE);
		GridDataFactory.fillDefaults().applyTo(sep);
		
		createPackageConfiguration(composite);

		initUI();
		
		validate();

		return composite;
	}


	private void createProcessSelector(Composite composite) {
		Label label;
		
		label = new Label(composite, SWT.WRAP);
		label.setText(MessageFormat.format(Messages.getString("DebugRunProcessDialog.ModeLabel"), data.getModeLabel())); //$NON-NLS-1$
		label.setFont(JFaceResources.getFontRegistry().getBold(JFaceResources.DIALOG_FONT));
		
		GridDataFactory.fillDefaults().grab(true, false).applyTo(composite);
		
		Composite radioGroup = new Composite(composite, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(radioGroup);
		GridLayoutFactory.fillDefaults().extendedMargins(INDENT, 0, 0, 0).numColumns(2).applyTo(radioGroup);

		createProjectExecutableRadioButton(radioGroup);
		createRemoteExecutableRadioButton(radioGroup);
		
		label = new Label(radioGroup, SWT.SEPARATOR | SWT.HORIZONTAL);
		GridDataFactory.fillDefaults().grab(true, false).span(2, 1).applyTo(label);
		
		createAttachToProcessRadioButton(radioGroup);
		
		String msg;
		if (data.isDebug())
			msg = Messages.getString("DebugRunProcessDialog.DebugConfigureMsg"); //$NON-NLS-1$
		else
			msg = Messages.getString("DebugRunProcessDialog.RunConfigureMsg"); //$NON-NLS-1$
		setMessage(msg);
		
		switch (data.getExeSelection()) {
		case USE_PROJECT_EXECUTABLE:
			projectExecutableRadioButton.setSelection(true);
			break;
		case USE_REMOTE_EXECUTABLE:
			remoteExecutableRadioButton.setSelection(true);
			break;
		case ATTACH_TO_PROCESS:
			attachToProcessRadioButton.setSelection(true);
			break;
		}
	}

	private void createPackageConfiguration(Composite composite) {
		Label label;
		
		label = new Label(composite, SWT.WRAP);
		label.setText(MessageFormat.format(Messages.getString("DebugRunProcessDialog.DeployLabel"), data.getModeLabel())); //$NON-NLS-1$
		label.setFont(JFaceResources.getFontRegistry().getBold(JFaceResources.DIALOG_FONT));
		
		GridDataFactory.fillDefaults().grab(true, true).applyTo(composite);
		
		packageInfoLabel = new Label(composite, SWT.WRAP);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(packageInfoLabel);
		composite.addControlListener(new ControlAdapter() {
			@Override
			public void controlResized(ControlEvent e) {
				packageInfoLabel.pack();
			}
		});
		
		installPackageCheckbox = new Button(composite, SWT.CHECK);
		GridDataFactory.fillDefaults().applyTo(installPackageCheckbox);
		
		installPackageCheckbox.setText(Messages.getString("DebugRunProcessDialog.InstallBeforeLaunchLabel")); //$NON-NLS-1$
		installPackageUI = new Composite(composite, SWT.NONE);
		GridDataFactory.fillDefaults().indent(INDENT, 0).applyTo(installPackageUI);
		
		createSISContents(installPackageUI);
		
		
		installPackageCheckbox.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				data.setInstallPackage(installPackageCheckbox.getSelection());
				updatePackageUI();
			}
		});
		
		
		if (data.isInstallPackage()) {
			installPackageCheckbox.setSelection(true);
			updatePackageUI();
		}
		
		updateSisFile();
		updatePackageUI();
	}
	
    protected void createSISContents(Composite composite) {
        GridLayoutFactory.fillDefaults().margins(6, 6).numColumns(2).applyTo(composite);
            
		final IProject project = data.getProject();
		ICarbideProjectInfo cpi = CarbideBuilderPlugin.getBuildManager().getProjectInfo(project);
		if (cpi != null) {
			final Label sisLabel = new Label(composite, SWT.NONE);
			sisLabel.setText(Messages.getString("DebugRunProcessDialog.SISFileLabel")); //$NON-NLS-1$
			GridDataFactory.fillDefaults().align(SWT.LEFT, SWT.CENTER).span(1, 1).applyTo(sisLabel);
			sisLabel.setToolTipText(Messages.getString("DebugRunProcessDialog.SISQueryTip")); //$NON-NLS-1$
			sisLabel.setData(UID, "DebugRunProcessDialog.sisLabel"); //$NON-NLS-1$

			sisFile = new Combo(composite, SWT.READ_ONLY);
			GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).span(1, 1).grab(true, false).applyTo(sisLabel);
			sisFile.setToolTipText(Messages.getString("DebugRunProcessDialog.SISQueryTip"));  //$NON-NLS-1$
			sisFile.add("None"); //$NON-NLS-1$
			sisFile.setData(UID, "DebugRunProcessDialog.sisFile"); //$NON-NLS-1$
			
			sisFile.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					updateSisFile();
				}
			});
			
			ICarbideBuildConfiguration config = cpi.getDefaultConfiguration();
			for (ISISBuilderInfo info : config.getSISBuilderInfoList()) {
				IPath sisPath = info.getSigningType() == ISISBuilderInfo.DONT_SIGN ? info.getUnsignedSISFullPath() : info.getSignedSISFullPath();
				sisFile.add(sisPath.toOSString());
			}
			
			// select the first sis file if any, otherwise select none
			if (sisFile.getItemCount() > 1) {
				sisFile.select(1);
			} else {
				sisFile.select(0);
			}

			// listen for events so we can detect if they click on the link below and add new sis info.
			CoreModel.getDefault().getProjectDescriptionManager().addCProjectDescriptionListener(this, CProjectDescriptionEvent.APPLIED);

			composite.addDisposeListener(new DisposeListener() {
				
				public void widgetDisposed(DisposeEvent e) {
					CoreModel.getDefault().getProjectDescriptionManager().removeCProjectDescriptionListener(DebugRunProcessDialog.this);
				}
			});
			
			Link link = new Link(composite, SWT.NONE);
			link.setText("<a>" + Messages.getString("DebugRunProcessDialog.SISConfigLinkText") + "...</a>"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			GridDataFactory.swtDefaults().align(SWT.FILL, SWT.CENTER).span(2, 1).grab(true, false).applyTo(link);
			link.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					PreferencesUtil.createPropertyDialogOn(getShell(), project, "com.nokia.carbide.cdt.internal.builder.ui.CarbideBuildConfigurationsPage", null, null).open(); //$NON-NLS-1$
				}
			});
			link.setData(UID, "DebugRunProcessDialog.link"); //$NON-NLS-1$
		} else {
			// not a Carbide project, just an executable.  show a browse/edit combo
			// to let them select a sis file if they want to.
			final Label sisLabel = new Label(composite, SWT.NONE);
			sisLabel.setText("SIS File to Install:"); //$NON-NLS-1$
			GridDataFactory.swtDefaults().span(2, 1).applyTo(sisLabel);
			sisLabel.setToolTipText(Messages.getString("DebugRunProcessDialog.SISQueryTip")); //$NON-NLS-1$
			sisLabel.setData(UID, "DebugRunProcessDialog.sisLabel"); //$NON-NLS-1$

			sisEdit = new Text(composite, SWT.BORDER);
			GridDataFactory.fillDefaults().span(1, 1).align(SWT.FILL, SWT.CENTER).grab(true, false).applyTo(sisEdit);
			sisEdit.setToolTipText(Messages.getString("DebugRunProcessDialog.SISQueryTip")); //$NON-NLS-1$
			sisEdit.addModifyListener(new ModifyListener() {
				public void modifyText(ModifyEvent e) {
					updateSisFile();
					validate();
				}
			});
			sisEdit.setData(UID, "DebugRunProcessDialog.sisEdit"); //$NON-NLS-1$

			sisBrowse = new Button(composite, SWT.NONE);
			sisBrowse.setText(Messages.getString("DebugRunProcessDialog.BrowseLabel")); //$NON-NLS-1$
			sisBrowse.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
			sisBrowse.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {
					FileDialog dialog = new FileDialog(getShell(), SWT.NONE);

					dialog.setText(Messages.getString("DebugRunProcessDialog.Title")); //$NON-NLS-1$
					dialog.setFilterExtensions(new String[] {"*.sis*", "*.*"}); //$NON-NLS-1$ //$NON-NLS-2$
					dialog.setFilterNames(new String[] {Messages.getString("DebugRunProcessDialog.InstallFilterName"), Messages.getString("DebugRunProcessDialog.AllFilterName")}); //$NON-NLS-1$ //$NON-NLS-2$

					BrowseDialogUtils.initializeFrom(dialog, sisEdit);

					String result = dialog.open();
					if (result != null && new File(result).exists()) {
						sisEdit.setText(result);
						updateSisFile();
						validate();
					}
				}
			});
			sisBrowse.setData(UID, "DebugRunProcessDialog.sisBrowse"); //$NON-NLS-1$
		}
    }
    
    
	/**
	 * 
	 */
	protected void updateSisFile() {
		String sisPath;
    	if (sisFile != null) {
        	sisPath = sisFile.getSelectionIndex() == 0 ? null : sisFile.getText(); //$NON-NLS-1$
        	data.setSisPath(sisPath);
    	} else if (sisEdit != null) {
    		sisPath = sisEdit.getText();
    		data.setSisPath(sisPath);
    	}
	}


	private void updatePackageUI() {
		installPackageUI.setEnabled(data.isInstallPackage());
		for (Control kid : installPackageUI.getChildren())
			kid.setEnabled(data.isInstallPackage());
	}


	public void handleEvent(CProjectDescriptionEvent event) {
		Shell shell = getShell();
		if (shell == null || shell.isDisposed()) {
			return;
		}
		
		IProject project = event.getProject() ;
		
		if (project != data.getProject()) {
			return;
		}
		
		if (sisFile != null) {
			ICarbideProjectInfo cpi = CarbideBuilderPlugin.getBuildManager().getProjectInfo(project);
			if (cpi != null) {
				sisFile.removeAll();

				sisFile.add(Messages.getString("DebugRunProcessDialog.NoneItem")); //$NON-NLS-1$
				
				ICarbideBuildConfiguration config = cpi.getDefaultConfiguration();
				for (ISISBuilderInfo info : config.getSISBuilderInfoList()) {
					IPath sisPath = info.getSigningType() == ISISBuilderInfo.DONT_SIGN ? info.getUnsignedSISFullPath() : info.getSignedSISFullPath();
					sisFile.add(sisPath.toOSString());
				}
				
				// select the first sis file if any, otherwise select none
				if (sisFile.getItemCount() > 1) {
					sisFile.select(1);
				} else {
					sisFile.select(0);
				}
			}
		}
	}
	
	protected void initUI() {
		List<IPath> exes = data.getExes();
		projectExecutableViewer.setInput(exes);
		IPath exeSelectionPath = data.getExeSelectionPath();
		if (exeSelectionPath.equals(Path.EMPTY) && !exes.isEmpty())
			exeSelectionPath = exes.get(0);
		projectExecutableViewer.setSelection(new StructuredSelection(exeSelectionPath));
		IPath remotePath = createSuggestedRemotePath(exeSelectionPath);
		remoteProgramEntry.setText(PathUtils.convertPathToWindows(remotePath));

		if (data.getExeSelection() == EExeSelection.USE_PROJECT_EXECUTABLE && exeSelectionPath != null) {
			projectExecutableRadioButton.forceFocus();
		}
		
		if (data.getExeSelection() == EExeSelection.USE_REMOTE_EXECUTABLE && exeSelectionPath != null) {
			remoteExecutableRadioButton.forceFocus();
		}
		
		if (data.getExeSelection() == EExeSelection.ATTACH_TO_PROCESS) {
			attachToProcessRadioButton.forceFocus();
		}

		handleProjectExecutableRadioSelected();
		handleRemoteExecutableRadioSelected();
		handleAttachToProcessRadioSelected();
	}


	private IPath createSuggestedRemotePath(IPath exeSelectionPath) {
		String filename = exeSelectionPath.lastSegment();
		return PathUtils.createPath("C:/sys/bin").append(filename); //$NON-NLS-1$
	}

	/**
	 * Allow selecting an executable detected to be built by the program.
	 * @param radioGroup
	 */
	private void createProjectExecutableRadioButton(Composite radioGroup) {
		projectExecutableRadioButton = new Button(radioGroup, SWT.RADIO);
		GridDataFactory.fillDefaults().grab(false, false).applyTo(projectExecutableRadioButton);
		projectExecutableRadioButton.setText(Messages.getString("DebugRunProcessDialog.LaunchProjectExeLabel")); //$NON-NLS-1$
		projectExecutableRadioButton.setData(UID, "radio_project_executable"); //$NON-NLS-1$
		
		projectExecutableViewer = new ComboViewer(radioGroup, SWT.READ_ONLY);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(projectExecutableViewer.getControl());
		projectExecutableViewer.getControl().setData(UID, "combo_project_executable"); //$NON-NLS-1$
		
		projectExecutableViewer.setContentProvider(new ArrayContentProvider());
		projectExecutableViewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof IPath)
					return ((IPath) element).lastSegment();
				return super.getText(element);
			}
		});
		
		projectExecutableRadioButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				handleProjectExecutableRadioSelected();
			}

		});
		
		projectExecutableViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			
			public void selectionChanged(SelectionChangedEvent event) {
				Object sel = ((IStructuredSelection) event.getSelection()).getFirstElement();
				if (sel instanceof IPath) {
					data.setExeSelectionPath((IPath) sel); 
					
					// track the default remote program from the executable, for easy editing
					if (remoteProgramEntry != null) {
						IPath exeSelectionPath = createSuggestedRemotePath(data.getExeSelectionPath());
						remoteProgramEntry.setText(PathUtils.convertPathToWindows(exeSelectionPath)); 
					}
					
					validate();
				}
			}
		});
	}

	private void handleProjectExecutableRadioSelected() {
		if (projectExecutableRadioButton.getSelection()) {
			projectExecutableViewer.getControl().setEnabled(true);
			data.setExeSelection(EExeSelection.USE_PROJECT_EXECUTABLE);
			IPath selectedPath = (IPath) ((IStructuredSelection) projectExecutableViewer.getSelection()).getFirstElement();
			if (selectedPath != null) {
				String symbianPath = PathUtils.convertPathToWindows(selectedPath);
				data.setExeSelectionPath(new Path(symbianPath));
			}
			validate();
		} else {
			projectExecutableViewer.getControl().setEnabled(false);
			// another button becomes active and sets the new launch process
		}
	}

	/**
	 * Allow user to enter an executable path.
	 * @param radioGroup
	 */
	private void createRemoteExecutableRadioButton(Composite radioGroup) {
		remoteExecutableRadioButton = new Button(radioGroup, SWT.RADIO);
		GridDataFactory.fillDefaults().grab(false, false).applyTo(remoteExecutableRadioButton);
		remoteExecutableRadioButton.setText(Messages.getString("DebugRunProcessDialog.LaunchRemoteProgLabel")); //$NON-NLS-1$
		
		remoteExecutableRadioButton.setData(UID, "radio_remote_program"); //$NON-NLS-1$
		
		remoteProgramEntry = new Text(radioGroup, SWT.BORDER);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(remoteProgramEntry);
		
		remoteProgramEntry.setData(UID, "text_remote_program"); //$NON-NLS-1$
		
		remoteExecutableRadioButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				handleRemoteExecutableRadioSelected();
			}

		});
		
		remoteProgramEntry.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				data.setExeSelectionPath(new Path(remoteProgramEntry.getText().trim()));
				validate();
			}
		});
	}

	private void handleRemoteExecutableRadioSelected() {
		if (remoteExecutableRadioButton.getSelection()) {
			remoteProgramEntry.setEnabled(true);
			data.setExeSelection(EExeSelection.USE_REMOTE_EXECUTABLE);
			String symbianPath = PathUtils.convertPathToWindows(remoteProgramEntry.getText());
			data.setExeSelectionPath(new Path(symbianPath));
			validate();
		} else {
			remoteProgramEntry.setEnabled(false);
			// another button becomes active and sets the new launch process
		}
	}

	/**
	 * Allow user to attach to a process.
	 * @param radioGroup
	 */
	private void createAttachToProcessRadioButton(Composite radioGroup) {
		attachToProcessRadioButton = new Button(radioGroup, SWT.RADIO);
		GridDataFactory.fillDefaults().grab(false, false).applyTo(attachToProcessRadioButton);
		attachToProcessRadioButton.setText(Messages.getString("DebugRunProcessDialog.AttachLabel")); //$NON-NLS-1$
		
		attachToProcessRadioButton.setData(UID, "radio_attach_to_process"); //$NON-NLS-1$
		
		Label label = new Label(radioGroup, SWT.WRAP);
		GridDataFactory.fillDefaults().grab(false, false).align(SWT.LEFT, SWT.CENTER).applyTo(label);
		
		label.setText(Messages.getString("DebugRunProcessDialog.AttachAddlMsg")); //$NON-NLS-1$
		
		attachToProcessRadioButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				handleAttachToProcessRadioSelected();
			}

		});
		
	}
	
	private void handleAttachToProcessRadioSelected() {
		if (attachToProcessRadioButton.getSelection()) {
			data.setExeSelection(EExeSelection.ATTACH_TO_PROCESS);
			data.setExeSelectionPath(null);
			validate();
		} else {
			// another button becomes active and sets the new launch process
		}
	}

	@Override
	protected void validate() {
		IStatus status = Status.OK_STATUS;
		
		// check launch method
		IPath exePath = data.getExeSelectionPath(); 
		switch (data.getExeSelection()) {
		case USE_PROJECT_EXECUTABLE:
			if (exePath.isEmpty()) {
				status = error(Messages.getString("DebugRunProcessDialog.NoExesError")); //$NON-NLS-1$
			}
			break;
		case USE_REMOTE_EXECUTABLE:
			if (exePath.isEmpty()) {
				status = error(Messages.getString("DebugRunProcessDialog.EnterPathError")); //$NON-NLS-1$
			} else {
				String exePathString = exePath.toString();
				char drive = exePathString.charAt(0);
				char colon = exePathString.length() < 2 ? 0x0 : exePathString.charAt(1);
				char root = exePathString.length() < 3 ? 0x0 : exePathString.charAt(2);
				char lastChar = exePathString.charAt(exePathString.length() - 1);
				if (!Character.isLetter(drive) || colon != ':' || (root != '\\' && root != '/') || 
						lastChar == '\\' || lastChar == '/' || lastChar == ':') { 
					status = error(Messages.getString("DebugRunProcessDialog.AbsolutePathError")); //$NON-NLS-1$
				} else if (exePath.getFileExtension() == null) {
					status = warning(Messages.getString("DebugRunProcessDialog.FilePathError")); //$NON-NLS-1$
				}
			}
			break;
		case ATTACH_TO_PROCESS:
			break;
		}
		
		// check SIS selection
		if (data.isInstallPackage()) {
	    	if (sisEdit != null) {
	    		String text = sisEdit.getText().trim();
	    		if (text.length() > 0) {
	    			// empty is allowed, but if they specify something, make sure
	    			// it exists
	    			File file = new File(text);
	    			if (!file.exists()) {
	    				status = error(Messages.getString("DebugRunProcessDialog.SISFileExistError"), text); //$NON-NLS-1$
	    			}
	    		}
	    	}
		}
		
		updateStatus(status);
	}
}
