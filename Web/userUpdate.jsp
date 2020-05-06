<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="admin.member.model.vo.Member,java.util.ArrayList" %>
    
   <% 
  Member m = (Member)request.getAttribute("member"); 
%> 
  
    
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>user</title>

  <!-- Custom fonts for this template -->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="css/sb-admin-2.min.css" rel="stylesheet">

  <!-- Custom styles for this page -->
  <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

</head>

<body id="page-top">
  <%@include file="header.jsp" %>

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <h1 class="h3 mb-2 text-gray-800">회원 정보</h1>
          

          <!-- DataTales Example -->
          <div class="card shadow mb-4"style="font-size:13px;">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">회원 정보 테이블</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0" >
                  <thead style="font-size:11.5px;">
                    <tr>
                      <th>회원 번호</th>
                      <th>회원 이름</th>
                      <th>아이디</th>
                      <th>패스워드</th>
                      <th>자기소개</th>
                      <th>프로필사진</th>
                      <th>이메일</th>
                      <th>핸드폰</th>
                      <th>가입 날짜</th>
                      <th>활동여부</th>
                      <th>포폴번호(fk)</th>
                      <th>수정일</th>
                      <th>수정자/내용</th>
                      
                      
                    </tr>
                  </thead>
                  <tfoot style="font-size:11.5px;">
                    <tr>
                    <th>회원 번호</th>
                      <th>회원 이름</th>
                      <th>아이디</th>
                      <th>패스워드</th>
                      <th>자기소개</th>
                      <th>프로필사진</th>
                      <th>이메일</th>
                      <th>핸드폰</th>
                      <th>가입 날짜</th>
                      <th>활동여부</th>
                      <th>포폴번호(fk)</th>
                      <th>수정일</th>
                      <th>수정자/내용</th>
                      
                      
                    </tr>
                  </tfoot>
                  <tbody>
         
   	<form id="updateForm" action="/win/mUpdate.do" method="post">
         <tr style="font-size:13px;">
            
            <td><input style="width:30px;Background:none;border:none;" type=text value='<%=m.getuNo()%>' name="uNo" readonly></td>
            <td><input style="width:60px"type="text" value="<%= m.getuName() %>" name="uName"></td>
            <td><input style="width:60px"type="text" value="<%= m.getuId() %>" name="uId"></td>
            <td><input style="width:80px"type="password" value="<%= m.getuPwd() %>" name="uPwd"></td>
            <td><input style="width:100px"type="text" value="<%= m.getuIntro() %>" name="uIntro"></td>
            <td><input style="width:50px"type="text" value="<%= m.getuProfile() %>" name="uProfile"></td>
            <td><input style="width:70px"type="email" value="<%= m.getuEmail() %>" name="uEmail"></td>
            <td><input style="width:80px"type="text" value="<%= m.getuPhone() %>" name="uPhone"></td>
            <td><%= m.getuRegDate() %></td>
           <td><input style="width:30px"type="text" value="<%= m.getuYn() %>" name="uYn"></td> 
           <td><input style="width:30px"type="text" value="<%= m.getfNo() %>" name="fNo"></td> 
            <td><input style="width:100px"type="date" value="<%= m.getuModifyDate() %>" name="uModifyDate"></td>
            <td><input style="width:50px"type="text" value="<%= m.getuModifyWriter() %>" name="uModifyWriter"></td>
           
            <td>
            <button class="btn btn-primary" id=alter<%= m.getuNo() %> onclick="Submit()"
            style=width:35px;height:25px;font-size:1em;margin:0px;padding:0px;>완료</button></td>
            
         </tr>
        </form>  
         
         
                  </tbody>
                </table>
              </div>
            </div>
          </div>

        </div>
        
        <script>
        
        function Submit(){
        	$("#updateForm").submit();
        	location.href="user.jsp"
        }
        
        </script>
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->

      <!-- Footer -->
      <footer class="sticky-footer bg-white">
        <div class="container my-auto">
          <div class="copyright text-center my-auto">
            <span>Copyright &copy; Your Website 2019</span>
          </div>
        </div>
      </footer>
      <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

  </div>
  <!-- End of Page Wrapper -->

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

  <!-- Logout Modal-->
  <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
          <button class="close" type="button" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">×</span>
          </button>
        </div>
        <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
        <div class="modal-footer">
          <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
          <a class="btn btn-primary" href="/win/Member/loginUser.jsp">Logout</a>
        </div>
      </div>
    </div>
  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="js/sb-admin-2.min.js"></script>

  <!-- Page level plugins -->
  <script src="vendor/datatables/jquery.dataTables.min.js"></script>
  <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

  <!-- Page level custom scripts -->
  <script src="js/demo/datatables-demo.js"></script>

</body>

</html>
