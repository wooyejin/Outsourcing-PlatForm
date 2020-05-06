package admin.member.model.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.member.model.exception.MemberException;
import admin.member.model.service.MemberService;
import admin.member.model.vo.Member;

/**
 * Servlet implementation class MemberReadServlet
 */
@WebServlet("/mUpdate.do")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MemberUpdateServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//회원정보 수정용 데이터 꺼내오기
				int uno = Integer.parseInt(request.getParameter("uNo"));
				int fno = Integer.parseInt(request.getParameter("fNo"));
				String name = request.getParameter("uName");
				String id = request.getParameter("uId");
				String pwd = request.getParameter("uPwd");
				String intro = request.getParameter("uIntro");
				String profile = request.getParameter("uProfile");
				String email = request.getParameter("uEmail");
				String phone = request.getParameter("uPhone");
				String modifydate = request.getParameter("uModifyDate");
				String modifywriter = request.getParameter("uModifyWriter");
				String yn = request.getParameter("uYn");
				
				
				System.out.println(name+id+pwd+intro+profile+email+phone+modifydate+modifywriter+yn);
				//해당 회원을 구분짓는 ID 받아오기
				HttpSession session = request.getSession(false);
				
				//Member m = (Member)session.getAttribute("member");
				
				Member m = new Member();
				
				Date writeDate = null;
				
				if(modifydate != ""&& modifydate != null) {
					//날짜가 들어 왔을 때
//				2020-01-30 ==> 2020, 1, 30

					String[] dateArr = modifydate.split("-");
					int[] intArr = new int[dateArr.length];
					
					//String -->int
					for(int i = 0; i<dateArr.length;i++) {
						intArr[i] = Integer.parseInt(dateArr[i]);
					}
					
					writeDate = new Date(new GregorianCalendar(
							intArr[0],intArr[1]-1,intArr[2]
							).getTimeInMillis());
				}else {
					//날짜가 들어오지 않으면
					writeDate = new Date(new GregorianCalendar().getTimeInMillis());
				}
				
				
				
				
				//기존의 회원 정보를 새로운 값으로 변경하기
			
				m.setuNo(uno);
				m.setfNo(fno);
				m.setuName(name);
				m.setuId(id);
				m.setuPwd(pwd);
				m.setuIntro(intro);
				m.setuProfile(profile);
				m.setuEmail(email);
				m.setuPhone(phone);
				m.setuModifyDate(writeDate);
				m.setuModifyWriter(modifywriter);
				m.setuYn(yn);
				
				
				MemberService ms = new MemberService();
				
				
				int result = ms.updateMember(m);
				
				if(result>0) {
					
					response.sendRedirect("/win/memberRead.do");
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
