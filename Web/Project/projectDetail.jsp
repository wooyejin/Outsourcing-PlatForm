<%@page import="com.winwin.jsp.projectComment.model.vo.ProjectComment"%>
<%@page import="com.winwin.jsp.project.model.vo.Project"%>
<%@page import="java.util.ArrayList"%>


<%
  Project p = (Project)request.getAttribute("project");
  //ArrayList<ProjectComment> plist = (ArrayList<ProjectComment>)request.getAttribute("plist");
  String type ="";
 
  int count = (int)request.getAttribute("count");
  
%>



<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
 <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>프로젝트 설명 상세</title>
    <script src="https://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>

    <!-- Custom fonts for this theme -->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet"
        type="text/css">

    <!-- Theme CSS -->
    <link href="/win/css/freelancer.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/win/css/mainpagecss.css">
    <!-- 합쳐지고 최소화된 최신 CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <!-- Font Awesome-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />

    <style>
    
    	a:hover{
    		none;
    		color: white;
    	}
    
        #content-wrap {
            width: 100%;
            height: 100%;
           /*  margin: 0px; */
           
           	margin-left:auto;
		margin-right:auto;
		margin-top:50px;
        }

        .container {
            margin-bottom: 3%;
            border: solid lightgrey 1px;
           /*  margin-left:355px; */
        }

        .project-header {
            border-bottom: solid grey 1px;

            font-size: 28px;
            margin: 5%;
            margin-bottom: 0px;
        }

        .project-content {
            margin: 5%;
            margin-top: 7px;
        }

        .small-menu {
            font-size: 14px;
            color: grey;
        }

        .back {
            background-color: skyblue;
            color: grey;
        }

        .basic-info {
            margin-top: 20px;
            padding-left: 20px;
            background: #f7f7f7;
            border: 1px solid #dedede;
            border-radius: 2px;
            padding-top: 3px;
            padding-bottom: 3px;
            line-height: 38px;
            font-size: 16px;
        }

        #project-apply {
            margin-left: 35%;
            width: 350px;
            height: 50px;
        }

        .comment {
            margin-top: -3%;
            margin-left: 4%;
        }

        .comment-send {
            margin-right: 20%;
        }

    </style>
</head>
    <!-- 상단바 끝 -->
	<%@ include file="/views/common/header.jsp" %>
    <body>
        <div id="content-wrap">

            <div class="container">
                <div class="project-header"><span><%=p.getPtitle() %></span> <!-- <span class="label label-info"
                        style="font-size: 16px;">마감 2주전</span> -->
                </div>
                <div class="project-content">
                    <p class="small-menu">
                      <%=p.getCname() %></p>
                    <p class="small-menu"><i class="fa fa-file-alt"> <%=count %> </i> 명 지원</p>
                    <div class="basic-info">
                        <table class="table" style="margin-bottom: -3%;">
                            <thead>
                                <th>예상 금액</th>
                                <th>예상 기간</th>
                                <th>등록 일자</th>
                            </thead>
                            <tbody>
                                <td id="price"><%=p.getPcost() %></td>
                                <td id="term"><%=p.getPgo() %></td>
                                <td id="ad-close"><%=p.getPstart() %></td>
                            </tbody>
                        </table>
                        <br>
                    </div>
                    <hr>
                    <table class="table table-striped table-sm" id="table-first-row">
                        <thead>
                            <th>우대 기술</th>
                            <th>경력 </th>
                            <th>마감 일자</th>
                        </thead>
                        <tbody>
                            <tr>
                                <td id="status" style="width: 325px;" ><%=p.getPdetail() %></td>
                                <td id="manage-experience" style=" width: 325px;"><%=p.getCareer() %></td>
                                <td id="post-date"><%=p.getPend() %></td>
                            </tr>
                        </tbody>
                    </table>
                     
                    <table class="table table-striped" id="table-second-row">
                        <thead>
                            <th>위치</th>
                            <th>모집인원</th>
                            <th>예상 시작일</th>
                        </thead>
                        <tbody>
                            <tr>
                                <td id="post-date" style="width: 310px;" ><%=p.getPbang() %></td>
                                <td id="manage-experience" style="width:300px;"><%=p.getMemcount() %>명</td>
                                <td id="status" style="width: 322px;"><%=p.getPstart() %></td>
                            </tr>
                        </tbody>
                    </table>
                    <h3>프로젝트 내용</h3><br>
                    <div class="main-content">
                        <%=p.getPcotx() %>
                    </div>
                    <hr>
                        <div class="skill-tag">
                        <h3>관련 기술</h3>
                        <label class="label label-default" id="HTML5">HTML5</label>
                        <label class="label label-default" id="CSS3">CSS3</label>
                        <label class="label label-default" id="JavaScript">JavaScript</label>
                        </div>
                    </div>
                     <button class="btn btn-info btn-lg" id="apply" style="position:relative;left:450px;">프로젝트 지원하기</button> 
                    
                    <br><hr></hr>
                </div>
                
                         <input type="hidden" id="pno" name="pno" value="<%=p.getPno() %>" />        
       
		<script>
		
		$('#apply').click(function(){
			$.ajax({
				url:"/win/eprjt.do",
				type:"post",
				data:{pno: $('#pno').val()},
				success:function(data){
					
					if(data=='ok'){
						alert("프로젝트 지원 성공!")
					}else{
						alert('지원불가능한 프로젝트 입니다.');
					}
				},error:function(){
					console.log("Error 입니다.");
				}
				
			});
		});
		
		
		<%-- var pno = '<%=p.getPno()%>';
		
		var parent = $(obj).parent();
		var grandparent = parent.parent();
		var siblingsTR = grandparent.siblings().last();
		
		var content = siblingsTR.find('textarea').val();
		 --%>
		<%-- $("button").on({
		    click:function(){
		$('#submit').click(function(){
			location.href='/win/cinsert.bo'
				+'?writer=<%=m.getUserId() %>'
				+ '&comment=' + content
				+ '&pno=' + pno;
		});
		    }
		}); --%>
	<%-- 	function cSubmit(){
			var pno = '<%=p.getPno()%>';
			
			var content = $('#comment').val();
			
			location.href='/win/cinsert.bo'
					+'?writer=<%=m.getUserId() %>'
					+ '&comment=' + content
					+ '&pno=' + pno;
					
			
		} --%>
		</script>
        <!-- Footer (시작점)-->
        <section class="last">
    <div class="last_container">
        <small style="left: -28px;
    position: relative;">Copyright &copy; Your Website 2020</small>
    </div>
</section>
    </body>

</html>