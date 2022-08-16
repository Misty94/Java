<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Change your Entry</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="/css/main.css">
</head>
<body>
	<div class="w-75 p-3">
		<div class="d-flex justify-content-between">
			<h1 class="my-2 px-5">Change your Entry</h1>
			<a href="/books" class="my-2">back to the shelves</a>
		</div>
	</div>
	<div class="ms-5 pt-3">
		<form:form action="/books/${book.id }/edit" method="POST" modelAttribute="book">
			<input type="hidden" name="_method" value="PUT" />
			<div>
				<form:errors path="title" class="d-block text-danger"/>
				<form:label path="title" class="me-5 pb-3">Title</form:label>
				<form:input type="text" path="title"/>
			</div>
			<div>
				<form:errors path="author" class="d-block text-danger"/>
				<form:label path="author" class="me-4 pb-3">Author</form:label>
				<form:input type="text" path="author"/>
			</div>
			<div>
				<form:errors path="thoughts" class="d-block text-danger"/>
				<form:label path="thoughts">My thoughts</form:label>
				<form:textarea path="thoughts" cols="40" rows="3"></form:textarea>
			</div>
			<div>
				<form:hidden path="user" value="${userId }"></form:hidden>
			</div>
			<button type="submit" class="mt-3 btn btn-info">Submit</button>
		</form:form>
	</div>
	<form action="/book/delete/${book.id }" method="POST">
		<input type="hidden" name="_method" value="delete" />
		<button type="submit" class="btn btn-danger mt-5 ms-5">Delete</button>
	</form>
</body>
</html>