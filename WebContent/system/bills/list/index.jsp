<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
request.setCharacterEncoding("utf-8");
String context = request.getContextPath();
%>

<!doctype html>
<html lang="en">
<head>
<jsp:include page="../../head.jsp" />
<title>Quản lý đơn hàng - Shoplane</title>
<link rel="stylesheet" href="<%=context%>/system/bills/list/index.css"
	type="text/css">
</head>
<body>
	<div id="app">
		<div id="sidebar">
			<jsp:include page="../../partials/sidebar/index.jsp" />
		</div>
		<div id="content">
			<div id="header">
				<jsp:include page="../../partials/header/index.jsp" />
			</div>
			<main id="main-content">
				<div class="actions">
					<a href="./form.jsp?type=add">Thêm bản ghi</a> <a href="#!"
						onclick="event.preventDefault();document.getElementById('selectedBill').submit();">Xóa
						bản ghi</a>
				</div>
				<div class="table">
					<div class="table__head">
						<div style="width: 5%"></div>
						<div style="width: 10%">ID</div>
						<div style="width: 25%">Ngày đặt</div>
						<div style="width: 25%">Trạng thái thanh toán</div>
						<div style="width: 15%">Mã khách hàng</div>
						<div style="width: 15%">Tổng tiền</div>
						<div style="width: 10%"></div>
					</div>
					<div class="table__body">
						<c:forEach var="b" items="${bills}">
							<div class="table__row">
								<div style="width: 5%">
									<input type="checkbox" name="selectedBills" value="${b.billId}">
								</div>
								<div style="width: 10%">${b.billId}</div>
								<div style="width: 25%">${b.date}</div>
								<div style="width: 25%">
									<c:choose>
										<c:when test="${b.statusBill==0}">
        								Chưa thanh toán
        							</c:when>
										<c:otherwise>
        								Đã thanh toán
        							</c:otherwise>
									</c:choose>
								</div>
								<div style="width: 15%">${b.user.userId}</div>
								<div style="width: 15%">${b.totalPrice}</div>
								<div style="width: 10%" class="table__link">
									<a href="<%=context %>/system/bills/detail?id=${b.billId}">Xem chi tiết</a>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</main>
		</div>
	</div>
</body>
</html>
