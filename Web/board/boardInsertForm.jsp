<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="win.model.vo.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <link rel="stylesheet" href="/win/css/boardWrite.css">
<title>Insert title here</title>
</head>

<body>
<%-- 	<%@ include file="../common/header.jsp" %> --%>
<%-- 	<% if (m != null) { %> --%>
    <div class="page">
        <div class="page_inner">
            <div class="sidebar">
                <ul class="how_sidebar">
                     <li class="notice"><a href="/win/selectList.no" class="list">공지사항</a></li>
                    <li class="board"><a href="/win/selectList2.bo"  class="list">게시판</a></li>
                    <li class="Q_A"><a href="/win/board/board_write.jsp"  class="list">자주 묻는 질문</a></li>

                </ul>
            </div>

            <form action="<%= request.getContextPath() %>/bInsert2.bo"  method="post" enctype="multipart/form-data"  id="setRows">
                <div class="write_main">
                    <div class="write_title_div">
                        <h3 class="write_title_text">게시판 작성</h3>
                        <p class="write_title_ment">사용하시면서 불편했던 부분 또는  개선해야할 부분과 사이트를 이용하면서 궁금했던 부분을 작성해주세요.</p>
                    </div>        
                            <div class="mypCotent">
                                <div class="title_div1">
                                    <label class="dContent_label" for="tInput">제목</label>
                                    <input class="title_input" id="title" name="title" type="text">
                                </div>

                                <div class="title_div1">
                                    <label class="dContent_label" for="tInput">작성자</label>
                                    <input class="title_input1" id="userId" name="writer" type="text" value="shining"<%-- value=<%=m.getName() %> --%>> 
                                </div>

                                <div class="title_div1">
                                    <label class="dContent_label">첨부파일 </label>
                                    <label for="attachFile" class="title_label1">첨부파일</label>
                                    <input class="InFile" id="attachFile" name="file" type="file">
                                </div>
                                
                                <div class="detail_content_div">
                                    <table>
                                        <tbody>
                                            <tr>
                                                <td>
                                                    <label class="dContent_label" for="cInput">내용</label>
                                                </td>
                                                <td>
                                                    <textarea class="dContent_textarea" name="content" rows="12" style="resize: none;"></textarea>
                                                </td>
                                            </tr>

                      
                                        </tbody>
                                    </table>
                                </div>
        
                                <div class="sub_btn">
                                    <button type="submit" class="input_btn">등록</button>
                                    <button type="reset" name="cancel" class="cancel_btn"><a class="cancel_btn">취소</a></button>
                                </div>
                            </div>
        
        
                        </div>
        
                    </form>


                        </div>
                    </div>
                </div>
             </form>
<%-- 	<% } else { 
		request.setAttribute("msg", "회원만 열람 가능합니다.");
		request.getRequestDispatcher("../common/errorPage.jsp").forward(request, response);
	 } %> --%>
</body>
</html>