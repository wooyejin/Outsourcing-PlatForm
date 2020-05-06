package win.model.controller;

import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import win.model.service.BoardService;
import win.model.vo.Board;

/**
 * Servlet implementation class BoardUpdateServlet
 */
@WebServlet("/bUpdate.bo")
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		
		Board bo = (Board)session.getAttribute("board");
		
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String fileName = request.getParameter("file");
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		Board b = new Board();		




		
				
		b.setBwriter(writer);
		b.setBdate(bo.getBdate());
		b.setBno(bno);
		b.setBtitle(title);
		b.setBcontent(content);
		b.setBoardfile(fileName);
		
		int result = new BoardService().updateBoard(b);
//		System.out.println("�������"+b.toString());
		if(result > 0 ) {
			request.setAttribute("board", b);
			request.getRequestDispatcher("/board/boardDetail.jsp").forward(request, response);
			/*response.sendRedirect("selectOne.no?bno=" + bno);*/
		}else {
			request.setAttribute("msg", "에러!");
			request.getRequestDispatcher("/board/boardUpdate.jsp").forward(request, response);
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
