<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Add a Song</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="/css/main.css">
</head>
<body>
	<h3>Add an Expense:</h3>
		<form:form action="/songs/new" method="POST" modelAttribute="song">
			<div class="row mb-3">
				<form:label path="title" class="col-sm-2 col-form-label">Title</form:label>
				<form:errors path="title" class="text-danger"/>
				<div class="col-sm-10"><form:input type="text" path="title" class="form-control" /></div>
			</div>
			<div class="row mb-3">
				<form:label path="artist" class="col-sm-2 col-form-label">Artist</form:label>
				<form:errors path="artist" class="text-danger"/>
				<div class="col-sm-10"><form:input type="text" path="artist" class="form-control" /></div>
			</div>
			<div class="row mb-3">
				<form:label path="rating" class="col-sm-2 col-form-label">Rating (1-10)</form:label>
				<form:errors path="rating" class="text-danger"/>
				<div class="col-sm-10"><form:input type="number" path="rating" class="form-control" /></div>
			</div>
			<button type="submit" class="btn btn-primary">Add Song</button>
		</form:form>
</body>
</html>