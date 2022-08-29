<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  

<!-- header  -->
<%@ include file="/WEB-INF/views/include/sellerheader.jsp" %>
<head>

<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script> -->
<!-- 서머노트를 위해 추가해야할 부분 -->
<script src="/resources/summerNote/summernote-lite.js"></script>
<script src="/resources/summerNote/summernote-ko-KR.js"></script>
<link rel="stylesheet" href="/resources/summerNote/summernote-lite.css">

</head>

<body>
	<div class="container-fluid" id="container-wrapper">
		
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-8">
				<h1>물품 등록</h1>
				<form role="writeForm" action="/sellerboard/sellinsertrun" method="post"
					id="frmCreate" enctype="multipart/form-data" accept-charset="UTF-8">
					<input type="hidden" name="sid" value="${sellerVo.sid}">
					<input type="hidden" name="sell_store_name" value="${storeInfo.sell_store_name}">
					<input type="hidden" name="reglocation" value="${storeInfo.reglocation}">
					<div class="form-group">
						<label for="item_title">물품명</label> <input type="text"
							class="form-control" id="item_title" name="item_title" />
					</div>
					<div class="form-group">
						<label for="item_cost">물품가격</label> <input type="number"
							class="form-control" id="item_cost" name="item_cost" />
					</div>
					<div class="form-group">
						<label for="item_amount">물품수량</label> <input type="number"
							class="form-control" id="item_amount" name="item_amount" />
					</div>
					<div class="form-group">
						<span> <label for="item_start_date"> 판매시작일 </label> <label
							for="item_end_date"> 판매종료일 </label> <br>
						</span> <span> <input type="date" id="item_start_date"
							name="item_start_date" min=""> <input type="date"
							id="item_end_date" name="item_end_date" min="0000-00-00">
						</span>
					</div>

					<div class="form-group">
						<label for="item_mainimage" id="item_mainimage"> 대표 이미지 업로드 </label> <input
							type="file" class="form-control-file" id="file" name="file" /> <img
							id="preview" src="/resources/images/no_image.jpg" width="200px"><br>
						<a id="image_delete" style="display: none;">사진 삭제 <b
							style="color: red; font-size: 30px; cursor: pointer;">&times;</b></a>
					</div>

					<div class="form-group">
						<label for="item_content"> 내용 </label>
						<textarea class="summernote" id="item_content"
							name="item_content" ><font color="red">== 
							1.이미지 배율을 꼭 지정해주세요.
							2.파일 이름은 영어로 해주세요 (이 글은 지우셔도 됩니다)==</font></textarea>
					</div>
					<div class="form-group">
						<label for="item_status">물품상태</label>
						  <select class="form-group" required name="item_status">
						  	<option value="T" selected>서비스중</option>
						  	<option value="F">숨김중</option>
						  </select>
					</div>
					<button type="submit" class="btn btn-primary">저장</button>
					<button type="button" onclick="history.back()" class="btn btn-danger">취소</button>
				</form>

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