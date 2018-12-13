package facebook4j.examples.signin.device;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.auth.DeviceCode;

public class DeviceSigninServlet extends HttpServlet {
    private static final long serialVersionUID = -7453606094644144082L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Facebook facebook = (Facebook) request.getSession().getAttribute("facebook");
        //facebook.setOAuthAppId("186055028795159", "f2d90ce338ea77d3232563730e724393");
        //facebook.setOAuthAccessToken(new AccessToken("b474e00e7b7d74a753a484d1f13f1403", null));
        DeviceCode deviceCode = (DeviceCode) request.getSession().getAttribute("deviceCode");
        try {
            facebook.getOAuthDeviceToken(deviceCode);
        } catch (FacebookException e) {
            throw new ServletException(e);
        }
        request.getSession().setAttribute("facebook", facebook);
        response.sendRedirect(request.getContextPath() + "/");
    }
}
