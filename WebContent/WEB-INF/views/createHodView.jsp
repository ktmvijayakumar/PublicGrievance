<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create HOD</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <script src="css/anim.js"></script>
 	<link rel="stylesheet" type="text/css" href="css/animation.css">
 	<link rel="stylesheet" type="text/css" href="css/hover.css">
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" type="text/css" href="css/style1.css">


</head>
<body>
<% response.setHeader("Cache-control","no-cache,no-store, must-revalidate");
response.setHeader("Pragma","no-cache");
response.setHeader("Expires","0");
%>
 <jsp:include page="adminhead.jsp"></jsp:include>
 <jsp:include page="adminmenu.jsp"></jsp:include>
 
<div class="index-center-register container"><center>
<h1>Create HOD</h1>
<hr>
<p style="color: red;">${errorString}</p>
 <form method="POST" action="${pageContext.request.contextPath}/createHod">
               <input type="text" name="name" placeholder="Name"/><br>
               <label class="radio-inline">
			      <input type="radio" name="department" value="Drainage">Drainage
			    </label>
			    <label class="radio-inline">
			      <input type="radio" name="department" value="Electric">Electric
			    </label>
			    <label class="radio-inline">
			      <input type="radio" name="department" value="Watersupply">Water Supply
			    </label>
	           
               <input type="text" name="age" placeholder="Age"/><br>
               <input type="text" name="emailId" placeholder="Emailid"/><br>
               <input type="text" name="phoneNumber" placeholder="PhoneNumber"/><br> 
               <input type="password" name="password" placeholder="Password"/><br>
               <input type="password" name="confirmPassword" placeholder="Confirm Password"/><br>
               <input type="submit" class="button" value= "Submit" />
               <a class="acolor" href="${pageContext.request.contextPath}/adminInfo">Cancel</a>
      </form>
      </center>
      </div>
 <jsp:include page="lfoot.jsp"></jsp:include>
</body>
</html>