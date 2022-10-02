<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="tags" tagdir="/WEB-INF/tags"%>


<head>
<style>
.main {
	padding-top: 12rem;
	padding-bottom: 4rem;
}

.product__inner {
	display: flex;
	justify-content: space-between;
	gap: 3rem;
}

.container_product_img {
	width: 40%;
}

.product_info {
	width: 60%;
}

.product_img {
	border-radius: 0.4rem;
	width: 100%;
	height: 40rem;
	background-repeat: no-repeat;
	background-size: cover;
	background-position: center;
	background-repeat: no-repeat;
}

.product_info-name {
	font-size: 2rem;
	color: rgba(0, 0, 0, 0.7);
	margin-bottom: 1rem;
}

.home-product-item__price {
	margin-bottom: 1.2rem;
}

.home-product-item__price-current {
	font-size: 2.6rem;
	font-weight: 600;
	color: red;
	margin-right: 1rem;
}

.home-product-item__price-old {
	font-size: 1.6rem;
	font-weight: 600;
	text-decoration: line-through;
}

.product_info-more {
	font-size: 1.6rem;
	margin-bottom: 1.4rem;
}

.product_info-more>span {
	display: block;
	margin-bottom: 0.5rem;
	font-weight: 500;
	color: #333;
}

.product_info-size {
	display: flex;
	flex-direction: row;
	align-items: center;
	margin-bottom: 20px;
}

.product_info-size-label {
	font-size: 1.6rem;
	margin-right: 1rem;
}

.product_info-size-list {
	display: flex;
	align-items: center;
	gap: 2rem;
}

.product_info-quantity {
	display: flex;
	flex-direction: row;
	align-items: center;
	margin-bottom: 24px;
}

.product_info-quantity-label {
	color: var(- -text-color);
	font-size: 1.6rem;
	margin-right: 10px;
}

.product_info-quantity-group {
	display: flex;
	gap: 0.4rem;
}

.product_info-quantity-btn {
	width: 2.5rem;
	height: 2.5rem;
	font-size: 1.6rem;
	cursor: pointer;
}

.product_info-quantity-text {
	width: 6rem;
	text-align: center;
}

.product_info-quantity-text:focus {
	outline: none;
}

.some_more_img_lable {
	font-size: 1.6rem;
	margin-bottom: 12px;
}

.some_more_img {
	display: flex;
	flex-direction: row;
	height: 60px;
	width: 100%;
	margin-bottom: 2rem;
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

.btn_container, .btn_cart {
	display: flex;
	align-items: center;
}

.btn_container {
	gap: 2rem;
}

.btn_cart {
	gap: 1rem;
	justify-content: center;
	border: 0.5px solid #f2f2f2;
	border-radius: 0.4rem;
	background-color: #fff;
	cursor: pointer;
	font-size: 1rem;
	padding: 0.8rem 0;
	min-width: 15rem;
	color: #fff;
	background-color: #5ec9ff;
	transition: all linear 0.2s;
}

.btn_cart:hover {
	background-color: #65b9e3;
}

.btn_cart ion-icon {
	font-size: 2.2rem;
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
						<span>Thông tin sản phẩm: ILLUSION T-SHIRT.</span> <span>
							Họa tiết: IN LỤA U.S.A</span> <span>Màu sắc: DARK BROWN</span> <span>Chất
							liệu: PREMIUM COTTON.</span>
					</p>
					<div class="product_info-size">
						<h3 class="product_info-size-label">KÍCH THƯỚC:</h3>
						<div class="product_info-size-list">
							<div class="product_info-size-item">
								<input type="radio" id="sizeM" name="sizeM" value="M"> <label
									for="sizeM"> M</label>
							</div>
							<div class="product_info-size-item">
								<input type="radio" id="sizeM" name="sizeM" value="M"> <label
									for="sizeM"> L</label>
							</div>
							<div class="product_info-size-item">
								<input type="radio" id="sizeM" name="sizeM" value="M"> <label
									for="sizeM"> XL</label>
							</div>
						</div>
					</div>
					<div class="product_info-quantity">
						<h3 class="product_info-quantity-label">SỐ LƯỢNG:</h3>
						<div class="product_info-quantity-group">
							<button class="product_info-quantity-btn">-</button>
							<input type="text" name="quantity" value="1"
								class="product_info-quantity-text" />
							<button class="product_info-quantity-btn">+</button>
						</div>

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
							<h3 class="btn_cart-lable">THÊM VÀO GIỎ</h3>
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
