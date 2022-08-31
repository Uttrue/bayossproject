<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<!-- header  -->
<%@ include file="/WEB-INF/views/include/header.jsp" %>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function(){
	//초기 변수 선언
	var ino = ${iteminfo.ino};
	var cid = "${userVo.cid}";
	var item_title = "${iteminfo.item_title}";
	var sid = "${iteminfo.sid}";
	//초기 좋아요 출력
	getislike();
	//초기 좋아요 카운트 출력
	getcountlike();
	//좋아요 입력,삭제
	$("#likeheart").click(function(){
		var url = "/userlike/likestatus";
		var sData = {
				"ino" : ino,
				"cid" : cid,
				"item_title" : item_title,
				"sid" : sid
		};
		//미 로그인시 좋아요 불가
		if(cid !== null && cid !== ""){
			$.get(url,sData,function(rData){
				getislike();
				getcountlike();
			});
		}
	});
	//초기 유저 좋아요 함수
	function getislike(){
		var url = "/userlike/getislike";
		var sData = {
				"ino" : ino,
				"cid" : cid
		};
		$.get(url,sData, function(rData){
			if(rData == "true"){
				$("#likeheart").css("color", "red");
			} else if(rData == "false"){
				$("#likeheart").css("color", "gray");
			}
		});
	}
	//초기 아이템 좋아요 갯수 함수
	function getcountlike(){
		var url = "/userlike/getcountlike";
		var sData = {
				"sid" : sid,
				"ino" : ino
		};
		$.get(url, sData, function(rData){
			$(".likenumber").text(rData);
		});
	}
	//콤마 적용 - 적용 확인 데이터 넣기
	var dbcost = $("#item_cost").text();
	var cost = dbcost.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	$("#item_cost").text(cost);
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
					<div style="display: inline-block; float: right;">
						<a style="color: gray; cursor: pointer;" id="likeheart" ><i class="fa fa-heart fa-3x likenumber" aria-hidden="true">0</i></a>
					</div> 
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
						<label for="item_cost"> 물품가격</label> <%-- <input
							type="number" class="form-control" disabled id="item_cost" value="${iteminfo.item_cost}" 
							style="border: none;" /> --%>
						<div class="form-control" id="item_cost" style="border: none;" >${iteminfo.item_cost}</div>
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
					<div id="item_content">${iteminfo.item_content}</div>
				</div>
			</div>
	</div><br><br>
	<button type="button" onclick="history.back()" class="btn btn-danger">뒤로가기</button>
	</div>
</section>

<script type="text/javascript">
/* $('.selectpicker').selectpicker({
    style: 'btn-info',
    size: 4
}); */
</script>



<!-- footer  -->
<%@ include file="/WEB-INF/views/include/footer.jsp" %>