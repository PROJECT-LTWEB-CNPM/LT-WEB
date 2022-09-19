<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="tags" tagdir="/WEB-INF/tags"%>


<head>
<style>
.main {
	padding-top: 6rem;
}

.product__inner {
	display: flex;
	justify-content: space-between;
	flex-direction: row;
	margin: 10px 0 40px 0;
}

.container_product_img {
	flex-basis: 48%;
}

.product_img {
	padding-top: 100%;
	background-repeat: no-repeat;
	background-size: contain;
	background-position: center;
}

.product_info {
	flex-basis: 48%;
}

.product_info-name {
	position: relative;
	top: -2px;
	font-size: 2.8rem;
	color: var(- -text-color);
	line-height: 2.8rem;
	margin-bottom: 20px;
}

.home-product-item__price {
	margin-bottom: 8px;
}

.home-product-item__price-current {
	font-size: 2.6rem;
	font-weight: 600;
	color: red;
	margin-right: 16px;
}

.home-product-item__price-old {
	font-size: 1.6rem;
	font-weight: 600;
	text-decoration: line-through;
}

.product_info-more {
	font-size: 1.8rem;
	line-height: 2.2rem;
	margin-bottom: 20px;
}

.product_info-size {
	display: flex;
	flex-direction: row;
	align-items: center;
	margin-bottom: 20px;
}

.product_info-size-label {
	color: var(- -text-color);
	font-size: 1.8rem;
	margin-right: 10px;
}

.product_info-size-general {
	width: 47px;
	height: 47px;
	text-align: center;
	vertical-align: middle;
	margin-right: 10px;
	border: 1px solid #000;
	border-radius: 10px;
	font-weight: 500;
	font-size: 1.6rem;
	cursor: pointer;
	background-color: #fff;
}

.product_info-size-active {
	background-color: #9999FF;
	color: #fff;
}

.product_info-quantity {
	display: flex;
	flex-direction: row;
	align-items: center;
	margin-bottom: 24px;
}

.product_info-quantity-label {
	color: var(- -text-color);
	font-size: 1.8rem;
	margin-right: 10px;
}

.product_info-quantity-subtraction, .product_info-quantity-number,
	.product_info-quantity-add {
	height: 30px;
	text-align: center;
	vertical-align: middle;
	border: 1px solid #000;
	border-radius: 10px;
	color: var(- -text-color);
	font-size: 1.8rem;
	font-weight: 500;
	margin-right: 10px;
	cursor: pointer;
	background-color: #fff;
}

.product_info-quantity-subtraction, .product_info-quantity-add {
	width: 30px;
}

.product_info-quantity-number {
	width: 100px;
}

.some_more_img_lable {
	font-size: 1.8rem;
	color: var(- -text-color);
	margin-bottom: 12px;
}

.some_more_img {
	display: flex;
	flex-direction: row;
	height: 60px;
	width: 100%;
	margin-bottom: 40px;
}

.member-item {
	margin-right: 10px;
	cursor: pointer;
}

.member-img {
	width: 60px;
	height: 100%;
}

.home-product-item__img {
	padding-top: 100%;
	background-repeat: no-repeat;
	background-size: contain;
	background-position: center;
}

.btn_container {
	display: flex;
	flex-direction: row;
	align-items: center;
	justify-content: space-between;
}

.btn_cart {
	display: flex;
	flex-direction: row;
	align-items: center;
	justify-content: center;
	min-width: 220px;
	height: 42px;
	border: 1px solid #000;
	border-radius: 10px;
	background-color: #fff;
	color: var(- -text);
	cursor: pointer;
}

.btn_cart ion-icon {
	font-size: 2.8rem;
	margin-left: 12px;
	vertical-align: middle;
}
</style>
</head>
<%
request.setCharacterEncoding("utf-8");
%>

<tags:base title="CAMERA T-SHIRT/ROSE GREY - SHOPLANE"
	css="../../assets/css/index.css">
	<jsp:include page="../header.jsp" />
	<main class="main">
		<div class="container">
			<div class="product__inner">
				<div class="container_product_img">
					<div class="product_img"
						style="background-image: url(https://cf.shopee.vn/file/fe2451710511f9ddb24d33dcf1621345);">
					</div>
				</div>
				<div class="product_info">
					<h3 class="product_info-name">ILLUSION T-SHIRT/DARK BROWN</h3>
					<div class="home-product-item__price">
						<span class="home-product-item__price-current">69,000₫</span> <span
							class="home-product-item__price-old">390,000₫</span>
					</div>
					<p class="product_info-more">
						Thông tin sản phẩm: ILLUSION T-SHIRT. HOẠ TIẾT: IN LỤA U.S.A <br>
						INK.COLOR: DARK BROWN SIZE: M / L / XL.<br> MATERIAL: PREMIUM
						COTTON.
					</p>
					<div class="product_info-size">
						<h3 class="product_info-size-label">KÍCH THƯỚC:</h3>
						<button class="product_info-size-general product_info-size-active">M</button>
						<button class="product_info-size-general">L</button>
						<button class="product_info-size-general">XL</button>
					</div>
					<div class="product_info-quantity">
						<h3 class="product_info-quantity-label">SỐ LƯỢNG:</h3>
						<button class="product_info-quantity-subtraction">-</button>
						<button class="product_info-quantity-number">1</button>
						<button class="product_info-quantity-add">+</button>
					</div>
					<h3 class="some_more_img_lable">XEM THÊM HÌNH ẢNH</h3>
					<div class="some_more_img">
						<div class="member-item">
							<img class="member-img"
								src="https://cf.shopee.vn/file/fe2451710511f9ddb24d33dcf1621345"
								alt="Name">
						</div>

						<div class="member-item">
							<img class="member-img"
								src="https://cf.shopee.vn/file/fe2451710511f9ddb24d33dcf1621345"
								alt="Name">
						</div>

						<div class="member-item">
							<img class="member-img"
								src="https://cf.shopee.vn/file/fe2451710511f9ddb24d33dcf1621345"
								alt="Name">
						</div>
					</div>
					<div class="btn_container">
						<button class="btn_cart">
							<h3 class="btn_cart-lable">THÊM VÀO GIỎ HÀNG</h3>
							<ion-icon name="cart"></ion-icon>
						</button>
						<button class="btn_cart">
							<h3 class="btn_cart-lable">MUA NGAY</h3>
							<ion-icon name="checkmark-outline"></ion-icon>
						</button>
					</div>
				</div>
			</div>
		</div>
	</main>
	<jsp:include page="../footer.jsp" />
</tags:base>
