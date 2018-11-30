<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Information
</title>
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

<% response.setHeader("Cache-control","no-cache,no-store, must-revalidate");
response.setHeader("Pragma","no-cache");
response.setHeader("Expires","0");
%>
<jsp:include page="userhead.jsp"></jsp:include>
<jsp:include page="hodmenu.jsp"></jsp:include>

<center>
<p style="color: green; font-size: 18px;">${successMessage}</p>
</center>

<div class="container index-center-profile ">
<center><h1>Profile</h1><br>
<table class="table-hover tableprofile">
      	 <tr>
          <th class="tabletitle">User Name:</th>
          <td>${user.hodname}</td>
         </tr>
         <tr>
          <th class="tabletitle">Age:</th>
          <td>${user.hodage} </td>
         </tr>
         <tr>
          <th class="tabletitle">Email Id: </th>
          <td>${user.hodemailid }</td>
         </tr>
         <tr>
          <th class="tabletitle">Phone Number: </th>
          <td>${user.hodphoneNumber }</td>
         </tr>     
       
    </table>
</center>
</div>

<div class="clearfix">&nbsp;</div>
 
<jsp:include page="lfoot.jsp"></jsp:include>

</body>
</html>