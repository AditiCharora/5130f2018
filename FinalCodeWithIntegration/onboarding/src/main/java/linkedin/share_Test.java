package linkedin;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONObject;

public class share_Test {
	public void sendPostShare(String code) throws Exception {

		// this method will make a HTTP post request to linkedin page using the
		// credentials of currently authenticated user .
		// if request is successful, then LinkedIn will return an ApiResponse object
		// with all of the relevant aspects of server’s response, i.e., confirmation of
		// sharing the content on LinkedIn.
		
		String url = "https://www.linkedin.com/oauth/v2/accessToken";
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		// add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("Host", "www.linkedin.com");
		con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

		String urlParameters = "grant_type=authorization_code&code=" + code + "&redirect_uri="
				+ credentials.redirect_url + "&client_id=" + credentials.client_id + "&client_secret="
				+ credentials.client_secret + "";

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		System.out.println(response.toString());

		JSONObject jsonObj = new JSONObject(response.toString());
		String access_token = jsonObj.getString("access_token");
		
		getAccessToken(access_token);

		System.out.println(access_token);

	}
	public void getAccessToken(String access_token)throws Exception {

		String url = "https://api.linkedin.com/v1/people/~?format=json";

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		// add request header
		con.setRequestProperty("Host", "api.linkedin.com");
		con.setRequestProperty("Connection", "Keep-Alive");
		con.setRequestProperty("Authorization", "Bearer " + access_token);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		System.out.println(response.toString());
/*		JSONObject jsonObj = new JSONObject(response.toString());
		String auth_token = jsonObj.getString("siteStandardProfileRequest.{auth_Token}");
		System.out.println(auth_token);*/
		
		
		Post(access_token);
		
		
	}
	
	public void Post(String access_token)throws Exception {
		String url = "https://api.linkedin.com/v1/people/~/shares?format=json";
	//	String jsonbody="{\"comment\": \"Check out developer.linkedin.com! http://linkd.in/1FC2PyG\",\"content\":{\"title\":\"LinkedIn Developer Resource\"} ,\"visibility\" :{\"code\":\"anyone\"}}";
		String jsonbody="{\n" + 
				"  \"comment\": \"Check out developer.linkedin.com! http://linkd.in/1FC2PyG\",\n" + 
				"  \"visibility\": {\n" + 
				"    \"code\": \"anyone\"\n" + 
				"  }\n" + 
				"}";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();	
		
		// add reuqest header
				con.setRequestMethod("POST");
				//con.setRequestProperty("Host", "www.linkedin.com");
				con.setRequestProperty("Connection", "Keep-Alive");
				con.setRequestProperty("Authorization", "Bearer " + access_token);
				con.setRequestProperty("Content-Type", "application/json");
				con.setRequestProperty("Content-Length","jsonbody.length()");
				con.setRequestProperty("x-li-format", "json");
				

		/*	String urlParameters = jsonbody+"&redirect_uri="
						+ credentials.redirect_url + "&client_id=" + credentials.client_id + "&client_secret="
						+ credentials.client_secret + "";*/

				// Send post request
				con.setDoOutput(true);
				DataOutputStream wr = new DataOutputStream(con.getOutputStream());
				wr.writeBytes(jsonbody);
				wr.flush();
				wr.close();

				int responseCode = con.getResponseCode();
				System.out.println("\nSending 'POST' request to URL : " + url);
		//		System.out.println("Post parameters : " + urlParameters);
				System.out.println("Response Code : " + responseCode);
		
		
	
	}

	
}
