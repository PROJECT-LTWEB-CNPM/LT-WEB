<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="tags" tagdir="/WEB-INF/tags"%>


<head>
<title>Dashboard</title>
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
			<main>
		
			</main>
		</div>
	</div>
</tags:base>
