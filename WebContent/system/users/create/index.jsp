<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
request.setCharacterEncoding("utf-8");
String baseUrl = request.getContextPath() + "/system/users/create";
%>

<!doctype html>
<html lang="en">
<head>
<jsp:include page="../../head.jsp" />
<link rel="stylesheet" href="<%=baseUrl%>/index.css" />
<title>Thêm người dùng - Shoplane</title>
</head>
<body>
	<div id="system">
		<div id="sidebar">
			<jsp:include page="../../partials/sidebar/index.jsp" />
		</div>
		<div id="content">
			<div id="header">
				<jsp:include page="../../partials/header/index.jsp" />
			</div>
			<main id="main-content">
				<div class="customer_info">
					<div class="img">
						<img
							src="https://cpad.ask.fm/450/774/576/-29996968-1tfd7tc-gpggmmc5d0og3a0/original/image.jpg"
							alt="" class="">
					</div>
					<button class="change_img">Thay đổi ảnh</button>

					<form action="create" method="POST">
						<input type="text" name="userId" id="userId"
							placeholder="Mã người dùng" class="form-control"> <input
							type="text" name="fullname" id="fullname" placeholder="Họ và tên"
							class="form-control"> <input type="text" name="email"
							id="email" placeholder="Email" class="form-control" /> <input
							type="text" name="phonenumber" id="phonenumber"
							placeholder="Số điện thoại" class="form-control"> <input
							type="text" name="address" id="address" placeholder="Địa chỉ"
							class="form-control" /> <input type="text" name="password"
							id="password" placeholder="Mật khẩu" class="form-control" /> <select
							class="form-control" id="acctiveAcc">
							<option value="-1">-- Lựa chọn trạng thái tài khoản --</option>
							<option value="1">Kích hoạt</option>
							<option value="0">Kích hoạt sau</option>
						</select>
						<select class="form-control" id="roleId">
							<option value="-1">-- Lựa chọn vai trò --</option>
							<c:forEach var="item" items="${roles}">
								<option value="${item.getRoleId()}">${item.getRoleName()}</option>
							</c:forEach>
						</select>
						<button type="submit" class="btn-submit">Lưu</button>
					</form>
				</div>
			</main>
		</div>
	</div>
	<!-- <!-- Jquery -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"
		integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</body>
</html>
