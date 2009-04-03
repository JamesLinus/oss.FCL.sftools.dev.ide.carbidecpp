/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.nokia.sdt.emf.component.util;

import com.nokia.sdt.emf.component.ComponentPackage;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ComponentXMLProcessor extends XMLProcessor {
	/**
	 * Public constructor to instantiate the helper.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentXMLProcessor() {
		super((EPackage.Registry.INSTANCE));
		ComponentPackage.eINSTANCE.eClass();
	}
	
	/**
	 * Register for "*" and "xml" file extensions the ComponentResourceFactoryImpl factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Map getRegistrations() {
		if (registrations == null) {
			super.getRegistrations();
			registrations.put(XML_EXTENSION, new ComponentResourceFactoryImpl());
			registrations.put(STAR_EXTENSION, new ComponentResourceFactoryImpl());
		}
		return registrations;
	}

} //ComponentXMLProcessor
