<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%!String message = "hello!";//message : instance var : impl private%>
<body>
	<%
		int counter = 100;//counter : method local var : _jspService
	//add a page scope attribute
	pageContext.setAttribute("attr1", 1234);
	%>
	<%--include test5.jsp --%>
	<%@ include file="test5.jsp" %>
</body>
</html>