<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Department</title>
</head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

<body>
	<br>
	<br> &nbsp&nbsp&nbsp&nbsp&nbsp
	<a href="admin.html" class="btn btn-success">Home</a>
	<br>
	<br>
	<div class="container">

		<br />
		<div class="well">

			<form:form modelAttribute="GappDepartment">

				<h4>
					DepartmentName:
					<form:input path="departmentname"></form:input>
					<br>
				</h4>
				<br>
				<input type="submit" class="btn btn-success" value="Add" name="Add" />
			</form:form>

		</div>
	</div>
</body>
</html>