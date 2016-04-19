<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Additional</title>
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

			<form:form modelAttribute="GappAdditional">
				<h3>
					Select Department: <select name="deptid">
						<c:forEach items="${GappDepartment}" var="s1">
							<option value="${s1.deptid }">${s1.departmentname }</option>
						</c:forEach>
					</select>
				</h3>


				<h3>
					Additional:
					<form:input path="additionalname" required="true"></form:input>
					<br>
				</h3>

				<h3>
					Select Type: <select id="type" name="type">
						<option value="string">String</option>
						<option value="file">File</option>
					</select>
				</h3>

				<br>
				<br>
				<input type="submit" class="btn btn-success" value="Add" name="Add" />
				<input type="hidden" name="type" value="${type }">
			</form:form>

		</div>
	</div>
</body>
</html>