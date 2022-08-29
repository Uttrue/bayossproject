<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  

<!-- header  -->
<%@ include file="/WEB-INF/views/include/sellerheader.jsp" %>

<script type="text/javascript">
$(function(){
	//사업자 번호 체크 여부
	var regcheck = "false";
	/* 사업자 등록번호 체크 */
	$(".btnregnum").click(function(){
		var b_no = $("#sell_store_regnum").val().trim();
		var start_dt = $("#sell_store_opendate").val().trim();
		var p_nm = $("#sell_store_ceo").val().trim();
		var b_nm = $("#sell_store_name").val().trim();
	//	var corp_no = $("#sell_store_regnum").val().trim();
		console.log("b_no ; ", b_no );
		console.log("start_dt ; ", start_dt );
		console.log("p_nm ; ", p_nm );
		console.log("b_nm ; ", b_nm );
//		console.log("corp_no ; ", corp_no );
		var data = {
				"businesses": [
				    {
					    "b_no": b_no,
					    "start_dt" : start_dt,
					    "p_nm" : p_nm,
					    "b_nm" : b_nm
				    }
				    ]
			   };  

		$.ajax({
			  url: "https://api.odcloud.kr/api/nts-businessman/v1/validate?serviceKey=nPwccfcyoLZaZ45yYphiZQkUlI3zHCYTmTsh2ZmR3T0O3JO2juSVU3B%2Bln5dYM4zVUy%2FTr4YvPo8rJQz%2BYgtNw%3D%3D",  
			  type: "POST",
			  data: JSON.stringify(data), // json 을 string으로 변환하여 전송
			  dataType: "JSON",
			  contentType: "application/json",
			  accept: "application/json",
			  success: function(result) {
			      console.log(result);
			      console.log(result.data[0].valid);
			      if(result.data[0].valid == "01"){
			    	  alert("사업자 인증됨");
			    	  regcheck = "true";
			    	  $(".btnregnum").attr("disabled", true);
			      } else if(result.data[0].valid == "02"){
			    	  alert("사업자 정보를 정확히 입력해주세요");
			      }
			     // console.log(result.data.0.valid);
			      
			      /* $(".btnregnum").attr("disabled");
			      alert("사업자 인증됨"); */
			  },
			  error: function(result) {
			      console.log(result.responseText); //responseText의 에러메세지 확인
			      
			  }
		});
		
	});/* 사업자 등록번호 체크끝 */
	//등록 버튼 클릭시
	$(".btnregstore").click(function(){
		var regcheckstore;
		var sell_store_regnum = $("#sell_store_regnum").val().trim();
		var url = "/seller/sellstoreRegChk";
		var sData = {
				"sell_store_regnum" : sell_store_regnum
		}
		//비동기 사업자 확인
		$.get(url, sData, function(rData){
			if(rData == "true"){
				alert("이미 등록된 사업자 번호 입니다");
			} else if(rData == "false" && regcheck == "true"){
				$("#fmtreg").attr("action" , "/seller/sellstoreregrun");
				$("#fmtreg").attr("method" , "post");
				$("#fmtreg").submit();
			}
		});
		
	});
	
});
</script>
</head>
<body>
	<div class="container-fluid" id="container-wrapper">
		${sellerVo}
		${storeInfo}
		
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-4">
				<h1>스토어 등록</h1>
				<form role="form" id="fmtreg">

					<div>
						<input type="hidden" style="display: none;" class="form-control" id="sid"
							name="sid" value="${sellerVo.sid}"/>
					</div>

					<div class="form-group">

						<label for="sell_store_name"> 업체이름 </label> <input type="text"
							class="form-control" id="sell_store_name" name="sell_store_name" />
					</div>

					<div class="form-group">

						<label for="sell_store_ceo"> 대표자성명 </label> <input type="text"
							class="form-control" id="sell_store_ceo" name="sell_store_ceo" />
					</div>

					<div class="form-group">

						<label for="sell_store_opendate"> 개업일자 </label> <input
							type="text" class="form-control" id="sell_store_opendate"
							name="sell_store_opendate" placeholder="YYYYMMDD" />
					</div>

					<div class="form-row">
						<label for="sell_store_regnum"> 사업자등록번호 </label>
					</div>
					<div class="form-row">
						<div class="col-sm-9">
							<input type="text" class="form-control" id="sell_store_regnum"
								name="sell_store_regnum" />
						</div>
						<div class="col-sm-3">
							<button type="button" class="btn btn-primary btnregnum"
								style="margin-top: 3%; float: right;">인증하기</button>
						</div>
					</div>

					<div class="form-group">
						<label for="sell_store_phone"> 업체 연락처 </label> <input
							type="number" class="form-control" id="sell_store_phone"
							name="sell_store_phone" />
					</div>
					<div class="form-group">
						<label for="reglocation"> 등록지역</label>
						<select name="reglocation" required>
							<option selected disabled>선택</option>
							<option value="pusan">부산</option>
							<option value="ulsan">울산</option>
						</select>
					</div>
					<button type="button" class="btn btn-primary btnregstore">등록</button>
					<button style="float: right;" type="button" class="btn btn-primary"
						onclick="history.back()">취소</button>

				</form>
			</div>
			<div class="col-md-5"></div>
		</div>
		
		<!-- footer  -->
		<%@ include file="/WEB-INF/views/include/sellerfooter.jsp"%>