<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  

<!-- header  -->
<%@ include file="/WEB-INF/views/include/header.jsp" %>



<section class="ftco-counter" id="section-counter">
	<div class="container">
		<div class="row">
			<div
				class="col-md-6 col-lg-3 d-flex justify-content-center counter-wrap ftco-animate">
				<div class="block-18 text-center">
					<div class="detailtitle">
						<span>ABOUT US</span>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<br>

<section class="ftco-section ftco-no-pt ftco-no-pb">
	<div class="container">
		<div class="row d-flex no-gutters">
			<div class="col-md-5 d-flex">
				<div id="map" style="width:500px;height:400px;"></div>
			</div>
			<div class="col-md-7 pl-md-5 py-md-5">
				<div class="heading-section pt-md-5">
					<h2 class="mb-4">회사 위치</h2>
				</div>
				<div class="row">
					<div class="col-md-6 services-2 w-100 d-flex">
						<div class="icon d-flex align-items-center justify-content-center">
							<h3 style="color: white;">1</h3>
						</div>
						<div class="text pl-3">
							<h4>Fast</h4>
							<p>Far far away, behind the word mountains, far from the
								countries.</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<br>
</section>


<!-- 카카오 지도 API -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=5b0eeb004f01ba8fd0412112930a2365&libraries=services"></script>

<script type="text/javascript">

	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	mapOption = {
		center : new kakao.maps.LatLng(35.117584, 129.092435), // 지도의 중심좌표
		level : 3
	// 지도의 확대 레벨
	};

	//지도를 생성합니다    
	var map = new kakao.maps.Map(mapContainer, mapOption);

	//주소-좌표 변환 객체를 생성합니다
	var geocoder = new kakao.maps.services.Geocoder();

	//주소로 좌표를 검색합니다
	geocoder.addressSearch(
					'부산 남구 신선로 365 부경대학교 창업보육센터 제10공학관 ',
					function(result, status) {

						// 정상적으로 검색이 완료됐으면 
						if (status === kakao.maps.services.Status.OK) {

							var coords = new kakao.maps.LatLng(result[0].y,
									result[0].x);

							// 결과값으로 받은 위치를 마커로 표시합니다
							var marker = new kakao.maps.Marker({
								map : map,
								position : coords
							});

							// 인포윈도우로 장소에 대한 설명을 표시합니다
							var infowindow = new kakao.maps.InfoWindow(
									{
										content : '<div style="width:150px;text-align:center;padding:6px 0;">하버맥스</div>'
									});
							infowindow.open(map, marker);

							// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
							map.setCenter(coords);
						}
					});
</script>



<!-- footer  -->
<%@ include file="/WEB-INF/views/include/footer.jsp" %>