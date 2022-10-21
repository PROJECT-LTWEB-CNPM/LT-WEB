<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
request.setCharacterEncoding("utf-8");
String baseUrl = request.getContextPath() + "/default/home";
%>

<!doctype html>
<html lang="en">
<head>
<jsp:include page="../head.jsp" />
<link rel="stylesheet" href="<%=baseUrl%>/slider/index.css" />
<link rel="stylesheet" href="<%=baseUrl%>/default-section/index.css" />
<title>Cửa hàng quần áo - SHOPLANE</title>
<style>
.main {
	padding-top: 6rem;
}
</style>
</head>
<body>
	<div id="app">
		<jsp:include page="../header/header.jsp" />
		<main class="main">
			<!-- Slider section -->
			<jsp:include page="./slider/index.jsp" />
			<!-- Shirt section-->
			<jsp:include page="./shirt-catalog/index.jsp" />
			<!-- Short section-->
			<jsp:include page="./short-catalog/index.jsp" />
		</main>
		<jsp:include page="../footer/footer.jsp" />
		<jsp:include page="../back-to-top/back-to-top.jsp" />
	</div>

	<!-- Jquery -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"
		integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>

	<!-- Swipper Slider -->
	<script
		src="https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.min.js"></script>
	<script type="text/javascript" src="<%=baseUrl%>/index.js"></script>

</body>
</html>

