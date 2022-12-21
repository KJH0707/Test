<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	임시 로그인
</h1>

<form action='login' method="post">
	id : <input type="text" name="id"><br>
	pw : <input type="text" name="pw">
	<input type="submit" value="로그인">
</form>
</body>
</html>
