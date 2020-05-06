<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="win.model.vo.*" %>
<%
	Member m = (Member)session.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/win/css/afterfoundid.css">
<title>Insert title here</title>
</head>
<body>
<div class="full_sc">
    <form method="POST">
        <div class="logo"><img src="/win/images/winwin_logo.PNG"></div>
        <div class="foundid">
            <div class="box_id">
            <fieldset class="div_idfound">
                <legend><p class="title_ment">아이디 찾기</p></legend>
                <%if(m.getUserId().equals("")){ %>
                  <div class="subtitle_ment">존재하지 않는 회원입니다.</div>
          
            <%}else{ %>
               <div class="subtitle_ment">회원가입 시 사용하신 아이디는   <%=m.getUserId()%> 입니다.</div>
      
             <%} %>
            </fieldset>
            </div>

            <div class="back">
                <button class="loginback" type="button" onclick="gologin();">로그인 화면으로 돌아가기</button>
                <button class="pwdgo" type="button" onclick="goPwd();">비밀번호 찾기 </button>
            </div>
        </div>
    </form>
</div>

	<script>
		function gologin(){
			location.href='/win/Member/loginUser.jsp';
		};
		
		function goPwd(){
			location.href='/win/Member/foundPwd.jsp';
		};
	</script>
</body>
</html>