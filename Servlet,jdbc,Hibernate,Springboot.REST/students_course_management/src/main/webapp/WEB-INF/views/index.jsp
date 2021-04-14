<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- import spring supplied jsp libraries -->
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Enrollment Platform</title>
</head>
<body>
<h2 class="display-3">Welcome to Student Enrollment System</h5>
<%--tag used for URL rewriting --%>
<h5><a href="<spring:url value='/courses/list'/>">List Courses</a></h5>

<%--To understand path variable --%>
<%-- <h5><a href="<spring:url value='/product/show/10/mango/100/2020-05-15'/>">Test Path Varibales</a></h5> --%>

<%-- <h5><a href="<spring:url value='/product/show2/10/mango/100/2020-05-15'/>">Test Path Varibales</a></h5> --%>
</body>
</html>