<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%!//JSP declaration block
	int counter;//private 

	int incIt() {
		return ++counter;//private 
	}

	//override jsp life cycle methods
	public void jspInit() {
		System.out.println("in jsp init " + Thread.currentThread());
	}%>
<body>
	<%
		System.out.println("in jsp service " + Thread.currentThread());
	%>
	<h5> Visit Counter : <%=  incIt() %></h5>
</body>
<%!//override jsp life cycle methods
	public void jspDestroy() {
		System.out.println("in jsp destroy " + Thread.currentThread());
	}%>
</html>