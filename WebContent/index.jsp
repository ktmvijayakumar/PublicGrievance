<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Public Grievance System</title>
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

</head>
<body>
 <jsp:include page="head.jsp"></jsp:include>
  <jsp:include page="menu.jsp"></jsp:include>
 
<div class="textcontent-index container">
	<div class="title"><p>Public Grievance System</p></div>
	<div class="titlecontent"><p>PGS is the platform based on web technology which primarily aims to
	 enable submission of grievances by the aggrieved citizens from anywhere and anytime (24x7) basis 
	 to Departments who scrutinize and take action for speedy and favorable 
	 redress of these grievances. Tracking grievances is also facilitated on this portal through
	 the system generated unique Complaint ID.</p></div>
</div>
<div class="container">
<div class="card-deck ">
	<div class="card card-index">
		<div class="card-title">
			<p>People</p>
		</div>
		<div class="card-content">
			<p>Users can complaint about Ministries/Departments in your area. After register the complaint, 
			the complaint will send to the respective User and Head of the department. User will get the 
			track id of the complaint, so user can track the status of the complaint details. User can view
			past complaints.</p>
		</div>
	</div>
	<div class="card card-index">
		<div class="card-title">
			<p>Head of the department</p>
		</div>
		<div class="card-content">
			<p>Head of respective department officers can view all the complaints given by citizens. He can
			update the complaints to the respective offices and update the status of the complaints. Head of 
			department will manage all the complaints and officers of the respective department.
		</div>
	</div>
</div> 
</div>
 
 <jsp:include page="foot.jsp"></jsp:include>
</body>
</html>