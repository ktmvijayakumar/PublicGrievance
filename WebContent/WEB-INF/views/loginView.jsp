<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
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
<center>
<p style="color: green; font-size: 18px;">${successMessage}</p>
</center>

<div class="textcontent container">
	<div class="title"><p>Public Grievance System</p></div>
	<div class="titlecontent"><p>PGS is the platform based on web technology which primarily aims to
	 enable submission of grievances by the aggrieved citizens from anywhere and anytime (24x7) basis 
	 to Departments who scrutinize and take action for speedy and favorable 
	 redress of these grievances. Tracking grievances is also facilitated on this portal through
	 the system generated unique Complaint ID.</p></div>
</div>

<div class="image container">
	<div class="row no-gutters">
		<div class="col-lg-6">
			<div class="image-row-body">
				<div class="slideshow">
					<div id="demo" class="carousel slide" data-ride="carousel">
					  <ul class="carousel-indicators">
					    <li data-target="#demo" data-slide-to="0" class="active"></li>
					    <li data-target="#demo" data-slide-to="1"></li>
					    <li data-target="#demo" data-slide-to="2"></li>
					  </ul>
					  <div class="carousel-inner">
					    <div class="carousel-item active">
					      <img alt="slide" src="img/electric.jpg" width="450px" height="300px">
					         
					    </div>
					    <div class="carousel-item">
					     <img alt="slide" src="img/drainage.jpg" width="450px" height="300px">   
					    </div>
					    <div class="carousel-item">
					     <img alt="slide" src="img/water.jpg" width="450px" height="300px">
					    </div>
					  </div>
				</div></div>
			</div>			
		</div>
		<div class="col-lg-6" >
			<div class="index-center">
				<center>
					 <h1>Login</h1>
					 <p style="color: red;">${errorString}</p>
					 <form method="POST" action="${pageContext.request.contextPath}/login"> 
				        	  <input type="text" name="emailid" placeholder="Email id"/> <br>
				     		  <input type="password" name="password" placeholder="Password"/> <br>
				              <input type="submit" class="button" value= "Submit" />
				              <a class="acolor" href="${pageContext.request.contextPath}/">Cancel</a><br><br>
				              <a class="otherloginbtn" href="${pageContext.request.contextPath}/othersLogin">Other's Login</a>    
				      </form>
				</center>
			</div>

		</div>
	</div>	
</div>

<div class="clearfix">&nbsp;</div>
 
<jsp:include page="lfoot.jsp"></jsp:include>
</body>
</html>