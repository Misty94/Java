<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fruity Loops</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<h1>Fruit Store</h1>
	<div id="container">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Name</th>
					<th>Price</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="fruit" items="${fruits }">
				<tr>
					<td><c:out value="${fruit.getName() }" /></td>
					<td><c:out value="${fruit.price }" /></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>