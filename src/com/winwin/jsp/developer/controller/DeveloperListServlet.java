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

import win.board.model.service.SkillService;
import win.board.model.vo.Skill;

import com.winwin.jsp.developer.model.vo.PageInfo;

/**
 * Servlet implementation class DeveloperListServlet
 */
@WebServlet("/dlist.do")
public class DeveloperListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeveloperListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<developer> list = null;
		ArrayList<Skill> slist = null;
		developerService bs = new developerService();
		
		// 페이징 처리에 필요한 변수들
		// 한 번에 표시할 페이지들 중 가장 앞의 페이지
		// 1,2,3,4,5 --> 1// 6,7,8,9,10 --> 6
		int startPage;
		
		// 한 번에 표시할 페이지들 중 가장 뒤의 페이지
		int endPage;
		
		// 전체 페이지의 가장 마지막 페이지
		int maxPage;
		
		// 사용자가 위치한 현재 페이지
		int currentPage;
		
		// 총 페이지 수
		int limit;
		
		
		
		// 처음 접속 시 페이지는 1페이지 부터 시작한다.
		currentPage = 1;
		
		// 글 갯수 및 페이지 수 10개로 제한하기
		limit = 5;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		// 페이징 처리
		int listCount = bs.getListCount();
		
		System.out.println("총 페이지 개수 : " + listCount);
		
		// 총 250개
		// 25개
		// 만약 전체 게시글 수가 13개라면
		// 페이지는 1,2가 나와야한다.
		// 13--> 1.3 --> 2(올림)
		
		maxPage = (int)((double)listCount/ limit + 0.9);
		
		// 시작 페이지와 마지막 페이지 계산하기
		// 1~10 : 7, 7/10 --> 0.7 --> 1.6--> 1-1 -- 0 * 10 +1;
		// 11~20: 19, 19/10 --> 1.9 --> 2.8 --> 2-1 -- 1* 10 + 1;
		startPage = ((int)((double)currentPage/limit + 0.9)-1)* limit + 1;
		
		// 마지막 페이지
		// 1~10 : 10
		// 11~20: 20
		endPage = startPage + limit -1;
		
		// 만약 마지막 페이지보다 현재 게시글이 끝나는 페이지가 적다면
		// 1~10 : 7
		if(endPage > maxPage) {
			endPage = maxPage;
		}
	
		list = bs.selectList(currentPage, limit);
		SkillService sk = new SkillService();
		slist = sk.selectAllList();
	
		
		String page = "";
		
		if(list != null) {
			page = "Project/developer.jsp?currentPage="+currentPage;
			request.setAttribute("list", list);
			request.setAttribute("slist", slist);
			
			PageInfo pi = new PageInfo(currentPage,listCount,limit,maxPage,startPage,endPage);
			request.setAttribute("pi", pi);
		}else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "프로젝트 목록 조회 실패!");
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
