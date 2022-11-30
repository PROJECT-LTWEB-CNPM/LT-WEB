<%@page import="com.shoplane.utils.Helper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
request.setCharacterEncoding("utf-8");
String context = request.getContextPath();
String baseUrl = request.getContextPath() + "/system/options/create";
%>

<!doctype html>
<html lang="en">
<head>
<jsp:include page="../../head.jsp" />
<link rel="stylesheet" href="<%=baseUrl%>/index.css" />
<title>Thêm sản phẩm - Shoplane</title>
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
				<div class="sub-nav">
					<a class="sub-nav-item"
						href="<%=context%>/system/bills/?current_page=1&page_size=10">Quản
						lý hóa đơn</a> <i class="fas fa-angle-right"></i><a
						class="sub-nav-item"
						href="<%=context%>/system/bills/create/">Thêm
						hóa đơn</a>
				</div>
				<div class="customer_info">
					<form action="" method="POST">
						<input name="optionId" value="OP<%=Helper.getRandom()%>" hidden />
						<select name="productId" class="form-control">
							<option value="${productId}">${product.getProductName()}</option>
						</select> <select name="colorId" class="form-control">
							<c:forEach var="item" items="${colors}">
								<option value="${item.getColorId()}">
									${item.getColorName()}</option>
							</c:forEach>
						</select> <select name="sizeId" class="form-control">
							<c:forEach var="item" items="${sizes}">
								<option value="${item.getSizeId()}">
									${item.getSizeName()}</option>
							</c:forEach>
						</select> <input type="text" name="availableQuantity"
							placeholder="Số lượng khả dụng" class="form-control" required />
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
