<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login and Registration</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="/css/main.css">
</head>
<body class="w-75 p-3">
	<div id="header">
		<h1 class="text-primary">Project Manager</h1>
		<p>A place for teams to manage projects.</p>
	</div>
	<div id="col-left">
		<h2>Register</h2>
		<form:form action="/register" method="POST" modelAttribute="newUser">
			<div>
				<form:label path="firstName">First Name:</form:label>
				<form:errors path="firstName" class="d-block text-danger"/>
				<form:input type="text" path="firstName"/>
			</div>
			<div>
				<form:label path="lastName">Last Name:</form:label>
				<form:errors path="lastName" class="d-block text-danger"/>
				<form:input type="text" path="lastName"/>
			</div>
			<div>
				<form:label path="email">Email:</form:label>
				<form:errors path="email" class="d-block text-danger"/>
				<form:input type="email" path="email"/>
			</div>
			<div>
				<form:label path="password">Password:</form:label>
				<form:errors path="password" class="d-block text-danger"/>
				<form:input type="password" path="password"/>
			</div>
			<div>
				<form:label path="confirm">Confirm PW:</form:label>
				<form:errors path="confirm" class="d-block text-danger"/>
				<form:input type="password" path="confirm"/>
			</div>
			<button type="submit" class="btn btn-primary mt-3">Submit</button>
		</form:form>
	</div>
	<div id="col-right">
		<h2>Log in</h2>
		<form:form action="/login" method="POST" modelAttribute="newLogin">
			<div>
				<form:label path="email">Email:</form:label>
				<form:errors path="email" class="d-block text-danger"/>
				<form:input type="email" path="email"/>
			</div>
			<div>
				<form:label path="password">Password:</form:label>
				<form:errors path="password" class="d-block text-danger"/>
				<form:input type="password" path="password"/>
			</div>
			<button type="submit" class="btn btn-success mt-3">Submit</button>
		</form:form>
	</div>
</body>
</html>