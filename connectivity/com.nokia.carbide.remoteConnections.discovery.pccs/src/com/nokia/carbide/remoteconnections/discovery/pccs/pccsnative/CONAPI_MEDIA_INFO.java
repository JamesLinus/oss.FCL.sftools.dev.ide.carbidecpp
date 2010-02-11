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
package com.nokia.carbide.remoteconnections.discovery.pccs.pccsnative;

import com.sun.jna.Structure;
import com.sun.jna.ptr.ShortByReference;

/**
 *  This file was originally autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 *  but modified to work with Carbide.
 */
public class CONAPI_MEDIA_INFO extends Structure {
	/// Must be sizeof(CONAPI_MEDIA_INFO)
	public int dwSize;
	/**
	 * Media ID<br>
	 * C type : GUID
	 */
	public GUID gMediaID;
	/// Detailed media type
	public int dwMediaType;
	/// Media state. Use media state macros to get states!
	public int dwMediaState;
	/**
	 * Media name<br>
	 * C type : WCHAR*
	 */
	public ShortByReference pstrName;
	/**
	 * Version (driver, stack, etc.), can be NULL<br>
	 * C type : WCHAR*
	 */
	public ShortByReference pstrVersion;
	/**
	 * Local address if supported, can be NULL<br>
	 * C type : WCHAR*
	 */
	public ShortByReference pstrAddress;
	/**
	 * Local HW name if supported, can be NULL<br>
	 * C type : WCHAR*
	 */
	public ShortByReference pstrHWName;
	/// For future use
	public int dwCapabilities;
	public CONAPI_MEDIA_INFO() {
		super();
	}
	/**
	 * @param dwSize Must be sizeof(CONAPI_MEDIA_INFO)<br>
	 * @param gMediaID Media ID<br>
	 * C type : GUID<br>
	 * @param dwMediaType Detailed media type<br>
	 * @param dwMediaState Media state. Use media state macros to get states!<br>
	 * @param pstrName Media name<br>
	 * C type : WCHAR*<br>
	 * @param pstrVersion Version (driver, stack, etc.), can be NULL<br>
	 * C type : WCHAR*<br>
	 * @param pstrAddress Local address if supported, can be NULL<br>
	 * C type : WCHAR*<br>
	 * @param pstrHWName Local HW name if supported, can be NULL<br>
	 * C type : WCHAR*<br>
	 * @param dwCapabilities For future use
	 */
	public CONAPI_MEDIA_INFO(int dwSize, GUID gMediaID, int dwMediaType, int dwMediaState, ShortByReference pstrName, ShortByReference pstrVersion, ShortByReference pstrAddress, ShortByReference pstrHWName, int dwCapabilities) {
		super();
		this.dwSize = dwSize;
		this.gMediaID = gMediaID;
		this.dwMediaType = dwMediaType;
		this.dwMediaState = dwMediaState;
		this.pstrName = pstrName;
		this.pstrVersion = pstrVersion;
		this.pstrAddress = pstrAddress;
		this.pstrHWName = pstrHWName;
		this.dwCapabilities = dwCapabilities;
	}
	protected ByReference newByReference() { return new ByReference(); }
	protected ByValue newByValue() { return new ByValue(); }
	protected CONAPI_MEDIA_INFO newInstance() { return new CONAPI_MEDIA_INFO(); }
	public static CONAPI_MEDIA_INFO[] newArray(int arrayLength) {
		return null;
//		return com.ochafik.lang.jnaerator.runtime.Structure.newArray(CONAPI_MEDIA_INFO.class, arrayLength);
	}
	public static class ByReference extends CONAPI_MEDIA_INFO implements com.sun.jna.Structure.ByReference {}
	public static class ByValue extends CONAPI_MEDIA_INFO implements com.sun.jna.Structure.ByValue {}
}
