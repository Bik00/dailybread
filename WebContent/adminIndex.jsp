<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${sessionScope.admin == null }">
<jsp:forward page = "adminLogin.do"/>
</c:if>
	
	<form action = "newBread.do" method="post" enctype="multipart/form-data">
		<ul>
			<li>Bread Name<input type="text" name="breadName"></li>
			<li>Image<input type="file" name="imageFile"></li>
			<li>Ingredient<input type="file" name="Ingredient"></li>
			<li>Price<input type="text" name="Price"></li>
			<li>Create Count<input type="text" name="createdCount"></li>
		</ul>
		<input type="submit" value="Add">
	</form> 
	<p>${result }</p>
</body>
</html>