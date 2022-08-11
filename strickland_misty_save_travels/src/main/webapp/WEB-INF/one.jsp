<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <title>Full CRUD Save Expenses</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="/css/one.css">
</head>
<body>
	<div class="mx-5 py-4 d-flex justify-content-between align-items-center">
		<h1 class="text-primary">Expense Details</h1>
		<a href="/expenses" class="mx-auto">Go Back</a>
	</div>
	<div id="container">
		<div class="col-left">
			<p>Expense Name:</p>
			<p>Expense Description:</p>
			<p>Vendor:</p>
			<p>Amount Spent:</p>
		</div>
		<div class="col-right">
			<p><c:out value="${oneExpense.expense }"/></p>
			<p><c:out value="${oneExpense.description }"/></p>
			<p><c:out value="${oneExpense.vendor }"/></p>
			<p>$<c:out value="${oneExpense.amount }"/></p>
		</div>
	</div>
</body>
</html>