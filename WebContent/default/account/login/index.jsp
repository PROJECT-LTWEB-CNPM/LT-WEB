<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("utf-8");
String context = request.getContextPath() + "/default/account/login";
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
				<section id="login">
					<div class="border border-1 rounded login-form">
						<form action="login" method="POST">
							<h1 class="login-header">ĐĂNG NHẬP</h1>
							<input type="text" hidden name="caller" value="${caller}" /> <input
								class="form-control" type="email" name="email"
								placeholder="Email" required> <input
								class="form-control" type="password" name="password"
								placeholder="Mật khẩu" required>

							<button class="btn-submit" type="submit">Đăng nhập</button>
							<div class="no-account">
								<p>
									Không có tài khoản?<a class="register-text"
										href="../register/index.jsp"> Đăng ký</a>
								</p>
							</div>
						</form>
					</div>
				</section>
			</div>
		</main>
		<jsp:include page="../../footer/footer.jsp" />
	</div>

	<!-- Jquery -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"
		integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>

	<!-- Swipper Slider -->
	<script
		src="https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.min.js"></script>
</body>
</html>