<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>


<div>
	<h1>Hello Test</h1>
	<form action="SizeController" method="POST">
		<div class="group">
			<label for="sizeId">Size id:</label> <input tabindex="-1" type="text"
				placeholder="Size id..." id="sizeId" name="sizeId" />
		</div>

		<div class="group">
			<label for="sizeName">Size name:</label> <input tabindex="-1"
				type="text" placeholder="Size name..." id="sizeName" name="sizeName" />
		</div>
		<button type="submit">Add Size</button>
	</form>
</div>