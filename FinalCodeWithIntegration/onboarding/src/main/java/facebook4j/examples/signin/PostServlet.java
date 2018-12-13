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

		/*InputStream is = null;
		FileOutputStream fos = null;

		String output = System.getProperty("java.io.tmpdir") + "/" + "mylocal.jpeg";
		try {
			URL url = new URL(
					"https://images.unsplash.com/photo-1503135935062-b7d1f5a0690f?dpr=1&auto=format&fit=crop&w=376&h=564&q=60&cs=tinysrgb");
			URLConnection conn = url.openConnection();

			is = conn.getInputStream();
			fos = new FileOutputStream(output);

			byte[] buffer = new byte[4096];
			int length;
			while ((length = is.read(buffer)) > 0) {
				fos.write(buffer, 0, length);
			}

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
		}*/

		try {
			/*File mediaFile = new File(output);
			Media media = new Media(mediaFile);
			PhotoUpdate photoUpdate = new PhotoUpdate(media);
			photoUpdate.message("Test photo upload!");

			facebook.postPhoto(photoUpdate);*/
			//facebook.postLink(new URL("https://www.udemy.com/"));
		facebook.postStatusMessage(message);
		facebook.postLink(new URL("https://www.udemy.com/"));
		} catch (FacebookException e) {
			throw new ServletException(e);
		}

		response.sendRedirect(request.getContextPath() + "/");
	}

}
