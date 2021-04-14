<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Courses</title>
</head>
<body>
<h2>On list courses page</h2>

<table class="table table-striped">
		
		<tr>
		<th>Course ID</th>
		<th>Course Name</th>
		<th>Select</th>
		<th>Delete</th>
		</tr>
			<c:forEach var="b" items="${requestScope.courses_list}">
		 <tr>
			<td>${b.courseid}</td>
			<td>${b.subject}</td>
			<td><a href='<spring:url value="/student/addmission?bid=${b.courseid}"></spring:url>'>Select</a></td> 
			<td><a href='<spring:url value="/courses/delete?bid=${b.courseid}"></spring:url>'>Delete Course</a></td> 
		</tr> 
		</c:forEach>
	</table> 
</body>
</html>