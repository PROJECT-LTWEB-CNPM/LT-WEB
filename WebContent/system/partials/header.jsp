<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<head>
<style>
.header__container {
	height: inherit;
	padding-right: 2rem;
	display: flex;
	justify-content: flex-end;
	align-items: center;
	gap: 2rem;
	position: fixed;
	right: 0;
	left: 25rem;
	z-index: 2;
	background-color: #fff;
	box-shadow: 10px 0px 9px 3px rgb(41 41 41/ 10%);
}

.header__userinfo {
	display: flex;
	align-items: center;
	gap: 1rem;
}

.header__userinfo-img {
	width: 4rem;
	height: 4rem;
	border-radius: 100px;
	border: 1px solid #d2d2d2;
}

.header__logout ion-icon {
	font-size: 2.5rem;
	cursor: pointer;
}
</style>

</head>

<div class="header__container">
	<div class="header__userinfo">
		<img
			src="https://cpad.ask.fm/450/774/576/-29996968-1tfd7tc-gpggmmc5d0og3a0/original/image.jpg"
			alt="" class="header__userinfo-img"> <span
			class="header__userinfo-username">Tuan Do</span>
	</div>
	<div class="header__logout">
		<ion-icon name="log-out-outline"></ion-icon>
	</div>
</div>