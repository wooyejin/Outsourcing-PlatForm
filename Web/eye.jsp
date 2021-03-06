<%@page import="admin.eye.model.vo.Eye"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.regex.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <% 
   ArrayList<Eye> elist = (ArrayList<Eye>)request.getAttribute("elist"); 
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
   <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>

<body id="page-top">
  <%@include file="header.jsp" %>

        <!-- Begin Page Content -->
        <div class="container-fluid">

                
        <!-- Page Heading -->
        <h1 class="h3 mb-2 text-gray-800">감시</h1>
         

        <!-- DataTales Example -->
        <div class="card shadow mb-4"style="font-size:13px;">
          <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">댓글관리</h6>
          </div>
          <div class="card-body">
            <div class="table-responsive">
              <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                  <tr style="font-size:13px;">
                    <th>댓글번호</th>
                    <th>작성자</th>
                    <th>작성일</th>
                    <th>내용</th>
                    <th>공개여부</th>
                    <th>감시</th>
                    <th></th>
                  </tr>
                </thead>
                <tfoot>
                 <tr style="font-size:13px;">
                   <th>댓글번호</th>
                    <th>작성자</th>
                    <th>작성일</th>
                    <th>내용</th>
                    <th>공개여부</th>
                    <th>감시</th>
                    <th></th>  
                  </tr>
                </tfoot>
                <tbody>
                
              
         <% for(Eye e : elist){ 
         
        	 
        	
        	 String regex1 = "@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+";


        	 Pattern p1 = Pattern.compile(regex1,Pattern.CASE_INSENSITIVE); 
        	 Matcher m1 = p1.matcher(e.geteContent()); 
        	 boolean validation1 = m1.find(); 
        	 
        	 String regex2 = "01(?:0|1[6-9])[.-]?(\\d{3}|\\d{4})[.-]?(\\d{4})"; 
        	 Pattern p2 = Pattern.compile(regex2,Pattern.CASE_INSENSITIVE); 
        	 Matcher m2 = p2.matcher(e.geteContent()); 
        	 boolean validation2 = m2.find(); 
        	 
        	 String regex3 = "[.-]?(\\d{4})"; 
        	 Pattern p3 = Pattern.compile(regex3,Pattern.CASE_INSENSITIVE); 
        	 Matcher m3 = p3.matcher(e.geteContent()); 
        	 boolean validation3 = m3.find(); 
        	 
        	 String regex4 = "01(?:0|1|[6-9])"; 
        	 Pattern p4 = Pattern.compile(regex4,Pattern.CASE_INSENSITIVE); 
        	 Matcher m4 = p4.matcher(e.geteContent()); 
        	 boolean validation4 = m4.find();
        	 
        	
        	 
        	 
        	 
        	 if(validation1==true ||validation2==true ||validation3==true||validation4==true){ %>
        	 
    
        	 <% if(e.geteYn().equals("N")){%>  <!-- 감시에잡힌댓글이 N일때 -->
     
         <tr style="font-size:13px;background:pink;">
            <td><%= e.geteNo() %></td>
            <td><%= e.geteWriter() %></td>
            <td><%= e.geteDate() %></td>
            <td><%= e.geteContent() %></td>
            <td><%= e.geteYn() %></td>
            <td>RED</td>
            <td></td>
           
         </tr>
            
        
       <%}else{ %>  
       
       
         <tr style="font-size:13px;background:pink;"><!-- 감시에잡힌댓글이 Y일때 -->
            <td><%= e.geteNo() %></td>
            <td><%= e.geteWriter() %></td>
            <td><%= e.geteDate() %></td>
            <td><%= e.geteContent() %></td>
            <td><%= e.geteYn() %></td>
            <td>RED</td>
            <td></td>
            <td></td>
         
         <script>
         $(function(){
        	 
         location.href="/win/eUpdate.do?no="+'<%=e.geteNo()%>'+"&yn="+'<%= e.geteYn() %>'; 
         });
         </script>
         </tr>
         
         <%}%>
        	 
        	 
        	 
        	 
        	 
         <%}else if(e.geteYn().equals("N")){%>
     
         <tr style="font-size:13px;background:ivory;"><!-- 기본댓글이 N일때 -->
            <td><%= e.geteNo() %></td>
            <td><%= e.geteWriter() %></td>
            <td><%= e.geteDate() %></td>
            <td><%= e.geteContent() %></td>
            <td><%= e.geteYn() %></td>
            <td></td>
            <td><button class="btn btn-primary" id=<%= e.geteNo() %> onclick="yn()"
            style=width:50px;height:25px;font-size:1em;margin:0px;padding:0px;>공개</button></td>
         </tr>
            
        
       <%}else{ %>  
       
       
         <tr style="font-size:13px;"><!-- 기본댓글이 Y일때 -->
            <td><%= e.geteNo() %></td>
            <td><%= e.geteWriter() %></td>
            <td><%= e.geteDate() %></td>
            <td><%= e.geteContent() %></td>
            <td><%= e.geteYn() %></td>
            <td></td>
            <td><button class="btn btn-primary" id=<%= e.geteNo() %> onclick="yn()"
            style=width:50px;height:25px;font-size:1em;margin:0px;padding:0px;>비공개</button></td>
         </tr>
         
         <%}
       }%>
                  </tbody>
                </table>
              </div>
            </div>
          </div>

        </div>
        
        
        
        <script>
        	 /* $(function(){
        		Submit();
        		
        		var no = $(this).parent().children().eq(0).text();
            	var yn = $(this).parent().children().eq(4).text();
        		
        		location.href="/win/eUpdate.do?no="+no+"&yn="+yn;   
        	}) */
        	 
        	
        function yn(){
            
        	
            $("#dataTable td").click(function(){
             
            	/* 
            	var no = $(this).parent().children().eq(0).text();
            	var yn = $(this).parent().children().eq(4).text();
                	
           
            	location.href="/win/eUpdate.do?no="+no+"&yn="+yn;          
            	 */
            	$.ajax({
          			url:"/win/eUpdate.do",
          			type:"get",
          			data:{
          				/* aMemo : $('#noticeText').val() */
          				no : $(this).parent().children().eq(0).text(),
          				yn : $(this).parent().children().eq(4).text()
          			},
          			success:function(data){
          				location.href="/win/eyeRead.do" 
          				
          			},
          			error:function(){
          			},
          			complete:function(){
          					
          				
          			}
          		});
            	
            	
            }); 
         }
         
        
       /*    function Submit1(aguments){
        	 $("#updateForm").submit();
         	location.href="/win/eye.jsp"
        }
         function Submit2(aguments){
        	 $("#updateForm").submit();
         	location.href="/win/eye.jsp"
        } */
         
        
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
