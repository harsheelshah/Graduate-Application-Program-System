<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">


</head>

<body>

<div class="container">
<br/>
<div class="well">

&nbsp&nbsp&nbsp&nbsp&nbsp<a href="student.html?id=${GappUsers.id }" class="btn btn-success">Back to Home Page</a>
<br><br>

<h1>Hi Student ${GappUsers.firstname}&nbsp&nbsp&nbsp&nbsp<a href="login.html" class="btn btn-success">Logout</a></h1>
<br>
<h1>Welcome to Gapp</h1>
<br><br>



<form:form modelAttribute="GappApplication1"  action="createapplication.html" enctype="multipart/form-data" method="post">

Enter First Name: <form:input path="applicantfirstname"/><br>
Enter Last Name: <form:input path="applicantlastname"/><br>
Enter Email: <form:input path="applicantemail"/><br>
Enter Phone Number: <form:input path="phone"/><br>
Enter Gender: <form:input path="gender"/><br>
Enter DOB: <form:input path="DOB"/><br>
Enter Citizenship: <form:input path="citizenship"/>
If International Student then please enter your TOEFL score:
<form:input path="TOEFL"/>

<br><br>
Select Department:
<select id="dept" name="dept" >
<option value="-----" >Select Department</option>
<c:forEach items="${GappDepartment}" var ="d1">	

<option value="${d1.deptid }" >${d1.departmentname }</option>
</c:forEach>
</select> 
<br><br>

Select Program:
<select id="prgm" name="prgm" >
<option value="---------">Select Program</option>
<%-- <c:forEach items="${GappProgram}" var ="p1">	
<option value="${p1.prgmid }" >${p1.programname }</option>
</c:forEach> --%>
</select> 
<br><br>

Select Term:
<select id="term" name="term" >	
<option value="Fall 2016" >Fall 2016</option>
<option value="Spring 2017" >Spring 2017</option>
</select> 
<br><br>


Educational Background:
<div id="inputs"><br>

				College Name : <input type='text' name='colname' > 
				Time Attended : <input type='text' name='timeattend' > 
				Degree Earned : <input type='text' name='degreeearn' >
				Major : <input type='text' name='major' >
				GPA : <input type='text'  name='gpa' >
<a href="#" class="btn btn-info" onclick="getinput()">Add More Degree</a><br>			
			</div>


<br><br>
Upload Transcript of the Latest University Attended
<input type="file" name="transcript">

<br><br>
<input type="submit" class="btn btn-success" name = "Save" value="Save">&nbsp&nbsp&nbsp&nbsp
<input type="submit" class="btn btn-success" name = "Submit" value="Submit">
<input type="hidden" name="deptid" value="${dept }">
<%-- <input type="hidden" name="prgmid" value="${prgm }"> --%>
<input type="hidden" name="term" value="${term}">
<input type="hidden" name="user" value="${GappUsers.id}">


</form:form>

 <script type="text/javascript" src="//code.jquery.com/jquery-latest.js"></script>
 <script src="js/jquery-1.11.1.js" type="text/javascript"></script>
 

	<script>
	function getinput()
	{
	var colname="<br><br>College Name : <input type='text' name='colname' > ";
	var timeattend="  Time Attended : <input type='text' name='timeattend' > ";
	var degreeearn="  Degree Earned : <input type='text' name='degreeearn' >";
	var major="  Major : <input type='text' name='major' >";
	var gpa="  GPA : <input type='text'  name='gpa' >";

	$("#inputs").append(colname,timeattend,degreeearn,major,gpa);
	"<br>"
	}
	</script> 
	
	
	<script>

	$(document).ready(function() {
		
		$('#dept').change(function(event) {
			var dept = $("select#dept").val();
			$.get("/gapp/student/getProg.html", {
				department : dept
			}, function(jsonResponse) {

				var select = $('#prgm');
				select.find('option').remove();
				$.each(jsonResponse, function(index, value) {
					$('<option>').val(value).text(value).appendTo(select);
				});
			});
		});

	});
</script>
	
	
	
</div>
</div>



</body>
</html>