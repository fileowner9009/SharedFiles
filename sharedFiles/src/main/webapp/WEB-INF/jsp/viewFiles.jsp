<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="path" value="pageContext.request.contextPath"/>

<html lang="en">
<head>

	<!-- Access the bootstrap Css like this,
		Spring boot will handle the resource mapping automcatically -->
	<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

	<!--
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
	<c:url value="/css/main.css" var="jstlCss" />
	<link href="${jstlCss}" rel="stylesheet" />

</head>
<body>

	<div class="container">
		<div class="starter-template">
			<h1>Files</h1>
			
			<table>
				<c:forEach items="${files}" var="file"> 
					<tr>
						<th>Name</th>
						<th>View File</th>
					</tr>
   					 <tr>
       		 			<td><c:out value="${file.name}"/></td>
        				<td><a href="/viewFile/${file.name}"> View File </a></td>  
        				
    				</tr>
				</c:forEach>
				
			</table>
		</div>
	</div>

	<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>