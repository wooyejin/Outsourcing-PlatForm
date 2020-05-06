
package win.model.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import win.common.MyRenamePolicy;
import win.exception.MemberException;
import win.model.service.MemberService;
import win.model.vo.Member;

/**
 * Servlet implementation class MemberPortoServlet
 */
@WebServlet("/pInsert.pe")
public class MemberPortoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberPortoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		
		Member m = (Member)session.getAttribute("member");
		
	    int no = m.getNo();
		String memberType = m.getMemberType();
		
		int maxSize = 1024 * 1024 * 10; // 10MB
	      
	      String root
	      = request.getServletContext().getRealPath("/resources");
	      
	      String savePath = root + "/boardUploadFiles/";
	      
	      MultipartRequest mrequest = new MultipartRequest(
	            request, // 변경하기 위한 원본 객체
	            savePath, // 파일 저장 경로
	            maxSize,   // 저장할 파일의 최대 크기
	            "UTF-8",   // 저장할 문자셋 설정
	            new DefaultFileRenamePolicy());
	     
	      
	     MemberService ms = new MemberService();
	     
	     Member mem = new Member();
	      
	      if(!ServletFileUpload.isMultipartContent(request)) {
	         // 만약 multipart/form-data로 보내지 않았으면 에러 발생!
	         
	         System.out.println("사진 전송실패");
	      }
	      
	      
	      String boardfile = new String();

	      boardfile = mrequest.getFilesystemName("file");
	      
	      mem.setBoardfile(boardfile);
	      mem.setNo(no);
	      mem.setMemberType(memberType);
          
	      m.setBoardfile(boardfile);
          
          System.out.println("파일저장된이름:"+boardfile);
          
		try {
			int result = new MemberService().insertPorto(mem);
			if(result > 0) {
				m.setBoardfile(boardfile);
				System.out.println("파일저장완료");
				if(mem.getMemberType().equals("D")) {
				response.sendRedirect("/win/page/myPage1.jsp");	
				} else if(mem.getMemberType().equals("C")) {
					response.sendRedirect("/win/page/mypage_company.jsp");
				}
			} 
		}catch (MemberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
