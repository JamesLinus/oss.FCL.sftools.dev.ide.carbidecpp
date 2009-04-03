/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.nokia.sdt.emf.component.impl;

import com.nokia.sdt.emf.component.ComponentPackage;
import com.nokia.sdt.emf.component.ConditionalSourceGen;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conditional Source Gen</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.sdt.emf.component.impl.ConditionalSourceGenImpl#getForms <em>Forms</em>}</li>
 *   <li>{@link com.nokia.sdt.emf.component.impl.ConditionalSourceGenImpl#getIfEvents <em>If Events</em>}</li>
 *   <li>{@link com.nokia.sdt.emf.component.impl.ConditionalSourceGenImpl#getIfExpr <em>If Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ConditionalSourceGenImpl extends EObjectImpl implements ConditionalSourceGen {
	/**
	 * The default value of the '{@link #getForms() <em>Forms</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForms()
	 * @generated
	 * @ordered
	 */
	protected static final List FORMS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getForms() <em>Forms</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForms()
	 * @generated
	 * @ordered
	 */
	protected List forms = FORMS_EDEFAULT;

	/**
	 * The default value of the '{@link #getIfEvents() <em>If Events</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIfEvents()
	 * @generated
	 * @ordered
	 */
	protected static final List IF_EVENTS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIfEvents() <em>If Events</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIfEvents()
	 * @generated
	 * @ordered
	 */
	protected List ifEvents = IF_EVENTS_EDEFAULT;

	/**
	 * The default value of the '{@link #getIfExpr() <em>If Expr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIfExpr()
	 * @generated
	 * @ordered
	 */
	protected static final String IF_EXPR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIfExpr() <em>If Expr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIfExpr()
	 * @generated
	 * @ordered
	 */
	protected String ifExpr = IF_EXPR_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConditionalSourceGenImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ComponentPackage.Literals.CONDITIONAL_SOURCE_GEN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List getForms() {
		return forms;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setForms(List newForms) {
		List oldForms = forms;
		forms = newForms;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.CONDITIONAL_SOURCE_GEN__FORMS, oldForms, forms));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List getIfEvents() {
		return ifEvents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIfEvents(List newIfEvents) {
		List oldIfEvents = ifEvents;
		ifEvents = newIfEvents;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.CONDITIONAL_SOURCE_GEN__IF_EVENTS, oldIfEvents, ifEvents));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIfExpr() {
		return ifExpr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIfExpr(String newIfExpr) {
		String oldIfExpr = ifExpr;
		ifExpr = newIfExpr;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.CONDITIONAL_SOURCE_GEN__IF_EXPR, oldIfExpr, ifExpr));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComponentPackage.CONDITIONAL_SOURCE_GEN__FORMS:
				return getForms();
			case ComponentPackage.CONDITIONAL_SOURCE_GEN__IF_EVENTS:
				return getIfEvents();
			case ComponentPackage.CONDITIONAL_SOURCE_GEN__IF_EXPR:
				return getIfExpr();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ComponentPackage.CONDITIONAL_SOURCE_GEN__FORMS:
				setForms((List)newValue);
				return;
			case ComponentPackage.CONDITIONAL_SOURCE_GEN__IF_EVENTS:
				setIfEvents((List)newValue);
				return;
			case ComponentPackage.CONDITIONAL_SOURCE_GEN__IF_EXPR:
				setIfExpr((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case ComponentPackage.CONDITIONAL_SOURCE_GEN__FORMS:
				setForms(FORMS_EDEFAULT);
				return;
			case ComponentPackage.CONDITIONAL_SOURCE_GEN__IF_EVENTS:
				setIfEvents(IF_EVENTS_EDEFAULT);
				return;
			case ComponentPackage.CONDITIONAL_SOURCE_GEN__IF_EXPR:
				setIfExpr(IF_EXPR_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ComponentPackage.CONDITIONAL_SOURCE_GEN__FORMS:
				return FORMS_EDEFAULT == null ? forms != null : !FORMS_EDEFAULT.equals(forms);
			case ComponentPackage.CONDITIONAL_SOURCE_GEN__IF_EVENTS:
				return IF_EVENTS_EDEFAULT == null ? ifEvents != null : !IF_EVENTS_EDEFAULT.equals(ifEvents);
			case ComponentPackage.CONDITIONAL_SOURCE_GEN__IF_EXPR:
				return IF_EXPR_EDEFAULT == null ? ifExpr != null : !IF_EXPR_EDEFAULT.equals(ifExpr);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (forms: ");
		result.append(forms);
		result.append(", ifEvents: ");
		result.append(ifEvents);
		result.append(", ifExpr: ");
		result.append(ifExpr);
		result.append(')');
		return result.toString();
	}

} //ConditionalSourceGenImpl
