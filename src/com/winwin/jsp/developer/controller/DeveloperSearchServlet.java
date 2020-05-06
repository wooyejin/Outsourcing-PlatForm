package com.winwin.jsp.developer.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.winwin.jsp.developer.model.service.developerService;
import com.winwin.jsp.developer.model.vo.developer;
import com.winwin.jsp.developer.model.vo.PageInfo;

/**
 * Servlet implementation class DeveloperSearchServlet
 */
@WebServlet("/dsearch.do")
public class DeveloperSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeveloperSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
ArrayList<developer> list = new ArrayList<developer>();
		
		developerService ps = new developerService();
		
		
		
		int startPage;
		int endPage;
		int maxPage;
		int currentPage;
		int limit;
		currentPage = 1;
		limit = 10;
		
		
		
		// 페이징
		String currentPage1 = request.getParameter("currentPage");
		

		String keyword = request.getParameter("keyword");
		
		
		
		
		
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
	
	
		
		list = ps.searchdeveloper(currentPage,limit,keyword);
		String page = "";
		
		if(list != null) {
			page = "Project/developer.jsp";
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
