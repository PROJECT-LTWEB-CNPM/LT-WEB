<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<head>
<style>
.swiper {
	height: 40rem;
}

.swiper-slide__img {
	width: inherit;
	height: 50rem;
	background-size: cover;
	background-position: center;
	background-repeat: no-repeat;
}
</style>
</head>

<section>
	<!-- Slider main container -->
	<div class="swiper">
		<!-- Additional required wrapper -->
		<div class="swiper-wrapper">
			<!-- Slides -->
			<%
			for (int i = 0; i < 4; i++) {
			%>
			<div class="swiper-slide">
				<div class="swiper-slide__img"
					style="background-image: url(https://theme.hstatic.net/200000305259/1000922697/14/slide_index_1_master.jpg?v=213);">
				</div>
			</div>
			<%
			}
			%>
		</div>
		<!-- If we need pagination -->
		<div class="swiper-pagination"></div>

		<!-- If we need navigation buttons -->
		<div class="swiper-button-prev"></div>
		<div class="swiper-button-next"></div>
	</div>

</section>