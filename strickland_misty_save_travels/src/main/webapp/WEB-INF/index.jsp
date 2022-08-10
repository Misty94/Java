<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save Travels</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/index.css">
</head>
<body>
	<div id="top">
		<h1>Save Travels</h1>
		<table class="table table-hover table-striped table-bordered">
			<thead>
				<tr>
					<th class="text-center">Expense</th>
					<th class="text-center">Vendor</th>
					<th class="text-center">Amount</th>
					<th class="text-center">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="expense" items="${expenses }">
				<tr>
					<td class="text-center"><c:out value="${expense.expense }" /></td>
					<td class="text-center"><c:out value="${expense.vendor }" /></td>
					<td class="text-center">$<c:out value="${expense.amount }" /></td>
					<td class="text-center"><a href="/expenses/edit/<c:out value="${expense.id }"/>">edit</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div id="bottom">
		<h3>Add an Expense:</h3>
		<form:form action="/expenses" method="POST" modelAttribute="charge">
			<div class="row mb-3">
				<form:label path="expense" class="col-sm-2 col-form-label">Expense Name:</form:label>
				<form:errors path="expense" class="text-danger"/>
				<div class="col-sm-10"><form:input type="text" path="expense" class="form-control" /></div>
			</div>
			<div class="row mb-3">
				<form:label path="vendor" class="col-sm-2 col-form-label">Vendor:</form:label>
				<form:errors path="vendor" class="text-danger"/>
				<div class="col-sm-10"><form:input type="text" path="vendor" class="form-control" /></div>
			</div>
			<div class="row mb-3">
				<form:label path="amount" class="col-sm-2 col-form-label">Amount:</form:label>
				<form:errors path="amount" class="text-danger"/>
				<div class="col-sm-10"><form:input type="text" path="amount" class="form-control" /></div>
			</div>
			<div class="row mb-3">
				<form:label path="description" class="col-sm-2 col-form-label">Description:</form:label>
				<form:errors path="description" class="text-danger"/>
				<div class="col-sm-10"><form:textarea path="description" cols="30" rows="5" class="form-control"/></div>
			</div>
			<button type="submit">Submit</button>
		</form:form>
	</div>
</body>
</html>