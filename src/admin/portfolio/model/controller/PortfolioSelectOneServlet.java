package admin.portfolio.model.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.portfolio.model.service.PortfolioService;
import admin.portfolio.model.vo.Portfolio;

/**
 * Servlet implementation class PortfolioSelectOneServlet
 */
@WebServlet("/fSelectOne.do")
public class PortfolioSelectOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PortfolioSelectOneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//내가 클릭한 게시물을 호출하기위해서 필요한 값을 받아서 변수에 담는다.
				int portNo = Integer.parseInt(request.getParameter("portNo"));
				System.out.println(portNo);
				PortfolioService fs = new PortfolioService();
				
				Portfolio f = fs.selectOne(portNo);
				
				String page = ""; 
				
				if(f != null) {
					page = "portfolioUpdate.jsp";
					request.setAttribute("portfolio", f);
				}else {
					page = "errorPage.jsp";
					request.setAttribute("msg", "공지사항 상세보기 실패!");
				}
				
				request.getRequestDispatcher(page).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
