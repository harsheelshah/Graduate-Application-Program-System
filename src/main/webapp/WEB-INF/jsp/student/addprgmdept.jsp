<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Programs</title>
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

			<form:form modelAttribute="GappProgram">
				<h3>Department: ${GappDepartment.departmentname}</h3>

				<h3>
					ProgramName:
					<form:input path="programname"></form:input>
					<br>
				</h3>


				<input type="submit" class="btn btn-success" value="Add" name="Add" />
				<input type="hidden" value="${GappDepartment.deptid }name = " deptid"/>
			</form:form>

		</div>
	</div>
</body>
</html>