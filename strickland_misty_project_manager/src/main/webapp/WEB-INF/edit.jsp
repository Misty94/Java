<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Edit Project</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="/css/main.css">
</head>
<body>
	<h1>Edit Project</h1>
	<div class="ms-5 pt-3">
		<form:form action="/projects/edit/${project.id }" method="POST" modelAttribute="project">
			<input type="hidden" name="_method" value="PUT" />
			<div>
				<form:errors path="title" class="d-block text-danger"/>
				<form:label path="title" class="me-5 pb-3">Project Title:</form:label>
				<form:input type="text" path="title"/>
			</div>
			<div>
				<form:errors path="description" class="d-block text-danger"/>
				<form:label path="description" class="me-4 pb-3">Project Description:</form:label>
				<form:textarea path="description" cols="40" rows="3"/>
			</div>
			<div>
				<form:errors path="dueDate" class="d-block text-danger"/>
				<form:label path="dueDate">Due Date:</form:label>
				<form:input type="date" path="dueDate"/>
			</div>
			<div>
				<form:hidden path="lead" value="${userId }"></form:hidden>
			</div>
			<button type="submit" class="mt-3 btn btn-info">Submit</button>
		</form:form>
		<a href="/dashboard"><button type="submit" class="btn btn-secondary mt-3" >Cancel</button></a>
	</div>
</body>
</html>