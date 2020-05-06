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

<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>

<title>Insert title here</title>
<link rel="stylesheet" href="/win/css/mainpagecss.css">

</head>
<body>

 <nav id=nav2>
        <ul>
            <li class="logo"><a href = "/win/mainpage.jsp" style="padding:0px;"><img src="/win/images/win_win.png"></a></li>
            <li><a href ="/win/plist.do">프로젝트 찾기</a></li>
            <li><a href ="/win/dlist.do">개발자 찾기</a></li>
            <li><a href ="/win/Project/signupProject.jsp">프로젝트 등록</a></li>
            <li><a href ="/win/selectList.no">공지사항</a></li>
            <li><a href ="#">이용방법</a></li>
            <%if(m==null){ %>
            <li class="login"><a href ="/win/Member/loginUser.jsp" onclick='login();'>로그인</a></li>
            <li class="signup"><a href ="/win/Member/memberJoinForm.jsp" onclick="memberJoin();">회원가입</a></li>
            <%}else /* if(m.getMemberType().equals("D")) */{ %>
            
             <li class="login"><a href="#" onclick='logout()'>로그아웃</a></li>
            <li class="signup"><a href="#" onclick="myPage();">마이페이지</a></li>
             <%
             } %>
            
            <%-- <%}else if(m.getMemberType().equals("C")) { %> --%>
            <!-- <li class="login"><a  onclick='logout()'>로그아웃</a></li>
            <li class="signup"><a  onclick="myPage2();">마이페이지</a></li> -->
           
     	
            
        </ul>
    </nav>

	<script>
		function login(){
			$('#loginForm').submit();
		}
		
		function logout(){
			location.href="/win/logout.me";
		}
		
		function memberJoin(){
			location.href="/win/views/member/memberJoinForm.jsp";
		}
		function myPage(){
			
		
			location.href="/win/selectList.bo";
		}
		
		
	</script>
</body>
</html>