<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="tags" tagdir="/WEB-INF/tags"%>


<head>
<title>Dashboard</title>

<link rel="stylesheet" href="../../assets/css/index.css" type="text/css" />
</head>
<tags:base>
	<jsp:include page="../header.jsp" />
	<jsp:include page="../sidebar.jsp" />
	<main>
		<h1>Content</h1>
		<a href="${pageContext.request.contextPath}/">Go to Home</a>
	</main>
</tags:base>
