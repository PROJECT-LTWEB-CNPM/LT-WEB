<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="product" class="services.ProductService"></jsp:useBean>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
request.setCharacterEncoding("utf-8");

String context = request.getContextPath();
%>

<section class="catalog">
	<div class="container hide_short">
		<h1 class="catalog__heading">DANH MỤC QUẦN</h1>
		<div class="catalog__list">
			<c:forEach var="item" items="${product.getAllShort()}">
				<div class="catalog__item">
					<div class="group_content">
						<div class="home-product-item__img"
							style="background-image: url(${item.getMainImageUrl()});">
						</div>
						<h4 class="home-product-item__name">
							<a
								href="${pageContext.request.contextPath}/product-detail?product_id=${item.getProductId()}">${item.getProductName()}</a>
						</h4>
						<h4 class="shop_name">SHOPLANE</h4>
						<div class="home-product-item__rating">
							<c:forEach begin="0" end="3">
								<ion-icon name="star-outline"></ion-icon>
							</c:forEach>
						</div>
						<div class="home-product-item__price">
							<span class="home-product-item__price-current">${item.getNewPrice()}đ</span>
							<span class="home-product-item__price-old">${item.getOldPrice()}đ</span>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		<div class="btn-more">
			<a class="btn-more-link"
				href="<%=context%>/collection?category_type=AO&category_id=QUAN4">
				XEM TẤT CẢ </a>
		</div>
	</div>
</section>
