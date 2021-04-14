<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:useBean id="voter" class="beans.VoterBean" scope="session" />
<jsp:setProperty property="*" name="voter"/>
<body>
<%--session.getAttribute("voter").validateUser() --%>
<h5>Authentication Status : ${sessionScope.voter.validateUser()}</h5>
</body>
</html>