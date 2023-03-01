<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Busify | Add Bus</title>
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

  <!-- Template Main CSS File -->
  <link href="assets/css/style.css" rel="stylesheet">

  <!-- =======================================================
  * Template Name: Remember - v4.10.0
  * Template URL: https://bootstrapmade.com/remember-free-multipurpose-bootstrap-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
	<link rel = "stylesheet" href = "all_components/style.css">
  	<style type="text/css">
	
	body{
	
	background-image: url(img/Lg-bg.jpg);
	width:100%;
	height:60vh;
	background-size: cover;
	background-attachment: fixed;
	}
   .reg:HOVER{
	text-decoration: none;
	}
	</style>
</head>
<body>
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
          <li><a class="nav-link scrollto active" href="addBuses.jsp">Add Buses</a></li>
          <li><a class="nav-link scrollto" href="busReport.jsp">Bus Report</a></li>
          <li><a class="nav-link scrollto " href="travelReport.jsp">Book Ticket Report</a></li>
         
          <li><a class="nav-link scrollto text-white" >Admin</a></li>
          <li><a class="nav-link scrollto" href="logout">Logout</a></li>
         
        </ul>
        <i class="bi bi-list mobile-nav-toggle"></i>
      </nav><!-- .navbar -->

    </div>
  </header><!-- End Header -->
    
     <!-- Register Form -->
  
   <div class = "container-fluid mt-4">
	       <div class = "row p-5">
	           <div class = "col-md-4 offset-md-4">
	                <div class = "card">
	                    <div class = "card-body">
	                         <div class = "text-center text-info mb-4">
	                         <i class="fa-solid fa-user-plus fa-2x" aria-hidden = "true"></i>
	                         <c:if test="${not empty ntf }">
	                        <div class="alert alert-success" role="alert">${ ntf}</div>
	                        <c:remove var="ntf"/>
	                         </c:if>
	                           <h2 style="color: #8fc04e"><b>Add Buses</b></h2>
	                         </div>
	                         <form action = "add_bus" method = "post">
	                               <div class = "form-group">
	                                   <label>Enter Bus No</label>
	                                   <input type = "text" required = "required" class = "form-control" id = "exampleInputEmail1"
	                                   aria-describedby = "emailHelp" name = "bno">
	                               </div>
	                                <div class = "form-group">
	                                   <label>Enter Bus Name</label>
	                                   <input type = "text" required = "required" class = "form-control" id = "exampleInputEmail1"
	                                   aria-describedby = "emailHelp" name = "bname">
	                               </div>
	                                <div class = "form-group">
	                                   <label>Enter From City</label>
	                                   <input type = "text" required = "required" class = "form-control" id = "exampleInputEmail1"
	                                   aria-describedby = "emailHelp" name = "fcity">
	                               </div>
	                                 <div class = "form-group">
	                                   <label>Enter To City</label>
	                                   <input type = "text" required = "required" class = "form-control" id = "exampleInputEmail1"
	                                   aria-describedby = "emailHelp" name = "tcity">
	                               </div>
	                                 <div class = "form-group">
	                                   <label>Enter Date</label>
	                                   <input type = "date" required = "required" class = "form-control" id = "exampleInputEmail1"
	                                   aria-describedby = "emailHelp" name = "date">
	                               </div>
	                                 <div class = "form-group">
	                                   <label>Enter Time</label>
	                                   <input type = "text" required = "required" class = "form-control" id = "exampleInputEmail1"
	                                   aria-describedby = "emailHelp" name = "time">
	                               </div>
	                                 <div class = "form-group">
	                                   <label>Enter Ticket Price</label>
	                                   <input type = "text" required = "required" class = "form-control" id = "exampleInputEmail1"
	                                   aria-describedby = "emailHelp" name = "price">
	                               </div>
	                              
	                               
	                               <button type = "submit" class = "btn badge-pill btn-block" style="background-color: #8fc04e; color: #fff">Add</button>
	                         </form>
	                    </div>
	                </div>
	           </div>
	       </div>
	 </div>
  <!-- End -->
</body>
</html>