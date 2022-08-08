<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Omikuji Form</title>
<link rel="stylesheet" type="text/css" href="/css/form.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<h1>Send an Omikuji!</h1>
	<form action="/process" method="POST">
		<label>Pick any number from 5 to 25</label>
		<select name="num">
		<c:forEach var = "i" items = "5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25">
			<option value="${i }"><c:out value = "${i}"/></option>
		</c:forEach>
		</select>
		<label>Enter the name of any city.</label>
		<input type="text" name="city" />
		<label>Enter the name of any real person.</label>
		<input type="text" name="person" />
		<label>Enter professional endeavor or hobby.</label>
		<input type="text" name="hobby" />
		<label>Enter any type of living thing.</label>
		<input type="text" name="thing"/>
		<label>Say something nice to someone:</label>
		<textarea name="comment" cols="30" rows="4"></textarea>
		<p>Send and show a friend</p>
		<button type="submit">Send</button>
	</form>
</body>
</html>