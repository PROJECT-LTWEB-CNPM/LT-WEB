<%@page import="com.shoplane.utils.Helper"%>
<%@page import="com.shoplane.utils.Constants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="product"
	class="com.shoplane.services.client.ProductService"></jsp:useBean>
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
		</div>
		<div class="btn-more">
			<a class="btn-more-link"
				href="<%=context%>/collection?category_id=<%=Constants.SHORT_ALL%>&category_type=<%=Constants.SHORT%>">
				XEM TẤT CẢ </a>
		</div>
	</div>
</section>
