package com.winwin.jsp.project.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.winwin.jsp.project.model.service.ProjectService;
import com.winwin.jsp.project.model.vo.Project;
import com.winwin.jsp.projectComment.model.service.ProjectCommentService;
import com.winwin.jsp.projectComment.model.vo.ProjectComment;

/**
 * Servlet implementation class ProjectSelectOneServlet
 */
@WebServlet("/selectOne2.bo")
public class ProjectSelectOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectSelectOneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pno = Integer.parseInt(request.getParameter("Pno"));
		System.out.println("Serlvet pno : " + pno);
		ProjectService ps = new ProjectService();
		
		// 프로젝트 상세조회용
		Project p = ps.selectOne(pno);
		
		int count = ps.selectCount(pno);
		
		String page = "";
		
		
		if(p != null) {
			page = "Project/projectDetail.jsp";
			request.setAttribute("project", p);
			request.setAttribute("count", count);
			//request.setAttribute("plist", plist);
			
		}else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "프로젝트 상세 보기 실패!");
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
