<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="win.model.vo.*"%>
<%
	Notice n = (Notice)request.getAttribute("notice");
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
</head>
<body>
<%@ include file="/views/common/header.jsp" %>
<div class="page">
        <div class="page_inner">
            <div class="sidebar">
                <ul class="how_sidebar">
                    <li class="notice"><a href="/win/selectList.no" class="list">공지사항</a></li>
                    <li class="board"><a href="/win/selectList2.bo"  class="list">게시판</a></li>
                    <li class="Q_A"><a href="/win/board/board_write.jsp"  class="list">자주 묻는 질문</a></li>

                </ul>
            </div>


            <form method="POST" id="setRows">
                <div class="write_main">
                    <div class="write_title_div">
                        <h3 class="write_title_text">공지사항</h3>
                        <!-- <p class="write_title_ment">사용하시면서 불편했던 부분 또는  개선해야할 부분과 사이트를 이용하면서 궁금했던 부분을 작성해주세요.</p> -->
                    </div>        
                            <div class="mypCotent">
                                <div class="title_div1">
                                    <label class="dContent_label" for="tInput">제목</label>
                                    <input class="title_input" id="title" name="title" type="text" readonly value=<%=n.getNtitle() %>>
                                </div>

                                <div class="title_div1">
                                    <label class="dContent_label" for="tInput">작성자</label>
                                    <input class="title_input1" id="writer" name="writer" type="text" readonly value=<%=n.getNwriter() %>>
                                </div>
                                
                               <div class="title_div1">
                                    <label class="dContent_label" for="tInput">작성일</label>
                                    <input class="title_input1" id="writer" name="date" type="text" readonly value=<%=n.getNdate() %>>
                                </div>
                                
                                
                                <div class="detail_content_div">
                                    <table>
                                        <tbody>
                                            <tr>
                                                <td style="border-bottom: none;">
                                                    <label class="dContent_label" for="cInput">내용</label>
                                                </td>
                                                <td style="border-bottom: none; margin-bottom:50px">
                                                    <textarea class="dContent_textarea" name="content" rows="12" style="resize: none; margin-bottom: 60px;" readonly><%=n.getNcontent() %></textarea>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                             </div>
                           </div>
                        </form>
                    </div>
      			</div>
</body>
</html>