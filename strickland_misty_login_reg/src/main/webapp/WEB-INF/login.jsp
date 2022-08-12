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
		<h1>Welcome!</h1>
		<p>Join our growing community.</p>
	</div>
	<div id="col-left">
		<h1>Register</h1>
		<form:form action="/register" method="POST" modelAttribute="newUser">
			<div>
				<form:label path="username" >User Name</form:label>
				<form:errors path="username" class="text-danger" />
				<form:input path="username" type="text" />
			</div>
			<div>
				<form:label path="email" >Email</form:label>
				<form:errors path="email" class="text-danger" />
				<form:input path="email" type="email" />
			</div>
			<div>
				<form:label path="password" >Password</form:label>
				<form:errors path="password" class="text-danger" />
				<form:input path="password" type="password"/>
			</div>
			<div>
				<form:label path="confirm" >Confirm PW </form:label>
				<form:errors path="confirm" class="text-danger" />
				<form:input path="confirm" type="password"/>
			</div>
			<button type="submit">Submit</button>
		</form:form>
	</div>
	<div id="col-right">
			<h1>Log in</h1>
			<form:form action="/login" method="POST" modelAttribute="newLogin">
			<div>
				<form:label path="email" >Email</form:label>
				<form:errors path="email" class="text-danger" />
				<form:input path="email" type="email"/>
			</div>
			<div>
				<form:label path="password" >Password</form:label>
				<form:errors path="password" class="text-danger" />
				<form:input path="password" type="password"/>
			</div>
			<button type="submit">Submit</button>
		</form:form>
	</div>
</body>
</html>