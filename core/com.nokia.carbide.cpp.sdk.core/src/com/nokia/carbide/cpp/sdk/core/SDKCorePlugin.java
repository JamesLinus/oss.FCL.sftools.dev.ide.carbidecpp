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
*/
package com.nokia.carbide.cpp.sdk.core;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

import com.nokia.carbide.cpp.internal.sdk.core.model.SDKManager;


/**
 * Main interface into the sdk.core plugin.
 * @see getSDKManager() to get the SDK information
 */
public class SDKCorePlugin extends Plugin {


	// The plug-in ID
	public static final String PLUGIN_ID = "com.nokia.carbide.cpp.sdk.core"; //$NON-NLS-1$

	// The shared instance
	private static SDKCorePlugin plugin;
	
	private static SDKManager sdkManager;
	
	/**
	 * The constructor
	 */
	public SDKCorePlugin() {
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}
	
	public static String getPluginId(){
		return PLUGIN_ID;
	}
	
	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static SDKCorePlugin getDefault() {
		return plugin;
	}
	
	/**
	 * Get the instance of the ISDKManager
	 * @return ISDKManager instance
	 */
	public static ISDKManager getSDKManager() {
		if (sdkManager == null) {
			sdkManager = new SDKManager();
		}
		return sdkManager;
	}
	
}
