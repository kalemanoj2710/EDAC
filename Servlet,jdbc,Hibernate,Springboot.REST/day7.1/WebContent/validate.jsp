<%@page import="pojos.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%!private String correctName, correctPassword;

	//for one 
	public void jspInit() {
		correctName = "abc";
		correctPassword = "1234";
	}%>
<body>
	<h5>From 1st page.....</h5>
	<%
		if (request.getParameter("name").equals(correctName) &&
				request.getParameter("pass").equals(correctPassword)) {
		//correct login : store user details under suitable scope : session (since clnt Pull II : redirect)
		session.setAttribute("user_details", new User(correctName, correctPassword));
		//clnt pull
		response.sendRedirect(response.encodeRedirectURL("details.jsp"));
		//WC sends resp : SC 302 | loacation=details.jsp;jsessionid=dfgfdg756e76 | body :EMPTY
	} else {
	%>
	<h5 style="color: red;">
		Invalid Login , Please <a href="login.jsp">Retry </a>
	</h5>
	<%
		}
	%>
</body>
</html>