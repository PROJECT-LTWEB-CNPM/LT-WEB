<%@page import="com.shoplane.utils.Constants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
request.setCharacterEncoding("utf-8");
String context = request.getContextPath();
String baseUrl = context + "/system/options/list";
%>

<!doctype html>
<html lang="en">
<head>
<jsp:include page="../../head.jsp" />
<link rel="stylesheet" href="<%=baseUrl%>/index.css" />
<title>Quản lý lựa chọn - Shoplane</title>
</head>
<body>
	<div id="app">
		<div id="sidebar">
			<jsp:include page="../../partials/sidebar/index.jsp" />
		</div>
		<div id="content">
			<div id="header">
				<jsp:include page="../../partials/header/index.jsp" />
			</div>
			<main id="main-content">
				<div class="sub-nav">
					<a class="sub-nav-item"
						href="<%=context%>/system/products/?product_type=ALL&category=AO5&current_page=1&page_size=10">Quản
						lý sản phẩm</a> <i class="fas fa-angle-right"></i><a
						class="sub-nav-item"
						href="<%=context%>/system/products/images/?product_id=${productId}">Quản
						lý ảnh xem trước</a>
				</div>
				<div class="actions">
					<a
						href="<%=context%>/system/products/options/create/?product_id=${productId}">Thêm
						hình</a> <a href="<%=context%>/system/products/options/delete">Xóa
						hình</a>
				</div>
				<div class="table">
					<div class="table__head">
						<div style="width: 5%">
							<input type="checkbox">
						</div>
						<div style="width: 10%">Mã hình ảnh</div>
						<div style="width: 35%">Đường dẫn</div>
						<div style="width: 15%">Hình ảnh</div>
						<div style="width: 10%">Tên sản phẩm</div>
						<div style="width: 10%">Nguồn gốc</div>
						<div style="width: 15%"></div>
					</div>
					<div class="table__body">
						<c:forEach var="item" items="${productImages}">
							<div class="table__row">
								<div style="width: 5%">
									<input type="checkbox">
								</div>
								<div style="width: 10%">${item.getImageId()}</div>
								<div style="width: 35%">${item.getImageUrl()}</div>
								<div style="width: 15%">
									<img src="${item.getImageUrl()}"
										alt="${product.getProductName()}"
										style="height: 60px; object-fit: cover" />
								</div>
								<div style="width: 10%">${product.getProductName()}</div>
								<div style="width: 10%">${product.getOrigin()}</div>
								<div style="width: 15%" class="table__link">
									<a
										href="<%=context %>/system/products/options/detail/?product_id=${productId}&image_id=${item.getImageUrl()}">Xem
										chi tiết</a>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</main>
		</div>
	</div>
	<!-- Jquery -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"
		integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</body>
</html>
