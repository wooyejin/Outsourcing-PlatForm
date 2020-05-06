package admin.project.model.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.project.model.service.ProjectService;
import admin.project.model.vo.Project;

/**
 * Servlet implementation class ProjectSelectOneServlet
 */
@WebServlet("/pSelectOne.do")
public class ProjectSelectOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectSelectOneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//내가 클릭한 게시물을 호출하기위해서 필요한 값을 받아서 변수에 담는다.
				int pNo = Integer.parseInt(request.getParameter("pNo"));
				System.out.println(pNo);
				// 받은 값을 NoticeService로 보내기위해서 객체를 새롭게 하나 만든다.
				ProjectService ps = new ProjectService();
				
				// NoticeService에서 반환받을 값의 변수를 지정
				// NoticeService에 있는 selectOne()메소드[상세페이지를 호출하기위한 메소드]를 호출
				Project p = ps.selectOne(pNo);
				
				//DB에서 전달받은 객체정보를 전달할코드 작성
				String page = ""; 
				//-->성공을 하던, 실패를 하던 각각의 페이지에다가 forward방식으로 호출할예정이라
				//	 변수하나를 선언
				
				if(p != null) {//공지글 상세페이지 데이터가져오는데 성공
					page = "projectUpdate.jsp";
					request.setAttribute("project", p);
					//request.setAttribute("내가 전달할 객체(변수)의 명을 기입","내가 전달할 객체(변수)값을 기입");
				}else {
					page = "errorPage.jsp";
					request.setAttribute("msg", "프로젝트 수정페이지 불러오기 실패!");
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
