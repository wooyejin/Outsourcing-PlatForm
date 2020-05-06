<%@page import="java.util.ArrayList"%>
<%@page import="win.board.model.vo.Skill"%>
<%@page import="win.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
   Member m = (Member)session.getAttribute("member");
 
 int count = 1;
 int count2 = 1;
 int count3 = 1;
 ArrayList<Skill> slist = (ArrayList<Skill>)session.getAttribute("slist");
   	
   /* session.setMaxInactiveInterval(1000);*/
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/win/css/mypagetechnology.css">
    <link rel="stylesheet" href="/win/css/mainpagecss.css">
    <title>보유 기술 등록창</title>
    <!-- <script src="https://code.jquery.com/jquery-1.10.2.js"></script> -->
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
                    <input type="hidden" name=no value="<%=m.getNo() %>">
                        <input type="hidden" name=memberType value="<%=m.getMemberType() %>">
                        <h3 class="write_title_text">보유기술</h3>
                    </div>

                    <div class="mypCotent">
                       
                        <div class="content_inner">
                            <section class="tech_content_title">
                                <h3 class="content_title">보유 기술 등록
                                    <p class="content_ment">최대 5개 까지 등록 가능합니다.
                              
                                    </p>
                                </h3>
                            </section>
                            <section>
                              
                                    <input name="sort" type="hidden">
                                  <form action="/win/mSkill.me" id="frm" method="post">  
                                    <table id="table_skill" class="table_skill" >
                                        <thead>
                                            <tr>
                                                <th class="table_width_sort"><span class="star">*</span>종류</th>
                                                <th class="table_width_workmanship"><span class="star">*</span>숙련도</th>
                                                <th class="table_width_experience"><span class="star">*</span>경험</th>
                                            </tr>
                                        </thead>
            
                                        <tbody id="skill_inventory">
                                      
                                       <%if(!slist.isEmpty()){ %>
                                        <%for (Skill ss : slist ) { %>
                                        <%String title = "title"+count;%>
                                        <%String workmanship = "workmanship"+count;%>
                                        <%String experience = "experience"+count;%>
                                       	  <input type="hidden" value="<%= count++ %>"> 
                                            <tr name="tableList">
                                                <td class="table_list_add"><input class="sort_input"name="<%=title %>" id="<%=title %>" type="text" value="<%=ss.getS_name() %>"></td>

                                                <td class="table_list_add">
                                                    <select class="workmanship_input" data-validation="required" name="<%=workmanship%>" id="<%=workmanship %>" required="required">
                                                        <option value="숙련도">숙련도</option>
                                                        <option value="관심있음">관심있음</option>
                                                        <option value="초급">초급</option>
                                                        <option value="중급">중급</option>
                                                        <option value="고급">고급</option>
                                                    </select>
                                                </td>
                                                <td class="table_list_add">
                                                    <select class="experience_input" data-validation="required" name="<%=experience %>" id="<%=experience %>" required="required">
                                                        <option selected="selected">경험</option>
                                                        <option value="1년 미만">1년 미만</option>
                                                        <option value="1년 이상 3년 미만">1년 이상 3년 미만</option>
                                                        <option value="3년 이상 5년 미만">3년 이상 5년 미만</option>
                                                        <option value="5년 이상 10년 미만">5년 이상 10년 미만</option>
                                                        <option value="10년 이상">10년 이상</option>
                                                    </select> 
                                                </td>
                                                
                                            </tr>
                                            
                                            	<% } %>
                                            	<%}else{ %>
                                            	  <tr name="tableList">
                                                <td class="table_list_add"><input class="sort_input"name="title1" id="title1" type="text"></td>
                                                
                                                
                                                <td class="table_list_add">
                                                    <select class="workmanship_input" data-validation="required" name="workmanship1" id="workmanship1" required="required">
                                                        <option selected="selected">숙련도</option>
                                                        <option value="관심있음">관심있음</option>
                                                        <option value="초급">초급</option>
                                                        <option value="중급">중급</option>
                                                        <option value="고급">고급</option>
                                                    </select>
                                                </td>
            
                                                <td class="table_list_add">
                                                    <select class="experience_input" data-validation="required" name="experience1" id="experience1" required="required">
                                                        <option selected="selected">경험</option>
                                                        <option value="1년 미만">1년 미만</option>
                                                        <option value="1년 이상 3년 미만">1년 이상 3년 미만</option>
                                                        <option value="3년 이상 5년 미만">3년 이상 5년 미만</option>
                                                        <option value="5년 이상 10년 미만">5년 이상 10년 미만</option>
                                                        <option value="10년 이상">10년 이상</option>
                                                    </select> 
                                                </td>
                                            </tr>
                                            
                                            <tr name="tableList">
                                                <td class="table_list_add"><input class="sort_input" data-validation="required" name="title2" id="title2" required="required" type="text"></td>
                                                
                                                <td class="table_list_add">
                                                    <select class="workmanship_input" data-validation="required" name="workmanship2" id="workmanship2" required="required">
                                                        <option selected="selected">숙련도</option>
                                                        <option value="관심있음">관심있음</option>
                                                        <option value="초급">초급</option>
                                                        <option value="중급">중급</option>
                                                        <option value="고급">고급</option>
                                                    </select>
                                                </td>
            
                                                <td class="table_list_add">
                                                    <select class="experience_input" data-validation="required" name="experience2" id="experience2" required="required">
                                                        <option selected="selected">경험</option>
                                                        <option value="1년 미만">1년 미만</option>
                                                        <option value="1년 이상 3년 미만">1년 이상 3년 미만</option>
                                                        <option value="3년 이상 5년 미만">3년 이상 5년 미만</option>
                                                        <option value="5년 이상 10년 미만">5년 이상 10년 미만</option>
                                                        <option value="10년 이상">10년 이상</option>
                                                    </select> 
                                                </td>
            
            
                                            </tr>

                                            <tr name="tableList">
                                                <td class="table_list_add"><input class="sort_input" data-validation="required" name="title3" id="title3" required="required" type="text"></td>
                                                
                                                <td class="table_list_add">
                                                    <select class="workmanship_input" data-validation="required" name="workmanship3" id="workmanship3" required="required">
                                                       <option selected="selected">숙련도</option>
                                                        <option value="관심있음">관심있음</option>
                                                        <option value="초급">초급</option>
                                                        <option value="중급">중급</option>
                                                        <option value="고급">고급</option>
                                                        
                                                    </select>
                                                </td>
            
                                                <td class="table_list_add">
                                                    <select class="experience_input" data-validation="required" name="experience3" id="experience3" required="required">
                                                         <option selected="selected">경험</option>
                                                        <option value="1년 미만">1년 미만</option>
                                                        <option value="1년 이상 3년 미만">1년 이상 3년 미만</option>
                                                        <option value="3년 이상 5년 미만">3년 이상 5년 미만</option>
                                                        <option value="5년 이상 10년 미만">5년 이상 10년 미만</option>
                                                        <option value="10년 이상">10년 이상</option>
                                                    </select> 
                                                </td>
                                                
               
                                            </tr>

                                            <tr name="tableList">
                                                <td class="table_list_add"><input class="sort_input" data-validation="required" name="title4" id="title4" required="required" type="text"></td>
                                                
                                                <td class="table_list_add">
                                                    <select class="workmanship_input" data-validation="required" name="workmanship4" id= "workmanship4" required="required">
                                                       <option selected="selected">숙련도</option>
                                                        <option value="관심있음">관심있음</option>
                                                        <option value="초급">초급</option>
                                                        <option value="중급">중급</option>
                                                        <option value="고급">고급</option>
                                                    </select>
                                                </td>
            
                                                <td class="table_list_add">
                                                    <select class="experience_input" data-validation="required" name="experience4" id="experience4" required="required">
                                                         <option selected="selected">경험</option>
                                                        <option value="1년 미만">1년 미만</option>
                                                        <option value="1년 이상 3년 미만">1년 이상 3년 미만</option>
                                                        <option value="3년 이상 5년 미만">3년 이상 5년 미만</option>
                                                        <option value="5년 이상 10년 미만">5년 이상 10년 미만</option>
                                                        <option value="10년 이상">10년 이상</option>
                                                    </select> 
                                                </td>

                                            </tr>

                                            <tr name="tableList">
                                                <td class="table_list_add"><input class="sort_input" data-validation="required" name="title5" id="title5" required="required" type="text"></td>
                                                
                                                <td class="table_list_add">
                                                    <select class="workmanship_input" data-validation="required" name="workmanship5" id="workmanship5" required="required">
                                                        <option selected="selected">숙련도</option>
                                                        <option value="관심있음">관심있음</option>
                                                        <option value="초급">초급</option>
                                                        <option value="중급">중급</option>
                                                        <option value="고급">고급</option>
                                                    </select>
                                                </td>
            
                                                <td class="table_list_add">
                                                    <select class="experience_input" data-validation="required" name="experience5" id="experience5" required="required">
                                                         <option selected="selected">경험</option>
                                                        <option value="1년 미만">1년 미만</option>
                                                        <option value="1년 이상 3년 미만">1년 이상 3년 미만</option>
                                                        <option value="3년 이상 5년 미만">3년 이상 5년 미만</option>
                                                        <option value="5년 이상 10년 미만">5년 이상 10년 미만</option>
                                                        <option value="10년 이상">10년 이상</option>
                                                    </select> 
                                                </td>
                                                

                                            </tr>
                                            	<%} %>
                                        </tbody>
                                    </table>
                                   
            						<% if(slist.isEmpty()){ %>
                                    <div class="bottom_class">
                                        <p class="btn">
                                            <button class="btn_cancel"type="reset"><a href="/win/page/myPage1.jsp" class="btncancel">취소</a></button>
                                            <button  class="submit_button">등록 완료</button>
                                        </p>
                                    </div>
                                    </form> 
                                    <%} else {%>
                                     <form> 
                                    <div class="bottom_class">
                                        <p class="btn">
                                            <button class="btn_cancel"type="reset"><a href="/win/page/myPage1.jsp" class="btncancel">취소</a></button>
                                            <button class="submit_button">수정 완료</button>
                                        </p>
                                    </div>
                                    <%} %>
                                      </form> 
                            </section>




                    </div>


                </div>
      </div>
            </div>
          </div>
          	
          <script>
          
          
      	$('#table_skill td').click(function(){
      		 title = $(this).parent().find('input').eq(0).val();
      		 work = $(this).parent().find('select').eq(0).val();
      		 ex = $(this).parent().find('select').eq(1).val();
      		 
      	
      		/* location.href="/win/sDelete.sk?title="+title+"&work="+work; */
      		
      	});
 
      	
          
          </script>
          
        
           <script>
           <%for(Skill sss : slist){%>
          	for(var i=0;i<5;i++){
          	   <%String workmanship = "workmanship"+count2;%>
				if(document.getElementById("<%=workmanship%>").children[i].value == '<%=sss.getS_lev()%>'){
				document.getElementById("<%=workmanship%>").children[i].selected=true;
				}
				<%=count2++%>
          	}
			
           <%}%>
           <%for(Skill sss : slist){%>
         	for(var i=0;i<5;i++){
         	   <%String experience = "experience"+count3;%>
				if(document.getElementById("<%=experience%>").children[i].value == '<%=sss.getS_ex()%>'){
				document.getElementById("<%=experience%>").children[i].selected=true;
				}
				<%=count3++%>
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
      </script>
  
</body>
</html>