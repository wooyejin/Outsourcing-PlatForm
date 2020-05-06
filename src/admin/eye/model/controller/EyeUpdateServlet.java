package admin.eye.model.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.eye.model.service.EyeService;
import admin.eye.model.vo.Eye;

/**
 * Servlet implementation class EyeUpdateServlet
 */
@WebServlet("/eUpdate.do")
public class EyeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public EyeUpdateServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//회원정보 수정용 데이터 꺼내오기
				String eNo = request.getParameter("no");
				
				String eYn = request.getParameter("yn");
				
				System.out.println(eNo);
				System.out.println(eYn);
				
				Eye e = new Eye();
				
				
				
				//기존의 회원 정보를 새로운 값으로 변경하기
			
				//e.seteNo(eNo);
				
				if(eYn.equals("Y")) {
				e.seteYn("N");
				}else {
				e.seteYn("Y");
				}
				
				EyeService es = new EyeService();
				
				
				int result = es.updateEye(e,eNo);
				
				if(result>0) {
					
					response.sendRedirect("/win/eyeRead.do");
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
