<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>New Ninja Form</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="/css/main.css">
</head>
<body>
	<h1 class="p-4">New Ninja</h1>
	<form:form action="/ninjas/new" method="POST" modelAttribute="ninja" class="ms-5">
		<div class="mb-3">
		<!--The path name for this label & select comes from the mappedBy name on the Dojo model-->
			<form:label path="dojo" class="me-5">Dojo</form:label> 
			<form:select path="dojo">
				<c:forEach var="eachDojo" items="${dojoList }">
					<form:option value="${eachDojo.id }"> ${eachDojo.name }</form:option>
				</c:forEach>
			</form:select>
		</div>
		<div class="mb-3">
			<form:label path="firstName">First Name: </form:label>
			<form:errors path="firstName" />
			<form:input type="text" path="firstName" />
		</div>
		<div class="mb-3">
			<form:label path="lastName">Last Name: </form:label>
			<form:errors path="lastName" />
			<form:input type="text" path="lastName" />
		</div>
		<div class="mb-3">
			<form:label path="age" class="me-5">Age: </form:label>
			<form:errors path="age" />
			<form:input type="number" path="age" />
		</div>
		
		<p><button type="submit" class="mt-4 btn btn-warning">Create</button></p>
	</form:form>
</body>
</html>