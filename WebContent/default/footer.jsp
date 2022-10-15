<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/default/footer.css"
	type="text/css" />
<style>
.footer {
	font-size: 1.2rem;
	background-color: #1c2632;
}

.footer__row {
	display: flex;
	justify-content: space-between;
	flex-wrap: wrap;
	gap: 2rem;
	padding: 4rem 0;
}

.footer__column {
	width: calc(1140px/ 4);
}

.footer__title {
	padding-bottom: 0.5rem;
	margin-bottom: 1rem;
	font-size: 1.9rem;
	position: relative;
	width: fit-content;
}

.footer__title:after {
	content: '';
	position: absolute;
	height: 2px;
	width: 5rem;
	bottom: 0;
	left: 0;
	background-color: #5ec9ff;
}

.footer__content>p {
	text-align: justify;
	margin-bottom: 0.4rem;
	font-size: 1.4rem;
	color: #9ba0a5;
	line-height: 2rem;
	font-weight: 500;
}

.footer__content>p>b {
	font-weight: 700;
	color: #d3d3d3;
}

.footer__subtitle {
	font-size: 1.4rem;
	font-weight: 600;
	display: inline-block;
	margin-bottom: 2rem;
}

.footer__connect {
	display: flex;
	align-items: center;
	gap: 0.5rem;
}

.footer__connect>a {
	font-size: 2.5rem;
	transition: all 0.2s ease-in-out;
	color: #fff;
}

.footer__connect>a:hover {
	transform: translateY(-5px);
}

/* Copyright */
.header__copyright {
	padding: 1rem 0;
	text-align: center;
	border-top: 0.5px solid rgba(255, 255, 255, 0.6);
	font-size: 1.3rem;
	font-weight: 600;
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
				<div class="footer__column">
					<h3 class="footer__title">THÔNG TIN LIÊN HỆ</h3>
					<div class="footer__content">
						<p class="footer__address">
							<b>Địa chỉ</b>: 5/15 Tô Hiệu, Tân Thới Hòa, Tân Phú, Hồ Chí Minh
							(Giờ mở cửa sáng: 08h30 đến 11h30, Giờ nghĩ trưa: 11h30 đến
							13h30, Giờ mở cửa buổi chiều: 13h30 đến 17h45) KH vui lòng đến
							đúng khung giờ mở cửa trên để mua hàng.
						</p>
						<p class="footer__phone">
							<b>Phone</b>: 037 335 7405.
						</p>
						<p class="footer__email">
							<b>Email</b>: shoplane.contact@gmail.com
						</p>
					</div>
				</div>
				<div class="footer__column">
					<h3 class="footer__title">CHÍNH SÁCH HỖ TRỢ</h3>
					<div class="footer__content"></div>
				</div>
				<div class="footer__column">
					<h3 class="footer__title">THÔNG TIN LIÊN KẾT</h3>
					<div class="footer__content">
						<span class="footer__subtitle">Hãy kết nối với chúng tôi.</span>
						<div class="footer__connect">
							<a href="#"> <i class="fab fa-facebook"></i>
							</a> <a href="#"> <i class="fab fa-instagram"></i>
							</a>
						</div>
					</div>
				</div>
				<div class="footer__column">
					<h3 class="footer__title">THEO DÕI FANPAGE CHÚNG TÔI ĐỂ CẬP
						NHẬT XU HƯỚNG THỜI TRANG HOT NHẤT</h3>
					<div class="footer__content"></div>
				</div>
			</div>
		</div>
	</div>
	<div class="header__copyright">
		©Copyright 2022. Bản quyền thuộc về <span>shoplane</span>.
	</div>

</footer>