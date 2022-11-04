p<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("utf-8");
String baseUrl = request.getContextPath() + "/system/users/form";
%>

<!doctype html>
<html lang="en">
<head>
<jsp:include page="../../head.jsp" />
<link rel="stylesheet" href="<%=baseUrl%>/index.css" />
<title>Products Manage</title>
</head>
<body onload="loadUserDataToForm(this)">
	<div id="system">
		<div id="sidebar">
			<jsp:include page="../../partials/sidebar/index.jsp" />
		</div>
		<div id="content">
			<div id="header">
				<jsp:include page="../../partials/header/index.jsp" />
			</div>
			<main id="main-content">
				<div class="customer_info">
					<div class="img">
						<img
							src="https://cpad.ask.fm/450/774/576/-29996968-1tfd7tc-gpggmmc5d0og3a0/original/image.jpg"
							alt="" class="">
					</div>
					<button class="change_img">Thay đổi ảnh</button>
					
					<div id="form_userData"></div>
				</div>
			</main>
		</div>
	</div>
	<!-- Jquery -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"
		integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script type="text/javascript">
		function loadUserDataToForm() {
			const queryString = window.location.search
			const urlParams = new URLSearchParams(queryString)
			var userNeedToEdit = urlParams.get("edit");
			$.ajax({
				url : "http://localhost:8080/shoplane-ft/system/users/",
				type : "get", //send it through get method
				data : {
					pageType : "user/form/index.jsp",
					userNeedToEdit : userNeedToEdit
				},
				success : function(response) {
					$('#form_userData').html(response);
				},
				error : function(xhr) {
					alert('ERROR')
				}
			});
		}
	</script>
</body>
</html>
