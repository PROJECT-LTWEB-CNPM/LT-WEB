<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
request.setCharacterEncoding("utf-8");
String context = request.getContextPath();

int[] entries = {10, 20, 30};
%>

<!doctype html>
<html lang="en">
<head>
<jsp:include page="../../head.jsp" />
<link rel="stylesheet"
	href="<%=context%>/assets/css/system/product/trash/index.css"
	type="text/css" />
<link rel="stylesheet"
	href="<%=context%>/assets/css/system/components/pagination.css"
	type="text/css" />
<title>Thùng rác - SHOPLANE</title>
</head>
<body>
	<div id="app">
		<div id="sidebar">
			<jsp:include page="../../components/sidebar.jsp" />
		</div>
		<div id="content">
			<div id="header">
				<jsp:include page="../../components/header.jsp" />
			</div>
			<main id="main-content">
				<div class="sub-nav">
					<a class="sub-nav-item"
						href="<%=context%>/system/products/?product_type=ALL&category=AO5&current_page=1&page_size=10">Quản
						lý sản phẩm</a> <i class="fas fa-angle-right"></i> <a
						class="sub-nav-item" href="<%=context%>/system/products/trash/">Thùng
						rác</a>
				</div>
				<div class="actions">
					<a href="" class="btnDeleteProducts">Xóa tất cả</a> <a
						href="<%=context%>/system/products/trash/">Khôi phục tất cả</a>
				</div>
				<div class="table">
					<div class="table__head">
						<div style="width: 5%">
							<input type="checkbox">
						</div>
						<div style="width: 10%">Mã sản phẩm</div>
						<div style="width: 20%">Tên sản phẩm</div>
						<div style="width: 10%">Hình ảnh</div>
						<div style="width: 10%">Loại sản phẩm</div>
						<div style="width: 10%">Danh mục</div>
						<div style="width: 10%">Tình trạng</div>
						<div style="width: 10%"></div>
						<div style="width: 15%"></div>
					</div>
					<div class="table__body">
						<c:forEach var="item" items="${products}">
							<div class="table__row">
								<div style="width: 5%">
									<input type="checkbox" name="productSelected"
										value="${item.getProductId()}">
								</div>
								<div style="width: 10%">${item.getProductId()}</div>
								<div style="width: 20%">${item.getProductName()}</div>
								<div style="width: 10%">
									<img src="${item.getMainImageUrl()}"
										alt="${item.getProductName()}"
										style="height: 60px; object-fit: cover" />
								</div>
								<div style="width: 10%">${item.getProductTypeBean().getTypeName()}</div>
								<div style="width: 10%">
									${item.getCategory().getCategoryName()}</div>
								<div style="width: 10%" class="table__link">
									<c:choose>
										<c:when test="${item.getIsActive() == 0}">
										Còn hàng	
									</c:when>
										<c:otherwise>
										Hết hàng	
									</c:otherwise>
									</c:choose>
								</div>
								<div style="width: 10%" class="table__link">
									<a
										href="<%=context %>/system/products/images/?product_id=${item.getProductId()}">Xóa</a>
								</div>
								<div style="width: 15%" class="table__link">
									<a
										href="<%=context %>/system/products/detail/?product_id=${item.getProductId()}">Khôi
										phục</a>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
				<jsp:include page="./pagination.jsp"></jsp:include>
			</main>
		</div>
	</div>
	<!-- Jquery -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"
		integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script type="text/javascript"
		src="<%=context%>/assets/js/softDeleteProduct.js"></script>

	<script type="text/javascript">
		function handleSelectProductType(elm) {
			const queryString = window.location.search;
			const urlParams = new URLSearchParams(queryString);

			const category = urlParams.get('category');
			const pageSize = urlParams.get('page_size');

			window.location = '?product_type=' + elm.value + '&category='
					+ category + '&current_page=1&page_size=' + pageSize;

		}
		function handleSelectCategory(elm) {
			const queryString = window.location.search;
			const urlParams = new URLSearchParams(queryString);

			const productType = urlParams.get('product_type');
			const pageSize = urlParams.get('page_size');

			window.location = '?product_type=' + productType + '&category='
					+ elm.value + '&current_page=1&page_size=' + pageSize;
		}

		function handleSelectEntries(elm) {
			const queryString = window.location.search;
			const urlParams = new URLSearchParams(queryString);

			const productType = urlParams.get('product_type');
			const category = urlParams.get('category');

			window.location = '?product_type=' + productType + '&category='
					+ category + '&current_page=1&page_size=' + elm.value;
		}
	</script>
</body>
</html>
