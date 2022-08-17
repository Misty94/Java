<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Dashboard</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="/css/main.css">
</head>
<body>
	<div class="w-75 p-3">
		<div class="d-flex justify-content-between">
			<h3 class="my-2 px-5">Welcome, ${currUser.firstName }!</h3>
			<a href="/logout" class="my-2">logout</a>
		</div>
		<div class="d-flex justify-content-between">
			<p class="my-2 px-5">All Projects</p>
			<a href="/projects/new"><button type="submit" class="btn btn-success">+ new project</button></a>
		</div>
	</div>
	<div id="middle">
		<table class="table table-bordered border-dark mx-5 w-75 p-3">
			<thead>
				<tr>
					<th>Project</th>
					<th>Team Lead</th>
					<th>Due Date</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="project" items="${projectList }">
				<tr>
					<c:choose>
						<c:when test="${userId != project.lead.id}">
							<td><a href="/projects/${project.id }"><c:out value="${project.title }"/></a></td>
							<td><c:out value="${project.lead.firstName }"/></td>
							<td><fmt:formatDate type="date" pattern="MMMM dd" value="${project.dueDate }"/></td>
							<td>
								<form action="/project/join/${project.id }" method="POST">
									<input type="hidden" name="_method" value="put" />
									<button type="submit" class="btn btn-info">Join Team</button>
								</form>
							</td>
						</c:when>
					</c:choose>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="mt-5">
		<p class="ms-5">Your Projects</p>
		<table class="table table-bordered border-dark mx-5 w-75 p-3">
			<thead>
				<tr>
					<th>Project</th>
					<th>Team Lead</th>
					<th>Due Date</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="project" items="${projectList }">
				<tr>
					<c:choose>
						<c:when test="${userId == project.lead.id || project.users.contains(user) }">
							<td><a href="/projects/${project.id }"><c:out value="${project.title }"/></a></td>
							<td><c:out value="${project.lead.firstName }"/></td>
							<td><fmt:formatDate type="date" pattern="MMMM dd" value="${project.dueDate }"/></td>
						</c:when>
					</c:choose>
					<c:if test="${userId == project.lead.id }">
						<td>
							<a href="/projects/edit/${project.id }"><button type="submit" class="btn btn-warning">Edit</button></a> 
						</td>
					</c:if>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>