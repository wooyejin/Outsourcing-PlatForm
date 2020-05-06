package admin.company.model.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.company.model.service.CompanyService;
import admin.company.model.vo.Company;

/**
 * Servlet implementation class CompanyReadServlet
 */
@WebServlet("/cUpdate.do")
public class CompanyUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CompanyUpdateServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//회원정보 수정용 데이터 꺼내오기
				int uno = Integer.parseInt(request.getParameter("cNo"));
				int pno = Integer.parseInt(request.getParameter("pNo"));
				String name = request.getParameter("cName");
				String id = request.getParameter("cId");
				String pwd = request.getParameter("cPwd");
				String email = request.getParameter("cEmail");
				String phone = request.getParameter("cPhone");
				String intro = request.getParameter("cIntro");
				String bus = request.getParameter("cBus");
				String modifydate = request.getParameter("cModifyDate");
				String modifywriter = request.getParameter("cModifyWriter");
				String yn = request.getParameter("cYn");
				String proof = request.getParameter("cProof");
				
				
				//해당 회원을 구분짓는 ID 받아오기
				HttpSession session = request.getSession(false);
				
				//Member m = (Member)session.getAttribute("member");
				
				Company c = new Company();
				
				Date writeDate = null;
				
				if(modifydate != ""&& modifydate != null) {

					String[] dateArr = modifydate.split("-");
					int[] intArr = new int[dateArr.length];
					
					for(int i = 0; i<dateArr.length;i++) {
						intArr[i] = Integer.parseInt(dateArr[i]);
					}
					
					writeDate = new Date(new GregorianCalendar(
							intArr[0],intArr[1]-1,intArr[2]
							).getTimeInMillis());
				}else {
					writeDate = new Date(new GregorianCalendar().getTimeInMillis());
				}
				
				
				
				
				//기존의 회원 정보를 새로운 값으로 변경하기
			
				c.setcNo(uno);
				c.setpNo(pno);
				c.setcName(name);
				c.setcId(id);
				c.setcPwd(pwd);
				c.setcIntro(intro);
				c.setcBus(bus);
				c.setcEmail(email);
				c.setcPhone(phone);
				c.setcModifyDate(writeDate);
				c.setcModifyWriter(modifywriter);
				c.setcYn(yn);
				c.setcProof(proof);
				
				System.out.println("변경한 회원 정보 확인 : "+c);
				
				CompanyService cs = new CompanyService();
				
				
				int result = cs.updateCompany(c);
				
				if(result>0) {
					
					response.sendRedirect("/win/companyRead.do");
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
