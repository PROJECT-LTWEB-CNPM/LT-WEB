<%@page import="com.shoplane.models.User"%>
<%@page import="com.shoplane.utils.Constants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="categoryDAO" class="com.shoplane.dao.CategoryDAO" />
<jsp:useBean id="productTypeDAO" class="com.shoplane.dao.ProductTypeDAO" />
<%
String context = request.getContextPath();
String url = null;
url = context + "/login";
User u = (User) session.getAttribute("user");
if (u != null) {
	url = context + "/account";
} else {
	url = context + "/login";
}
%>

<header class="header">
	<div class="container">
		<ul class="header__navbar">
			<li class="header__navbar-left">
				<div class="header__navbar-item hide header__logo">
					<a href="<%=context%>/"> <span>SHOP</span><span>LANE</span>
					</a>
				</div>
				<div class="header__navbar-item hide dropdown">
					<a href="<%=context%>/collection?category_id=AO5&category_type=AO">ÁO</a>
					<c:if test="${ categoryDAO != null && productTypeDAO != null}">
						<div class="dropdown-content">
							<c:forEach var="item"
								items="${categoryDAO.findByProductType(productTypeDAO.find(Constants.SHIRT))}">
								<a
									href="<%=context %>/collection?category_id=${item.getCategoryId()}&category_type=AO">${item.getCategoryName()}</a>
							</c:forEach>
						</div>
					</c:if>
				</div>
				<div class="header__navbar-item hide dropdown">
					<a
						href="<%=context%>/collection?category_id=QUAN4&category_type=QUAN">QUẦN</a>
					<c:if test="${ categoryDAO != null && productTypeDAO != null}">
						<div class="dropdown-content">
							<c:forEach var="item"
								items="${categoryDAO.findByProductType(productTypeDAO.find(Constants.SHORT))}">
								<a
									href="<%=context %>/collection?category_id=${item.getCategoryId()}&category_type=QUAN">${item.getCategoryName() }</a>
							</c:forEach>
						</div>
					</c:if>
				</div>
			</li>
			<li class="header__navbar-item header__navbar-item-search"><i
				class="fas fa-search header__navbar-item-search-icon"></i>
				<form action="search" method="get" style="width: 100%;">
					<input type="text" placeholder="Tìm kiếm quần áo...."
						class="header__navbar-item-search-input" autofocus
						name="product_name" /> <input type="submit" style="display: none" />
				</form></li>
			<li class="header__navbar-item header__navbar-actions"><a
				href="<%=context%>/cart" class="header__navbar-item-link"><ion-icon
						name="cart-outline"></ion-icon>
					<div class="header_navbar-count"></div> <input id='ordersCount'
					type='hidden' value='${sessionScope.orderSize}' /> </a> <a
				href="<%=url%>" class="header__navbar-item-link"><ion-icon
						name="person-outline"></ion-icon></a></li>
		</ul>
	</div>
</header>