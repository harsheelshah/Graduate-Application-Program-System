<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student</title>
</head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<body>
	<div class="container">
		<br />
		<div class="well">


			<h1>
				Hi Student ${GappUsers.firstname}&nbsp&nbsp&nbsp&nbsp<a
					href="login.html" class="btn btn-success">Logout</a>
			</h1>
			<br>
			<h1>Welcome to Gapp</h1>
			<br>
			<br>

			<h4>
				<a href="createapplication.html?id=${GappUsers.id }">New
					Application</a>
			</h4>
			<br>
			<br>


			<table border=2>
				<tr>
					<td><h4>
							<b>Application ID</b>
						</h4></td>
					<td><h4>
							<b>DepartmentName</b>
						</h4></td>
					<td><h4>
							<b>ProgramName</b>
						</h4></td>
					<td><h4>
							<b>Term</b>
						</h4></td>
					<td><h4>
							<b>Date Applied</b>
						</h4></td>
					<td><h4>
							<b>Status</b>
						</h4></td>
					<td><h4>
							<b>Edit</b>
						</h4></td>
					<td><h4>
							<b>View</b>
						</h4></td>
				</tr>

				<c:forEach items="${GappApplication}" var="a1">
					<c:set var="p1" value="${a1.prgmid}" />
					<c:set var="d1" value="${p1.deptid}" />
					<c:set var="s1" value="${a1.statusid}" />

					<tr>
						<td>${a1.appid}</td>
						<td>${d1.departmentname}</td>
						<td>${p1.programname}
						<td>${a1.term}</td>
						<td>${a1.date}</td>

						<td>${s1.name}</td>
						<c:choose>
							<c:when test="${s1.name=='Not Submitted'}">
								<td><a
									href="editapplication.html?id=${GappUsers.id}&&deptid=${d1.deptid}&&prgmid=${p1.prgmid}&&appid=${a1.appid}">Edit</a></td>
							</c:when>
							<c:otherwise>
								<td>Edit</td>
							</c:otherwise>
						</c:choose>
						<td><a
							href="viewapplication.html?id=${GappUsers.id}&&deptid=${d1.deptid}&&prgmid=${p1.prgmid}&&appid=${a1.appid}">View</a>
					</tr>
				</c:forEach>



			</table>




		</div>
	</div>

</body>
</html>