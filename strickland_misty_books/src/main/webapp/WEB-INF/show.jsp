<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Book</title>
</head>
<body>
	<h1>${oneBook.title }</h1>
	<p>Description: ${oneBook.description }</p>
	<p>Language: ${oneBook.language }</p>
	<p>Number of Pages: ${oneBook.numberOfPages }</p>
	
</body>
</html>