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
<body>
	<div id="header">
		<h1>Book Club</h1>
		<p>A place for friends to share thoughts on books.</p>
	</div>
	<div id="col-left">
		<h2>Register</h2>
		<form:form action="/register" method="POST" modelAttribute="newUser">
			<div>
				<form:label path="name">Name:</form:label>
				<form:errors path="name" class="d-block text-danger"/>
				<form:input type="text" path="name"/>
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
			<button type="submit" class="btn btn-primary">Submit</button>
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
			<button type="submit" class="btn btn-success">Submit</button>
		</form:form>
	</div>
</body>
</html>