package com.winwin.jsp.project.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.winwin.jsp.project.model.exception.projectException;
import com.winwin.jsp.project.model.service.ProjectService;
import com.winwin.jsp.project.model.vo.Project;

import win.model.vo.Member;

/**
 * Servlet implementation class insertProjectServlet
 */
@WebServlet("/pinsert.do")
public class insertProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertProjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session  = request.getSession();
		
		Member m  = (Member)session.getAttribute("member");
		
		String ptitle = request.getParameter("ptitle"); // 프로젝트 제목
		String pbang = request.getParameter("pbang"); // 프로젝트 진행방식
		String ptype = request.getParameter("ptype"); // 프로젝트 카테고리
		String pdetail = String.join(", ", request.getParameterValues("pdetail")); // 프로젝트 상세 카테고리
		String pcotx = request.getParameter("pcotx"); // 상세 업무 내용
		String pstart = request.getParameter("pstart"); // 예상 시작일
		String pend = request.getParameter("pend"); // 공고 마감일
		String pgo = request.getParameter("pgo"); // 예상 진행 
		String career = request.getParameter("career");
		int pcost = Integer.parseInt(request.getParameter("cost")); // 프로젝트 예산
		String memcount = request.getParameter("memcount");
		
		Project p = new Project();
		
		
		 
		Date pstart2 = null;
		
		if(pstart !="" && pstart!= null) {
			// 날짜가 들어 왔을 때
			//2020-01-30 --> 2020, 1, 30
			String[] dateArr1 = pstart.split("-");
			int[] intArr1 = new int[dateArr1.length];
			System.out.println(dateArr1.length);
			// String --> int
			for(int i=0; i<dateArr1.length;i++) {
				intArr1[i] = Integer.parseInt(dateArr1[i]);
				System.out.println(intArr1[i]);
			}
			
			pstart2 = new Date(new GregorianCalendar(
					intArr1[0],intArr1[1]-1,intArr1[2]).getTimeInMillis());
				
		}else {
			// 날짜가 들어오지 않으면 
			pstart2 = new Date(new GregorianCalendar().getTimeInMillis());
		}
		
		Date pend2 = null;
		
		if(pend !="" && pend!= null) {
			// 날짜가 들어 왔을 때
			//2020-01-30 --> 2020, 1, 30
			String[] dateArr2 = pend.split("-");
			int[] intArr2 = new int[dateArr2.length];
			
			// String --> int
			for(int i=0; i<dateArr2.length;i++) {
				intArr2[i] = Integer.parseInt(dateArr2[i]);
			}
			
			pend2 = new Date(new GregorianCalendar(
					intArr2[0],intArr2[1]-1,intArr2[2]).getTimeInMillis());
			
		}else {
			// 날짜가 들어오지 않으면 
			pend2 = new Date(new GregorianCalendar().getTimeInMillis());
		}
		p.setPtitle(ptitle);
		p.setPbang(pbang);
		p.setPtype(ptype);
		p.setPdetail(pdetail);
		p.setPcotx(pcotx);
		p.setPcost(pcost);
		p.setPstart(pstart2);
		p.setPend(pend2);
		p.setPgo(pgo);
		p.setCareer(career);
		p.setMemcount(memcount);
		
		System.out.println("프로젝트 확인 : " + p);
		
		ProjectService ps = new ProjectService();
		
		try {
			ps.insertProject(p,m);
			System.out.println("프로젝트 등록 완료!");
			
			response.sendRedirect("mainpage.jsp");
		} catch (projectException e) {
			e.printStackTrace();
			
			//e.printStackTrace();
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
