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
* Contributors:
*
* Description: 
*
*/

package com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Valuetype Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.KbdataPackage#getValuetypeType()
 * @model extendedMetaData="name='valuetype_._type'"
 * @generated
 */
public enum ValuetypeType implements Enumerator {
	/**
	 * The '<em><b>Data</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DATA_VALUE
	 * @generated
	 * @ordered
	 */
	DATA(0, "data", "data"),

	/**
	 * The '<em><b>Ref</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REF_VALUE
	 * @generated
	 * @ordered
	 */
	REF(1, "ref", "ref"),

	/**
	 * The '<em><b>Object</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OBJECT_VALUE
	 * @generated
	 * @ordered
	 */
	OBJECT(2, "object", "object"),

	/**
	 * The '<em><b>Dita Use Conref Target</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DITA_USE_CONREF_TARGET_VALUE
	 * @generated
	 * @ordered
	 */
	DITA_USE_CONREF_TARGET(3, "ditaUseConrefTarget", "-dita-use-conref-target");

	/**
	 * The '<em><b>Data</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Data</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DATA
	 * @model name="data"
	 * @generated
	 * @ordered
	 */
	public static final int DATA_VALUE = 0;

	/**
	 * The '<em><b>Ref</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Ref</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REF
	 * @model name="ref"
	 * @generated
	 * @ordered
	 */
	public static final int REF_VALUE = 1;

	/**
	 * The '<em><b>Object</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Object</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OBJECT
	 * @model name="object"
	 * @generated
	 * @ordered
	 */
	public static final int OBJECT_VALUE = 2;

	/**
	 * The '<em><b>Dita Use Conref Target</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Dita Use Conref Target</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DITA_USE_CONREF_TARGET
	 * @model name="ditaUseConrefTarget" literal="-dita-use-conref-target"
	 * @generated
	 * @ordered
	 */
	public static final int DITA_USE_CONREF_TARGET_VALUE = 3;

	/**
	 * An array of all the '<em><b>Valuetype Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ValuetypeType[] VALUES_ARRAY =
		new ValuetypeType[] {
			DATA,
			REF,
			OBJECT,
			DITA_USE_CONREF_TARGET,
		};

	/**
	 * A public read-only list of all the '<em><b>Valuetype Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ValuetypeType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Valuetype Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ValuetypeType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ValuetypeType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Valuetype Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ValuetypeType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ValuetypeType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Valuetype Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ValuetypeType get(int value) {
		switch (value) {
			case DATA_VALUE: return DATA;
			case REF_VALUE: return REF;
			case OBJECT_VALUE: return OBJECT;
			case DITA_USE_CONREF_TARGET_VALUE: return DITA_USE_CONREF_TARGET;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private ValuetypeType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //ValuetypeType
