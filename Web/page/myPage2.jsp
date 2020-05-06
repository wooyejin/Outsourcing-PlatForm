<%@page import="win.board.model.vo.Career"%>
<%@page import="java.util.ArrayList"%>
<%@page import="win.board.model.vo.Skill"%>
<%@page import="win.board.model.vo.Introduce"%>
<%@page import="win.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
	Member m = (Member)request.getAttribute("member");
	/* session.setMaxInactiveInterval(1000);*/
	
	Introduce in =(Introduce)request.getAttribute("in");
	
     ArrayList<Skill> slist = (ArrayList<Skill>)request.getAttribute("slist");
     
     ArrayList<Career> clist = (ArrayList<Career>)request.getAttribute("clist");
	

%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/win/css/mypage1.css">
    <link rel="stylesheet" href="/win/css/mainpagecss.css">
    <title>Document</title>
     <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>

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
            <li class="login"><a href ="/win/page/myPage1.jsp">마이페이지</a></li>
        </ul>
    </nav>

   <div class="page">
   <form action="<%= request.getContextPath() %>/mUpdate3.me"
		      method="post" enctype="multipart/form-data" name="profileform">
        <div class="page_inner">
            <div class="sidebar">
              <div class="developer_name_tag">
                    <h3 class="developer_heading"> 개발자 
                       <!--  <a onclick='del();'><img src="/win/images/delete.png" class="main_img"></a>
                        <a onclick='logout();'><img src="/win/images/log_out.png" class="main_img"></a>
                        <a href="/win/page/myPage1.jsp"><img src="/win/images/home.png" class="mypage_img"></a> -->
                    </h3>
                    
                    
                    <div class="developer_body_img">
                        <div id="developer_img_con">
                        	<% if(m.getChangename()==null) {%>
                            <img alt="User01" class="developer_img" id="titleImg" src="/win/images/mypage_info.png">
                            <%} else{%>
                            <img class="developer_img" id="titleImg" src="/win/resources/images/<%=m.getChangename()%>">
                            <%} %>
                       </div>
                        <div class="fileArea" id="fileArea">
		      			</div>
                        <h4 class="userId">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%= m.getName() %></h4>
                    </div>
                </div>
               </form>
                

               <!--  <div class="sidebar_bottom">
                    <ul class="sidebar_bot">
                        <li class="sidebar_list"><a href="/win/page/changeInfo.jsp" class="sidebar_info">개인정보수정</a></li>
                    </ul>
                </div>

                <div class="sidebar_bottom" id="sidebar_bottom">
                    <ul class="sidebar_bot">
                        <li class="sidebar_list"><a href="javascript:profileform.submit();" class="sidebar_info" id="profilea">프로필저장</a></li>
                        
                        <button type="submit" name="input" class="sidebar_info">프로필저장</button>
                    </ul>
                </div>
 -->

            </div>

            <div class="content">
                <div class="content_inner">
                    <section>
                        <div class="mypage_info">
                            <div>
                                <h4 class="info_title">자기 소개<!-- <a class="info_button" href="/win/page/mypage_write.jsp">등록</a> -->
                               <!--  <a class="info_button" href="/win/page/mypage_write2.jsp">수정</a> -->
                                </h4>
                                <div class="info_title_container">
                                    <div class="info_title_content">
                                        <div style="display:content;">
                                        <%if (in==null) {%>
                                            <div>
                                                <img src="/win/images/introduce.png" class="mypage_info_img">
                                                <p class="mypage_info_ment">입력된 자기 소개가 없습니다.</p>
                                                </div>
                                                <%}else {%>
                                                	<div>
                                            			<p id="intro_title" style="text-align: left;margin-left: 39px;">제목</p>
                                            			      	<p style="text-align: left;margin-left: 39px;margin-right: 10px; " ><%=in.getIn_title() %></p>
                                                	</div>
                                                	<div>
                                                	<p id="intro_title" style="text-align: left;margin-left: 39px;">내용</p>
                                                		<p style="text-align: left;margin-left: 39px; margin-right: 10px; overflow: hidden; display: -webkit-box;-webkit-line-clamp: 3; -webkit-box-orient: vertical;" >
                                                		<%=in.getIn_content() %></p>
                                                	</div>
                                                <% } %>
                                           <!--  </div> -->
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>

                    <section class="mypage_portfolios">
                        <div class="mypage_portfolio" style="height: 149px;">
                        <form action="<%= request.getContextPath() %>/pInsert.pe" 
			      	method="post" enctype="multipart/form-data" name="portform">
                            <div>
                                <!-- <h4 class="portfolio_title">포트폴리오<a class="portfolio_button">업데이트 하기</a></h4> -->
                                 <h4 class="portfolio_title">포트폴리오
                                   <!--  <label  for="portfolio_update" class="portfolio_update" >파일</label>
                                    <input type="file" class="portfolio_button" id="file" name="file" value="파일" hidden>
                                    <a href="javascript:portform.submit();"class="portfolio_update">저장</a>
                                    <input class="portfolio_button" type="file" id="portfolio_update" name="file" hidden>  -->
                                </h4>
                                
                                <div class="portfolio_container">
                                    <div class="portfolio_content">
                           						<div style="display:content">
                           						<%if(m.getBoardfile()==null) { %>
                                            <div>
                                                <img src="/win/images/folderadd.png" class="mypage_info_img">
                                                <p class="mypage_info_ment">등록된 포트폴리오가 없습니다.</p>	
                                            </div> 
                                           <%}else if(m.getBoardfile() != null) {  %>
                                           <a style="position: relative;/* top: -50px;left: -26px; */
                                           top:22px;left:-135px;" 
                                           href="/win/bfdown.bo?path=<%=m.getBoardfile() %>"><%=m.getBoardfile() %></a>
                                           <%if(m.getFileYN().equals("N")){ %>
                                           <p id ="board">승인여부</p>
                                          	<p id="board2">파일명</p>
                                           <span style="position: relative;left: 97px;top: -91px;">X</span>
                                           <% } else {%>
                                           <p id ="board">승인여부</p>
                                          	<p id="board2">파일명</p>
                                           <span style="position: relative;left: 97px; top: -91px;">◎</span>
                                           <% } %>
                                          	<% } %>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            </form>
                       </div>
                    </section>



                    
                    <section class="mypage_technologys">
                        <div class="mypage_technology">
                            <div>
                                <h4 class="technology_title">보유 기술<!-- <a class="technology_button" href="/win/page/mypagetechnology.jsp">업데이트 하기</a> --></h4>
                                <div class="technology_container">
                                    <div class="technology_content">
                                        <div style="display:content;">
                                        	<%if (slist==null) {%>
                                            <div>
                                                <img src="/win/images/setting.png" class="mypage_info_img">
                                                <p class="mypage_info_ment">등록된 보유 기술이 없습니다.</p>
                                                </div>
                                                 <%}else {%>
                                                 
                                                 	<table class ="table-hover">
                                                 		<thead>
                                                 			<tr>
                                                 				<th style="min-width: 181px; max-width: 370px">사용언어</th>
                                                 			
                                                 				<th style="min-width: 330px; max-width: 370px">숙련도</th>
                                                 				
                                                 				<th style="min-width: 203px; max-width: 370px">경험</th>
                                                 		</tr>
                                                 		</thead>
                                                 	
                                                 		<tbody>
                                                 			<%for(Skill s : slist) {%>
                                                 			<tr>
                                                 				<td><%=s.getS_name() %></td>
                                                 				<td><%=s.getS_lev() %></td>
                                                 				<td><%=s.getS_ex() %></td>
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



                    <section class="mypage_careers">
                        <div class="mypage_career">
                            <div>
                                <h4 class="career_title">경력<!-- <a class="career_button" href="/win/page/mypagecareer.jsp">업데이트 하기</a> --></h4>
                                <div class="career_container">
                                    <div class="career_content">
                                        <div style="display:content;">
                                        	<%if (clist==null) {%>
                                            <div>
                                                <img src="/win/images/career.png" class="mypage_info_img">
                                                <p class="mypage_info_ment"> 등록된 경력이 없습니다.</p>
                                            </div>
                                            <%}else {%>
                                      			  <table class ="table-hover">
                                                 		<thead>
                                           		<tr>
                                       						<th style="min-width: 175px; max-width: 370px">회사명</th>
                                                 			
                                                 				<th style="min-width: 110px; max-width: 370px">분야</th>
                                                 				
                                                 				<th style="min-width: 157px; max-width: 370px">직위</th>
                                                 				
                                                 				<th style="min-width: 142px; max-width: 370px">경력</th>
                                                 				
                                                 				<th style="min-width: 186px; max-width: 370px">재직중</th>
                                                 		</tr>
                                                 		</thead>
                                                 	
                                                 		<tbody>
                                                 			<%for(Career c : clist) {%>
                                                 			<tr>
                                                 				<td><%=c.getCa_name() %></td>
                                                 				<td><%=c.getCa_work() %></td>
                                                 				<td><%=c.getCa_rank() %></td>
                                                 				<td><%=c.getCa_exper() %></td>
                                                 				<% if( c.getStatus().equals("Y")) { %>
																	<td> ◎ </td>
																	<%} else { %>
																	<td> X </td>
																		<% } %>
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
           
           
    
          
    <script>
   /* 	$(function() {
   		$('#fileArea').hide();
   		
   		$('#developer_img_con').click(() => {
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
   	} */
    function logout(){
			location.href="/win/logout.me";
		}
    
    /* function del(){
		location.href="/win/mUpdate2.me";
	} */
   </script>
</body>
</html>