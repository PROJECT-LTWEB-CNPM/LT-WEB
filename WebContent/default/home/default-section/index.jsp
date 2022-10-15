<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
<jsp:useBean id="product" class="services.ProductService"></jsp:useBean>
<style>
.catalog {
	margin: 8rem 0;
}

.catalog__heading {
	margin: 0 auto;
	text-transform: uppercase;
	margin-bottom: 3rem;
	position: relative;
	width: fit-content;
	text-transform: uppercase;
}

.catalog__heading::after {
	position: absolute;
	content: "";
	height: 2px;
	width: 100%;
	background-color: #000;
	bottom: -0.4rem;
	left: 0;
	border-radius: 0.4rem;
	background-color: #5ec9ff;
}

.catalog__list {
	display: flex;
	align-items: flex-start;
	justify-content: flex-start;
	flex-wrap: wrap;
	gap: 2.5rem 2rem;
}

.catalog__item {
	width: 23%;
}

.group_content {
	box-shadow: rgba(0, 0, 0, 0.1) 0px 3px 8px;
	overflow: hidden;
	border-radius: 1rem;
	min-width: calc(( 1200px - 60px)/4);
	transition: all linear 0.2s;
}

.group_content:hover {
	box-shadow: rgba(0, 0, 0, 0.3) 0px 3px 8px;
}

.home-product-item__img {
	width: inherit;
	height: 25rem;
	background-size: cover;
	background-position: center;
	background-repeat: no-repeat;
}

.home-product-item__name {
	font-size: 1.5rem;
	margin-top: 8px;
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

.btn-more {
	display: block;
	margin: 40px auto 0;
	width: 120px;
}

.btn-more-link {
	display: flex;
	padding: 0.8rem 1.5rem;
	border: 1px solid #5ec9ff;
	border-radius: 0.4rem;
	color: #5ec9ff;
	font-weight: 500;
	transition: all linear 0.2s;
	font-size: 1.4rem;
}

.btn-more-link:hover {
	background-color: #5ec9ff;
	color: #fff;
}
</style>
</head>

<section class="catalog">
	<c:choose>
		<c:when test="${showAll.contains('showAll')}">
			<c:choose>
				<c:when
					test="${showAll.contains('DANH MỤC ÁO') && param.heading.contains('DANH MỤC ÁO')}">
					<div class="container">
						<h1 class="catalog__heading">${param.heading}</h1>
						<div class="catalog__list">
							<c:forEach var="item" items="${product.getAllShirt()}">
								<div class="catalog__item">
									<div class="group_content">
										<div class="home-product-item__img"
											style="background-image: url(${item.getMainImageUrl()});">
										</div>
										<h4 class="home-product-item__name">
											<%-- <a href="${pageContext.request.contextPath}/default/products/index.jsp">${item.getProductName()}</a> --%>
											<a
												href="${pageContext.request.contextPath}/ProductController?productId=${item.getProductId()}">${item.getProductName()}</a>
										</h4>
										<h4 class="shop_name">SHOPLANE</h4>
										<div class="home-product-item__rating">
											<ion-icon name="star-outline"></ion-icon>
											<ion-icon name="star-outline"></ion-icon>
											<ion-icon name="star-outline"></ion-icon>
											<ion-icon name="star-outline"></ion-icon>
											<ion-icon name="star-outline"></ion-icon>
										</div>
										<div class="home-product-item__price">
											<span class="home-product-item__price-current">${item.getNewPrice()}</span>
											<span class="home-product-item__price-old">${item.getOldPrice()}</span>
										</div>
									</div>
								</div>
							</c:forEach>
							<div class="btn-more">
								<a class="btn-more-link"
									href="${pageContext.request.contextPath}/ProductController?showAll=showAll-${param.heading}">
									XEM TẤT CẢ </a>
							</div>
						</div>
					</div>
				</c:when>
				<c:when
					test="${showAll.contains('DANH MỤC QUẦN') && param.heading.contains('DANH MỤC QUẦN')}">
					<div class="container">
						<h1 class="catalog__heading">${param.heading}</h1>
						<div class="catalog__list">
							<c:forEach var="item" items="${product.getAllShort()}">
								<div class="catalog__item">
									<div class="group_content">
										<div class="home-product-item__img"
											style="background-image: url(${item.getMainImageUrl()});">
										</div>
										<h4 class="home-product-item__name">
											<%-- <a href="${pageContext.request.contextPath}/default/products/index.jsp">${item.getProductName()}</a> --%>
											<a
												href="${pageContext.request.contextPath}/ProductController?productId=${item.getProductId()}">${item.getProductName()}</a>
										</h4>
										<h4 class="shop_name">SHOPLANE</h4>
										<div class="home-product-item__rating">
											<ion-icon name="star-outline"></ion-icon>
											<ion-icon name="star-outline"></ion-icon>
											<ion-icon name="star-outline"></ion-icon>
											<ion-icon name="star-outline"></ion-icon>
											<ion-icon name="star-outline"></ion-icon>
										</div>
										<div class="home-product-item__price">
											<span class="home-product-item__price-current">${item.getNewPrice()}</span>
											<span class="home-product-item__price-old">${item.getOldPrice()}</span>
										</div>
									</div>
								</div>
							</c:forEach>
							<div class="btn-more">
								<a class="btn-more-link"
									href="${pageContext.request.contextPath}/ProductController?showAll=showAll-${param.heading}">
									XEM TẤT CẢ </a>
							</div>
						</div>
					</div>
				</c:when>
			</c:choose>
		</c:when>

		<c:otherwise>
			<div class="container">
				<h1 class="catalog__heading">${param.heading}</h1>
				<div class="catalog__list">
					<c:forEach var="item"
						items="${param.heading == 'DANH MỤC ÁO' ? product.getAllShirt(1, 12) :  product.getAllShort()}">
						<div class="catalog__item">
							<div class="group_content">
								<div class="home-product-item__img"
									style="background-image: url(${item.getMainImageUrl()});">
								</div>
								<h4 class="home-product-item__name">
									<%-- <a href="${pageContext.request.contextPath}/default/products/index.jsp">${item.getProductName()}</a> --%>
									<a
										href="${pageContext.request.contextPath}/ProductController?productId=${item.getProductId()}">${item.getProductName()}</a>
								</h4>
								<h4 class="shop_name">SHOPLANE</h4>
								<div class="home-product-item__rating">
									<ion-icon name="star-outline"></ion-icon>
									<ion-icon name="star-outline"></ion-icon>
									<ion-icon name="star-outline"></ion-icon>
									<ion-icon name="star-outline"></ion-icon>
									<ion-icon name="star-outline"></ion-icon>
								</div>
								<div class="home-product-item__price">
									<span class="home-product-item__price-current">${item.getNewPrice()}</span>
									<span class="home-product-item__price-old">${item.getOldPrice()}</span>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
				<div class="btn-more">
					<a class="btn-more-link"
						href="${pageContext.request.contextPath}/ProductController?showAll=showAll-${param.heading}">
						XEM TẤT CẢ </a>
				</div>
			</div>
		</c:otherwise>
	</c:choose>
</section>