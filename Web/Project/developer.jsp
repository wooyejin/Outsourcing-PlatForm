<%@page import="win.board.model.vo.Skill"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Date"%>
<%@page import="com.winwin.jsp.developer.model.vo.PageInfo"%>
<%@page import="com.winwin.jsp.developer.model.vo.developer"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
ArrayList<developer> list = (ArrayList<developer>)request.getAttribute("list");
ArrayList<Skill> slist = (ArrayList<Skill>)request.getAttribute("slist");

PageInfo pi = (PageInfo)request.getAttribute("pi");
int listCount = pi.getListCount();
int currentPage = pi.getCurrentPage();
int maxPage = pi.getMaxPage();
int startPage = pi.getStartPage();
int endPage = pi.getEndPage();
Date date = new Date(System.currentTimeMillis());
SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Find Developer</title>
   <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
   <script src="https://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script> 
  <!-- <link href="netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css"> -->
  <!-- Custom fonts for this theme -->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

  <!-- Theme CSS -->
  <link href="/win/css/freelancer.min.css" rel="stylesheet">
  <link rel="stylesheet" href="/win/css/mainpagecss.css">

</head>

<body id="page-top">
 <%@ include file="/views/common/header.jsp" %> 

  
  <div class = "">


     

    
    <!-- 메인 시작부분 (흰색배경) 콘텐츠 집어넣어야함. -->
  
      <h2 id = "projectid" style="    position: relative;
    top: 0px;
    left: 304px;
    border-bottom : 1px solid black;
    width : 1400px;">개발자</h2>
      <div id = "custom2" style="position: relative;
       width: 240px;
        top: 55px;
    left: 290px">
      <div id="custom-search-input">
        <div class="input-group col-md-12">
            <input type="text" id="keyword" class="  search-query form-control" placeholder="Search" />
            <span class="input-group-btn">
                <button class="btn btn-danger" type="button">
                    <span class=" glyphicon glyphicon-search"></span>
                </button>
            </span>
        </div>
    </div>
</div>
<p id = "filter"    style="position: relative;
    width: 210px;
    height: 52px;
    background: #0f4c81;
    color: white;
    top: 35px;
    left: 305px;
    font-size: 14px;
    line-height: 6px;
    border-radius: 3px" >
    <span id = "pfilter" onclick="search();" >프로젝트 필터</span>
    </p>
    <div style="    position: relative;
        top: -100px;
    left: 537px;
    width: 1000px;">
  <ul>
    <%for(developer d : list){ %>
    <%if(d.getUyn().equals("Y")) {%>
    	
	<li class="btn1" style="height: 278px;">
 <div class = "divline" id = "div0" hidden><span id = "font1"><%=d.getuNo()%></span><strong class = "black"></strong></div>
    <div class = "" style = "display:inline-block; width: 880px;
       height: 270px;
    border: 2px solid #ced4da;
    left: 530px;
    margin-bottom: 10px;" >
			<h5 style="        position: relative;
    top: 33px;
    left: 97px" ><%=d.getTitle() %></h5>
      <div class = "block" style = "display:inline-block;">
      <div class = "block2" style = "display:inline-block;">
      <div class = "picture" style="    padding-top: 55px;">
      <%if(d.getImg() ==null){ %>
      <img style="width: 112px; height:112px;border-radius: 53px;border: 1px solid;" src ="/win/images/mypage_info.png"></div>
		<%} else{ %>
      <img style="width: 112px; height:112px;border-radius: 53px;border: 1px solid;" src = "/win/resources/images/<%=d.getImg() %>"></div>
      	<%} %>
      	<div>
      	 <span style="position: relative;left: 93px;top: 10px;"><%=d.getuId() %> </span>
      	     </div>
      	     <div style="    position: relative;left: 29px;top: 10px;text-align: center;">
          <span class= "person">(<%=d.getuName() %>)</span>
      </div>
      
      </div> 
      </div>
      <div class="block" style="
      display: inline-block;
      height: 200px;
      top: -165px;
        width: 350px;
      margin-left: 27px;">

        <div class = "info1">
          <p id = "context"><span id ="text2">
            <br>"<%=d.getIntro() %>"
          </span></p>
          
          </div>
      </div>
    
      <div style=" display: inline-block;
    position: relative;
   height: 191px;
    width: 98px;
    text-align: center;
    bottom: 132px;
    border: 1px solid black;
    background: aliceblue;
   			 "
   			 >
      <%if(d.getPortYN() != null){ %>
     <span style="    position: relative;
		    top: 10px;
		    font-size: 15px;
		    font-weight: bolder;">포트폴리오  <br><br><strong style="color: blue;">◎</strong></span>
     <%} else { %>
     <span style="    position: relative;
		    top: 10px;
		    font-size: 15px;
		    font-weight: bolder;">포트폴리오 <br><br><strong style="color: red;">X</strong></span>
     <% }  %>
   </div>
   <div style="display: inline-block;
    position: relative;
    left: 10px;
    height: 43px;
    width: 98px;
    text-align: center;
    bottom: 180px;
    border: 1px solid black;
    background: aliceblue;">
     
     <span style="    position: relative;
		    top: 10px;
		    font-size: 15px;
		    font-weight: bolder;
		    text-align: left;">보유기술</span>
   </div>
   
   <div style="   
    position: relative;
    border: 1px solid;
    width: 99px;
    height: 144px;
    text-align: center;
    background: aliceblue;
    font-weight: bold;
    left: 675px;
    bottom: 274px; "> 
		     <%for(Skill s : slist){ %>
		     <%if(s.getNo() == d.getuNo()){ %>
		    <span style="    top: 9px;
    position: relative;">
		        	<%=s.getS_name()%><br>
		    </span>
		   	<%}%>
		    <%} %>
	
    </div> 
   

         </li>
  

  <br>
  <%} %>
            <%} %>
            </ul>
            </div >
             <div class="pagingArea" align="center">
			<button onclick="location.href='<%= request.getContextPath() %>/dlist.do?currentPage=1'"><<</button>
			<%  if(currentPage <= 1){  %>
			<button disabled><</button>
			<%  }else{ %>
			<button onclick="location.href='<%= request.getContextPath() %>/dlist.do?currentPage=<%=currentPage - 1 %>'"><</button>
			<%  } %>
			
			<% for(int p = startPage; p <= endPage; p++){
					if(p == currentPage){	
			%>
				<button disabled><%= p %></button>
			<%      }else{ %>
				<button onclick="location.href='<%= request.getContextPath() %>/dlist.do?currentPage=<%= p %>'"><%= p %></button>
			<%      } %>
			<% } %>
				
			<%  if(currentPage >= maxPage){  %>
			<button disabled>></button>
			<%  }else{ %>
			<button onclick="location.href='<%= request.getContextPath() %>/dlist.do?currentPage=<%=currentPage + 1 %>'">></button>
			<%  } %>
			<button onclick="location.href='<%= request.getContextPath() %>/dlist.do?currentPage=<%= maxPage %>'">>></button>
			
		</div>

<br>



  
 <section class="last">
    <div class="last_container">
        <small>Copyright &copy; Your Website 2020</small>
    </div>
</section>
</div>

<script>
$(function(){
	
	$("#pfilter").mouseenter(function(){
		$(this).parent().css({"background":"darkgray", "cursor":"pointer"});
	}).mouseout(function(){
		$(this).parent().css({"background":"#0f4c81"});
	})
});

$(function(){
	
	$(".btn1").mouseenter(function(){
		$(this).parent().css({"cursor":"pointer"});
	})
});

function search(){
	location.href="<%=request.getContextPath()%>/dsearch.do?currentPage=<%=currentPage%>&keyword="+$('#keyword').val();

}

$("div").on({
    click:function(){
       $(".btn1").click(function(){
               console.log($(this).parent().children().eq(0).text());
               var uno = $(this).children().children().eq(0).text();
               var D = 'D';
               location.href="<%=request.getContextPath()%>/mDetail?uno="+uno+"&memberType="+D;
            });
    }
 });
$(function(){
	
	$(".btn1").mouseenter(function(){
		$(this).parent().css({"cursor":"pointer"});
	})
});
</script>

</body>

</html>
