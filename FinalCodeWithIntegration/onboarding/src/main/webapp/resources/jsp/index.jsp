<%@page import="linkedin.credentials"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>
Login With Linked In
</h1>
<%
System.out.println("Linkedin login step 2: request an authorization code");

%>	
<a href="https://www.linkedin.com/oauth/v2/authorization?response_type=code
&client_id=<%=credentials.client_id %>&redirect_uri=<%=credentials.redirect_url%>&state=fdfdfdfd
 &scope=r_basicprofile%20r_emailaddress%20rw_company_admin%20w_share">

		<img alt="" src="Linkedin-customized-button.png" style="width: 10%">		
		
</a>

</body>
</html>