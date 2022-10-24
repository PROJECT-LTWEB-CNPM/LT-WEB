<%@page import="models.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
request.setCharacterEncoding("utf-8");
String context = request.getContextPath();
String url = "";
User u = (User) session.getAttribute("user");
if (u != null) {
	url = context + "/checkout";
} else {
	url = context + "/login";
	String cartUrl = context + "/cart";
	session.setAttribute("caller", cartUrl);
}
%>
<div class="order__container">
	<div class="order__top">
		<div class="order__left">
			<h3 class="order__heading">GIỎ HÀNG</h3>
			<div class="order__list">
				<c:forEach var="o" items="${orders}">
					<div class="order__item">
						<img class="order__image"
							src="${o.getOption().getProduct().getMainImageUrl()}" width="100"
							height="100" alt="${o.getOption().getProduct().getProductName()}" />
						<div class="order__content">
							<div class="order__row order__group">
								<strong class="order__group-name">${o.getOption().getProduct().getProductName()}</strong>
								<form action="cart" method="POST">
									<input type="text" name="oId" value="12" hidden />
									<button class="order__remove-btn" type="submit">XÓA
										SẢN PHẨM</button>
								</form>
							</div>
							<div class="order__row">KÍCH THƯỚC:
								${o.getOption().getSize().getSizeName()}</div>
							<div class="order__quanty order__row">
								<span class="order__quanty-title">SỐ LƯỢNG:</span>
								<div class="order__quanty-action">
									<button type="button" class="order__quanty-btn">-</button>
									<input type="text" name="updates" size="1"
										value="${o.getOrderedQuantity()}" class="btn qty-btn">
									<button type="button" class="order__quanty-btn">+</button>
								</div>
							</div>
							<div class="order__total">${o.getOption().getProduct().getNewPrice()}₫</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="order__right">
			<h3 class="order__heading">ĐƠN HÀNG</h3>
			<div class="order__payment">
				<span class="title_order order_item">Tổng tiền:</span> <span
					class="order__payment-price">270000₫</span>
			</div>
			<a class="btn-submit" href="<%=url%>"> <span
				class="btn_cart-lable">THANH TOÁN</span> <ion-icon name="cart"></ion-icon>
			</a>
		</div>
	</div>
	<div class="order__bottom">
		<a class="btn-submit" href="${pageContext.request.contextPath}/">TRANG
			CHỦ </a>
	</div>
</div>
