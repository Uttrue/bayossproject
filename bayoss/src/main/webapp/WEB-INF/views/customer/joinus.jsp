<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  

<!-- header  -->
<%@ include file="/WEB-INF/views/include/header.jsp" %>
<!-- 제이쿼리 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script type="text/javascript">
$(function(){
	var cidcheck = "false"; /* 아이디 중복체크 여부 */
	var emailcheck = "false;" /* 이메일 인증 여부 */
	var pwcheck = "false"; /* 비밀번호 정규식 통과 */
	var pwequlcheck = "false"; /* 비밀번호 일치 여부 */
	var cellphonecheck = "false"; /* 핸드폰 정규식 통과 */
	var emailnum = "";
	/* 아이디 중복 체크 */
	$(".idcheck").click(function(){
		var cid = $("#cid").val().trim();
		console.log("cid" , cid);
		var url = "/user/isuserexist";
		var sData = {
				"cid" : cid
				};
		$.get(url,sData, function(rData){
			/* console.log("rData : " , rData); */
			if(rData == "true"){
				$("#textidcheck").text("이미 사용중인 아이디 입니다").css("color","red");
				cidcheck = "false";
			}else if (rData == "false"){
				$("#textidcheck").text("사용가능한 아이디 입니다").css("color","blue");
				cidcheck = "true";
			}
		})
	});
	/* 이메일 인증 */
	$(".btnemailsend").click(function() {
		var eamil = $("#email").val().trim(); // 이메일 주소값 얻어오기!
		console.log('완성된 이메일 : ' + eamil); // 이메일 오는지 확인
		
		
		$.ajax({
			type : "get",
			url : "/user/mailCheck?email=" + eamil, 
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
	
	
	/* 가입 완료 전송시 */
	$(".btnjoin").click(function(){
		console.log("cidcheck" , cidcheck);
		console.log("emailcheck" , emailcheck);
		console.log("pwcheck" , pwcheck);
		console.log("pwequlcheck" , pwequlcheck);
		console.log("cellphonecheck" , cellphonecheck);
		/* 1. 비밀번호 체크 */
		chkPW();
		/* 2. 비밀번호 일치 확인 */
		
		if(pwcheck == "true"){
			var pw = $("#cpw").val().trim();
			var pw2 = $("#cpw2").val().trim();
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
	    if (cidcheck == "true" && emailcheck == "true" &&
	    		pwcheck == "true" && pwequlcheck == "true" &&
	    		cellphonecheck == "true"){
	    	$("#fmtsignup").submit();
	    }
	    
	});
	
	

	
	/* 비밀번호 정규식 함수 8~20자,영문,숫자,특수문자 포함 */
	function chkPW(){
		var pw = $("#cpw").val().trim();
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
});
</script>
</head>
<body>
	<div class="container-fluid">
	<div class="row sellerjoindiv" >
		<div class="col-md-4">
		</div>
		<div class="col-md-4" style="margin-bottom: 5%;">
				<div><br>
				</div>
				<form role="form" id="fmtsignup" action="/user/userjoinrun" method="post">
					<div class="form-row">
						<label for="cid"> ID </label>
					</div>
					<div class="form-row">	
						<div class="col-sm-9">	
							<input type="text" class="form-control" id="cid" name="cid" />
						</div>
						<div class="col-sm-3">	
							<button type="button" class="btn btn-primary idcheck" style="margin-top: 3%;float: right;">중복확인</button>
						</div>
					</div>
					<div class="form-group">
						<div id="textidcheck"></div>
					</div>
					<div class="form-row">

						<label for="spw"> PW </label> <input
							type="password" class="form-control" id="cpw" name="cpw"/>
					</div>
					<div class="form-row">

						<label for="spw2"> PW check </label> <input
							type="password" class="form-control" id="cpw2" />
					</div>
					<div class="form-row">
						<div id="pwmatch"></div><br>
					</div>
					<div class="form-row">
						<label for="email"> E-mail </label>
					</div>
					<div class="form-row">
						<div class="col-sm-9">	
						<input type="email" class="form-control" id="email" name="email" />
						</div>
						<div class="col-sm-3">	
						<button type="button" class="btn btn-primary btnemailsend" style="margin-top: 3%; float: right;">인증번호전송</button>
						</div>
					</div>
					<div class="form-row">
						<label for="cell"> authentication code number </label> 
					</div>
					<div class="form-row">
					<div class="col-sm-9">
						<input type="text" class="form-control" placeholder="please enter the six-digit authentication code number" id="mailcheckinput" disabled/>
						</div>
						<div class="col-sm-3">
						<button type="button" class="btn btn-primary btnemailcheck" disabled style="margin-top: 3%; float: right;">인증번호확인</button>
					</div>
					</div>
					<div class="form-row">

						<label for="shipname"> ship name </label> <input
							type="text" class="form-control" placeholder="blank space available" id="shipname" name="shipname"/>
					</div>
					<div class="form-row">

						<label for="address"> address </label> <input
							type="text" class="form-control" placeholder="blank space available" id="address" name="address"/>
					</div>
					<div class="form-group">
						<label for="cell"> cellphone </label> <input
							type="number" class="form-control" placeholder="only number" id="cellphone" name="cellphone" />
					</div>
					<button type="button" class="btn btn-primary btnjoin">join</button>
					<button style="float: right;" type="button" class="btn btn-primary"
					 onclick="history.back()">cancel</button>
					 
				</form>
			</div>
		<div class="col-md-4">
		</div>
	</div>
</div>

<!-- footer  -->
<%@ include file="/WEB-INF/views/include/footer.jsp" %>