<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
request.setCharacterEncoding("utf-8");
String context = request.getContextPath();
String baseUrl = context + "/system/users/list";
%>

<!doctype html>
<html lang="en">
<head>
<jsp:include page="../../head.jsp" />
<link rel="stylesheet" href="<%=baseUrl%>/index.css" />
<link rel="stylesheet" href="<%=baseUrl%>/pagination/pagination.css" />
<title>Quản lý người dùng - Shoplane</title>
</head>
<body>
	<div id="app">
		<div id="sidebar">
			<jsp:include page="../../partials/sidebar/index.jsp" />
		</div>
		<div id="content">
			<div id="header">
				<jsp:include page="../../partials/header/index.jsp" />
			</div>
			<main id="main-content">
				<div class="actions">
					<div class="action__select">
						Loại người dùng <select id="select__type"
							onchange="javascript:handleSelectRole(this)">
							<c:forEach var="item" items="${roles}">
								<c:choose>
									<c:when test="${item.getRoleId().equals(roleId)}">
										<option value="${item.getRoleId()}" selected>${item.getRoleName()}</option>
									</c:when>
									<c:otherwise>
										<option value="${item.getRoleId()}">${item.getRoleName()}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</div>
					<div class="action__select">
						Xem <select style="width: 5rem" id="select__entries"
							onchange="javascript:handleSelectEntries(this)">
							<c:forEach end="3" begin="1" var="item">
								<c:choose>
									<c:when test="${(item * 10) == pageSize}">
										<option value="${item * 10}" selected>${item * 10}</option>
									</c:when>
									<c:otherwise>
										<option value="${item * 10}">${item * 10}</option>
									</c:otherwise>
								</c:choose>

							</c:forEach>
						</select> sản phẩm
					</div>
					<a href="<%=context%>/system/users/create">Thêm người dùng</a> <a
						onclick="deleteUser(this)"> Xóa người dùng</a>
				</div>
				<div class="table">
					<div class="table__head">
						<div style="width: 5%">
							<input type="checkbox" class="all">
						</div>
						<div style="width: 10%">Mã người dùng</div>
						<div style="width: 25%">Họ và tên</div>
						<div style="width: 25%">Email</div>
						<div style="width: 15%">Loại người dùng</div>
						<div style="width: 15%">Ngày tạo</div>
						<div style="width: 10%"></div>
					</div>
					<div class="table__body" id="data-users">
						<c:forEach var="item" items="${users}">
							<div class="table__row">
								<div style="width: 5%">
									<input type="checkbox" value="${item.getUserId()}" />
								</div>
								<div style="width: 10%">${item.getUserId()}</div>
								<div style="width: 25%">${item.getFullname()}</div>
								<div style="width: 25%">${item.getEmail()}</div>
								<div style="width: 15%">${item.getRole().getRoleName()}</div>
								<div style="width: 15%">Ngày tạo</div>
								<div style="width: 10%">
									<a href="./edit?user_id=${item.getUserId()}">Xem chi tiết</a>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
				<jsp:include page="./pagination/pagination.jsp"></jsp:include>
			</main>
		</div>
	</div>
	<!-- Jquery -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"
		integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>

	<script type="text/javascript">
		// Toggle check all
		let selectedItems = [];
		const inputAll = $('.all');
		const inputItems = [...$('input[type=checkbox]')].slice(1);
/* 		inputAll.on('click', () => {
			if(inputAll.is(':checked')))	 {
					
			}
		})
 */			inputItems.forEach(item => {
				item.addEventListener("click", e => {
					const isChecked = e.target.checked;
					if(isChecked) {
						selectedItems.push(e.target.value);
						if(selectedItems.length === inputItems.length) {
							$('.all').prop('checked', true);
						}
					} else {
						selectedItems = selectedItems.filter(item => item !== e.target.value);
						$('.all').prop('checked', false);
					}
				})
		    });
			
		
		function deleteUser() {
			$.ajax({
				url : "http://localhost:8080/shoplane-ft/system/users/delete",
				type : "POST",
				data : {
					data: selectedItems.join(',')
				},
				success : function(response) {
					alert('successfull')
/* 					window.location.reload()
 */				},
				error : function(xhr) {
					alert('error')
				}
			});
		}
		function handleSelectRole(elm) {
			const queryString = window.location.search;
			const urlParams = new URLSearchParams(queryString);

			const pageSize = urlParams.get('page_size');

			window.location = '?role_id=' + elm.value + '&current_page=1&page_size=' + pageSize;

		}
		function handleSelectEntries(elm) {
			const queryString = window.location.search;
			const urlParams = new URLSearchParams(queryString);

			const roleId = urlParams.get('role_id');

			window.location = '?eole_id=' + roleId + '&current_page=1&page_size=' + elm.value;
		}
	</script>
</body>
</html>

