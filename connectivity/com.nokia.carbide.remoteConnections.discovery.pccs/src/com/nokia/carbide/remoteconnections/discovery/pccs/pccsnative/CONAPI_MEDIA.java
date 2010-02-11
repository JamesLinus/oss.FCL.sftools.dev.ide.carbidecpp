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

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

/**
 * This file was originally autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * but then modified for Carbide.
 */
public class CONAPI_MEDIA extends Structure {
	/// Must be sizeof(CONAPI_MEDIA)
	public int dwSize;
	/// Media type
	public int dwMedia;
	/**
	 * Media name<br>
	 * C type : WCHAR*
	 */
	public com.sun.jna.ptr.ShortByReference pstrDescription;
	/// Media state. CONAPI_MEDIA_ACTIVE or CONAPI_MEDIA_NOT_ACTIVE
	public int dwState;
	/// Media options
	public int dwOptions;
	/// Media specific data
	public int dwMediaData;
	/**
	 * Media ID string<br>
	 * C type : WCHAR*
	 */
	public com.sun.jna.ptr.ShortByReference pstrID;
	public CONAPI_MEDIA() {
		super();
	}
	public CONAPI_MEDIA(Pointer p) {
		super(p);
	}
	/**
	 * @param dwSize Must be sizeof(CONAPI_MEDIA)<br>
	 * @param dwMedia Media type<br>
	 * @param pstrDescription Media name<br>
	 * C type : WCHAR*<br>
	 * @param dwState Media state. CONAPI_MEDIA_ACTIVE or CONAPI_MEDIA_NOT_ACTIVE<br>
	 * @param dwOptions Media options<br>
	 * @param dwMediaData Media specific data<br>
	 * @param pstrID Media ID string<br>
	 * C type : WCHAR*
	 */
	public CONAPI_MEDIA(int dwSize, int dwMedia, com.sun.jna.ptr.ShortByReference pstrDescription, int dwState, int dwOptions, int dwMediaData, com.sun.jna.ptr.ShortByReference pstrID) {
		super();
		this.dwSize = dwSize;
		this.dwMedia = dwMedia;
		this.pstrDescription = pstrDescription;
		this.dwState = dwState;
		this.dwOptions = dwOptions;
		this.dwMediaData = dwMediaData;
		this.pstrID = pstrID;
	}
	protected ByReference newByReference() {
		ByReference s = new ByReference();
		s.useMemory(getPointer());
		write();
		s.read();
		return s;
	}
	protected ByValue newByValue() { 
		ByValue s = new ByValue();
		s.useMemory(getPointer());
		write();
		s.read();
		return s;
	}
	protected CONAPI_MEDIA newInstance() {
		CONAPI_MEDIA s = new CONAPI_MEDIA();
		s.useMemory(getPointer());
		write();
		s.read();
		return s;
	}
	public static CONAPI_MEDIA[] newArray(int arrayLength) {
		return (CONAPI_MEDIA[]) new CONAPI_MEDIA().toArray(arrayLength);
	}
	public static class ByReference extends CONAPI_MEDIA implements com.sun.jna.Structure.ByReference {}
	public static class ByValue extends CONAPI_MEDIA implements com.sun.jna.Structure.ByValue {}

}
