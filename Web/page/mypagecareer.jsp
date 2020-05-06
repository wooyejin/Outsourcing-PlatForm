<%@page import="win.board.model.vo.Career"%>
<%@page import="java.util.ArrayList"%>
<%@page import="win.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%
	Member m = (Member)session.getAttribute("member");
 int count = 1;
 int count2 = 1;
 int count3 = 1;
 int count4 = 1;
 int count5 = 1;
 
 	ArrayList<Career> clist = (ArrayList<Career>)session.getAttribute("clist");

%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/win/css/mypagecareer_signup.css">
    <link rel="stylesheet" href="/win/css/mainpagecss.css">
    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <title>경력 등록창</title>
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
        <div class="page_inner">
            <div class="sidebar">
                <div class="developer_name_tag">
                    <h3 class="developer_heading"> 개발자 
                         <a onclick='del();'><img src="/win/images/delete.png" class="main_img"></a>
                        <a onclick='logout();'><img src="/win/images/log_out.png" class="main_img"></a>
                        <a href="/win/page/myPage1.jsp"><img src="/win/images/home.png" class="mypage_img"></a>
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
		      				<input type="file" id="thumbnailImg1"
		      					name="thumbnailImg1" onchange="loadImg(this, 1);" />
		      			</div>
                       <h4 class="userId">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%= m.getName() %></h4>
                    </div>
                </div>

                <div class="sidebar_bottom">
                    <ul class="sidebar_bot">
                        <li class="sidebar_list"><a href="/win/page/changeInfo.jsp" class="sidebar_info">개인정보수정</a></li>
                    </ul>
                </div>
              
            </div>

         

            
                <div class="write_main">
                    <div class="write_title_div">
                        <h3 class="write_title_text">경력
                        </h3>
                    </div>

                    <div class="mypCotent">
                       
                        <div class="content_inner">
                            <section class="tech_content_title">
                                <h3 class="content_title">경력 등록
                                    <p class="content_ment">최대 5개 까지 등록 가능합니다.
                              
                                    </p>
                                </h3>
                            </section>
                            <section>
                                
                                    <input name="sort" type="hidden">
                                     <form action="/win/mCareer.me" id="crm" method="post">
                                    <table class="table_career">
                                        <thead>
                                            <tr>
                                                <th class="table_width_companyName"><span class="star">*</span>회사명</th>
                                                <th class="table_width_field"><span class="star">*</span>분야</th>
                                                <th class="table_width_position"><span class="star">*</span>직위</th>
                                                <th class="table_width_career"><span class="star">*</span>경력</th>
                                                <th class="table_width_work"><span class="star">*</span>재직 중</th>
                                           
                                            </tr>
                                        </thead>
            
                                        <tbody id="career_inventory">
                                           <%if(!clist.isEmpty()){ %>	
                                           <%for (Career ss : clist ) { %>
                                        <%String title = "title"+count;%>
                                        <%String field = "field"+count;%>
                                        <%String position = "position"+count;%>
                                        <%String career = "career"+count; %>
                                        <%String work = "work"+count; %>  
                                       <input type="hidden" value="<%= count++ %>"> 
                                            <tr name="tableList">
                                            
                                                <td class="table_list_add"><input value="<%=ss.getCa_name() %>" class="companyName_input" data-validation="required" name="<%=title %>" id="<%=title %>" required="required" type="text"></td>
            
                                                <td class="table_list_add">
                                                    <select class="field_input" data-validation="required" name="<%=field %>" id="<%=field %>" required="required">
                                                        <option selected="selected">분야</option>
                                                        <option value="개발">개발</option>
                                                        <option value="디자인/영상">디자인/영상</option>
                                                        <option value="기획">기획</option>
                                                        <option value="기타">기타</option>
                                                    </select>
                                                </td>
            
                                                <td class="table_list_add">
                                                    <select class="position_input" data-validation="required" name="<%=position %>" id="<%=position %>" required="required">
                                                        <option selected="selected">직위</option>
                                                        <option value="사원">사원</option>
                                                        <option value="주임">주임</option>
                                                        <option value="대리">대리</option>
                                                        <option value="과장">과장</option>
                                                        <option value="차장">차장</option>
                                                        <option value="부장">부장</option>
                                                        <option value="이사">이사</option>
                                                        <option value="상무">상무</option>
                                                        <option value="전무">전무</option>
                                                        <option value="부사장">부사장</option>
                                                        <option value="사장">사장</option>
                                                    </select> 
                                                </td>
            
                                                
                                                <td class="table_list_add">
                                                    <select class="career_input" data-validation="required" name="<%=career %>" id="<%=career %>" required="required">
                                                        <option selected="selected">경력</option>
                                                        <option value="1년 미만">1년 미만</option>
                                                        <option value="1년 이상 3년 미만">1년 이상 3년 미만</option>
                                                        <option value="3년 이상 5년 미만">3년 이상 5년 미만</option>
                                                        <option value="5년 이상 10년 미만">5년 이상 10년 미만</option>
                                                        <option value="10년 이상">10년 이상</option>
                                                    </select> 
                                                </td>
            
                                                <td class="table_list_add">
                                                    <select class="work_input" name="<%=work %>" id="<%=work %>" >
                                                    	<option value='Y'>재직 중 </option>
                                                    	<option value='N'>재직 안함</option>
                                                    </select>
                                                </td>
                                                
                                                </tr>
												<% }%>
                                           		 <%} else{ %>
                                            <tr name="tableList">
                                                <td class="table_list_add"><input class="companyName_input" data-validation="required" name="title1" id="title1" required="required" type="text"></td>
            
                                                <td class="table_list_add">
                                                    <select class="field_input" data-validation="required" name="field1" id="field1" required="required">
                                                        <option selected="selected" value>분야</option>
                                                        <option value="개발">개발</option>
                                                        <option value="디자인/영상">디자인/영상</option>
                                                        <option value="기획">기획</option>
                                                        <option value="기타">기타</option>
                                                    </select>
                                                </td>
            
                                                <td class="table_list_add">
                                                    <select class="position_input" data-validation="required" name="position1" id="position1" required="required">
                                                        <option selected="selected" value>직위</option>
                                                        <option value="사원">사원</option>
                                                        <option value="주임">주임</option>
                                                        <option value="대리">대리</option>
                                                        <option value="과장">과장</option>
                                                        <option value="차장">차장</option>
                                                        <option value="부장">부장</option>
                                                        <option value="이사">이사</option>
                                                        <option value="상무">상무</option>
                                                        <option value="전무">전무</option>
                                                        <option value="부사장">부사장</option>
                                                        <option value="사장">사장</option>
                                                    </select> 
                                                </td>
            
                                                
                                                <td class="table_list_add">
                                                    <select class="career_input" data-validation="required" name="career1" id="career1" required="required">
                                                        <option selected="selected" value>경력</option>
                                                        <option value="1년 미만">1년 미만</option>
                                                        <option value="1년 이상 3년 미만">1년 이상 3년 미만</option>
                                                        <option value="3년 이상 5년 미만">3년 이상 5년 미만</option>
                                                        <option value="5년 이상 10년 미만">5년 이상 10년 미만</option>
                                                        <option value="10년 이상">10년 이상</option>
                                                    </select> 
                                                </td>
            
                                                <td class="table_list_add">
                                                    <select class="work_input" name="work1" id="work1" >
                                                    	<option value='Y'>재직 중 </option>
                                                    	<option value='N'>재직 안함</option>
                                                    </select>
                                                </td>
                                                
            
                                                
                                                </tr>

                                            <tr name="tableList">
                                                <td class="table_list_add"><input class="companyName_input" data-validation="required" name="title2" id="title2" required="required" type="text"></td>
            
                                                <td class="table_list_add">
                                                    <select class="field_input" data-validation="required" name="field2" id="field2" required="required">
                                                        <option selected="selected" value>분야</option>
                                                        <option value="개발">개발</option>
                                                        <option value="디자인/영상">디자인/영상</option>
                                                        <option value="기획">기획</option>
                                                        <option value="기타">기타</option>
                                                    </select>
                                                </td>
            
                                                <td class="table_list_add">
                                                    <select class="position_input" data-validation="required" name="position2" id="position2" required="required">
                                                        <option selected="selected" value>직위</option>
                                                        <option value="사원">사원</option>
                                                        <option value="주임">주임</option>
                                                        <option value="대리">대리</option>
                                                        <option value="과장">과장</option>
                                                        <option value="차장">차장</option>
                                                        <option value="부장">부장</option>
                                                        <option value="이사">이사</option>
                                                        <option value="상무">상무</option>
                                                        <option value="전무">전무</option>
                                                        <option value="부사장">부사장</option>
                                                        <option value="사장">사장</option>
                                                    </select> 
                                                </td>
            
                                                
                                                <td class="table_list_add">
                                                    <select class="career_input" data-validation="required" name="career2" id="career2" required="required">
                                                        <option selected="selected" value>경력</option>
                                                        <option value="1년 미만">1년 미만</option>
                                                        <option value="1년 이상 3년 미만">1년 이상 3년 미만</option>
                                                        <option value="3년 이상 5년 미만">3년 이상 5년 미만</option>
                                                        <option value="5년 이상 10년 미만">5년 이상 10년 미만</option>
                                                        <option value="10년 이상">10년 이상</option>
                                                    </select> 
                                                </td>
            
                                                <td class="table_list_add">
                                                   <select class="work_input" name="work2" id="work2" >
                                                    	<option value='Y'>재직 중 </option>
                                                    	<option value='N'>재직 안함</option>
                                                    </select>
                                                </td>
            
                                            </tr>

                                            <tr name="tableList">
                                                <td class="table_list_add"><input class="companyName_input" data-validation="required" name="title3" id="title3" required="required" type="text"></td>
            
                                                <td class="table_list_add">
                                                    <select class="field_input" data-validation="required" name="field3" id="field3" required="required">
                                                        <option selected="selected" value>분야</option>
                                                        <option value="개발">개발</option>
                                                        <option value="디자인/영상">디자인/영상</option>
                                                        <option value="기획">기획</option>
                                                        <option value="기타">기타</option>
                                                    </select>
                                                </td>
            
                                                <td class="table_list_add">
                                                    <select class="position_input" data-validation="required" name="position3" id="position3" required="required">
                                                        <option selected="selected" value>직위</option>
                                                        <option value="사원">사원</option>
                                                        <option value="주임">주임</option>
                                                        <option value="대리">대리</option>
                                                        <option value="과장">과장</option>
                                                        <option value="차장">차장</option>
                                                        <option value="부장">부장</option>
                                                        <option value="이사">이사</option>
                                                        <option value="상무">상무</option>
                                                        <option value="전무">전무</option>
                                                        <option value="부사장">부사장</option>
                                                        <option value="사장">사장</option>
                                                    </select> 
                                                </td>
            
                                                
                                                <td class="table_list_add">
                                                    <select class="career_input" data-validation="required" name="career3" id="career3" required="required">
                                                        <option selected="selected" value>경력</option>
                                                        <option value="1년 미만">1년 미만</option>
                                                        <option value="1년 이상 3년 미만">1년 이상 3년 미만</option>
                                                        <option value="3년 이상 5년 미만">3년 이상 5년 미만</option>
                                                        <option value="5년 이상 10년 미만">5년 이상 10년 미만</option>
                                                        <option value="10년 이상">10년 이상</option>
                                                    </select> 
                                                </td>
            
                                                <td class="table_list_add">
                                                   <select class="work_input" name="work3" id="work3" >
                                                    	<option value='Y'>재직 중 </option>
                                                    	<option value='N'>재직 안함</option>
                                                    </select>
                                                </td>
            
            
                                            </tr>

                                            <tr name="tableList">
                                                <td class="table_list_add"><input class="companyName_input" data-validation="required" name="title4" id="title4" required="required" type="text"></td>
            
                                                <td class="table_list_add">
                                                    <select class="field_input" data-validation="required" name="field4" id="field4" required="required">
                                                        <option selected="selected" value>분야</option>
                                                        <option value="개발">개발</option>
                                                        <option value="디자인/영상">디자인/영상</option>
                                                        <option value="기획">기획</option>
                                                        <option value="기타">기타</option>
                                                    </select>
                                                </td>
            
                                                <td class="table_list_add">
                                                    <select class="position_input" data-validation="required" name="position4" id="position4" required="required">
                                                        <option selected="selected" value>직위</option>
                                                        <option value="사원">사원</option>
                                                        <option value="주임">주임</option>
                                                        <option value="대리">대리</option>
                                                        <option value="과장">과장</option>
                                                        <option value="차장">차장</option>
                                                        <option value="부장">부장</option>
                                                        <option value="이사">이사</option>
                                                        <option value="상무">상무</option>
                                                        <option value="전무">전무</option>
                                                        <option value="부사장">부사장</option>
                                                        <option value="사장">사장</option>
                                                    </select> 
                                                </td>
            
                                                
                                                <td class="table_list_add">
                                                    <select class="career_input" data-validation="required" name="career4" id="career4" required="required">
                                                        <option selected="selected" value>경력</option>
                                                        <option value="1년 미만">1년 미만</option>
                                                        <option value="1년 이상 3년 미만">1년 이상 3년 미만</option>
                                                        <option value="3년 이상 5년 미만">3년 이상 5년 미만</option>
                                                        <option value="5년 이상 10년 미만">5년 이상 10년 미만</option>
                                                        <option value="10년 이상">10년 이상</option>
                                                    </select> 
                                                </td>
            
                                                <td class="table_list_add">
                                                    <select class="work_input" name="work4" id="work4" >
                                                    	<option value='Y'>재직 중 </option>
                                                    	<option value='N'>재직 안함</option>
                                                    </select>
                                                </td>
            									
                                            </tr>

                                            <tr name="tableList">
                                                <td class="table_list_add"><input class="companyName_input" data-validation="required" name="title5" id="title5" required="required" type="text"></td>
            
                                                <td class="table_list_add">
                                                    <select class="field_input" data-validation="required" name="field5" id="field5" required="required">
                                                        <option selected="selected" value>분야</option>
                                                        <option value="개발">개발</option>
                                                        <option value="디자인/영상">디자인/영상</option>
                                                        <option value="기획">기획</option>
                                                        <option value="기타">기타</option>
                                                    </select>
                                                </td>
            
                                                <td class="table_list_add">
                                                    <select class="position_input" data-validation="required" name="position5" id="position5" required="required">
                                                        <option selected="selected" value>직위</option>
                                                        <option value="사원">사원</option>
                                                        <option value="주임">주임</option>
                                                        <option value="대리">대리</option>
                                                        <option value="과장">과장</option>
                                                        <option value="차장">차장</option>
                                                        <option value="부장">부장</option>
                                                        <option value="이사">이사</option>
                                                        <option value="상무">상무</option>
                                                        <option value="전무">전무</option>
                                                        <option value="부사장">부사장</option>
                                                        <option value="사장">사장</option>
                                                    </select> 
                                                </td>
            
                                                
                                                <td class="table_list_add">
                                                    <select class="career_input" data-validation="required" name="career5" id="career5" required="required">
                                                        <option selected="selected" value>경력</option>
                                                        <option value="1년 미만">1년 미만</option>
                                                        <option value="1년 이상 3년 미만">1년 이상 3년 미만</option>
                                                        <option value="3년 이상 5년 미만">3년 이상 5년 미만</option>
                                                        <option value="5년 이상 10년 미만">5년 이상 10년 미만</option>
                                                        <option value="10년 이상">10년 이상</option>
                                                    </select> 
                                                </td>
            
                                                <td class="table_list_add">
                                                    <select class="work_input" name="work5" id="work5" >
                                                    	<option value='Y'>재직 중 </option>
                                                    	<option value='N'>재직 안함</option>
                                                    </select>
                                                </td>
            								
            									
            
            
                                            </tr>
                                            
                                            
                                          	  <%} %>
                                        </tbody>
                                    </table>
                                    <ul>
                                        <li>
                                        </li>
                                    </ul>
            
                                    <div class="bottom_class">
                                        <p class="btn">
                                            <button class="btn_cancel" type="button"><a href="/win/page/myPage1.jsp" class="btncancel">취소</a></button>
                                           <%if(clist.isEmpty() ) {%>
                                            <button class="submit_button">등록 완료</a></button>
                                            <%} else{%>
                                            <button class="submit_button">수정 완료</a></button>
                                            <%} %>
                                        </p>
                                    </div>
                                </form>
                            </section>
            
                        </div>


                </div>

        



        </div>
    </div>
    
    
    <script>
    
   
    <%for(Career cc : clist){%>
   	for(var i=0;i<5;i++){
   	   <%String field = "field"+count2;%>
			if(document.getElementById("<%=field%>").children[i].value == '<%=cc.getCa_work()%>'){
			document.getElementById("<%=field%>").children[i].selected=true;
			}
			<%=count2++%>
   	}
		
    <%}%>
    <%for(Career cc : clist){%>
  	for(var i=0;i<11;i++){
  	   <%String position = "position"+count3;%>
			if(document.getElementById("<%=position%>").children[i].value == '<%=cc.getCa_rank()%>'){
			document.getElementById("<%=position%>").children[i].selected=true;
			}
			<%=count3++%>
  	}
		
   <%}%>
   
   <%for(Career cc : clist){%>
 	for(var i=0;i<5;i++){
 	   <%String career = "career"+count4;%>
			if(document.getElementById("<%=career%>").children[i].value == '<%=cc.getCa_exper()%>'){
			document.getElementById("<%=career%>").children[i].selected=true;
			}
			<%=count4++%>
 	}
		
  <%}%>
 
  <%for(Career cc : clist){%>
	for(var i=0;i<2;i++){
	   <%String work = "work"+count5;%>
			if(document.getElementById("<%=work%>").children[i].value == '<%=cc.getStatus()%>'){
			document.getElementById("<%=work%>").children[i].selected=true;
			}
			<%=count5++%>
	}
		
<%}%>

  
    
    </script>
    
    
    
    <script>
      
        
	    $(function() {
       		$('#fileArea').hide();
       		
       		$('#developer_img_con').click(() => {
    			$('#thumbnailImg1').click();
    		});
       	});
       function profileon(){
    	  document.getElementById('profilea').submit();
       }
       	
       	
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