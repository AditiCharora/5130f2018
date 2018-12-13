<%@page import="facebook4j.examples.signin.SignInServlet"%>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html>
<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>Sign in with Facebook example</title>
</head>
<body>
	<tag:notloggedin>
		<p>Login flow for Web Applications:</p>
		<a href="signin"><img src="./resources/img/icons/login-with-facebook.png"
			alt="Sign in with Facebook"></a>
		<hr />
		<p>Login from Devices:</p>
		<a href="gencode"><img src="./resources/img/icons/login-with-facebook.png"
			alt="Sign in with Facebook"></a>
	</tag:notloggedin>
	<tag:loggedin>
		<h1>Welcome ${facebook.name} (${facebook.id})</h1>
		<a href="tokenInfo" target="_blank">Access Token Info</a>
		<hr />
		<form action="./post" method="post">
			<textarea cols="80" rows="2" name="message"></textarea>
			<input type="submit" name="post" value="statuses" />
		</form>
		<a href="./logout">logout</a>
	</tag:loggedin>
</body>
</html>