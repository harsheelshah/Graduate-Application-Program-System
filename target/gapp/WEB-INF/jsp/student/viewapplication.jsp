<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student</title>
</head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<body>
<div class="container">
<br/>
<div class="well">
&nbsp&nbsp&nbsp&nbsp&nbsp<a href="student.html?id=${GappUsers.id }" class="btn btn-success">Back to Home Page</a>
<br><br>

<h1>Hi Student ${GappUsers.firstname}&nbsp&nbsp&nbsp&nbsp<a href="login.html" class="btn btn-success">Logout</a></h1>
<br>
<h1>Welcome to Gapp - View Application</h1>
<br><br>

<h3><b>Application Information</b></h3>
<table border = 2>
<tr>
<td><h4><b>DepartmentID</b></h4></td>
<td><h4><b>ProgramID</b></h4></td>
<td><h4><b>Term</b></h4></td>
</tr>

<tr>

<td>${GappDepartment.departmentname}</td>
<td>${GappProgram.programname}</td>
<td>${GappApplication.term}</td>
</tr>
</table>
<br>
<h3><b>Application Personal Information</b></h3>
<table border = 2>
<tr>
<td><h4><b>First Name</b></h4></td>
<td><h4><b>Last Name</b></h4></td>
<td><h4><b>Email</b></h4></td>
<td><h4><b>Phone Number</b></h4></td>
<td><h4><b>Gender</b></h4></td>
<td><h4><b>DOB</b></h4></td>
<td><h4><b>Citizenship</b></h4></td>
</tr>

<tr>

<td>${GappApplication.applicantfirstname}</td>
<td>${GappApplication.applicantlastname}</td>
<td>${GappApplication.applicantemail}</td>
<td>${GappApplication.phone}</td>
<td>${GappApplication.gender}</td>
<td>${GappApplication.DOB}</td>
<td>${GappApplication.citizenship}</td>
</tr>
</table>




<br>
<h3><b>Educational Background:</b></h3>
<table border=2>
<tr>
<td>College Name</td><td>Time Attended</td><td>Degree Earned</td><td>Major</td><td>GPA</td>
</tr>
<c:set var = "ar1" value="${GappApplication.arid}" />
<c:forEach items="${ar1}" var="ar1">
<tr>

<td>${ar1.collegename}</td>
<td>${ar1.timeattended}</td>
<td>${ar1.degreeearned}</td>
<td>${ar1.major}</td>
<td>${ar1.GPA}</td>

</tr>
</c:forEach>
</table>
<br><br>
<c:choose>
<c:when test="${empty GappApplication.transcript.filename}">
<h3><b>Download Transcript</b></h3>
</c:when>
<c:otherwise>
<h3><b>Download Transcript of Latest University Attended:</b></h3>

<a class="btn btn-success" href="../download.html?filename=${GappApplication.transcript.filename }">Download Transcript</a>
</c:otherwise>
</c:choose>
</div>
</div>
</body>
</html>