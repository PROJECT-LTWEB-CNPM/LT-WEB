p<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="tags" tagdir="/WEB-INF/tags"%>


<head>
<style>
.main {
	padding-top: 6rem;
}

.checkouts__container {
	display: flex;
	flex-direction: row;
	justify-content: space-between;
	margin: 6rem;
}
/* Content */
.group_content:first-child {
	flex-basis: 58%;
	border-right: 1px solid rgb(176, 175, 175);
}

.info_customer {
	color: var(- -text-color);
	font-size: 1.8rem;
	opacity: 0.8;
	margin-bottom: 1rem;
}

.form-control {
	width: 90%;
	margin-bottom: 1rem;
	outline: none;
	padding: 1rem 1.5rem;
	border-radius: 0.4rem;
	border: 1px solid #ddd;
	display: block;
	font-size: 1.4rem;
}

.form-control:focus {
	outline: none !important;
	border-color: #719ECE;
	box-shadow: 0 0 10px #719ECE;
}

.checkBill_policy-first, .checkBill_policy-second {
	display: flex;
	flex-direction: row;
	width: 90%;
	justify-content: space-between;
	border: 1px solid #e3e3e3;
	height: 40px;
	line-height: 40px;
	padding: 0 16px;
	margin-top: 16px;
}

.checkBill_policy-first {
	border-radius: 10px;
}

.checkBill_policy-second {
	border-top-left-radius: 10px;
	border-top-right-radius: 10px;
}

.checkBill_policy-first i, .checkBill_policy-second i {
	color: var(- -text-color);
	font-weight: 500;
	font-size: 1.4rem;
	margin-right: 4px;
}

.checkBill_policy-first span, .checkBill_policy-second span {
	color: #757575;
	font-size: 1.4rem;
}

.checkBill_policy-content {
	width: 90%;
	background-color: #F2F2F2;
	padding: 8px 16px;
}

.checkBill_policy-content p {
	text-align: justify;
	font-size: 1.3rem;
	color: rgba(0, 0, 0, 0.6);
}

.checkBill_policy-content p:first-child {
	margin-bottom: 4px;
}

.btn_container {
	display: flex;
	align-items: center;
	justify-content: space-between;
	max-width: 90%;
	gap: 12rem;
	margin-top: 2rem;
}

.group_content:last-child {
	flex-basis: 38%;
}

.bill_info {
	display: flex;
	flex-direction: row;
	justify-content: space-between;
}

.bill_info:not(:last-child) {
	margin-bottom: 1rem;
}

.bill_info:last-child {
	border-top: 0.5px solid #d2d2d2;
	padding-top: 1rem;
}

.bill_info h3 {
	color: var(- -text-color);
	font-size: 1.8rem;
	opacity: 0.8;
}

.bill_info h3:last-child {
	color: red;
}

.btn-submit {
	display: flex;
	justify-content: center;
	align-items: center;
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
}

.btn-submit:hover {
	color: #fff;
	background-color: #6c757d;
}
</style>
</head>

<%
request.setCharacterEncoding("utf-8");
%>

<tags:base title="Giỏ hàng của bạn - SHOPLANE"
	css="../../assets/css/index.css">
	<jsp:include page="../header.jsp" />
	<main class="main">
		<div class="container">
			<!-- Content -->
			<div class="checkouts__container">
				<div class="group_content">
					<h3 class="info_customer">THÔNG TIN GIAO HÀNG</h3>
					<input class="form-control" type="email" name="email"
						placeholder="Họ và tên" required> <input
						class="form-control" type="text" name="password"
						placeholder="Số điện thoại" required> <input
						class="form-control" type="text" name="password"
						placeholder="Địa chỉ" required> <input
						class="form-control" type="text" name="password"
						placeholder="Số điện thoại" required>

					<div class="form-control"
						style="display: flex; align-items: center; justify-content: space-between;">
						<div style="color: #d2d2d2">
							<i class="fas fa-dot-circle"></i> <span>Giao hàng tận nơi</span>
						</div>
						<span>35,000đ</span>
					</div>
					<div class="checkBill_policy-second">
						<div>
							<i class="fa-regular fa-circle-dot"></i> <span>Thanh toán
								khi giao hàng (COD)</span>
						</div>
					</div>
					<div class="checkBill_policy-content">
						<p>1. Khi click vào nút hoàn tất đơn hàng thì đơn hàng sẽ được
							hệ thống tự động xác nhận mà không cần phải gọi qua điện thoại,
							nếu điền thông tin địa chỉ và số điện thoại chính xác thì đơn
							hàng sẽ được vận chuyển từ 3-4-5 ngày tùy vùng miền.</p>
						<p>2. Trường hợp đặt hàng xong nhưng muốn HỦY ĐƠN, vui lòng
							soạn tin nhắn theo cú pháp: SĐT ĐÃ ĐẶT ĐƠN (hoặc MÃ ĐƠN hoặc
							GMAIL ĐƠN HÀNG) + TÊN NGƯỜI NHẬN sau đó gửi qua các kênh online:
							Page Facebook, Intagram. Nhân viên check tin nhắn sẽ xử lý hủy
							giúp Quý KH.</p>
					</div>
					<div class="btn_container">
						<button class="btn-submit">
							<span class="btn_cart-lable">Quay lại giỏ hàng</span>
							<ion-icon name="cart"></ion-icon>
						</button>
						<button class="btn-submit">
							<span class="btn_cart-lable">Hoàn tất đơn hàng</span>
						</button>
					</div>
				</div>
				<div class="group_content">
					<div class="bill_info">
						<h3>Tạm tính:</h3>
						<h3>69,000đ</h3>
					</div>
					<div class="bill_info">
						<h3>Phí vận chuyển:</h3>
						<h3>35,000đ</h3>
					</div>
					<div class="bill_info">
						<h3>Tổng:</h3>
						<h3>104,000đ</h3>
					</div>
				</div>
			</div>
		</div>
	</main>
	<jsp:include page="../footer.jsp" />
</tags:base>
