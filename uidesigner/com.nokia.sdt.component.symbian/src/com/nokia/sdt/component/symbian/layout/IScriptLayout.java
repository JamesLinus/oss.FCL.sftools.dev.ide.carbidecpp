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

package com.nokia.sdt.component.symbian.layout;

import com.nokia.sdt.component.symbian.scripting.WrappedInstance;
import com.nokia.sdt.displaymodel.ILookAndFeel;

import org.eclipse.swt.graphics.Point;

/**
 * This script interface is used to layout the children of a layout container
 *
 */
public interface IScriptLayout {
    /**
     * Layout the container's children
     */
    public void layout(WrappedInstance instance, ILookAndFeel laf);

    /**
     * return the preferred size of a nested container
     */
    public Point getPreferredSize(WrappedInstance instance, ILookAndFeel laf, int wHint, int hHint);
}
