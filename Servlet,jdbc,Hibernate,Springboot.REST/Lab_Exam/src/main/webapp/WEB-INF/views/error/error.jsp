<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Page</title>
</head>
<body>
We are sorry that you face the below error. Please try again with different parameters.<br>
Error Message: ${requestScope.error.message}<br>
Error Details: ${requestScope.error.errDetails}<br>

</body>
</html>