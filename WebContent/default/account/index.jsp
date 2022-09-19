p<%@ page language="java" contentType="text/html; charset=UTF-8"
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
}

.your-orders, .your-info {
	border: 0.5px solid #ddd;
	border-radius: 0.4rem;
	padding: 1.5rem 1rem;
}

.main-section {
	padding: 0 10%;
	margin: 10% 0;
	font-size: 0.8125rem;
}

.order-head, .info-head {
	font-size: 1.25rem;
	font-weight: 700;
}

.your-orders, .personal-information {
	padding: 10px;
}

.th-title {
	font-weight: normal;
}

.td-value {
	font-style: italic;
}

.table-item {
	margin-bottom: 0;
}

@media ( max-width : 990px) {
	.personal-information {
		margin: 50px;
	}
}

/* Personal Information Section */
.infor-item {
	margin: 5px 0 5px;
}

.infor-button {
	margin: 5px 0 5px;
}

.btn-submit {
	display: block;
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

<tags:base title="Tài khoản của bạn - SHOPLANE"
	css="../../assets/css/index.css">
	<jsp:include page="../header.jsp" />
	<main class="main">
		<div class="container">
			<div class="your__container">
				<div class="your-orders">
					<h1 class="order-head">ĐƠN HÀNG CỦA BẠN</h1>
					<div class="border border-1 rounded your-order-unit">
						<table class="table table-borderless table-item">
							<thead>
								<tr>
									<th class="th-title">Mã đơn hàng</th>
									<th class="th-title">Ngày đặt</th>
									<th class="th-title">Trạng thái thanh toán</th>
									<th class="th-title">Trạng thái vận chuyển</th>
									<th class="th-title">Tổng tiền</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td class="td-value">354651</td>
									<td class="td-value">01/09/2022</td>
									<td class="td-value">Chưa hoàn tất</td>
									<td class="td-value">Đang vận chuyển</td>
									<td class="td-value">203.000đ</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>

				<div class="your-info">
					<div class="card container-pluid personal-information">
						<h1 class="info-head">TÀI KHOẢN CỦA BẠN</h1>
						<table class="table table-borderless">
							<tr class="infor-item">
								<th>Họ tên:</th>
								<td>Đỗ Dương Thái Tuấn</td>
							</tr>

							<tr class="infor-item">
								<th>Email:</th>
								<td>dtb1742002@email.com</td>
							</tr>
							<tr class="infor-item">
								<th>Địa chỉ:</th>
								<td>Thanh Xuân - Hà Nội</td>
							</tr>
							<tr class="infor-item">
								<th>Điện thoại</th>
								<td>0123456789</td>
							</tr>
						</table>
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
