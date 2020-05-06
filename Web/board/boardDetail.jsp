<%@page import="admin.qna.model.vo.Qna"%>
<%@page import="admin.qna.model.service.QnaService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="win.model.vo.*, java.util.*" %>
<%

Board b = (Board)request.getAttribute("board");
Board bo = (Board)session.getAttribute("board2");

   // 댓글 리스트
   ArrayList<BoardComment> clist
   	= (ArrayList<BoardComment>)request.getAttribute("clist");
   
   ArrayList<Qna> qlist = new ArrayList<Qna>(); 
   QnaService qs = new QnaService();
   qlist = qs.readQna();
   String answer = "";
   
   for(Qna q : qlist){
	
	   if(q.getqWriter().equals(b.getBwriter())){
			answer = q.getqA();
	   }
   }
  		
   
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <link rel="stylesheet" href="/win/css/board.css">
    <link rel="stylesheet" href="/win/css/survey.css">
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script><!-- 검색기능 -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>Insert title here</title>
 <script>
             function goUpdate(){
            	 $('#setRows').attr('action','/win/bUpView.bo?bno='+<%= request.getParameter("bno")%>).submit();
             }
             
             function gomain(){
     			location.href='/views/board/boardList.jsp';
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
                    <li class="Q_A"><a href="/win/board/board_write.jsp"  class="list">자주 묻는 질문</a></li>

                </ul>
            </div>


             <form  method="POST" id="setRows">
                 <div class="write_main">
                    <div class="write_title_div">
                        <h3 class="write_title_text">게시판 작성</h3>
                        <p class="write_title_ment">사용하시면서 불편했던 부분 또는  개선해야할 부분과 사이트를 이용하면서 궁금했던 부분을 작성해주세요.</p>
                    </div>        
                            <div class="mypCotent" style = "margin-bottom : 50px">
                                <div class="title_div1">
                                    <label class="dContent_label" for="tInput">제목</label>
                                    <input class="title_input" id="title" name="title" type="text" readonly style="margin-left:40px" value=<%=b.getBtitle() %>>
                                </div>

                                <div class="title_div1">
                                    <label class="dContent_label" for="tInput">작성자</label>
                                    <input class="title_input" id="writer" name="writer" type="text"  readonly value=<%=b.getBwriter() %>>
                                </div>

                                
                                <div class="title_div1">
                                    <label class="dContent_label" for="tInput">작성일</label>
                                    <input class="title_input" id="date" name="date" type="text" readonly value=<%=b.getBdate() %>>
                                </div>

                                <div class="title_div1">
                                    <label class="dContent_label" for="tInput">조회수</label>
                                    <input class="title_input" id="count" name="count" type="text" readonly value=<%=b.getBcount() %>>
                                </div>
 
							 <%if(b.getBoardfile() != null && b.getBoardfile().length() > 0){ %>  
                                <div class="title_div1">
                                    <label class="dContent_label">첨부파일 </label>
                           <!--          <label for="attachFile" class="title_label1">첨부파일</label> -->
                           			<a style="margin-left:20px;" href="/win/bfdown2.bo?path=<%=b.getBoardfile() %>"><%=b.getBoardfile() %></a>
                                   <!--  <input id="attachFile" name="file" type="file" style="margin-left:20px;"> -->
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
                                                    <textarea class="dContent_textarea" name="description" rows="12" style="resize: none; margin-left:40px" readonly><%=b.getBcontent()%></textarea>
                                                </td>
                                            </tr>

                      
                                        </tbody>
                                    </table>
                                </div>
        
                                <div class="sub_btn">
									<%if(m.getUserId().equals(b.getBwriter())) {%>
                                    <button type="submit" name="input" class="input_btn" onclick="goUpdate()">수정하기</button>
									<%} %>
                                    <button type="reset" name="cancel" class="cancel_btn" onclick="goboard();">취소</button>
                                </div>
                            </div>
        
        					<hr style="border: 1px dashed #dedede; ">
        
                        </div>
        
                     </form>
                    </div>
                 </div>

             <div class="title_div1">
             	<div class="replywrite">
             		<form action="insertComment.bo" method="post">
             			<input type ="hidden" name="writer"  value="<%=m.getUserId()%>"/>
             			<input type = "hidden" name="bno" value="<%=b.getBno()%>">
                		<table>
                    		<tbody>
                        		<tr>
                            		<td style="border-bottom:none;">
             
                                		<label class="dContent_label" for="cInput" style="margin-left:380px; margin-bottom: 50px">답변</label>
										
                            		</td>   
                            		<td style="border-bottom:none;">
                                		<textarea class="ment_textarea" name="replyContent" rows="5" style="resize: none;  margin-top:30px;border: 1px solid #dedede; border-radius: 5px;width: 800px;height: 130px;margin-left: 30px;margin-bottom: 30px;" readonly><%=answer %></textarea><br>
										<!-- <textarea class="ment_textarea" name="replyContent" rows="5" style="resize: none;  margin-top:30px;border: 1px solid #dedede; border-radius: 5px;width: 800px;height: 40px;margin-left: 30px;margin-bottom: 30px;">댓글을 입력하세요</textarea><br> -->
                                			
                                		
                            		</td>
                          		<!-- <td style="border-bottom:none;"><button type="submit" id="addReply" class="input_btn" style="top: 78px;
																position: relative;">등록</button></td> -->
                       			</tr>
                    		</tbody>
               	 		</table>
                		</form>
                	</div>
                	<div>
                	<% if (clist != null) { %>
						<% for(BoardComment bco : clist) { %>
				
					<table id="replySelectTable" class="replyList">
						
		  					<tr>
		  					<td rowspan="5" style="border-bottom:none;"> </td>
<%-- 							<td style="border-bottom:none;"><b><%= bco.getCwriter() %></b></td>
							<td style="border-bottom:none;"><%= bco.getCdate() %></td>
							<td style="border-bottom:none;"><%= bco.getCcontent() %></td> --%>
							
							
							<tbody>
                        		<tr>
                        			<td style="border-bottom:none;">
										<input type="text" style="display:none;"  id="cno" value="<%=bco.getCno() %>">
										<%-- <label style=" margin-left:380px; border-top:1px dashed #dedede; font-weight: 600;"><%=bco.getCwriter()%></label> --%>
									</td>
                            		<td style="border-bottom:none;">
                                		<label class="dContent_label" for="cInput" style="margin-left:380px; text-align:center;"><%=bco.getCwriter()%></label><Br>
										<label class="dContent_label" for="cInput" style="margin-left:365px; font-size:0.6rem;"><%=bco.getCdate() %></label>
                            		</td>
                            		<td style="border-bottom:none;">
                                		<textarea class="ment_textarea" name="description" rows="12" style="resize: none; border: 1px solid #dedede; border-radius: 5px;width: 800px;height: 130px;margin-left: 16px;margin-bottom: 30px;" readonly><%=bco.getCcontent() %></textarea>
                            		</td>
                            		
                            		<td style="border-bottom:none;">
										<button type="button" class="input_btn" onclick="deleteReply(this);">삭제</button>
									</td>
								
                        		</tr>
                   	 		</tbody>
						
						</tr>
					</table>

						<%} %>
					<% } %>
            	</div>
             </div>
             
             <script>
         		function deleteReply(obj) {
        			// 댓글의 번호 가져오기
        			var cno = $("#cno").val();
        			console.log(cno);
        			
        		
        			// 게시글 번호 가져오기
        			var bno = '<%=b.getBno()%>';
        		
        			location.href="/win/deleteComment.bo"+"?cno="+cno+"&bno="+bno;
        		}
         		
         		function goboard() {
         			location.href="/win/selectList2.bo";
         		}
             </script>
            
</body>
</html>