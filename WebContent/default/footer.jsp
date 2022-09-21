<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/default/footer.css"
	type="text/css" />
<style>
.footer {
	font-size: 1.4rem;
}

.footer__row {
	display: flex;
	align-items: center;
	justify-content: space-between;
	flex-wrap: wrap;
	gap: 2rem;
	padding: 4rem 0;
}

.footer__column {
	max-width: calc(1140px/ 4);
}

/* Copyright */
.header__copyright {
	padding: 1rem 0;
	text-align: center;
	border-top: 0.5px solid rgba(255, 255, 255, 0.6);
	font-size: 1.3rem;
}

.header__copyright>span {
	text-transform: uppercase;
	font-weight: 700;
}
</style>
</head>

<footer class="footer">
	<div class="footer__top">
		<div class="container">
			<div class="footer__row">
				<%
				for (int i = 0; i < 4; i++) {
				%>
				<div class="footer__column">
					<h3 class="footer__title">THÔNG TIN LIÊN HỆ</h3>
					<p class="footer__content">
						<b>Địa chỉ</b>: 5/15 Tô Hiệu, Tân Thới Hòa, Tân Phú, Hồ Chí Minh
						(Giờ mở cửa sáng: 08H30 -> 11H30, Giờ nghĩ trưa: 11H30 -> 13H30,
						Giờ mở cửa buổi chiều: 13H30 -> 17H45) KH vui lòng đến đúng khung
						giờ mở cửa trên để mua hàng.
					</p>
					<p class="footer__phone">
						<b>Phone</b>: 037 335 7405.
					</p>
					<p class="footer__email">
						<b>Email</b>: shoplane.contact@gmail.com
					</p>
				</div>
				<%
				}
				%>
			</div>
		</div>
	</div>
	<div class="header__copyright">
		©Copyright 2022. Bản quyền thuộc về <span>shoplane</span>.
	</div>

</footer>