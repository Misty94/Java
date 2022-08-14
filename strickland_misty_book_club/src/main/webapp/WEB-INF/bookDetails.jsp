<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title><c:out value="${book.title }"/> Details</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="/css/main.css">
</head>
<body>
	<div class="w-75 p-3">
		<div class="d-flex justify-content-between">
			<h1 class="my-2 px-3"><c:out value="${book.title }"/></h1>
			<a href="/books" class="my-2 pe-5">back to the shelves</a>
		</div>
		<div class="w-75 p-3">
			<h4 class="ms-5">Here are <c:out value="${book.user.name }"/>'s thoughts:</h4>
			<p class="ms-5 pt-5"><c:out value="${book.thoughts }"/></p>
		</div>
	</div>
</body>
</html>