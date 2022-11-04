p<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("utf-8");
String baseUrl = request.getContextPath() + "/system/products/form";
%>

<!doctype html>
<html lang="en">
<head>
<jsp:include page="../../head.jsp" />
<link rel="stylesheet" href="<%=baseUrl%>/index.css" />
<title>Products Manage</title>
</head>
<body>
	<div id="system">
		<div id="sidebar">
			<jsp:include page="../../partials/sidebar/index.jsp" />
		</div>
		<div id="content">
			<div id="header">
				<jsp:include page="../../partials/header/index.jsp" />
			</div>
			<main id="main-content">
				<div class="customer_info">
					<div class="customer_info-item">
						<label for="productName">Tên sản phẩm: </label> <input type="text"
							name="productName" id="productName"
							placeholder="Áo phông form rộng">
					</div>
					<div class="customer_info-item">
						<label for="productName">Hình ảnh: </label> <input type="text"
							name="productName" id="productName" placeholder="url....">
					</div>
					<div class="customer_info-item">
						<label for="productName">Giá cũ: </label> <input type="text"
							name="productName" id="productName" placeholder="350,000">
					</div>
					<div class="customer_info-item">
						<label for="productName">Giá mới: </label> <input type="text"
							name="productName" id="productName" placeholder="69,000">
					</div>
					<div class="customer_info-item">
						<label for="productName">Mô tả: </label> <input type="text"
							name="productName" id="productName"
							placeholder="doduongthaituan201102@gmail.com">
					</div>
					<div class="customer_info-item">
						<label for="productName">Nguồn gốc: </label> <input type="text"
							name="productName" id="productName" placeholder="Việt Nam">
					</div>
					<div class="customer_info-item">
						<label for="productName">Họa tiết: </label> <input type="text"
							name="productName" id="productName" placeholder="Không họa tiết">
					</div>
					<div class="customer_info-item">
						<label for="productName">Loại vải: </label> <input type="text"
							name="productName" id="productName" placeholder="Cotton">
					</div>
					<button class="save_change">Lưu</button>
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
