<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="sidebar__container">
	<div class="sidebar__logo">
		<i class="fas fa-bars"></i> <span class="sidebar__logo-name">
			SHOPLANE </span>
	</div>
	<div class="sidebar__nav">
		<a class="sidebar__nav-item"><i class="fas fa-chart-line"></i><span>
				Dashboard </span></a> <a
			href="${pageContext.request.contextPath}/system/users/index.jsp"
			class="sidebar__nav-item"><i class="fas fa-users"></i> <span>
				Users </span></a> <a class="sidebar__nav-item"><i
			class="fas fa-money-bill-wave-alt"></i> <span> Bills </span></a> <a
			href="${pageContext.request.contextPath}/system/products/index.jsp"
			class="sidebar__nav-item"><i class="fas fa-tshirt"></i> <span>
				Products </span></a>
	</div>
</div>
