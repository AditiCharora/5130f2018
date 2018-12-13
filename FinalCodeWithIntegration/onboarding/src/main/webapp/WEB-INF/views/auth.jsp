<%@page import="linkedin.LinkedInProfile"%>
<%@page import="linkedin.share_Test"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

<%
System.out.println("you are here aditi");

String code=(String)request.getParameter("code");
String state=(String)request.getParameter("state");
share_Test obj_Post=new share_Test();
obj_Post.sendPostShare(code);
System.out.println("exiting");
%>
 
 </body>
</html>