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

package com.nokia.carbide.cpp.internal.news.reader.gen.FeedInfo;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import com.nokia.carbide.cpp.internal.news.reader.CarbideNewsReaderPlugin;
import com.nokia.cpp.internal.api.utils.core.FileUtils;

/**
 * A class for managing feed information.
 *
 */
public class FeedInfoManager {

	// private data
	private static final String FEED_INFO_FILE_KEY = "com.nokia.carbide.cpp.news.reader.feed.listing.file";
	private static final String FEED_INFO_FILE_NAME = "feedListing.xml";
	private File feedInfoFile;
	private FeedInfoType feedInfo;

	/**
	 * Check whether a feed is news feed.
	 * @param feed - feed to be checked
	 * @return true if it is a news feed
	 */
	public static boolean isNewsFeed(FeedType feed) {
		return feed.getType().toLowerCase().equals(FeedInfoConstants.FEED_TYPE_NEWS);
	}

	/**
	 * Check whether a feed is resource feed.
	 * @param feed - feed to be checked
	 * @return true if it is a resource feed
	 */
	public static boolean isResourceFeed(FeedType feed) {
		return feed.getType().toLowerCase().equals(FeedInfoConstants.FEED_TYPE_RESOURCE);
	}

	public static boolean isSubscribed(FeedType feed) {
		String subscribed = feed.getType().toLowerCase();
		if (subscribed.equals(FeedInfoConstants.SUBSCRIBED_ALWAYS) || subscribed.equals(FeedInfoConstants.SUBSCRIBED_TRUE)) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Load feed information from a file.
	 * @param url - URL to the file
	 * @return true on success
	 */
	public boolean loadFeedInfo(URL url) {
		if (url == null) {
			return false;
		}

		boolean success = true;
		try {
			feedInfo = FeedInfoLoader.loadFeedInfo(url);
			success = (feedInfo != null);
		} catch (URISyntaxException eURI){
			CarbideNewsReaderPlugin.log(eURI);
			success = false;
		} catch (IOException eIO){
			CarbideNewsReaderPlugin.log(eIO);
			success = false;
		}
		return success;
	}

	/**
	 * Return the stored feed information.
	 * @return stored feed information
	 */
	public FeedInfoType getFeedInfo() {
		return feedInfo;
	}

	/**
	 * Retrieve the feed info file from remote server, make a local copy of this file
	 * and returns the URL to the local copy.
	 * @return URL of local copy of feed info file
	 * @throws Exception
	 */
	public URL getFeedInfoFileURL() throws Exception {
		String pathStr = CarbideNewsReaderPlugin.getFeedManager().getProperty(FEED_INFO_FILE_KEY);
		if (pathStr != null) {
			URL fileUrl = new URL(pathStr);
			if (fileUrl != null) {
				HttpURLConnection httpConnection = null;
				InputStream inputStream = null;
				try {
					URLConnection connection = fileUrl.openConnection();
					httpConnection = (HttpURLConnection)connection;
					httpConnection.connect();
					int responseCode = httpConnection.getResponseCode();
					handlesHttpErrorCode(responseCode);
					inputStream = connection.getInputStream();
					if (inputStream != null) {
						if (feedInfoFile == null) {
							feedInfoFile = createFeedInfoFile();
						}
						if (feedInfoFile != null) {
							if (feedInfoFile.exists()) {
								feedInfoFile.delete();
							}
							FileUtils.copyFile(inputStream, feedInfoFile);
							return feedInfoFile.toURL();
						}
					}
				} catch (Exception e) {
					CarbideNewsReaderPlugin.log(e);
				} finally {
					if (httpConnection != null) {
					    httpConnection.disconnect();
					}
					if (inputStream != null) {
						inputStream.close();
					}
				}
			}
		}
		return null;
	}

	/**
	 * Save feed information to a file.
	 * @param url - URL to the file
	 * @return true on success
	 */
	public boolean saveFeedInfo(URL url) {
		if (url == null) {
			return false;
		}

		boolean success = true;
		try {
			if (feedInfo != null) {
				success = FeedInfoLoader.saveFeedInfo(feedInfo, url);
			}
		} catch (URISyntaxException eURI){
			CarbideNewsReaderPlugin.log(eURI);
			success = false;
		} catch (IOException eIO){
			CarbideNewsReaderPlugin.log(eIO);
			success = false;
		}
		return success;
	}

	/**
	 * Set the stored feed information
	 * @param feedInfo - incoming feed information
	 */
	public void setFeedInfo(FeedInfoType feedInfo) {
		this.feedInfo = feedInfo;
	}

	/**
	 * Create a feed info file in the local temp directory.
	 * @return feed info file in the local temp directory
	 */
	private File createFeedInfoFile() {
		File tempDir = FileUtils.getTemporaryDirectory();
		IPath path = new Path(tempDir.getAbsolutePath());
		path = path.append(FEED_INFO_FILE_NAME);
		File file = path.toFile();
		return file;
	}

	/**
	 * Handles HTTP error codes.
	 * @param responseCode - HTTP response code
	 */
	private void handlesHttpErrorCode(int responseCode) throws Exception {
		if (responseCode == 403) {
			throw new Exception("Authentication required for that resource. HTTP Response code was:" + responseCode);
		} else if (responseCode >= 400 && responseCode < 500) {
			throw new Exception("The requested resource could not be found. HTTP Response code was:" + responseCode);
		} else if (responseCode >= 500 && responseCode < 600) {
			throw new Exception("The server encounted an error. HTTP Response code was:" + responseCode);
		}
	}

}
