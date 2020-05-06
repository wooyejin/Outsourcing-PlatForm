package admin.project.model.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.project.model.service.ProjectService;
import admin.project.model.vo.Project;

/**
 * Servlet implementation class CompanySelectOneServlet
 */
@WebServlet("/pConnect.do")
public class ProjectConnectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectConnectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				int pNo = Integer.parseInt(request.getParameter("pNo"));
				System.out.println(pNo);
				ProjectService ps = new ProjectService();
				Project p = ps.selectOne(pNo);
				
				String page = ""; 
				
				if(p != null) {
					page = "projectConnect.jsp";
					request.setAttribute("project", p);
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
