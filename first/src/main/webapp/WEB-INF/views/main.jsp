<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
<script type="text/javascript">
	function openChat() {
		var randomStr = Math.random().toString(36).substring(2, 12);
		location.href="/chat?bang_id="+randomStr;
	}
</script>
</head>
<body>
	<h1>${id }, 왔나~ 자리해라</h1>
	<input type="button" onclick="openChat()" value="채팅하기">
</body>
</html>