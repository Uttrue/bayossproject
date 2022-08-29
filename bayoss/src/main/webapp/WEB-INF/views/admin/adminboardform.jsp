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
<script type="text/javascript">
$(function(){
	$("#main_category").change(function(){
		var category = $("#main_category").val();
		console.log("home_category : " , category );
		if(category == "maintenence"){
			$("#detail_maintenence").show();
			$("#detail_maintenence").attr("disabled", false);
			$("#detail_supplies").hide();
			$("#detail_services").hide();
			$("#detail_supplies").attr("disabled", true);
			$("#detail_services").attr("disabled", true);
		} else if(category == "supplies"){
			$("#detail_supplies").show();
			$("#detail_supplies").attr("disabled", false);
			$("#detail_maintenence").hide();
			$("#detail_services").hide();
			$("#detail_maintenence").attr("disabled", true);
			$("#detail_services").attr("disabled", true);
		}  else if(category == "services"){
			$("#detail_services").show();
			$("#detail_services").attr("disabled", false);
			$("#detail_maintenence").hide();
			$("#detail_supplies").hide();
			$("#detail_maintenence").attr("disabled", true);
			$("#detail_supplies").attr("disabled", true);
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
				<h1>홈 글 등록</h1>
				<form role="writeForm" action="/admin/admininsertrun" method="post"
					id="frmCreate">
					<input type="hidden" name="sid" value="${sellerVo.sid}">
					<div class="form-group">
						<label for="home_category">카테고리</label>
						  <select class="form-group" id="main_category" name="main_category">
						  	<option disabled selected>카테고리</option>
						  	<option value="maintenence">maintenence</option>
						  	<option value="supplies">supplies</option>
						  	<option value="services">service</option>
						  </select>
						  
						  <select class="form-group" required id="detail_maintenence" name="detail_category" style="display: none;">
						  	<option disabled selected>카테고리</option>
						  	<option value="ict">ict</option>
						  	<option value="machinery">machinery</option>
						  	<option value="metalfabrication">metal fabrication</option>
						  </select>
						  
						  <select class="form-group" required id="detail_supplies" name="detail_category" style="display: none;">
						  	<option disabled selected>카테고리</option>
						  	<option value="bunkering">bunkering</option>
						  	<option value="spareparts">spare parts</option>
						  	<option value="consumables">consumables</option>
						  </select>
						   <select class="form-group" required id="detail_services" name="detail_category" style="display: none;">
						  	<option disabled selected>카테고리</option>
						  	<option value="internet">internet</option>
						  	<option value="pickup">pick-up</option>
						  	<option value="medicalcare">medical care</option>
						  	<option value="tour">tour</option>
						  	<option value="event">event</option>
						  </select>
						  
					</div>
					<div class="form-group">
						<label for="reglocation">등록지역</label>
						 <select class="form-group" required  name="reglocation">
							  	<option disabled selected>지역</option>
							  	<option value="Pusan">부산</option>
							  	<option value="ulsan">울산</option>
						  </select>
					</div>
					<div class="form-group">
						<label for="content"> 내용 </label>
						<textarea class="summernote" id="content"
							name="content" ></textarea>
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

	
	
</script>		


<!-- footer  -->
<%@ include file="/WEB-INF/views/include/sellerfooter.jsp"%>