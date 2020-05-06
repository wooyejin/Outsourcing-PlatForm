package admin.portfolio.model.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.portfolio.model.service.PortfolioService;
import admin.portfolio.model.vo.Portfolio;

/**
 * Servlet implementation class portfolioReadServlet
 */
@WebServlet("/portfolioRead.do")
public class portfolioReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public portfolioReadServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Portfolio> flist = new ArrayList<Portfolio>();
		PortfolioService fs = new PortfolioService();
		

		flist = fs.readPortfolio();
		String page = null;
		
		
		if(flist!=null) {
			page= "portfolio.jsp";
			request.setAttribute("flist", flist);
			
		}else {
			page = "errorPage.jsp";
			request.setAttribute("msg", "회원 목록 불러오기 에러!");
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
