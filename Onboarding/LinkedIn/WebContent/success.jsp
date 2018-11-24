<%@page import="linkedin.LinkedInProfile"%>
<%@page import="linkedin.Post_Test"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Login Success</h1>

<%
String code=(String)request.getParameter("code");
String state=(String)request.getParameter("state");

Post_Test obj_Post=new Post_Test();
LinkedInProfile OBJ_LinkedInProfile=obj_Post.sendPost(code);
%>


 Fist Name : <%=OBJ_LinkedInProfile.getFirstName() %><br>
 Last Name:<%=OBJ_LinkedInProfile.getLastName() %><br>




</body>
</html>
