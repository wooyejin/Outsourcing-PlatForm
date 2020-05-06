<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="UTF-8">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/win/css/boardWrite.css">
    <link rel="stylesheet" href="/win/css/mainpagecss.css">
    <script src = "https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src = "https://code.jquery-3.1.1.min.js"></script>
    <style>
        body{
	        line-height: 1.6
        }

        .container{
    	    width: 900px;
	        margin: 0 auto;
        }

        ul.tabs{
	        margin: 0px;
	        padding: 0px;
	        list-style: none;
            margin-left: 15px;
        }
        ul.tabs li{
	        background: none;
	        color: #222;
	        display: inline-block;
	        cursor: pointer;
        }

        ul.tabs li.current{
	        /* background: #ededed; */
	        color: #222;
        }

        .tab-content{
	        display: none;
	        padding: 15px;
        }

        .tab-content.current{
	        display: inherit;
        }
        
        .menu {
            width : 900px;
            height : 50px;
            background : #0f4c81;
            border-radius : 20px;
            text-align : center;
            cursor : pointer;
            color:#fff;
            margin-top:5px;
        }

        .content {
            width : 900px;
            height : 150px;
            border : none;
            background: #fff;
            border-radius: 20px;
            text-align : center;
            display : none;
            color: black;
            float: none;
            margin-left: 0px;
            margin-right: 0px;
            margin-bottom: 20px;
            border:1px solid #0f4c81;
        }

        .content1{
            width : 900px;
            height : 350px;
            border : none;
            background: #fff;
            border-radius: 20px;
            text-align : center;
            display : none;
            color: black;
            float: none;
            margin-left: 0px;
            margin-right: 0px;
            margin-bottom: 20px;
            border:1px solid #0f4c81;
        }
    </style>
</head>
<body>
<!--     <nav>
        <ul>
            <li class="logo"><img src="images/win_win.png"></li>
            <li><a href ="#">프로젝트 찾기</a></li>
            <li><a href ="#">개발자 찾기</a></li>
            <li><a href ="#">프로젝트 등록</a></li>
            <li><a href ="#">이용방법</a></li>
            <li class="login"><a href ="LoginUser.html">마이페이지</a></li>
        </ul>
    </nav> -->

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


            <div class="write_main">
                <div class="write_title_div">
                    <h3 class="write_title_text" style="padding-top:20px">자주 묻는 질문</h3>
                </div>              

                <div class="mypCotent">
                    <div class="container">

                        <ul class="tabs">
                            <li class="tab-link current" data-tab="tab-1" style="padding-top: 50px;"><p style="border-bottom: 1px double #0f4c81; border-width: 4px; padding:6px"  >기업</p></li>
                            <li class="tab-link" data-tab="tab-2" style="padding-top: 50px;"><p style="border-bottom: 1px double #0f4c81; border-width: 4px; padding:6px" >개발자</p></li>
                            <li class="tab-link" data-tab="tab-3" style="padding-top: 50px;"><p style="border-bottom: 1px double #0f4c81; border-width: 4px; padding:6px" >WIN WIN 관련</p></li>
                        </ul>
                    
                        <div id="tab-1" class="tab-content current" style="padding-bottom: 50px; padding-right: 0px;"> 
                            <div>
                                <div class = "menu"><div style="padding-top: 13px;">프로젝트를 재등록하고 싶습니다.</div></div>
                                <p class = "content" style="padding-top: 10px; padding-bottom: 10px; padding: 50px;">프로젝트 재등록은 견적을 조정해야 하거나 프로젝트 내용이 변경된 불가피한 상황에만 가능합니다.<br>
                                                       사이트에서 기존과 동일한 방식으로 재등록 하시면, 담당자가 연락드려 상담드리겠습니다.
                                                    
                                </p>
                        
                                <div class = "menu"><div style="padding-top: 13px;">프로젝트가 '검사 중' 이라는데, 검사는 얼마나 걸리나요?</div></div>
                                <p class = "content" style="padding-top: 25px;">프로젝트 등록일 기준 최대 24시간 이내에 순차적으로 이루어집니다.(주말 및 공휴일 제외)<br>
                                                     프로젝트 관련 기술 및 정확한 업무 범위 확인을 위해 필요한 과정으로  <br> 담당자와의 상담을 통해 가이드라인을 안내 받으실 수 있고,<br>
                                                     프로젝트 내용을 수정 및 보완해 사이트에 최동 등록을 하고 있습니다.
                                </p>
                        
                                <div class = "menu"><div style="padding-top: 13px;">프로젝트 취소는 어디서 하나요?</div></div>
                                <p class = "content" style="padding-top: 70px;">프로젝트 취소 문의는 고객센터(1544-9970)로 연락 부탁드립니다.</p>
                        
                                <div class = "menu"><div style="padding-top: 13px;">일정이 변경되어 프로젝트를 보류하고 싶습니다.</div></div>
                                <p class = "content" style="padding-top: 50px;">프로젝트를 보류해야 할 경우, WIN WIN 고객센터(1544-9970)로 연락주세요.<br>
                                                     보류하신 프로젝트는 재개 처리 가능하며, 상담을 원하실 경우 고객센터로 연락 부탁드립니다.
                                </p>
                        
                                <div class = "menu"><div style="padding-top: 13px;">계약은 어떻게 진행되나요?</div></div>
                                <p class = "content" style="padding-top: 52px;">프로젝트 성사 시 미팅을 통해 계약서를 쓰고 프로젝트가 진행됩니다.<br>
                                                     더 자세한 내용은 고객센터(1544-9970)로 연락주세요.
                                </p>
                            </div>
                        </div>
                
                        <div id="tab-2" class="tab-content" style="padding-bottom: 50px;  padding-left: 0px;"> 
                            <div>
                                <div class = "menu"><div style="padding-top: 13px;">지원한 프로젝트가 모집마감이 되었는데 아무런 연락이 없어요.</div></div>
                                <p class = "content" style="padding-top: 35px;">기업이 미팅을 진행할 지원자를 선정하는 중입니다. 기업은 모집 마감일 이후 최대 10일까지 지원자를 검토할 수있습니다.<br>
                                                     해당 기간 내에 파트너님께 미팅 신청을 할 경우 win win 담당자가 연락드려 미팅 조율을 도와드리며, <br>
                                                     미팅이 성사되지 않은 경우에는 메일로 결과를 안내하고 있습니다.<br>
                                </p>
                        
                                <div class = "menu"><div style="padding-top: 13px;">미팅 때 동석하는 WIN WIN 매니저의 역할은 무엇인가요?</div></div>
                                <p class = "content" style="padding-top: 25px;">미팅 시 담당 프로세스 매니저가 배정이됩니다.<br>
                                                     1. 미팅이 원할하게 진행될 수 있도록 절차를 안내해드립니다.<br>
                                                     2. 공정하고 안전한 계약을 위해 미팅 시 나눈 내용을 토대로 계약서를 작성해드립니다.<br>
                                                     3. 일방에 유리/불리하지 않도록 의견을 조율합시다.<br>
                                </p>
                        
                                <div class = "menu"><div style="padding-top: 13px;">선급금(착수금) 형태로 진행할 수 있나요?</div></div>
                                <p class = "content" style="padding-top: 65px;">원칙적으로 선급금을 지급하지 않습니다.</p>
                        
                                <div class = "menu"><div style="padding-top: 13px;">프로젝트 완료 후 기업에서 추가 업무를 요구하면 어떻게 해야하나요?</div></div>
                                <p class = "content" style="padding-top: 37px;">계약서상에 명시된 업무 또는 하자 보수 범위가 아니라면, 개발자님께서 추가 업무를 진행할 의무는 없습니다.<br>
                                                     만약, 기업에서 추가 업무를 요구한다면, WIN WIN 에서 추가 계약 진행을 도와드립니다.<br>
                                                     추가 계약은 담당자에게 문의 주시면 상담해 드리도록 하겠습니다.<br>
                                </p>
                        
                                <div class = "menu"><div style="padding-top: 13px;">계약은 어떻게 진행되나요?</div></div>
                                <p class = "content" style="padding-top: 48px;">프로젝트 성사 시 미팅을 통해 계약서를 쓰고 프로젝트가 진행됩니다.<br>
                                                     더 자세한 내용은 고객센터(1544-9970)로 연락주세요.
                                </p>
                            </div>
                        </div>
                        
                        <div id="tab-3" class="tab-content" style="padding-bottom: 50px;">
                            <div>
                                <div class = "menu"><div style="padding-top: 13px;">가입한 이메일 주소를 변경하고 싶어요.</div></div>
                                <p class = "content1" style="padding-top: 80px;">이메일 변경을 원하실 경우, WIN WIN에 등록된 이메일을 통해 아래의 양식을 작성하여 <br> WIN WIN 고객센터 이메일로 발송 부탁드립니다.<br>
                                                     WIN WIN 고객센터 이메일 : shining852@naver.com<br>
                
                                                     [WIN WIN 이메일 변경 요쳥]
                                                     1. 기존 이메일 주소 : 예시) help@naver.com<br>
                                                     2. 변경할 이메일 주소 : 예시) help2@naver.com<br>
                                                     3. 이메일 변경 사유 : 예시) 담당자 변경, 사용할 수 없는 이메일 주소 등<br>
                                                     4. 신원 인증 서류 첨부 : 예시) 개인/팀(주민등록증, 운전면허증) , 사업자(사업자 등록증)<br>
                
                                                     계약 체결한 이력이 있을 경우, 이메일 주소 변경이 불가능합니다.<br>
                                                     WIN WIN 에 등록된 이메일이 아닌 다른 이메일로 요청 시, 이메일 변경 요청이 반려될 수 있습니다.<br>
                                                     반드시 WIN WIN 에 등록된 이메일을 통해 요청해주세요.<br>
                
                                                     * 등록된 이메일로 발신이 불가한 경우는 WIN WIN 고객센터(1544-9970)로 문의 부탁드립니다.<br>
                                </p>
                        
                                <div class = "menu"><div style="padding-top: 13px;">신원 인증은 어떻게 하나요?</div></div>
                                <p class = "content" style="padding-top: 30px;">신원인증은 인증서류를 팩스(02-562-2378)로 보내주시면 됩니다.<br>
                                                     인증 서류는 범인/개인 사업자일 경우 사업자 등록증을, <br>개인이나 팀일 경우 주민등록증이나 운전면허증을 첨부해주시면 됩니다.<br>
                                                     신원 인증은 최대 24시간이 소요됩니다.<br>
                                </p>
                        
                                <div class = "menu"><div style="padding-top: 13px;">WIN WIN은 어떤 서비스를 하는 곳인가요?</div></div>
                                <p class = "content" style="padding-top: 35px;">WIN WIN 은 IT 프로젝트를 의뢰하고자 하는 기업과 IT 전문인력이 함께 만나, <Br>편리하고 안전하게 프로젝트를 진행 할 수 있도록 
                                                     도와주는 아웃소싱 플랫폼입니다.<br>
                                                     프로젝트의 시작부터 끝까지 프로젝트 전반에 필요한 과정들을 WIN WIN에서 한번에 진행하실 수 있습니다.
                                </p>
                        
                
                            </div>
                        </div>
                    
                    </div>

                </div>
            </div>
        </div>
             
    </div>

    <script>
        $(function() {
            // 초기 상태 설정
            $('.content').slideUp();

            $('.menu').click(function() {
                $(this).next('p').slideToggle();
            });
        });



        $(document).ready(function(){
	
    	$('ul.tabs li').click(function(){
		var tab_id = $(this).attr('data-tab');

		$('ul.tabs li').removeClass('current');
		$('.tab-content').removeClass('current');

		$(this).addClass('current');
		$("#"+tab_id).addClass('current');
	});

});
</script>
</body>
</html>