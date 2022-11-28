<%@page import="com.shoplane.utils.Helper"%>
<%@page import="com.shoplane.utils.Constants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="product"
	class="com.shoplane.services.client.ProductService"></jsp:useBean>

<%
request.setCharacterEncoding("utf-8");
%>

<section class="catalog">
	<div class="container">
		<h1 class="catalog__heading">DANH MỤC ÁO</h1>
		<div class="catalog__list">
			<c:forEach var="item" items="${product.getAllShirt(1, 12)}">
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
							<c:forEach begin="1" end="5">
								<i class="fas fa-star"></i>
							</c:forEach>
						</div>
						<div class="home-product-item__price">
							<span class="home-product-item__price-current">${Helper.intToVND(item.getNewPrice())}</span>
							<span class="home-product-item__price-old">${Helper.intToVND(item.getOldPrice())}</span>
						</div>
					</div>
				</div>
			</c:forEach>
			<div class="btn-more">
				<a class="btn-more-link"
					href="${pageContext.request.contextPath}/collection?category_id=<%=Constants.SHIRT_ALL %>&category_type=<%=Constants.SHIRT%>">
					XEM TẤT CẢ </a>
			</div>
		</div>
	</div>
</section>