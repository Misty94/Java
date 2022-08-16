<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Book Broker</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="/css/main.css">
</head>
<body class="mt-5 ms-5">
	<div id="header">
		<div id="top">
			<p>Hello, ${currUser.name }. Welcome to..</p>
			<a href="/books">back to the shelves</a>
		</div>
		<h1>The Book Broker!</h1>
	</div>
	<div id="middle">
		<p>Available Books to Borrow</p>
		<table class="table table-hover mx-5 w-75 p-3">
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Author Name</th>
					<th>Owner</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${bookList }">
				<tr>
					<c:choose>
						<c:when test="${book.borrower.id == null }">
							<td><c:out value="${book.id }"/></td>
							<td><a href="/books/${book.id }"><c:out value="${book.title }"/></a></td>
							<td><c:out value="${book.author }"/></td>
							<td><c:out value="${book.user.name }"/></td>
						</c:when>
					</c:choose>
					<c:if test="${userId != book.user.id && book.borrower.id == null }">
						<td>
							<form action="/book/borrow/${book.id }" method="POST">
								<input type="hidden" name="_method" value="put" />
								<button type="submit" class="btn btn-info">Borrow</button>
							</form>
						</td>
					</c:if>
					<c:if test="${userId == book.user.id && book.borrower.id == null }">
						<td>
							<a href="/books/${book.id }/edit"><button type="submit" class="btn btn-warning">Edit</button></a> 
							<form action="/book/delete/${book.id }" method="POST" class="d-inline">
								<input type="hidden" name="_method" value="delete" />
								<button type="submit" class="btn btn-danger">Delete</button>
							</form>
						</td>
					</c:if>
					
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div id="bottom">
		<p>Books I'm borrowing..</p>
		<table class="table table-bordered border-dark mx-5 w-75 p-3">
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Author Name</th>
					<th>Owner</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${bookList }">
					<tr>
						<c:choose>
							<c:when test="${book.borrower.id == userId }">
								<td><c:out value="${book.id }"/></td>
								<td><a href="/books/${book.id }"><c:out value="${book.title }"/></a></td>
								<td><c:out value="${book.author }"/></td>
								<td><c:out value="${book.user.name }"/></td>
								<td>
									<form action="/book/return/${book.id }" method="POST">
										<input type="hidden" name="_method" value="put" />
										<button type="submit" class="btn btn-secondary">Return</button>
									</form>
								</td>
							</c:when>
							<c:otherwise></c:otherwise>
						</c:choose>	
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>