<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>From 1st page....</h4>
	<%
	  out.flush();
		//create req scope attribute to hold product details
	request.setAttribute("product_dtls",
			request.getParameter("pid") + ":" + request.getParameter("name") 
			+ ":" + request.getParameter("price"));
	%>
	<jsp:include page="test2.jsp">
		<jsp:param value="food" name="category" />
	</jsp:include>
	<h4>After Request dispatching...</h4>

</body>
</html>