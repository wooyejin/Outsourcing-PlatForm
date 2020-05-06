<%@page import="admin.admin.model.vo.Admin"%>
<%@page import="admin.admin.model.service.AdminService"%>
<%@page import="admin.portfolio.model.vo.Portfolio"%>
<%@page import="admin.portfolio.model.service.PortfolioService"%>
<%@page import="admin.project.model.vo.Project"%>
<%@page import="admin.project.model.service.ProjectService"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="admin.ads.model.service.AdsService"%>
<%@page import="admin.ads.model.dao.AdsDao"%>
<%@page import="admin.ads.model.vo.Asset"%>
<%@page import="admin.ads.model.vo.Ads"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <% 
     AdsService as = new AdsService();
    ArrayList<Ads> alist =  as.readAds(); /* (ArrayList<Ads>)request.getAttribute("alist");  //선언부분
  /* ArrayList<Asset> aslist = as.readAs(); /* (ArrayList<Asset>)request.getAttribute("aslist"); */ 
   
   
   
   
   
   Asset ass = new Asset();
   AdsDao ad = new AdsDao();
   
   
   ProjectService ps = new ProjectService();//프로젝트 가져오기부분
   ArrayList<Project> plist = new ArrayList<Project>();
   plist = ps.readProject();
   int pcount=0;
   for(int i=0;i<plist.size();i++){
	  if(plist.get(i).getStatus().equals("N")){
		  pcount++;
	  }
   }
   
   PortfolioService fs = new PortfolioService();
   ArrayList<Portfolio> flist = new ArrayList<Portfolio>();
   flist = fs.readPortfolio();
   int fcount=0;
   for(int i=0;i<flist.size();i++){
		  if(flist.get(i).getPoYn().equals("N")){
			  fcount++;
		  }
	   }
	   
   
   
  
   ArrayList<Asset> asslist = new ArrayList<Asset>();
  asslist = as.readAs();
  int total = 0;
 int revenueTotal =0;
 int adsTotal =0;
  
  for(int i=0;i<asslist.size();i++){//수익 담는 포문
  total += asslist.get(i).getpCost();
  revenueTotal += asslist.get(i).getpCost()*0.05;
  adsTotal += asslist.get(i).getAssetAdsRevenue();
  
  }
  int raTotal = revenueTotal+adsTotal;
  
  DecimalFormat formatter = new DecimalFormat("###,###");//돈 포멧
  
  String to = formatter.format(total);
  String ra = formatter.format(adsTotal);
   
 
   
%>    
<!DOCTYPE html>
<html lang="en">
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>winwin admin page</title>

  <!-- Custom fonts for this template-->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body id="page-top">
<%@include file="header.jsp" %>

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <h1 class="h3 mb-0 text-gray-800"><sup>win</sup>win</h1>
            
          </div>

          <!-- Content Row -->
          <div class="row">

            <!-- Earnings (Monthly) Card Example -->
            <div class="col-xl-3 col-md-6 mb-4">
            <a href="/win/asRead.do">
              <div class="card border-left-primary shadow h-100 py-2">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="text-s font-weight-bold text-primary text-uppercase mb-1">총 프로젝트 진행비</div>
                      <div class="h5 mb-0 font-weight-bold text-gray-800"><%= to %>원</div>
                    </div>
                    <div class="col-auto">
                      <i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
                    </div>
                  </div>
                </div>
              </div>
</a>
            </div>
            <!-- Earnings (Monthly) Card Example -->
            <div class="col-xl-3 col-md-6 mb-4">
            <a href="/win/adsRead.do">
              <div class="card border-left-success shadow h-100 py-2">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="text-s font-weight-bold text-success text-uppercase mb-1">총 광고 수익</div>
                      <div class="h5 mb-0 font-weight-bold text-gray-800"><%= ra %>원</div>
                    </div>
                    <div class="col-auto">
                      <i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
                    </div>
                  </div>
                </div>
              </div>
              </a>
            </div>

            <!-- Earnings (Monthly) Card Example -->
            <div class="col-xl-3 col-md-6 mb-4">
              <a href="/win/projectRead.do">
                <div class="card border-left-info shadow h-100 py-2">
                  <div class="card-body">
                    <div class="row no-gutters align-items-center">
                      <div class="col mr-2">
                        <div class="text-s font-weight-bold text-info text-uppercase mb-1">프로젝트 승인 대기</div>
                          <div class="h5 mb-0 mr-3 font-weight-bold text-gray-800"><%= pcount %> 건</div>
                      </div>
                      <div class="col-auto">
                        <i class="fas fa-file-signature fa-2x text-gray-300"></i>
                      </div>
                    </div>
                  </div>
                </div>
              </a>
            </div>

            <!-- Pending Requests Card Example -->
            <div class="col-xl-3 col-md-6 mb-4">
              <a href="/win/portfolioRead.do">
                <div class="card border-left-warning shadow h-100 py-2">
                  <div class="card-body">
                    <div class="row no-gutters align-items-center">
                      <div class="col mr-2">
                        <div class="text-s font-weight-bold text-warning text-uppercase mb-1">포트폴리오 승인 대기</div>
                        <div class="h5 mb-0 font-weight-bold text-gray-800"><%= fcount %> 건</div>
                      </div>
                      <div class="col-auto">
                        <i class="fas fa-address-card fa-2x text-gray-300"></i>
                      </div>
                    </div>
                  </div>
                </div>
              </a>
            </div>


          </div>
<br><br><br><br>
          <!-- Content Row -->

          <div class="row">

            <!-- Area Chart -->
            <div class="col-xl-8 col-lg-7">
              <div class="card shadow mb-4">
                <!-- Card Header - Dropdown -->
                <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                  <h6 class="m-0 font-weight-bold text-primary">매출 개요</h6>
                  <div class="dropdown no-arrow">
                    
                    
                  </div>
                </div>
                <!-- Card Body -->
                <div class="card-body">
                  <div class="chart-area">
                  
                    <canvas id="myAreaChart1"></canvas>
                  </div>
                </div>
              </div>
            </div>

            <!-- Pie Chart -->
            <div class="col-xl-4 col-lg-5">
              <div class="card shadow mb-4">
                <!-- Card Header - Dropdown -->
                <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                  <h6 class="m-0 font-weight-bold text-primary">회원 현황</h6>
                  <div class="dropdown no-arrow">
                    
                    
                  </div>
                </div>
                <!-- Card Body -->
                <div class="card-body">
                  <div class="chart-pie pt-4 pb-2">
                  
                  <% AdminService adms = new AdminService();
                  	AdsService asser = new AdsService();
                  	
                  ArrayList<Admin> admlist = new ArrayList<Admin>();
                  ArrayList<Asset> assetlist = new ArrayList<Asset>();
                  
                  Admin adm = new Admin();
                  Asset asset = new Asset();
                  int result1 = ads.updateAdmin(adm);
                  admlist = adms.readAdmin();
                  assetlist = asser.readAs();
                  
                  int admcCount =0;//도넛차트숫자 부분
                  int admuCount =0;
                  
                  int mon1 = 0; //월별 수익차트 값부분
                  int mon2 = 0; 
                  int mon3 = 0; 
                  int mon4 = 0; 
                  int mon5 = 0; 
                  int mon6 = 0; 
                  int mon7 = 0; 
                  int mon8 = 0; 
                  int mon9 = 0; 
                  int mon10 = 0; 
                  int mon11 = 0; 
                  int mon12 = 0; 
                  
                  for(int i=0;i<1;i++){//갯수 담는 포문
                	  
                	  admcCount = adlist.get(i).getCcCount();
                	  admuCount = adlist.get(i).getUuCount();
                	 
                	  } 
                  for(int i=0;i<assetlist.size();i++){//갯수 담는 포문
                	  int mon =assetlist.get(i).getAssetUpdateDate().getMonth()+1;
                	  if(mon==1){
                		  mon1+=assetlist.get(i).getAssetRevenue();
                	  }else if(mon==2){
                		  mon2+=assetlist.get(i).getAssetRevenue();
                	  }else if(mon==3){
                		  mon3+=assetlist.get(i).getAssetRevenue();
                	  }else if(mon==4){
                		  mon4+=assetlist.get(i).getAssetRevenue();
                	  }else if(mon==5){
                		  mon5+=assetlist.get(i).getAssetRevenue();
                	  }else if(mon==6){
                		  mon6+=assetlist.get(i).getAssetRevenue();
                	  }else if(mon==7){
                		  mon7+=assetlist.get(i).getAssetRevenue();
                	  }else if(mon==8){
                		  mon8+=assetlist.get(i).getAssetRevenue();
                	  }else if(mon==9){
                		  mon9+=assetlist.get(i).getAssetRevenue();
                	  }else if(mon==10){
                		  mon10+=assetlist.get(i).getAssetRevenue();
                	  }else if(mon==11){
                		  mon11+=assetlist.get(i).getAssetRevenue();
                	  }else if(mon==12){
                		  mon12+=assetlist.get(i).getAssetRevenue();
                	  }
                	 
                	  } 
                  %>
                    <canvas id="myChart"></canvas>
<script>

Chart.defaults.global.defaultFontFamily = 'Nunito', '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#858796';

var ctx = document.getElementById('myChart').getContext('2d'); //도넛차트
var myChart = new Chart(ctx, {
    type: 'doughnut',
    data: {
        labels: ['기업회원', '개발자회원'],
        datasets: [{
            data: [<%= admcCount %> , <%= admuCount %>],
            backgroundColor: [
            	'#4e73df', '#1cc88a', '#36b9cc'
            ],
            hoverBackgroundColor: ['#2e59d9', '#17a673', '#2c9faf'],
            hoverBorderColor: "rgba(234, 236, 244, 1)",
        }]
    },
    options: {
    	 maintainAspectRatio: false,
    	    tooltips: {
    	      backgroundColor: "rgb(255,255,255)",
    	      bodyFontColor: "#858796",
    	      borderColor: '#dddfeb',
    	      borderWidth: 1,
    	      xPadding: 15,
    	      yPadding: 15,
    	      displayColors: false,
    	      caretPadding: 10,
        scales: {
            yAxes: [{
                ticks: {
                    beginAtZero: true
                }
            }]
        }
    },
    legend: {
        display: false
    },
    cutoutPercentage: 80,
  }
});//도넛차트 끝




function number_format(number, decimals, dec_point, thousands_sep) {//선차트
	  // *     example: number_format(1234.56, 2, ',', ' ');
	  // *     return: '1 234,56'
	  number = (number + '').replace(',', '').replace(' ', '');
	  var n = !isFinite(+number) ? 0 : +number,
	    prec = !isFinite(+decimals) ? 0 : Math.abs(decimals),
	    sep = (typeof thousands_sep === 'undefined') ? ',' : thousands_sep,
	    dec = (typeof dec_point === 'undefined') ? '.' : dec_point,
	    s = '',
	    toFixedFix = function(n, prec) {
	      var k = Math.pow(10, prec);
	      return '' + Math.round(n * k) / k;
	    };
	  // Fix for IE parseFloat(0.55).toFixed(0) = 0;
	  s = (prec ? toFixedFix(n, prec) : '' + Math.round(n)).split('.');
	  if (s[0].length > 3) {
	    s[0] = s[0].replace(/\B(?=(?:\d{3})+(?!\d))/g, sep);
	  }
	  if ((s[1] || '').length < prec) {
	    s[1] = s[1] || '';
	    s[1] += new Array(prec - s[1].length + 1).join('0');
	  }
	  return s.join(dec);
	}

	// Area Chart Example
	var ctx = document.getElementById("myAreaChart1");
	var myLineChart = new Chart(ctx, {
	  type: 'line',
	  data: {
	    labels: ["(20년)1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"],
	    datasets: [{
	      label: "매출",
	      lineTension: 0.3,
	      backgroundColor: "rgba(78, 115, 223, 0.05)",
	      borderColor: "rgba(78, 115, 223, 1)",
	      pointRadius: 3,
	      pointBackgroundColor: "rgba(78, 115, 223, 1)",
	      pointBorderColor: "rgba(78, 115, 223, 1)",
	      pointHoverRadius: 3,
	      pointHoverBackgroundColor: "rgba(78, 115, 223, 1)",
	      pointHoverBorderColor: "rgba(78, 115, 223, 1)",
	      pointHitRadius: 10,
	      pointBorderWidth: 2,
	      data: [<%= mon1%>, <%= mon2%>, <%= mon3%>, <%= mon4%>, <%= mon5%>, <%= mon6%>, <%= mon7%>, <%= mon8%>, <%= mon9%>, <%= mon10%>, <%= mon11%>, <%= mon12%>],
	    }],
	  },
	  options: {
	    maintainAspectRatio: false,
	    layout: {
	      padding: {
	        left: 10,
	        right: 25,
	        top: 25,
	        bottom: 0
	      }
	    },
	    scales: {
	      xAxes: [{
	        time: {
	          unit: 'date'
	        },
	        gridLines: {
	          display: false,
	          drawBorder: false
	        },
	        ticks: {
	          maxTicksLimit: 7
	        }
	      }],
	      yAxes: [{
	        ticks: {
	          maxTicksLimit: 5,
	          padding: 10,
	          // Include a dollar sign in the ticks
	          callback: function(value, index, values) {
	            return number_format(value)+'원';
	          }
	        },
	        gridLines: {
	          color: "rgb(234, 236, 244)",
	          zeroLineColor: "rgb(234, 236, 244)",
	          drawBorder: false,
	          borderDash: [2],
	          zeroLineBorderDash: [2]
	        }
	      }],
	    },
	    legend: {
	      display: false
	    },
	    tooltips: {
	      backgroundColor: "rgb(255,255,255)",
	      bodyFontColor: "#858796",
	      titleMarginBottom: 10,
	      titleFontColor: '#6e707e',
	      titleFontSize: 14,
	      borderColor: '#dddfeb',
	      borderWidth: 1,
	      xPadding: 15,
	      yPadding: 15,
	      displayColors: false,
	      intersect: false,
	      mode: 'index',
	      caretPadding: 10,
	      callbacks: {
	        label: function(tooltipItem, chart) {
	          var datasetLabel = chart.datasets[tooltipItem.datasetIndex].label || '';
	          return datasetLabel + ':'+number_format(tooltipItem.yLabel) + ' 원';
	        }
	      }
	    }
	  }
	});//선차트 끝




</script>
                  </div>
                  <div class="mt-4 text-center small">
                    <span class="mr-2">
                      <i class="fas fa-circle text-success"></i> 개발자회원
                    </span>
                    <span class="mr-2">
                      <i class="fas fa-circle text-primary"></i> 기업회원
                    </span>
                  
                  </div>
                </div>
              </div>
            </div>
          </div>

	
          <!-- Content Row -->
          <div class="row">

            <!-- Content Column -->
            <div class="col-lg-6 mb-4">


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
        <div class="modal-body">로그아웃 하시겠습니까?</div>
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
  <script src="vendor/chart.js/Chart.min.js"></script>

  <!-- Page level custom scripts -->
  <script src="js/demo/chart-area-demo.js"></script>
  <script src="js/demo/chart-pie-demo.js"></script>

</body>

</html>
