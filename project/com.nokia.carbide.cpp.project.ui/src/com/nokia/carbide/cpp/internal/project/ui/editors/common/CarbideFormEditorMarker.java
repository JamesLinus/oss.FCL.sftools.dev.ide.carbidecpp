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
package com.nokia.carbide.cpp.internal.project.ui.editors.common;

import com.nokia.carbide.cpp.internal.project.ui.ProjectUIPlugin;

/**
 * A class for markers generated by editor(s) based on CarbideFormEditor.
 */
public class CarbideFormEditorMarker {

	/**
	 * CarbideFormEditor problem marker type. This can be used to recognize 
	 * the problem markers generated by editor(s) based on CarbideFormEditor.
	 */
	public static final String FORMEDITOR_PROBLEM_MARKER = ProjectUIPlugin.PLUGIN_ID + ".CarbideFormEditorMarker"; //$NON-NLS-1$

}
