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
package com.nokia.carbide.cdt.builder.test.errorParsers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.NullProgressMonitor;

import com.nokia.carbide.cdt.builder.CarbideBuilderPlugin;
import com.nokia.carbide.cdt.builder.builder.CarbideCPPBuilder;
import com.nokia.carbide.cdt.builder.project.ICarbideBuildConfiguration;
import com.nokia.carbide.cdt.builder.project.ICarbideProjectInfo;
import com.nokia.carbide.cdt.builder.test.TestPlugin;
import com.nokia.carbide.cpp.internal.api.sdk.SymbianBuildContext;
import com.nokia.carbide.cpp.project.core.ProjectCorePlugin;
import com.nokia.carbide.cpp.sdk.core.*;
import com.nokia.cpp.internal.api.utils.core.FileUtils;

import junit.framework.TestCase;

public class TestMakmakeErrorParser extends TestCase {
	private static final String PROJECT_NAME = "TestMakmakeErrorParser";
	private static final String PROJECT_PATH = "group/bld.inf";
	private static final String SDK_ID_UPPER_CASE = "S60_3RD_MR";  // ID of the SDK we want to use to create build configurations
	
	private static final String TEST_DATA_INPUT_FILE = "data/errorpatterns/makmake.errors.input.1.txt";
	private static final String CONTROL_DATA_FILE    = "data/errorpatterns/makmake.errors.regression.1.xml";
	
	CarbideErrorParserTestHarness harness;
	private IProject project;
	
	protected void setUp() throws Exception {
		super.setUp();
		project = ProjectCorePlugin.createProject(PROJECT_NAME, null);
		
		// You need to set the proper default configuration so the correct set of error parsers is called
		List<ISymbianSDK> sdkList = SDKCorePlugin.getSDKManager().getSDKList();
		ISymbianSDK sdk = null;
		for (ISymbianSDK currSDK : sdkList){
			if (currSDK.getUniqueId().toUpperCase().equals(SDK_ID_UPPER_CASE)){
				sdk = currSDK;
				break;
			}
		}
		
		assertNotNull(sdk);
		
		ISymbianBuildContext context = new SymbianBuildContext(sdk, ISymbianBuildContext.ARMV5_PLATFORM, ISymbianBuildContext.DEBUG_TARGET);
		List<ISymbianBuildContext> contextList = new ArrayList<ISymbianBuildContext>();
		contextList.add(context);
		
		// Don't do this... Because it will just default to WINSCW target
//		ProjectCorePlugin.postProjectCreatedActions(project, "group/bld.inf", 
//				TestPlugin.getUsableBuildConfigs(), new ArrayList<String>(), 
//				"Debug MMP", null, new NullProgressMonitor());
		
		ProjectCorePlugin.postProjectCreatedActions(project, PROJECT_PATH, 
				contextList, new ArrayList<String>(), 
				"Debug MMP", null, new NullProgressMonitor());
		
		ICarbideProjectInfo cpi = CarbideBuilderPlugin.getBuildManager().getProjectInfo(project);
		ICarbideBuildConfiguration buildConfig = cpi.getDefaultConfiguration();
		harness = new CarbideErrorParserTestHarness(project, 
												new NullProgressMonitor(),
												CarbideCPPBuilder.getParserIdArray(buildConfig.getErrorParserId()), 
												cpi.getINFWorkingDirectory());
	}

	protected void tearDown() throws Exception {
		project.delete(true, null);
		super.tearDown();
	}
	
	protected FileInputStream pluginRelativeControlFile(String filePath) {
		FileInputStream fileInputStream = null;
		try {
			java.io.File file = FileUtils.pluginRelativeFile(TestPlugin.getDefault(), filePath);
			fileInputStream = new FileInputStream(file);
		} catch (IOException e) {
			fail("Loading control data file " + filePath + " gives IOException");
		}
		return fileInputStream;
	}


	/**
	 * Test for multiple types of compiler errors
	 */
	public void testMakmakeCompilerErrors() {
		//argument 1 is console output you get from the tool
		//argument 2 is control XML with the marker data
		try {
			harness.parseStringAndTestAgainstXML(FileUtils.pluginRelativeFile(TestPlugin.getDefault(), TEST_DATA_INPUT_FILE), 
												FileUtils.pluginRelativeFile(TestPlugin.getDefault(), CONTROL_DATA_FILE));
		} catch (IOException e) {
			fail();
		}
	}
}
