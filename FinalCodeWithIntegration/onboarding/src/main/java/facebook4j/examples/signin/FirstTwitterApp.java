package facebook4j.examples.signin;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.security.auth.login.Configuration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import twitter4j.Status;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

public class FirstTwitterApp extends HttpServlet {	
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String CONSUMER_KEY = "F97yaG4UZSpiYqAoEjiNiumi9";
	    String CONSUMER_KEY_SECRET = "OqsgIvrcaXyRh8Q8FdbmlShXjff2QOIHrJxD1pRat7ZA7F1nHl";
	
		ConfigurationBuilder cf = new ConfigurationBuilder();
		cf.setDebugEnabled(true)
		.setOAuthConsumerKey("F97yaG4UZSpiYqAoEjiNiumi9")
		.setOAuthConsumerSecret("OqsgIvrcaXyRh8Q8FdbmlShXjff2QOIHrJxD1pRat7ZA7F1nHl")
		.setOAuthAccessToken("1628484787-u1DhXBDfVglwHA93wV5aLIgJ20aHY6gv1zSvgsd")
		.setOAuthAccessTokenSecret("fw7smgJhC0zjBPlxu1woeIoTn2GaX4GmtNVrUGkTudxXo");
		  
		TwitterFactory tf= new TwitterFactory(cf.build()); 
		twitter4j.Twitter twitter= tf.getInstance();
			
			List<Status> status = null;
			try {
				status = twitter.getHomeTimeline();
			} catch (TwitterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(Status st :status)
			{
				System.out.println(st.getUser().getName()+"-------------------"+st.getText());
			}
			
			String message="\"A Visit to Transylvania\" by Euromaxx: Lifestyle Europe (DW) \n http://bit.ly/1cHB7MH";
		//	File file=new File("Macintosh HD⁩/⁨Users⁩⁨/aditicharora⁩/Downloads/Linkedin.png");
			StatusUpdate share = new StatusUpdate(message);

		//	share.setMedia(file); // set the image to be uploaded here.

			try {
				twitter.updateStatus(share);
			} catch (TwitterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
