package twitter;

import twitter4j.Status;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

public class FirstTwitterApp {

	public static void main(String[] args) {


		ConfigurationBuilder cf = new ConfigurationBuilder();
		cf.setDebugEnabled(true)
			.setOAuthConsumerKey("*********************")
			.setOAuthConsumerSecret("2********************")
			.setOAuthAccessToken("************************************************************")
			.setOAuthAccessTokenSecret("************************************************************");

  }
