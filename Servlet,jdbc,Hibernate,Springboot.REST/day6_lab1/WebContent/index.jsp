<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- pageContext.getSession().getId() --%>
	<h5>Session ID : ${pageContext.session.id}</h5>
	<h5>
		<a href="login.jsp">User Login</a>
	</h5>
	<h5>
		<a href="test1.jsp">Testing Different Scopes</a>
	</h5>
</body>
</html>