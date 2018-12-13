package com.zipperagent.socialmanager;

import java.net.URL;

public interface ProfileAgent {

	void postLink(URL link, String message);
	void postPhoto(String fileLocation, String message);
	void postMessage(String message);
}
