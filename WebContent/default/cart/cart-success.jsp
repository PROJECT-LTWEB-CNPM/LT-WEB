<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="tags" tagdir="/WEB-INF/tags"%>


<head>
<style>
.main {
	padding-top: 6rem;
}

.content-nav {
	display: flex;
	flex-direction: row;
	justify-content: center;
	align-items: flex-start;
	padding: 80px 0px;
	width: 1728px;
	height: 414px;
	background: #FFFFFF;
	box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
}

.content {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	padding: 0px;
	gap: 20px;
	width: 1200px;
	height: 254px;
}

.content-inner ion-icon {
	width: 87.5px;
	height: 100px;
}

.notification {
	display: flex;
	flex-direction: column;
	align-items: center;
	padding: 0px 0px 0px 40px;
	width: 512px;
	height: 64px;
}

h3 {
	display: flex;
	width: 249px;
	height: 32px;
	font-family: 'Inter';
	font-style: normal;
	font-weight: 700;
	font-size: 18px;
	line-height: 32px;
	color: rgba(0, 0, 0, 0.6);
}

h4 {
	padding: 0px 20px 0px 0px;
	width: 412px;
	height: 32px;
	font-family: 'Inter';
	font-style: normal;
	font-weight: 700;
	font-size: 13px;
	line-height: 32px;
	color: rgba(0, 0, 0, 0.6);
}

.btn_container {
	display: flex;
	flex-direction: row;
	align-items: center;
	padding: 0px 0px 0px 60px;
	justify-content: space-between;
	width: 90%;
	margin: 32px 0;
}

.btn_cart {
	display: flex;
	flex-direction: row;
	align-items: center;
	justify-content: center;
	min-width: 200px;
	height: 42px;
	border: 1px solid #000;
	border-radius: 10px;
	background-color: #fff;
	color: var(- -text);
	cursor: pointer;
}

.btn_cart-lable {
	display: flex;
	justify-content: center;
	font-size: 1.6rem;
}

.btn_cart ion-icon {
	font-size: 2.2rem;
	padding: 0px 0px 0px 0px;
	vertical-align: middle;
}
</style>
</head>

<%
request.setCharacterEncoding("utf-8");
%>

<div class="content-nav">
	<div class="content">
		<div class="content-inner">
			<ion-icon name="bag-check"></ion-icon>
		</div>
		<div class="content-notice">
			<div class="notification">
				<h3>ĐẶT HÀNG THÀNH CÔNG</h3>
				<h4>VUI LÒNG KIỂM TRA EMAIL ĐỂ XEM CHI TIẾT ĐƠN HÀNG</h4>
				<div class="btn_container">
					<button class="btn_cart">
						<h3 class="btn_cart-lable">TIẾP TỤC MUA HÀNG</h3>
						<ion-icon name="cart"></ion-icon>
					</button>
				</div>
			</div>
		</div>
	</div>
</div>