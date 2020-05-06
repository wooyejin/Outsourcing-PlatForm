<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>mainpage</title>
    <link rel="stylesheet" href="/win/css/mainpagecss.css">
    
    <style>
    
    *{margin:0;padding:0;}
    ul,li{list-style:none;}
    .slide{height:300px;overflow:hidden;}
    .slide ul{width:calc(100% * 3);display:flex;animation:slide 13s infinite;} /* slide를 8초동안 진행하며 무한반복 함 */
    .slide li{width:calc(100% / 3);height:300px;}
    .slide li:nth-child(1){background:#ffa; box-shadow: 0 5px 10px -6px #222;}
    .slide li:nth-child(2){background:#faa;}
  /*   .slide li:nth-child(3){background:#afa;} */
/*     .slide li:nth-child(4){background:#aaf;} */
    @keyframes slide {
      0% {margin-left:0;} /* 0 ~ 10  : 정지 */
      10% {margin-left:0;} /* 10 ~ 25 : 변이 */
      25% {margin-left:-100%;} /* 25 ~ 35 : 정지 */
      35% {margin-left:-100%;} /* 35 ~ 50 : 변이 */
      /* 50% {margin-left:-100%;} */
    /*   60% {margin-left:-200%;}
      75% {margin-left:-300%;}
      85% {margin-left:-300%;} */
      100% {margin-left:0;}
    
    }
  
  /* #slide .pos{text-align:center;position:absolute;bottom:10px;left:0;width:100%;text-align:center;}
  #pos1:checked~ul{margin-left:0%;}
  #pos2:checked~ul{margin-left:-100%;}
  #pos3:checked~ul{margin-left:-200%;}
  #pos4:checked~ul{margin-left:-300%;}
  #pos1:checked~.pos>label:nth-child(1){background:#666;}
  #pos2:checked~.pos>label:nth-child(2){background:#666;}
  #pos3:checked~.pos>label:nth-child(3){background:#666;}
  #pos4:checked~.pos>label:nth-child(4){background:#666;} */
    


    </style>

  
</head>
<body>
 
 <%@ include file="views/common/header.jsp" %>
   <div class="introduction"style="padding:64px 0px 0px" >
        <section class="intro_container">
            <div class="introdution_ment">
                <p class="title_ment">능력있는 개발자 , <br> 맞춤형 프로젝트를 <br>WIN WIN 에서 <br> 더 간편하고 빠르게!</p>
                <p class="guide_ment">애플리케이션 개발, 웹 개발, 일반 소프트웨어 개발, <br> 웹 디자인, 쇼핑몰 등</p>
            </div>
            <div class="introdution_img">
                <img src="images/winwinlogo.jpg">
            </div>
        </section>
 
 <div class="slide">
    <ul>
      <li class="btn2"><img src ="/win/images/tcompany.png" style="width: calc(100%);height: 300px;"></li>
      <li><img src ="/win/images/tcompany2.png" style="width: calc(100%);height: 300px;"></li>
      <li></li>
    <!--   <li></li> -->
    </ul>
  </div>

 
 
    <footer class="foot">
        <div class="foot_container">
            <div class="row">
                <div class="map">
                    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3165.3783800920023!2d127.03072031526789!3d37.49899297981053!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357c9ec255555555%3A0x3565475c3365c5bb!2zS0jsoJXrs7TqtZDsnKHsm5A!5e0!3m2!1sko!2skr!4v1579419044117!5m2!1sko!2skr" width="350" height="200" frameborder="0" style="border:0;" allowfullscreen=""></iframe>
                </div>
                <div class="location">
                    <h4 class="h4_text">Location</h4>
                    <p class="loacation_text"> 서울특별시 강남구 테헤란로 <br><br> 14길 6  남도빌딩 2F, 3F, 4F, 5F</p>
                </div>
                <div class="fax_phone">
                    <h4 class="h4_text">Information</h4>
                    <p class="fax_phone_text">Tel: 1544-9970 </p>
                    <p class="fax_phone_text">Fax: 02-562-2378</p>
                </div>
            </div>
        </div>
    </footer>
    <section class="last">
        <div class="last_container">
            <small>Copyright &copy; Your Website 2020</small>
        </div>
    </section>
    <script>
    

    </script>
    
</body>
</html>