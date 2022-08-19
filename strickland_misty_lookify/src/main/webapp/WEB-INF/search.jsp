<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Search by Artist</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="/css/main.css">
</head>
<body class="w-75 p-3">
	<div>
		<p>Songs by artist: ${artist }</p>
		<form action="/search" method="POST">
				<input type="text" name="artist" placeholder="Search"/>
				<input type="submit" value="Submit" class="btn btn-success"/>
			</form>
			<table class="table table-bordered border-dark mx-5">
			<thead>
				<tr>
					<th>Name</th>
					<th>Rating</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="songs" items="${artistSongs }">
				<tr>
					<td><a href="/songs/${songs.id }"><c:out value="${songs.title }"/></a></td>
					<td><c:out value="${songs.rating }"/></td>
					<td>
						<form action="/song/${songs.id }/delete" method="POST">
							<input type="hidden" name="_method" value="delete" />
							<input type="submit" value="Delete" class="btn btn-danger"/>
						</form>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>