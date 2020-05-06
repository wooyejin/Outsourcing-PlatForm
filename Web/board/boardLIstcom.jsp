<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="win.model.vo.*, java.util.*"%>
<% 
	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
	/* PageInfo pi = (PageInfo)request.getAttribute("pi");
	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage(); */
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



                <div class="write_main">
                    <div class="write_title_div">
                        <h3 class="write_title_text">Q&A-개발자 </h3>
                        <p class="write_title_ment">사용하시면서 불편했던 부분 또는  개선해야할 부분과 사이트를 이용하면서 궁금했던 부분을 작성해주세요.</p>
                    </div>

                    <div class="mypCotent">
                        <div class="title_div">
                            <fieldset>
                                <input type="text" class="tbox" title="검색어를 입력해주세요" placeholder="검색어를 입력해주세요" id="keyword">
                                <a href="javascript:;" class="btn_srch">검색</a>
                            </fieldset>

                            <table class="table" id="user_table">
                                <thead>
                                    <tr>
                                        <th class="col">번호</th>
                                        <th class="colT">제목</th>
                                        <th class="col">작성자</th>
                                        <th class="col">작성일</th>
                                        <th class="col">조회수</th>
                                        <th class="col">첨부파일</th>
                                    </tr>
                                </thead>
                               
                                <tbody class="item">
                                 <% for(Board b : list){ %>
                                    <tr>
                                   <input type="hidden" value="<%= b.getBno() %>"/> 
                                        <td><%=b.getBno() %></td>
                                        <td><%=b.getBtitle() %></td>
                                        <td><%=b.getBwriter() %></td>
                                        <td><%=b.getBdate() %></td>
                                        <td><%=b.getBcount() %></td>
                                        <% if( b.getBoardfile() != null) { %>
                                        <td> O </td>
                                        <%} else { %>
                                        <td> X</td>
                                    </tr>
                                     <% } %>
                                    
                                </tbody>
                                <% } %>
                            </table>


                            <ul class="pagination">
    
                            </ul>

                            
                            <div class="write">
                         <%--    <% if(m != null){ %> --%>
                                <button onclick="location.href='/win/board/boardInsertForm.jsp'" class="write_btn">작성하기</button>
                        <%--     <% } %> --%>
                            </div>


                        </div>
                    </div>
                </div>
                </div>
                </div>

		

             <script type="text/javascript">
                 // 검색기능
                $(document).ready(function() {
                    $("#keyword").keyup(function() {
                        var k = $(this).val();
                        $("#user_table > tbody > tr").hide();
                        var title = $("#user_table > tbody > tr > td:nth-child(4n+2):contains('" + k + "')");

                        $(title).parent().show();
                    })
                });


                function pagination(){
				var req_num_row=5;
				var $tr=jQuery('tbody tr');
				var total_num_row=$tr.length;
				var num_pages=0;
				if(total_num_row % req_num_row ==0){
					num_pages=total_num_row / req_num_row;
				}
				if(total_num_row % req_num_row >=1){
					num_pages=total_num_row / req_num_row;
					num_pages++;
					num_pages=Math.floor(num_pages++);
				}
  
    			jQuery('.pagination').append("<li><a class=\"prev\">Previous</a></li>");
  
				for(var i=1; i<=num_pages; i++){
					jQuery('.pagination').append("<li><a>"+i+"</a></li>");
      				jQuery('.pagination li:nth-child(2)').addClass("active");
     				jQuery('.pagination a').addClass("pagination-link");
				}
  
    			jQuery('.pagination').append("<li><a class=\"next\">Next</a></li>");
  
					$tr.each(function(i){
      				jQuery(this).hide();
      			if(i+1 <= req_num_row){
					$tr.eq(i).show();
					}
				});
  
				jQuery('.pagination a').click('.pagination-link', function(e){
					e.preventDefault();
					$tr.hide();
					var page=jQuery(this).text();
					var temp=page-1;
					var start=temp*req_num_row;
      				var current_link = temp;
      
     			jQuery('.pagination li').removeClass("active");
				jQuery(this).parent().addClass("active");
    
				for(var i=0; i< req_num_row; i++){
					$tr.eq(start+i).show();
				}
      
      			if(temp >= 1){
        			jQuery('.pagination li:first-child').removeClass("disabled");
      			}
      			else {
        			jQuery('.pagination li:first-child').addClass("disabled");
     			}
            
				});
  
    			jQuery('.prev').click(function(e){
        			e.preventDefault();
        		jQuery('.pagination li:first-child').removeClass("active");
    			});

    			jQuery('.next').click(function(e){
        			e.preventDefault();
        		jQuery('.pagination li:last-child').removeClass("active");
    			});

				}

				jQuery('document').ready(function(){
					pagination();
  
  				jQuery('.pagination li:first-child').addClass("disabled");
  
				});


		$(function(){
			$('#user_table td').click(function(){
				var bno =$(this).parent().find("input[type=hidden]").val();
				location.href="<%=request.getContextPath()%>/selectOne.bo?"+"&bno="+bno;
			});
		});
 
         
          </script>




</body>
</html>