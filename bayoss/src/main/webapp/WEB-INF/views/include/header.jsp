<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>BAYOSS</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link href="https://fonts.googleapis.com/css?family=Montserrat:200,300,400,500,600,700,800&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
 	
    <link rel="stylesheet" href="/resources/css/animate.css">
    
    <link rel="stylesheet" href="/resources/css/owl.carousel.min.css">
    <link rel="stylesheet" href="/resources/css/owl.theme.default.min.css">
    <link rel="stylesheet" href="/resources/css/magnific-popup.css">


    <link rel="stylesheet" href="/resources/css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="/resources/css/jquery.timepicker.css">

    <link rel="stylesheet" href="/resources/css/flaticon.css">
    <link rel="stylesheet" href="/resources/css/style.css">
    <script src="/resources/js/jquery.min.js"></script>
	  
  </head>
  <body>

    <div class="wrap">
			<div class="container">
				<div class="row">
					<div class="col-md-6 d-flex align-items-center">
						<p class="mb-0 phone pl-md-2">
						<!-- 추�?? ?��?�� ?��?���? 빼기 -->
						</p>
					</div>
					<div class="col-md-6 d-flex justify-content-md-end">
						<div class="social-media">
			    		<p class="mb-0 d-flex">
			    			<c:if test="${empty userVo}">
			    				<a href="/user/login" class="d-flex align-items-center justify-content-center loginicon"><span>login</span></a>
			    				<a href="/user/joinus" class="d-flex align-items-center justify-content-center loginicon"><span>joinus</span></a>
			    			</c:if>
			    			<c:if test="${not empty userVo}">
			    				<a href="/user/logout" class="d-flex align-items-center justify-content-center loginicon"><span>logout</span></a>
			    				<a href="/user/mypge" class="d-flex align-items-center justify-content-center loginicon"><span>mypage</span></a>
			    			</c:if>
			    			<c:if test="${userVo.cid eq 'admin'}">
			    				<a href="/user/login" class="d-flex align-items-center justify-content-center loginicon"><span>관리자페이지</span></a>
			    			</c:if>
			    				
			    			
			    			
			    			<a href="/user/faqboard" class="d-flex align-items-center justify-content-center loginicon"><span>contact</span></a>
			    			<a href="#" class="d-flex align-items-center justify-content-center"><span><i class="fa fa-globe" aria-hidden="true"></i></span></a>
			    		</p>
		        </div>
					</div>
				</div>
			</div>
		</div>
		<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
	    <div class="container">
			<a class="navbar-brand" href="/">BAYOSS</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
			  <span class="fa fa-bars"></span> Menu
			</button>
	      <div class="collapse navbar-collapse" id="ftco-nav">
			<ul class="navbar-nav ml-auto">
				
				<li class="nav-item dropdown"><a class="nav-link">MAINTENENCE<%-- <spring:message code="message.index.title"/> --%></a>
					<ul class="dropdown-menu">
						<li><a href="/sub/boardcontent?main_category=maintenence&detail_category=ict">ICT        </a></li>
						<li><a href="/sub/boardcontent?main_category=maintenence&detail_category=machinery">Machinery</a></li>
						<li><a href="/sub/boardcontent?main_category=maintenence&detail_category=metalfabrication">Metal Fabrication</a></li>
					</ul>
				</li>
				<li class="nav-item dropdown"><a class="nav-link">Supplies</a>
					<ul class="dropdown-menu">
						<li><a href="/sub/boardcontent?main_category=supplies&detail_category=bunkering">Bunkering</a></li>
						<li><a href="/sub/boardcontent?main_category=supplies&detail_category=spareparts">Spare Parts</a></li>
						<li><a href="/sub/boardcontent?main_category=supplies&detail_category=consumables">Consumables</a></li>
						<li><a href="/sub/boardcontent?main_category=supplies&detail_category=hse">HSE &amp; Sagety</a></li>
						<li><a href="/sub/boardcontent?main_category=supplies&detail_category=foodstuff">Foodstuff</a></li>
					</ul>
				</li>
				<li class="nav-item dropdown"><a class="nav-link">Services</a>
					<ul class="dropdown-menu">
						<li><a href="/sub/boardcontent?main_category=services&detail_category=internet">Inernet</a></li>
						<li><a href="/sub/boardcontent?main_category=services&detail_category=pickup">Pick-Up</a></li>
						<li><a href="/sub/boardcontent?main_category=services&detail_category=medicalcare">Medical Care</a></li>
						<li><a href="/sub/boardcontent?main_category=services&detail_category=tour">Tour</a></li>
						<li><a href="/sub/boardcontent?main_category=services&detail_category=event">Event</a></li>
					</ul>
				</li>
				<li class="nav-item dropdown"><a href="/sub/shopping?page=1" class="nav-link">Shopping</a>
					<ul class="dropdown-menu">
						<li><a href="sub/shopping/cosmetics.html">Cosmetics</a></li>
						<li><a href="sub/shopping/accessories.html">Accessories</a></li>
						<li><a href="sub/shopping/nutrient.html">Nutrient</a></li>
						<li><a href="sub/shopping/medicals.html">Medicals</a></li>
						<li><a href="sub/shopping/apparel.html">Apparel</a></li>
						<li><a href="sub/shopping/sumdries.html">Sumdries</a></li>
						<li><a href="sub/shopping/processedfood.html">Processed Food</a></li>
					</ul>
				</li>
				<li class="nav-item dropdown"><a href="#" class="nav-link">Review</a>
					<ul class="dropdown-menu">
						<li><a href="/sub/review">Review</a></li>
						<li><a href="/user/faq">FAQ</a></li>
					</ul>
				</li>
			</ul>
				<div>	
					<input type="text" placeholder="search">
					<button class="btn btn-primary-sm" type="button"><i class="fa fa-search fa-2x" aria-hidden="true"></i></button>
				</div>
	      </div>
	    </div>
	  </nav>
    <!-- END nav -->