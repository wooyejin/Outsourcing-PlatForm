package admin.qna.model.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.qna.model.service.QnaService;
import admin.qna.model.vo.Qna;

/**
 * Servlet implementation class QnaReadServlet
 */
@WebServlet("/qnaRead.do")
public class QnaReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public QnaReadServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Qna> qlist = new ArrayList<Qna>();
		QnaService qs = new QnaService();
		
		
		qlist = qs.readQna();
		String page = null;
		
		
		if(qlist!=null) {
			page= "qna.jsp";
			request.setAttribute("qlist", qlist);
			
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
