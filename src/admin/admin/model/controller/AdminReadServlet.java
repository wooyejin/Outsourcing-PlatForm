package admin.admin.model.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.admin.model.service.AdminService;
import admin.admin.model.vo.Admin;

/**
 * Servlet implementation class AdminReadServlet
 */
@WebServlet("/adminRead.do")
public class AdminReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminReadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Admin> adlist = new ArrayList<Admin>();
		AdminService ads = new AdminService();
		
		adlist = ads.readAdmin();
		System.out.println("adminread");
		String page = null;
		System.out.println(adlist);
		if(adlist!=null) {
		
			page= "index.jsp";
			request.setAttribute("adlist", adlist);
			
			}else {
				
			page = "errorPage.jsp";
			request.setAttribute("msg", "기업회원 목록 불러오기 에러!");
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
