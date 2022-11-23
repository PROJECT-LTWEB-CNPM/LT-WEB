<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
request.setCharacterEncoding("utf-8");
String context = request.getContextPath();
String baseUrl = request.getContextPath() + "/default/home";
%>



<!doctype html>
<html lang="en">
<head>
<jsp:include page="../head.jsp" />
<link rel="stylesheet" href="<%=baseUrl%>/slider/index.css"
	type="text/css" />
<link rel="stylesheet" href="<%=baseUrl%>/default-section/index.css" />
<title>Cửa hàng quần áo - Shoplane</title>
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
	<!-- Swipper Slider -->
	<script
		src="https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.min.js"></script>
	<jsp:include page="../script.jsp" />
	<script type="text/javascript" src="<%=baseUrl%>/index.js"></script>
</body>
</html>
