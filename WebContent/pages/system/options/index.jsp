<%@page import="com.shoplane.utils.Constants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
request.setCharacterEncoding("utf-8");
String context = request.getContextPath();
%>

<!doctype html>
<html lang="en">
<head>
<jsp:include page="../head.jsp" />
<link rel="stylesheet"
	href="<%=context%>/assets/css/system/option/index.css"
	type="text/css" />
<title>Quản lý lựa chọn - SHOPLANE</title>
</head>
<body>
	<div id="app">
		<div id="sidebar">
			<jsp:include page="../components/sidebar.jsp" />
		</div>
		<div id="content">
			<div id="header">
				<jsp:include page="../components/header.jsp" />
			</div>
			<main id="main-content">
				<div class="sub-nav">
					<a class="sub-nav-item"
						href="<%=context%>/system/products/?product_type=ALL&category=AO5&current_page=1&page_size=10">Quản
						lý sản phẩm</a> <i class="fas fa-angle-right"></i><a
						class="sub-nav-item"
						href="<%=context%>/system/products/options/?product_id=${productId}">Quản
						lý lựa chọn</a>
				</div>
				<div class="actions">
					<a
						href="<%=context%>/system/products/options/create/?product_id=${productId}">Thêm
						lựa chọn</a> <a href="<%=context%>/system/products/options/delete">Xóa
						lựa chọn</a>
				</div>
				<div class="table">
					<div class="table__head">
						<div style="width: 5%">
							<input type="checkbox">
						</div>
						<div style="width: 10%">ID</div>
						<div style="width: 35%">Mã sản phẩm</div>
						<div style="width: 15%">Màu sắc</div>
						<div style="width: 10%">Kích thước</div>
						<div style="width: 10%">Số lượng còn lại</div>
						<div style="width: 15%"></div>
					</div>
					<div class="table__body">
						<c:forEach var="item" items="${options}">
							<div class="table__row">
								<div style="width: 5%">
									<input type="checkbox">
								</div>
								<div style="width: 10%">${item.getOptionId()}</div>
								<div style="width: 35%">${item.getProduct().getProductId()}</div>
								<div style="width: 15%">${item.getColor().getColorName()}
								</div>
								<div style="width: 10%">${item.getSize().getSizeName()}</div>
								<div style="width: 10%">${item.getAvailableQuantity()}</div>
								<div style="width: 15%" class="table__link">
									<a
										href="<%=context %>/system/products/options/detail/?product_id=${productId}&option_id=${item.getOptionId()}">Xem
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
