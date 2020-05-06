<%@page import="win.model.service.MemberService"%>
<%@page import="java.util.ArrayList"%>
<%@page import="win.board.model.vo.Introduce"%>
<%@page import="win.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
		
 	MemberService ms = new MemberService();
 	Member m = (Member)session.getAttribute("member");
	/* session.setMaxInactiveInterval(1000);*/
	
	Introduce in =(Introduce)session.getAttribute("in");
	
	ArrayList<Member> ulist = ms.updateCompany(m);
	
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/win/css/mypage_company.css">
    <link rel="stylesheet" href="/win/css/mainpagecss.css">
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
     <form action="<%= request.getContextPath() %>/mUpdate3.me"
		      method="post" enctype="multipart/form-data" name="profileform">
        <div class="page_inner">
            <div class="sidebar">
                <div class="company_name_tag">
                    <h3 class="company_heading"> 기업 
                    <a onclick='del();'><img src="/win/images/delete.png" class="main_img"></a>
                        <a onclick='logout();'><img src="/win/images/log_out.png" class="main_img"></a>
                        <a href="/win/page/mypage_company.jsp"><img src="/win/images/home.png" class="mypage_img"></a>
                        
                    </h3>
                    <div class="company_body_img">
                        <div id="company_img_con">
                            <% if(m.getChangename()==null) {%>
                            <img alt="User01" class="developer_img" style="width: 218px; height: 218px;padding-left: 10px;" id="titleImg" src="/win/images/mypage_info.png"> 
                            <%} else{%>
                            <img class="developer_img" style="width: 218px; height: 218px;padding-left: 10px;" id="titleImg" src="/win/resources/images/<%=m.getChangename()%>">
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
                        <li class="sidebar_list"><a href="/win/page/changeInfo_com.jsp" class="sidebar_info">개인정보수정</a></li>
                    </ul>
                </div>
                
                <div class="sidebar_bottom">
                    <ul class="sidebar_bot">
                        <li class="sidebar_list"><a href="javascript:profileform.submit();" class="sidebar_info" id="profilea">프로필저장</a></li>
                    </ul>
                </div>

                <!-- <div class="sidebar_bottom">
                    <ul class="sidebar_bot">
                        <li class="sidebar_list"><a href="/win/page/companysurvey_commit.jsp"  class="sidebar_info">평가등록</a></li>
                    </ul>
                </div> -->
            </div>

            <div class="content">
                <div class="content_inner">
                    <section>
                        <div class="mypage_info">
                            <div>
                                <h4 class="info_title">기업 소개<a class="info_button" href="/win/page/companywrite.jsp">등록</a>
                                <%if( in != null) {%>
                                <a class="info_button" href="/win/page/companywrite2.jsp">수정</a>
                                <%  }%>
                           	</h4>
                                <div class="info_title_container">
                                    <div class="info_title_content">
                                        <div style="display:content;">
                                            <%if (in==null) {%>
                                            <div>
                                                <img src="/win/images/introduce.png" class="mypage_info_img">
                                                <p class="mypage_info_ment">입력된 자기 소개가 없습니다.</p>
                                                <%}else {%>
                                                	<div>
                                            			<p id="intro_title" style="text-align: left;margin-left: 39px;">제목</p>
                                            			      	<p style="text-align: left;margin-left: 39px;margin-right: 10px; " ><%=in.getIn_title() %></p>
                                                	</div>
                                                	<div>
                                                	<p id="intro_title" style="text-align: left;margin-left: 39px;">내용</p>
                                                		<p style="text-align: left;margin-left: 39px; margin-right: 10px; overflow: hidden; display: -webkit-box;-webkit-line-clamp: 3;-webkit-box-orient: vertical;" >
                                                		<%=in.getIn_content() %></p>
                                                	</div>
                                                <% } %>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>

                  <!--   <section class="mypage_projects">
                        <div class="mypage_project">
                            <div>
                                <h4 class="project_title">등록한 프로젝트<a class="project_button">업데이트 하기</a></h4>
                                <div class="project_container">
                                    <div class="project_content">
                                        <div>
                                            <div>
                                                <img src="/win/images/folderadd.png" class="mypage_info_img">
                                                <p class="mypage_info_ment">등록된 프로젝트가 없습니다.</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section> -->
                    
                    
                     <section class="mypage_user">
                        <div class="mypage_user">
                            <div>
                                <h4 class="project_title">프로젝트 신청자 정보<!-- <a class="project_button">업데이트 하기</a> --></h4>
                                <div class="project_container">
                                    <div class="project_content">
                                        <div style="display:content">
                                        <%if (ulist==null) { %>
                                            <div>
                                                <img src="/win/images/user.png" class="mypage_info_img">
                                                <p class="mypage_info_ment">신청자가 없습니다.</p>
                                            </div>
                                            <% }else { %>
                                            <table id="detable" class ="table-hover">
                                           		<thead>
                                                 	<tr>
                                                 	<th style="min-width: 181px; max-width: 370px; font-size: 18px;color: #0f4c81;font-weight: 900;">프로젝트명</th>
                                                 	<th style="min-width: 330px; max-width: 370px; font-size: 18px;color: #0f4c81;font-weight: 900;">아이디</th>
                                                 	</tr>
                                                 </thead>
                                                <tbody>
                                                 <%for(Member u : ulist) {%>
                                                 	<tr>
                                                 		<td style="left: 9px;position: relative;"><%=u.getTitle() %></td>
                                                 		<td><%=u.getUserId() %></td>
                                                 		<td><input  type ="hidden" value="<%=u.getNo()%>"></td>
                                                 	</tr>
                                                 	<% }%>
                                                 </tbody>
                                                 </table>
                                               <% } %>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>


                </div>
            </div>

        </div>
        </form>
    </div>
    
	<script>
	
	$('#detable td').click(function(){
		
		var uno = $(this).parent().find('input').val();
		var D = 'D';
	
 		location.href="<%=request.getContextPath()%>/mDetail?uno="+uno+"&memberType="+D;

		
		
	});
	
	</script>
    
    
    <script>
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
    
    function logout(){
			location.href="/win/logout.me";
		}
    function del(){
		location.href="/win/mUpdate2.me";
	}
   </script>
</body>
</html>