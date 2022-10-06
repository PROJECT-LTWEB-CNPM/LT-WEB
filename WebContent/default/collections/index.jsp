<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<head>

<style>
.main {
	padding-top: 6rem;
}



.collection__container {
	margin-bottom: 4rem;
	margin-top: 6rem;
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
.category__container {
	background-color: #f9f9f9;
	border-radius: 0.4rem;
	box-shadow: 0px 0px 0.5rem rgb(0 0 0/ 10%);
}

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
	color: rgb(0 0 0/ 60%);
	text-align: center;
	border-bottom: 1px solid rgba(0, 0, 0, 0.1);
}

.category-list {
	padding: 0 0 8px 0;
	list-style: none;
	margin-left: 10px;
}

.category-item>a {
	transition: all linear 0.2s;
}

.category-item:hover>a {
	color: #5ec9ff;
}

.category-item.active>a {
	color: #5ec9ff;
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
	padding: 12px 16px;
	font-weight: 600;
	color: #5ec9ff;
}

.option_filter {
	display: flex;
	flex-direction: row;
	align-items: center;
	justify-content: space-between;
}

.option_filter-label {
	font-size: 1.5rem;
	margin-top: 0;
	padding: 12px 16px;
	font-weight: 600;
}

.option_filter-group {
	display: flex;
	align-items: center;
	justify-content: space-between;
	border: 1px solid #999;
	border-radius: 0.4rem;
	padding: 0.2rem 1rem;
	font-size: 1.6rem;
}

.group_content {
	box-shadow: rgba(0, 0, 0, 0.2) 0px 3px 8px;
	overflow: hidden;
	border-radius: 8px;
	transition: all ease-in-out 0.2s;
}

.group_content:hover {
	box-shadow: rgba(0, 0, 0, 0.38) 0px 3px 8px;
}

.home-product-item__img {
	padding-top: 100%;
	background-repeat: no-repeat;
	background-size: contain;
	background-position: center;
}

.home-product-item__name {
	font-size: 1.5rem;
	margin: 1rem 0;
	/* Xử lí tên quá dài */
	line-height: 1.5rem;
	max-height: 1.5rem;
	display: -webkit-box;
	-webkit-box-orient: vertical;
	-webkit-line-clamp: 1;
	overflow: hidden;
	cursor: pointer;
	transition: all linear 0.1s;
}

.shop_name {
	font-size: 1.6rem;
	margin: 4px 0;
	color: rgb(0 0 0/ 70%);
}

.home-product-item__name, .shop_name, .home-product-item__rating,
	.home-product-item__price {
	padding: 0 8px;
}

.home-product-item__rating {
	font-size: 1.2rem;
	color: orange;
	margin: 0.5rem 0;
}

.home-product-item__price {
	display: flex;
	flex-direction: row;
	justify-content: space-between;
	padding-top: 8px;
	padding-bottom: 16px;
	border-top: 1px solid #eae9e9;
	padding-bottom: 16px;
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
	display: flex;
	align-items: center;
	justify-content: center;
}

.btn-submit {
	display: block;
	width: 30%;
	outline: none;
	border: 0.5px solid #6c757d;
	padding: 0.8rem 0;
	border-radius: 0.4rem;
	cursor: pointer;
	font-size: 1.4rem;
	color: #6c757d;
	background-color: transparent;
	transition: all linear 0.2s;
}

.btn-submit:hover {
	color: #fff;
	background-color: #6c757d;
}
</style>
</head>


<tags:base title="Tất cả sản phẩm - SHOPLANE"
	css="./assets/css/index.css">
	<jsp:include page="../header.jsp" />
	<main class="main">
		<div class="container">
			
			<div class="grid__row collection__container">
	<div class="grid__column">
		<div class="category__container">
			<h3 class="category__heading">Danh Mục</h3>
			<div class="btn_close">
				<i class="fa-solid fa-xmark"></i>
			</div>
			<ul class="category-list">
				<li class="category-item active"><a href=""
					class="category-item__link">${listC.get(0).getCategoryName()}</a></li>
				<c:forEach begin="1" var="cat" items="${listC}">
					<li class="category-item"><a href=""
					class="category-item__link"><c:out value="${cat.getCategoryName()}"/></a></li>
				</c:forEach>
			</ul>
		</div>
	</div>
	<div class="grid__column_3">
		<div class="product_filter">
			<h3 class="type_of_product">ÁO THUN</h3>
			<div class="option_filter">
				<h3 class="option_filter-label">SẮP XẾP THEO</h3>
				<select class="option_filter-group" tabindex="-1">
					<option value="manual">Sản phẩm nổi bật</option>
					<option value="price-ascending">Giá: Tăng dần</option>
					<option value="price-descending">Giá: Giảm dần</option>
					<option value="title-ascending">Tên: A-Z</option>
					<option value="title-descending">Tên: Z-A</option>
					<option value="created-ascending">Cũ nhất</option>
					<option value="created-descending" selected>Mới nhất</option>
					<option value="best-selling">Bán chạy nhất</option>
				</select>
			</div>
		</div>
		<div class="grid__row">
			<c:forEach var="product" items="${listP}">
			<div class="grid__column-3-3">
				<div class="group_content">
					<div class="home-product-item__img"
						style="background-image: url(${product.getMainImageUrl()});">
					</div>
					<h4 class="home-product-item__name">${product.getProductName()}</h4>
					<h4 class="shop_name">SHOPLANE</h4>
					<div class="home-product-item__rating">
						<i class="fas fa-star"></i> <i class="fas fa-star"></i> <i
							class="fas fa-star"></i> <i class="fas fa-star"></i> <i
							class="fas fa-star"></i>
					</div>
					<div class="home-product-item__price">
						<span class="home-product-item__price-current">${product.getNewPrice()}</span> 
						<span class="home-product-item__price-old">${product.getOldPrice()}</span>
					</div>
				</div>
			</div>
			</c:forEach>
		</div>
		<div class="show_all">
			<button class="btn-submit">XEM THÊM 45 SẢN PHẨM KHÁC</button>
		</div>
	</div>
</div>			

		</div>
	</main>
	<jsp:include page="../footer.jsp" />
	<jsp:include page="../back-to-top.jsp" />

</tags:base>