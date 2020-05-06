package win.model.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import win.model.service.BoardCommentService;
import win.model.vo.BoardComment;

/**
 * Servlet implementation class CommentInsertervlet
 */
@WebServlet("/insertComment.bo")
public class CommentInsertervlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentInsertervlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String writer = request.getParameter("writer");
		int bno = Integer.parseInt(request.getParameter("bno"));
		String content = request.getParameter("replyContent");
		
		System.out.println(bno);
		
		BoardComment bco = new BoardComment(bno,content,writer);
		
		int result = new BoardCommentService().insertComment(bco);
		
		if(result > 0) {
			response.sendRedirect("selectOne.bo?bno=" + bno);
		}else {
			request.setAttribute("msp", "댓글 작성 실패");
			request.getRequestDispatcher("/views/common/errorPage.jsp").forward(request, response);
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
