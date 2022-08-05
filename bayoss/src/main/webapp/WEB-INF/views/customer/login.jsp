<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  

<!-- header  -->
<%@ include file="/WEB-INF/views/include/header.jsp" %>
<!-- 제이쿼리 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script type="text/javascript">
$(function(){
	var join_result = "${join_result}";
	if(join_result == "true"){
		alert("회원가입 성공");
	}else if(join_result == "false"){
		alert("회원가입 실패");
	}
});
</script>
</head>
<body>
	<div class="container-fluid">
		<div class="row sellerlogindiv">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<div><br>
				</div>
				<form role="form">
					<div class="form-group">

						<label for="id"> 아이디 </label> <input type="text"
							class="form-control" id="id" />
					</div>
					<div class="form-group">

						<label for="pw"> 비밀번호 </label> <input
							type="password" class="form-control" id="pw" />
					</div>
					<div class="checkbox">
						<label> <input type="checkbox" /> 아이디 저장</label>
					</div>
					<button type="submit" class="btn btn-primary">로그인</button>
					<a style="float: right;" type="button" class="btn btn-primary"href="/seller/sellerjoin">회원가입</a>
					
				</form>
				<br>
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>

<!-- footer  -->
<%@ include file="/WEB-INF/views/include/footer.jsp" %>