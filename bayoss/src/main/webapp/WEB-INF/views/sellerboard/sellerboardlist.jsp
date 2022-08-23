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
$(function(){
	//물품 삭제 여부
	var delete_result = "${delete_result}";
	
	if(delete_result == "true"){
		alert("물품 정상 삭제");
	} else if(delete_result == "false"){
		alert("물품 삭제 실패");
	}
	
	var searchType;
	var keyword;
	//옵션 체인지
	$("#searchType").change(function(){
		searchType = $(this).val();
		console.log("searchType : " , searchType);
	});
	//검색
	$(".btnsearch").click(function(){
		keyword = $(this).prev().val();
		console.log("keyword : " , keyword);
		if(searchType == null){
			alert("검색타입을 지정하세요");
		} else if (keyword == null){
			alert("검색어를 입력하세요");
		} else {
			$("#frmSearch").find("input[name=searchType]").val(searchType);
			$("#frmSearch").find("input[name=keyword]").val(keyword);
			$("#frmSearch").attr("method" , "get")
			$("#frmSearch").attr("action" , "/sellerboard/selllist").submit();
		}
	});
});
</script>
</head>

<body>
	<div class="container-fluid" id="container-wrapper">
		
		
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-8">
				<h1>등록물품리스트</h1><br>
				<div class="row">
        	<!-- 검색 -->
        <div class="col">
        	
        	<select id="searchType" style="width: 15%; padding: 1%;" >
        		<option selected disabled>선택</option>
        		<option value="p"
        			<c:if test="${pagingDto.searchType == 'p'}">selected</c:if>
        		>물품</option>
        		<option value="c"
        			<c:if test="${pagingDto.searchType == 'c'}">selected</c:if>
        		>가격</option>
        	</select>
        		<input type="text" id="keyword" class="form-control" style="width: 30%; display: inline-block;">
        		<button type="button" class="btn btn-primary btnsearch" >검색</button>
       		<form id="frmSearch">
        		<input type="hidden" name="searchType" value="${pagingDto.searchType}" class="form-control">
        		<input type="hidden" name="keyword" value="${pagingDto.keyword}" class="form-control">
        		<input type="hidden" name="page" value="${pagingDto.page}"  class="form-control">
        		<input type="hidden" name="sid" value="${sellerVo.sid}"  class="form-control">
        	</form>
        </div>
        <!-- 검색 -->
        </div><br>
				
				
				
				
				
				
				
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
				</div><br>

				<!-- 페이징  -->
				<div class="row">
					<div class="col-md-12">
						<nav>
							<ul class="pagination justify-content-center">
								<c:if test="${pagingDto.startPage !=1}">
									<li><a class="page-link" href="/sellerboard/selllist?sid=${sellerVo.sid}&page=${pagingDto.startPage-1}">&lt;</a></li>
								</c:if>
								<c:forEach begin="${pagingDto.startPage}"
									end="${pagingDto.endPage}" var="i">
									<li
										<c:choose>
									<c:when test="${i==pagingDto.page}">class="page-item active"</c:when>
									<c:otherwise>class="page-item"</c:otherwise>
								</c:choose>><a
										 class="page-link" href="/sellerboard/selllist?sid=${sellerVo.sid}&page=${i}"><span>${i}</span></a></li>
								</c:forEach>
								<c:if test="${pagingDto.endPage != pagingDto.totalPage}">
									<li><a class="page-link" href="/sellerboard/selllist?sid=${sellerVo.sid}&page=${pagingDto.endPage+1}">&gt;</a></li>
								</c:if>


							<!-- 	<li class="page-item"><a class="page-link" href="#">이전</a></li>
								<li class="page-item"><a class="page-link" href="#">1</a></li>
								<li class="page-item"><a class="page-link" href="#">2</a></li>
								<li class="page-item"><a class="page-link" href="#">3</a></li>
								<li class="page-item"><a class="page-link" href="#">4</a></li>
								<li class="page-item"><a class="page-link" href="#">5</a></li>
								<li class="page-item"><a class="page-link" href="#">다음</a>
								</li> -->
							</ul>
						</nav>
					</div>
				</div>

				<!-- 페이징  -->
			</div>
			<div class="col-md-3"></div>
		</div>

	

<!-- footer  -->
<%@ include file="/WEB-INF/views/include/sellerfooter.jsp"%>