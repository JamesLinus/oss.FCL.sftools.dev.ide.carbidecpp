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

/**
 *  This file was originally autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 *  but modified to work with Carbide.
 */
public class UP_PERSONALITY_DESCRIPTORS extends Structure {
	/// Size of the structure
	public int dwSize;
	/// All personality descriptor type
	public byte bDescriptorType;
	/// Personality code that is currently selected in the device
	public byte bCurrentPersonality;
	/// Number of possible personalities that the device supports
	public byte bNumOfPersonalities;
	/**
	 * Pointer to UP_PERSONALITY structures<br>
	 * C type : UP_PERSONALITY*
	 */
	public UP_PERSONALITY.ByReference pPersonalities;
	public UP_PERSONALITY_DESCRIPTORS() {
		super();
	}
	/**
	 * @param dwSize Size of the structure<br>
	 * @param bDescriptorType All personality descriptor type<br>
	 * @param bCurrentPersonality Personality code that is currently selected in the device<br>
	 * @param bNumOfPersonalities Number of possible personalities that the device supports<br>
	 * @param pPersonalities Pointer to UP_PERSONALITY structures<br>
	 * C type : UP_PERSONALITY*
	 */
	public UP_PERSONALITY_DESCRIPTORS(int dwSize, byte bDescriptorType, byte bCurrentPersonality, byte bNumOfPersonalities, UP_PERSONALITY.ByReference pPersonalities) {
		super();
		this.dwSize = dwSize;
		this.bDescriptorType = bDescriptorType;
		this.bCurrentPersonality = bCurrentPersonality;
		this.bNumOfPersonalities = bNumOfPersonalities;
		this.pPersonalities = pPersonalities;
	}
	protected ByReference newByReference() { return new ByReference(); }
	protected ByValue newByValue() { return new ByValue(); }
	protected UP_PERSONALITY_DESCRIPTORS newInstance() { return new UP_PERSONALITY_DESCRIPTORS(); }
	public static UP_PERSONALITY_DESCRIPTORS[] newArray(int arrayLength) {
		return null;
//		return com.ochafik.lang.jnaerator.runtime.Structure.newArray(UP_PERSONALITY_DESCRIPTORS.class, arrayLength);
	}
	public static class ByReference extends UP_PERSONALITY_DESCRIPTORS implements com.sun.jna.Structure.ByReference {}
	public static class ByValue extends UP_PERSONALITY_DESCRIPTORS implements com.sun.jna.Structure.ByValue {}

}
