<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Complaint</title>
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
<jsp:include page="hodmenu.jsp"></jsp:include>
<div class="textcontent-viewcomplaint container">
<center><h3>Complaint List</h3>
 
    <p style="color: red;">${errorString}</p>
   	<table class="table table-hover">
       <tr>
          <th class="tabletitle">Complaint Id</th>
          <th class="tabletitle">User Name</th>
          <th class="tabletitle">Complaint Title</th>
          <th class="tabletitle">Complaint Descption</th>
          <th class="tabletitle">Complaint Address</th>
          <th class="tabletitle">Complaint Status</th>
          
       </tr>     
       <c:forEach items="${adminViewComplaintList}"  var="complain">
          <tr>          
             <td>${complain.complaintId}</td>
             <td>${complain.userName}</td>
             <td>${complain.complaintTitle}</td>
             <td>${complain.complaintDesc}</td>
             <td>${complain.complaintAddress}</td>
          	 <td>${complain.complaintStatus}<br><a href="updateStatus?complaintId=${complain.complaintId}">Update</a></td>
          </tr>
       </c:forEach>
    </table>
</center>
</div>
    <jsp:include page="lfoot.jsp"></jsp:include>
 
 </body>
 </html>