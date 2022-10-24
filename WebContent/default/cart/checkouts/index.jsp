<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="models.User"%>

<%
request.setCharacterEncoding("utf-8");
String context = request.getContextPath() + "/default/cart/checkouts";
String url = request.getContextPath();
User u = (User) session.getAttribute("user");
if (u != null) {
	url = "./checkouts.jsp";
} else {
	url = url + "/default/account/login/index.jsp";
	session.setAttribute("caller", "/default/cart/index.jsp");
}
%>

<!doctype html>
<html lang="en">
<head>
<jsp:include page="../../head.jsp" />
<link rel="stylesheet" href="<%=context%>/index.css" />
<title>Tất cả sản phẩm - SHOPLANE</title>
<style>
.main {
	padding-top: 6rem;
}
</style>
</head>
<body>
	<div id="app">
		<jsp:include page="../../header/header.jsp" />
		<main class="main">
			<div class="container">
				<!-- Content -->
				<div class="checkouts__container">
					<div class="group_content">
						<h3 class="info_customer">THÔNG TIN GIAO HÀNG</h3>
						<form action="checkout" method="POST">
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
									<i class="fas fa-dot-circle"></i> <span>Giao hàng tận
										nơi</span>
								</div>
								<span>35,000đ</span>
							</div>
							<div class="checkBill_policy-second">
								<div>
									<i class="fa-regular fa-circle-dot"></i> <span>Thanh
										toán khi giao hàng (COD)</span>
								</div>
							</div>
							<div class="checkBill_policy-content">
								<p>1. Khi click vào nút hoàn tất đơn hàng thì đơn hàng sẽ
									được hệ thống tự động xác nhận mà không cần phải gọi qua điện
									thoại, nếu điền thông tin địa chỉ và số điện thoại chính xác
									thì đơn hàng sẽ được vận chuyển từ 3-4-5 ngày tùy vùng miền.</p>
								<p>2. Trường hợp đặt hàng xong nhưng muốn HỦY ĐƠN, vui lòng
									soạn tin nhắn theo cú pháp: SĐT ĐÃ ĐẶT ĐƠN (hoặc MÃ ĐƠN hoặc
									GMAIL ĐƠN HÀNG) + TÊN NGƯỜI NHẬN sau đó gửi qua các kênh
									online: Page Facebook, Intagram. Nhân viên check tin nhắn sẽ xử
									lý hủy giúp Quý KH.</p>
							</div>
							<div class="btn_container">
								<a class="btn-submit" href="${pageContext.request.contextPath}/cart"> <span
									class="btn_cart-lable">Quay lại giỏ hàng</span> <ion-icon
										name="cart"></ion-icon>
								</a>
								<button class="btn-submit" type="submit">
									<span class="btn_cart-lable">Hoàn tất đơn hàng</span>
								</button>
							</div>
						</form>
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
		<jsp:include page="../../footer/footer.jsp" />
	</div>

	<jsp:include page="../../script.jsp" />
</body>
</html>

