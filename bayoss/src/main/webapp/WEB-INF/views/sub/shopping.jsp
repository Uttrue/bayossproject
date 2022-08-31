<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<!-- header  -->
<%@ include file="/WEB-INF/views/include/header.jsp" %>
<script>
$(function(){
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
			$("#frmSearch").attr("action" , "/sub/shopping").submit();
		}
	});
	//콤마 적용 - 적용 확인 데이터 넣기 - 수정요
	var dbcost = "";
	var cost = dbcost.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	$("#tagcost").text(cost);
	//금액 콤마 함수
	function comma(str) {
        str = String(str);
        return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');
    }
	
});
</script>

<section class="ftco-counter" id="section-counter">
	<div class="container">
		<div class="row">
			<div
				class="col-md-6 col-lg-3 d-flex justify-content-center counter-wrap ftco-animate">
				<div class="block-18 text-center">
					<div class="detailtitle">
						<span>shopping</span>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>

<section class="ftco-section">
	<div class="container">
		<div class="row justify-content-center pb-5 mb-3">
          <div class="col-md-7 heading-section text-center ftco-animate">
          </div>
        </div>
        <div class="row">
        	<!-- 검색 -->
        <div class="col">
        	
        	<select id="searchType" style="width: 15%; padding: 1%;" >
        		<option selected disabled>선택</option>
        		<option value="p"
        			<c:if test="${pagingDto.searchType == 'p'}">selected</c:if>
        		>물품</option>
        		<option value="s"
        			<c:if test="${pagingDto.searchType == 's'}">selected</c:if>
        		>판매자</option>
        	</select>
        		<input type="text" id="keyword" class="form-control" style="width: 30%; display: inline-block;">
        		<button type="button" class="btn btn-primary btnsearch" >검색</button>
       		<form id="frmSearch">
        		<input type="hidden" name="searchType" value="${pagingDto.searchType}" class="form-control">
        		<input type="hidden" name="keyword" value="${pagingDto.keyword}" class="form-control">
        		<input type="hidden" name="page" value="${pagingDto.page}"  class="form-control">
        	</form>
        </div>
        <!-- 검색 -->
        </div><br>
        <div class="row d-flex">
		<c:forEach var="list" items="${itemlist}">
			<div class="col-md-6 col-lg-3 ftco-animate">
				<div class="staff" onclick="location.href='/sub/shoppinginfo?ino=${list.ino}'" style="cursor: pointer;">
					<div class="img-wrap d-flex align-items-stretch">
						<div class="img align-self-stretch"
							style="background-image: url('/sellerboard/displayimages?filename=${list.item_mainimage}');"></div>
					</div>
					<div class="text pt-3 px-3 pb-4 text-center">
						<h3>${list.item_title}</h3>
						<span class="position mb-2">${list.sell_store_name}</span>
						<div class="faded">
							<p id="tagcost">${list.item_cost}</p>
							
						</div>
					</div>
				</div>
			</div>
</c:forEach>
        </div>
		<div class="row mt-5">
			<div class="col text-center">
				<div class="block-27">
					<ul>
						<c:if test="${pagingDto.startPage !=1}">
							<li><a href="/sub/shopping?page=${pagingDto.startPage-1}">&lt;</a></li>
						</c:if>
						<c:forEach begin="${pagingDto.startPage}" end="${pagingDto.endPage}" var="i">
							<li
								<c:choose>
									<c:when test="${i==pagingDto.page}">class="active"</c:when>
									<c:otherwise>class=""</c:otherwise>
								</c:choose>
							><a href="/sub/shopping?page=${i}"><span>${i}</span></a></li>
						</c:forEach>
						<c:if test="${pagingDto.endPage != pagingDto.totalPage}">
							<li><a href="/sub/shopping?page=${pagingDto.endPage+1}">&gt;</a></li>
						</c:if>	
					</ul>
				</div>
			</div>
		</div>
	</div>
</section>





<!-- footer  -->
<%@ include file="/WEB-INF/views/include/footer.jsp" %>