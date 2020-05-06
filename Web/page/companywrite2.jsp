<%@page import="win.board.model.vo.Introduce"%>
<%@page import="win.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Member m = (Member)session.getAttribute("member");
	/* session.setMaxInactiveInterval(1000);*/
	
	Introduce in =(Introduce)session.getAttribute("in");
	
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/win/css/mypagewrite.css">
    <link rel="stylesheet" href="/win/css/mainpagecss.css">
    <!-- <link rel="stylesheet" href="css/write1.css"> -->
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <title>자기소개 등록 후</title>
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
                    <div class="developer_body_img">
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
                        <li class="sidebar_list"><a href="/win/page/changeInfo_com.jsp" class="sidebar_info">개인정보수정</a></li>
                    </ul>
                </div>
              <!--   <div class="sidebar_bottom">
                    <ul class="sidebar_bot">
                        <li class="sidebar_list"><a href="/win/page/companysurvey.jsp"  class="sidebar_info">평가</a></li>
                    </ul>
                </div> -->

               <!--  <div class="sidebar_bottom">
                    <ul class="sidebar_bot">
                        <li class="sidebar_list"><a href="/win/page/companysurvey_commit.jsp"  class="sidebar_info">평가등록</a></li>
                    </ul>
                </div> -->
            </div>
		<% if (m != null) { %>
           <form action="<%= request.getContextPath() %>/bInsert.bo" 
			      method="post" enctype="multipart/form-data">
                <div class="write_main">
                    <div class="write_title_div">
                    <input type="hidden" name=no value="<%=m.getNo() %>">
                        <input type="hidden" name=memberType value="<%=m.getMemberType() %>">
                        <h3 class="write_title_text">자기소개</h3>
                    </div>

                    <div class="mypCotent">
                        <div class="title_div">
                            <label class="title_label" for="tInput">제목</label>
                            <input class="title_input" id="tInput" name="title" type="text" value="<%=in.getIn_title() %>">
                        </div>
                        
                        <div class="detail_content_div">
                            <table>
                                <tbody>
                                    <tr>
                                        <td>
                                            <label class="dContent_label" for="cInput">내용</label>
                                        </td>
                                        <td>
                                             <textarea class="dContent_textarea" name="content"  rows="12" style="resize: none;" > <%=in.getIn_content()%> </textarea> 
                                        <%--    <input class="dContent_textarea" id="tInput" name="content" type="text" value="<%=in.getIn_content()%>">
         --%>                                </td>
                                    </tr>
                                    <tr>

                                    </tr>
              
                                </tbody>
                            </table>
                        </div>

                        <div class="sub_btn">
                            <button type="submit" name="input" class="input_btn">등록</button>
                           <input type="reset" name="cancel" class="cancel_btn" value="취소" onclick="history.back();">
                        </div>
                    </div>


                </div>

            </form>

        </div>
    </div>
    
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
    function logout(){
			location.href="/win/logout.me";
		}
    
    function del(){
		location.href="/win/mUpdate2.me";
	}
   </script>
    <% } %>
</body>
</html>