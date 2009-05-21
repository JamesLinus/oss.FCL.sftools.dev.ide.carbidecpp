/*
* Copyright (c) 2007-2009 Nokia Corporation and/or its subsidiary(-ies).
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

package com.nokia.carbide.cpp.epoc.engine.model.sbv;

import com.nokia.carbide.cpp.epoc.engine.model.*;

/**
 * This is the owner interface to the SBV (Symbian Binary Variant) model.  
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface ISBVOwnedModel extends ISBVModel, IOwnedModel<ISBVView> {

}
