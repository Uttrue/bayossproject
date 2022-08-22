<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  

<!-- header  -->
<%@ include file="/WEB-INF/views/include/sellerheader.jsp" %>

<script type="text/javascript">
$(function(){
	var emailcheck = "false;" /* 이메일 인증 여부 */
	var pwcheck = "false"; /* 비밀번호 정규식 통과 */
	var pwequlcheck = "false"; /* 비밀번호 일치 여부 */
	var cellphonecheck = "false"; /* 핸드폰 정규식 통과 */
	var emailnum = "";
	
	/* 이메일 인증 */
	$(".btnemailsend").click(function() {
		var eamil = $("#email").val().trim(); // 이메일 주소값 얻어오기!
		console.log('완성된 이메일 : ' + eamil); // 이메일 오는지 확인
		
		
		$.ajax({
			type : "get",
			url : "/seller/mailCheck?email=" + eamil, 
			success : function (data) {
				console.log("data : " +  data);
				$(".btnemailcheck").attr('disabled',false);
				$("#mailcheckinput").attr('disabled',false);
				emailnum =data;
				alert('인증번호가 전송되었습니다.')
			}			
		}); // end ajax
	}); // end send eamil	
	/* 이메일 인증 확인 */
	$(".btnemailcheck").click(function(){
		var input = $("#mailcheckinput").val().trim();
		if(input == emailnum){
			alert("메일 인증 완료");
			emailcheck = "true";
			$(".btnemailcheck").attr('disabled',true);
			$("#mailcheckinput").attr('disabled',true);
		} else {
			alert("메일 인증 실패");
			emailcheck = "false";
		}
	});
	//수정버튼 클릭시 활성화
	$("#btnupdate").click(function(){
		$("#btnupdate").hide();
		$(".btnupdaterun").show();
		$(".disabledgroup").removeAttr("disabled");
		
	});
	
	/* 가입 완료 전송시 */
	$(".btnupdaterun").click(function(){
		/* 1. 비밀번호 체크 */
		chkPW();
		/* 2. 비밀번호 일치 확인 */
		
		if(pwcheck == "true"){
			var pw = $("#spw").val().trim();
			var pw2 = $("#spw2").val().trim();
			if(pw == pw2){
				$("#pwmatch").text("비밀번호 일치함").css("color","blue");
				pwequlcheck = "true";
			}else{
				$("#pwmatch").text("비밀번호를 확인해주세요").css("color","red");
				pwequlcheck = "false";
			}
		}
		/* 3. 핸드폰 번호 확인  */
		var phonenum = $("#cellphone").val().trim();

	    var regPhone = /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/;
	    if (regPhone.test(phonenum) === true) {
          	/* alert('입력된 값은 휴대전화번호입니다.'); */
	    	cellphonecheck = "true";
      	} else if(regPhone.test(phonenum) === false){
      		alert('휴대전화 번호를 입력해 주세요');
      		cellphonecheck = "false";
      	}
	    
	    /* form 전송전 조건 체크 요건 모두 true 일때 전송 */
	    if (emailcheck == "true" &&
	    		pwcheck == "true" &&pwequlcheck == "true" &&
	    		cellphonecheck == "true"){
	    	$("#fmtsignup").submit();
	    }
	    
	});
	
	

	
	/* 비밀번호 정규식 함수 8~20자,영문,숫자,특수문자 포함 */
	function chkPW(){
		var pw = $("#spw").val().trim();
		var num = pw.search(/[0-9]/g);
		var eng = pw.search(/[a-z]/ig);
		var spe = pw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
	
		if(pw.length < 8 || pw.length > 20){
	
		  alert("8자리 ~ 20자리 이내로 입력해주세요.");
		  return false;
		}else if(pw.search(/\s/) != -1){
		  alert("비밀번호는 공백 없이 입력해주세요.");
		  return false;
		}else if(num < 0 || eng < 0 || spe < 0 ){
		  alert("영문,숫자, 특수문자를 혼합하여 입력해주세요.");
		  return false;
		}else {
			pwcheck = "true";
		    return true;
		}
	}
	//업데이트 후
	var update_result = "${update_result}";
	if(update_result == "true"){
		alert("업데이트 성공");
	}else if(update_result == "false"){
		alert("업데이트 실패");
	}
});
</script>
</head>
<body>
	<div class="container-fluid">
	<div class="row sellerjoindiv" >
		<div class="col-md-3"></div>
		<div class="col-md-4" style="margin-bottom: 5%;">
				<div><br>
					<h1>셀러 정보보기</h1>
				</div>
				<form role="form" id="fmtsignup" action="/seller/sellerupdaterun" method="post">
				<input type="hidden" name="sid" value="${sellerVo.sid}">
					<div class="form-row">
						<label for="sid"> 아이디 </label>
					</div>
					<div class="form-row">	
						<div class="col-sm-9">	
							<input type="text" class="form-control" disabled value="${sellerVo.sid}" />
						</div>
						<div class="col-sm-3">	
							<button type="button" class="btn btn-primary idcheck disabledgroup" disabled style="margin-top: 3%;float: right;">중복확인</button>
						</div>
					</div>
					<div class="form-group">
						<div id="textidcheck"></div>
					</div>
					<div class="form-row">

						<label for="spw"> 비밀번호 </label> <input
							type="password" class="form-control disabledgroup" id="spw" name="spw" disabled/>
					</div>
					<div class="form-row">

						<label for="spw2"> 비밀번호확인 </label> <input
							type="password" class="form-control disabledgroup" id="spw2" disabled />
					</div>
					<div class="form-row">
						<div id="pwmatch"></div><br>
					</div>
					<div class="form-row">
						<label for="email"> 이메일 </label>
					</div>
					<div class="form-row">
						<div class="col-sm-9">	
						<input type="email" class="form-control disabledgroup" id="email" name="email" disabled value="${sellerVo.email}"/>
						</div>
						<div class="col-sm-3">	
						<button type="button" class="btn btn-primary btnemailsend disabledgroup" disabled style="margin-top: 3%; float: right;">인증번호전송</button>
						</div>
					</div>
					<div class="form-row">
						<label for="cell"> 이메일 인증번호 </label> 
					</div>
					<div class="form-row">
					<div class="col-sm-9">
						<input type="text" class="form-control" id="mailcheckinput" disabled/>
						</div>
						<div class="col-sm-3">
						<button type="button" class="btn btn-primary btnemailcheck" disabled style="margin-top: 3%; float: right;">인증번호확인</button>
					</div>
					</div>
					<div class="form-group">
						<label for="cell"> 핸드폰번호 </label> <input
							type="number" class="form-control disabledgroup" id="cellphone" name="cellphone" disabled value="${sellerVo.cellphone}"/>
					</div>
					<button type="button" class="btn btn-primary" id="btnupdate">수정</button>
					<button type="button" class="btn btn-warning btnupdaterun" style="display: none;">수정</button>
					<button style="float: right;" type="button" class="btn btn-primary"
					 onclick="history.back()">취소</button>
					 
				</form>
			</div>
		<div class="col-md-5"></div>
</div>


<!-- footer  -->
<%@ include file="/WEB-INF/views/include/sellerfooter.jsp" %>