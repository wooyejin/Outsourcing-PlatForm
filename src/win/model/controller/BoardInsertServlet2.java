package win.model.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import win.model.service.BoardService;
import win.model.vo.Board;

/**
 * Servlet implementation class BoardInsertServlet
 */
@WebServlet("/bInsert2.bo")
public class BoardInsertServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardInsertServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int maxSize = 1024*1024*10;
		
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "multipart를 통한 전송이 아닙니다");
			request.getRequestDispatcher("/win/boardInsertFormjsp").forward(request, response);
		}
		
//		String root = request.getServletContext().getRealPath("");
////		System.out.println("root : " + root);
//		
//		String savePath = "/semi/web/resources/boardUploadFiles";
		
		String root = request.getServletContext().getRealPath("/resources/boardUploadFiles");
	    System.out.println("root : " + root);
	      
	    String savePath = root;
		
		MultipartRequest mrequest = new MultipartRequest(
				request, // �����ϱ� ���� ������ü
				savePath, // ���� ���� ���
				maxSize, // ������ ������ �ִ� ũ��
				"UTF-8", // ������ ���ڼ� ���� 
				new DefaultFileRenamePolicy()
				// ������ �̸��� ������ �������� ���
				// ������ ���ϰ� �����ϱ� ����
				// ���ο� ���ϸ� �ڿ� ���ڸ� ���̴� ��Ģ
				);
		
		String title = mrequest.getParameter("title");
		String content = mrequest.getParameter("content");
		String writer = mrequest.getParameter("writer");
		
		String fileName = mrequest.getFilesystemName("file");
		
		Board b = new Board();
		b.setBtitle(title);
		b.setBcontent(content);
		b.setBwriter(writer);
		b.setBoardfile(fileName);
		
		int result = new BoardService().insertBoard(b);
		System.out.println(result);
		if(result > 0 ) {
			response.sendRedirect("selectList2.bo");
		}else {
			request.setAttribute("msg", "에러임");
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
