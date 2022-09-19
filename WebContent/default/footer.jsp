<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/default/footer.css"
	type="text/css" />
<style>
.grid {
	width: 1200px;
	max-width: 100%;
	margin: 0 auto;
}

.grid__row {
	display: flex;
	flex-wrap: wrap;
	margin-left: -5px;
	margin-right: -5px;
}

.grid__column {
	padding-left: 10px;
	padding-right: 10px;
	width: 25%;
	margin-bottom: 32px;
}

/* Top */

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
			<div class="grid">
				<div class="grid__row">
					<%
					for (int i = 0; i < 4; i++) {
					%>
					<div class="grid__column">
						<h2 class="footer_title">THÔNG TIN LIÊN HỆ</h2>
						<p class="footer_content">
							<b>Địa chỉ</b>: 5/15 Tô Hiệu, Tân Thới Hòa, Tân Phú, Hồ Chí Minh
							(Giờ mở cửa sáng: 08H30 -> 11H30, Giờ nghĩ trưa: 11H30 -> 13H30,
							Giờ mở cửa buổi chiều: 13H30 -> 17H45) KH vui lòng đến đúng khung
							giờ mở cửa trên để mua hàng.
						</p>
						<p class="footer_phonenumber">
							<b>Phone</b>: 037 335 7405.
						</p>
						<p class="footer_email">
							<b>Email</b>: shoplane.contact@gmail.com
						</p>
					</div>
					<%
					}
					%>
				</div>
			</div>

		</div>
	</div>
	<div class="header__copyright">
		©Copyright 2022. Bản quyền thuộc về <span>shoplane</span>.
	</div>

</footer>