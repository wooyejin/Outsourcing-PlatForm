package win.model.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import win.board.model.service.CareerService;
import win.board.model.service.IntroduceService;
import win.board.model.service.SkillService;
import win.board.model.vo.Career;
import win.board.model.vo.Introduce;
import win.board.model.vo.Skill;
import win.model.service.MemberService;
import win.model.vo.Member;

/**
 * Servlet implementation class MemberDetailInfoServlet
 */
@WebServlet("/mDetail")
public class MemberDetailInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDetailInfoServlet() {
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
		
		
						
			Member m = new Member();
			
			m = ms.selectMember2(selnumber,seltype);
					
		
			in = is.selectList(seltype,selnumber); 
			slist = ss.selectList(seltype,selnumber);
			clist= cs.selectList(seltype,selnumber);
			
			
			request.setAttribute("slist", slist);
			request.setAttribute("clist", clist);
			request.setAttribute("in", in);
			request.setAttribute("member", m);			

		
			
		
			request.getRequestDispatcher("page/myPage2.jsp").forward(request, response);
				
        		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
