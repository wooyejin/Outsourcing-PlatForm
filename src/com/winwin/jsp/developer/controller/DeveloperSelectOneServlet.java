package com.winwin.jsp.developer.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.winwin.jsp.developer.model.service.developerService;
import com.winwin.jsp.developer.model.vo.developer;

/**
 * Servlet implementation class DeveloperSelectOnerServlet
 */
@WebServlet("/dselect.do")
public class DeveloperSelectOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeveloperSelectOneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int dno = Integer.parseInt(request.getParameter("dno"));
		System.out.println("Serlvet dno : " + dno);
		developerService ps = new developerService();
		
		// 프로젝트 상세조회용
		developer d = ps.selectOne(dno);
		
		
		
		String page = "";
		
		if(d != null) {
			page = "Project/developer.jsp";
			request.setAttribute("developer", d);
			
			
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
