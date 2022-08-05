<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <link href="img/logo/logo.png" rel="icon">
  <title>Admin Page</title>
  <link href="/resources/seller/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="/resources/seller/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
  <link href="/resources/seller/css/ruang-admin.min.css" rel="stylesheet">
</head>


<body id="page-top">
  <div id="wrapper">
    <!-- Sidebar -->
    <ul class="navbar-nav sidebar sidebar-light accordion" id="accordionSidebar">
      <a class="sidebar-brand d-flex align-items-center justify-content-center" href="/">
        <div class="sidebar-brand-icon"></div>
        <div class="sidebar-brand-text mx-3">BAYOSS HOME</div>
      </a>
      <li class="nav-item active">
        <a class="nav-link" href="/seller/sellerlogin">
          <i class="fas fa-fw fa-tachometer-alt"></i>
          <span>
          	<c:if test="${not empty storeInfo.sell_store_name}">${storeInfo.sell_store_name}</c:if>
          	<c:if test="${empty storeInfo.sell_store_name}">등록업체없음</c:if>
          </span></a>
      </li>
      <hr class="sidebar-divider">
      <div class="sidebar-heading">
        category
      </div>
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseBootstrap"
          aria-expanded="true" aria-controls="collapseBootstrap">
          <i class="far fa-fw fa-window-maximize"></i>
          <span>상품관리</span>
        </a>
        <div id="collapseBootstrap" class="collapse" aria-labelledby="headingBootstrap" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">목록</h6>
            <a class="collapse-item" href="alerts.html">리스트</a>
            <a class="collapse-item" href="/sellerboard/sellerboardform">등록</a>
          </div>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseForm" aria-expanded="true"
          aria-controls="collapseForm">
          <i class="fab fa-fw fa-wpforms"></i>
          <span>주문내역</span>
        </a>
        <div id="collapseForm" class="collapse" aria-labelledby="headingForm" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">내역</h6>
            <a class="collapse-item" href="form_basics.html">Form Basics</a>
            <a class="collapse-item" href="form_advanceds.html">Form Advanceds</a>
          </div>
        </div>
      </li>
    </ul>
    
    <!-- Sidebar -->
    <div id="content-wrapper" class="d-flex flex-column">
      <div id="content">
        
        <!-- 테스트 Topbar -->
 <nav class="navbar navbar-expand navbar-light bg-navbar topbar mb-4 static-top">
          <button id="sidebarToggleTop" class="btn btn-link rounded-circle mr-3">
            <i class="fa fa-bars"></i>
          </button>
          <ul class="navbar-nav ml-auto">
            
            <li class="nav-item dropdown no-arrow">
              <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown"
                aria-haspopup="true" aria-expanded="false">
                <img class="img-profile rounded-circle" src="/resources/images/loc.png" style="max-width: 60px">
                <span class="ml-2 d-none d-lg-inline text-white small">${sellerVo.sid}</span>
              </a>
              <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                <a class="dropdown-item" href="#">
                  <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>사용자정보</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="javascript:void(0);" href="/seller/sellerlogout" data-toggle="modal" data-target="#logoutModal">
                  <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i> 로그아웃</a>
              </div>
            </li>
          </ul>
        </nav>
        <!-- Topbar -->