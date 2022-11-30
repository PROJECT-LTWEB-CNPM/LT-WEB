<%@page import="com.shoplane.utils.Helper"%>
<%@page import="com.shoplane.utils.Constants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
request.setCharacterEncoding("utf-8");
String categoryId = (String) request.getAttribute("categoryId");
String context = request.getContextPath();
String baseUrl = context + "/default/collections";
%>

<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="../head.jsp" />
<link rel="stylesheet" href="<%=baseUrl%>/index.css" />
<link rel="stylesheet" href="<%=baseUrl%>/pagination/pagination.css" />
<title>${c.getCategoryName()} - Shoplane</title>
</head>
<body>
	<div id="app">
		<jsp:include page="../header/header.jsp" />
		<main class="main">
			<div class="container">
				<div class="grid__row collection__container">
					<div class="grid__column">
						<div class="category__container">
							<h3 class="category__heading">Danh Mục</h3>
							<div class="btn_close">
								<i class="fa-solid fa-xmark"></i>
							</div>
							<ul class="category-list">
								<c:forEach var="item" items="${categories}">
									<li
										class="category-item ${category == item.getCategoryId() ? 'active' : ''}">
										<a
										href="<%=context %>/collection/?product_type=${item.getProducttype().getTypeId()}&category_id=${item.getCategoryId()}&current_page=1&page_size=12"
										class="category-item__link">${item.getCategoryName()}</a>
									</li>
								</c:forEach>
							</ul>
						</div>
					</div>
					<div class="grid__column_3">
						<div class="product_filter">
							<h3 class="type_of_product">${c.getCategoryName()}</h3>
							<div class="option_filter">
								<h3 class="option_filter-label">SẮP XẾP THEO</h3>
								<form
									action="${requestScope['javax.servlet.forward.request_uri']}?category_id=${categoryId}&category_type=${categoryType}"
									method="post">
									<select onchange="this.form.submit()" name="orderType"
										class="option_filter-group" tabindex="-1">
										<option value="<%=Constants.OLDEST%>">Cũ nhất</option>
										<option value="<%=Constants.NEWEST%>">Mới nhất</option>
										<option value="<%=Constants.DESC%>">Giá giảm dần</option>
										<option value="<%=Constants.ASC%>">Giá tăng dần</option>
									</select>
								</form>
							</div>
						</div>
						<div class="grid__row">
							<c:forEach var="item" items="${products}">
								<div class="grid__column-3-3">
									<div class="group_content">
										<div class="home-product-item__img"
											style="background-image: url(${item.getMainImageUrl()})"></div>
										<h4 class="home-product-item__name">
											<a
												href="<%=context %>/product-detail?product_id=${item.getProductId()}">${item.getProductName()}</a>
										</h4>
										<h4 class="shop_name">SHOPLANE</h4>
										<div class="home-product-item__rating">
											<c:forEach begin="1" end="5">
												<i class="fas fa-star"></i>
											</c:forEach>
										</div>
										<div class="home-product-item__price">
											<span class="home-product-item__price-current">${Helper.intToVND(item.getNewPrice())}</span>
											<span class="home-product-item__price-old">${Helper.intToVND(item.getOldPrice())}</span>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
						<div class="show_all">
							<jsp:include page="./pagination/pagination.jsp" />
						</div>
					</div>
				</div>
			</div>
		</main>
		<jsp:include page="../footer/footer.jsp" />
		<jsp:include page="../back-to-top/back-to-top.jsp" />
	</div>
	<jsp:include page="../script.jsp" />
</body>
</html>
