'<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/win/css/found_id.css">
<title>아이디 찾기</title>
</head>
<body>
    <div class="full_sc">
    <form method="POST" id="findform" action="${pageContext.request.contextPath}/mFind.do">
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
                            <dt class="info_phone"><label class="label_txt">이메일</label></dt>
                            <dd class="info_phone1">
                                <input type="email" id="email" name="email" class="found_userid" required> 
                                
                            </dd>
                    </div>
                </div>
            </div>
            <div>
            <button type="submit" value="확인" class="sub_btn" onclick="findId()">확인</button>
            <button type="button" value="취소" class="sub_btn1" onclick="history.back();">취소</button>
            </div>
    </form>
    </div>
    
    <script>
		function findId(){
			var name = document.getElementById("userName").value;
			var email = document.getElementById("email").value;
			
			if(name == "" && email==""){
				alert("모든 정보를 입력해주세요");
				return;
			}
		}
		
		/* function gomain(){
			location.href='/win/Login.jsp';
		} */
    </script>
</body>
</html>