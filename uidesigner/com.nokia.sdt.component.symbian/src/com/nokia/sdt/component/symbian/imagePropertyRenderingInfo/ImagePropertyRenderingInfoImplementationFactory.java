/*
* Copyright (c) 2005 Nokia Corporation and/or its subsidiary(-ies).
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


package com.nokia.sdt.component.symbian.imagePropertyRenderingInfo;

import com.nokia.sdt.component.symbian.implementations.IImplementationTypeFactory;
import com.nokia.sdt.datamodel.adapter.IImagePropertyRenderingInfo;

public class ImagePropertyRenderingInfoImplementationFactory implements IImplementationTypeFactory {

	public Class getInterface() {
		return IImagePropertyRenderingInfo.class;
	}

	public Class getCodeImplAdapterClass() {
		return ImagePropertyRenderingInfoAdapterCode.class;
	}

	public Class getScriptImplAdapterClass() {
		return ImagePropertyRenderingInfoAdapterScript.class;
	}
}
