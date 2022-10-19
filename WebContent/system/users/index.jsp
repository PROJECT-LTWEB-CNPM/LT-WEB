<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("utf-8");
String baseUrl = request.getContextPath() + "/system/users";
%>

<!doctype html>
<html lang="en">
<head>
<jsp:include page="../head.jsp" />
<link rel="stylesheet" href="<%=baseUrl%>/index.css" />
<title>Users Manage</title>
</head>
<body>
	<div id="system">
		<div id="sidebar">
			<jsp:include page="../partials/sidebar/index.jsp" />
		</div>
		<div id="content">
			<div id="header">
				<jsp:include page="../partials/header/index.jsp" />
			</div>
			<main id="main-content">
				<div class="actions">
					<a href="./form.jsp?type=add">Thêm bản ghi</a> <a href="#">Xóa
						bản ghi</a>
				</div>
				<div class="table">
					<div class="table__head">
						<div style="width: 5%">
							<input type="checkbox">
						</div>
						<div style="width: 10%">ID</div>
						<div style="width: 25%">Họ và tên</div>
						<div style="width: 25%">Email</div>
						<div style="width: 15%">Loại người dùng</div>
						<div style="width: 15%">Ngày tạo</div>
						<div style="width: 10%"></div>
					</div>
					<div class="table__body">
						<div class="table__row">
							<div style="width: 5%">
								<input type="checkbox">
							</div>
							<div style="width: 10%">1234</div>
							<div style="width: 25%">Do Duong Thai Tuan</div>
							<div style="width: 25%">doduongthaituan@gmail.com</div>
							<div style="width: 15%">admin</div>
							<div style="width: 15%">20/11/2016</div>
							<div style="width: 10%" class="table__link">
								<a href="./form.jsp?type=edit">Xem chi tiết</a>
							</div>
						</div>
					</div>
				</div>
			</main>
		</div>
	</div>
	<!-- Jquery -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"
		integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</body>
</html>

