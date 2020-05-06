package win.board.model.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import win.board.model.service.IntroduceService;


import win.board.model.vo.Introduce;



/**
 * Servlet implementation class BoardInsertServlet
 */
@WebServlet("/bInsert.bo")
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int maxSize = 1024 *1024*10;
		
		// 2. multipart / form-data 형식으로 전송되었는지 확인!
		if(!ServletFileUpload.isMultipartContent(request)) {
			// 만약 올바른 multipart/form-data로 전송되지 않았을 경우
			// 에러페이지로 즉시 이동시킨다.
			request.setAttribute("msg", "multipart를 통한 전송이 아닙니다.");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			
		}
		
		// 3. 웹 상의 루트(최상위 경로) 경로를 활용하여 저장할 폴더의 위치 지정하기
		String root = request.getServletContext().getRealPath("/");
		System.out.println("root : " + root);
		// 게시판의 첨부파일을 저장할 폴더 이름 지정하기
		String savePath = root + "resources/boardUploadFiles";
		
		// 4. 실제 담아온 파일 기타 정보들을 활용하여
		//	  MultipartRequest 생성하기
		// 	  request -> MultipartRequest
		
		MultipartRequest mrequest = new MultipartRequest(
										request, // 변경하기 위한 원본 객체
										savePath, // 파일 저장 경로
										maxSize, // 저장할 파일의 최대 크기
										"UTF-8",	 // 저장할 문자셋 설정
										new DefaultFileRenamePolicy()
										// 동일한 이름의 파일을 저장했을 경우
										// 기존의 파일과 구분하기 위해
										// 새로운 파일명 뒤에 숫자를 붙이는 규칙
				);
		// -- 파일 업로드 로직 실시 -- //
		// 5-1. 기본 전송값 처리
		
		
		String title = mrequest.getParameter("title");
		String content = mrequest.getParameter("content");
		String name = mrequest.getParameter("memberType");
		String no = mrequest.getParameter("no");
		
		System.out.println("name:" +name);
		System.out.println("no:"+no);
		
		Introduce in = new Introduce();
		in.setIn_title(title);
		in.setIn_content(content);
		
		HttpSession session = request.getSession();
		
		int result = new IntroduceService().insertBoard(in,name,no);
					
		
		if(result >0) {
			
			session.setAttribute("in", in);
			if(name.equals("D")) {
				response.sendRedirect("/win/page/myPage1.jsp");
			} else if(name.equals("C")) {
				response.sendRedirect("/win/page/mypage_company.jsp");
			}
			
		}else {
			request.setAttribute("msg", "게시글 작성 실패");
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
