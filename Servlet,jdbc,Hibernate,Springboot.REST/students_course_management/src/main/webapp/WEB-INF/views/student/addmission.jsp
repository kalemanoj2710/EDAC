<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Admission Page</title>
</head>
<body>
<h3>Student Admission & Validation form</h3>
<h2 style="color: red">${requestScope.error}</h2>
<form:form method="post" modelAttribute="student">
			<table>
				<tr>
					<td>Student ID: </td>
					<td><input type="text" name="studentId" required="required"></td>
				</tr>
			
				<tr>
					<td>Student Name: </td>
					<td><input type="text" name="name" required="required"></td>
				</tr>
				<tr>
					<td>Address </td>
					<td><input type="text" name="address" required="required"></td>
				</tr>
				<tr>
					<td>Date of Birth</td>
					<td><input type="date" name="dob" required="required"></td>
				</tr>
				<tr>
					<td>CGPA</td>
					<td><input type="number" name="cgpa" required="required"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Enter Details"></td>
					<td></td>
				</tr>
			</table>
	</form:form> 

</body>
</html>