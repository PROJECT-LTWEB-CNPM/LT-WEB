<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
request.setCharacterEncoding("utf-8");
String context = request.getContextPath();
String baseUrl = context + "/system/products/list";

int[] entries = {10, 20, 30};
%>

<!doctype html>
<html lang="en">
<head>
<jsp:include page="../../head.jsp" />
<link rel="stylesheet" href="<%=baseUrl%>/index.css" />
<link rel="stylesheet" href="<%=baseUrl%>/pagination/pagination.css" />
<title>Quản lý sản phẩm - Shoplane</title>
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
					<div class="action__select">
						Loại sản phẩm <select style="width: 6rem" id="select__type"
							onchange="javascript:handleSelectProductType(this)">
							<c:forEach var="item" items="${productTypes}">
								<c:choose>
									<c:when test="${item.getTypeId().equals(productType)}">
										<option value="${item.getTypeId()}" selected>${item.getTypeName()}</option>
									</c:when>
									<c:otherwise>
										<option value="${item.getTypeId()}">${item.getTypeName()}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</div>
					<div class="action__select">
						Danh mục <select id="select__category"
							onchange="javascript:handleSelectCategory(this)">
							<c:forEach var="item" items="${categories}">
								<c:choose>
									<c:when test="${item.getCategoryId().equals(category)}">
										<option value="${item.getCategoryId()}" selected>${item.getCategoryName()}</option>
									</c:when>
									<c:otherwise>
										<option value="${item.getCategoryId()}">${item.getCategoryName()}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</div>
					<div class="action__select">
						Xem <select style="width: 5rem" id="select__entries"
							onchange="javascript:handleSelectEntries(this)">
							<c:forEach end="3" begin="1" var="item">
								<c:choose>
									<c:when test="${(item * 10) == pageSize}">
										<option value="${item * 10}" selected>${item * 10}</option>
									</c:when>
									<c:otherwise>
										<option value="${item * 10}">${item * 10}</option>
									</c:otherwise>
								</c:choose>

							</c:forEach>
						</select> sản phẩm
					</div>

					<a href="./create">Thêm sản phẩm</a> <a href="./delete">Xóa sản
						phẩm</a>
				</div>
				<div class="table">
					<div class="table__head">
						<div style="width: 5%">
							<input type="checkbox">
						</div>
						<div style="width: 10%">ID</div>
						<div style="width: 25%">Tên sản phẩm</div>
						<div style="width: 15%">Hình ảnh</div>
						<div style="width: 10%">Loại sản phẩm</div>
						<div style="width: 10%">Danh mục</div>
						<div style="width: 10%">Các lựa chọn</div>
						<div style="width: 15%"></div>
					</div>
					<div class="table__body">
						<c:forEach var="item" items="${products}">
							<div class="table__row">
								<div style="width: 5%">
									<input type="checkbox">
								</div>
								<div style="width: 10%">${item.getProductId()}</div>
								<div style="width: 25%">${item.getProductName()}</div>
								<div style="width: 15%">
									<img src="${item.getMainImageUrl()}"
										alt="${item.getProductName()}"
										style="height: 60px; object-fit: cover" />
								</div>
								<div style="width: 10%">${item.getProducttype().getTypeName()}</div>
								<div style="width: 10%">${item.getCategory().getCategoryName()}</div>
								<div style="width: 10%" class="table__link">
									<a
										href="<%=context %>/system/products/options?product_id=${item.getProductId()}">Xem
										thêm</a>
								</div>
								<div style="width: 15%" class="table__link">
									<a
										href="<%=context %>/system/products/detail?product_id=${item.getProductId()}">Xem
										chi tiết</a>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
				<jsp:include page="./pagination/pagination.jsp"></jsp:include>
			</main>
		</div>
	</div>
	<!-- Jquery -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"
		integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>

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
