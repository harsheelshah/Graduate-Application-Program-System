<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Added Additional</title>
</head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<body>

	<div class="container">
		<br />
		<div class="well">

			<h3>Additional ${GappAdditional.additionalname} Added
				successfully!!</h3>

			<%-- <c:set var = "s1" value="${GappAdditional.deptid}" /> --%>
			<a href="admin.html" class="btn btn-success">Home</a>

		</div>
	</div>
</body>
</html>