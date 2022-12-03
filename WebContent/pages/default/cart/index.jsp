<%@page import="com.shoplane.utils.Constants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
request.setCharacterEncoding(Constants.UTF8);
response.setCharacterEncoding(Constants.UTF8);
String context = request.getContextPath();
%>

<!doctype html>
<html lang="en">
<head>
<jsp:include page="../components/head.jsp" />
<c:choose>
	<c:when test="${orders.size() > 0}">
		<link rel="stylesheet" href="<%=context%>/assets/css/default/cart/cart.css" />
	</c:when>
	<c:otherwise>
		<link rel="stylesheet"
			href="<%=context%>/assets/css/default/cart/cartEmptyOrder.css" />
	</c:otherwise>
</c:choose>
<title>Giỏ hàng của bạn - SHOPLANE</title>
</head>
<body>
	<div id="app">
		<jsp:include page="../components/header.jsp" />
		<main class="main">
			<div class="container">
				<c:choose>
					<c:when test="${orders.size() > 0}">
						<jsp:include page="./cartListOrder.jsp" />
					</c:when>
					<c:otherwise>
						<jsp:include page="./cartEmptyOrder.jsp" />
					</c:otherwise>
				</c:choose>
			</div>
		</main>
		<jsp:include page="../components/footer.jsp" />
		<jsp:include page="../components/backToTop.jsp" />
	</div>
	<jsp:include page="../components/script.jsp" />
</body>
</html>

