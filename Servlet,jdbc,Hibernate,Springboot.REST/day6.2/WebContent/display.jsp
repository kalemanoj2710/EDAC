<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4 align="center">
		Session ID
		<%=session.getId()%></h4>
	<h5>
		Email :
		<%
		out.print(request.getParameter("em"));
	%>
	</h5>
	<h5>
		Password :
		<%
		out.print(request.getParameter("pass"));
	%>
	</h5>
	<hr>
	<h4>Display email n password using JSP expression</h4>
	<h5>
		Email :
		<%=request.getParameter("em")%>

	</h5>
	<h5>
		Password  :
		<%=request.getParameter("pass")%>

	</h5>
	<hr>
	<h4>Display email n password using EL syntax</h4>
	<%--WC : out.print(request.getParamter("em"); --%>
	<h5>Email : ${param.em}</h5>
	<h5>Password : ${param.pass}</h5>
	<h5>param map : ${param}</h5>
	<h5> JDBC Driver : ${initParam.drvr}</h5>
	<h5> User Name : ${initParam.user_name}</h5>
	<%--WC : out.print(cookie.get("JSESSIONID").getValue()) --%>
	<h5>Value of a Cookie JSESSIONID : ${cookie.JSESSIONID.value}</h5>
	
</body>
</html>