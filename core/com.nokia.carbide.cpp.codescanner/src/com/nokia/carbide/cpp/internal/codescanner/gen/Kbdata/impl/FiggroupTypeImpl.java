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

package com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.impl;

import com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.ApinameType;
import com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.BType;
import com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.CmdnameType;
import com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.CodephType;
import com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.DirType51;
import com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.FiggroupType;
import com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.FilepathType;
import com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.FnType;
import com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.IType;
import com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.ImportanceType50;
import com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.KbdataPackage;
import com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.KeywordType;
import com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.MenucascadeType;
import com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.MsgnumType;
import com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.MsgphType;
import com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.OptionType;
import com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.ParmnameType;
import com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.PhType;
import com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.StatusType27;
import com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.SubType;
import com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.SupType;
import com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.SynphType;
import com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.SystemoutputType;
import com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.TitleType;
import com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.TranslateType87;
import com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.TtType;
import com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.UType;
import com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.UicontrolType;
import com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.UserinputType;
import com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.VarnameType;
import com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.WintitleType;
import com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.XrefType;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Figgroup Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.impl.FiggroupTypeImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.impl.FiggroupTypeImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.impl.FiggroupTypeImpl#getFiggroup <em>Figgroup</em>}</li>
 *   <li>{@link com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.impl.FiggroupTypeImpl#getXref <em>Xref</em>}</li>
 *   <li>{@link com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.impl.FiggroupTypeImpl#getFn <em>Fn</em>}</li>
 *   <li>{@link com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.impl.FiggroupTypeImpl#getPh <em>Ph</em>}</li>
 *   <li>{@link com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.impl.FiggroupTypeImpl#getUicontrol <em>Uicontrol</em>}</li>
 *   <li>{@link com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.impl.FiggroupTypeImpl#getMenucascade <em>Menucascade</em>}</li>
 *   <li>{@link com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.impl.FiggroupTypeImpl#getB <em>B</em>}</li>
 *   <li>{@link com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.impl.FiggroupTypeImpl#getU <em>U</em>}</li>
 *   <li>{@link com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.impl.FiggroupTypeImpl#getI <em>I</em>}</li>
 *   <li>{@link com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.impl.FiggroupTypeImpl#getTt <em>Tt</em>}</li>
 *   <li>{@link com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.impl.FiggroupTypeImpl#getSup <em>Sup</em>}</li>
 *   <li>{@link com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.impl.FiggroupTypeImpl#getSub <em>Sub</em>}</li>
 *   <li>{@link com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.impl.FiggroupTypeImpl#getCodeph <em>Codeph</em>}</li>
 *   <li>{@link com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.impl.FiggroupTypeImpl#getSynph <em>Synph</em>}</li>
 *   <li>{@link com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.impl.FiggroupTypeImpl#getFilepath <em>Filepath</em>}</li>
 *   <li>{@link com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.impl.FiggroupTypeImpl#getMsgph <em>Msgph</em>}</li>
 *   <li>{@link com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.impl.FiggroupTypeImpl#getUserinput <em>Userinput</em>}</li>
 *   <li>{@link com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.impl.FiggroupTypeImpl#getSystemoutput <em>Systemoutput</em>}</li>
 *   <li>{@link com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.impl.FiggroupTypeImpl#getKeyword <em>Keyword</em>}</li>
 *   <li>{@link com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.impl.FiggroupTypeImpl#getWintitle <em>Wintitle</em>}</li>
 *   <li>{@link com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.impl.FiggroupTypeImpl#getOption <em>Option</em>}</li>
 *   <li>{@link com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.impl.FiggroupTypeImpl#getParmname <em>Parmname</em>}</li>
 *   <li>{@link com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.impl.FiggroupTypeImpl#getApiname <em>Apiname</em>}</li>
 *   <li>{@link com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.impl.FiggroupTypeImpl#getCmdname <em>Cmdname</em>}</li>
 *   <li>{@link com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.impl.FiggroupTypeImpl#getMsgnum <em>Msgnum</em>}</li>
 *   <li>{@link com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.impl.FiggroupTypeImpl#getVarname <em>Varname</em>}</li>
 *   <li>{@link com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.impl.FiggroupTypeImpl#getAudience <em>Audience</em>}</li>
 *   <li>{@link com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.impl.FiggroupTypeImpl#getBase <em>Base</em>}</li>
 *   <li>{@link com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.impl.FiggroupTypeImpl#getClass_ <em>Class</em>}</li>
 *   <li>{@link com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.impl.FiggroupTypeImpl#getConref <em>Conref</em>}</li>
 *   <li>{@link com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.impl.FiggroupTypeImpl#getDir <em>Dir</em>}</li>
 *   <li>{@link com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.impl.FiggroupTypeImpl#getId <em>Id</em>}</li>
 *   <li>{@link com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.impl.FiggroupTypeImpl#getImportance <em>Importance</em>}</li>
 *   <li>{@link com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.impl.FiggroupTypeImpl#getLang <em>Lang</em>}</li>
 *   <li>{@link com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.impl.FiggroupTypeImpl#getOtherprops <em>Otherprops</em>}</li>
 *   <li>{@link com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.impl.FiggroupTypeImpl#getOutputclass <em>Outputclass</em>}</li>
 *   <li>{@link com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.impl.FiggroupTypeImpl#getPlatform <em>Platform</em>}</li>
 *   <li>{@link com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.impl.FiggroupTypeImpl#getProduct <em>Product</em>}</li>
 *   <li>{@link com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.impl.FiggroupTypeImpl#getProps <em>Props</em>}</li>
 *   <li>{@link com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.impl.FiggroupTypeImpl#getRev <em>Rev</em>}</li>
 *   <li>{@link com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.impl.FiggroupTypeImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.impl.FiggroupTypeImpl#getTranslate <em>Translate</em>}</li>
 *   <li>{@link com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.impl.FiggroupTypeImpl#getXtrc <em>Xtrc</em>}</li>
 *   <li>{@link com.nokia.carbide.cpp.internal.codescanner.gen.Kbdata.impl.FiggroupTypeImpl#getXtrf <em>Xtrf</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FiggroupTypeImpl extends EObjectImpl implements FiggroupType {
	/**
	 * The cached value of the '{@link #getTitle() <em>Title</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected TitleType title;

	/**
	 * The cached value of the '{@link #getGroup() <em>Group</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroup()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap group;

	/**
	 * The default value of the '{@link #getAudience() <em>Audience</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAudience()
	 * @generated
	 * @ordered
	 */
	protected static final Object AUDIENCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAudience() <em>Audience</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAudience()
	 * @generated
	 * @ordered
	 */
	protected Object audience = AUDIENCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getBase() <em>Base</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase()
	 * @generated
	 * @ordered
	 */
	protected static final Object BASE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBase() <em>Base</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase()
	 * @generated
	 * @ordered
	 */
	protected Object base = BASE_EDEFAULT;

	/**
	 * The default value of the '{@link #getClass_() <em>Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClass_()
	 * @generated
	 * @ordered
	 */
	protected static final Object CLASS_EDEFAULT = "- topic/figgroup ";

	/**
	 * The cached value of the '{@link #getClass_() <em>Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClass_()
	 * @generated
	 * @ordered
	 */
	protected Object class_ = CLASS_EDEFAULT;

	/**
	 * This is true if the Class attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean classESet;

	/**
	 * The default value of the '{@link #getConref() <em>Conref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConref()
	 * @generated
	 * @ordered
	 */
	protected static final Object CONREF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConref() <em>Conref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConref()
	 * @generated
	 * @ordered
	 */
	protected Object conref = CONREF_EDEFAULT;

	/**
	 * The default value of the '{@link #getDir() <em>Dir</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDir()
	 * @generated
	 * @ordered
	 */
	protected static final DirType51 DIR_EDEFAULT = DirType51.LTR;

	/**
	 * The cached value of the '{@link #getDir() <em>Dir</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDir()
	 * @generated
	 * @ordered
	 */
	protected DirType51 dir = DIR_EDEFAULT;

	/**
	 * This is true if the Dir attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean dirESet;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getImportance() <em>Importance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImportance()
	 * @generated
	 * @ordered
	 */
	protected static final ImportanceType50 IMPORTANCE_EDEFAULT = ImportanceType50.OBSOLETE;

	/**
	 * The cached value of the '{@link #getImportance() <em>Importance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImportance()
	 * @generated
	 * @ordered
	 */
	protected ImportanceType50 importance = IMPORTANCE_EDEFAULT;

	/**
	 * This is true if the Importance attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean importanceESet;

	/**
	 * The default value of the '{@link #getLang() <em>Lang</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLang()
	 * @generated
	 * @ordered
	 */
	protected static final String LANG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLang() <em>Lang</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLang()
	 * @generated
	 * @ordered
	 */
	protected String lang = LANG_EDEFAULT;

	/**
	 * The default value of the '{@link #getOtherprops() <em>Otherprops</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOtherprops()
	 * @generated
	 * @ordered
	 */
	protected static final Object OTHERPROPS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOtherprops() <em>Otherprops</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOtherprops()
	 * @generated
	 * @ordered
	 */
	protected Object otherprops = OTHERPROPS_EDEFAULT;

	/**
	 * The default value of the '{@link #getOutputclass() <em>Outputclass</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputclass()
	 * @generated
	 * @ordered
	 */
	protected static final Object OUTPUTCLASS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOutputclass() <em>Outputclass</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputclass()
	 * @generated
	 * @ordered
	 */
	protected Object outputclass = OUTPUTCLASS_EDEFAULT;

	/**
	 * The default value of the '{@link #getPlatform() <em>Platform</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlatform()
	 * @generated
	 * @ordered
	 */
	protected static final Object PLATFORM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPlatform() <em>Platform</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlatform()
	 * @generated
	 * @ordered
	 */
	protected Object platform = PLATFORM_EDEFAULT;

	/**
	 * The default value of the '{@link #getProduct() <em>Product</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProduct()
	 * @generated
	 * @ordered
	 */
	protected static final Object PRODUCT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProduct() <em>Product</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProduct()
	 * @generated
	 * @ordered
	 */
	protected Object product = PRODUCT_EDEFAULT;

	/**
	 * The default value of the '{@link #getProps() <em>Props</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProps()
	 * @generated
	 * @ordered
	 */
	protected static final Object PROPS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProps() <em>Props</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProps()
	 * @generated
	 * @ordered
	 */
	protected Object props = PROPS_EDEFAULT;

	/**
	 * The default value of the '{@link #getRev() <em>Rev</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRev()
	 * @generated
	 * @ordered
	 */
	protected static final Object REV_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRev() <em>Rev</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRev()
	 * @generated
	 * @ordered
	 */
	protected Object rev = REV_EDEFAULT;

	/**
	 * The default value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected static final StatusType27 STATUS_EDEFAULT = StatusType27.NEW;

	/**
	 * The cached value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected StatusType27 status = STATUS_EDEFAULT;

	/**
	 * This is true if the Status attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean statusESet;

	/**
	 * The default value of the '{@link #getTranslate() <em>Translate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTranslate()
	 * @generated
	 * @ordered
	 */
	protected static final TranslateType87 TRANSLATE_EDEFAULT = TranslateType87.YES;

	/**
	 * The cached value of the '{@link #getTranslate() <em>Translate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTranslate()
	 * @generated
	 * @ordered
	 */
	protected TranslateType87 translate = TRANSLATE_EDEFAULT;

	/**
	 * This is true if the Translate attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean translateESet;

	/**
	 * The default value of the '{@link #getXtrc() <em>Xtrc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXtrc()
	 * @generated
	 * @ordered
	 */
	protected static final Object XTRC_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getXtrc() <em>Xtrc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXtrc()
	 * @generated
	 * @ordered
	 */
	protected Object xtrc = XTRC_EDEFAULT;

	/**
	 * The default value of the '{@link #getXtrf() <em>Xtrf</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXtrf()
	 * @generated
	 * @ordered
	 */
	protected static final Object XTRF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getXtrf() <em>Xtrf</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXtrf()
	 * @generated
	 * @ordered
	 */
	protected Object xtrf = XTRF_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FiggroupTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KbdataPackage.eINSTANCE.getFiggroupType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TitleType getTitle() {
		return title;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTitle(TitleType newTitle, NotificationChain msgs) {
		TitleType oldTitle = title;
		title = newTitle;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KbdataPackage.FIGGROUP_TYPE__TITLE, oldTitle, newTitle);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTitle(TitleType newTitle) {
		if (newTitle != title) {
			NotificationChain msgs = null;
			if (title != null)
				msgs = ((InternalEObject)title).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - KbdataPackage.FIGGROUP_TYPE__TITLE, null, msgs);
			if (newTitle != null)
				msgs = ((InternalEObject)newTitle).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - KbdataPackage.FIGGROUP_TYPE__TITLE, null, msgs);
			msgs = basicSetTitle(newTitle, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbdataPackage.FIGGROUP_TYPE__TITLE, newTitle, newTitle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getGroup() {
		if (group == null) {
			group = new BasicFeatureMap(this, KbdataPackage.FIGGROUP_TYPE__GROUP);
		}
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FiggroupType> getFiggroup() {
		return getGroup().list(KbdataPackage.eINSTANCE.getFiggroupType_Figgroup());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<XrefType> getXref() {
		return getGroup().list(KbdataPackage.eINSTANCE.getFiggroupType_Xref());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FnType> getFn() {
		return getGroup().list(KbdataPackage.eINSTANCE.getFiggroupType_Fn());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PhType> getPh() {
		return getGroup().list(KbdataPackage.eINSTANCE.getFiggroupType_Ph());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UicontrolType> getUicontrol() {
		return getGroup().list(KbdataPackage.eINSTANCE.getFiggroupType_Uicontrol());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MenucascadeType> getMenucascade() {
		return getGroup().list(KbdataPackage.eINSTANCE.getFiggroupType_Menucascade());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BType> getB() {
		return getGroup().list(KbdataPackage.eINSTANCE.getFiggroupType_B());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UType> getU() {
		return getGroup().list(KbdataPackage.eINSTANCE.getFiggroupType_U());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IType> getI() {
		return getGroup().list(KbdataPackage.eINSTANCE.getFiggroupType_I());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TtType> getTt() {
		return getGroup().list(KbdataPackage.eINSTANCE.getFiggroupType_Tt());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SupType> getSup() {
		return getGroup().list(KbdataPackage.eINSTANCE.getFiggroupType_Sup());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SubType> getSub() {
		return getGroup().list(KbdataPackage.eINSTANCE.getFiggroupType_Sub());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CodephType> getCodeph() {
		return getGroup().list(KbdataPackage.eINSTANCE.getFiggroupType_Codeph());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SynphType> getSynph() {
		return getGroup().list(KbdataPackage.eINSTANCE.getFiggroupType_Synph());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FilepathType> getFilepath() {
		return getGroup().list(KbdataPackage.eINSTANCE.getFiggroupType_Filepath());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MsgphType> getMsgph() {
		return getGroup().list(KbdataPackage.eINSTANCE.getFiggroupType_Msgph());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UserinputType> getUserinput() {
		return getGroup().list(KbdataPackage.eINSTANCE.getFiggroupType_Userinput());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SystemoutputType> getSystemoutput() {
		return getGroup().list(KbdataPackage.eINSTANCE.getFiggroupType_Systemoutput());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<KeywordType> getKeyword() {
		return getGroup().list(KbdataPackage.eINSTANCE.getFiggroupType_Keyword());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<WintitleType> getWintitle() {
		return getGroup().list(KbdataPackage.eINSTANCE.getFiggroupType_Wintitle());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OptionType> getOption() {
		return getGroup().list(KbdataPackage.eINSTANCE.getFiggroupType_Option());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParmnameType> getParmname() {
		return getGroup().list(KbdataPackage.eINSTANCE.getFiggroupType_Parmname());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ApinameType> getApiname() {
		return getGroup().list(KbdataPackage.eINSTANCE.getFiggroupType_Apiname());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CmdnameType> getCmdname() {
		return getGroup().list(KbdataPackage.eINSTANCE.getFiggroupType_Cmdname());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MsgnumType> getMsgnum() {
		return getGroup().list(KbdataPackage.eINSTANCE.getFiggroupType_Msgnum());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VarnameType> getVarname() {
		return getGroup().list(KbdataPackage.eINSTANCE.getFiggroupType_Varname());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getAudience() {
		return audience;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAudience(Object newAudience) {
		Object oldAudience = audience;
		audience = newAudience;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbdataPackage.FIGGROUP_TYPE__AUDIENCE, oldAudience, audience));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getBase() {
		return base;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase(Object newBase) {
		Object oldBase = base;
		base = newBase;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbdataPackage.FIGGROUP_TYPE__BASE, oldBase, base));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getClass_() {
		return class_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClass(Object newClass) {
		Object oldClass = class_;
		class_ = newClass;
		boolean oldClassESet = classESet;
		classESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbdataPackage.FIGGROUP_TYPE__CLASS, oldClass, class_, !oldClassESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetClass() {
		Object oldClass = class_;
		boolean oldClassESet = classESet;
		class_ = CLASS_EDEFAULT;
		classESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, KbdataPackage.FIGGROUP_TYPE__CLASS, oldClass, CLASS_EDEFAULT, oldClassESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetClass() {
		return classESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getConref() {
		return conref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConref(Object newConref) {
		Object oldConref = conref;
		conref = newConref;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbdataPackage.FIGGROUP_TYPE__CONREF, oldConref, conref));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DirType51 getDir() {
		return dir;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDir(DirType51 newDir) {
		DirType51 oldDir = dir;
		dir = newDir == null ? DIR_EDEFAULT : newDir;
		boolean oldDirESet = dirESet;
		dirESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbdataPackage.FIGGROUP_TYPE__DIR, oldDir, dir, !oldDirESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDir() {
		DirType51 oldDir = dir;
		boolean oldDirESet = dirESet;
		dir = DIR_EDEFAULT;
		dirESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, KbdataPackage.FIGGROUP_TYPE__DIR, oldDir, DIR_EDEFAULT, oldDirESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDir() {
		return dirESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbdataPackage.FIGGROUP_TYPE__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImportanceType50 getImportance() {
		return importance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImportance(ImportanceType50 newImportance) {
		ImportanceType50 oldImportance = importance;
		importance = newImportance == null ? IMPORTANCE_EDEFAULT : newImportance;
		boolean oldImportanceESet = importanceESet;
		importanceESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbdataPackage.FIGGROUP_TYPE__IMPORTANCE, oldImportance, importance, !oldImportanceESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetImportance() {
		ImportanceType50 oldImportance = importance;
		boolean oldImportanceESet = importanceESet;
		importance = IMPORTANCE_EDEFAULT;
		importanceESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, KbdataPackage.FIGGROUP_TYPE__IMPORTANCE, oldImportance, IMPORTANCE_EDEFAULT, oldImportanceESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetImportance() {
		return importanceESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLang() {
		return lang;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLang(String newLang) {
		String oldLang = lang;
		lang = newLang;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbdataPackage.FIGGROUP_TYPE__LANG, oldLang, lang));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getOtherprops() {
		return otherprops;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOtherprops(Object newOtherprops) {
		Object oldOtherprops = otherprops;
		otherprops = newOtherprops;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbdataPackage.FIGGROUP_TYPE__OTHERPROPS, oldOtherprops, otherprops));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getOutputclass() {
		return outputclass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputclass(Object newOutputclass) {
		Object oldOutputclass = outputclass;
		outputclass = newOutputclass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbdataPackage.FIGGROUP_TYPE__OUTPUTCLASS, oldOutputclass, outputclass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getPlatform() {
		return platform;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlatform(Object newPlatform) {
		Object oldPlatform = platform;
		platform = newPlatform;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbdataPackage.FIGGROUP_TYPE__PLATFORM, oldPlatform, platform));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getProduct() {
		return product;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProduct(Object newProduct) {
		Object oldProduct = product;
		product = newProduct;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbdataPackage.FIGGROUP_TYPE__PRODUCT, oldProduct, product));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getProps() {
		return props;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProps(Object newProps) {
		Object oldProps = props;
		props = newProps;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbdataPackage.FIGGROUP_TYPE__PROPS, oldProps, props));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getRev() {
		return rev;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRev(Object newRev) {
		Object oldRev = rev;
		rev = newRev;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbdataPackage.FIGGROUP_TYPE__REV, oldRev, rev));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatusType27 getStatus() {
		return status;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatus(StatusType27 newStatus) {
		StatusType27 oldStatus = status;
		status = newStatus == null ? STATUS_EDEFAULT : newStatus;
		boolean oldStatusESet = statusESet;
		statusESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbdataPackage.FIGGROUP_TYPE__STATUS, oldStatus, status, !oldStatusESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetStatus() {
		StatusType27 oldStatus = status;
		boolean oldStatusESet = statusESet;
		status = STATUS_EDEFAULT;
		statusESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, KbdataPackage.FIGGROUP_TYPE__STATUS, oldStatus, STATUS_EDEFAULT, oldStatusESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetStatus() {
		return statusESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TranslateType87 getTranslate() {
		return translate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTranslate(TranslateType87 newTranslate) {
		TranslateType87 oldTranslate = translate;
		translate = newTranslate == null ? TRANSLATE_EDEFAULT : newTranslate;
		boolean oldTranslateESet = translateESet;
		translateESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbdataPackage.FIGGROUP_TYPE__TRANSLATE, oldTranslate, translate, !oldTranslateESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTranslate() {
		TranslateType87 oldTranslate = translate;
		boolean oldTranslateESet = translateESet;
		translate = TRANSLATE_EDEFAULT;
		translateESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, KbdataPackage.FIGGROUP_TYPE__TRANSLATE, oldTranslate, TRANSLATE_EDEFAULT, oldTranslateESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTranslate() {
		return translateESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getXtrc() {
		return xtrc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXtrc(Object newXtrc) {
		Object oldXtrc = xtrc;
		xtrc = newXtrc;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbdataPackage.FIGGROUP_TYPE__XTRC, oldXtrc, xtrc));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getXtrf() {
		return xtrf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXtrf(Object newXtrf) {
		Object oldXtrf = xtrf;
		xtrf = newXtrf;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbdataPackage.FIGGROUP_TYPE__XTRF, oldXtrf, xtrf));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case KbdataPackage.FIGGROUP_TYPE__TITLE:
				return basicSetTitle(null, msgs);
			case KbdataPackage.FIGGROUP_TYPE__GROUP:
				return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
			case KbdataPackage.FIGGROUP_TYPE__FIGGROUP:
				return ((InternalEList<?>)getFiggroup()).basicRemove(otherEnd, msgs);
			case KbdataPackage.FIGGROUP_TYPE__XREF:
				return ((InternalEList<?>)getXref()).basicRemove(otherEnd, msgs);
			case KbdataPackage.FIGGROUP_TYPE__FN:
				return ((InternalEList<?>)getFn()).basicRemove(otherEnd, msgs);
			case KbdataPackage.FIGGROUP_TYPE__PH:
				return ((InternalEList<?>)getPh()).basicRemove(otherEnd, msgs);
			case KbdataPackage.FIGGROUP_TYPE__UICONTROL:
				return ((InternalEList<?>)getUicontrol()).basicRemove(otherEnd, msgs);
			case KbdataPackage.FIGGROUP_TYPE__MENUCASCADE:
				return ((InternalEList<?>)getMenucascade()).basicRemove(otherEnd, msgs);
			case KbdataPackage.FIGGROUP_TYPE__B:
				return ((InternalEList<?>)getB()).basicRemove(otherEnd, msgs);
			case KbdataPackage.FIGGROUP_TYPE__U:
				return ((InternalEList<?>)getU()).basicRemove(otherEnd, msgs);
			case KbdataPackage.FIGGROUP_TYPE__I:
				return ((InternalEList<?>)getI()).basicRemove(otherEnd, msgs);
			case KbdataPackage.FIGGROUP_TYPE__TT:
				return ((InternalEList<?>)getTt()).basicRemove(otherEnd, msgs);
			case KbdataPackage.FIGGROUP_TYPE__SUP:
				return ((InternalEList<?>)getSup()).basicRemove(otherEnd, msgs);
			case KbdataPackage.FIGGROUP_TYPE__SUB:
				return ((InternalEList<?>)getSub()).basicRemove(otherEnd, msgs);
			case KbdataPackage.FIGGROUP_TYPE__CODEPH:
				return ((InternalEList<?>)getCodeph()).basicRemove(otherEnd, msgs);
			case KbdataPackage.FIGGROUP_TYPE__SYNPH:
				return ((InternalEList<?>)getSynph()).basicRemove(otherEnd, msgs);
			case KbdataPackage.FIGGROUP_TYPE__FILEPATH:
				return ((InternalEList<?>)getFilepath()).basicRemove(otherEnd, msgs);
			case KbdataPackage.FIGGROUP_TYPE__MSGPH:
				return ((InternalEList<?>)getMsgph()).basicRemove(otherEnd, msgs);
			case KbdataPackage.FIGGROUP_TYPE__USERINPUT:
				return ((InternalEList<?>)getUserinput()).basicRemove(otherEnd, msgs);
			case KbdataPackage.FIGGROUP_TYPE__SYSTEMOUTPUT:
				return ((InternalEList<?>)getSystemoutput()).basicRemove(otherEnd, msgs);
			case KbdataPackage.FIGGROUP_TYPE__KEYWORD:
				return ((InternalEList<?>)getKeyword()).basicRemove(otherEnd, msgs);
			case KbdataPackage.FIGGROUP_TYPE__WINTITLE:
				return ((InternalEList<?>)getWintitle()).basicRemove(otherEnd, msgs);
			case KbdataPackage.FIGGROUP_TYPE__OPTION:
				return ((InternalEList<?>)getOption()).basicRemove(otherEnd, msgs);
			case KbdataPackage.FIGGROUP_TYPE__PARMNAME:
				return ((InternalEList<?>)getParmname()).basicRemove(otherEnd, msgs);
			case KbdataPackage.FIGGROUP_TYPE__APINAME:
				return ((InternalEList<?>)getApiname()).basicRemove(otherEnd, msgs);
			case KbdataPackage.FIGGROUP_TYPE__CMDNAME:
				return ((InternalEList<?>)getCmdname()).basicRemove(otherEnd, msgs);
			case KbdataPackage.FIGGROUP_TYPE__MSGNUM:
				return ((InternalEList<?>)getMsgnum()).basicRemove(otherEnd, msgs);
			case KbdataPackage.FIGGROUP_TYPE__VARNAME:
				return ((InternalEList<?>)getVarname()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case KbdataPackage.FIGGROUP_TYPE__TITLE:
				return getTitle();
			case KbdataPackage.FIGGROUP_TYPE__GROUP:
				if (coreType) return getGroup();
				return ((FeatureMap.Internal)getGroup()).getWrapper();
			case KbdataPackage.FIGGROUP_TYPE__FIGGROUP:
				return getFiggroup();
			case KbdataPackage.FIGGROUP_TYPE__XREF:
				return getXref();
			case KbdataPackage.FIGGROUP_TYPE__FN:
				return getFn();
			case KbdataPackage.FIGGROUP_TYPE__PH:
				return getPh();
			case KbdataPackage.FIGGROUP_TYPE__UICONTROL:
				return getUicontrol();
			case KbdataPackage.FIGGROUP_TYPE__MENUCASCADE:
				return getMenucascade();
			case KbdataPackage.FIGGROUP_TYPE__B:
				return getB();
			case KbdataPackage.FIGGROUP_TYPE__U:
				return getU();
			case KbdataPackage.FIGGROUP_TYPE__I:
				return getI();
			case KbdataPackage.FIGGROUP_TYPE__TT:
				return getTt();
			case KbdataPackage.FIGGROUP_TYPE__SUP:
				return getSup();
			case KbdataPackage.FIGGROUP_TYPE__SUB:
				return getSub();
			case KbdataPackage.FIGGROUP_TYPE__CODEPH:
				return getCodeph();
			case KbdataPackage.FIGGROUP_TYPE__SYNPH:
				return getSynph();
			case KbdataPackage.FIGGROUP_TYPE__FILEPATH:
				return getFilepath();
			case KbdataPackage.FIGGROUP_TYPE__MSGPH:
				return getMsgph();
			case KbdataPackage.FIGGROUP_TYPE__USERINPUT:
				return getUserinput();
			case KbdataPackage.FIGGROUP_TYPE__SYSTEMOUTPUT:
				return getSystemoutput();
			case KbdataPackage.FIGGROUP_TYPE__KEYWORD:
				return getKeyword();
			case KbdataPackage.FIGGROUP_TYPE__WINTITLE:
				return getWintitle();
			case KbdataPackage.FIGGROUP_TYPE__OPTION:
				return getOption();
			case KbdataPackage.FIGGROUP_TYPE__PARMNAME:
				return getParmname();
			case KbdataPackage.FIGGROUP_TYPE__APINAME:
				return getApiname();
			case KbdataPackage.FIGGROUP_TYPE__CMDNAME:
				return getCmdname();
			case KbdataPackage.FIGGROUP_TYPE__MSGNUM:
				return getMsgnum();
			case KbdataPackage.FIGGROUP_TYPE__VARNAME:
				return getVarname();
			case KbdataPackage.FIGGROUP_TYPE__AUDIENCE:
				return getAudience();
			case KbdataPackage.FIGGROUP_TYPE__BASE:
				return getBase();
			case KbdataPackage.FIGGROUP_TYPE__CLASS:
				return getClass_();
			case KbdataPackage.FIGGROUP_TYPE__CONREF:
				return getConref();
			case KbdataPackage.FIGGROUP_TYPE__DIR:
				return getDir();
			case KbdataPackage.FIGGROUP_TYPE__ID:
				return getId();
			case KbdataPackage.FIGGROUP_TYPE__IMPORTANCE:
				return getImportance();
			case KbdataPackage.FIGGROUP_TYPE__LANG:
				return getLang();
			case KbdataPackage.FIGGROUP_TYPE__OTHERPROPS:
				return getOtherprops();
			case KbdataPackage.FIGGROUP_TYPE__OUTPUTCLASS:
				return getOutputclass();
			case KbdataPackage.FIGGROUP_TYPE__PLATFORM:
				return getPlatform();
			case KbdataPackage.FIGGROUP_TYPE__PRODUCT:
				return getProduct();
			case KbdataPackage.FIGGROUP_TYPE__PROPS:
				return getProps();
			case KbdataPackage.FIGGROUP_TYPE__REV:
				return getRev();
			case KbdataPackage.FIGGROUP_TYPE__STATUS:
				return getStatus();
			case KbdataPackage.FIGGROUP_TYPE__TRANSLATE:
				return getTranslate();
			case KbdataPackage.FIGGROUP_TYPE__XTRC:
				return getXtrc();
			case KbdataPackage.FIGGROUP_TYPE__XTRF:
				return getXtrf();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case KbdataPackage.FIGGROUP_TYPE__TITLE:
				setTitle((TitleType)newValue);
				return;
			case KbdataPackage.FIGGROUP_TYPE__GROUP:
				((FeatureMap.Internal)getGroup()).set(newValue);
				return;
			case KbdataPackage.FIGGROUP_TYPE__FIGGROUP:
				getFiggroup().clear();
				getFiggroup().addAll((Collection<? extends FiggroupType>)newValue);
				return;
			case KbdataPackage.FIGGROUP_TYPE__XREF:
				getXref().clear();
				getXref().addAll((Collection<? extends XrefType>)newValue);
				return;
			case KbdataPackage.FIGGROUP_TYPE__FN:
				getFn().clear();
				getFn().addAll((Collection<? extends FnType>)newValue);
				return;
			case KbdataPackage.FIGGROUP_TYPE__PH:
				getPh().clear();
				getPh().addAll((Collection<? extends PhType>)newValue);
				return;
			case KbdataPackage.FIGGROUP_TYPE__UICONTROL:
				getUicontrol().clear();
				getUicontrol().addAll((Collection<? extends UicontrolType>)newValue);
				return;
			case KbdataPackage.FIGGROUP_TYPE__MENUCASCADE:
				getMenucascade().clear();
				getMenucascade().addAll((Collection<? extends MenucascadeType>)newValue);
				return;
			case KbdataPackage.FIGGROUP_TYPE__B:
				getB().clear();
				getB().addAll((Collection<? extends BType>)newValue);
				return;
			case KbdataPackage.FIGGROUP_TYPE__U:
				getU().clear();
				getU().addAll((Collection<? extends UType>)newValue);
				return;
			case KbdataPackage.FIGGROUP_TYPE__I:
				getI().clear();
				getI().addAll((Collection<? extends IType>)newValue);
				return;
			case KbdataPackage.FIGGROUP_TYPE__TT:
				getTt().clear();
				getTt().addAll((Collection<? extends TtType>)newValue);
				return;
			case KbdataPackage.FIGGROUP_TYPE__SUP:
				getSup().clear();
				getSup().addAll((Collection<? extends SupType>)newValue);
				return;
			case KbdataPackage.FIGGROUP_TYPE__SUB:
				getSub().clear();
				getSub().addAll((Collection<? extends SubType>)newValue);
				return;
			case KbdataPackage.FIGGROUP_TYPE__CODEPH:
				getCodeph().clear();
				getCodeph().addAll((Collection<? extends CodephType>)newValue);
				return;
			case KbdataPackage.FIGGROUP_TYPE__SYNPH:
				getSynph().clear();
				getSynph().addAll((Collection<? extends SynphType>)newValue);
				return;
			case KbdataPackage.FIGGROUP_TYPE__FILEPATH:
				getFilepath().clear();
				getFilepath().addAll((Collection<? extends FilepathType>)newValue);
				return;
			case KbdataPackage.FIGGROUP_TYPE__MSGPH:
				getMsgph().clear();
				getMsgph().addAll((Collection<? extends MsgphType>)newValue);
				return;
			case KbdataPackage.FIGGROUP_TYPE__USERINPUT:
				getUserinput().clear();
				getUserinput().addAll((Collection<? extends UserinputType>)newValue);
				return;
			case KbdataPackage.FIGGROUP_TYPE__SYSTEMOUTPUT:
				getSystemoutput().clear();
				getSystemoutput().addAll((Collection<? extends SystemoutputType>)newValue);
				return;
			case KbdataPackage.FIGGROUP_TYPE__KEYWORD:
				getKeyword().clear();
				getKeyword().addAll((Collection<? extends KeywordType>)newValue);
				return;
			case KbdataPackage.FIGGROUP_TYPE__WINTITLE:
				getWintitle().clear();
				getWintitle().addAll((Collection<? extends WintitleType>)newValue);
				return;
			case KbdataPackage.FIGGROUP_TYPE__OPTION:
				getOption().clear();
				getOption().addAll((Collection<? extends OptionType>)newValue);
				return;
			case KbdataPackage.FIGGROUP_TYPE__PARMNAME:
				getParmname().clear();
				getParmname().addAll((Collection<? extends ParmnameType>)newValue);
				return;
			case KbdataPackage.FIGGROUP_TYPE__APINAME:
				getApiname().clear();
				getApiname().addAll((Collection<? extends ApinameType>)newValue);
				return;
			case KbdataPackage.FIGGROUP_TYPE__CMDNAME:
				getCmdname().clear();
				getCmdname().addAll((Collection<? extends CmdnameType>)newValue);
				return;
			case KbdataPackage.FIGGROUP_TYPE__MSGNUM:
				getMsgnum().clear();
				getMsgnum().addAll((Collection<? extends MsgnumType>)newValue);
				return;
			case KbdataPackage.FIGGROUP_TYPE__VARNAME:
				getVarname().clear();
				getVarname().addAll((Collection<? extends VarnameType>)newValue);
				return;
			case KbdataPackage.FIGGROUP_TYPE__AUDIENCE:
				setAudience(newValue);
				return;
			case KbdataPackage.FIGGROUP_TYPE__BASE:
				setBase(newValue);
				return;
			case KbdataPackage.FIGGROUP_TYPE__CLASS:
				setClass(newValue);
				return;
			case KbdataPackage.FIGGROUP_TYPE__CONREF:
				setConref(newValue);
				return;
			case KbdataPackage.FIGGROUP_TYPE__DIR:
				setDir((DirType51)newValue);
				return;
			case KbdataPackage.FIGGROUP_TYPE__ID:
				setId((String)newValue);
				return;
			case KbdataPackage.FIGGROUP_TYPE__IMPORTANCE:
				setImportance((ImportanceType50)newValue);
				return;
			case KbdataPackage.FIGGROUP_TYPE__LANG:
				setLang((String)newValue);
				return;
			case KbdataPackage.FIGGROUP_TYPE__OTHERPROPS:
				setOtherprops(newValue);
				return;
			case KbdataPackage.FIGGROUP_TYPE__OUTPUTCLASS:
				setOutputclass(newValue);
				return;
			case KbdataPackage.FIGGROUP_TYPE__PLATFORM:
				setPlatform(newValue);
				return;
			case KbdataPackage.FIGGROUP_TYPE__PRODUCT:
				setProduct(newValue);
				return;
			case KbdataPackage.FIGGROUP_TYPE__PROPS:
				setProps(newValue);
				return;
			case KbdataPackage.FIGGROUP_TYPE__REV:
				setRev(newValue);
				return;
			case KbdataPackage.FIGGROUP_TYPE__STATUS:
				setStatus((StatusType27)newValue);
				return;
			case KbdataPackage.FIGGROUP_TYPE__TRANSLATE:
				setTranslate((TranslateType87)newValue);
				return;
			case KbdataPackage.FIGGROUP_TYPE__XTRC:
				setXtrc(newValue);
				return;
			case KbdataPackage.FIGGROUP_TYPE__XTRF:
				setXtrf(newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case KbdataPackage.FIGGROUP_TYPE__TITLE:
				setTitle((TitleType)null);
				return;
			case KbdataPackage.FIGGROUP_TYPE__GROUP:
				getGroup().clear();
				return;
			case KbdataPackage.FIGGROUP_TYPE__FIGGROUP:
				getFiggroup().clear();
				return;
			case KbdataPackage.FIGGROUP_TYPE__XREF:
				getXref().clear();
				return;
			case KbdataPackage.FIGGROUP_TYPE__FN:
				getFn().clear();
				return;
			case KbdataPackage.FIGGROUP_TYPE__PH:
				getPh().clear();
				return;
			case KbdataPackage.FIGGROUP_TYPE__UICONTROL:
				getUicontrol().clear();
				return;
			case KbdataPackage.FIGGROUP_TYPE__MENUCASCADE:
				getMenucascade().clear();
				return;
			case KbdataPackage.FIGGROUP_TYPE__B:
				getB().clear();
				return;
			case KbdataPackage.FIGGROUP_TYPE__U:
				getU().clear();
				return;
			case KbdataPackage.FIGGROUP_TYPE__I:
				getI().clear();
				return;
			case KbdataPackage.FIGGROUP_TYPE__TT:
				getTt().clear();
				return;
			case KbdataPackage.FIGGROUP_TYPE__SUP:
				getSup().clear();
				return;
			case KbdataPackage.FIGGROUP_TYPE__SUB:
				getSub().clear();
				return;
			case KbdataPackage.FIGGROUP_TYPE__CODEPH:
				getCodeph().clear();
				return;
			case KbdataPackage.FIGGROUP_TYPE__SYNPH:
				getSynph().clear();
				return;
			case KbdataPackage.FIGGROUP_TYPE__FILEPATH:
				getFilepath().clear();
				return;
			case KbdataPackage.FIGGROUP_TYPE__MSGPH:
				getMsgph().clear();
				return;
			case KbdataPackage.FIGGROUP_TYPE__USERINPUT:
				getUserinput().clear();
				return;
			case KbdataPackage.FIGGROUP_TYPE__SYSTEMOUTPUT:
				getSystemoutput().clear();
				return;
			case KbdataPackage.FIGGROUP_TYPE__KEYWORD:
				getKeyword().clear();
				return;
			case KbdataPackage.FIGGROUP_TYPE__WINTITLE:
				getWintitle().clear();
				return;
			case KbdataPackage.FIGGROUP_TYPE__OPTION:
				getOption().clear();
				return;
			case KbdataPackage.FIGGROUP_TYPE__PARMNAME:
				getParmname().clear();
				return;
			case KbdataPackage.FIGGROUP_TYPE__APINAME:
				getApiname().clear();
				return;
			case KbdataPackage.FIGGROUP_TYPE__CMDNAME:
				getCmdname().clear();
				return;
			case KbdataPackage.FIGGROUP_TYPE__MSGNUM:
				getMsgnum().clear();
				return;
			case KbdataPackage.FIGGROUP_TYPE__VARNAME:
				getVarname().clear();
				return;
			case KbdataPackage.FIGGROUP_TYPE__AUDIENCE:
				setAudience(AUDIENCE_EDEFAULT);
				return;
			case KbdataPackage.FIGGROUP_TYPE__BASE:
				setBase(BASE_EDEFAULT);
				return;
			case KbdataPackage.FIGGROUP_TYPE__CLASS:
				unsetClass();
				return;
			case KbdataPackage.FIGGROUP_TYPE__CONREF:
				setConref(CONREF_EDEFAULT);
				return;
			case KbdataPackage.FIGGROUP_TYPE__DIR:
				unsetDir();
				return;
			case KbdataPackage.FIGGROUP_TYPE__ID:
				setId(ID_EDEFAULT);
				return;
			case KbdataPackage.FIGGROUP_TYPE__IMPORTANCE:
				unsetImportance();
				return;
			case KbdataPackage.FIGGROUP_TYPE__LANG:
				setLang(LANG_EDEFAULT);
				return;
			case KbdataPackage.FIGGROUP_TYPE__OTHERPROPS:
				setOtherprops(OTHERPROPS_EDEFAULT);
				return;
			case KbdataPackage.FIGGROUP_TYPE__OUTPUTCLASS:
				setOutputclass(OUTPUTCLASS_EDEFAULT);
				return;
			case KbdataPackage.FIGGROUP_TYPE__PLATFORM:
				setPlatform(PLATFORM_EDEFAULT);
				return;
			case KbdataPackage.FIGGROUP_TYPE__PRODUCT:
				setProduct(PRODUCT_EDEFAULT);
				return;
			case KbdataPackage.FIGGROUP_TYPE__PROPS:
				setProps(PROPS_EDEFAULT);
				return;
			case KbdataPackage.FIGGROUP_TYPE__REV:
				setRev(REV_EDEFAULT);
				return;
			case KbdataPackage.FIGGROUP_TYPE__STATUS:
				unsetStatus();
				return;
			case KbdataPackage.FIGGROUP_TYPE__TRANSLATE:
				unsetTranslate();
				return;
			case KbdataPackage.FIGGROUP_TYPE__XTRC:
				setXtrc(XTRC_EDEFAULT);
				return;
			case KbdataPackage.FIGGROUP_TYPE__XTRF:
				setXtrf(XTRF_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case KbdataPackage.FIGGROUP_TYPE__TITLE:
				return title != null;
			case KbdataPackage.FIGGROUP_TYPE__GROUP:
				return group != null && !group.isEmpty();
			case KbdataPackage.FIGGROUP_TYPE__FIGGROUP:
				return !getFiggroup().isEmpty();
			case KbdataPackage.FIGGROUP_TYPE__XREF:
				return !getXref().isEmpty();
			case KbdataPackage.FIGGROUP_TYPE__FN:
				return !getFn().isEmpty();
			case KbdataPackage.FIGGROUP_TYPE__PH:
				return !getPh().isEmpty();
			case KbdataPackage.FIGGROUP_TYPE__UICONTROL:
				return !getUicontrol().isEmpty();
			case KbdataPackage.FIGGROUP_TYPE__MENUCASCADE:
				return !getMenucascade().isEmpty();
			case KbdataPackage.FIGGROUP_TYPE__B:
				return !getB().isEmpty();
			case KbdataPackage.FIGGROUP_TYPE__U:
				return !getU().isEmpty();
			case KbdataPackage.FIGGROUP_TYPE__I:
				return !getI().isEmpty();
			case KbdataPackage.FIGGROUP_TYPE__TT:
				return !getTt().isEmpty();
			case KbdataPackage.FIGGROUP_TYPE__SUP:
				return !getSup().isEmpty();
			case KbdataPackage.FIGGROUP_TYPE__SUB:
				return !getSub().isEmpty();
			case KbdataPackage.FIGGROUP_TYPE__CODEPH:
				return !getCodeph().isEmpty();
			case KbdataPackage.FIGGROUP_TYPE__SYNPH:
				return !getSynph().isEmpty();
			case KbdataPackage.FIGGROUP_TYPE__FILEPATH:
				return !getFilepath().isEmpty();
			case KbdataPackage.FIGGROUP_TYPE__MSGPH:
				return !getMsgph().isEmpty();
			case KbdataPackage.FIGGROUP_TYPE__USERINPUT:
				return !getUserinput().isEmpty();
			case KbdataPackage.FIGGROUP_TYPE__SYSTEMOUTPUT:
				return !getSystemoutput().isEmpty();
			case KbdataPackage.FIGGROUP_TYPE__KEYWORD:
				return !getKeyword().isEmpty();
			case KbdataPackage.FIGGROUP_TYPE__WINTITLE:
				return !getWintitle().isEmpty();
			case KbdataPackage.FIGGROUP_TYPE__OPTION:
				return !getOption().isEmpty();
			case KbdataPackage.FIGGROUP_TYPE__PARMNAME:
				return !getParmname().isEmpty();
			case KbdataPackage.FIGGROUP_TYPE__APINAME:
				return !getApiname().isEmpty();
			case KbdataPackage.FIGGROUP_TYPE__CMDNAME:
				return !getCmdname().isEmpty();
			case KbdataPackage.FIGGROUP_TYPE__MSGNUM:
				return !getMsgnum().isEmpty();
			case KbdataPackage.FIGGROUP_TYPE__VARNAME:
				return !getVarname().isEmpty();
			case KbdataPackage.FIGGROUP_TYPE__AUDIENCE:
				return AUDIENCE_EDEFAULT == null ? audience != null : !AUDIENCE_EDEFAULT.equals(audience);
			case KbdataPackage.FIGGROUP_TYPE__BASE:
				return BASE_EDEFAULT == null ? base != null : !BASE_EDEFAULT.equals(base);
			case KbdataPackage.FIGGROUP_TYPE__CLASS:
				return isSetClass();
			case KbdataPackage.FIGGROUP_TYPE__CONREF:
				return CONREF_EDEFAULT == null ? conref != null : !CONREF_EDEFAULT.equals(conref);
			case KbdataPackage.FIGGROUP_TYPE__DIR:
				return isSetDir();
			case KbdataPackage.FIGGROUP_TYPE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case KbdataPackage.FIGGROUP_TYPE__IMPORTANCE:
				return isSetImportance();
			case KbdataPackage.FIGGROUP_TYPE__LANG:
				return LANG_EDEFAULT == null ? lang != null : !LANG_EDEFAULT.equals(lang);
			case KbdataPackage.FIGGROUP_TYPE__OTHERPROPS:
				return OTHERPROPS_EDEFAULT == null ? otherprops != null : !OTHERPROPS_EDEFAULT.equals(otherprops);
			case KbdataPackage.FIGGROUP_TYPE__OUTPUTCLASS:
				return OUTPUTCLASS_EDEFAULT == null ? outputclass != null : !OUTPUTCLASS_EDEFAULT.equals(outputclass);
			case KbdataPackage.FIGGROUP_TYPE__PLATFORM:
				return PLATFORM_EDEFAULT == null ? platform != null : !PLATFORM_EDEFAULT.equals(platform);
			case KbdataPackage.FIGGROUP_TYPE__PRODUCT:
				return PRODUCT_EDEFAULT == null ? product != null : !PRODUCT_EDEFAULT.equals(product);
			case KbdataPackage.FIGGROUP_TYPE__PROPS:
				return PROPS_EDEFAULT == null ? props != null : !PROPS_EDEFAULT.equals(props);
			case KbdataPackage.FIGGROUP_TYPE__REV:
				return REV_EDEFAULT == null ? rev != null : !REV_EDEFAULT.equals(rev);
			case KbdataPackage.FIGGROUP_TYPE__STATUS:
				return isSetStatus();
			case KbdataPackage.FIGGROUP_TYPE__TRANSLATE:
				return isSetTranslate();
			case KbdataPackage.FIGGROUP_TYPE__XTRC:
				return XTRC_EDEFAULT == null ? xtrc != null : !XTRC_EDEFAULT.equals(xtrc);
			case KbdataPackage.FIGGROUP_TYPE__XTRF:
				return XTRF_EDEFAULT == null ? xtrf != null : !XTRF_EDEFAULT.equals(xtrf);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (group: ");
		result.append(group);
		result.append(", audience: ");
		result.append(audience);
		result.append(", base: ");
		result.append(base);
		result.append(", class: ");
		if (classESet) result.append(class_); else result.append("<unset>");
		result.append(", conref: ");
		result.append(conref);
		result.append(", dir: ");
		if (dirESet) result.append(dir); else result.append("<unset>");
		result.append(", id: ");
		result.append(id);
		result.append(", importance: ");
		if (importanceESet) result.append(importance); else result.append("<unset>");
		result.append(", lang: ");
		result.append(lang);
		result.append(", otherprops: ");
		result.append(otherprops);
		result.append(", outputclass: ");
		result.append(outputclass);
		result.append(", platform: ");
		result.append(platform);
		result.append(", product: ");
		result.append(product);
		result.append(", props: ");
		result.append(props);
		result.append(", rev: ");
		result.append(rev);
		result.append(", status: ");
		if (statusESet) result.append(status); else result.append("<unset>");
		result.append(", translate: ");
		if (translateESet) result.append(translate); else result.append("<unset>");
		result.append(", xtrc: ");
		result.append(xtrc);
		result.append(", xtrf: ");
		result.append(xtrf);
		result.append(')');
		return result.toString();
	}

} //FiggroupTypeImpl
