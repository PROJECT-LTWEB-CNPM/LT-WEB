<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("utf-8");
String baseUrl = request.getContextPath() + "/system/products/detail-update";
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
						<a href="./">&lt;&lt;Quản lý sản phẩm</a>
					</div>
					<form action="update" method="POST">
						<input type="text" name="productName" id="productName"
							placeholder="Tên sản phẩm" class="form-control"
							value="${product.getProductName()}" /> 
						<input type="text"
							name="mainImageUrl" id="mainImageUrl" placeholder="Hình ảnh"
							class="form-control" value="${product.getMainImageUrl()}" /> 
						<input
							type="text" name="oldPrice" id="oldPrice"
							placeholder="Giá cũ" class="form-control"
							value="${product.getOldPrice()}" /> 
						<input type="text"
							name="newPrice" id="newPrice" placeholder="Giá mới"
							class="form-control" value="${product.getNewPrice()}"/> 
						<input type="text" name="productName"
							id="productName" placeholder="Mô tả" class="form-control"
							value="${product.getDescription()}" /> 
						<input type="text"
							name="origin" id="origin" placeholder="Nguồn gốc"
							class="form-control"value="${product.getOrigin()}" /> 
						<input type="text" name="pattern"
							id="pattern" placeholder="Họa tiết" class="form-control" value="${product.getPattern()}"/>
							
						<input type="text" name="meterial" id="meterial"
							placeholder="Loại vải" class="form-control" value="${product.getMeterial()}"/>
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
