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
package com.nokia.carbide.cpp.internal.qt.core;

import java.io.File;

import org.eclipse.jface.viewers.IFilter;

import com.nokia.carbide.cpp.sdk.core.ISymbianBuildContext;

public abstract class QtFilter implements IFilter {

	protected File getLibFile(ISymbianBuildContext context) {

		if (context.getPlatformString().equals(ISymbianBuildContext.EMULATOR_PLATFORM)) {
			return context.getSDK().getReleaseRoot().append(context.getPlatformString()).
			append(context.getTargetString()).append("QtCore.dll").toFile(); //$NON-NLS-1$
		} else {
			// for non-emulator targets, check in the armv5/lib directory (ARMV5 and GCCE)
			return context.getSDK().getReleaseRoot().append("armv5/lib/QtCore.lib").toFile(); //$NON-NLS-1$
		}
	}
	
	public abstract boolean select(Object toTest);

}
