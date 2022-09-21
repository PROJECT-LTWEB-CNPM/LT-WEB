<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="tags" tagdir="/WEB-INF/tags"%>


<head>
<style>
.main {
	padding-top: 6rem;
}

.order__container {
	margin: 6rem 0;
}

.order__top {
	display: flex;
	align-items: flex-start;
	justify-content: space-between;
	gap: 3rem;
	margin-bottom: 2rem;
}

.order__bottom {
	max-width: 25rem;
}

.order__left {
	flex: 1;
}

.order__left, .order__right {
	border: 0.5px solid #ddd;
	border-radius: 0.4rem;
	padding: 1rem 2rem;
}

.order__right {
	min-width: 35rem;
}

.order__heading {
	margin-bottom: 1rem;
}

.order__item {
	display: flex;
	align-items: flex-start;
	gap: 1rem;
	padding-bottom: 1.5rem;
	border-bottom: 0.5px solid #ddd;
}

.order__item:not(:last-child ) {
	margin-bottom: 1.5rem;
}

.order__content {
	flex: 1;
}

.order__row {
	margin-bottom: 0.8rem;
}

.order__group {
	display: flex;
	justify-content: space-between;
	align-items: center;
}

.order__group-name {
	font-size: 1.8rem;
}

.order__remove-btn {
	outline: none;
	background-color: transparent;
	border: none;
	cursor: pointer;
}

.order__total {
	width: fit-content;
	margin-left: auto;
	font-weight: 700;
	font-size: 1.7rem;
	color: red;
}

.order__quanty, .order__quanty-action {
	display: flex;
	align-items: center;
	gap: 0.5rem;
}

.order__quanty-btn {
	background-color: transparent;
	outline: none;
	border: 1px solid #d2d2d2;
	padding: 0 0.6rem;
	display: flex;
	align-items: center;
	justify-content: center;
	cursor: pointer;
}

.order__remove-btn:hover {
	text-decoration: underline;
}

.order__payment {
	margin: 3rem 0 1.5rem 0;
	font-weight: 600;
	font-size: 2rem;
	display: flex;
	justify-content: space-between;
	align-items: center;
}

.order__payment-price {
	color: red;
}

.btn-submit {
	display: flex;
	align-items: center;
	justify-content: center;
	gap: 1rem;
	width: 100%;
	outline: none;
	border: 0.5px solid #6c757d;
	padding: 1rem 0;
	border-radius: 0.4rem;
	cursor: pointer;
	font-size: 1.6rem;
	color: #6c757d;
	background-color: transparent;
	transition: all linear 0.2s;
	width: 100%;
	width: 100%;
	gap: 1rem;
}

.btn-submit:hover {
	color: #fff;
	background-color: #6c757d;
}

.btn-submit ion-icon {
	font-size: 2.5rem;
}
</style>
</head>

<%
request.setCharacterEncoding("utf-8");
%>

<div class="container">
	<div class="order__container">
		<div class="order__top">
			<div class="order__left">
				<h3 class="order__heading">GIỎ HÀNG</h3>
				<div class="order__list">
					<%
					for (int i = 0; i < 3; i++) {
					%>
					<div class="order__item">
						<img class="order__image"
							src="https://product.hstatic.net/200000305259/product/vgc-tee_mockup_sep22-art_play-red_1_df951b2ad8fd4e2d8d9f1a635a58f6d9_master.jpg"
							width="100" height="100" alt="UPGRADE PLAY T-SHIRT/RED" />
						<div class="order__content">
							<div class="order__row order__group">
								<strong class="order__group-name">UPGRADE PLAY
									T-SHIRT/RED</strong>
								<button class="order__remove-btn">XÓA SẢN PHẨM</button>
							</div>
							<div class="order__row">KÍCH THƯỚC: XL</div>
							<div class="order__quanty order__row">
								<span class="order__quanty-title">SỐ LƯỢNG:</span>
								<div class="order__quanty-action">
									<button type="button" class="order__quanty-btn">-</button>
									<input type="text" size="1" name="updates" min="1" id=""
										data-price="" value="1" class="btn qty-btn">
									<button type="button" class="order__quanty-btn">+</button>
								</div>
							</div>
							<div class="order__total">69000₫</div>
						</div>
					</div>
					<%
					}
					%>
				</div>
			</div>
			<div class="order__right">
				<h3 class="order__heading">ĐƠN HÀNG</h3>
				<div class="order__payment">
					<span class="title_order order_item">Tổng tiền:</span> <span
						class="order__payment-price">270000₫</span>
				</div>
				<a class="btn-submit" href="./checkouts.jsp"> <span
					class="btn_cart-lable">THANH TOÁN</span> <ion-icon name="cart"></ion-icon>
				</a>
			</div>
		</div>
		<div class="order__bottom">
			<a class="btn-submit" href="${pageContext.request.contextPath}/">
				QUAY LẠI TRANG CHỦ </a>
		</div>
	</div>
</div>