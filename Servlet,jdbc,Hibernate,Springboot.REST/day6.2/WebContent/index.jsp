<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4 align="center">Session ID <%= session.getId() %></h4>
	<h4>
		Welcome 2 JSP !!!!!! @
		<%=new Date()%></h4>
		<h5>Page : <%= page %></h5>
		<h5>PageContext <%= pageContext %></h5>
	<h5>
		<a href="comments.jsp">Test Comments</a>
	</h5>
	<h5>
		<a href="login.jsp">Test Scripting Elements</a>
	</h5>
	<h5>
		<a href="test.jsp">Test JSP Declarations</a>
	</h5>
</body>
</html>