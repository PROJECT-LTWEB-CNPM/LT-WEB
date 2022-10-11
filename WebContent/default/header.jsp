<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
<jsp:useBean id="categories" class="services.CategoryService"></jsp:useBean>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/default/header.css" />

<style>
.header {
	z-index: 999;
}

.header__logo>a {
	color: #5ec9ff;
}

.dropdown {
	position: relative;
	display: inline-block;
}

.dropdown>a, .dropdown-content a {
	font-weight: 500;
	font-size: 1.7rem;
}

.dropdown>a, .dropdown-content a {
	transition: all linear 0.1s;
}

.dropdown>a:hover, .dropdown-content a:hover {
	color: #358dba;
}

.dropdown-content {
	position: absolute;
	background-color: #f9f9f9;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1000;
	display: none;

	/*
	transform: translate(-20%, 5%);
	*/
}

.dropdown-content a {
	color: black;
	padding: 0.8rem 1.5rem;
	text-decoration: none;
	display: block;
	text-decoration: none;
}

.dropdown-content a:hover {
	background-color: #f1f1f1;
}

.dropdown:hover .dropdown-content {
	display: block;
}

.header__navbar-item-search, .header__navbar-item-search-input, form {
	background: var(--white-color-5);
}

.header__navbar-item-link>ion-icon {
	font-size: 2.5rem !important;
	transition: all linear 0.1s;
}

.header__navbar-item-link>ion-icon:hover {
	color: #5ec9ff;
}

.header__navbar-item-link>ion-icon[name="cart-outline"] {
	font-size: 2.8rem !important;
}

.header__navbar-left {
	display: flex;
	align-items: center;
	gap: 2.5rem;
}

.header__navbar-actions {
	display: flex;
	align-items: center;
	gap: 2rem;
}

.header__navbar-count {
	position: absolute;
	width: 2.5rem;
	height: 2rem;
	top: -20%;
	right: -40%;
	border: 0.5px solid #5ec9ff;
	border-radius: 2rem;
	color: #fff;
	font-size: 1.4rem;
	background-color: #5ec9ff;
	font-weight: 400;
	display: flex;
	align-items: center;
	justify-content: center;
}
</style>
</head>

<header class="header">
	<div class="container">
		<ul class="header__navbar">
			<li class="header__navbar-left">
				<div class="header__navbar-item hide header__logo">
					<a href="${pageContext.request.contextPath}/"> <span>SHOP</span><span>LANE</span>
					</a>
				</div>
				<div class="header__navbar-item hide dropdown">
					<a href="${pageContext.request.contextPath}/">ÁO</a>
					<div class="dropdown-content">
						<c:forEach var="item" items="${categories.getAllShirtType()}">
							<a
								href="${pageContext.request.contextPath}/ProductController?categoryId=${item.getCategoryId()}">${item.getCategoryName() }</a>
						</c:forEach>
					</div>
				</div>
				<div class="header__navbar-item hide dropdown">
					<a href="${pageContext.request.contextPath}/">QUẦN</a>
					<div class="dropdown-content">
						<c:forEach var="item" items="${categories.getAllShortType()}">
							<a
								href="${pageContext.request.contextPath}/ProductController?categoryId=${item.getCategoryId()}">${item.getCategoryName() }</a>
						</c:forEach>
					</div>
				</div>
			</li>
			<li class="header__navbar-item header__navbar-item-search"><i
				class="fas fa-search header__navbar-item-search-icon"></i>
				<form action="ProductController" method="post" style="width:100%;">
					<input type="text" placeholder="Tìm kiếm quần áo...."
						class="header__navbar-item-search-input" autofocus
						name="findProduct" value=""/>
					<input type="submit" style="display:none"/>
				</form></li>

			<li class="header__navbar-item header__navbar-actions"><a
				href="${pageContext.request.contextPath}/ProductController?showCart=showCart"
				class="header__navbar-item-link"><ion-icon name="cart-outline"></ion-icon>
					<div class="header__navbar-count">0</div></a> <a
				href="${pageContext.request.contextPath}/default/account/index.jsp"
				class="header__navbar-item-link"><ion-icon name="person-outline"></ion-icon></a></li>
		</ul>
	</div>
</header>
