/*
* Copyright (c) 2010 Nokia Corporation and/or its subsidiary(-ies).
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
* Test the BldInfViewPathHelper class.
*
*/
package com.nokia.carbide.cpp.internal.api.sdk.sbsv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import com.nokia.carbide.cpp.sdk.core.ISymbianSDK;

public class SBSv2ConfigData implements ISBSv2ConfigData {

	/** The supporting SDK. May be null if it's a base configuration */
	ISymbianSDK sdk;
	
	/**
	 * A unique build alias. There can only be one alias definition, but an SDK can change the meaning of the alias 
	 */
	String buildAlias;
	/*
	 * The dotted name for the alias. One build alias can have multiple meanings, each defined in an SDK
	 */
	String meaning;
	
	String target = null;
	String platform = null;
	String releaseDirectory = null;
	
	public SBSv2ConfigData(String buildAlias, String meaning, ISymbianSDK sdk){
		this.buildAlias = buildAlias;
		this.meaning = meaning;
		if (sdk != null){
			this.sdk = sdk;
		} 
	}

	public String getBuildAlias() {
		return buildAlias;
	}

	public String getMeaning() {
		return meaning;
	}


	public String getReleaseDirectory() {
		
		return releaseDirectory;
	}

	public ISBSv2ConfigPreprocessorInfo getCPPPreprocessorData() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTraditionalTarget() {
		
		
		return target;
	}

	public String getTraditionalPlatform() {
		
		return platform;
	}

	public String toString(){
		return "Alias = " + buildAlias + " : Meaning = " + meaning;
	}

	public ISymbianSDK getSupportingSDK() {
		return sdk;
	}
	

}