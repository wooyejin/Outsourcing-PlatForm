package admin.portfolio.model.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.portfolio.model.service.PortfolioService;
import admin.portfolio.model.vo.Portfolio;
import win.model.vo.Member;

/**
 * Servlet implementation class MemberReadServlet
 */
@WebServlet("/fUpdate.do")
public class PortfolioUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public PortfolioUpdateServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//회원정보 수정용 데이터 꺼내오기
				int no = Integer.parseInt(request.getParameter("portNo"));
				int uno = Integer.parseInt(request.getParameter("uNo"));
				String port = request.getParameter("Port");
				String poYn = request.getParameter("PoYn");
				String modifydate = request.getParameter("PoModifyDate");
				String modifywriter = request.getParameter("PoModifyWriter");
			
				//해당 회원을 구분짓는 ID 받아오기
				HttpSession session = request.getSession(false);
				
				
				Portfolio f = new Portfolio();
				Member m = new Member();
				m.setNo(uno);
				m.setFileYN(poYn);
				Date writeDate = null;
				
				if(modifydate != ""&& modifydate != null) {
					//날짜가 들어 왔을 때

					String[] dateArr = modifydate.split("-");
					int[] intArr = new int[dateArr.length];
					
					//String -->int
					for(int i = 0; i<dateArr.length;i++) {
						intArr[i] = Integer.parseInt(dateArr[i]);
					}
					
					writeDate = new Date(new GregorianCalendar(
							intArr[0],intArr[1]-1,intArr[2]
							).getTimeInMillis());
				}else {
					//날짜가 들어오지 않으면
					writeDate = new Date(new GregorianCalendar().getTimeInMillis());
				}
				
				
				
				
				//기존의 회원 정보를 새로운 값으로 변경하기
			
			f.setPortNo(no);
			f.setuNo(uno);
			f.setPort(port);
			f.setPoYn(poYn);
				
				f.setPoModifyDate(writeDate);
				f.setPoModifyWriter(modifywriter);
				
				System.out.println("변경한 포폴 정보 확인 : "+f);
				
				PortfolioService fs = new PortfolioService();
				
				
				int result = fs.updatePortfolio(f,m);
				
				if(result>0) {
					
					response.sendRedirect("/win/portfolioRead.do");
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
