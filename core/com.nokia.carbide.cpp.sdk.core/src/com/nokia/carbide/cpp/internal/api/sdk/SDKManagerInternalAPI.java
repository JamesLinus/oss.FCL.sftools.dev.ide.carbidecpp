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
package com.nokia.carbide.cpp.internal.api.sdk;

import java.util.List;

import com.nokia.carbide.cpp.internal.sdk.core.model.SDKManager;
import com.nokia.carbide.cpp.sdk.core.*;

public class SDKManagerInternalAPI {
	    
    public static ISymbianSDK addMissingSdk(String uid) {
    	return ((SDKManager)SDKCorePlugin.getSDKManager()).addMissingSdk(uid);
    }
    
    public static void removeMissingSdk(String uid) {
    	((SDKManager)SDKCorePlugin.getSDKManager()).removeMissingSdk(uid);
    }
    
    public static ISymbianSDK getMissingSdk(String uid) {
    	return ((SDKManager)SDKCorePlugin.getSDKManager()).getMissingSdk(uid);
    }
    
	public static List<ISymbianSDK> getMissingSDKList() {
		return ((SDKManager)SDKCorePlugin.getSDKManager()).getMissingSDKList();			
	}

	public static void addInstalledSdkChangeListener(ICarbideInstalledSDKChangeListener listener) {
		((SDKManager)SDKCorePlugin.getSDKManager()).addInstalledSdkChangeListener(listener);
	}
	
	public static void removeInstalledSdkChangeListener(ICarbideInstalledSDKChangeListener listener) {
		((SDKManager)SDKCorePlugin.getSDKManager()).removeInstalledSdkChangeListener(listener);
	}
	
	public static void fireInstalledSdkChanged(ICarbideInstalledSDKChangeListener.SDKChangeEventType eventType) {
		((SDKManager)SDKCorePlugin.getSDKManager()).fireInstalledSdkChanged(eventType);
	}

}
