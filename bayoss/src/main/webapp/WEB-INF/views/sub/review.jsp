<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  

<!-- header  -->
<%@ include file="/WEB-INF/views/include/header.jsp" %>


<section class="ftco-counter" id="section-counter">
	<div class="container">
		<div class="row">
			<div
				class="col-md-6 col-lg-3 d-flex justify-content-center counter-wrap ftco-animate">
				<div class="block-18 text-center">
					<div class="detailtitle">
						<span>Review</span>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<section>
	<div class="container">
		<div class="row" style="margin: 1%;">
			<select id="searchType" name="searchType" >
				<option disabled selected>선택</option>
				<option value="item_title"
					<c:if test="">selected</c:if>
				>물품명</option>
				<option value="sell_store_name"
					<c:if test="">selected</c:if>
				>업체명</option>
				<option value="userid"
					<c:if test="">selected</c:if>
				>아이디</option>
			</select>
			<input type="text" name="keyword" id="keyword" style="margin-left: 1%;">
			<button type="button" class="btn btn-primary" style="margin-left: 1%;">검색</button>
		</div>
	
		<div class="row">
			<table class="table">
				<thead>
					<tr>
						<th>#</th>
						<th>물품명</th>
						<th>아이디</th>
						<th>등록일</th>
						<th>업체명</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach begin="1" end="10" varStatus="status">
					<tr>
						<td>${status.count}</td>
						<td>TB - Monthly</td>
						<td>01/04/2012</td>
						<td>Default</td>
						<td>Default</td>
					</tr>
				</c:forEach>	
				</tbody>
			</table>
			<a type="button" class="btn btn-primary" href="/user/writeform">글쓰기</a>
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