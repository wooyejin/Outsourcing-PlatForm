<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>로그인</title>
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    
    <link rel="stylesheet" href="/win/css/LoginUser.css">
</head>
<body>
    <!-- <form action="/win/login.me" method="POST"> -->
    <div class="logo"><a href="/win/mainpage.jsp" style="padding:0px;"><img src="/win/images/winwin_logo.PNG"></a></div>

<div class = "Id_pwd_form2">
    기업<input class="mtype" type="radio" name="mType" value="C">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      개발자<input class="mtype" type="radio" name="mType" value="D">
      </div>
      <br>
    <input type="text" id="ID" name="userId" class="login_form" placeholder="아이디" required> 
    <div class="Id_pwd_form">
    <input type="password" id="PWD" name="userPwd" class="login_form" placeholder="비밀번호" required>
    </div>
   
    
    <div class="sub_but">
        <input type="button" id="loginbtn" value="로그인" class="submit_button" style="width: 380px; height: 50px; margin-top: 20px;">
    </div>
    <hr class="line_form">
<!-- </form> -->

    <div class="links">
        <a href="/win/Member/foundId.jsp">아이디 찾기 </a> &nbsp;
        <a href="/win/Member/foundPwd.jsp">비밀번호 찾기 </a> <br>
        <a href="/win/Member/memberJoinForm.jsp"> <br> 회원가입</a>
      </div>

	<script>
	
	$("#loginbtn").click(function(){
		
		var id = document.getElementById('ID').value;
		var pwd = document.getElementById('PWD').value;
		
		
		$.ajax({
			url : "/win/login.me",
			type : "post",
			data : {ID:$("#ID").val(),PWD:$("#PWD").val(),type:$("input[name=mType]:checked").val() },
			success: function(data){
				console.log(data);
				
				if(data == 'admin'){
					location.href="../index.jsp";
				}else if(data == 'null'){
					alert('아이디 비밀번호를 확인하세요')
				}else{
				    location.href="../mainpage.jsp";		
				}		
			},
			error:function(){
				console.log("Error 입니다.");
			}
			
		})
		
	})
	
	
	
	
	
	</script>




</body>
</html>