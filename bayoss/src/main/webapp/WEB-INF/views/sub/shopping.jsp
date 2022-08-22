<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<!-- header  -->
<%@ include file="/WEB-INF/views/include/header.jsp" %>


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
        	<form id="frmSearch" action="/sub/shpping" method="get">
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
        		<input type="hidden" id="searchType" value="${pagingDto.searchType}" class="form-control">
        		<input type="hidden" id="keyword" value="${pagingDto.keyword}" class="form-control">
        		<input type="hidden" id="page" value="${pagingDto.page}"  class="form-control">
        		<button type="button" class="btn btn-primary">검색</button>
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
							<p>${list.item_cost}</p>
							
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
						<li><a href="#">&lt;</a></li>
						<li class="active"><span>1</span></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#">&gt;</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</section>





<!-- footer  -->
<%@ include file="/WEB-INF/views/include/footer.jsp" %>