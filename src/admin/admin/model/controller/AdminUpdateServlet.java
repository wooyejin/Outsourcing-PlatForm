package admin.admin.model.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.admin.model.service.AdminService;
import admin.admin.model.vo.Admin;

/**
 * Servlet implementation class AdminReadServlet
 */
@WebServlet("/adUpdate.do")
public class AdminUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AdminUpdateServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//회원정보 수정용 데이터 꺼내오기
				
				
				//해당 회원을 구분짓는 ID 받아오기
				HttpSession session = request.getSession(false);
				
				//Member m = (Member)session.getAttribute("member");
				
				Admin ad = new Admin();
				
				
				AdminService ads = new AdminService();
				
				
				int result = ads.updateAdmin(ad);
				
				if(result>0) {

					response.sendRedirect("//adminRead.do");
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
