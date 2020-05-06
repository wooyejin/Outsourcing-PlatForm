package admin.notice.model.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.notice.model.service.NoticeService;
import admin.notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeReadServlet
 */
@WebServlet("/noticeRead.do")
public class NoticeReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public NoticeReadServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Notice> nlist = new ArrayList<Notice>();
		NoticeService ns = new NoticeService();
		
		
		nlist = ns.readNotice();
		String page = null;
		
		
		if(nlist!=null) {
			page= "notice.jsp";
			request.setAttribute("nlist", nlist);
			
		}else {
			page = "errorPage.jsp";
			request.setAttribute("msg", "회원 목록 불러오기 에러!");
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
