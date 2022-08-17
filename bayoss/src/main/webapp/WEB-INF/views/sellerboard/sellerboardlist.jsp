<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  

<!-- header  -->
<%@ include file="/WEB-INF/views/include/sellerheader.jsp" %>
<head>

<!-- 서머노트를 위해 추가해야할 부분 -->
<script src="/resources/summerNote/summernote-lite.js"></script>
<script src="/resources/summerNote/summernote-ko-KR.js"></script>
<link rel="stylesheet" href="/resources/summerNote/summernote-lite.css">
<style type="text/css">
.itemlisttr :hover{
background-color: aliceblue;
}
</style>
<script type="text/javascript">
//물품 삭제 여부
var delete_result = "${delete_result}";

if(delete_result == "true"){
	alert("물품 정상 삭제");
} else if(delete_result == "false"){
	alert("물품 삭제 실패");
}
</script>
</head>

<body>
	<div class="container-fluid" id="container-wrapper">
		
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-8">
				<h1>등록물품리스트</h1><br>
				<table class="table">
					<thead>
						<tr>
							<th>#</th>
							<th>등록번호</th>
							<th>물품명</th>
							<th>가격</th>
							<th>상태</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="list" items="${itemlist}" varStatus="status">
							<tr class="itemlisttr" onclick="location.href='/sellerboard/iteminfo?ino=${list.ino}'" 
								style="cursor: pointer;">
								<td>${status.count}</td>
								<td>${list.ino}</td>
								<td>${list.item_title}</td>
								<td>${list.item_cost}</td>
								<td>
									<c:if test="${list.item_status eq 'T'}">서비스</c:if>
									<c:if test="${list.item_status eq 'F'}">중지</c:if>
								</td>
							</tr>
						</c:forEach>	
					</tbody>
				</table>
				<div>
				<button type="button" onclick="history.back()" class="btn btn-danger">뒤로가기</button>
				<a type="button" style="float: right;" href="/sellerboard/sellerboardform" class="btn btn-primary">등록하기</a>
				</div>

				<!-- 페이징  -->
			
			
			<!-- 페이징  -->
			</div>
			<div class="col-md-3"></div>
		</div>

	

<!-- footer  -->
<%@ include file="/WEB-INF/views/include/sellerfooter.jsp"%>