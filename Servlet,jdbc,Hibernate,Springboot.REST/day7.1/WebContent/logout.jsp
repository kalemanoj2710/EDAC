<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h5>from logout page...</h5>
	<h5>Session ID : ${pageContext.session.id}</h5>
	<%--session.getAttribute("user_details").getName() --%>
	<h5>Hello , ${sessionScope.user_details.name}</h5>
	<%--invalidate Http Session --%>
	<%-- <%
		session.invalidate();
	%> --%>
	<%--EL syntax CAN invoke regular java methods : ret void --%>
	<%--pageContext.getSession().invalidate() --%>
	${pageContext.session.invalidate()}
	<h5>You have logged out....</h5>
	<h5>
		<a href="index.jsp">Visit Again</a>
	</h5>
</body>
</html>