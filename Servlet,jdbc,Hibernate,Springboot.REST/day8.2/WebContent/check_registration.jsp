<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--import JSTL suplied core tag lib --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:useBean id="candidate" class="beans.CandidateBean" scope="session" />
<jsp:setProperty property="*" name="candidate" />
<body>
	<%-- WC :  response.sendRedirect(response.encodeRedirectURL(session.getAttribute("candidate").validateNRegisterUser().concat(".jsp")--%>
	<c:redirect url="${sessionScope.candidate.validateNRegisterUser()}.jsp" />
</body>
</html>