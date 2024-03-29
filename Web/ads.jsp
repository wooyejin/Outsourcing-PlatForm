<%@page import="java.text.DecimalFormat"%>
<%@page import="admin.ads.model.vo.Asset"%>
<%@page import="admin.ads.model.vo.Ads"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <% 
   ArrayList<Ads> alist = (ArrayList<Ads>)request.getAttribute("alist"); 
   ArrayList<Asset> aslist = (ArrayList<Asset>)request.getAttribute("aslist"); 
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
        <h1 class="h3 mb-2 text-gray-800">ADS</h1>
         

        <!-- DataTales Example -->
        <div class="card shadow mb-4"style="font-size:13px;">
          <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">광고테이블</h6>
          </div>
          <div class="card-body">
            <div class="table-responsive">
              <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                  <tr style="font-size:13px;">
                    <th>기업번호(fk)</th>
                    <th>프로젝트번호(fk)</th>
                    <th>광고시작</th>
                    <th>광고종료</th>
                    <th>광고수익</th>
                    <th>수정날짜</th>
                    <th>수정자/내용</th>
                    <th></th>
                  </tr>
                </thead>
                <tfoot>
                 <tr style="font-size:13px;">
                    <th>기업번호(fk)</th>
                    <th>프로젝트번호(fk)</th>
                    <th>광고시작</th>
                    <th>광고종료</th>
                    <th>광고수익</th>
                    <th>수정날짜</th>
                    <th>수정자/내용</th>
                  
                   
                    
                    <th><button class="btn btn-primary" onclick="Insert()"
            style=width:35px;height:25px;font-size:1em;margin:0px;padding:0px;>추가</button></th> 
                    	  
                  </tr>
                </tfoot>
                <tbody>
                
              
         <% 
         
         	Date today = new Date();
         
        	 DecimalFormat formatter = new DecimalFormat("###,###");
         for(Ads a : alist){
        	 
                 String ap = formatter.format(a.getAdsPrice());
         	int compare = a.getAdsEnd().compareTo(today);
        	 
        	 if(compare>0){
        	 %>
     
         <tr style="font-size:13px;">
            <input type="hidden" id="aNo<%= a.getcNo() %>" value="<%= a.getcNo() %>"/>
            <td><a href="/win/cConnect.do?cNo=<%= a.getcNo() %>";><%= a.getcNo() %></a></td>
            <td><a href="/win/pConnect.do?pNo=<%= a.getpNo() %>";><%=a.getpNo() %></a></td>
            <td><%= a.getAdsStart() %></td>
            <td><%= a.getAdsEnd() %></td>
            <td><%= ap %>원</td>
            <td><%= a.getAdsModifyDate() %></td>
            <td><%= a.getAdsModifyWriter() %></td>
           
            <td><button class="btn btn-primary" id=<%= a.getcNo() %> onclick="Update(this.id)"
            style=width:35px;height:25px;font-size:1em;margin:0px;padding:0px;>수정</button>
            
            
         </tr>
         <% }else{%>
        	 <tr style="font-size:13px; background:ivory;" >
             <input type="hidden" id="aNo<%= a.getcNo() %>" value="<%= a.getcNo() %>"/>
             <td><a href="/win/cConnect.do?cNo=<%= a.getcNo() %>";><%= a.getcNo() %></a></td>
             <td><a href="/win/pConnect.do?pNo=<%= a.getpNo() %>";><%=a.getpNo() %></a></td>
             <td><%= a.getAdsStart() %></td>
             <td><%= a.getAdsEnd() %>(광고마감)</td>
             <td><%= ap %>원</td>
             <td><%= a.getAdsModifyDate() %></td>
             <td><%= a.getAdsModifyWriter() %></td>
            
             <td><button class="btn btn-primary" id=<%= a.getcNo() %> onclick="Update(this.id)"
             style=width:35px;height:25px;font-size:1em;margin:0px;padding:0px;>수정</button>
             
             
          </tr>
        	 
       <% }
        	 }%>  
                  </tbody>
                </table>
              </div>
            </div>
          </div>

        </div>
        
        <script>
        
        function Update(aguments){
        	<% Ads a = new Ads(); %>
        	var cNo = aguments;
			location.href="/win/aSelectOne.do?cNo=" + cNo;
        	
        }
        function Insert(){
			location.href="/win/adsInsert.jsp"
        	
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
