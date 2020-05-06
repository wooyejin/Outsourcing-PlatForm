package win.model.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import win.exception.MemberException;
import win.model.service.MemberService;
import win.model.vo.Member;

/**
 * Servlet implementation class MemberinsertServlet
 */
@WebServlet("/mInsert.me")
public class MemberinsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberinsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memberType = request.getParameter("memberType");
		String email = request.getParameter("email");
		String name = request.getParameter("userName");
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String companyId = request.getParameter("companyId");
		
		// 회원 가입 시 전달을 위한 VO 생성
		Member m = new Member(memberType,email,name,userId,userPwd,companyId);
		System.out.println("가입 회원 정보 확인 : ");
		
		// 회원 가입 서비스 실행
		MemberService ms = new MemberService();
		
		try {
			ms.insertMember(m);
			System.out.println("회원 가입 완료!");
			
			response.sendRedirect("mainpage.jsp");
		} catch (MemberException e) {
			request.setAttribute("msg", "회원 가입 중 에러 발생!!");
			request.setAttribute("exception", e);
			
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			
			e.printStackTrace();
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
