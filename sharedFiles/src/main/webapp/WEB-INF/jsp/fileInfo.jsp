<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="path" value="pageContext.request.contextPath" />
<%@ page contentType="text/html; charset=UTF-8"%>
<html lang="en">
<head>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.7.js"
	type="text/javascript"></script>
<!-- Access the bootstrap Css like this,
		Spring boot will handle the resource mapping automcatically -->
<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
<!--

	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />

<!-- script>
	$(document).ready(function() {
		$('.editbtn').click(function() {
			var $this = $(this);
			var tds = $this.closest('tr').find('td').filter(function() {
				return $(this).find('.editbtn').length === 0;
			});
			if ($this.html() === 'Edit') {
				$this.html('Save');
				tds.prop('contenteditable', true);
			} else {
				$this.html('Edit');
				tds.prop('contenteditable', false);
			}
		});
	});
</script> -->
</head>

<body>
	<form:form method="post" action="/saveFile"
		modelAttribute="fileContentsBean">

		<div class="container">
			<button type="submit" name="Action" value="Submit">Save</button>
			<div class="starter-template">
				<h1>File Contents</h1>
				<table border="1">
					<thead>
						<tr>
							<th class="col1">City</th>
							<th class="col2">State</th>
							<th class="col3">Country</th>
							<th />
						</tr>
					</thead>

					<c:forEach items="${fileContentsBean.fileRows}" varStatus="vs">
						<div class="field">
							<tr>
								<td><form:input path="fileRows[${vs.index}].city" /></td>
								<td><form:input path="fileRows[${vs.index}].state" /></td>
								<td><form:input path="fileRows[${vs.index}].country" /></td>
							</tr>
						</div>
					</c:forEach>

				</table>
			</div>

		</div>

		<h1>Add</h1>
		<table border="1">
			<thead>
				<tr>
					<th class="col1">City</th>
					<th class="col2">State</th>
					<th class="col3">Country</th>
					<th />
				</tr>
			</thead>

			<tr>
				<td><form:input path="newCityName" /></td>
				<td><form:input path="newStateName" /></td>
				<td><form:input path="newCountryName" /></td>
			</tr>

		</table>

		<button type="submit" name="Action" value="Submit" >Add</button>

	</form:form>
</body>

</html>