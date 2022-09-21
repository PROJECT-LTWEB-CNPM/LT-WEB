<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="tags" tagdir="/WEB-INF/tags"%>


<head>
<style>
.main {
	padding-top: 6rem;
}

.your__container {
	display: flex;
	align-items: flex-start;
	gap: 2rem;
	padding: 8rem 0;
}

.your__orders, .your__info {
	border: 0.5px solid #ddd;
	border-radius: 0.4rem;
	padding: 1.5rem 1rem;
}

.your__orders {
	flex: 1;
}

.your__info {
	max-width: 40rem;
}

.your__info-heading, .your__order-heading {
	font-size: 1.8rem;
	margin-bottom: 1.5rem;
}

.your__order-table {
	border: 1px solid #ddd;
	padding: 1rem;
	border-radius: 0.4rem;
}

.your__order-table-head {
	border-bottom: 1px solid #ddd;
	padding-bottom: 0.5rem;
	margin-bottom: 1rem;
	font-weight: 700;
}

.your__order-table-head, .your__order-table-item {
	display: flex;
	align-items: center;
	justify-content: space-between;
}

.your__order-table-item>a {
	transition: all linear 0.2s;
}

.your__order-table-item>a:hover {
	color: #5ec9ff;
}

.your__order-table-item:not(:last-child) {
	padding-bottom: 1.2rem;
	border-bottom: 1px solid #ddd;
	margin-bottom: 1.2rem;
}

.your__info-list {
	margin-bottom: 1.5rem;
	display: flex;
	flex-direction: column;
	gap: 0.8rem;
}

.infor-item>span:first-child {
	min-width: 8rem;
	display: inline-block;
	font-weight: 400;
}

.infor-item>span:last-child {
	font-weight: 500;
}

.btn-submit {
	display: flex;
	justify-content: center;
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
}

.btn-submit:not(:last-child) {
	margin-bottom: 1rem;
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

<tags:base title="Tài khoản của bạn - SHOPLANE"
	css="../../assets/css/index.css">
	<jsp:include page="../header.jsp" />
	<main class="main">
		<div class="container">
			<div class="your__container">
				<div class="your__orders">
					<h1 class="your__order-heading">ĐƠN HÀNG CỦA BẠN</h1>
					<div class="your__order-table">
						<div class="your__order-table-head">
							<span class="your__order-title">Mã đơn hàng</span> <span
								class="your__order-title">Ngày đặt</span> <span
								class="your__order-title">Trạng thái thanh toán</span> <span
								class="your__order-title">Trạng thái vận chuyển</span> <span
								class="your__order-title">Tổng tiền</span>
						</div>
						<div class="your__order-table-body">
							<div class="your__order-table-item">
								<a class="your__order-value" href="./my-orders.jsp">354651</a> <span
									class="your__order-value">01/09/2022</span> <span
									class="your__order-value">Chưa hoàn tất</span> <span
									class="your__order-value">Đang vận chuyển</span> <span
									class="your__order-value">203.000đ</span>
							</div>
							<div class="your__order-table-item">
								<a class="your__order-value" href="./my-orders.jsp">354660</a> <span
									class="your__order-value">01/09/2022</span> <span
									class="your__order-value">Chưa hoàn tất</span> <span
									class="your__order-value">Đang vận chuyển</span> <span
									class="your__order-value">203.000đ</span>
							</div>
						</div>
					</div>
				</div>
				<div class="your__info">
					<h1 class="your__info-heading">TÀI KHOẢN CỦA BẠN</h1>
					<div class="your__info-list">
						<div class="infor-item">
							<span>Họ và tên:</span> <span>Đỗ Dương Thái Tuấn</span>
						</div>
						<div class="infor-item">
							<span>Địa chỉ:</span> <span>Thanh Đa, Hà Nội</span>
						</div>
						<div class="infor-item">
							<span>Email:</span> <span>doduongthaituan201102@gmail.com</span>
						</div>
						<div class="infor-item">
							<span>Điện thoại:</span> <span>0123456789</span>
						</div>
					</div>
					<div class="your__info-action">
						<a class="btn-submit" type="submit" name="modify-button"
							href="${pageContext.request.contextPath}/default/account/modify.jsp">Chỉnh
							sửa thông tin</a> <a class="btn-submit"
							href="${pageContext.request.contextPath}/default/account/login.jsp">Đăng
							xuất</a>
					</div>
				</div>
			</div>
		</div>
	</main>
	<jsp:include page="../footer.jsp" />
</tags:base>
