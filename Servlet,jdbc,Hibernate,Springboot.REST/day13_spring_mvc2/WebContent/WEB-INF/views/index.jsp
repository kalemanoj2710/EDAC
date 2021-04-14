<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>
	<%--URL sent after clicking the link : http://host:port/day13_spring_mvc2/hello --%>
		<a href="hello">Test Spring MVC Flow</a>
	</h4>
	<h4>
	<%--URL sent after clicking the link : http://host:port/day13_spring_mvc2/test/hello1--%>
		<a href="test/hello1">Test Model Attributes With Model n View</a>
	</h4>
	<h4>
	<%--URL sent after clicking the link : http://host:port/day13_spring_mvc2/test/hello2?start=10&end=50--%>
		<a href="test/hello2?start=10&end=50">Test Model Attributes With Model Map n Request Params</a>
	</h4>
</body>
</html>