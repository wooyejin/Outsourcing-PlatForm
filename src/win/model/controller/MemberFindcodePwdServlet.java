package win.model.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import win.exception.MemberException;

/**
 * Servlet implementation class MemberFindcodePwdServlet
 */
@WebServlet("/mcodeFindpwd.do")
public class MemberFindcodePwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberFindcodePwdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String AuthentiactionKey = (String)request.getSession().getAttribute("AuthenticationKey");
	      System.out.println("sunin MemberChangePwdServlet AuthentiactionKey : " + AuthentiactionKey);
	      
	      String AuthenticationUser = request.getParameter("AuthenticationUser");
	      System.out.println("sunin MemberChangePwdServlet AuthenticationUser : " + AuthenticationUser);
	      
	      if(!AuthentiactionKey.equals(AuthenticationUser))
	      {
	         System.out.println("인증번호 일치 하지 않음");
	         request.setAttribute("msg", "인증번호가 일치하지 않습니다.");
	         request.getRequestDispatcher("/Member/foundPwd.jsp").forward(request, response);
	      }
	      

	      if(AuthentiactionKey.equals(AuthenticationUser)) {
	         System.out.println("인증번호 일치");
	         request.getRequestDispatcher("/Member/changePwd.jsp").forward(request, response);
	      
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
