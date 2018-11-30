<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Complaint 
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
<jsp:include page="adminhead.jsp"></jsp:include>
<jsp:include page="hodmenu.jsp"></jsp:include>


<div class="container index-center-profile ">
<center><h1>Complaint Information</h1><br>
<table class="table-hover tableprofile">
      	 <tr>
          <th class="tabletitle">ComplaintId:</th>
          <td>${complaint.complaintId}</td>
         </tr>
         <tr>
          <th class="tabletitle">ComplaintTitle:</th>
          <td>${complaint.complaintTitle} </td>
         </tr>
         <tr>
          <th class="tabletitle">Complaint Desc: </th>
          <td>${complaint.complaintDesc }</td>
         </tr>
         <tr>
          <th class="tabletitle">Complaint Address: </th>
          <td>${complaint.complaintAddress}</td>
         </tr>  
         <tr>
          <th class="tabletitle">Complaint Status: </th>
          <td><p style="color: red;">${errorString}</p>
          <form method="POST" action="${pageContext.request.contextPath}/updateStatus"> 
           <input type="hidden" name="complaintId" value="${complaint.complaintId}" />
          <input type="text" name="status" placeholder="Update Status"/><br>
          <input type="submit" class="button" value= "Submit" />
          </form>
          </td>
         </tr>     
       
    </table>
</center>
</div>

<div class="clearfix">&nbsp;</div>
 
<jsp:include page="lfoot.jsp"></jsp:include>

</body>
</html>