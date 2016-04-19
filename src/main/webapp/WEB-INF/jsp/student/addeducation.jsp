<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Education</title>
</head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<body>
	<br>
	<br> &nbsp&nbsp&nbsp&nbsp&nbsp
	<a href="createapplication.html?id=${GappUsers.id}"
		class="btn btn-success">Back to Application Page</a>
	<br>
	<br>
	<div class="container">
		<br />
		<div class="well">
			<h3>
				<b>Add Education Details: </b>
			</h3>
			<br>
			<form:form modelAttribute="GappAcademicRecords">
				<h4>
					College Name:
					<form:input path="collegename"></form:input>
					<br>
				</h4>
				<h4>
					Time Attended:
					<form:input path="timeattended"></form:input>
					<br>
				</h4>
				<h4>
					Degree Earned:
					<form:input path="degreeearned"></form:input>
					<br>
				</h4>
				<h4>
					Major:
					<form:input path="major"></form:input>
					<br>
				</h4>
				<h4>
					GPA:
					<form:input path="GPA"></form:input>
					<br>
				</h4>
				<br>
				<input type="submit" class="btn btn-success" value="Add" name="Add" />
				<input type="hidden" name="user1" value="${GappUsers.id}">
			</form:form>

		</div>
	</div>
</body>
</html>