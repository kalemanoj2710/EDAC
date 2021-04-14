<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome Page</title>
</head>
<jsp:useBean id="course" class="beans.CourseBean" scope="application" />
<body>
	<form action="student_details.jsp">
		<table style="background-color: cyan; margin: auto;">
			<caption>All Available Courses</caption>
			<c:forEach var="nm" items="${applicationScope.course.allCourses}">
				<tr>
					<td><input type="radio" name="courseName" value="${nm}"/></td>
					<td>${nm}</td>
				</tr>
			</c:forEach>
			<tr>
				<td><input type="submit" value="Choose Course"></td>
			</tr>
		</table>
	</form>
</body>
</html>