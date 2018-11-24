<%@page import="linkedin.credentials"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LinkedIn</title>
</head>
<body>


<a href="https://www.linkedin.com/oauth/v2/authorization?response_type=code&client_id=<%=credentials.client_id%>&redirect_uri=<%=credentials.redirect_url%>&state=fdfdfdfd&scope=r_basicprofile%20r_emailaddress">

		<img alt="" src="Linkedin-customized-button.png" style="width: 60%">
</a>

</body>
</html>
