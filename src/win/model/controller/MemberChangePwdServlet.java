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
 * Servlet implementation class MemberChangePwd
 */
@WebServlet("/mChangepwd.do")
public class MemberChangePwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberChangePwdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	      String pwd = request.getParameter("userPwd");
	      String pwd1 = request.getParameter("userPwd");
	      String email = request.getParameter("email");
	      
	      System.out.println("member email : " +email);
	      System.out.println("MemberChangePwdServlet Pwd : " + pwd);
	      System.out.println("MemberChangePwdServlet Pwd1 : " + pwd1);

	            
	      Member m = new Member();

	      MemberService ms = new MemberService();
	      
	      try {
	         if(pwd.equals(pwd1)) {
	            m.setEmail(email);
	            m.setUserPwd(pwd);
	            System.out.println("member : "+m);
	            ms.updatePwd(m);
	            System.out.println("비밀번호 수정 완료");
	            
	            HttpSession session = request.getSession();
	            Member mm = (Member)session.getAttribute("member");
	            System.out.println("세션의 패스워드 : " + mm.getUserPwd());
	            System.out.println("변경한 패스워드 : " + pwd);      
	            response.sendRedirect("/win/mainpage.jsp");   
	         }
	         
	      }catch(MemberException e) {
	         request.setAttribute("msg", "비밀번호 수정 중 에러 발생!");
	         request.setAttribute("exception", e);
	         
	         request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
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
