package admin.admin.model.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.admin.model.service.AdminService;
import admin.admin.model.vo.Admin;

/**
 * Servlet implementation class AdsReadServlet
 */
@WebServlet("/adInsert.do")
public class AdminInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AdminInsertServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//회원정보 수정용 데이터 꺼내오기
			
				String aMemo = request.getParameter("aMemo");
			
				
				
				AdminService adss = new AdminService();
				
				
				int result = adss.insertAdmin(aMemo);
				
				if(result>0) {
					
					System.out.println("memo등록성공");
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
