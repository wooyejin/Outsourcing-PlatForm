package win.model.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import win.exception.MemberException;
import win.model.service.MemberService;
import win.model.vo.Member;

/**
 * Servlet implementation class MemberFindServlet
 */
@WebServlet("/mFind.do")
public class MemberFindIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberFindIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userName");
	      String email = request.getParameter("email");
	      
	      System.out.println(userId);
	      System.out.println(email);
	      
	  
	      
	      MemberService ms = new MemberService();
	      
	      try{// 회원 아이디 찾았을 떄
	        Member m = ms.findId(userId,email);
	         
	         System.out.println("아이디찾기 성공!!!");
	         
	         
	         System.out.println(m.getUserId());
	         
	         HttpSession session = request.getSession();
	         session.setAttribute("member", m);
	         response.sendRedirect("/win/Member/foundidResult.jsp");
	      }catch(MemberException e) {// 회원 아이디 찾지 못했을 떄
	         request.setAttribute("msg", "존재하지 않은 회원입니다");
	         request.setAttribute("exception", e);
	         
	         request.getRequestDispatcher("/win/Member/foundId.jsp");
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
