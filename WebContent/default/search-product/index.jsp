<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
request.setCharacterEncoding("utf-8");
String context = request.getContextPath();
String baseUrl = context + "/default/search-product";
%>

<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="../head.jsp" />
<link rel="stylesheet" href="<%=baseUrl%>/index.css" />
<title>Tìm kiếm sản phẩm - SHOPLANE</title>
<style>
.main {
	padding-top: 6rem;
}
</style>
</head>
<body>
	<div id="app">
		<jsp:include page="../header/header.jsp" />
		<section class="catalog">
			<div class="container">
				<h1 class="catalog__heading">SẢN PHẨM BẠN ĐANG TÌM KIẾM: ${findProduct}</h1>
				<div class="catalog__list">
					<c:forEach var="item" items="${listProductWithSearch}">
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
			</div>
		</section>
		<jsp:include page="../footer/footer.jsp" />
		<jsp:include page="../back-to-top/back-to-top.jsp" />
	</div>

	<!-- Jquery -->
<<<<<<< HEAD
	<jsp:include page="../script.jsp" />

=======
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"
		integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
>>>>>>> 5ff24020b2ced68e7b1712c7d6212c23aaf10030
</body>
</html>
