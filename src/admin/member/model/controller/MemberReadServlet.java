package admin.member.model.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.member.model.service.MemberService;
import admin.member.model.vo.Member;

/**
 * Servlet implementation class MemberReadServlet
 */
@WebServlet("/memberRead.do")
public class MemberReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MemberReadServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Member> mlist = new ArrayList<Member>();
		MemberService ms = new MemberService();
		
		
		mlist = ms.readMember();
		int result = 0;
		String page = null;
		
		
		if(mlist!=null) {
			result = ms.insertUcount();
			
			if(result>0) {
			page= "user.jsp";
			request.setAttribute("mlist", mlist);
			
		}else {
			page = "errorPage.jsp";
			request.setAttribute("msg", "회원 목록 불러오기 에러!");
		}
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
