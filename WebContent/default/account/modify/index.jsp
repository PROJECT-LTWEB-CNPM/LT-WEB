<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("utf-8");
String context = request.getContextPath() + "/default/account/modify";
%>

<!doctype html>
<html lang="en">
<head>
<jsp:include page="../../head.jsp" />
<link rel="stylesheet" href="<%=context%>/index.css" />
<title>Thay đổi thông tin - Shoplane</title>
</head>
<body>
	<div id="app">
		<jsp:include page="../../header/header.jsp" />
		<main class="main">
			<div class="container">
				<section id="modify">
					<div class="modify-form">
						<form action="modify" method="POST">
							<h1 class="modify-header">ĐIỀU CHỈNH THÔNG TIN</h1>
							<input class="form-control" type="text" name="fullname"
								placeholder="Họ và tên"> <input class="form-control"
								type="text" name="phonenumber" placeholder="Số điện thoại" /> <input
								class="form-control" type="text" name="address"
								placeholder="Địa chỉ">
							<button class="btn-submit" type="submit" name="modifyButton">Cập
								nhật</button>
						</form>
					</div>
				</section>
			</div>
		</main>
		<jsp:include page="../../footer/footer.jsp" />
	</div>
	<jsp:include page="../../script.jsp" />
</body>
</html>