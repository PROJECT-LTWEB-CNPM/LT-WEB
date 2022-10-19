p<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("utf-8");
String baseUrl = request.getContextPath() + "/system/users/form";
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
					<div class="img">
						<img
							src="https://cpad.ask.fm/450/774/576/-29996968-1tfd7tc-gpggmmc5d0og3a0/original/image.jpg"
							alt="" class="">
					</div>
					<button class="change_img">Thay đổi ảnh</button>
					<div class="customer_info-item">
						<label for="productName">Họ và tên: </label> <input type="text"
							name="productName" id="productName"
							placeholder="Áo phông form rộng">
					</div>
					<div class="customer_info-item">
						<label for="productName">Số điện thoại: </label> <input
							type="text" name="productName" id="productName"
							placeholder="url....">
					</div>
					<div class="customer_info-item">
						<label for="productName">Địa chỉ: </label> <input type="text"
							name="productName" id="productName" placeholder="350,000">
					</div>
					<div class="customer_info-item">
						<label for="productName">Email: </label> <input type="text"
							name="productName" id="productName" placeholder="69,000">
					</div>
					<div class="customer_info-item">
						<label for="productName">Mật khẩu: </label> <input type="text"
							name="productName" id="productName"
							placeholder="doduongthaituan201102@gmail.com">
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
