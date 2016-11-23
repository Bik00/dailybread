<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>
		<nav>
			<ul>
				<li><a href="index.do">New</a></li>
				<c:if test="${sessionScope.admin != null }">
				<li><a href="adminLogin.do?command=logout">Logout</a></li>
				</c:if>
			</ul>
		</nav>
	</header>
	<section>
		<c:if test="${cont != null }">
			<jsp:include page="${cont }"></jsp:include>
		</c:if>
	</section>
	<footer>
		<p>Daily Bread Inc. Tel. 053-000-0000, ask@dailybread.com</p>
	</footer>
</body>
</html>