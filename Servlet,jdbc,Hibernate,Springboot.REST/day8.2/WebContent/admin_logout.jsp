<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--clean up daos --%>
	<h5>Cleaning up of DB resources....</h5>
	${sessionScope.voter.voterDao.cleanUp()}
	${sessionScope.candidate.candidateDao.cleanUp()}
	<%--invalidate session --%>
	${pageContext.session.invalidate()}
	<h5>Logged out successfully...</h5>
	<h5>
		<a href="login.jsp">Visit Again</a>
	</h5>
</body>
</html>