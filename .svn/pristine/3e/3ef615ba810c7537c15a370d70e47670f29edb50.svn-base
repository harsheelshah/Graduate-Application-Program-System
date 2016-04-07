<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Department</title>
</head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<body>

<div class="container">
<br/>
<div class="well">

<a href="admin.html" class="btn btn-success">Home</a>
<br><br>

<form:form modelAttribute="GappDepartment">
<h4><b>DepartmentName:</b><form:input path="departmentname"/>
<input type="submit" class="btn btn-success" name="save" value="Save"></h4>
</form:form>
<br>

<h4><b>Add/Remove programs:</b></h4>

<table border = 2>
<c:set var = "s1" value="${GappDepartment.prgmid}" />
<tr><!-- <td>ProgramId</td> --><td><h4><b>ProgramName</b></td><td><b>Remove</b></td></h4></tr>
<c:forEach items="${s1}" var="s1">

<tr><%-- <td>${s1.prgmid}</td> --%>
 <td><h4>${s1.programname}</h4></td>  
<td><h4><a href="removeprgm.html?prgmid=${s1.prgmid}" class="btn btn-success" >Remove</a></h4></td></tr>
</c:forEach>
</table>
<br>
<h7><a href="addprgmdept.html?deptid=${GappDepartment.deptid }" class="btn btn-success">Add Programs</a></h7>

<br><br>
<h4><b>Add/Remove Additional:</b></h4>

<table border = 2>
<c:set var = "s2" value="${GappDepartment.additionalid }" />
<tr><!-- <td>Additional ID</td> --><td><h4><b>Additional Name</b></td><td><b>Remove</h4></b></td></tr>
<c:forEach items="${s2}" var="s2">

<tr><%-- <td>${s2.additionalid}</td> --%>
 <td><h4>${s2.additionalname}</h4></td>  
<td><h4><a href="removeadditional.html?additionalid=${s2.additionalid}" class="btn btn-success">Remove</a></h4></td></tr>
</c:forEach>
</table>

<br>
<a href="addadditionaldept.html?deptid=${GappDepartment.deptid }" class="btn btn-success">Add Additional</a>



</div>
</div>
</body>
</html>