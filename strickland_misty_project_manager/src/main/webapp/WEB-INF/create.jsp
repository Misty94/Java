<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Create a Project</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="/css/main.css">
</head>
<body>
	<h1>Create a Project</h1>
	<div class="ms-5 pt-3">
		<form:form action="/projects/new" method="POST" modelAttribute="project">
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
				<!--We need this to connect the project to the user (lead) who is creating it.-->
				<form:hidden path="lead" value="${userId }"></form:hidden>
				<!--I joined the tables using a column named lead_id.-->
			</div>
			<button type="submit" class="mt-3 btn btn-info">Submit</button>
		</form:form>
		<a href="/dashboard"><button type="submit" class="btn btn-secondary mt-3" >Cancel</button></a>
	</div>
</body>
</html>