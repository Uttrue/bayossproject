<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  

<!-- header  -->
<%@ include file="/WEB-INF/views/include/header.jsp" %>

<c:forEach items="${boardVo}" begin="0" end="0" var="boardVo">
<section class="ftco-counter" id="section-counter">
	<div class="container">
		<div class="row">
			<div
				class="col-md-6 col-lg-3 d-flex justify-content-center counter-wrap ftco-animate">
				<div class="block-18 text-center">
					<div class="detailtitle">
						<span>${boardVo.main_category}</span>
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
				<form action="#" class="appointment" method="get">
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<div class="form-field">
									<div class="select-wrap">
										<div class="icon">
											<span class="fa fa-chevron-down"></span>
										</div>
										<select name="" id="" class="form-control" name="service">
											<option disabled selected>Select services</option>
											<option value="maintenance">maintenance Services</option>
											<option value="supplies">supplies Services</option>
											<option value="services">Service</option>
											<option value="shopping">shopping Service</option>
										</select>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group">
								<input type="text" class="form-control" placeholder="service">
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Name">
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<input type="text" class="form-control"
									placeholder="Ship Name">
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<input type="number" class="form-control" placeholder="Phone">
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<input type="email" class="form-control"
									placeholder="Email">
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<div class="input-wrap">
									<div class="icon">
										<span class="fa fa-calendar"></span>
									</div>
									<input type="text" class="form-control appointment_date"
										placeholder="Date">
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<div class="input-wrap">
									<div class="icon">
										<span class="fa fa-clock-o"></span>
									</div>
									<input type="text" class="form-control appointment_time"
										placeholder="Time">
								</div>
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group">
								<textarea name="" id="" cols="30" rows="7" class="form-control"
									placeholder="Message"></textarea>
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group">
								<input type="submit" value="Send message"
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