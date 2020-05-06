package com.winwin.jsp.enterProject.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import win.model.service.MemberService;
import win.model.vo.Member;

/**
 * Servlet implementation class enterProject
 */
@WebServlet("/eprjt.do")
public class enterProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public enterProject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		HttpSession session = request.getSession();
		Member m = (Member)session.getAttribute("member");
		
		
		int pno = Integer.parseInt(request.getParameter("pno"));
		int uno = m.getNo();
		System.out.println("pno : " +pno);
		
		MemberService ms = new MemberService();
	 	int result = ms.insertApp(uno,pno);
		
		response.getWriter().print((result>0) ? "ok" : "no");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
