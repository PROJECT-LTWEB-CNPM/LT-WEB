<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
request.setCharacterEncoding("utf-8");
String context = request.getContextPath();
%>

<!doctype html>
<html lang="en">
<head>
<jsp:include page="../head.jsp" />
<c:choose>
	<c:when test="${orders.size() > 0}">
		<link rel="stylesheet" href="<%=context%>/default/cart/index.css" />
	</c:when>
	<c:otherwise>
		<link rel="stylesheet"
			href="<%=context%>/default/cart/cart-empty/index.css" />
	</c:otherwise>
</c:choose>
<title>Giỏ hàng của bạn - Shoplane</title>
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
			<div class="container">
				<c:choose>
					<c:when test="${orders.size() > 0}">
						<jsp:include page="./cart-list/index.jsp" />
					</c:when>
					<c:otherwise>
						<jsp:include page="./cart-empty/index.jsp" />
					</c:otherwise>
				</c:choose>
			</div>
		</main>
		<jsp:include page="../footer/footer.jsp" />
		<jsp:include page="../back-to-top/back-to-top.jsp" />

	</div>
	<jsp:include page="../script.jsp" />
</body>
</html>

