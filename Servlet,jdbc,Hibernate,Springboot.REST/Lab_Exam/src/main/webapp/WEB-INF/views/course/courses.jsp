<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Course List</title>
</head>
<body>
<div align="center">
<h4>${requestScope.response}</h4>
<table>
<tr>
<td>Course Name</td>
<td>Click for Delete</td>
<td>Click to Add Student</td>
</tr>
<c:forEach var="course" items="${requestScope.courses}">
<tr>
<td>${course.name}</td>
<td>
<a href="/course/delete?courseId=${course.id}">Delete</a>
</td>
<td>
<a href="/course/addstudent?courseId=${course.id}">Add Student</a>
</td>
</tr>
</c:forEach>
</table>
</div>

</body>
</html>