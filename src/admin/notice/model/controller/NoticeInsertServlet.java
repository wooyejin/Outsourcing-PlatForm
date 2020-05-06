package admin.notice.model.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.notice.model.service.NoticeService;
import admin.notice.model.vo.Notice;

/**
 * Servlet implementation class AdsReadServlet
 */
@WebServlet("/nInsert.do")
public class NoticeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public NoticeInsertServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
				String nTitle = request.getParameter("nTitle");
				String nWriter = request.getParameter("nWriter");
				String nContent = request.getParameter("nContent");
				
				//해당 회원을 구분짓는 ID 받아오기
				HttpSession session = request.getSession(false);
				
				//Member m = (Member)session.getAttribute("member");
				
				Notice n = new Notice();
				
				
				
				
				//기존의 회원 정보를 새로운 값으로 변경하기
			
				n.setnTitle(nTitle);
				n.setnWriter(nWriter);
				n.setnContent(nContent);
			
				
				NoticeService ns = new NoticeService();
				
				
				int result = ns.insertNotice(n);
				
				if(result>0) {
					
					response.sendRedirect("/win/noticeRead.do");
				}else {
					
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
