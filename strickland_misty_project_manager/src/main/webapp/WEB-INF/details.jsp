<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Project Details</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="/css/main.css">
</head>
<body>
	<div class="mx-5 py-4 d-flex justify-content-between align-items-center">
		<h1>Project Details</h1>
		<a href="/dashboard" class="mx-auto">Back to Dashboard</a>
	</div>
	<div class="ms-5">
		<p class="mt-5">Project: <span><c:out value="${project.title }"/></span></p>
		<p class="mt-5">Description: <span><c:out value="${project.description }"/></span></p>
		<p class="mt-5">Due Date: <span><fmt:formatDate type="date" dateStyle="short" value="${project.dueDate }"/></span></p>
	</div>
	<div class="me-5 d-flex justify-content-end w-75 p-3">
		<form action="/projects/delete/${project.id }" method="POST">
			<input type="hidden" name="_method" value="DELETE" />
			<button type="submit" class="btn btn-danger">Delete Project</button>
		</form>
	</div>
</body>
</html>