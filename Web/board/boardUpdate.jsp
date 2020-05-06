<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="win.model.vo.*, java.util.*" %>
<% Board b = (Board)request.getAttribute("board");
   // 댓글 리스트
   ArrayList<BoardComment> clist
   	= (ArrayList<BoardComment>)request.getAttribute("clist");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/win/css/board.css">
<link rel="stylesheet" href="/win/css/survey.css">
<title>Insert title here</title>
<script>
             function goboard(){
            	 location.href='/win/bUpdate.bo';
             }
             
             // 업데이트용
             function updateBoard(){
            	 $('#updateForm').attr("action","/win/bUpdate.bo").submit();
             }
             
             // 삭제용
             function deleteBoard(){
            	 $('#updateForm').attr("action","/win/bDelete.bo").submit();
             }
</script>            
</head>
<body>
	<div class="page">
<%@ include file="/views/common/header.jsp" %>	
        <div class="page_inner">
            <div class="sidebar">
                <ul class="how_sidebar">
                    <li class="notice"><a href="/win/selectList.no" class="list">공지사항</a></li>
                    <li class="board"><a href="/win/selectList2.bo"  class="list">게시판</a></li>
                    <li class="Q_A"><a href="#"  class="list">자주 묻는 질문</a></li>
                </ul>
            </div>


            <form  method="POST" id="updateForm">
                <div class="write_main">
                    <div class="write_title_div">
                        <h3 class="write_title_text">게시판 작성</h3>
                        <p class="write_title_ment">사용하시면서 불편했던 부분 또는  개선해야할 부분과 사이트를 이용하면서 궁금했던 부분을 작성해주세요.</p>
                    </div>        
                            <div class="mypCotent">
                                <div class="title_div1">
                                    <label class="dContent_label" for="tInput">제목</label>
                                    <input class="title_input" id="title" name="title" type="text"  style="margin-left:40px" value=<%=b.getBtitle() %>>
                                </div>

                                <div class="title_div1">
                                    <label class="dContent_label" for="tInput">작성자</label>
                                    <input class="title_input" id="writer" name="writer" type="text" readonly value=<%=b.getBwriter() %>>
                                </div>

                                
                                <div class="title_div1">
                                    <label class="dContent_label" for="tInput">작성일</label>
                                    <input class="title_input" id="date" name="date" type="text"  readonly value=<%=b.getBdate() %>>
                                </div>

                                <div class="title_div1">
                                    <label class="dContent_label" for="tInput">조회수</label>
                                    <input class="title_input" id="count" name="count" type="text" value=<%=b.getBcount() %>>
                                </div>
 
							 <%if(b.getBoardfile() != null && b.getBoardfile().length() > 0){ %>  
                                <div class="title_div1">
                                    <label class="dContent_label">첨부파일 </label>
                                    <!-- <label for="attachFile" class="title_label1">첨부파일</label> -->
                                    <div id="filediv">
                                    
                                   		 <a style="margin-left:100px;" href="/semi/bfdown.bo?path=<%=b.getBoardfile() %>"><%=b.getBoardfile() %></a>
                                    	 <a href="#this"  id="delete" name="delete" style="margin-left:10px; magin-top:50px; width:100px; height:50px;"><button class="cancel_btn">삭제</button></a>
                                    	<!-- <button type="reset" name="delete" id="deleteimg" class="cancel_btn" onclick ="deleteimg();"style="margin-left:10px; magin-top:50px;">삭제</button><Br> -->
                                    
                                    </div>
                                    <input id="attachFile" name="file" type="file" style="margin-left:100px;">
                                </div>
                                <% } %>
                                
                                <div class="detail_content_div">
                                    <table>
                                        <tbody>
                                            <tr>
                                                <td style="border-bottom:none">
                                                    <label class="dContent_label" for="cInput">내용</label>
                                                </td>
                                                <td style="border-bottom:none">
                                                    <textarea class="dContent_textarea" name="content" rows="12" style="resize: none; margin-left:40px"><%=b.getBcontent()%></textarea>
                                                </td>
                                            </tr>

                      
                                        </tbody>
                                    </table>
                                </div>
        
                                <div class="sub_btn">
   <%--                              	<% if(m != null && m.getUserId().equals(b.getBwriterId())) %> --%>
                                    <input type="submit" name="input" id="btnInput" class="input_btn" onclick="updateBoard();" value="수정완료">
       <%--                              <% } %> --%>
                                    <button type="submit" name="delete" class="cancel_btn" onclick="deleteBoard();">삭제</button> 
                                    <button type="reset" name="cancel" class="cancel_btn">취소</button>
                                </div>
                            </div>
        						<input type="hidden" name="bno" value="<%=b.getBno() %>">
       		                </div>	
                  		</form>
                     </div>
                  </div>
                  
                  <script>
                  $(document).ready(function(){         
                      $("a[name='delete']").on("click", function(e){ //삭제 버튼
                         e.preventDefault();
                         fn_deleteFile($(this));
                      });
                   });      
                   
                   function fn_deleteFile(obj){
                      obj.parent().remove();
                   }
                  </script>
  
</body>
</html>