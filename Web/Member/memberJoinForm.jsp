<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 폼 </title>
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<style>
	body{
    background-color: #dcdcdc;
    width: auto;
    margin: 0 auto;
    max-width: 768px;
    min-width: 460px;

}

.logo{ /* win win*/
    text-align: center;
    padding-top: 50px;
    padding-bottom: 50px;
}

.form_group{
    margin-bottom: 10px;
    text-align: -webkit-center;
    margin-right:120px ;
    
    /* margin: 0 0 30 0; */
}

.form_group1{/* 이용목적 폼*/
    /* margin-bottom: 10px; */
    /* margin: 0 0 30 0; */
    /* float: left; */
    /*  text-align: center;*/
    padding-left:99px;
}


.control_label{/* 이용목적 , 로그인, 아이디, 비밀번호 , 비밀번호 확인 목록 */
    display: inline-block;
    width: 7em; 
    /* margin-top: 0px; */
    /* margin-bottom: 0px; */
    padding-top: 7px;
    text-align: left;
}

.email-label{
    /* width:200px; */
    font-family: sans-serif;
    font-size: 16px;
}

.requird_form{
    width: 310px;
    margin: 2px;
    padding: 8px;
    text-align: center;
    border-radius: 5px;
    
    border: none;
}


.form_group_caption_text{
    font-size: 0.75em;
    color: indianred;
    margin-top: 0.5em;
    margin-bottom: 0.5em;
    padding: 6px;
    margin-right: 1.7em;
}
.form_pwd_caption_text{
    font-size: 0.75em;
    color: indianred;
    margin-top: 0.5em;
    margin-bottom: 0.5em;
    padding: 6px;
    margin-left: 5em;
}
.form_pwd1_caption_text{
    font-size: 0.75em;
    color: indianred;
    margin-top: 0.5em;
    margin-bottom: 0.5em;
    padding: 6px;
    margin-right: 1.8em;
}

.com_dev{
    /* margin-left: 60px; */
}

.terms_form1{
    /* margin-left: 120px; */
    padding-bottom: 10px;
    font-size: 0.85em;
    text-align: center;
    /* margin-right: 30px; */
    padding-right: 40px;
    /* padding-right: 130px; input 끝에 맞춤 */
}

.terms_form2{
    margin-left: 4.2em;
    font-size: 0.85em;
    text-align: center;
    /* margin-right: 30px */
    padding-right: 40px; 
    /* padding-right: 210px;  input 끝에 맞춤*/
}

.button{
    /* width: 300px; */
    /* height: 100px; */
    /* margin: 5px; */
    /* padding: 5px; */
    /* padding-left: 650px; */
    text-align: center;

}

.signup_list_element{ /* 이용목적 개발자 & 기업*/
    margin-right: 10px;
    float: left;
    margin-left: 10px;
    margin-bottom: 5%;
}

.signup_list_label{/* 이용목적 개발자 & 기업 */
    width: 150px;
    height: 220px;
    display: inline-block;
    padding: 15px 0 12px 0;
    margin-bottom: 0;   
    border: 1px dashed black;
    text-align: center;
    box-sizing: border-box;
    cursor: pointer;
}

.signup_list_text{
    margin-top: 5px;
    margin-bottom: 20px;
    font-size: 12px;
    font-weight: bold;
    color: #778899;
    line-height: 1;
}

.signup_list_element_img{/* 이용목적 - 기업*/
    background-image: url("../images/paper.png");
    display: inline-block;
    width: 50px;
    height: 50px;
    background-size: 50px 50px;
    margin-bottom: 3px;
    box-sizing: border-box;
    text-align: center;
    
}


.signup_list_element_radio{
    margin-bottom: 5px;
    line-height: 1;
}

.signup_list_element_who{
    margin-left: 16px;
    margin-right: 16px;
    margin-bottom: 7px;
}

.signup_list_who{
    font-weight: bold;
    font-size: 13px;
    color: #778899;
    line-height: 13px;
    padding-top: 1px;
}

.signup_list_hr{
    border: 1px solid #778899;
    margin:  0 2px 6px 2px;
}

.signup_list_explain{
    margin-bottom: 0;
    font-size: 12px;
    line-height: 16px;
    color: #778899;
    font-weight: normal;
}

.singup_form{
    /* width: 410px; */
    /* margin-left: 10px; */
    /* margin-right: 10px; */
    /* padding-bottom: 20px; */
}
.signup_list{ /* 이용목적 기업 & 개발자  */
    /* padding:0; */
    /* margin-top: 0; */
    /* margin: 1em 0; */
    /* float: left; */
    
}

.signup_form{/* 이용목적 크기 */
    /* top: 50%; */
    /* left: 50%; */
    /* height: 280px; */
    display: inline-block;

}
.signup_list_element_img1{ /* 이용목적 - 개발자 */
    background-image: url("../images/search.png");
    display: inline-block;
    width: 50px;
    height: 50px;
    background-size: 50px 50px;
    /* margin-bottom: 3px; */
    box-sizing: border-box;
    text-align: center;
    
}

.star{
    color: #CD5c5c;
    margin: 1px;
}

.sign_form{
    text-align: center;
    margin: 0 auto;
    width: auto;
}

.signup_form1{
    display: inline-block;
}

.signup_list_1{
    float: left;
}

.signup_list_2{
    float: left;
}
.list_form{
    display: inline;
}
.formstyle{
    display: center;
}

.input_field{
    background-color: #0f4c81;
    color: white;
    font-weight: bold;
    border: none;
    border-radius: 5px;
}
</style>
</head>
<body>
	 <form id="joinForm" action="/win/mInsert.me" method="post">
         <div class="sign_form">
            <div class="logo"><a href="/win/mainpage.jsp" style="padding:0px;"><img src="../images/winwin_logo.PNG"></a></div>
                <div class="signup_form">
                <ul class="signup_list" style="padding-left: 0px; ">
                <div class="signup_list_1">
                    <oi class="signup_list_element">
                        <label class="signup_list_label">
                            <p class="signup_list_text">프로젝트를 의뢰합니다.</p>
                            <div class="signup_list_element_img"></div>
                            <div class="signup_list_element_radio">
                                <input class="signup_list_radio" name="memberType" type="radio" value="C" id="company" onclick="cNum(this);">
                            </div>
                            <div class="signup_list_element_who">
                                <p class="signup_list_who">기업</p>
                                <hr class="signup_list_hr">
                                <p class="signup_list_explain">의뢰할 프로젝트가 있는 기업</p>
                            </div>
                        </label>
                    </oi>
                </div>
            
                <div class="signup_form">
                    <div class="signup_list_2">
                    <oi class="signup_list_element">
                        <label class="signup_list_label">
                            <p class="signup_list_text">프로젝트를 찾습니다.</p>
                            <div class="signup_list_element_img1"></div>
                            <div class="signup_list_element_radio">
                                <input class="signup_list_radio" name="memberType" type="radio" value="D" id="developer" onclick="cNum(this);">
                            </div>
                            <div class="signup_list_element_who">
                                <p class="signup_list_who">개발자</p>
                                <hr class="signup_list_hr">
                                <p class="signup_list_explain">프로젝트를 참여하고 싶은 개발자</p>
                            </div>
                        </label>
                    </oi>
                </div>
                </ul>
                </div>
            </div>
            
       
            <div class="list_form">
            <div class="form_group">
            <label class="control_label" for="user_email"><span class="star">*</span>이메일</label>
                
                <input class="requird_form" id="user_email" name="email" type="email"  placeholder="사용하실 이메일을 입력해주세요.">
       
                <div class="form_group_caption">
                    <div class="form_group_caption_text">
                     <dd>비지니스용 이메일을 사용을 권장합니다.</dd>
                    </div>
                </div>
        </div>

        <div class="form_group">
            <label class="control_label" for="user_Name"><span class="star">*</span>이름(기업명)</label>
                <input class="requird_form" id="user_Name" name="userName" type="text" placeholder="이름(기업명)을 입력해주세요." >                
        </div>
       

        <div class="form_group">
            <label class="control_label" for="user_ID"><span class="star">*</span>아이디</label>
                <input class="requird_form" id="user_ID" name="userId" type="text" placeholder="사용하실 아이디를 입력해주세요." >  
                <div id="idCheck" class="input_field" style="position: relative; width: 90px;height: 25px;left: 278px;top: -15px;
                										margin: -15px;
                										padding-top: 3px; font-size:15px">중복확인
               	</div>              
        </div>

        <div class="form_group1"  id="com_num">
            <label class="control_label" for="company_num"><span class="star">*</span>사업자번호</label>
                <input class="requird_form" id="company_num" name="companyId" type="text" placeholder="사업자 번호를 입력해주세요.(- 없이)" >    
        </div>





        <div class="form_group">
            <label class="control_label" for="user_pwd"><span class="star">*</span>비밀번호</label>
                <input class="requird_form" id="user_pwd" name="userPwd" type="password"  placeholder="사용하실 비밀번호를 입력해주세요." >                
            <div class="form_group_caption">
                <div class="form_pwd_caption_text">
                    비밀번호는 8자 이상 32자 이하로 입력해주세요.
                </div>
            </div>
        </div>

        <div class="form_group">
            <label class="control_label" for="user_pwd1"><span class="star">*</span>비밀번호 확인</label>
                <input class="requird_form" id="user_pwd1" name="userPwd1" type="password" placeholder="비밀번호를 다시 입력해주세요." >    
            <div class="form_group_caption">
                <div class="form_pwd1_caption_text">
                    동일한 비밀번호를 입력해주세요.
                </div>
            </div>
        </div>


        <div class="terms_form1" >
            <input id="check1" type="radio" name="clause" value="clause"><a href="use.html"><b>이용약관</b></a>에 동의합니다. <br>
        </div>
        <div class="terms_form2">
            <input id="check2" type="radio" name="personalInfo" value="personalInfo"><a href="user.html"><b>개인정보 처리방침</b></a>에 동의합니다.
        </div>

        <div class="button">
            <input type="submit" onclick="return input()" value="회원가입" name="input_submit" class="input_field" style="width:325px;height:40px;margin-top: 30px;margin-bottom: 50px;">
        </div>
     </div>

    </form>

	<script>
	
	function input(){
		
		if(document.getElementById('user_email').value == ""){
		 	alert("이메일을 입력해 주세요");
		 	return false; 
		}
		if(document.getElementById('user_Name').value == ""){
			alert("이름을 입력해 주세요")
			return false;
		}
		if(document.getElementById('user_ID').value == ""){
			alert("아이디를 입력해 주세요")
			return false;
		}
		if(document.getElementById('company_num').value == "" && document.getElementById('company').check ==true ){
			alert("사업자 번호를 입력해 주세요")
			return false;
		}
		if(document.getElementById('user_pwd').value == ""){
			alert("비밀번호를 입력해 주세요")
			return false;
		}
		if(document.getElementById('user_pwd1').value == ""){
			alert("비밀번호를 입력해 주세요")
			return false;
		}
		if(document.getElementById('check1').checked == false){
				alert('이용약관에 동의해 주세요');	
				return false;
		}
		if(document.getElementById('check2').checked == false){
			alert('개인정보 수집에 동의해 주세요');
			return false;
		}
		if(document.getElementById('user_pwd').value != document.getElementById('user_pwd1').value){
			alert('비밀번호가 일치하지 않습니다.');
			return false;
		}else{
			return true;	
		}
		
		
	}
	
	</script>
	


    <script>
    
    
    
        function cNum(radio){
                if(radio.value == 'D'){
                    com_num.style.display = "none";
                }else if(radio.value == 'C'){
                    com_num.style.display = "block";
                }
                
        }
        
        $('#idCheck').click(function() {
			$.ajax({
				url:"/win/idDup.me",
				type:"post",
				data:{user_ID: $('#user_ID').val()},
				success:function(data) {
					console.log(data);
					
					if(data=='ok') {
						alert("사용 가능한 아이디입니다.");
					} else {
						alert("이미 사용중인 아이디입니다.");
						$('#user_ID').select();
					}
				}, error:function() {
					console.log("Error 입니다.");
				}
			});
		});
    

    </script>
</body>
</html>