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
package com.nokia.carbide.remoteconnections.discovery.pccs.agent;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;

import com.nokia.carbide.remoteconnections.RemoteConnectionsActivator;
import com.nokia.carbide.remoteconnections.discovery.pccs.Activator;
import com.nokia.carbide.remoteconnections.discovery.pccs.Messages;
import com.nokia.carbide.remoteconnections.discovery.pccs.pccsnative.DeviceConnectionInfo;
import com.nokia.carbide.remoteconnections.discovery.pccs.pccsnative.DeviceInfo;
import com.nokia.carbide.remoteconnections.discovery.pccs.pccsnative.PCCSConnection;
import com.nokia.carbide.remoteconnections.discovery.pccs.pccsnative.PCCSConnection.DeviceEventListener;
import com.nokia.carbide.remoteconnections.interfaces.IConnection;
import com.nokia.carbide.remoteconnections.interfaces.IConnectionFactory;
import com.nokia.carbide.remoteconnections.interfaces.IConnectionType;
import com.nokia.carbide.remoteconnections.interfaces.IConnectionsManager;
import com.nokia.carbide.remoteconnections.internal.api.IConnection2;
import com.nokia.carbide.remoteconnections.internal.api.IDeviceDiscoveryAgent;

/**
 * Implementation of IDeviceDiscoveryAgent for PCCS USB connection.
 */
public class PCCSDiscoveryAgent implements IDeviceDiscoveryAgent, DeviceEventListener {

	private static final String USB_CONNECTION_TYPE = 
		"com.nokia.carbide.trk.support.connection.USBConnectionType"; //$NON-NLS-1$
	private static final String PORT_SETTING = "port"; //$NON-NLS-1$

	public class PCCSPrequisiteStatus implements IPrerequisiteStatus {
		private boolean isOK = true;
		private String errorText;
		private URL errorURL;
		
		public PCCSPrequisiteStatus() {
			isOK = true;
			errorText = null;
			errorURL = null;
		}

		public PCCSPrequisiteStatus(boolean ok, String msg, URL url) {
			isOK = ok;
			errorText = msg;
			errorURL = url;
		}
		/* (non-Javadoc)
		 * @see com.nokia.carbide.remoteconnections.internal.api.IDeviceDiscoveryAgent.IPrerequisiteStatus#getErrorText()
		 */
		public String getErrorText() {
			return errorText;
		}

		/* (non-Javadoc)
		 * @see com.nokia.carbide.remoteconnections.internal.api.IDeviceDiscoveryAgent.IPrerequisiteStatus#getURL()
		 */
		public URL getURL() {
			return errorURL;
		}

		/* (non-Javadoc)
		 * @see com.nokia.carbide.remoteconnections.internal.api.IDeviceDiscoveryAgent.IPrerequisiteStatus#isOK()
		 */
		public boolean isOK() {
			return isOK;
		}

	}

	protected Map<String, IConnection2> connections;
	protected IConnectionsManager manager;
	protected PCCSConnection pccsConnection;
	private IPrerequisiteStatus loadStatus = new PCCSPrequisiteStatus();

	/**
	 * Constructs a PCCSDiscoveryAgent object
	 */
	public PCCSDiscoveryAgent() {
		connections = new HashMap<String, IConnection2>();
		manager = RemoteConnectionsActivator.getConnectionsManager();
		pccsConnection = new PCCSConnection();
	}

	private boolean isSymSEELayout() {
		return Activator.isSymSEELayout();
	}

	/*
	 * (non-Javadoc)
	 * @see com.nokia.carbide.remoteconnections.internal.IDeviceDiscoveryAgent#getInformation()
	 */
	public URL getInformation() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.nokia.carbide.remoteconnections.discovery.pccs.pccsnative.PCCSConnection.DeviceEventListener#onDeviceEvent(com.nokia.carbide.remoteconnections.discovery.pccs.pccsnative.PCCSConnection.DeviceEventListener.DeviceEvent, java.lang.String)
	 */
	public void onDeviceEvent(DeviceEvent eventType, String serialNumber) {
		try {
			switch (eventType) {
			case DEVICE_LIST_UPDATED:
			case DEVICE_ADDED:
			case DEVICE_REMOVED:
			case DEVICE_UPDATED_ADDEDCONNECTION:
			case DEVICE_UPDATED_REMOVEDCONNECTION:
				updateConnections(pccsConnection.getDeviceList());
				break;
			case DEVICE_UPDATED_RENAMED:
				// TODO what to do when device is renamed?
				break;
			}
		} catch (CoreException e) {
			RemoteConnectionsActivator.logError(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.nokia.carbide.remoteconnections.internal.IDeviceDiscoveryAgent#start()
	 */
	public void start() throws CoreException {
		try {
			pccsConnection.open();
		} catch (CoreException ce) {
			saveLoadStatus(ce);
			throw ce;		// rethrow
		}
		updateConnections(pccsConnection.getDeviceList());
		pccsConnection.addEventListenter(this);
	}

	private void saveLoadStatus(CoreException ce) {
		String msg = null;
		URL location = null;
		if (isSymSEELayout()) {
			if (ce.getStatus().getCode() == PCCSConnection.PCCS_NOT_FOUND)
				msg = Messages.PCCSDiscoveryAgent_PCCS_Not_Found_Error;
			else
				msg = Messages.PCCSDiscoveryAgent_PCCS_Version_Error;
			
			try {
				location = new URL(Activator.getLoadErrorURL());
			} catch (MalformedURLException e) {
			}
		} else {
			if (ce.getStatus().getCode() == PCCSConnection.PCCS_NOT_FOUND)
				msg = Messages.PCCSDiscoveryAgent_PCSuite_Not_Found_Error;
			else
				msg = Messages.PCCSDiscoveryAgent_PCSuite_Version_Error;
			
			try {
				location = new URL(Activator.getLoadErrorURL());
			} catch (MalformedURLException e) {
			}
		}
		loadStatus = new PCCSPrequisiteStatus(false, msg, location);
	}

	/*
	 * (non-Javadoc)
	 * @see com.nokia.carbide.remoteconnections.internal.IDeviceDiscoveryAgent#stop()
	 */
	public void stop() throws CoreException {
		pccsConnection.removeEventListener(this);
		pccsConnection.close();
	}

	/**
	 * Creates a new PCCS USB connection
	 * @param deviceInfo - device information of the PCCS USB connection
	 */
	protected void createConnection(DeviceInfo deviceInfo, DeviceConnectionInfo connectionInfo) {
		if (connections.get(deviceInfo) == null) {
			// TODO: currently only handles USB
			if (connectionInfo.media.equals("usb")) { //$NON-NLS-1$
				IConnectionType connectionType = 
					RemoteConnectionsActivator.getConnectionTypeProvider().getConnectionType(USB_CONNECTION_TYPE);
				if (connectionType != null) {
					IConnectionFactory factory = connectionType.getConnectionFactory();
					Map<String, String> settings = factory.getSettingsFromUI();
					settings.put(PORT_SETTING, connectionInfo.comPort);
					IConnection connection = factory.createConnection(settings);
					if (connection instanceof IConnection2) {
						IConnection2 connection2 = (IConnection2) connection;
						connection2.setIdentifier(createUniqueId(deviceInfo));
						connection2.setDisplayName(deviceInfo.friendlyName);
						connection2.setDynamic(true);
						String key = getKey(deviceInfo, connectionInfo);
						connections.put(key, connection2);
						manager.addConnection(connection2);
					}
					else {
						RemoteConnectionsActivator.log("Could not create dynamic serial connection", null);
					}
				}
				else {
					RemoteConnectionsActivator.log("USB connection type extension not found", null);
				}
			}
		}
	}

	private String createUniqueId(DeviceInfo deviceInfo) {
		return getClass().getSimpleName() + ": " + deviceInfo.friendlyName; //$NON-NLS-1$
	}

	/**
	 * Return a string key based on the device and connection information 
	 * @param deviceInfo - device information
	 * @param connectionInfo - device connection information
	 * @return
	 */
	protected String getKey(DeviceInfo deviceInfo, DeviceConnectionInfo connectionInfo) {
		String key = deviceInfo.friendlyName + deviceInfo.serialNumber + connectionInfo.address;
		return key;
	}

	/**
	 * Update existing PCCS USB connections
	 * @param deviceInfoList - list of device information for current PCCS USB connections
	 */
	protected void updateConnections(DeviceInfo[] deviceInfoList) {
		disconnectAll();
 		if (deviceInfoList != null) {
			if (connections.isEmpty()) {
				// no existing connections, so create new ones
				for (DeviceInfo deviceInfo : deviceInfoList) {
					for (DeviceConnectionInfo connectionInfo : deviceInfo.connections) {
						createConnection(deviceInfo, connectionInfo);
					}
				}
			}
			else {
				for (DeviceInfo deviceInfo : deviceInfoList) {
					for (DeviceConnectionInfo connectionInfo : deviceInfo.connections) {
						String key = getKey(deviceInfo, connectionInfo);
						IConnection2 connection = connections.get(key);
						if (connection == null) {
							// no existing connection for the device found, must be new connection
							createConnection(deviceInfo, connectionInfo);
						}
						else {
							// existing connection for the device found, try to reconnect
							if (!manager.reconnect(connection)) {
								// reconnect failed, probably because the connection is not in use
								// so just create a new one
								manager.addConnection(connection);
							}
						}
					}
				}
			}
		}
	}

	private void disconnectAll() {
		for (IConnection2 connection : connections.values()) {
			manager.disconnect(connection);
		}
	}

	public String getDisplayName() {
		return Activator.getDisplayName();
	}

	public IPrerequisiteStatus getPrerequisiteStatus() {
		// Manager calls this first so we can check if we can load.
		// so let's open the discovery and close it catching any exceptions.
		try {
			pccsConnection.open();
			// successful load - close it as start() will open again
			pccsConnection.close();
		} catch (CoreException ce) {
			saveLoadStatus(ce);
		}
		
		return loadStatus;
	}
	
}