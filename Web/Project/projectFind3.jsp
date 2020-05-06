<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Find Project</title>
   <script src="https://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script> 
  <script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
  <!-- <link href="netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css"> -->
  <!-- Custom fonts for this theme -->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

  <!-- Theme CSS -->
  <link href="/semi/resources/css/freelancer.min.css" rel="stylesheet">
  <link rel="stylesheet" href="/semi/resources/css/mainpagecss.css">


</head>

<body id="page-top">

  <!-- Navigation -->
  <nav>
      <ul>
          <li class="logo"><a href = "/semi/mainpage.jsp" style="padding:0px;"><img src="/semi/resources/images/win_win.png"></li>
           <li><a href ="/win/plist.do">프로젝트 찾기</a></li>
            <li><a href ="/win/dlist.do">개발자 찾기</a></li>
            <li><a href ="/win/Project/signupProject.jsp">프로젝트 등록</a></li>
            <li><a href ="/win/selectList.no">공지사항</a></li>
          <li><a href ="#">이용방법</a></li>
          <li class="login"><a href ="LoginUser.html">로그인</a></li>
          <li class="signup"><a href ="JoinUser.html">회원가입</a></li>
      </ul>
  </nav>
  <!-- 상단바 끝 -->
  

  <!-- Masthead -->
  <header class="masthead bg-primary text-white text-center">
    <div class="container d-flex align-items-center flex-column">

      <!-- Masthead Avatar Image -->
      <!-- <img class="masthead-avatar mb-5" src="images/avataaars.svg" alt=""> -->

      <!-- Masthead Heading -->
      <!-- <h1 class="masthead-heading text-uppercase mb-0">Welcome!</h1> -->
            <!-- <h2 class = "subTitle">프로젝트</h2> -->
      <!-- Icon Divider -->
      <div class="divider-custom divider-light">
        <div class="divider-custom-line"></div>
        <div class="divider-custom-icon">
          <i class="fas fa-star"></i>
        </div>
        <div class="divider-custom-line"></div>
      </div>

      <!-- Masthead Subheading -->
      <!-- <p class="masthead-subheading font-weight-light mb-0">Project</p> -->

    </div>
  </header>

        <!-- About Section Heading -->
      <!-- <h2 class="page-section-heading text-center text-uppercase text-white">About</h2> -->

      <!-- Icon Divider -->
      <div class="divider-custom divider-light">
        <div class="divider-custom-line"></div>
        <div class="divider-custom-icon">
          <i class="fas fa-star"></i>
        </div>
        <div class="divider-custom-line"></div>
      </div>

    
  <!-- Contact Section -->
  <section class="page-section" id="contact">
    <div class="container">
      <!-- Icon Divider -->
      <div class="divider-custom">
        <div class="divider-custom-line"></div>
        <div class="divider-custom-icon">
          <i class="fas fa-star"></i>
        </div>
        <div class="divider-custom-line"></div>
      </div>
    </section>
    
    <!-- 메인 시작부분 (흰색배경) 콘텐츠 집어넣어야함. -->
    <div class = "maindan">

      <h2 id = "projectid">프로젝트</h2>
     
      <div id = "custom2">
      <div id="custom-search-input">
        <div class="input-group col-md-12">
            <!-- <p id = "example-font"><span class = "example-font">프로젝트 등록 제목 예시입니다 &nbsp;&nbsp;&nbsp;프로젝트 등록 제목 예시입니다</span></p>
            <p id = "date"><span class = "date">등록 : 2020년 01월 20일</span></p> -->
            <!-- <div id = "point-item01"> -->
            <input type="text" class="  search-query form-control" placeholder="Search" />
            <span class="input-group-btn">
                <button class="btn btn-danger" type="button">
                    <span class=" glyphicon glyphicon-search"></span>
                </button>
            </span>
            
             </div>
            </div>
        </div>
      <!-- <div id = "box">
         <p id = "example-font"><span class = "example-font">프로젝트 등록 제목 예시입니다 &nbsp;&nbsp;&nbsp;프로젝트 등록 제목 예시입니다</span></p>
            <p id = "date"><span class = "date">등록 : 2020년 01월 20일</span></p> 
             <div id = "point-item01">
      </div>
    </div> -->
</div>
<p id = "filter"><span id = "pfilter">프로젝트 필터</span></p>
  <div id = "filtercheck">
    
    <dl>
      <dt>기본 정렬</dt>
      <dd>
        <ul>
          <li><input type ="checkbox" name = "filter-radio" checked=true>
            <label>기본 정렬 순</label>
          </li>
          <li><input type ="checkbox" name = "filter-radio" >
            <label>급여 순</label>
          </li>
          <li><input type ="checkbox" name = "filter-radio" >
            <label>평점 순</label>
          </li>
          <li><input type ="checkbox" name = "filter-radio" >
            <label>최신 등록 순</label>
          </li>
          <li><input type ="checkbox" name = "filter-radio" >
            <label>마감 임박 순</label>
          </li>
        </ul>
        <hr>
        <dt>참여파트 분류</dt>
        <ul>
          <li><input type = "checkbox" name = "part" id = "기획">
              <label>기획</label>
          <li><input type = "checkbox" name = "part" id = "기획">
              <label>디자인</label>
          <li><input type = "checkbox" name = "part" id = "기획">
              <label>개발</label>
          <li><input type = "checkbox" name = "part" id = "기획">
              <label>기획+개발</label>
          <li><input type = "checkbox" name = "part" id = "기획">
              <label>디자인+개발</label>
          <li><input type = "checkbox" name = "part" id = "기획">
              <label>기획+디자인</label>
          <li><input type = "checkbox" name = "part" id = "기획">
              <label>기획+디자인+개발</label>
        </ul>
      </dd>
    </dl>

  </div>

  <div class = "div1">
    <h3 id = "projectname">프로젝트 제목 제목 예시 예시</h3>
    <p id = "date">등록 : 2020년 01월 20일(등록 일자 입력 부분)</p> 
    <div style = "display:flex;">
    <div class = "divline" id = "div1"><span id = "font1">예산 </span><strong class = "black">10,000만원</strong></div>
    <div class = "divline" id = "div2"><span id = "font1">기간</span><strong class = "black">150일</strong></div>
    <div class = "divline" id = "div3"><span id = "font1">마감</span><strong class = "black">D-42</strong></div>
    <div class = "divline" id = "div4"><span id = "font1">지원자수</span><strong class = "black">5명</strong></div>
    <div class = "divline" id = "div5"><span id = "font2">기획 작성 중</span></div>
    </div>
    <div class = "divbottom" id = "divb1" style = "border-right : 1px solid #ced4da; width : 640px;">
      <div style = "display:flex;">
        <div class = "divline2" id = "di1"><span id = "font3">카테고리>상세카테고리</span></div> </div>
        <p id = "font4">사용되는 언어</p>
      <p id = "word">  
                       프로젝트 진행 방식  내용 내용 내용 내용 내용 내용 내용 내용 내용  <br>
                       내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용  <br>
                       내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 <br>
      </p>
      
    </div>
  
    <div class = "divbottom" id = "divb2">
      <!-- <p id = "word2">  등록한 회사 정보<br> -->
        <!-- 내용 내용 내용 내용 내용 <br> -->
        <!-- 내용 내용 내용 내용 내용 <br> -->
        <!-- 내용 내용 내용 내용 내용 <br> -->
        <!-- 내용 내용 내용 내용 내용 <br> -->
        <!-- 내용 내용 내용 내용 내용 <br> -->
        <p id ="company">
          <img src = "/semi/resources/images/developer.png" 
          style="position: relative;
          left: -16px;
          top: 32px;
          width:80px; height:80px">
          <p id = "company_1">
            기업 아이디
          </p>
          <p id = "company_2">
            기업 소개 내용<br>
            내용 내용 내용<br>
            내용 내용 내용<br>
          </p>

       </p>

    </div>

  </div>
  


  


  <!-- Footer (시작점)-->
      
   <%@ include file="../views/common/footer.jsp" %>
</body>

</html>
