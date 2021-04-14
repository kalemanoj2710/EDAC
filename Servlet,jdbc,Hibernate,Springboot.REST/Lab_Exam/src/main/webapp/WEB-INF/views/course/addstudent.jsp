<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student</title>
</head>
<body>
<div align="center">
<form:form action="/course/addstudent" method="post" modelAttribute="student">
<input type="hidden" name="courseId" value="${requestScope.courseId}">
<table>
<tr>
<td colspan="2" align="center">Student Admission Form</td>
</tr>
<tr>
<td>Name</td>
<td>
<form:input path="name"/>
<form:errors path="name"/>
</td>
</tr>
<tr>
<td>Address</td>
<td>
<form:input path="address"/>
<form:errors path="address"/>
</td>
</tr>
<tr>
<td>Date of Birth</td>
<td>
<form:input type="date" path="dob"/>
<form:errors path="dob"/>
</td>
</tr>
<tr>
<td>CGPA</td>
<td>
<form:input path="cgpa"/>
<form:errors path="cgpa"/>
</td>
</tr>
<tr>
<td colspan="2" align="center">
<input type="submit"  value="Admit Student">
</td>
</tr>



</table>
</form:form>
</div>
</body>
</html>