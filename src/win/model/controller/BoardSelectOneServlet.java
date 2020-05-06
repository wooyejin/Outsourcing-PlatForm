package win.model.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import win.model.service.BoardCommentService;
import win.model.service.BoardService;
import win.model.vo.Board;
import win.model.vo.BoardComment;

/**
 * Servlet implementation class BoardSelectOneServlet
 */
@WebServlet("/selectOne.bo")
public class BoardSelectOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardSelectOneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		System.out.println(bno);
		// �Խñ� �� ��ȸ��
		Board b = new BoardService().selectOne(bno);
		
		// ��� ���� ��ȸ��
		ArrayList<BoardComment> clist = new BoardCommentService().selectList(bno);
		
		HttpSession session = request.getSession();
		
		
		String page="";
		
		if(b != null) {
			page = "/board/boardDetail.jsp";
			request.setAttribute("board", b);
			session.setAttribute("board2", b);
			request.setAttribute("clist", clist);
		}else {
			page="/views/common/errorpage.jsp";
			request.setAttribute("msg", "에러임!");
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
