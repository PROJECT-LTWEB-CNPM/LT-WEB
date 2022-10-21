<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="models.User"%>

<%
request.setCharacterEncoding("utf-8");
String context = request.getContextPath() + "/default/cart/checkouts";
String url = request.getContextPath();
User u = (User) session.getAttribute("user");
if (u != null) {
	url = "./checkouts.jsp";
} else {
	url = url + "/default/account/login/index.jsp";
	session.setAttribute("caller", "/default/cart/index.jsp");
}
%>

<!doctype html>
<html lang="en">
<head>
<jsp:include page="../../head.jsp" />
<link rel="stylesheet" href="<%=context%>/index.css" />
<title>Tất cả sản phẩm - SHOPLANE</title>
<style>
.main {
	padding-top: 6rem;
}
</style>
</head>
<body>
	<div id="app">
		<jsp:include page="../../header/header.jsp" />
		<main class="main">
			<div class="container">
				<div class="order__container">
					<div class="order__top">
						<div class="order__left">
							<h3 class="order__heading">GIỎ HÀNG</h3>
							<div class="order__list">
								<%
								for (int i = 0; i < 3; i++) {
								%>
								<div class="order__item">
									<img class="order__image"
										src="https://product.hstatic.net/200000305259/product/vgc-tee_mockup_sep22-art_play-red_1_df951b2ad8fd4e2d8d9f1a635a58f6d9_master.jpg"
										width="100" height="100" alt="UPGRADE PLAY T-SHIRT/RED" />
									<div class="order__content">
										<div class="order__row order__group">
											<strong class="order__group-name">UPGRADE PLAY
												T-SHIRT/RED</strong>
											<button class="order__remove-btn">XÓA SẢN PHẨM</button>
										</div>
										<div class="order__row">KÍCH THƯỚC: XL</div>
										<div class="order__quanty order__row">
											<span class="order__quanty-title">SỐ LƯỢNG:</span>
											<div class="order__quanty-action">
												<button type="button" class="order__quanty-btn">-</button>
												<input type="text" size="1" name="updates" min="1" id=""
													data-price="" value="1" class="btn qty-btn">
												<button type="button" class="order__quanty-btn">+</button>
											</div>
										</div>
										<div class="order__total">69000₫</div>
									</div>
								</div>
								<%
								}
								%>
							</div>
						</div>
						<div class="order__right">
							<h3 class="order__heading">ĐƠN HÀNG</h3>
							<div class="order__payment">
								<span class="title_order order_item">Tổng tiền:</span> <span
									class="order__payment-price">270000₫</span>
							</div>
							<a class="btn-submit" href="<%=url%>"> <span
								class="btn_cart-lable">THANH TOÁN</span> <ion-icon name="cart"></ion-icon>
							</a>
						</div>
					</div>
					<div class="order__bottom">
						<a class="btn-submit" href="${pageContext.request.contextPath}/">
							QUAY LẠI TRANG CHỦ </a>
					</div>
				</div>
			</div>
		</main>
		<jsp:include page="../../footer/footer.jsp" />
	</div>

	<!-- Jquery -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"
		integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>

	<!-- Swipper Slider -->
	<script
		src="https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.min.js"></script>
</body>
</html>

