<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="win.model.vo.*"%>
 <%
	Member m = (Member)session.getAttribute("member");
	/* session.setMaxInactiveInterval(1000);*/
%>
<!DOCTYPE html>
<html>
<script>
alert("메일 전송 완료!");
</script>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/win/css/changepwd.css">
<title>Insert title here</title>
</head>
<body>
<div class="full_sc">
    <form method="POST" action="${pageContext.request.contextPath}/mcodeFindpwd.do">
        <div class="logo"><img src="/win/images/winwin_logo.PNG"></div>
        <div class="foundid">
            <div class="div_phone">
                 <div class="foundid">
                    <div class="div_email">
                        <label class="id_email">비밀번호 변경</label>
                            <p class="foundid_ment">이메일에 전송된 인증코드를 입력하고, 비밀번호를 재설정해주세요.</p>
                    <div class="div_phone_info">
                            <dt class="info_name" style="margin-top:50px"><label class="label_txt">인증번호</label></dt>
                            <dd class="info_name1" style="margin-top:50px"><input type="text" id="userId" name="AuthenticationUser" class="found_userid" required></dd><br><br>
     
                    </div>
                    </div>
                </div>
            </div>
        </div>
            <div>
            <button type="submit" value="확인" class="sub_btn" onclick="test1();">확인</button>
            <button type="button" value="취소" class="sub_btn1" onclick="history.back();">취소</button>
            </div>
    </form>
</div>

<script>
function changePWd(){
	
	location.href="/Member/changePwd.jsp?userEmail="+document.getElementById('email').value;
}
</script>
</body>
</html>