<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

<body>

	<div class="container">

		<div class="well">
			<form:form modelAttribute="GappUsers">
				<br>
				<h3>
					First Name:
					<form:input path="firstname" required='true' />
					<form:errors path="firstname" />
				</h3>
				<h3>
					Last Name:
					<form:input path="lastname" required='true' />
					<form:errors path="lastname" />
				</h3>
				<h3>
					Email:
					<form:input path="email" required='true' />
					<c:if test="${emailerror != null}">
						<c:out value="${emailerror}" />
					</c:if>
					<form:errors path="email" />
				</h3>

				<h3>
					Password:
					<form:input path="password" required='true' />
					<form:errors path="password" />
				</h3>
				<br>
				<a href="login.html" class="btn btn-success"
					style="margin-right: 15px;">Back</a>
				<input type="submit" value="Register" class="btn btn-success"
					name="Register" />

			</form:form>
		</div>
	</div>

</body>
</html>