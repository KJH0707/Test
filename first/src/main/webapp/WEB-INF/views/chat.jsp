<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.2/jquery.min.js"></script>
<script type="text/javascript">

$(document).ready(function(){
//전송 버튼 누르는 이벤트
	$("#button-send").on("click", function(e) {
		sendMessage();
		$('#msg').val('');
	});
});
	var sock = new SockJS('http://localhost:8080/chatting');
	sock.onmessage = onMessage;
	
	function sendMessage() {
		sock.send($("#msg").val());
	}
	//서버에서 메시지를 받았을 때
	function onMessage(msg) {
		
		var data = msg.data;
		var sessionId = null; //데이터를 보낸 사람
		var message = null;
		
		var cur_session = '${id}'; //현재 세션에 로그인 한 사람
		console.log("cur_session : " + cur_session);
		
	    //로그인 한 클라이언트와 타 클라이언트를 분류하기 위함
		if(sessionId == cur_session){
			
			var str = "<div class='col-6'>";
			str += "<div class='alert alert-secondary'>";
			str += "<b>"+data+"</b>";
			str += "</div></div>";
			
			$("#msgArea").append(str);
		}
		else{
			
			var str = "<div class='col-6'>";
			str += "<div class='alert alert-warning'>";
			str += "<b>"+data+"</b>";
			str += "</div></div>";
			
			$("#msgArea").append(str);
		}
		
	}

</script>
</head>

<body>
	<div class="container">
	<div class="col-6">
		<label><b>채팅방</b></label>
	</div>
	<div>
		<div id="msgArea" class="col">
		
		</div>
		<div class="col-6">
		<div class="input-group mb-3">
			<input type="text" id="msg" class="form-control" aria-label="Recipient's username" aria-describedby="button-addon2">
			<div class="input-group-append">
				<button class="btn btn-outline-secondary" type="button" id="button-send">전송</button>
			</div>
		</div>
		</div>
	</div>
	<div class="col-6">
	</div>
</div>
</body>
</html>