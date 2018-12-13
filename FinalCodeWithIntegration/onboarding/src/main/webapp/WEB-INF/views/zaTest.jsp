<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="/">
<title>ZA Onboarding</title>

<script type="text/javascript" src="<spring:url value="/resources/js/jquery/jquery.min.js" htmlEscape="true"/>"></script>
<script type="text/javascript" src="<spring:url value="/resources/js/jquery/jqueryui/jquery-ui.min.js" htmlEscape="true" />"></script>
<script type="text/javascript" src="<spring:url value="/resources/js/angularjs/1.6.2/angular.min.js" htmlEscape="true"/>"></script> 
<script type="text/javascript" src="<spring:url value="/resources/js/angularjs/1.6.2/angular-animate.min.js" htmlEscape="true"/>"></script>
<script type="text/javascript" src="<spring:url value="/resources/js/angularjs/1.6.2/angular-messages.min.js" htmlEscape="true"/>"></script>
<script type="text/javascript" src="<spring:url value="/resources/js/angularjs/1.6.2/angular-aria.min.js" htmlEscape="true"/>"></script> 
<script type="text/javascript" src="<spring:url value="/resources/js/angularjs/1.6.2/angular-route.min.js" htmlEscape="true"/>"></script>  
<script type="text/javascript" src="<spring:url value="/resources/js/angularjs/1.6.2/angular-sanitize.min.js" htmlEscape="true"/>"></script>
<script type="text/javascript" src="<spring:url value="/resources/js/angularjs/ui-bootstrap-tpls-0.10.0.js" htmlEscape="true"/>"></script>
<script type="text/javascript" src="<spring:url value="/resources/js/controller/zaTestController.js" htmlEscape="true"/>"></script>
<script type="text/javascript" src="<spring:url value="/resources/js/angular-material/angular-material.min.js" htmlEscape="true"/>"></script>
</head>
<body>
	<div id="testDiv" ng-controller="testController">
		<div ng-view></div>
	</div>
</body>
</html>