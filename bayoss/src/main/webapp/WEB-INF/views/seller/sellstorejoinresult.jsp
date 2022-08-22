<%@page import="org.apache.jasper.tagplugins.jstl.core.Remove"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  

<!-- header  -->
<%@ include file="/WEB-INF/views/include/sellerheader.jsp" %>

</head>
<body>
	<div class="container-fluid" id="container-wrapper">
		<div class="row">
			<h1>등록 신청 되었습니다 관리자 승인후 사용가능 합니다 다시 로그인해주세요</h1>
			<% session.invalidate(); %>
		</div>
		<!-- footer  -->
		<%@ include file="/WEB-INF/views/include/sellerfooter.jsp"%>