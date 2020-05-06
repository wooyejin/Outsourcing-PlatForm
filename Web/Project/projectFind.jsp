
<%-- <%@page import="java.sql.Date"%> --%>
<%@page import="com.winwin.jsp.member.model.vo.Company"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Date"%>
<%@page import="com.winwin.jsp.project.model.vo.Project"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.winwin.jsp.project.model.vo.PageInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
ArrayList<Company> clist = (ArrayList<Company>)request.getAttribute("clist");
ArrayList<Project> list = (ArrayList<Project>)request.getAttribute("list"); 
PageInfo pi = (PageInfo)request.getAttribute("pi");
int listCount = pi.getListCount();
int currentPage = pi.getCurrentPage();
int maxPage = pi.getMaxPage();
int startPage = pi.getStartPage();
int endPage = pi.getEndPage();
Date date = new Date(System.currentTimeMillis());
SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
/* Project p = (Project)request.getAttribute("project");
 */
%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Find Project</title>
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
 <div style="height: 100%;padding-top: 5px; "class ="maindan">


      <h2 id = "projectid">프로젝트</h2>
     
      <div id = "custom2">
      <div id="custom-search-input">
        <div class="input-group col-md-12">
            <!-- <p id = "example-font"><span class = "example-font">프로젝트 등록 제목 예시입니다 &nbsp;&nbsp;&nbsp;프로젝트 등록 제목 예시입니다</span></p>
            <p id = "date"><span class = "date">등록 : 2020년 01월 20일</span></p> -->
            <!-- <div id = "point-item01"> -->
            <input type="text" id="keyword" class="  search-query form-control" placeholder="Search" style="top:11px;" />
            <span class="input-group-btn">
                <button class="btn btn-danger" type="button">
                    <span class=" glyphicon glyphicon-search"></span>
                </button>
            </span>
            
             </div>
            </div>
        </div>


<p id = "filter"><span id = "pfilter" onclick="search();">프로젝트 필터</span></p>
  <div id = "filtercheck" style="    margin-top: 0px;">
    
    <dl>	
      <dt>기본 정렬</dt>
      <dd>
        <ul>
          <li><input type ="radio" name = "filter-radio" id="sort1" value="sort1" checked=true>
            <label>기본 정렬 순</label>
          </li>
          <li><input type ="radio" name = "filter-radio" id="sort2" value="sort2" >
            <label>급여 순</label>
          </li>
          <li><input type ="radio" name = "filter-radio" id="sort3" value="sort3" >
            <label>최신 등록 순</label>
          </li>
          <li><input type ="radio" name = "filter-radio" id="sort4" value="sort4" >
            <label>마감 임박 순</label>
          </li>
        </ul>
        <hr>
        <dt>참여파트 분류</dt>
        <ul>
          <li><input type = "checkbox" name = "searchCondition1" id = "develop" value="develop">
              <label>개발</label>
          <li><input type = "checkbox" name = "searchCondition1" id = "design" value="design">
              <label>디자인</label>
          <li><input type = "checkbox" name = "searchCondition1" id = "plan" value="plan">
              <label>기획</label>
        </ul>
    </dl>

  </div>

  <div class = "divdiv" style=" bottom: 670px;;border: white ;position: relative;width: 1158px; left: 530px;">
  <ul>
  <%for(Project p : list){ %>
  <%-- <%int compare = dateFormat.format(p.getPend()).compareTo(dateFormat.format(date)); %> --%>
 
  <li class="btn1" style="border: 2px solid #ced4da; height: 407px;">
  <div  class = "proj-header">
  
    <div class = "divline" id = "div0" hidden><span class = "font1"><%=p.getPno() %> </span><strong class = "black"></strong></div>
    <h3 id = "projectname"><%=p.getPtitle() %></h3>
    <p id = "date">등록 : <%=p.getPenroll() %></p> 
    </div>
    
    <div class="proj-point" style = "display:flex;">
    <div class = "divline" id = "div1"><span class = "font1">예산 </span><strong class = "black"><%=p.getPcost() %> 원</strong></div>
    <div class = "divline" style=" width: 195px;" id = "div2"><span class = "font1">기간</span><strong class = "black"><%=p.getPgo() %></strong></div>
    <div class = "divline" id = "div3"><span class= "font1">마감</span><strong class = "black"><%=p.getPend() %></strong></div>
    <div class = "divline" id = "div4"><span class = "font1">경력</span><strong class = "black"><%=p.getCareer() %></strong></div>
   <!--  <div class = "divline" id = "div5"><span id = "font2"></span></div> -->
    </div>
   
    <div class = "proj-bottom">
    <div class = "divbottom"  style = "border-right : 1px solid #ced4da; width : 640px;height: 223px;">
      <div>
        <div class = "divline2" ><span class="font3"><%=p.getPbang() %> --- <%=p.getPtype() %></span></div>
   
       <div class = "divline3"><span class="font3"><%=p.getPdetail() %></span></div> 
        <!--  외주 or 상주 -->
																																
      <p class = "word">  
              <%=p.getPcotx() %>         
      </p>
        </div>
     </div>
  	<div class = "divbottom" id = "divb2">
    
        <p id ="company">
          <img style="width: 100px;
    height: 100px;
    border-radius: 53px;
    border: 1px solid; top:20px; left:-25px; position:relative;" src = "/win/resources/images/<%=p.getcImg() %>" 
          style="position: relative;
          left: -16px;
          top: 32px;">
          <p id = "company_1">
           <%=p.getcId() %>				<!--  기업 아이디 끌어다 넣을 것 -->
          </p>
          <p id = "company_2">
          <%=p.getcContent() %>
          </p>
	
       </div>
       </div>
       </li>
      
       <br>
       <%} %>
	</ul>
	</div>
	
	<div class="pagingArea" align="center" style="    height: 70px;">
			<button onclick="location.href='<%= request.getContextPath() %>/plist.do?currentPage=1'"><<</button>
			<%  if(currentPage <= 1){  %>
			<button disabled><</button>
			<%  }else{ %>
			<button onclick="location.href='<%= request.getContextPath() %>/plist.do?currentPage=<%=currentPage - 1 %>'"><</button>
			<%  } %>
			
			<% for(int p = startPage; p <= endPage; p++){
					if(p == currentPage){	
			%>
				<button disabled><%= p %></button>
			<%      }else{ %>
				<button onclick="location.href='<%= request.getContextPath() %>/plist.do?currentPage=<%= p %>'"><%= p %></button>
			<%      } %>
			<% } %>
				
			<%  if(currentPage >= maxPage){  %>
			<button disabled>></button>
			<%  }else{ %>
			<button onclick="location.href='<%= request.getContextPath() %>/plist.do?currentPage=<%=currentPage + 1 %>'">></button>
			<%  } %>
			<button onclick="location.href='<%= request.getContextPath() %>/plist.do?currentPage=<%= maxPage %>'">>></button>
			
		</div>
    </div>
    <%@ include file="../views/common/footer.jsp" %>
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
	var check = $('input[name=searchCondition1]');
	
	var sort = $('input[name=filter-radio]');
	
	var chk = '';	
	for(var i=0; i< check.length;i++){
		if($('input[name=searchCondition1]')[i].checked == true){
			chk = $('input[name=searchCondition1]')[i].value;
		}
	}
	var chk2 = '';
	for(var i=0; i< sort.length;i++){
		if($('input[name=filter-radio]')[i].checked == true){
			chk2 = $('input[name=filter-radio]')[i].value;
			console.log(chk2);
		}
	}

	location.href="<%=request.getContextPath()%>/pSearch.do?currentPage=<%=currentPage%>&con="+chk+"&keyword="+$('#keyword').val()+"&sort="+chk2;
}

/* function detail(){
	var pno =
}
 */ $("div").on({
    click:function(){
       $(".btn1").click(function(){
               //console.log($(this).parent().children().eq(0).text());
               var Pno = $(this).children().children().eq(0).text();
               console.log(Pno)
              location.href="<%=request.getContextPath()%>/selectOne2.bo?Pno=" + Pno; 
            });
    }
 });
</script>

  


  


  <!-- Footer (시작점)-->
      
   
</body>

</html>
