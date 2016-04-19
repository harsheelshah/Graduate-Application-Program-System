<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

<body>

	<div class="container">

		<br />
		<div class="well">
			<form method="post">
				<h3>
					Username:<input type="text" name="email">
				</h3>
				<h3>
					Password:<input type="password" name="password">
				</h3>
				<br> <input type="submit" class="btn btn-primary" value="Login"
					name="Login" />
			</form>
			<br> <a href="registration.html" class=" btn btn-success">Register</a>

		</div>
	</div>
</body>
</html>