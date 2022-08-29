<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
				<form role="form" action="/user/userloginrun" method="post">
					<div class="form-group">
						<label for="id"> ID </label> <input type="text"
							class="form-control" id="id" name="cid"/>
					</div>
					<div class="form-group">

						<label for="pw"> password </label> <input
							type="password" class="form-control" id="pw" name="cpw"/>
					</div>
					<div class="checkbox">
						<label> <input type="checkbox" /> ID save</label>
					</div>
					<button type="submit" class="btn btn-primary">login</button>
					<a style="float: right;" type="button" class="btn btn-primary"href="/user/joinus">joinus</a>
					
				</form>
				<br>
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>

<!-- footer  -->
<%@ include file="/WEB-INF/views/include/footer.jsp" %>