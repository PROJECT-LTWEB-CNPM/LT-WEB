<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@page import="java.util.Arrays"%> <%@page
import="java.util.List"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="categories" class="services.CategoryService"></jsp:useBean>

<% request.setCharacterEncoding("utf-8"); String categoryId = (String)
request.getAttribute("categoryId"); String context = request.getContextPath();
String baseUrl = context + "/default/collections"; %>

<!DOCTYPE html>
<html lang="en">
<<<<<<< HEAD
  <head>
    <jsp:include page="../head.jsp" />
    <link rel="stylesheet" href="<%=baseUrl%>/index.css" />
    <title>${cateName} - Shoplane</title>
    <style>
      .main {
        padding-top: 6rem;
      }
    </style>
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
                  <li
                    class="category-item ${categoryId == 'AO5' || categoryId == 'QUAN4' ? 'active' : ''}"
                  >
                    <a
                      href="<%=context%>/collection?category_id=AO5&category_type=${categoryType}"
                      class="category-item__link"
                      >TẤT CẢ SẢN PHẨM</a
                    >
                  </li>
                  <c:forEach var="item" items="${cates}">
                    <li
                      class="category-item ${categoryId == item.getCategoryId() ? 'active' : ''}"
                    >
                      <a
                        href="<%=context %>/collection?category_id=${item.getCategoryId()}&category_type=${categoryType}"
                        class="category-item__link"
                        >${item.getCategoryName()}</a
                      >
                    </li>
                  </c:forEach>
                </ul>
              </div>
            </div>
            <div class="grid__column_3">
              <div class="product_filter">
                <h3 class="type_of_product">${cateName}</h3>
                <div class="option_filter">
                  <h3 class="option_filter-label">SẮP XẾP THEO</h3>
                  <form>
                    <select class="option_filter-group" tabindex="-1">
                      <option value="manual">Sản phẩm nổi bật</option>
                      <option value="price-ascending">Giá: Tăng dần</option>
                      <option value="price-descending">Giá: Giảm dần</option>
                      <option value="title-ascending">Tên: A-Z</option>
                      <option value="title-descending">Tên: Z-A</option>
                      <option value="created-ascending">Cũ nhất</option>
                      <option value="created-descending" selected>
                        Mới nhất
                      </option>
                      <option value="best-selling">Bán chạy nhất</option>
                    </select>
                  </form>
                </div>
              </div>
              <div class="grid__row">
                <c:forEach var="item" items="${productBycategoryId}">
                  <div class="grid__column-3-3">
                    <div class="group_content">
                      <div
                        class="home-product-item__img"
                        style="background-image: url(${item.getMainImageUrl()})"
                      ></div>
                      <h4 class="home-product-item__name">
                        <a
                          href="<%=context %>/product-detail?product_id=${item.getProductId()}"
                          >${item.getProductName()}</a
                        >
                      </h4>
                      <h4 class="shop_name">SHOPLANE</h4>
                      <div class="home-product-item__rating">
                        <i class="fas fa-star"></i> <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i> <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                      </div>
                      <div class="home-product-item__price">
                        <span class="home-product-item__price-current"
                          >${item.getNewPrice()}đ</span
                        >
                        <span class="home-product-item__price-old"
                          >${item.getOldPrice()}đ</span
                        >
                      </div>
                    </div>
                  </div>
                </c:forEach>
              </div>
              <div class="show_all">
                <button class="btn-submit">XEM THÊM 45 SẢN PHẨM KHÁC</button>
              </div>
            </div>
          </div>
        </div>
      </main>
      <jsp:include page="../footer/footer.jsp" />
      <jsp:include page="../back-to-top/back-to-top.jsp" />
    </div>

    <!-- Jquery -->
    <script
      src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"
      integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA=="
      crossorigin="anonymous"
      referrerpolicy="no-referrer"
    ></script>
    <jsp:include page="../script.jsp" />
  </body>
=======
<head>
<jsp:include page="../head.jsp" />
<link rel="stylesheet" href="<%=baseUrl%>/index.css" />
<title>Tất cả sản phẩm - SHOPLANE</title>
<title>${cateName}-Shoplane</title>
<style>
.main {
	padding-top: 6rem;
}
</style>
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
								<li
									class="category-item ${categoryId == 'AO5' || categoryId == 'QUAN4' ? 'active' : ''}">
									<a
									href="<%=context%>/collection?category_id=AO5&category_type=${categoryType}"
									class="category-item__link">TẤT CẢ SẢN PHẨM</a>
								</li>
								<c:forEach var="item" items="${cates}">
									<li
										class="category-item ${categoryId == item.getCategoryId() ? 'active' : ''}">
										<a
										href="<%=context %>/collection?category_id=${item.getCategoryId()}&category_type=${categoryType}"
										class="category-item__link">${item.getCategoryName()}</a>
									</li>
								</c:forEach>
							</ul>
						</div>
					</div>
					<div class="grid__column_3">
						<div class="product_filter">
							<h3 class="type_of_product">${cateName}</h3>
							<div class="option_filter">
								<h3 class="option_filter-label">SẮP XẾP THEO</h3>
								<form>
									<select class="option_filter-group" tabindex="-1">
										<option value="manual">Sản phẩm nổi bật</option>
										<option value="price-ascending">Giá: Tăng dần</option>
										<option value="price-descending">Giá: Giảm dần</option>
										<option value="title-ascending">Tên: A-Z</option>
										<option value="title-descending">Tên: Z-A</option>
										<option value="created-ascending">Cũ nhất</option>
										<option value="created-descending" selected>Mới nhất
										</option>
										<option value="best-selling">Bán chạy nhất</option>
									</select>
								</form>
							</div>
						</div>
						<div class="grid__row">
							<c:forEach var="item" items="${productBycategoryId}">
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
											<i class="fas fa-star"></i> <i class="fas fa-star"></i> <i
												class="fas fa-star"></i> <i class="fas fa-star"></i> <i
												class="fas fa-star"></i>
										</div>
										<div class="home-product-item__price">
											<span class="home-product-item__price-current">${item.getNewPrice()}đ</span>
											<span class="home-product-item__price-old">${item.getOldPrice()}đ</span>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
						<div class="show_all">
							<button class="btn-submit">XEM THÊM 45 SẢN PHẨM KHÁC</button>
						</div>
					</div>
				</div>
			</div>
		</main>
		<jsp:include page="../footer/footer.jsp" />
		<jsp:include page="../back-to-top/back-to-top.jsp" />
	</div>

	<!-- Jquery -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"
		integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<jsp:include page="../script.jsp" />

</body>
>>>>>>> 5ff24020b2ced68e7b1712c7d6212c23aaf10030
</html>
