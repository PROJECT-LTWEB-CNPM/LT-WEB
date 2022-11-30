<%@page import="com.shoplane.utils.Helper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
request.setCharacterEncoding("utf-8");
String context = request.getContextPath();
String baseUrl = context + "/system/products/create";
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
						href="<%=context%>/system/products/?product_type=ALL&category=AO5&current_page=1&page_size=10">Quản
						lý sản phẩm</a> <i class="fas fa-angle-right"></i><a
						class="sub-nav-item"
						href="<%=context%>/system/products/create">Thêm sản phẩm</a>
				</div>
				<div class="customer_info">
					<div class="actions">
						<a
							href="<%=context%>/system/products/?product_type=ALL&category=AO5&current_page=1&page_size=10">&lt;&lt;Quản
							lý sản phẩm</a>
					</div>
					<form action="" method="POST">
						<input type="text" name="productId" hidden
							value="<%=Helper.getRandom()%>" /> <select name="categoryTypeId"
							class="form-control">
							<c:forEach var="item" items="${productTypes}">
								<option value="${item.getTypeId()}">${item.getTypeName()}</option>
							</c:forEach>
						</select> <select name="categoryId" class="form-control">
							<c:forEach var="item" items="${categories}">
								<option value="${item.getCategoryId()}">${item.getCategoryName()}</option>
							</c:forEach>
						</select> <input type="text" name="productName" id="productName"
							placeholder="Tên sản phẩm" class="form-control" /> <input
							type="text" name="mainImageUrl" id="mainImageUrl"
							placeholder="Hình ảnh" class="form-control" /> <input
							type="text" name="oldPrice" id="oldPrice" placeholder="Giá cũ"
							class="form-control" /> <input type="text" name="newPrice"
							id="newPrice" placeholder="Giá mới" class="form-control" /> <input
							type="text" name="description" placeholder="Mô tả"
							class="form-control" /> <input type="text" name="origin"
							id="origin" placeholder="Nguồn gốc" class="form-control" /> <input
							type="text" name="pattern" id="pattern" placeholder="Họa tiết"
							class="form-control" /> <input type="text" name="meterial"
							id="meterial" placeholder="Loại vải" class="form-control" />
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
