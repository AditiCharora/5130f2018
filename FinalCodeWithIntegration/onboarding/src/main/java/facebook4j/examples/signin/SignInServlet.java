package facebook4j.examples.signin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zipper.fbsignin.FbLogin;

public class SignInServlet extends HttpServlet {
    private static final long serialVersionUID = -7453606094644144082L;
    private static final String fbUserPermissions = "publish_actions";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("facebook") != null) {
		// if facebook object exists get accesstoken
		FbLogin fb = (FbLogin) request.getSession().getAttribute("facebook");
		String accessToken = fb.getUserAccessToken(request.getParameter("code"));
		System.out.println(accessToken);
		System.out.println(fb.getUserId());
	} else {
		// else create a fblogin object and initiate the login process
		FbLogin fb = new FbLogin("186055028795159", "f2d90ce338ea77d3232563730e724393");
		request.getSession().setAttribute("facebook", fb);
		response.sendRedirect(fb.login(request.getRequestURL().toString()));
	}
}
}
