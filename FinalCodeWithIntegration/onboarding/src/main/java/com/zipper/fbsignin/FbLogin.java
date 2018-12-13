package com.zipper.fbsignin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

public class FbLogin {

	private static final String FB_GRAPH_API_URL = "https://graph.facebook.com";
	private static final String FB_LOGIN_URL = "https://www.facebook.com/v2.12/dialog/oauth";
	private static final String FB_ACCESS_TOKEN_URL = "https://graph.facebook.com/v2.12/oauth/access_token";
	private static final String FB_METHOD_GET = "GET";

	private String appId;
	private String appSecret;
	private String permissions;
	private String callbackURL;
	private String userAccessToken;

	public FbLogin(String appId, String appSecret) {
		this.appId = appId;
		this.appSecret = appSecret;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	public String login(String callbackURL) {
		this.callbackURL = callbackURL;

		String url = FB_LOGIN_URL + "?client_id=" + this.appId + "&redirect_uri=" + callbackURL;

		return url;
	}

	public String getUserAccessToken(String oauthCode) {
		String url = FB_ACCESS_TOKEN_URL + "?client_id=" + this.appId + "&client_secret=" + this.appSecret + "&code="
				+ oauthCode + "&redirect_uri=" + callbackURL;

		String accessToken = null;
		try {
			HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
			if (con.getResponseCode() != 200) {
				accessToken = getResponseString(con.getErrorStream());
			} else {
				try {
					JSONObject json = new JSONObject(getResponseString(con.getInputStream()));
					accessToken = json.getString("access_token");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			con.disconnect();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.userAccessToken = accessToken;
		return accessToken;
	}

	public String getUserId() {
		String url = FB_GRAPH_API_URL + "/me?access_token=" + this.userAccessToken;

		String userId = null;
		try {
			HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
			if (con.getResponseCode() != 200) {
				userId = getResponseString(con.getErrorStream());
			} else {
				try {
					//userId = getResponseString(con.getInputStream());
					JSONObject json = new JSONObject(getResponseString(con.getInputStream()));
					userId = json.getString("id");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			con.disconnect();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return userId;
	}

	private String getResponseString(InputStream is) {
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();

		String line;
		try {

			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}
}
