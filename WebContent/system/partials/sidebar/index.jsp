<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("utf-8");
String context = request.getContextPath() + "/system";
%>

<div class="sidebar__container">
	<div class="sidebar__logo">
		<i class="fas fa-bars"></i> <span class="sidebar__logo-name">
			SHOPLANE </span>
	</div>
	<div class="sidebar__nav">
		<a class="sidebar__nav-item" href="<%=context%>/dashboard"><i class="fas fa-chart-line"></i><span>
				Thống kê </span></a> 
		<a href="<%=context %>/users"
			class="sidebar__nav-item"><i class="fas fa-users"></i> <span>
				Người dùng </span></a> 
		<a class="sidebar__nav-item" href="<%=context%>/bills"><i
			class="fas fa-money-bill-wave-alt"></i> <span>Hóa đơn</span></a> 
		<a
			href="<%=context %>/products"
			class="sidebar__nav-item"><i class="fas fa-tshirt"></i> <span>
				Sản phẩm </span></a>
	</div>
</div>
