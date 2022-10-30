<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("utf-8");
String baseUrl = request.getContextPath() + "/system/users";
%>

<!doctype html>
<html lang="en">
<head>
<jsp:include page="../head.jsp" />
<link rel="stylesheet" href="<%=baseUrl%>/index.css" />
<title>Quản lý người dùng - Shoplane</title>
</head>
<body onload="loadUserData(this)">
	<div id="app">
		<div id="sidebar">
			<jsp:include page="../partials/sidebar/index.jsp" />
		</div>
		<div id="content">
			<div id="header">
				<jsp:include page="../partials/header/index.jsp" />
			</div>
			<main id="main-content">
				<div class="actions">
					<a href="<%=baseUrl%>/form/index.jsp?edit=add">Thêm bản ghi</a> <a href="#">Xóa
						bản ghi</a>
				</div>
				<div class="table">
					<div class="table__head">
						<div style="width: 5%">
							<input type="checkbox">
						</div>
						<div style="width: 10%">ID</div>
						<div style="width: 25%">Họ và tên</div>
						<div style="width: 25%">Email</div>
						<div style="width: 15%">Loại người dùng</div>
						<div style="width: 15%">Ngày tạo</div>
						<div style="width: 10%"></div>
					</div>
					<div class="table__body" id="data-users">
					
					</div>
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
	function loadUserData() {
		$.ajax({
			  url: "http://localhost:8080/shoplane-ft/system/users/",
			  type: "get",
			  data: {
				  pageType : "user/index.jsp"
			  },
			  success: function(response) {
				//var dataUser = document.querySelector('#data-users')
				//dataUser.innerHTML = response
				
				$('#data-users').html(response);
			  },
			  error: function(xhr) {
				  alert('ERROR')
			  }
			});
	}
	</script>
</body>
</html>

