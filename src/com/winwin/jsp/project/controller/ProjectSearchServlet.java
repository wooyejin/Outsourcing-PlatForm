package com.winwin.jsp.project.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.winwin.jsp.project.model.service.ProjectService;
import com.winwin.jsp.project.model.vo.PageInfo;
import com.winwin.jsp.project.model.vo.Project;

/**
 * Servlet implementation class ProjectSearchServlet
 */
@WebServlet("/pSearch.do")
public class ProjectSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Project> list = new ArrayList<Project>();
		
		ProjectService ps = new ProjectService();
		
		String sort = request.getParameter("sort");
		
		int startPage;
		int endPage;
		int maxPage;
		int currentPage;
		int limit;
		currentPage = 1;
		limit = 3;
		
		
		
		// 페이징
		String currentPage1 = request.getParameter("currentPage");
		
//		String category = request.getParameter("con");
		String category = String.join(", ",request.getParameterValues("con"));
		String keyword = request.getParameter("keyword");
		
		
		
		System.out.println("category : "  + category);
		System.out.println("keyword : " + keyword);
		System.out.println("currentPage1 : " + currentPage1);
		
		if(currentPage1 != null) {
			currentPage = Integer.parseInt(currentPage1);
		}
		
		int listCount = ps.getListCount();
		maxPage = (int)((double)listCount/ limit + 0.9);
		startPage = ((int)((double)currentPage/limit + 0.9)-1)* limit + 1;
		endPage = startPage + limit -1;
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		System.out.println("currentPage :"+currentPage);
		System.out.println("listCount :"+listCount);
		System.out.println("limit :"+limit);
		System.out.println("maxPage :"+maxPage);
		System.out.println("startPage :"+startPage);
		System.out.println("endPage :"+endPage);
		
	
		
		list = ps.searchProject(currentPage,limit, category,keyword,sort);
		System.out.println(list);
		String page = "";
		
		if(list != null) {
			page = "Project/projectFind.jsp";
			request.setAttribute("list", list);
			
			PageInfo pi = new PageInfo(currentPage,listCount,limit,maxPage,startPage,endPage);
			request.setAttribute("pi", pi);
		}else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "프로젝트 검색 실패!");
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
