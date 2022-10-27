<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("utf-8");
String context = request.getContextPath();
String url = context + "/default/account/register";
%>

<!doctype html>
<html lang="en">
<head>
<jsp:include page="../../head.jsp" />
<link rel="stylesheet" href="<%=url%>/index.css" />
<title>Đăng ký tài khoản - Shoplane</title>
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
				<section id="register">
					<div class="border border-1 rounded register-form">

						<form action="register" method="POST">
							<h1 class="register-header">ĐĂNG KÝ</h1>
							<input class="form-control" type="text" name="fullName"
								placeholder="Họ và tên" required /> 
							<input
								class="form-control" type="text" name="phonenumber"
								placeholder="Số điện thoại" required /> 
							<input
								class="form-control" type="text" name="address"
								placeholder="Địa chỉ" required /> 
							<input
								class="form-control" type="email" name="email"
								placeholder="Email" /> 
							<input class="form-control"
								type="password" name="password" placeholder="Password">

							<button class="btn-submit" type="submit" name="registerButton">Đăng
								ký</button>

							<div class="have-account">
								<p>
									Đã có tài khoản?<a class="signin-text"
										href="<%=context%>/login"> Đăng nhập</a>
								</p>
							</div>

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