<%@page import="com.entity.book"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.Dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
             <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Busify | Tickets Report</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="assets/img/fav.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="assets/vendor/aos/aos.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
  <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

<!--Fontowesome  -->
	<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
	integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
  <!-- Template Main CSS File -->
  <link href="assets/css/style.css" rel="stylesheet">

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" 
integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" 
crossorigin="anonymous">  
<!-- =======================================================
  * Template Name: Remember - v4.10.0
  * Template URL: https://bootstrapmade.com/remember-free-multipurpose-bootstrap-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
 <style type="text/css">
 body{
	
	background-image: url(img/Lg-bg.jpg);
	width:100%;
	height:60vh;
	background-size: cover;
	background-attachment: fixed;
	}
.table{

width: 90%;
}
.btn .btn-sm{
width: 2pc;
}
.alert{
 width: 30%;
}
.thead{
background-color: #8fc04e;
color: #fff;
}
tbody{
color: #fff;
}
</style>
</head>
<body>
     
     <%
		String email = (String) session.getAttribute("email");
		String ph = (String) session.getAttribute("ph");
		String date = (String) session.getAttribute("date");
		String nperson = (String) session.getAttribute("nperson");
		String addr = (String) session.getAttribute("addr");
		String price = (String) session.getAttribute("price");

      
     %>
       <!-- ======= Header ======= -->
  <header id="header" class="d-flex align-items-center">
    <div class="container d-flex justify-content-between">

      <div class="logo">
        <h1 class="text-light"><a href="index.html">Busify</a></h1>
        <!-- Uncomment below if you prefer to use an image logo -->
        <!-- <a href="index.html"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->
      </div>

      <nav id="navbar" class="navbar">
        <ul>
        <li><a class="nav-link scrollto " href="index.jsp">Home</a></li>
        <li><a class="nav-link scrollto active" href="ticketReport.jsp">Ticket Report</a></li>
                  
        <%	String fname = (String) session.getAttribute("fname"); %>
          <li><a class="nav-link scrollto text-white"> <%=fname %></a></li>
                  
          <li><a class="nav-link scrollto" href="logout">Logout</a></li>
        </ul>
        <i class="bi bi-list mobile-nav-toggle"></i>
      </nav><!-- .navbar -->
    
      </div>
  </header><!-- End Header -->
     
      <div class="container mt-4">
     <center><h4 style="text-align: center;  color: #8fc04e; padding: 4px; border-radius: 6px; font-weight: bold;">Tickets Report</h4></center> 
     </div>  
     
          <c:if test="${not empty ntff }">
	       <center><div class="alert alert-success text-center mt-3" role="alert">${ ntff}</div></center>
	       <c:remove var="ntff"/>
	       </c:if>
     <div>
     <center>
     <table class="table text-center mt-5">
	   <thead class="thead">
	    <tr>
	      <th scope="col">Email ID</th>
	      <th scope="col">Contact No</th>
	      <th scope="col">Date of Journey</th>
	      <th scope="col">No of Person</th>
	      <th scope="col">Address</th>
	      <th scope="col">Final Price</th>
	    </tr>
	  </thead>
     
     <tbody>
	    <tr>
	      <td><%=email %></td>
	      <td><%=ph %></td>
	      <td><%=date %></td>
	      <td><%=nperson %></td>
	      <td><%=addr %></td>
	      <td><%=price %></td>
	      </tr>
	 </tbody>
	</table>
	</center>      
	</div>
</body>
</html>