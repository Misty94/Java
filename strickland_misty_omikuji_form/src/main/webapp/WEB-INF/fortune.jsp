<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fortune</title>
<link rel="stylesheet" type="text/css" href="/css/fortune.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<h1>Here's Your Omikuji!</h1>
	<div id="container">
		<p>In ${num } years, you will live in ${city } with ${person } as your roommate, selling ${hobby } for a living. The next time you see a ${thing }, you will have good luck. Also, ${comment}.</p>
	</div>
	<a href="/omikuji">Go Back</a>
</body>
</html>