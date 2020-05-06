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
import static win.common.JDBCTemplate.*;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/mUpdate.me")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String pwd = request.getParameter("userPwd");
		String id = request.getParameter("userId");
		String type = request.getParameter("memberType");
		
		HttpSession session = request.getSession(false);
		
		Member m = new Member();
		
		m.setUserId(id);
		m.setUserPwd(pwd);
		m.setEmail(email);
		m.setMemberType(type);
		
		System.out.println("변경한 회원 정보 확인 : " + m);
		
		MemberService ms = new MemberService();
		
		try {
			ms.updateMember(m);
			System.out.println("회원 정보 수정 완료!");
			if(m.getMemberType().equals("D")) {
				response.sendRedirect("/win/page/myPage1.jsp");
			} else if(m.getMemberType().equals("C")) {
				response.sendRedirect("/win/page/mypage_company.jsp");
			}
			
		} catch (MemberException e) {
			request.setAttribute("msg", "회원정보 수정 중 에러 발생!");
			request.setAttribute("exception", e);
			
			request.getRequestDispatcher("/win/views/common/errorPage.jsp").forward(request, response);
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
