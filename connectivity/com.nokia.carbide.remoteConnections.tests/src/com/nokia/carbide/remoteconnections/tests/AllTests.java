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
package com.nokia.carbide.remoteconnections.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for remoteconnections.tests");
		
		//$JUnit-BEGIN$
		suite.addTestSuite(RegistryTest.class);
		suite.addTestSuite(SerializationTest.class);
		suite.addTestSuite(FilterTest.class);
		suite.addTestSuite(TCPIPConnectionTypeTests.class);
		//$JUnit-END$
		return suite;
	}

}
