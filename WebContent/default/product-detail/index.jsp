<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
request.setCharacterEncoding("utf-8");
String context = request.getContextPath() + "/default/product-detail";
%>

<!doctype html>
<html lang="en">
<head>
<jsp:include page="../head.jsp" />
<link rel="stylesheet" href="<%=context%>/index.css" />
<title>Tất cả sản phẩm - SHOPLANE</title>
<style>
.main {
	padding-top: 10rem;
	padding-bottom: 4rem;
}
</style>
</head>
<body>
	<div id="app">
		<jsp:include page="../header/header.jsp" />
		<main class="main">
			<div class="container">
				<div class="product__inner">
					<div class="container_product_img">
						<div class="product_img"
							style="background-image: url(${productImagesDetail != null ? productImagesDetail.getImageUrl() : product.getMainImageUrl()});">
						</div>
					</div>
					<div class="product_info">
						<h3 class="product_info-name">${product.getProductName()}</h3>
						<div class="home-product-item__price">
							<span class="home-product-item__price-current">${product.getNewPrice()}đ</span>
							<span class="home-product-item__price-old">${product.getOldPrice()}đ</span>
						</div>
						<p class="product_info-more">
							<span>Thông tin sản phẩm: ILLUSION T-SHIRT.</span> <span>
								Họa tiết: ${product.getPattern()}</span> <span>Màu sắc:
								${product.getProductName().split('/')[1]}</span> <span>Chất
								liệu: ${product.getMeterial()}</span>
						</p>
						<div class="product_info-size">
							<h3 class="product_info-size-label">KÍCH THƯỚC:</h3>
							<div class="product_info-size-list">
								<div class="product_info-size-item">
									<input type="radio" id="sizeM" name="sizeM" value="M">
									<label for="sizeM"> M</label>
								</div>
								<div class="product_info-size-item">
									<input type="radio" id="sizeM" name="sizeM" value="M">
									<label for="sizeM"> L</label>
								</div>
								<div class="product_info-size-item">
									<input type="radio" id="sizeM" name="sizeM" value="M">
									<label for="sizeM"> XL</label>
								</div>
							</div>
						</div>
						<div class="product_info-quantity">
							<h3 class="product_info-quantity-label">SỐ LƯỢNG:</h3>
							<div class="product_info-quantity-group">
								<button class="product_info-quantity-btn btn-sub">-</button>
								<input type="text" name="quantity" value="1"
									class="product_info-quantity-text" />
								<button class="product_info-quantity-btn btn-ins">+</button>
							</div>
						</div>
						<h3 class="some_more_img_lable">XEM THÊM HÌNH ẢNH</h3>
						<div class="some_more_img">
							<c:forEach var="item" items="${productImages}">
								<div class="member-item">
									<img class="member-img" src="${item.getImageUrl()}" alt="Name">
								</div>
							</c:forEach>
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
		<jsp:include page="../footer/footer.jsp" />
	</div>
	<!-- Jquery -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"
		integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script type="text/javascript" src="<%=context%>/index.js"></script>
	<script>
		
	</script>

</body>
</html>

