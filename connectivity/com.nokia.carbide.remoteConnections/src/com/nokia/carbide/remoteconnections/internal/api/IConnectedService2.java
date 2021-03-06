/**
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

package com.nokia.carbide.remoteconnections.internal.api;

import java.util.Map;

import com.nokia.carbide.remoteconnections.interfaces.IConnectedService;

/**
 * An extended interface to a connected service
 * @since 2.5
 */
public interface IConnectedService2 extends IConnectedService {

	/**
	 * Set the device OS values, to potentially affect the information for the user.
	 * @param familyName
	 * @param version
	 */
	void setDeviceOS(String familyName, String version);
	
	/**
	 * Return the properties for this connected service
	 * @return Map
	 */
	Map<String, String> getProperties();
}
