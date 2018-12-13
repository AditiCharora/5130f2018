package com.zipperagent.socialmanager;

import java.io.File;
import java.net.URL;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Media;
import facebook4j.PhotoUpdate;
import facebook4j.auth.AccessToken;

public class FacebookAgent implements ProfileAgent {
	private Facebook facebook = null;

	public FacebookAgent(String appID, String appSecret, String oauthCode) {
		facebook = new FacebookFactory().getInstance();
		facebook.setOAuthAppId(appID, appSecret);
		facebook.setOAuthAccessToken(new AccessToken(oauthCode, null));
	}
	
	public void getOAuthAuthorizationURL(String callbackURL){
		facebook.getOAuthAuthorizationURL(callbackURL);
	}

	public void postLink(URL link, String message) {
		if(message == null){
			System.err.println(this.getClass().getName() + ": Null message");
			return;
		}
		if (message.isEmpty()) {
			postOnlyLink(link);
		} else {
			try {
				facebook.postLink(link, message);
			} catch (FacebookException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void postOnlyLink(URL link) {
		try {
			facebook.postLink(link);
		} catch (FacebookException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void postPhoto(String fileLocation, String message) {
		File mediaFile = new File("C:\\Ravi\\Wallpapers\\sample1.png");
		Media media = new Media(mediaFile);
		PhotoUpdate photoUpdate = new PhotoUpdate(media);
		photoUpdate.message(message);
		try {
			facebook.postPhoto(photoUpdate);
		} catch (FacebookException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void postMessage(String message) {
		try {
			facebook.postStatusMessage(message);
		} catch (FacebookException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Facebook getFacebook() {
		return facebook;
	}

	public AccessToken getAccessToken(String oauthCode) {
		try {
			return facebook.getOAuthAccessToken(oauthCode);
		} catch (FacebookException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
