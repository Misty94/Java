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
	<link rel="stylesheet" href="/css/details.css">
</head>
<body>
	<div id="container">
		<div class="d-flex justify-content-between">
			<h1><c:out value="${book.title }"/></h1>
			<a href="/books" class="my-2 pe-5">back to the shelves</a>
		</div>
		<div>
			<c:if test="${userId == book.user.id }">
				<p id="optional"><span id="red"><c:out value="${book.user.name }"/></span> read <span><c:out 				value="${book.title }"/></span> by <span id="green"><c:out value="${book.author }"/></span>.</p>
			</c:if>
			<h4>Here are <c:out value="${book.user.name }"/>'s thoughts:</h4>
		</div>
		<div id="thoughts">
			<p><c:out value="${book.thoughts }"/></p>
		</div>
		<div>
			<c:if test="${userId == book.user.id }">
				<a href="/books/${book.id }/edit"><button type="submit" class="btn btn-warning">Edit</button></a> 
			</c:if>
		</div>
	</div>
</body>
</html>