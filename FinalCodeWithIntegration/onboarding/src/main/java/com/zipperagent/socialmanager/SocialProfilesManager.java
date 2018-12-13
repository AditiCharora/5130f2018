package com.zipperagent.socialmanager;

import java.net.URL;
import java.util.HashMap;

import facebook4j.auth.AccessToken;

public class SocialProfilesManager {
	HashMap<Integer, ProfileAgent> activeUserProfiles = new HashMap<Integer, ProfileAgent>();
	AccessToken fbAccessToken = null;

	public void createFacebookProfile(String appID, String appSecret, String oauthCode, String callbackURL) {
		FacebookAgent fbAgent = new FacebookAgent(appID, appSecret, oauthCode);
		activeUserProfiles.put(activeUserProfiles.size(), fbAgent);
		
		fbAgent.getOAuthAuthorizationURL(callbackURL);
		fbAccessToken = fbAgent.getAccessToken(oauthCode);
	}

	public AccessToken getFbAccessToken() {
		return fbAccessToken;
	}

	public void postMessage(int[] agentIds, String message) {
		if (agentIds.length != 0) {
			if (message == null || message.isEmpty()) {
				System.err.println(this.getClass().getName() + ": Empty or null message");
				return;
			}
			for (int i : agentIds) {
				ProfileAgent agent = activeUserProfiles.get(i);
				agent.postMessage(message);
			}
		} else {
			System.err.println(this.getClass().getName() + ": No profile selected");
			return;
		}
	}

	public void postLink(int[] agentIds, URL url, String message) {
		if (agentIds.length != 0) {
			for (int i : agentIds) {
				ProfileAgent agent = activeUserProfiles.get(i);
				agent.postLink(url, message);
			}
		} else {
			System.err.println(this.getClass().getName() + ": No profile selected");
			return;
		}
	}
}
