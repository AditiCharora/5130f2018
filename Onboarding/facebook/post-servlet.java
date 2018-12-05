package facebook4j.examples.signin;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.Media;
import facebook4j.PhotoUpdate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 4179545353414298791L;
	private String message = null;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		message = request.getParameter("message");
		Facebook facebook = (Facebook) request.getSession().getAttribute("facebook");


		try {

		facebook.postStatusMessage(message);
		facebook.postLink(new URL("https://www.uml.edu/"));
		} catch (FacebookException e) {
			throw new ServletException(e);
		}

		response.sendRedirect(request.getContextPath() + "/");
	}

}
