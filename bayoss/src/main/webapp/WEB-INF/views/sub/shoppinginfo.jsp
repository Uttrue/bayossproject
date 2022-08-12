<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<!-- header  -->
<%@ include file="/WEB-INF/views/include/header.jsp" %>
<script type="text/javascript">
$(function(){
	//스크롤 다운시 컨텐츠 출력
	$(window).scroll(function(){
		if($(window).scrollTop() == $(document).height() - $(window).height()){
			console.log("scrolldown");
			$("#item_content").html('${iteminfo.item_content}');
		}
	});
});
</script>

<section class="ftco-counter" id="section-counter">
	<div class="container">
		<div class="row">
			<div
				class="col-md-6 col-lg-3 d-flex justify-content-center counter-wrap ftco-animate">
				<div class="block-18 text-center">
					<div class="detailtitle">
						<span>shoppingitem</span>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>

<section class="ftco-section">
	<div class="container">
	<div class="row">
		<div class="col-md-6 form-group">
			<img src="/sellerboard/displayimages?filename=${iteminfo.item_mainimage}" width="100%;">
		</div>
		<div class="col-md-6">
				<form role="form">
					<input type="hidden" value="${iteminfo.ino}">
					<div class="form-group">
						<label for="sell_store_name"> 판매업체</label> <input
							type="text" class="form-control" disabled id="sell_store_name" value="${iteminfo.sell_store_name}" 
							style="border: none;" />
					</div>
					<div class="form-group">
						<label for="item_title"> 물품명</label> <input
							type="text" class="form-control" disabled id="item_title" value="${iteminfo.item_title}" 
							style="border: none;" />
					</div>
					<div class="form-group">
						<label for="item_cost"> 물품가격</label> <input
							type="number" class="form-control" disabled id="item_cost" value="${iteminfo.item_cost}" 
							style="border: none;" />
					</div>
					<div class="form-group">
						<label for="amount"> 수량</label>
						<select class="selectpicker" name="amount">
							<option disabled="disabled">선택</option>
							<c:forEach begin="1" end="10" var="amount">
								<option value="${amount}">${amount}</option>
							</c:forEach>
						</select>
					</div>
					
					
					<button type="submit" class="btn btn-primary">구매하기</button>
				</form>
			</div>
		</div> <!-- row -->
		<div class="row">
			<div class="col-md-12">		
				<div>
					<label for="item_content"> 내용 </label>
					<div id="item_content" style="background-color: aliceblue;"></div>
				</div>
			</div>
	</div>
	</div>
</section>

<script type="text/javascript">
$('.selectpicker').selectpicker({
    style: 'btn-info',
    size: 4
});
</script>



<!-- footer  -->
<%@ include file="/WEB-INF/views/include/footer.jsp" %>