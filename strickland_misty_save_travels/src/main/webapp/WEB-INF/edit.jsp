<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <title>Edit Expenses</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
</head>
<body>
	<div class="mx-5 d-flex justify-content-between align-items-center">
		<h1 class="text-success">Edit Expense</h1>
		<a href="/expenses" class="mx-auto">Go Back</a>
	</div>
	<div class="w-75">
   		<form:form action="/expenses/edit/${charge.id }" method="POST" modelAttribute="charge" class="mx-5">
			<input type="hidden" name="_method" value="put" />
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
			<button type="submit" class="btn btn-primary">Submit</button>
		</form:form>
	</div>
</body>
</html>