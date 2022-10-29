<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="services.ProductService"%>

<%
request.setCharacterEncoding("utf-8");
%>

<!doctype html>
<html lang="en">
<head>
<jsp:include page="../head.jsp" />
<title>Quản lý đơn hàng - Shoplane</title>
</head>
<body>
	<div id="app">
		<div id="sidebar">
			<jsp:include page="../partials/sidebar/index.jsp" />
		</div>
		<div id="content">
			<div id="header">
				<jsp:include page="../partials/header/index.jsp" />
			</div>
			<main></main>
		</div>
	</div>
	<!-- Jquery -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"
		integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</body>
</html>
