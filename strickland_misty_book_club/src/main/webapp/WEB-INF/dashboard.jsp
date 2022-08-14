<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Book Club Dashboard</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="/css/main.css">
</head>
<body>
	<div class="w-75 p-3">
		<div class="d-flex justify-content-between">
			<h1 class="my-2 px-5">Welcome, ${currUser.name }</h1>
			<a href="/logout" class="my-2">logout</a>
		</div>
		<div class="d-flex justify-content-between">
			<p class="my-2 px-5">Books from everyone's shelves:</p>
			<a href="/books/new">+ Add a book to my shelf!</a>
		</div>
	</div>
	<div class="w-75 p-3">
		<table class="table table-bordered border-dark mx-5">
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Author Name</th>
					<th>Posted By</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${bookList }">
				<tr>
					<td><c:out value="${book.id }"/></td>
					<td><a href="/books/${book.id }"><c:out value="${book.title }"/></a></td>
					<td><c:out value="${book.author }"/></td>
					<td><c:out value="${book.user.name }"/></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
</body>
</html>