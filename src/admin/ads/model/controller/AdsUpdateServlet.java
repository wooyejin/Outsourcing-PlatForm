package admin.ads.model.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.ads.model.service.AdsService;
import admin.ads.model.vo.Ads;

/**
 * Servlet implementation class AdsReadServlet
 */
@WebServlet("/aUpdate.do")
public class AdsUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AdsUpdateServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//회원정보 수정용 데이터 꺼내오기
				int cno = Integer.parseInt(request.getParameter("cNo"));
				int pno = Integer.parseInt(request.getParameter("pNo"));
				String adsstart = request.getParameter("adsStart");
				String adsend = request.getParameter("adsEnd");
				int adsprice = Integer.parseInt(request.getParameter("adsPrice"));
				String adsmodifydate = request.getParameter("adsModifyDate");
				String adsmodifywriter = request.getParameter("adsModifyWriter");
				
				
				//해당 회원을 구분짓는 ID 받아오기
				HttpSession session = request.getSession(false);
				
				//Member m = (Member)session.getAttribute("member");
				
				Ads a = new Ads();
				
				Date writeDate = null;
				Date startDate = null;
				Date endDate = null;
				
				if(adsstart != ""&& adsstart != null) {

					String[] dateArr1 = adsstart.split("-");
					int[] intArr1 = new int[dateArr1.length];
					
					for(int i = 0; i<dateArr1.length;i++) {
						intArr1[i] = Integer.parseInt(dateArr1[i]);
					}
					
					startDate = new Date(new GregorianCalendar(
							intArr1[0],intArr1[1]-1,intArr1[2]
							).getTimeInMillis());
				}else {
					startDate = new Date(new GregorianCalendar().getTimeInMillis());
				}
				
				
				if(adsend != ""&& adsend != null) {
					
					String[] dateArr2 = adsend.split("-");
					int[] intArr2 = new int[dateArr2.length];
					
					for(int i = 0; i<dateArr2.length;i++) {
						intArr2[i] = Integer.parseInt(dateArr2[i]);
					}
					
					endDate = new Date(new GregorianCalendar(
							intArr2[0],intArr2[1]-1,intArr2[2]
							).getTimeInMillis());
				}else {
					endDate = new Date(new GregorianCalendar().getTimeInMillis());
				}
				
				
				if(adsmodifydate != ""&& adsmodifydate != null) {
					
					String[] dateArr3 = adsmodifydate.split("-");
					int[] intArr3 = new int[dateArr3.length];
					
					for(int i = 0; i<dateArr3.length;i++) {
						intArr3[i] = Integer.parseInt(dateArr3[i]);
					}
					
					writeDate = new Date(new GregorianCalendar(
							intArr3[0],intArr3[1]-1,intArr3[2]
							).getTimeInMillis());
				}else {
					writeDate = new Date(new GregorianCalendar().getTimeInMillis());
				}
				
				
				
				
				//기존의 회원 정보를 새로운 값으로 변경하기
			
				a.setcNo(cno);
				a.setpNo(pno);
				a.setAdsStart(startDate);
				a.setAdsEnd(endDate);
				a.setAdsPrice(adsprice);
				a.setAdsModifyDate(writeDate);
				a.setAdsModifyWriter(adsmodifywriter);
				
				
				System.out.println("변경한 회원 정보 확인 : "+a);
				
				AdsService as = new AdsService();
				
				
				int result = as.updateAds(a);
				
				if(result>0) {
					
					response.sendRedirect("/win/adsRead.do");
				}else {
					
					request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
