<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div class="container">
<nav class="navbar navbar-expand-md">
	
  <a class="navbar-brand" href="index.jsp">HOME</a>
  <button class="navbar-toggler navbar-dark" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
      <li class="nav-item ">
        <a class="nav-link" href="${pageContext.request.contextPath}/homeComplaint">COMPLAINTS</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">ABOUTUS</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">CONTACTUS</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">NEWS</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/gallery">GALLERY</a>
      </li>    
    </ul>
	
  </div>  
</nav>
</div>
</body>
</html>