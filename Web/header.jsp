<%@page import="admin.project.model.service.ProjectService"%>
<%@page import="admin.project.model.vo.Project"%>
<%@page import="admin.portfolio.model.vo.Portfolio"%>
<%@page import="admin.portfolio.model.service.PortfolioService"%>
<%@page import="admin.qna.model.vo.Qna"%>
<%@page import="admin.qna.model.service.QnaService"%>
<%@page import="admin.eye.model.service.EyeService"%>
<%@page import="admin.eye.model.vo.Eye"%>
<%@page import="admin.admin.model.vo.Admin"%>
<%@page import="java.util.ArrayList"%>
<%@page import="admin.admin.model.service.AdminService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>admin</title>
 
  <!-- Custom fonts for this template -->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="css/sb-admin-2.min.css" rel="stylesheet">

  <!-- Custom styles for this page -->
  <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

</head>

<body id="page-top">

<% AdminService ads = new AdminService();//사용 서블렛 선언부
		  ArrayList<Eye> eelist = new ArrayList<Eye>();
		  ArrayList<Qna> qqlist = new ArrayList<Qna>();
		ArrayList<Admin> adlist = new ArrayList<Admin>();
		ArrayList<Portfolio> ppflist = new ArrayList<Portfolio>();
		ArrayList<Project> pjlist = new ArrayList<Project>();
		
		
		  QnaService qqs = new QnaService();
		  EyeService ees = new EyeService();
		  PortfolioService ppf = new PortfolioService();
		  ProjectService pjs = new ProjectService();
		  
Admin add = new Admin();
int result = ads.updateAdmin(add);//서블렛 실행부분


adlist = ads.readAdmin();
qqlist = qqs.readQna();
ppflist = ppf.readPortfolio();
pjlist = pjs.readProject();

int adcCount =0;//알림 숫자 부분
int aduCount =0;
int adaCount =0;
int adeCount =0;
int adccCount =0;
int aduuCount =0;
int adaaCount =0;
int adeeCount =0;
int enCount = 0;
int eenCount = 0;
String aMemo="";
for(int i=0;i<1;i++){//갯수 담는 포문
	  adcCount = adlist.get(i).getcCount();
	  aduCount = adlist.get(i).getuCount();
	  adaCount = adlist.get(i).getaCount();
	  adeCount = adlist.get(i).geteCount();
	  adccCount = adlist.get(i).getCcCount();
	  aduuCount = adlist.get(i).getUuCount();
	  adaaCount = adlist.get(i).getAaCount();
	  adeeCount = adlist.get(i).getEeCount();
	  enCount = adlist.get(i).getEnCount();
	  aMemo = adlist.get(i).getaMemo();
	  } 
for(int i=0;i<eelist.size();i++){//감시n카운트
	if(eelist.get(i).geteYn().equals("N")){
		eenCount++;
	}
	
}

	
	
int qqCount = 0;

for(int j=0;j<qqlist.size();j++){//qna n카운트
	if(qqlist.get(j).getqYn().equals("N")){
		qqCount++;
	}
}
int ppfCount = 0;

for(int i=0;i<ppflist.size();i++){//portfolio n카운트
	if(ppflist.get(i).getPoYn().equals("N")){
		ppfCount++;
	}
}
int pjCount = 0;

for(int i=0;i<pjlist.size();i++){//project n카운트
	if(pjlist.get(i).getStatus().equals("N")){
		pjCount++;
	}
}

	int cTotal = adccCount-adcCount;
	int uTotal = aduuCount-aduCount;
	int aTotal = adaaCount-adaCount;
	int eTotal = adeeCount-adeCount;
	int enTotal = eenCount-enCount;
	  
	int lastTotal = enTotal+pjCount+ppfCount+qqCount;
	  
	  %>

  


 <!-- Page Wrapper -->
  <div id="wrapper">

     <!-- Sidebar -->
     <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

      <!-- Sidebar - Brand -->
      <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.jsp">
        <div class="sidebar-brand-icon rotate-n-15">
          <i class="fas fa-wrench"></i>
        </div>
        <div class="sidebar-brand-text mx-3"><sup>win</sup>win</div>
      </a>

      <!-- Divider -->
      <hr class="sidebar-divider my-0">

      <!-- Nav Item - Dashboard -->
      <div class="sidebar-heading">
     
        
      </div>
      

      <!-- Divider -->
      

      <!-- Heading -->
      <div  class="sidebar-heading">
        
      </div >
      <!-- Nav Item - Charts -->
      <li class="nav-item">
        <a class="nav-link" href="charts.jsp">
          <i class="fas fa-fw fa-chart-area"></i>
          <span>유입관리</span></a>
      </li>
     <li class="nav-item">
        <a class="nav-link" href="/win/asRead.do">
          <i class="fas fa-fw fa-dollar-sign"></i>
          <span>회계관리</span>
          <% if(aTotal!=0){ %>
            <span class="badge badge-danger badge-counter"style="background:#58b91a;margin-top:5px;"><%= aTotal %></span><%} %></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/win/adsRead.do">
          <i class="fas fa-fw fa-tv"></i>
          <span>광고관리</span></a>
      </li>
     
       
      <!-- Divider -->
      <hr class="sidebar-divider">

      <!-- Heading -->
      <div class="sidebar-heading">
       
      </div>


      

       <!-- Nav Item - Pages Collapse Menu -->
       <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
          <i class="fas fa-fw fa-user"></i>
          <span>회원관리</span>
          <% if(uTotal!=0){ %>
          <span class="badge badge-danger badge-counter" style="background:#58b91a;margin-top:15px;"><%= uTotal %></span>
          <%} %>
          <% if(ppfCount!=0){ %>
            <span class="badge badge-danger badge-counter"style="background:deeppink;"><%= ppfCount %></span><%} %>
          </a>
       
        <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <a class="collapse-item" href="/win/memberRead.do">회원 정보
             <% if(uTotal!=0){ %>
            <span class="badge badge-danger badge-counter"style="background:#58b91a;"><%= uTotal %></span><%} %>
            </a>
            <a class="collapse-item" href="/win/portfolioRead.do">포트폴리오
            <% if(ppfCount!=0){ %>
            <span class="badge badge-danger badge-counter"style="background:deeppink;"><%= ppfCount %></span><%} %></a>
          </div>
        </div>
      </li>

      <!-- Nav Item - Utilities Collapse Menu -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
          <i class="fas fa-fw fa-briefcase"></i>
          <span>기업관리</span>
          <% if(cTotal!=0){ %>
          <span class="badge badge-danger badge-counter" style="background:#58b91a;margin-top:15px;"><%= cTotal %></span>
          <%} %>
          <% if(pjCount!=0){ %>
            <span class="badge badge-danger badge-counter"style="background:deeppink;"><%= pjCount %></span><%} %>
        </a>
        <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <a class="collapse-item" href="/win/companyRead.do">기업 정보
            <% if(cTotal!=0){ %>
            <span class="badge badge-danger badge-counter"style="background:#58b91a;"><%= cTotal %></span><%} %></a>
            <a class="collapse-item" href="/win/projectRead.do">프로젝트
            <% if(pjCount!=0){ %>
            <span class="badge badge-danger badge-counter"style="background:deeppink;"><%= pjCount %></span><%} %></a>
            
          </div>
        </div>
      </li>

      <!-- Nav Item - Tables -->
      <li class="nav-item">
        <a class="nav-link" href="/win/noticeRead.do">
          <i class="fas fa-fw fa-tags"></i>
          <span>공지사항</span></a>
      </li>
      <!-- Nav Item - Tables -->
      <li class="nav-item">
        <a class="nav-link" href="/win/qnaRead.do">
          <i class="fas fa-fw fa-comment"></i>
          <span>Q&A</span>
          <% if(qqCount!=0){ %>
            <span class="badge badge-danger badge-counter"style="background:deeppink;margin-top:5px;"><%= qqCount %></span><%} %>
            </a>
      </li>
      <!-- Nav Item - Tables -->
      <li class="nav-item">
        <a class="nav-link" href="/win/eyeRead.do">
          <i class="fas fa-fw fa-eye"></i>
          <span>감시</span>
          <% if(eTotal!=0){ %>
            <span class="badge badge-danger badge-counter"style="background:#58b91a;margin-top:15px;"><%= eTotal %></span><%} %>
            
          <% if(enTotal!=0){ %>
            <span class="badge badge-danger badge-counter"style="background:deeppink;"><%= enTotal %></span><%} %>
          </a>
      </li>
      <hr class="sidebar-divider my-0">
<!-- Nav Item - Tables -->
<li class="nav-item">
  <a class="nav-link" href="mainpage.jsp">
    <i class="fas fa-fw fa-home"></i>
    <span>Winwin홈페이지</span></a>
</li>
      <!-- Divider -->
      <hr class="sidebar-divider d-none d-md-block">

      <!-- Sidebar Toggler (Sidebar) -->
      <div class="text-center d-none d-md-inline">
        <button class="rounded-circle border-0" id="sidebarToggle"></button>
      </div>

    </ul>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">

        <!-- Topbar -->
        <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

          <!-- Sidebar Toggle (Topbar) -->
          <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
            <i class="fa fa-bars"></i>
          </button>
	<% if(aMemo==null){
       	  aMemo="메모를 입력하세요.";} %>
          <!-- Topbar Search -->
          <form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
            <div class="input-group">
              <input type="text" id="noticeText" class="form-control bg-light border-0 small" aria-label="Search" aria-describedby="basic-addon2" value="<%= aMemo %>">
              <div class="input-group-append">
                <button class="btn btn-primary" type="button" onclick="noti()">
                  <i class="fas fa-exclamation"></i>
                </button>
              </div>
            </div>
          </form>
          <script>
          function noti(){
        	  $.ajax({
      			url:"/win/adInsert.do",
      			type:"get",
      			data:{
      				aMemo : $('#noticeText').val()
      			},
      			success:function(data){
      				alert("메모되었습니다.");				
      			},
      			error:function(){
      			},
      			complete:function(){
      			}
      		});
          };
          </script>

          <!-- Topbar Navbar -->
          <ul class="navbar-nav ml-auto">

            <!-- Nav Item - Search Dropdown (Visible Only XS) -->
            <li class="nav-item dropdown no-arrow d-sm-none">
              <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-search fa-fw"></i>
              </a>
              <!-- Dropdown - Messages -->
              <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in" aria-labelledby="searchDropdown">
                <form class="form-inline mr-auto w-100 navbar-search">
                  <div class="input-group">
                    <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
                    <div class="input-group-append">
                      <button class="btn btn-primary" type="button">
                        <i class="fas fa-search fa-sm"></i>
                      </button>
                    </div>
                  </div>
                </form>
              </div>
            </li>

            <!-- Nav Item - Alerts -->
            <li class="nav-item dropdown no-arrow mx-1">
              <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-bell fa-fw"></i>
                <!-- Counter - Alerts -->
                <span class="badge badge-danger badge-counter"style="background:deeppink;"><%= lastTotal %></span>
              </a>
              <!-- Dropdown - Alerts -->
              <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="alertsDropdown">
                <h6 class="dropdown-header">
                  Alerts Center
                </h6>
                
                    <% if(ppfCount!=0){ %>
                <a class="dropdown-item d-flex align-items-center" href="/win/portfolioRead.do">
                  <div class="mr-3">
                    <div class="icon-circle bg-warning">
                      <i class="fas fa-file-alt text-white"></i>
                    </div>
                  </div>
                  <div>
                    <div class="small text-gray-500">포트폴리오</div>
                    <span class="font-weight-bold">확인<Small>을 기다리는 포트폴리오</Small></span>
            <span class="badge badge-danger badge-counter"style="background:deeppink;"><%= ppfCount %>+</span>
                  </div>
                </a><%} %>
                
                <% if(pjCount!=0){ %>
                <a class="dropdown-item d-flex align-items-center" href="/win/projectRead.do">
                  <div class="mr-3">
                    <div class="icon-circle bg-warning">
                      <i class="fas fa-fw fa-briefcase"style="color:white;"></i>
                    </div>
                  </div>
                  <div>
                    <div class="small text-gray-500">프로젝트</div>
                    <span class="font-weight-bold">확인<Small>을 기다리는 프로젝트</Small></span>
            <span class="badge badge-danger badge-counter"style="background:deeppink;"><%= pjCount %>+</span>
                  </div>
                </a><%} %>
                
                <% if(qqCount!=0){ %>
                <a class="dropdown-item d-flex align-items-center" href="/win/qnaRead.do">
                  <div class="mr-3">
                    <div class="icon-circle bg-warning"style="color:lightpink;">
                      <i class="fas fa-fw fa-comment"style="color:white;"></i>
                    </div>
                  </div>
                  <div>
                    <div class="small text-gray-500">Q&A</div>
                    <span class="font-weight-bold">답변<Small>을 기다리는 Q&A</Small></span>
            <span class="badge badge-danger badge-counter"style="background:deeppink;"><%= qqCount %>+</span>
                  </div>
                </a><%} %>
                
                <% if(enTotal!=0){ %>
                <a class="dropdown-item d-flex align-items-center" href="/win/eyeRead.do">
                  <div class="mr-3">
                    <div class="icon-circle bg-warning">
                      <i class="fas fa-file-alt text-white"></i>
                    </div>
                  </div>
                  <div>
                    <div class="small text-gray-500">감시</div>
                    <span class="font-weight-bold">확인<Small>을 기다리는 댓글</Small></span>
            <span class="badge badge-danger badge-counter"style="background:deeppink;"><%= enTotal %>+</span>
                  </div>
                </a><%} %>

            <!-- Nav Item - Messages -->
            <li class="nav-item dropdown no-arrow mx-1">
              <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-envelope fa-fw"></i>
                <!-- Counter - Messages -->
                <span class="badge badge-danger badge-counter"style="background:#58b91a">1</span>
              </a>
              <!-- Dropdown - Messages -->
              <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="messagesDropdown">
                <h6 class="dropdown-header">
                  Message Center
                </h6>
                <a class="dropdown-item d-flex align-items-center" href="#">
                  <div class="dropdown-list-image mr-3">
                    <img class="rounded-circle" src="https://source.unsplash.com/fn_BT9fwg_E/60x60" alt="">
                    <div class="status-indicator bg-success"></div>
                  </div>
                  <div class="font-weight-bold">
                    <div class="text-truncate">안녕하세요 메인프로젝트 광고 건으로 연락드립니다.</div>
                    <div class="small text-gray-500">KH정보 · 58m</div>
                  </div>
                  
                  
               
                
                <a class="dropdown-item d-flex align-items-center" href="#">
                  <div class="dropdown-list-image mr-3">
                    <img class="rounded-circle" src="https://source.unsplash.com/CS2uCrpNzJY/60x60" alt="">
                    
                  </div>
                  <div>
                    <div class="text-truncate">ok, bye!</div>
                    <div class="small text-gray-500">eric jhon · 2d</div>
                  </div>
                </a>
                
                
                <a class="dropdown-item d-flex align-items-center" href="#">
                  <div class="dropdown-list-image mr-3">
                    <img class="rounded-circle" src="https://source.unsplash.com/Mv9hjnEUHR4/60x60" alt="">
                  </div>
                  <div>
                    <div class="text-truncate">네 감사합니다~</div>
                    <div class="small text-gray-500">(주)DogIT · 1w</div>
                  </div>
                </a>
                <a class="dropdown-item text-center small text-gray-500" href="#">Read More Messages</a>
              </div>
            </li>

            <div class="topbar-divider d-none d-sm-block"></div>

            <!-- Nav Item - User Information -->
            <li class="nav-item dropdown no-arrow">
              <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <span class="mr-2 d-none d-lg-inline text-gray-600 small">admin</span>
                <i class="fas fa-fw fa-user-circle"></i>
              </a>
              <!-- Dropdown - User Information -->
              <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                <a class="dropdown-item" href="#">
                  <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                  Profile
                </a>
              
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="/win/Member/loginUser.jsp" data-toggle="modal" data-target="#logoutModal">
                  <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                  Logout
                </a>
              </div>
            </li>

          </ul>

        </nav>
        <!-- End of Topbar -->
</body>
</html>