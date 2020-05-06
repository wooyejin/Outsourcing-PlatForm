package win.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;



import win.board.model.service.CareerService;
import win.board.model.service.IntroduceService;
import win.board.model.service.SkillInsertServlet;
import win.board.model.service.SkillService;
import win.board.model.vo.Career;
import win.board.model.vo.Introduce;
import win.board.model.vo.Skill;
import win.model.service.MemberService;
import win.model.vo.Member;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/selectList.bo")

public class IntroduceListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IntroduceListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Introduce in = new Introduce();
		IntroduceService is = new IntroduceService();
		
		/*Skill s = new Skill();*/
		SkillService ss = new SkillService();
		
		ArrayList<Skill> slist = new ArrayList<Skill>();
		
		CareerService cs = new CareerService();
		
		ArrayList<Career> clist = new ArrayList<Career>();
	
		MemberService ms= new MemberService();
		HttpSession session = request.getSession();
		
		
		String selnumber = request.getParameter("uno");
		String seltype =request.getParameter("memberType");
		
		if(selnumber == null && seltype == null) {
			Member m = (Member)session.getAttribute("member");
			
			String type2 = m.getMemberType();
			String number = String.valueOf(m.getNo()); 
			
			
			in = is.selectList(type2,number); 
			slist = ss.selectList(type2,number);
			clist= cs.selectList(type2,number);
			
			System.out.println("in:"+in);
		
			if(m.getMemberType().equals("D") && m.getBoardfile() == null) {
				System.out.println("insert port");
				ms.insertMemberPort(m);
			}
			
			
			System.out.println("보드파일333:"+m.getBoardfile());
			//HttpSession session = request.getSession(); 
			
		/*	session.setAttribute("in", in); // 원래 없었다가 내가추가함 2020-02-24
*/			session.setAttribute("slist", slist);
			session.setAttribute("clist", clist);
			
			String page = "";
			if(in != null) {
				if(type2.equals("D")) {
					page = "page/myPage1.jsp";
					session.setAttribute("in", in);
				} else if(type2.equals("C")) {
					page = "page/mypage_company.jsp";
					session.setAttribute("in", in);
				}
				
			
			} else {
				if(type2.equals("D")) {
					page = "page/myPage1.jsp";
					session.setAttribute("in", in);
				} else if(type2.equals("C")) {
					page = "page/mypage_company.jsp";
					session.setAttribute("in", in);
				}
				//request.setAttribute("msg", "공지사항 목록 불러오기 에러!");
			}
			response.sendRedirect(page);
			//request.getRequestDispatcher().forward(request, response);
			
		}else {
						
			Member m = new Member();
			
			m = ms.selectMember2(selnumber,seltype);
					
		
			in = is.selectList(seltype,selnumber); 
			slist = ss.selectList(seltype,selnumber);
			clist= cs.selectList(seltype,selnumber);
			
			
			session.setAttribute("slist", slist);
			session.setAttribute("clist", clist);
			
			session.setAttribute("member", m);			

			
			String page = "";
			if(in != null) {
				if(seltype.equals("D")) {
					page = "page/myPage1.jsp";
					session.setAttribute("in", in);
				} else if(seltype.equals("C")) {
					page = "page/mypage_company.jsp";
					session.setAttribute("in", in);
				}
				
			
			} else {
				if(seltype.equals("D")) {
					page = "page/myPage1.jsp";
					session.setAttribute("in", in);
				} else if(seltype.equals("C")) {
					page = "page/mypage_company.jsp";
					session.setAttribute("in", in);
				}
				//request.setAttribute("msg", "공지사항 목록 불러오기 에러!");
			}
			response.sendRedirect(page);
			//request.getRequestDispatcher().forward(request, response);
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
