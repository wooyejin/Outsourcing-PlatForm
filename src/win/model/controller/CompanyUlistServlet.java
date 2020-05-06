package win.model.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import win.model.service.MemberService;
import win.model.vo.Member;

/**
 * Servlet implementation class CompanyUlistServlet
 */
@WebServlet("/cload.ce")
public class CompanyUlistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompanyUlistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		Member m = (Member)session.getAttribute("member");
		
		

		
		ArrayList<Member> ulist = new ArrayList<Member>();
		
		MemberService ms = new MemberService();
		
		ulist = ms.updateCompany(m);
		
		System.out.println(ulist.toString());
		 
		
		if(ulist!=null) {
			request.setAttribute("ulist", ulist);
			request.getRequestDispatcher("win/mypage_company.jsp").forward(request, response);
		} else {
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
