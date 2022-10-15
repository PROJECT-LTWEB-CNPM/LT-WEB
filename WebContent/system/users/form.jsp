<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="tags" tagdir="/WEB-INF/tags"%>


<head>
<title>Users Manage</title>
<link rel="stylesheet" href="../../assets/css/index.css" type="text/css" />

<style>
#admin {
	display: flex;
}

#sidebar {
	width: 25rem;
}

#content {
	width: calc(100% - 25rem);
}

#header {
	height: 6rem;
}

#main-content {
	padding: 3rem 2rem 10rem 1rem;
}

/*  Customer info*/
.customer_info {
	text-align: center;
	width: 1000px;
	margin: 0 auto;
	padding-bottom: 36px;
}

.img img {
	width: 200px;
	border-radius: 50%;
}

.change_img, .save_change {
	padding: 0.5rem 1rem;
	border-radius: 4px;
	border: 1px solid #000;
	font-size: 1.6rem;
	margin-top: 16px;
	cursor: pointer;
}

.customer_info-item {
	display: flex;
	flex-direction: row;
	justify-content: space-between;
	margin-top: 20px;
}

.customer_info-item label {
	min-width: 120px;
	text-align: start;
	font-size: 1.8rem;
	font-weight: 500;
	color: var(- -text-color);
	margin-right: 40px;
}

.customer_info-item input {
	flex: 1;
	width: 50%;
	height: 36px;
	outline: none;
	border: 1px solid #B3B3B3;
	border-radius: 10px;
	padding-left: 10px;
	font-size: 1.6rem;
}
</style>
</head>

<tags:base>
	<div id="admin">
		<div id="sidebar">
			<jsp:include page="../partials/sidebar.jsp" />
		</div>
		<div id="content">
			<div id="header">
				<jsp:include page="../partials/header.jsp" />
			</div>
			<main id="main-content">
				<div class="customer_info">
					<div class="img">
						<img
							src="https://cpad.ask.fm/450/774/576/-29996968-1tfd7tc-gpggmmc5d0og3a0/original/image.jpg"
							alt="" class="">
					</div>
					<button class="change_img">Thay đổi ảnh</button>
					<div class="customer_info-item">
						<label for="productName">Họ và tên: </label> <input type="text"
							name="productName" id="productName"
							placeholder="Áo phông form rộng">
					</div>
					<div class="customer_info-item">
						<label for="productName">Số điện thoại: </label> <input type="text"
							name="productName" id="productName" placeholder="url....">
					</div>
					<div class="customer_info-item">
						<label for="productName">Địa chỉ: </label> <input type="text"
							name="productName" id="productName" placeholder="350,000">
					</div>
					<div class="customer_info-item">
						<label for="productName">Email: </label> <input type="text"
							name="productName" id="productName" placeholder="69,000">
					</div>
					<div class="customer_info-item">
						<label for="productName">Mật khẩu: </label> <input type="text"
							name="productName" id="productName"
							placeholder="doduongthaituan201102@gmail.com">
					</div>
					<button class="save_change">Lưu</button>
				</div>
			</main>
		</div>
	</div>
</tags:base>
