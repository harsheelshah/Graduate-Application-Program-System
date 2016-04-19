<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%-- <jsp:useBean id="c" class="gapp.StudentController" scope="application" /> --%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
</head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

<body>

	<div class="container">
		<h2>
			Hi Admin &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp <a href="login.html"
				class="btn btn-success">Logout</a>
		</h2>

		<h1>Welcome to Gapp</h1>

		<table border=2>
			<tr>
				<!-- <td><b>Departmentid</b></td> -->
				<td><b><h2>DepartmentName</h2></b></td>
				<td><b><h2>No of Programs</h2></b></td>
				<td><h2>View</h2></td>
			</tr>

			<c:forEach items="${GappDepartment}" var="dept">
				<tr>
					<%-- <td>${dept.deptid}</td> --%>
					<td><h4>${dept.departmentname}</h4></td>
					<td><h4>${fn:length(dept.prgmid)}</h4></td>
					<td><h4>
							<a href="editdept.html?deptid=${dept.deptid}"
								class="btn btn-success">View</a>
						</h4></td>
			</c:forEach>

		</table>
		<br>
		<br> <a href="adddept.html" class="btn btn-success">Add New
			Department</a>&nbsp&nbsp&nbsp&nbsp <a href="addprgm.html"
			class="btn btn-success">Add New Program</a>&nbsp&nbsp&nbsp&nbsp <a
			href="addadditional.html" class="btn btn-success">Add New
			Additional</a>

	</div>
</body>
</html>