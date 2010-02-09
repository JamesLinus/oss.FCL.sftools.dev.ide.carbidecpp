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

import java.nio.IntBuffer;
import java.nio.ShortBuffer;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.nokia.carbide.remoteconnections.discovery.pccs.Activator;
import com.nokia.carbide.remoteconnections.discovery.pccs.Messages;
import com.nokia.carbide.remoteconnections.discovery.pccs.pccsnative.CONAPI_MEDIA.ByReference;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;

public class ConnAPILibrary implements IConnAPILibrary {

	private static IConnAPILibrary Instance;
	
	/**
	 * 
	 */
	public ConnAPILibrary() {
	}

	/* (non-Javadoc)
	 * @see com.nokia.carbide.remoteconnections.discovery.pccs.pccsnative.ConnAPILibrary#getInstance()
	 */
	public static IConnAPILibrary getInstance() throws CoreException {
		if (Instance == null) 
			loadConnAPILibrary();
		return Instance;
	}

	/* (non-Javadoc)
	 * @see com.nokia.carbide.remoteconnections.discovery.pccs.pccsnative.ConnAPILibrary#loadConnAPILibrary()
	 */
	private static void loadConnAPILibrary() throws CoreException {
		try {
			Instance = (IConnAPILibrary) Native.loadLibrary("ConnAPI", IConnAPILibrary.class); //$NON-NLS-1$
		} catch (UnsatisfiedLinkError e) {
			String msg;
			if (Activator.isSymSEELayout()) {
				msg = Messages.ConnAPILibrary_PCCS_Not_Found_Error + Activator.getLoadErrorURL();
			} else {
				msg = Messages.ConnAPILibrary_PCSuite_Not_Found_Error + Activator.getLoadErrorURL();
			}
			throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, PCCSConnection.PCCS_NOT_FOUND, msg, e));
		}
	}

	// these calls are here just to satisfy the interface
	//   the real calls are marshalled through jna to the native library
	public int CFAPI_Initialize(int dwAPIVersion, IntByReference pdwParam) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int CFAPI_Terminate(IntByReference pdwParam) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int CONACloseDM(APIHANDLE mHDMHandle) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int CONAFreeDeviceStructure(int dwCount, CONAPI_DEVICE[] pDevices) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int CONAGetDeviceCount(APIHANDLE hDMHandle, IntByReference pdwCount) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int CONAGetDevices(APIHANDLE hDMHandle, IntByReference pdwCount,
			CONAPI_DEVICE[] pDevices) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int CONAOpenDM(LPAPIHANDLE mHDMHandle) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int CONARegisterNotifyCallback(APIHANDLE hDMHandle, int dwState,
			IConnAPIDeviceCallback pfnNotify) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int DMAPI_GetAPIVersion() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int DMAPI_Initialize(int dwAPIVersion, IntByReference pdwParam) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int DMAPI_Terminate(IntByReference pdwParam) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int CONACloseMM(APIHANDLE hMCHandle) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int CONAMMFreeMediaStructures(int dwCountOfMedia,
			CONAPI_MEDIA[] pMedia) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int CONAMMGetMedia(APIHANDLE hMCHandle, IntBuffer pdwCountOfMedia,
			ByReference[] ppMedia) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int CONAMMSetMedia(APIHANDLE hMCHandle, CONAPI_MEDIA[] pMedia) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int CONAOpenMM(LPAPIHANDLE phMCHandle, int dwValue) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int CONARegisterMMNotifyCallback(APIHANDLE hMCHandle, int dwState,
			IConnAPIMediaCallback pfnNotify) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int MCAPI_FreeMediaInfo(CONAPI_MEDIA_INFO[] pMediaInfo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int MCAPI_GetAPIVersion() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int MCAPI_GetMediaInfo(APIHANDLE hMCHandle, ShortBuffer pstrMediaID,
			CONAPI_MEDIA_INFO[] pMediaInfo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int MCAPI_Initialize(int dwAPIVersion, IntBuffer pdwParam) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int MCAPI_Terminate(IntBuffer pdwParam) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int UPAPI_CloseUSBPersonality(APIHANDLE hUPHandle) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int UPAPI_FreeDeviceDescriptor(int dwDeviceCount,
			UP_DEVICE_DESCRIPTOR[] pDeviceDescriptor) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int UPAPI_FreePersonalityDescriptors(
			UP_PERSONALITY_DESCRIPTORS[] pPersonalityDescriptors) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int UPAPI_FreeStringDescriptor(
			UP_STRING_DESCRIPTOR[] pStringDescriptor) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int UPAPI_GetAPIVersion() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int UPAPI_GetConfigurationDescriptor(APIHANDLE hUPHandle,
			ShortBuffer pstrDeviceId,
			UP_CONFIGURATION_DESCRIPTOR[] pConfigurationDescriptor) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int UPAPI_GetPersonalityDescriptors(APIHANDLE hUPHandle,
			ShortBuffer pstrDeviceId,
			UP_PERSONALITY_DESCRIPTORS[] pPersonalityDescriptors) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int UPAPI_GetStringDescriptor(APIHANDLE hUPHandle,
			ShortBuffer pstrDeviceId, int dwDescriptorIndex, int dwLanguageID,
			UP_STRING_DESCRIPTOR[] pStringDescriptor) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int UPAPI_Initialize(int dwAPIVersion, IntBuffer pdwParam) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int UPAPI_OpenUSBPersonality(int dwVendorId, LPAPIHANDLE phUPHandle) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int UPAPI_QueryDeviceCount(APIHANDLE hUPHandle,
			IntBuffer pdwDeviceCount) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int UPAPI_QueryDevices(APIHANDLE hUPHandle, IntBuffer pdwDeviceCount,
			UP_DEVICE_DESCRIPTOR[] pDeviceDescriptor) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int UPAPI_SendCommandToDevice(APIHANDLE hUPHandle,
			ShortBuffer pstrDeviceId, int dwDataDirection,
			UP_DATA_BUFFER[] pDataBuffer) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int UPAPI_SetPersonality(APIHANDLE hUPHandle,
			ShortBuffer pstrDeviceId, int dwPersonalityCode) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int UPAPI_Terminate(IntBuffer pdwParam) {
		// TODO Auto-generated method stub
		return 0;
	}

}