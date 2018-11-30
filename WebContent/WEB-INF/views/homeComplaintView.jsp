<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Complaints Details</title>
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
<jsp:include page="lhead.jsp"></jsp:include>
 <jsp:include page="lmenu.jsp"></jsp:include>
<div class="textcontent-complaint container">
	<div class="title"><p>Types of Complaint</p></div>
	
<div class="container">
<div class="card-deck ">
	<div class="card card-indexcomp">
		<div class="card-title">
			<p>Drainage Complaint</p>
		</div>
		<div class="card-content">
			<p>Users can complaint about Drainage Departments in your area. After register the complaint, 
			the complaint will send to the respective User and Head of the department. User will get the 
			complaint id of the complaint, so user can track the status of the complaint details. User can view
			past complaints.</p>
		</div>
	</div>
	<div class="card card-indexcomp">
		<div class="card-title">
			<p>Electric Complaint</p>
		</div>
		<div class="card-content">
			<p>Users can complaint about Electricity Departments in your area. After register the complaint, 
			the complaint will send to the respective User and Head of the department. User will get the 
			complaint id of the complaint, so user can track the status of the complaint details. User can view
			past complaints.</p>
		</div>
	</div>
	<div class="card card-indexcomp">
		<div class="card-title">
			<p>Water Supply Complaint</p>
		</div>
		<div class="card-content">
			<p>Users can complaint about Water Supply Departments in your area. After register the complaint, 
			the complaint will send to the respective User and Head of the department. User will get the 
			complaint id of the complaint, so user can track the status of the complaint details. User can view
			past complaints.</p>
		</div>
	</div>
</div> 
</div>
 
	
</div>
<jsp:include page="lfoot.jsp"></jsp:include>

</body>
</html>