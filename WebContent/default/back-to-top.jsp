<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<head>
<style>
.back-to-top {
	display: flex;
	align-items: center;
	justify-content: center;
	background-color: #5ec9ff;
	color: #fff;
	position: fixed;
	bottom: 2rem;
	right: 1rem;
	z-index: 99;
	padding: 1rem 1.2rem;
	border-radius: 0.4rem;
	visibility: hidden;
	opacity: 0;
	cursor: pointer;
	transition: all linear 0.2s;
	transform: translateY(calc(2rem + 100%));
}

.back-to-top:hover {
	background-color: #4c97bd;
}

.back-to-top.visible {
	visibility: visible;
	opacity: 1;
	transform: translateY(0);
}
</style>
</head>

<div class="back-to-top">
	<i class="fas fa-chevron-up"></i>
</div>

<script>
	const backToTopRef = document.querySelector(".back-to-top");
	const headerheight = 80;
	document.addEventListener('scroll', () => {
		if(document.body.scrollTop > headerheight ||
			      document.documentElement.scrollTop > headerheight) {
			backToTopRef.classList.add("visible");
		} else {
			backToTopRef.classList.remove("visible");
		}
	})
	console.log({backToTopRef})
	backToTopRef.addEventListener('click', () => {
		window.scrollTo({top: 0, behavior: 'smooth'});
	})
</script>