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
*/
package com.nokia.carbide.cpp.internal.api.sdk;

/**
 * Convenience interface for extension-point clients to know when the Carbide Symbian SDK plug-in has loaded.
 */
public interface ISDKManagerLoadedHook {
	
	/**
	 * Feature to notify that SDKs are loaded the first time.
	 * For subsequent SDK scan notifications see {@link com.nokia.carbide.cdt.builder.project.ICarbideConfigurationChangedListener}
	 */
	public void symbianSDKManagerLoaded();
	
	
}
