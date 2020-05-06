<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="win.model.vo.*"%>
<%
	Member m = (Member)session.getAttribute("member");
	/* session.setMaxInactiveInterval(1000);*/
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/win/css/foundpwd.css">
<title>회원 비밀번호 찾기</title>
</head>
<body>
   <div class="full_sc">
    <form method="POST" id="findpwdform" action="${pageContext.request.contextPath}/mfindpwd.do">
        <div class="logo"><img src="/win/images/winwin_logo.PNG"></div>
        <div class="foundid">
            <div class="div_phone">
                 <div class="foundid">
                    <div class="div_email">
                        <label class="id_email">내 정보에 등록된 이메일로 찾기</label>
                            <p class="foundid_ment">내 정보에 등록된 이메일과 입력한 이메일 주소가 같아야, 인증번호를 받을 수 있습니다.</p>
                    <div class="div_phone_info">
                            <dt class="info_name"><label class="label_txt">이름</label></dt>
                            <dd class="info_name1"><input type="text" id="userName" name="userName" class="found_userid" required></dd><br><br>
                           
                            <dt class="info_name"><label class="label_txt">아이디</label></dt>
                            <dd class="info_name1"><input type="text" id="userId" name="userId" class="found_userid" required></dd><br><br>
                            
                            <dt class="info_phone"><label class="label_txt">이메일</label></dt>
                            <dd class="info_phone1">
                                <input type="email" id="email" name="email" class="found_userid" required> 
                                <input type="submit" id="identify" name="changeCode" class="found_userid_num" value="인증번호 받기" onclick="">
                            </dd>
                       
                            
<!-- 							<dt class="info_phone"><label class="label_txt1">인증코드</label></dt>
                            <dd class="info_phone2">
                                <input type="text" id="code" name="code" class="changeCode">
                            </dd> -->
                           

                    </div>
                    </div>
                </div>
            </div>
        </div>

            <div>
            <button type="button" value="확인" class="sub_btn" onchange="changePwd();">확인</button>
            <button type="button" value="취소" class="sub_btn1" onclick="back();">취소</button>
            </div>    
		</div>
		
		<script>
		/* 	function test1(){
				//alert("인증번호 발송 완료!");
				if(){
					alert("인증번호 발송 완료");
					document.getElementById("findpwdform").submit();
				}else{
					alert("인증번호 발송 실패 ");
				}
			} 
			

				
			 */
			
			function changePWd(){
				
				location.href="/win/Member/changePwd.jsp?email="+document.getElementById('email').value;
			}
			 function back() {
				 location.href="/win/Member/loginUser.jsp"
			 }
		</script>

		


     </form>
</body>
</html>