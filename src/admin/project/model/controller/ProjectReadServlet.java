package admin.project.model.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.company.model.service.CompanyService;
import admin.company.model.vo.Company;
import admin.project.model.service.ProjectService;
import admin.project.model.vo.Project;

/**
 * Servlet implementation class MemberReadServlet
 */
@WebServlet("/projectRead.do")
public class ProjectReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ProjectReadServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Project> plist = new ArrayList<Project>();
		ProjectService ps = new ProjectService();
		
		
		plist = ps.readProject();
		String page = null;
		
		if(plist!=null) {
			page= "project.jsp";
			request.setAttribute("plist", plist);
		}else {
			page = "errorPage.jsp";
			request.setAttribute("msg", "프로젝트 목록 불러오기 에러!");
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
