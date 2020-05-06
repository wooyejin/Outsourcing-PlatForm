package admin.company.model.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.company.model.service.CompanyService;
import admin.company.model.vo.Company;
import admin.member.model.service.MemberService;

/**
 * Servlet implementation class CompanySelectOneServlet
 */
@WebServlet("/cSelectOne.do")
public class CompanySelectOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompanySelectOneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//내가 클릭한 게시물을 호출하기위해서 필요한 값을 받아서 변수에 담는다.
				int cNo = Integer.parseInt(request.getParameter("cNo"));
				System.out.println(cNo);
				CompanyService cs = new CompanyService();
				Company c = cs.selectOne(cNo);
				
				String page = ""; 
				
				if(c != null) {//공지글 상세페이지 데이터가져오는데 성공
					page = "companyUpdate.jsp";
					request.setAttribute("company", c);
					//request.setAttribute("내가 전달할 객체(변수)의 명을 기입","내가 전달할 객체(변수)값을 기입");
				}else {
					page = "errorPage.jsp";
					request.setAttribute("msg", "공지사항 상세보기 실패!");
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
