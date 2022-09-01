<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  

<!-- header  -->
<%@ include file="/WEB-INF/views/include/header.jsp" %>
<style>
.detailtitle{
	text-transform: uppercase;
}
</style>
<script type="text/javascript">
$(function(){
	$("#btnsubmit").click(function(){
		var wdate = $("#wdate").val();
		var arrdate = wdate.split('/');
		var date = arrdate.[0];
		var month = arrdate.1;
		var year = arrdate.2;
		console.log("date :" , date);
		console.log("month :" , month);
		console.log("year :" , year);
	});
});
</script>
<c:forEach items="${boardVo}" begin="0" end="0" var="boardVo">
<section class="ftco-counter" id="section-counter">
	<div class="container">
		<div class="row">
			<div
				class="col-md-6 col-lg-3 d-flex justify-content-center counter-wrap ftco-animate">
				<div class="block-18 text-center">
					<div class="detailtitle">
						<span>${boardVo.detail_category}</span>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>

<section>
	<div class="container">
		<div class="row">
		${boardVo.content}
		</div>
	</div>
</section>
</c:forEach>

<!-- 문의  -->
<section class="ftco-appointment ftco-section ftco-no-pt ftco-no-pb img"
	style="background-image: url('/resources/images/cruiseship2.jpg');">
	<div class="overlay"></div>
	<div class="container">
		<div class="row d-md-flex justify-content-end">
			<div class="col-md-12 col-lg-6 half p-3 py-5 pl-lg-5 ftco-animate">
				<h2 class="mb-4">enter consultation</h2>
				<form role="form" action="/user/service" class="appointment" method="get">
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<div class="form-field">
									<div class="select-wrap">
										<div class="icon">
											<span class="fa fa-chevron-down"></span>
										</div>
										<select id="" class="form-control" name="category">
											<option disabled selected>Select services</option>
											<option value="maintenance">maintenance Services</option>
											<option value="supplies">supplies Services</option>
											<option value="services">Service</option>
										</select>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group">
								<input type="text" class="form-control" name="service" placeholder="service">
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<input type="text" class="form-control" name="wname" placeholder="Name">
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<input type="text" class="form-control" name="shipname"
									placeholder="Ship Name">
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<input type="number" class="form-control" name="phone" placeholder="Phone">
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<input type="email" class="form-control" name="email"
									placeholder="Email">
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group">
								<div class="input-wrap">
									<div class="icon">
										<span class="fa fa-calendar"></span>
									</div>
									<input type="text" class="form-control appointment_date" id="wdate"name="wdate"
										placeholder="Date">
								</div>
							</div>
						</div>
						
						<div class="col-md-12">
							<div class="form-group">
								<textarea id="" cols="30" rows="7" class="form-control"
									placeholder="Message" name="message"></textarea>
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group">
								<input type="submit" id="btnsubmit" value="Send message"
									class="btn btn-primary py-3 px-4">
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</section>
<!-- footer  -->
<%@ include file="/WEB-INF/views/include/footer.jsp" %>