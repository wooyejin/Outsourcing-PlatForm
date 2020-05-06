<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="win.model.vo.Member"%>



<%
	Member m = (Member)session.getAttribute("member");
	/* session.setMaxInactiveInterval(1000);*/
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/win/css/mainpagecss.css">
    <link rel="stylesheet" href="/win/css/changeinfo_css.css">
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
     <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    
    <title>Document</title>
</head>

<body>
    <nav id = nav2>
        <ul>
           <li class="logo"><a href = "/win/mainpage.jsp" style="padding:0px;"><img src="/win/images/win_win.png"></a></li>
            <li><a href ="/win/plist.do">프로젝트 찾기</a></li>
            <li><a href ="/win/dlist.do">개발자 찾기</a></li>
            <li><a href ="/win/Project/signupProject.jsp">프로젝트 등록</a></li>
            <li><a href ="/win/selectList.no">공지사항</a></li>
            <li><a href ="#">이용방법</a></li>
            <li class="login"><a href ="/win/page/mypage_company.jsp">마이페이지</a></li>
        </ul>
    </nav>

    <div class="page">
        <div class="page_inner">
            <div class="sidebar">
                <div class="developer_name_tag">
                    <h3 class="developer_heading"> 기업 
                        <a onclick='del();'><img src="/win/images/delete.png" class="main_img"></a>
                        <a onclick='logout();'><img src="/win/images/log_out.png" class="main_img"></a>
                        <a href="/win/page/mypage_company.jsp"><img src="/win/images/home.png" class="mypage_img"></a>
                    </h3>
                    <div class="company_body_img">
                        <div id="company_img_con">
                            <% if(m.getChangename()==null) {%>
                            <img alt="User01" class="developer_img" id="titleImg" src="/win/images/mypage_info.png">
                            <%} else{%>
                            <img class="developer_img" id="titleImg" src="/win/resources/images/<%=m.getChangename()%>">
                            <%} %>
                        </div>
                        <div class="fileArea" id="fileArea">
		      				<input type="file" id="thumbnailImg1"
		      					name="thumbnailImg1" onchange="loadImg(this, 1);" />
		      			</div>
                       <h4 class="userId">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%= m.getName() %></h4>
                    </div>
                </div>

                <div class="sidebar_bottom">
                    <ul class="sidebar_bot">
                        <li class="sidebar_list"><a href="#" class="sidebar_info">개인정보수정</a></li>
                    </ul>
                </div>
                <!-- <div class="sidebar_bottom">
                    <ul class="sidebar_bot">
                        <li class="sidebar_list"><a href="/win/page/companysurvey.jsp"  class="sidebar_info">평가</a></li>
                    </ul>
                </div>

                <div class="sidebar_bottom">
                    <ul class="sidebar_bot">
                        <li class="sidebar_list"><a href="/win/page/companysurvey_commit.jsp"  class="sidebar_info">평가등록</a></li>
                    </ul>
                </div> -->
            </div>

            <form id="updateForm" action="/win/mUpdate.me" method="post">
                <div class="write_main">
                    <div class="write_title_div">
                        <h3 class="write_title_text">개인정보수정</h3>
                    </div>

                    <div class="mypCotent">
                        <div class="title_div">

                            <div class="form_group">
                                <label class="control_label" for="user_email">이메일</label>
                                <input class="requird_form" id="user_email" name="email" type="email" required>
                                <input type="hidden" name="memberType" value="<%=m.getMemberType()%>">
                            </div>

                            <div class="form_group_caption">
                                <div class="form_group_caption_text">
                                    <dd>비지니스용 이메일을 사용을 권장합니다.</dd>
                                </div>
                            </div>
                        
            
                            <div class="form_group">
                                <label class="control_label" for="user_Name">이름(기업명)</label>
                                <input class="requird_form" id="user_Name" name="userName" type="text" value = "<%=m.getName() %>" readonly>                
                                
                            </div>
                   
            
                            <div class="form_group">
                                <label class="control_label" for="user_ID">아이디</label>
                                <input class="requird_form" id="user_ID" name="userId" type="text" value = "<%=m.getUserId() %>" readonly>                
                            </div>
            
            
                            <div class="form_group">
                                <label class="control_label" for="user_pwd">비밀번호</label>
                                <input class="requird_form" id="user_pwd" name="userPwd" type="password"  placeholder="사용하실 비밀번호를 입력해주세요." required> 
                                <div class="alert-success" id="alert-success">비밀번호가 일치합니다.</div>               
                            <div class="form_group_caption">
                            
                            <div class="form_pwd_caption_text">
                                비밀번호는 8자 이상 32자 이하로 입력해주세요.
                                
                            </div>

                            
            
                            <div class="form_group">
                                <label class="control_label" for="user_pwd1">비밀번호 확인</label>
                                <input class="requird_form" id="user_pwd1" name="userPwd1" type="password" placeholder="비밀번호를 다시 입력해주세요." required>  
                                <div class="alret-danger" id="alert-danger">비밀번호가 일치하지 않습니다.</div>  
                            <div class="form_group_caption">

                            <div class="form_pwd1_caption_text">
                                동일한 비밀번호를 입력해주세요.
                            </div>

                            

                            <div class="btn">
                                <button class="submit_btn" type="submit" onclick="chkPW()">수정 완료</button>
                                <a href="/win/page/mypage_company.jsp" class="submit_btn"><button class="submit_btn" type="button">취소</button></a>
                            </div>
                        </div>
                    </div>
                </div>

            </form>


            </div>
        </div>
    </div>

    <script type="text/javascript">
        // 비밀번호 & 비밀번호 확인 일치, 불일치 
        $(function(){ 
            $("#alert-success").hide();
            $("#alert-danger").hide(); 
            $("input").keyup(function(){ 
                var pwd1=$("#user_pwd").val(); 
                var pwd2=$("#user_pwd1").val(); 
                if(pwd1 != "" || pwd2 != ""){ 
                    $(".form_pwd_caption_text").hide();
                    $(".form_pwd1_caption_text").hide();
                     if(pwd1 == pwd2){ 
                        $("#alert-success").show(); 
                        $("#alert-danger").hide(); 
                        $("#submit").removeAttr("disabled");
                    }else{ 
                        $("#alert-success").hide(); 
                        $("#alert-danger").show(); 
                        $("#submit").attr("disabled", "disabled"); 
                    } 
                } 
             }); 
        }); 

        // 비밀번호 유효성 체크 검사 
        function chkPW(){ 
            var pw = $("#user_pwd").val();
             var num = pw.search(/[0-9]/g); 
             var eng = pw.search(/[a-z]/ig); 
             var spe = pw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
              if(pw.length < 8 || pw.length > 33){ alert("8자리 ~ 32자리 이내로 입력해주세요."); 
              return false; }else if(pw.search(/\s/) != -1){ alert("비밀번호는 공백 없이 입력해주세요."); 
              return false; }else if(num < 0 || eng < 0 || spe < 0 ){ alert("영문,숫자, 특수문자를 혼합하여 입력해주세요."); 
              return false; }else { console.log("통과"); 
              alert("회원 정보 수정 완료!");
              return true; } 
            
        }
        
        function logout(){
    			location.href="/win/logout.me";
    		}
        
        function del(){
    		location.href="/win/mUpdate2.me";
    	}
        $(function() {
       		$('#fileArea').hide();
       		
       		$('#company_img_con').click(() => {
    			$('#thumbnailImg1').click();
    		});
       	});
  
       	
       	
       	function loadImg(value, num){
    		
    		if(value.files && value.files[0])  {
    			
    			var reader = new FileReader();
    			
    			reader.onload = function(e){
    				
    				switch(num) {
    				case 1 : $('#titleImg').attr('src', e.target.result);
    					break;
    				}
    			}
    			reader.readAsDataURL(value.files[0]);
    		}
       	}

    </script>
    
    
    

</body>
</html>