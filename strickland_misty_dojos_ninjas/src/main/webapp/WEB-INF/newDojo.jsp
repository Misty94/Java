<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Add a New Dojo</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="/css/main.css">
</head>
<body>
	<h1 class="p-5">New Dojo</h1>
	<form:form action="/dojos/new" method="POST" modelAttribute="DOJO" class="ms-5">
		<form:label path="name">Name: </form:label>
		<form:errors path="name" />
		<form:input type="text" path="name" />
		<p><button type="submit" class="mt-4 btn btn-info">Create</button></p>
	</form:form>
</body>
</html>