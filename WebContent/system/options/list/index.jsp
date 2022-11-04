<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
request.setCharacterEncoding("utf-8");
String baseUrl = request.getContextPath() + "/system/options/list";
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
				<div class="actions">
					<a href="./">&lt;&lt;Quản lý sản phẩm</a> <a
						href="./options/create">Thêm lựa chọn</a> <a href="./delete">Xóa
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
									<a href="./options/detail?option_id=${item.getOptionId()}">Xem
										chi tiết</a>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
				<button>Quay lại</button>
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
