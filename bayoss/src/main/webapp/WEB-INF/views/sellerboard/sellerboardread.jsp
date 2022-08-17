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
<script type="text/javascript">
$(function(){
	//대표이미지 미리보기 버튼
	$(".btnpreview").click(function(){
		$("#preview").attr("src","/sellerboard/displayimages?filename=${iteminfo.item_mainimage}");
		$("#image_delete").show();
	});
	//물품 등록 여부
	var insert_result = "${insert_result}";
	//물품 업데이트 여부
	var update_result = "${update_result}";
	
	if(insert_result == "true"){
		alert("물품 정상 등록");
	} else if(insert_result == "false"){
		alert("물품 등록 실패");
	}
	if(update_result == "true"){
		alert("물품 정상 업데이트");
	} else if(update_result == "false"){
		alert("물품 업데이트 실패");
	}
	
	//스크롤 다운시 컨텐츠 출력. 대기 삭제 예정
/* 	$(window).scroll(function(){
		if($(window).scrollTop() == $(document).height() - $(window).height()){
			console.log("scrolldown");
			$("#item_content").html('${iteminfo.item_content}');
		}
	}); */
	//아이템 수정 버튼
	$("#itemupdate").click(function(e){
		console.log("click");
		$("form").attr("action","/sellerboard/sellupdateform");
		$("form").attr("method", "get");
	});
	
	
	
});

</script>
</head>

<body>
	<div class="container-fluid" id="container-wrapper">
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-8">
				<h1>등록물품보기</h1>
				<div class="row">
				<form role="form">
		<div class="form-group">
		<label for="item_title"> 메인이미지</label>
			<img src="/sellerboard/displayimages?filename=${iteminfo.item_mainimage}" width="100%;">
		</div>
				
					<input type="hidden" value="${iteminfo.ino}" name="ino">
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
						<label for="item_amount"> 수량</label>
						<input
							type="number" class="form-control" disabled id="item_amount" value="${iteminfo.item_amount}" 
							style="border: none;" />
						
					</div>
					<div class="form-group">
						<span> <label for="item_start_date"> 판매시작일 </label> <label
							for="item_end_date"> 판매종료일 </label> <br>
						</span> <span> <input type="date" id="item_start_date"
							name="item_start_date" min="" value="${iteminfo.item_start_date}" disabled> <input type="date"
							id="item_end_date" name="item_end_date" min="0000-00-00" value="${iteminfo.item_end_date}"disabled>
						</span>
					</div>
					<div class="form-group">
						<label for="item_status">물품상태</label>
						  <select class="form-group" name="item_status" disabled>
						  	<option disabled>상태</option>
						  	<option value="T" disabled <c:if test="${iteminfo.item_status eq 'T'}">selected</c:if>
						  	>서비스중</option>
						  	<option value="F" disabled<c:if test="${iteminfo.item_status eq 'F'}">selected</c:if>
						  	>숨김중</option>
						  </select>
					</div>
					<div class="form-group">
						<label for="item_content"> 내용 </label>
						<div id="item_content">${iteminfo.item_content}</div>
					</div>
					<button type="submit" class="btn btn-primary" id="itemupdate">수정하기</button>
					<a href="/sellerboard/selllist?sid=${iteminfo.sid}" class="btn btn-warning">목록리스트</a>
		</form>
			
		</div> <!-- row -->
		<div class="row">
			<div class="col-md-12">		
				
			</div>
	</div>

			</div>
			<div class="col-md-3"></div>
		</div>
<script>
	// 썸머노트
	$('.summernote').summernote(
					{
						// 에디터 높이
						height : 350,
						// 에디터 한글 설정
						lang : "ko-KR",
						// 에디터에 커서 이동 
						focus : true,
						toolbar : [
								// 글꼴 설정
								[ 'fontname', [ 'fontname' ] ],
								// 글자 크기 설정
								[ 'fontsize', [ 'fontsize' ] ],
								// 굵기, 기울임꼴, 밑줄,취소 선, 서식지우기
								[
										'style',
										[ 'bold', 'italic', 'underline',
												'strikethrough', 'clear' ] ],
								// 글자색
								[ 'color', [ 'forecolor', 'color' ] ],
								// 표만들기
								[ 'table', [ 'table' ] ],
								// 글머리 기호, 번호매기기, 문단정렬
								[ 'para', [ 'ul', 'ol', 'paragraph' ] ],
								// 줄간격
								[ 'height', [ 'height' ] ],
								// 그림첨부, 링크만들기, 동영상첨부
								[ 'insert', [ 'picture', 'link', 'video' ] ],

								// 코드보기, 확대해서보기, 도움말
								[ 'view', [ 'codeview', 'fullscreen', 'help' ] ] ],
						// 추가한 글꼴
						fontNames : [ 'Arial', 'Arial Black', 'Comic Sans MS',
								'Courier New', '맑은 고딕', '궁서', '굴림체', '굴림',
								'돋음체', '바탕체' ],
						// 추가한 폰트사이즈
						fontSizes : [ '8', '9', '10', '11', '12', '14', '16',
								'18', '20', '22', '24', '28', '30', '36', '50',
								'72' ],
						// 이미지 업로드시
						callbacks : {
							onImageUpload : function(files, editor, welEditable){
								console.log("rData 피드백 전: " ,files[0]);
								var file = files[0];
								var formData = new FormData();
								formData.append("file", file);
								
								$.ajax({
									processData : false,
									contentType : false,
									type : "post",
									async : "true",
									url : "/sellerboard/uploadSummernoteImageFile",
									data : formData,
									success : function(rData){
										console.log("rData 피드백 : " , rData);
										/*  $('.summernote').append("<p><img src='/sellerboard/displayimages?filename=" + rData+"'></p>"); */
										$('.summernote').summernote('editor.insertImage',
												"/sellerboard/displayimages?filename=" + rData);
									}
								});
							}
						}
					});

	// 썸머노트 이미지 업로드
	function uploadSummernoteImageFile(file) {
		data = new FormData();
		data.append("file", file);
		$.ajax({
			data : data,
			type : "POST",
			url : "/sellerboard/uploadSummernoteImageFile",
			contentType : false,
			enctype : 'multipart/form-data',
			processData : false,
			success : function(data) {
				$('.summernote').summernote('insertImage',
						"/sellerboard/summerimages?filename=" + data);
			},
			error : function(e) {
				console.log(e)
			}
		});
	}

	// 대표 이미지 미리보기
	$(function() {
		$("#file").on("change", function() {
			readURL(this);
		});
	});

	function readURL(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				$("#preview").attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
			$("#image_delete").show();
		}
	}

	// 대표 이미지 삭제하기
	$(document).ready(function() {
		$("#image_delete").click(function() {
			console.log($("#file").val());
			$("#file").val("");
			$("#preview").attr("src", "");
			$("#image_delete").hide();
		});
	});
	// 판매 시작일 최소날짜
	var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth() + 1; //1월은 0
	var yyyy = today.getFullYear();
	if (dd < 10) {
		dd = '0' + dd;
	}
	if (mm < 10) {
		mm = '0' + mm;
	}
	today = yyyy + '-' + mm + '-' + dd;
	document.getElementById("item_start_date").setAttribute("min", today);
	// 판매 종료일 최소날짜
	$(item_start_date).change(function() {
		var start_date = $("#item_start_date").val();
		console.log(start_date);
		$("#item_end_date").attr("min", start_date);
	});
</script>	
	

<!-- footer  -->
<%@ include file="/WEB-INF/views/include/sellerfooter.jsp"%>