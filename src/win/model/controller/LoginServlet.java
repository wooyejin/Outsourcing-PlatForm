package win.model.controller;

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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.me")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        MemberService ms = new MemberService();
        HttpSession session = request.getSession();

		
        String userId = request.getParameter("ID");
        String userPwd = request.getParameter("PWD");
        String mType = request.getParameter("type");

        System.out.println("id : "+ userId);
        System.out.println("pwd : "+ userPwd);
        System.out.println("mtype : "+ mType);
        
        
        Member m = new Member(userId, userPwd);
        m.setMemberType(mType);

        Member mem = new Member();
        
        mem = ms.selectMember(m);
     
        
        
        if(mem != null) {
        	session.setAttribute("member", mem);
        	response.getWriter().print(mem.getUserId());
          }
        else {
        	response.getWriter().print("null");
        }
           
       
     
     }

}
