<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Top Ten</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="/css/main.css">
</head>
<body class="w-75 p-3">
	<p>Top Ten Songs</p>
	<div>
		<ul>
			<c:forEach var="top" items="${topTen }">
			<li><c:out value="${top.rating }"/> <span> - </span><a href="/songs/${top.id }"><c:out value="${top.title }"/></a><span> - </span> <c:out value="${top.artist }"/></li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>