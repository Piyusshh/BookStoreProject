<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Internal Server Error</title>
</head>
<body>
	<div align="center">
	<div>
		<img src="${pageContext.request.contextPath}images/BookstoreLogo.png" />
	</div>
	<div>
		<h2>Sorry The Sever has encountered an error while fulfilling your request</h2>
		<h3>Please Check Back Later or Contact our Administrator</h3>
	</div>
	<div>
		<a href="javascript:history.go(-1)">Go Back</a>
	</div>
	</div>
</body>
</html>