<%@page import="java.text.DecimalFormat"%>
<%@page import="admin.ads.model.dao.AdsDao"%>
<%@page import="admin.ads.model.vo.Asset"%>
<%@page import="admin.ads.model.vo.Ads"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <% 
   ArrayList<Ads> alist = (ArrayList<Ads>)request.getAttribute("alist"); 
   ArrayList<Asset> aslist = (ArrayList<Asset>)request.getAttribute("aslist"); 
   Asset ass = new Asset();
   AdsDao ad = new AdsDao();
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
        <h1 class="h3 mb-2 text-gray-800">회계</h1>
         

        <!-- DataTales Example -->
        <div class="card shadow mb-4"style="font-size:13px;">
          <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">회계테이블</h6>
          </div>
          <div class="card-body">
            <div class="table-responsive">
              <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                 <tr style="font-size:13px;">
                    <th>기업번호(fk)</th>
                    <th>기업명</th>
                    <th>프로젝트번호(fk)</th>
                    <th>프로젝트 비용(원)</th>
                    <th>모든 진행비용(원)</th>
                    <th>WIN수익(원)</th>
                    <th>총광고수익(원)</th>
                    <th>업데이트날짜</th>
                    
                  </tr>
                </thead>
                
               
                <tbody>
         <% 
         DecimalFormat formatter = new DecimalFormat("###,###");
         for(Asset as : aslist){ 
             String apc = formatter.format(as.getpCost());
        	 String ar = formatter.format(as.getAssetRevenue());
             String aar = formatter.format(as.getAssetAdsRevenue());
        	 
        	 
         %>
     
         <tr style="font-size:13px;">
            <input type="hidden" id="aNo<%= as.getcNo() %>" value="<%= as.getcNo() %>"/>
            <td><a href="/win/cConnect.do?cNo=<%= as.getcNo() %>";><%= as.getcNo() %></a></td>
            <td><%= as.getcName() %></td>
            <td><a href="/win/pConnect.do?pNo=<%= as.getpNo() %>";><%=as.getpNo() %></a></td>
            <td><%= apc %>원</td>
            <td>-</td>
            <td><%= ar %>원</td>
            <td><%= aar %>원</td>
            <td><%= as.getAssetUpdateDate() %></td>
         
         </tr>
         <% } %>  
                  </tbody>
                <tfoot>
                  <tr style="font-size:13px;">
                    <th>기업번호(fk)</th>
                    <th>기업명</th>
                    <th>프로젝트번호(fk)</th>
                    <th>프로젝트 비용</th>
                           <% 
                         
                          
                           for(Asset as : aslist){
                        	   
                        	   
                           String at = formatter.format(as.getAssetTotal());
                           String arrr = formatter.format(as.getAssetRevenueTotal());
                           String aat = formatter.format(as.getAssetAdsTotal());
                           
                           
                        	   
                        	   if(as.getCount()==as.getpNo()){
         %>
                    <th><%= at %>원</th>
                    <td><%= arrr %>원</td>
            <td><%= aat %>원</td>
                   <% };
                        	   } %>
                    <th>업데이트날짜</th>
                    
                  </tr>
                </tfoot>
                </table>
              </div>
            </div>
          </div>

        
       
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
