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
* This default include file locator provides system #include directories
* based on an SDK's include directory and variant.hrh directory.
*
*
*/
package com.nokia.carbide.cdt.builder;

import java.io.File;
import java.util.*;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;

import com.nokia.carbide.cdt.builder.project.ICarbideProjectInfo;
import com.nokia.carbide.cpp.epoc.engine.model.sbv.ISBVView;
import com.nokia.carbide.cpp.sdk.core.*;
import com.nokia.carbide.internal.api.cpp.epoc.engine.preprocessor.BasicIncludeFileLocator;

public class DefaultIncludeFileLocator extends BasicIncludeFileLocator {
	/**
	 * Create default #include locator that searches the same directory
	 * as an #including file and optionally the given
	 * SDK's epoc32\include directory.  
	 * @param project the project providing the bld.inf path
	 * @param buildContext the build context, or null
	 */
	public DefaultIncludeFileLocator(IProject project, ISymbianBuildContext buildContext) {
		super(null, null);
		
		List<File> systemPaths = new ArrayList<File>();
		if (buildContext != null && buildContext.getSDK() != null) {
			// search implicit bld.inf directory if known
			if (project != null) {
				ICarbideBuildManager buildManager = CarbideBuilderPlugin.getBuildManager();
				ICarbideProjectInfo cpi = buildManager.getProjectInfo(project);
				if (cpi != null && cpi.getAbsoluteBldInfPath() != null) {
					systemPaths.add(cpi.getAbsoluteBldInfPath().removeLastSegments(1).toFile());
				}
			}
			
			IBSFPlatform bsfplatform = buildContext.getSDK().getBSFCatalog().findPlatform(buildContext.getPlatformString());
			ISBVPlatform sbvPlatform = buildContext.getSDK().getSBVCatalog().findPlatform(buildContext.getPlatformString());

			// look in the epoc32 directory of the SDK
			IPath includePath = buildContext.getSDK().getIncludePath();
			if (includePath != null) {
				File includeDir = includePath.toFile().getAbsoluteFile();
				File dir;
				
				// get additional include directories from BSF platform, if defined
				if (bsfplatform != null) {
					IPath[] systemIncludePaths = bsfplatform.getSystemIncludePaths();
					for (IPath path : systemIncludePaths) {
						dir = path.toFile();
						if (dir.exists() && dir.isDirectory()) {
							systemPaths.add(dir);
						}
					}
				} else if (sbvPlatform != null){
					
					Map<IPath, String> platPaths = sbvPlatform.getBuildIncludePaths();
					Set<IPath> set = platPaths.keySet();
					for (IPath path : set) {
						String pathType = platPaths.get(path);
						if (pathType.equalsIgnoreCase(ISBVView.INCLUDE_FLAG_PREPEND) || pathType.equalsIgnoreCase(ISBVView.INCLUDE_FLAG_SET)){
							dir = path.toFile();
							systemPaths.add(dir);
						}
					}
				}
				else {
					// legacy behavior 
					if (buildContext.getPlatformString().equals(ISymbianBuildContext.EMULATOR_PLATFORM)) {
						dir = new File(includeDir, "wins"); //$NON-NLS-1$
						if (dir.exists() && dir.isDirectory()) {
							systemPaths.add(dir);
						}
					}
				}

				// add OEM dir
				dir = new File(includeDir, "oem"); //$NON-NLS-1$
				if (dir.exists() && dir.isDirectory()) {
					systemPaths.add(dir);
				}
	
				// and finally the normal include dir
				systemPaths.add(includeDir);
				
				// and finally, finally, if this is an SBV add any paths with the append flag
				if (sbvPlatform != null){
					
					Map<IPath, String> platPaths = sbvPlatform.getBuildIncludePaths();
					Set<IPath> set = platPaths.keySet();
					for (IPath path : set) {
						String pathType = platPaths.get(path);
						if (pathType.equalsIgnoreCase(ISBVView.INCLUDE_FLAG_APPEND)){
							dir = path.toFile();
							systemPaths.add(dir);
						}
					}	
				}
			}
			
			// also search files in same folder as variant.hrh
			File prefix = buildContext.getSDK().getPrefixFile();
			if (sbvPlatform != null){
				// might be an alternate HRH file to use
				IPath varVarHRH = sbvPlatform.getBuildVariantHRHFile();
				if (!varVarHRH.toFile().equals(prefix) && varVarHRH.toFile().exists()){
					prefix = varVarHRH.toFile();
				} 
			}
			if (prefix != null) {
				systemPaths.add(prefix.getParentFile());
			}

		}
		setPaths(null, (File[]) systemPaths.toArray(new File[systemPaths.size()]));
	}
}
