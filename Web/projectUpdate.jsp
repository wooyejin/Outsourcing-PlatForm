<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="admin.project.model.vo.Project,java.util.ArrayList" %>
    
   <% 
  Project p = (Project)request.getAttribute("project"); 
%> 
  
    
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>project</title>

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
          <h1 class="h3 mb-2 text-gray-800">프로젝트 정보</h1>
          

          <!-- DataTales Example -->
          <div class="card shadow mb-4"style="font-size:13px;">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">프로젝트 정보 테이블</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
              <form id="updateForm" action="/win/pUpdate.do" method="post">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0" >
                  <thead style="font-size:11.5px;">
                    <tr>
                      <th>pj 번호</th>
                      <th>등록날</th>
                      <th>pj명</th>
                      <th>외/상주</th>
                      <th>구분</th>
                      <th>상세분류</th>
                      <th>내용</th>
                      <th>예상비용</th>
                      <th>예상시작일</th>
                      <th>예상마감일</th>
                      <th>진행기간</th>
                      <th>기업번호</th>
                      <th>검사</th>
                      <th>광고</th>
                      <th>수정날</th>
                      <th>수정자/내용</th>
                      
                      
                    </tr>
                  </thead>
                  <tfoot style="font-size:11.5px;">
                    <tr>
                    <th>pj 번호</th>
                      <th>등록날</th>
                      <th>pj명</th>
                      <th>외/상주</th>
                      <th>구분</th>
                      <th>상세분류</th>
                      <th>내용</th>
                      <th>예상비용</th>
                      <th>예상시작일</th>
                      <th>예상마감일</th>
                      <th>진행기간</th>
                      <th>기업번호</th>
                      <th>검사</th>
                      <th>광고</th>
                      <th>수정날</th>
                      <th>수정자/내용</th>
                      
                      
                    </tr>
                  </tfoot>
                  <tbody>
         
   	
         <tr style="font-size:13px;">
            
            <td><input style="width:30px;Background:none;border:none;" type=text value='<%=p.getpNo()%>' name="pNo" readonly></td>
            <td><input style="width:60px"type="date" value="<%= p.getpEnro() %>" name="pEnro"></td>
            <td><input style="width:60px"type="text" value="<%= p.getpTitle() %>" name="pTitle"></td>
            <td><input style="width:80px"type="text" value="<%= p.getpBang() %>" name="pBang"></td>
            <td><input style="width:100px"type="text" value="<%= p.getpType() %>" name="pType"></td>
            <td><input style="width:50px"type="text" value="<%= p.getpDetail() %>" name="pDetail"></td>
            <td><input style="width:70px"type="text" value="<%= p.getpCotx() %>" name="pCotx"></td>
            <td><input style="width:80px"type="text" value="<%= p.getpCost() %>" name="pCost"></td>
            <td><input style="width:80px"type="date" value="<%= p.getpStart() %>" name="pStart"></td>
            <td><input style="width:80px"type="date" value="<%= p.getpEnd() %>" name="pEnd"></td>
            <td><input style="width:80px"type="text" value="<%= p.getpGo() %>" name="pGo"></td>
           <td><input style="width:30px"type="text" value="<%= p.getcNo() %>" name="cNo"></td> 
           <td><input style="width:30px"type="text" value="<%= p.getStatus() %>" name="status"></td> 
           <td><input style="width:30px"type="text" value="<%= p.getpAdsYn() %>" name="pAdsYn"></td> 
            <td><input style="width:100px"type="date" value="<%= p.getpModifyDate() %>" name="pModifyDate"></td>
            <td><input style="width:50px"type="text" value="<%= p.getpModifyWriter() %>" name="pModifyWriter"></td>
           
            <td>
            <button class="btn btn-primary" id=alter<%= p.getpNo() %> onclick="Submit()"
            style=width:35px;height:25px;font-size:1em;margin:0px;padding:0px;>완료</button></td>
            
         </tr>
         
         
         
                  </tbody>
                </table>
                 </form>
              </div>
            </div>
          </div>

        </div>
        
        <script>
        
        function Submit(){
        	$("#updateForm").submit();
        	location.href="project.jsp"
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
