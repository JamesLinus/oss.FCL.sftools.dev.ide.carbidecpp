/**
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

package com.nokia.carbide.remoteconnections.internal.ui;

import java.text.MessageFormat;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.mylyn.internal.provisional.commons.ui.AbstractNotificationPopup;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;

import com.nokia.carbide.remoteconnections.internal.api.IStatusDisplay;
import com.nokia.cpp.internal.api.utils.core.Check;

@SuppressWarnings("restriction")
public class StatusDisplay implements IStatusDisplay {
		
	private final class NotificationPopup extends AbstractNotificationPopup {
		private final IStatus status;
		private final String prompt;

		private NotificationPopup(Display display, IStatus status, String prompt) {
			super(display);
			this.status = status;
			this.prompt = prompt;
			setDelayClose(30 * 1000);
		}
		
		protected void createContentArea(Composite composite) {
			GridLayoutFactory.fillDefaults().margins(5, 5).applyTo(composite);
			Label label = new Label(composite, SWT.WRAP);
			label.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			label.setText(status.getMessage());
			label.setBackground(composite.getBackground());
			if (prompt != null) {
				Link link = new Link(composite, SWT.WRAP);
				link.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
				link.setText(MessageFormat.format("<a href=\"{0}\">{0}</a>", prompt));
				link.setBackground(composite.getBackground());
				link.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent e) {
						clicked = true;
						NotificationPopup.this.close();
					}
				});
			}
		}
		
		@Override
		protected String getPopupShellTitle() {
			switch (status.getSeverity()) {
			case IStatus.INFO:
				return "Information";
			case IStatus.WARNING:
				return "Warning";
			case IStatus.ERROR:
				return "Error";
			};
			Check.checkState(false);
			return null;
		}
	 
		@Override
		protected Image getPopupShellImage(int maximumHeight) {
			switch (status.getSeverity()) {
			case IStatus.INFO:
				return JFaceResources.getImage(Dialog.DLG_IMG_MESSAGE_INFO);
			case IStatus.WARNING:
				return JFaceResources.getImage(Dialog.DLG_IMG_MESSAGE_WARNING);
			case IStatus.ERROR:
				return JFaceResources.getImage(Dialog.DLG_IMG_MESSAGE_ERROR);
			};
			Check.checkState(false);
			return null;
		}
	}

	private boolean clicked;
	private boolean closed;

	public StatusDisplay() {
	}

	public void displayStatus(final IStatus status) {
		final Display display = Display.getDefault();
		display.syncExec(new Runnable() {
			public void run() {
				doDisplayStatus(display, null, status);
			}
		});
	}

	public void displayStatusWithAction(final IStatus status, final String prompt, Runnable action) {
		final Display display = Display.getDefault();
		display.asyncExec(new Runnable() {
			public void run() {
				doDisplayStatus(display, prompt, status);
			}
		});
		while (!closed) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e1) {
			}
		}
		if (clicked)
			action.run();
	}

	protected void doDisplayStatus(Display display, String prompt, IStatus status) {
		NotificationPopup popup = new NotificationPopup(display, status, prompt);
		popup.open();
		popup.getShell().addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				StatusDisplay.this.closed = true;
			}
		});
	}

}