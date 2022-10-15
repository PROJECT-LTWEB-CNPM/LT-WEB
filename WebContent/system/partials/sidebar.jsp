<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<head>
<style>
.sidebar__container {
	width: inherit;
	position: fixed;
	top: 0;
	left: 0;
	bottom: 0;
	z-index: 10;
	background-color: #fff;
	box-shadow: 1px 0px 9px 3px rgb(41 41 41/ 10%);
	bottom: 0;
	left: 0;
	top: 0;
}

.sidebar__logo {
	height: 6rem;
	padding: 0 1rem;
	display: flex;
	align-items: center;
	gap: 1rem;
	display: flex;
	color: #5ec9ff;
	box-shadow: 0px 0px 9px 3px rgb(41 41 41/ 10%);
}

.sidebar__logo>svg {
	font-size: 2.4rem;
}

.sidebar__logo>.sidebar__logo-name {
	font-size: 2rem;
	font-weight: 700;
}

.sidebar__nav {
	list-style: none;
	font-size: 2rem;
	font-weight: 600;
}

.sidebar__nav-item {
	display: flex;
	align-items: center;
	gap: 1rem;
	border-bottom: 0.5px solid #f2f2f2;
	padding: 1rem;
	transition: all 0.2s linear;
	cursor: pointer;
}

.sidebar__nav-item:hover {
	color: #5ec9ff;
	border-color: #5ec9ff;
	padding-left: 1.5rem;
}

.sidebar__nav-item>svg {
	font-size: 2rem;
}

.sidebar__nav-item span {
	font-size: 1.6rem;
}
</style>
</head>


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