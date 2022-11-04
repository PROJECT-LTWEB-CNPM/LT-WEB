<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("utf-8");
String context = request.getContextPath();
String baseUrl = request.getContextPath() + "/system/options/detail-update";
%>

<!doctype html>
<html lang="en">
<head>
<jsp:include page="../../head.jsp" />
<link rel="stylesheet" href="<%=baseUrl%>/index.css" />
<title>Chi tiết sản phẩm - Shoplane</title>
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
					<div class="actions">
						<a href="/system/products">&lt;&lt;Quản lý sản phẩm</a>
					</div>
					<form action="create" method="POST">
						<input type="text" name="optionId" placeholder="Mã option"
							class="form-control" /> <select name="productId"
							class="form-control">
							<option value="-1">-- Lựa chọn sản phẩm --</option>
						</select> <select name="colorId" class="form-control">
							<option value="-1">-- Lựa chọn màu sắc --</option>
						</select> <select name="sizeId" class="form-control">
							<option value="-1">-- Lựa chọn kích thước --</option>
						</select> <input type="text" name="availableQuantity"
							placeholder="Số lượng khả dụng" class="form-control" />
						<button class="btn-submit" type="submit">Lưu</button>
					</form>
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
