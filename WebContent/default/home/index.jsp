<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="tags" tagdir="/WEB-INF/tags"%>


<head>

<style>
.main {
	padding-top: 6rem;
}
</style>
</head>

<%
request.setCharacterEncoding("utf-8");
%>

<tags:base title="Cửa hàng quần áo - SHOPLANE" css="./assets/css/index.css">
	<jsp:include page="../header.jsp" />
	<main class="main">
		<!-- Slider section -->
		<jsp:include page="./slider/index.jsp" />

		<!-- <jsp:include page="./test/index.jsp" /> -->
		
		<!-- Shirt section-->
		<jsp:include page="./shirt-catalog/index.jsp" />
		<!-- Short section-->
		<jsp:include page="./short-catalog/index.jsp" />
	</main>
	<jsp:include page="../footer.jsp" />
	<jsp:include page="../back-to-top.jsp" />
</tags:base>