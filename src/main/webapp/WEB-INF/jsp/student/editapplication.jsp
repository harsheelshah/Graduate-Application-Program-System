<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student</title>
</head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<body>
	<div class="container">
		<br />
		<div class="well">

			&nbsp&nbsp&nbsp&nbsp&nbsp<a href="student.html?id=${GappUsers1.id }"
				class="btn btn-success">Back to Home Page</a> <br>
			<br>


			<h1>
				Hi Student ${GappUsers1.firstname}&nbsp&nbsp&nbsp&nbsp<a
					href="login.html" class="btn btn-success">Logout</a>
			</h1>
			<br>
			<h1>Welcome to Gapp - Edit Application</h1>
			<br>
			<br>

			<form:form modelAttribute="GappApplication1"
				action="editapplication.html" enctype="multipart/form-data"
				method="post">

				<h4>
					<b>DepartmentName : ${GappDepartment.departmentname}</b>
				</h4>

				<br>
				<h4>
					<b>ProgramName : <select id="prgm" name="prgm">
							<c:forEach items="${GappDepartment.prgmid }" var="p1">
								<option value="${p1.prgmid }"
									${p1.prgmid == GappProgram.prgmid ?'selected' : '' }>${p1.programname }</option>
							</c:forEach>
					</select></b>
				</h4>
				<br>


				<h4>
					<b>Term : <select id="term" name="term">
							<option value="Fall 2016"
								${GappApplication1.term == 'Fall 2016,' ?'selected' : '' }>Fall
								2016</option>
							<option value="Spring 2017"
								${GappApplication1.term == 'Spring 2017,' ?'selected' : '' }>Spring
								2017</option>
					</select>
					</b>
				</h4>
				<br>

				<%-- <h4><b>Term:<form:input path="term"/></b></h4> --%>

				<h4>
					<b>First Name:<form:input path="applicantfirstname" /></b>
				</h4>
				<h4>
					<b>Last Name:<form:input path="applicantlastname" /></b>
				</h4>
				<h4>
					<b>Email:<form:input path="applicantemail" /></b>
				</h4>
				<h4>
					<b>Phone:<form:input path="phone" /></b>
				</h4>
				<h4>
					<b>Citizenship:<form:input path="citizenship" /></b>
				</h4>
				<h4>
					<b>Gender:<form:input path="gender" /></b>
				</h4>
				<h4>
					<b>DOB:<form:input path="DOB" /></b>
				</h4>
				<h4>
					<b>TOEFL(if international student):<form:input path="TOEFL" /></b>
				</h4>

				<br>


				<h3>
					<b>Educational Background:</b>
				</h3>
				<table border=2>
					<tr>
						<td>College Name</td>
						<td>Time Attended</td>
						<td>Degree Earned</td>
						<td>Major</td>
						<td>GPA</td>
						<td>Remove</td>
					</tr>
					<c:set var="ar1" value="${GappApplication1.arid}" />
					<c:forEach items="${ar1}" var="ar1">
						<tr>

							<td>${ar1.collegename}</td>
							<td>${ar1.timeattended}</td>
							<td>${ar1.degreeearned}</td>
							<td>${ar1.major}</td>
							<td>${ar1.GPA}</td>
							<td><a
								href="removedegree.html?arid=${ar1.arid }&&id=${GappUsers1.id }&&deptid=${GappDepartment.deptid }&&prgmid=${GappProgram.prgmid }&&appid=${GappApplication1.appid}">Remove
									Degree</a></td>
						</tr>
					</c:forEach>
				</table>


				<div id="inputs">
					<br> <a href="#" class="btn btn-info" onclick="getinput()">Add
						More Degree</a><br>
					<br> College Name : <input type='text' name='colname'>
					<br> Time Attended : <input type='text' name='timeattend'>
					<br> Degree Earned : <input type='text' name='degreeearn'><br>
					Major : <input type='text' name='major'><br> GPA : <input
						type='text' name='gpa'><br>

				</div>

				<br>

Existing Transcript:
<br>
				<c:choose>
					<c:when test="${empty GappApplication1.transcript.filename}">
						<h3>
							<b>Not Uploaded transcript</b>
						</h3>
					</c:when>
					<c:otherwise>
						<a class="btn btn-success"
							href="../download.html?filename=${GappApplication1.transcript.filename }">Download
							Existing Transcript</a>
					</c:otherwise>
				</c:choose>
				<br>
				<br>

Re-Upload Transcript
<input type="file" name="transcript">





				<br>
				<br>
				<input type="submit" class="btn btn-success" name="Save"
					value="Save">&nbsp&nbsp&nbsp&nbsp
<input type="submit" class="btn btn-success" name="Submit"
					value="Submit">
				<input type="hidden" name="prgm" value="${prgm}">
				<input type="hidden" name="term" value="${term}">
				<input type="hidden" name="appid" value="${GappApplication1.appid}">
				<input type="hidden" name="user1" value="${GappUsers1.id}">
				<input type="hidden" name="dept" value="${GappDepartment.deptid}">
				<input type="hidden" name="fileid"
					value="${GappApplication1.transcript.fileid}">

			</form:form>
			<script type="text/javascript"
				src="//code.jquery.com/jquery-latest.js"></script>

			<script>
				function getinput() {
					var colname = "<br>College Name : <input type='text' name='colname' > ";
					var timeattend = " <br> Time Attended : <input type='text' name='timeattend' > ";
					var degreeearn = " <br> Degree Earned : <input type='text' name='degreeearn' >";
					var major = " <br> Major : <input type='text' name='major' >";
					var gpa = " <br> GPA : <input type='text'  name='gpa' >";

					$("#inputs").append(colname, timeattend, degreeearn, major,
							gpa);

					"<br>"
				}
			</script>


		</div>
	</div>
</body>
</html>