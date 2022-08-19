<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>${song.title }</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="/css/main.css">
</head>
<body class="w-75 p-3">
	<div>
		<a href="/dashboard">Dashboard</a>
	</div>
	<div>
		<p class="me-5">Title <span class="ms-5">${song.title }</span></p>
		<p class="me-5">Artist <span class="ms-5">${song.artist }</span></p>
		<p class="me-5">Rating (1-10) <span class="ms-5">${song.rating }</span></p>
	</div>
	<div>
		<form action="/song/${song.id }/delete" method="POST">
			<input type="hidden" name="_method" value="DELETE" />
			<input type="submit" value="Delete" class="btn btn-danger"/>
		</form>
	</div>
</body>
</html>