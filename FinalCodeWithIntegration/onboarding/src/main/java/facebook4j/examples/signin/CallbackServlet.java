package facebook4j.examples.signin;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.auth.AccessToken;

public class CallbackServlet extends HttpServlet {
    private static final long serialVersionUID = 6305643034487441839L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Facebook facebook = (Facebook) request.getSession().getAttribute("facebook");
        String oauthCode = request.getParameter("code");
        try {
            AccessToken accessToken = facebook.getOAuthAccessToken(oauthCode);
            System.out.println(accessToken);
            
            InputStream is = null;
    		FileOutputStream fos = null;

    		String output = System.getProperty("java.io.tmpdir") + "/" + "mylocal.txt";
    		try {
    			fos = new FileOutputStream(output);
    			ObjectOutputStream oos = new ObjectOutputStream(fos);
    			oos.writeObject(accessToken);
    			oos.close();

    			/*byte[] buffer = new byte[accessToken.toString().length()];
    			int length;
    			while ((length = accessToken.toString().length()) > 0) {
    				fos.write(buffer, 0, length);
    			}*/

    		} finally {
    			try {
    				if (is != null) {
    					is.close();
    				}
    			} finally {
    				if (fos != null) {
    					fos.close();
    				}
    			}
    		}
            String userId = facebook.getId();
        } catch (FacebookException e) {
            throw new ServletException(e);
        }
        response.sendRedirect(request.getContextPath() + "/");
    	
    }
}
