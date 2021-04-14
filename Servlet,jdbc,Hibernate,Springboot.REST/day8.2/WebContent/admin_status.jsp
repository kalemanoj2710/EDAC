<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>Hello , ${sessionScope.voter.userDetails.name}</h5>
	<h5>${sessionScope.voter.message}</h5>
	<h5>${sessionScope.candidate.message}</h5>
	<h5>
		<a href="candidate_register.jsp">New Candidate Registration</a>
	</h5>
	<h5>
		<a href="admin_logout.jsp">Log Out</a>
	</h5>
</body>
</html>