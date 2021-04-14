<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--import spring suppiled JSP tag lib for URL rewriting --%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>Welcome 2 Spring MVC !!!!!</h4>
	<h5>
		<a href="<spring:url value='/user/login'/>">User Login</a>
	</h5>
	<h5>
		<a href="<spring:url value='/products'/>">Testing ResponseBody Annotation</a>
	</h5>
	<h5>
		<a href="<spring:url value='/products/10/bread/50/2021-03-04'/>">Testing PathVariable n ResponseBody Annotation</a>
	</h5>
</body>
</html>