<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="tags" tagdir="/WEB-INF/tags"%>


<head>

<style>
.main {
	padding-top: 6rem;
}

.grid {
	max-width: 100%;
	margin: 0 auto;
}

.grid__row {
	display: flex;
	flex-wrap: wrap;
	margin-left: -5px;
	margin-right: -5px;
}

.grid__column {
	padding-left: 10px;
	padding-right: 10px;
	width: 25%;
	margin-bottom: 32px;
}

.grid__column_3 {
	padding-left: 5px;
	padding-right: 5px;
	width: 75%;
	margin-bottom: 40px;
}

.grid__column-3-3 {
	padding-left: 10px;
	padding-right: 10px;
	width: 33.33333%;
	margin-bottom: 32px;
}

/* Content */
.category {
	background-color: #f8f8f8;
	border-radius: 2px;
}

.btn_close {
	display: none;
}

.category__heading {
	font-size: 1.8rem;
	margin-top: 0;
	padding: 12px 16px;
	color: var(- -text-color);
	border-bottom: 1px solid rgba(0, 0, 0, 0.1);
	text-align: center;
}

.category-list {
	padding: 0 0 8px 0;
	list-style: none;
	margin-left: 10px;
}

.category-item__link {
	display: block;
	text-decoration: none;
	color: var(- -text-color);
	font-size: 1.5rem;
	font-weight: 600;
	padding: 8px 16px;
	position: relative;
	right: 0;
	transition: right linear 0.1s;
}

.category-item-active .category-item__link {
	color: blue;
}

.product_filter {
	display: flex;
	flex-direction: row;
	align-items: center;
	justify-content: space-between;
	border-bottom: 1px solid rgba(0, 0, 0, 0.1);
	margin-bottom: 24px;
}

.type_of_product {
	font-size: 1.8rem;
	margin-top: 0;
	padding: 12px 16px
}

.option_filter {
	display: flex;
	flex-direction: row;
	align-items: center;
	justify-content: space-between;
}

.option_filter-label {
	font-size: 1.8rem;
	margin-top: 0;
	padding: 12px 16px
}

.option_filter-group {
	display: flex;
	flex-direction: row;
	align-items: center;
	justify-content: space-between;
	border: 1px solid #999;
	padding: 10px 0;
	margin-left: 16px;
	border-radius: 8px;
}

.option_filter-name {
	padding-left: 16px;
	font-size: 1.8rem;
	margin-top: 0;
}

.option_filter-group ion-icon {
	font-size: 1.8rem;
	padding: 0 16px;
}

.group_content {
	box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px;
	cursor: pointer;
	overflow: hidden;
	border-radius: 8px;
}

.home-product-item__img {
	padding-top: 100%;
	background-repeat: no-repeat;
	background-size: contain;
	background-position: center;
}

.home-product-item__name {
	font-size: 1.5rem;
	margin-top: 8px;
	/* Xử lí tên quá dài */
	line-height: 1.5rem;
	max-height: 1.5rem;
	display: -webkit-box;
	-webkit-box-orient: vertical;
	-webkit-line-clamp: 1;
	overflow: hidden;
}

.shop_name {
	font-size: 1.6rem;
	margin: 4px 0;
}

.home-product-item__name, .shop_name, .home-product-item__rating,
	.home-product-item__price {
	padding: 0 8px;
}

.home-product-item__rating ion-icon {
	font-size: 1.3rem;
}

.home-product-item__price {
	display: flex;
	flex-direction: row;
	justify-content: space-between;
	padding-top: 8px;
	padding-bottom: 16px;
	border-top: 1px solid #eae9e9;
}

.home-product-item__price-current {
	font-size: 1.4rem;
	font-weight: 600;
	color: red;
}

.home-product-item__price-old {
	font-size: 1.4rem;
	font-weight: 600;
	text-decoration: line-through;
}

.show_all {
	text-align: center;
}

.show_all-btn {
	padding: 10px 20px;
	border-radius: 8px;
	border: 1px solid #000;
	background-color: #fff;
	font-weight: 700;
	cursor: pointer;
}

/* Dùng để làm resposive */
.nav__overplay {
	position: fixed;
	top: 0;
	right: 0;
	left: 0;
	bottom: 0;
	background-color: rgba(0, 0, 0, 0.3);
	animation: fadeIn linear 0.3s;
	display: none;
}

.nav__bar-btn {
	font-size: 2.2rem;
	padding: 8px;
	display: none;
}

.nav__input {
	display: none;
}

@
keyframes fadeIn {from { opacity:0;
	
}

to {
	opacity: 1;
}
}
</style>
</head>

<%
request.setCharacterEncoding("utf-8");
%>

<tags:base title="Tất cả sản phẩm - SHOPLANE"
	css="../../assets/css/index.css">
	<jsp:include page="../header.jsp" />
	<main class="main">
		<div class="container">
			<div class="grid__row">
				<div class="grid__column">
					<input type="checkbox" name="" id="nav-mobile-input"
						class="nav__input"> <label for="nav-mobile-input"
						class="nav__overplay"></label> <label for="nav-mobile-input"
						class="category">
						<h3 class="category__heading">Danh Mục</h3>
						<div class="btn_close">
							<i class="fa-solid fa-xmark"></i>
						</div>
						<ul class="category-list">
							<li class="category-item category-item-active"><a href=""
								class="category-item__link">ÁO THUN</a></li>
							<li class="category-item"><a href=""
								class="category-item__link">ÁO THUN</a></li>
							<li class="category-item"><a href=""
								class="category-item__link">ÁO THUN</a></li>
							<li class="category-item"><a href=""
								class="category-item__link">ÁO THUN</a></li>
							<li class="category-item"><a href=""
								class="category-item__link">ÁO THUN</a></li>
							<li class="category-item"><a href=""
								class="category-item__link">ÁO THUN</a></li>
							<li class="category-item"><a href=""
								class="category-item__link">ÁO THUN</a></li>
							<li class="category-item"><a href=""
								class="category-item__link">ÁO THUN</a></li>
						</ul>
					</label>
				</div>
				<div class="grid__column_3">
					<div class="product_filter">
						<h3 class="type_of_product">ÁO THUN</h3>
						<div class="option_filter">
							<h3 class="option_filter-label">SẮP XẾP THEO</h3>
							<div class="option_filter-group">
								<h3 class="option_filter-name">MỚI NHẤT</h3>
								<ion-icon name="arrow-down-outline"></ion-icon>
							</div>
						</div>
					</div>
					<div class="grid__row">
						<div class="grid__column-3-3">
							<div class="group_content">
								<div class="home-product-item__img"
									style="background-image: url(https://cf.shopee.vn/file/fe2451710511f9ddb24d33dcf1621345);">
								</div>
								<h4 class="home-product-item__name">ILLUSION T-SHIRT/DARK
									BROWN</h4>
								<h4 class="shop_name">SHOPLANE</h4>
								<div class="home-product-item__rating">
									<ion-icon name="star-outline"></ion-icon>
									<ion-icon name="star-outline"></ion-icon>
									<ion-icon name="star-outline"></ion-icon>
									<ion-icon name="star-outline"></ion-icon>
									<ion-icon name="star-outline"></ion-icon>
								</div>
								<div class="home-product-item__price">
									<span class="home-product-item__price-current">69,000₫</span> <span
										class="home-product-item__price-old">390,000₫</span>
								</div>
							</div>
						</div>
						<div class="grid__column-3-3">
							<div class="group_content">
								<div class="home-product-item__img"
									style="background-image: url(https://cf.shopee.vn/file/fe2451710511f9ddb24d33dcf1621345);">
								</div>
								<h4 class="home-product-item__name">ILLUSION T-SHIRT/DARK
									BROWN</h4>
								<h4 class="shop_name">SHOPLANE</h4>
								<div class="home-product-item__rating">
									<ion-icon name="star-outline"></ion-icon>
									<ion-icon name="star-outline"></ion-icon>
									<ion-icon name="star-outline"></ion-icon>
									<ion-icon name="star-outline"></ion-icon>
									<ion-icon name="star-outline"></ion-icon>
								</div>
								<div class="home-product-item__price">
									<span class="home-product-item__price-current">69,000₫</span> <span
										class="home-product-item__price-old">390,000₫</span>
								</div>
							</div>
						</div>
						<div class="grid__column-3-3">
							<div class="group_content">
								<div class="home-product-item__img"
									style="background-image: url(https://cf.shopee.vn/file/fe2451710511f9ddb24d33dcf1621345);">
								</div>
								<h4 class="home-product-item__name">ILLUSION T-SHIRT/DARK
									BROWN</h4>
								<h4 class="shop_name">SHOPLANE</h4>
								<div class="home-product-item__rating">
									<ion-icon name="star-outline"></ion-icon>
									<ion-icon name="star-outline"></ion-icon>
									<ion-icon name="star-outline"></ion-icon>
									<ion-icon name="star-outline"></ion-icon>
									<ion-icon name="star-outline"></ion-icon>
								</div>
								<div class="home-product-item__price">
									<span class="home-product-item__price-current">69,000₫</span> <span
										class="home-product-item__price-old">390,000₫</span>
								</div>
							</div>
						</div>
						<div class="grid__column-3-3">
							<div class="group_content">
								<div class="home-product-item__img"
									style="background-image: url(https://cf.shopee.vn/file/fe2451710511f9ddb24d33dcf1621345);">
								</div>
								<h4 class="home-product-item__name">ILLUSION T-SHIRT/DARK
									BROWN</h4>
								<h4 class="shop_name">SHOPLANE</h4>
								<div class="home-product-item__rating">
									<ion-icon name="star-outline"></ion-icon>
									<ion-icon name="star-outline"></ion-icon>
									<ion-icon name="star-outline"></ion-icon>
									<ion-icon name="star-outline"></ion-icon>
									<ion-icon name="star-outline"></ion-icon>
								</div>
								<div class="home-product-item__price">
									<span class="home-product-item__price-current">69,000₫</span> <span
										class="home-product-item__price-old">390,000₫</span>
								</div>
							</div>
						</div>
						<div class="grid__column-3-3">
							<div class="group_content">
								<div class="home-product-item__img"
									style="background-image: url(https://cf.shopee.vn/file/fe2451710511f9ddb24d33dcf1621345);">
								</div>
								<h4 class="home-product-item__name">ILLUSION T-SHIRT/DARK
									BROWN</h4>
								<h4 class="shop_name">SHOPLANE</h4>
								<div class="home-product-item__rating">
									<ion-icon name="star-outline"></ion-icon>
									<ion-icon name="star-outline"></ion-icon>
									<ion-icon name="star-outline"></ion-icon>
									<ion-icon name="star-outline"></ion-icon>
									<ion-icon name="star-outline"></ion-icon>
								</div>
								<div class="home-product-item__price">
									<span class="home-product-item__price-current">69,000₫</span> <span
										class="home-product-item__price-old">390,000₫</span>
								</div>
							</div>
						</div>
						<div class="grid__column-3-3">
							<div class="group_content">
								<div class="home-product-item__img"
									style="background-image: url(https://cf.shopee.vn/file/fe2451710511f9ddb24d33dcf1621345);">
								</div>
								<h4 class="home-product-item__name">ILLUSION T-SHIRT/DARK
									BROWN</h4>
								<h4 class="shop_name">SHOPLANE</h4>
								<div class="home-product-item__rating">
									<ion-icon name="star-outline"></ion-icon>
									<ion-icon name="star-outline"></ion-icon>
									<ion-icon name="star-outline"></ion-icon>
									<ion-icon name="star-outline"></ion-icon>
									<ion-icon name="star-outline"></ion-icon>
								</div>
								<div class="home-product-item__price">
									<span class="home-product-item__price-current">69,000₫</span> <span
										class="home-product-item__price-old">390,000₫</span>
								</div>
							</div>
						</div>
						<div class="grid__column-3-3">
							<div class="group_content">
								<div class="home-product-item__img"
									style="background-image: url(https://cf.shopee.vn/file/fe2451710511f9ddb24d33dcf1621345);">
								</div>
								<h4 class="home-product-item__name">ILLUSION T-SHIRT/DARK
									BROWN</h4>
								<h4 class="shop_name">SHOPLANE</h4>
								<div class="home-product-item__rating">
									<ion-icon name="star-outline"></ion-icon>
									<ion-icon name="star-outline"></ion-icon>
									<ion-icon name="star-outline"></ion-icon>
									<ion-icon name="star-outline"></ion-icon>
									<ion-icon name="star-outline"></ion-icon>
								</div>
								<div class="home-product-item__price">
									<span class="home-product-item__price-current">69,000₫</span> <span
										class="home-product-item__price-old">390,000₫</span>
								</div>
							</div>
						</div>
						<div class="grid__column-3-3">
							<div class="group_content">
								<div class="home-product-item__img"
									style="background-image: url(https://cf.shopee.vn/file/fe2451710511f9ddb24d33dcf1621345);">
								</div>
								<h4 class="home-product-item__name">ILLUSION T-SHIRT/DARK
									BROWN</h4>
								<h4 class="shop_name">SHOPLANE</h4>
								<div class="home-product-item__rating">
									<ion-icon name="star-outline"></ion-icon>
									<ion-icon name="star-outline"></ion-icon>
									<ion-icon name="star-outline"></ion-icon>
									<ion-icon name="star-outline"></ion-icon>
									<ion-icon name="star-outline"></ion-icon>
								</div>
								<div class="home-product-item__price">
									<span class="home-product-item__price-current">69,000₫</span> <span
										class="home-product-item__price-old">390,000₫</span>
								</div>
							</div>
						</div>
						<div class="grid__column-3-3">
							<div class="group_content">
								<div class="home-product-item__img"
									style="background-image: url(https://cf.shopee.vn/file/fe2451710511f9ddb24d33dcf1621345);">
								</div>
								<h4 class="home-product-item__name">ILLUSION T-SHIRT/DARK
									BROWN</h4>
								<h4 class="shop_name">SHOPLANE</h4>
								<div class="home-product-item__rating">
									<ion-icon name="star-outline"></ion-icon>
									<ion-icon name="star-outline"></ion-icon>
									<ion-icon name="star-outline"></ion-icon>
									<ion-icon name="star-outline"></ion-icon>
									<ion-icon name="star-outline"></ion-icon>
								</div>
								<div class="home-product-item__price">
									<span class="home-product-item__price-current">69,000₫</span> <span
										class="home-product-item__price-old">390,000₫</span>
								</div>
							</div>
						</div>
					</div>
					<div class="show_all">
						<form action="">
							<button class="show_all-btn">XEM THÊM 45 SẢN PHẨM KHÁC</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</main>
	<jsp:include page="../footer.jsp" />
	<jsp:include page="../back-to-top.jsp" />

</tags:base>