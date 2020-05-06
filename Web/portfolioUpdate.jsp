<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="admin.portfolio.model.vo.Portfolio,java.util.ArrayList" %>
    
   <% 
  Portfolio f = (Portfolio)request.getAttribute("portfolio"); 
%> 
  
    
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>portfolio</title>

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
          <h1 class="h3 mb-2 text-gray-800">포트폴리오 정보</h1>
          

          <!-- DataTales Example -->
          <div class="card shadow mb-4"style="font-size:13px;">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">포트폴리오 정보 테이블</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
              <form id="updateForm" action="/win/fUpdate.do" method="post">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0" >
                  <thead style="font-size:11.5px;">
                    <tr>
                      <th>pf 번호</th>
                      <th>pf</th>
                      <th>회원 번호(fk)</th>
                       <th>검사</th>
                      <th>수정일</th>
                      <th>수정자/내용</th>
                      <th></th>
                      
                      
                    </tr>
                  </thead>
                  <tfoot style="font-size:11.5px;">
                    <tr>
                    <th>pf 번호</th>
                      <th>pf</th>
                      <th>회원 번호(fk)</th>
                       <th>검사</th>
                      <th>수정일</th>
                      <th>수정자/내용</th>
                      <th></th>
                      
                      
                    </tr>
                  </tfoot>
                  <tbody>
         
   	
         <tr style="font-size:13px;">
            	
            <td><input style="width:30px;Background:none;border:none;" type=text value='<%=f.getPortNo()%>' name="portNo" readonly></td>
            <td><input style="width:100px"type="text" value="<%= f.getPort() %>" name="Port"></td>
            <td><input style="width:30px"type="text" value="<%= f.getuNo() %>" name="uNo"></td>
            <td><input style="width:30px"type="text" value="<%= f.getPoYn() %>" name="PoYn"></td>
            <td><input style="width:80px"type="date" value="<%= f.getPoModifyDate() %>" name="PoModifyDate"></td>
            <td><input style="width:50px"type="text" value="<%= f.getPoModifyWriter() %>" name="PoModifyWriter"></td>
           
           
            <td>
            <input type="submit" value="완료" class="btn btn-primary" id=alter<%= f.getPortNo() %>
            style=width:35px;height:25px;font-size:1em;margin:0px;padding:0px;></td>
            
         </tr>
     
         
         
                  </tbody>
                </table>
                   </form>  
              </div>
            </div>
          </div>

        </div>
        
        <script>
        
    <%--     function Submit2(){
        	console.log(<%= f.getPoModifyWriter() %>);
        	console.log(<%= f.getPort() %>);
        	console.log(<%= f.getuNo() %>);
        	console.log(<%=f.getPortNo()%>);
        	console.log(<%= f.getPoModifyDate() %>);
        	$("#updateForm").submit();
         	location.href="portfolio.jsp"
       } --%>
        
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
