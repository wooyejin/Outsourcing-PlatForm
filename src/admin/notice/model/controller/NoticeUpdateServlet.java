package admin.notice.model.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.notice.model.service.NoticeService;
import admin.notice.model.vo.Notice;

/**
 * Servlet implementation class MemberReadServlet
 */
@WebServlet("/nUpdate.do")
public class NoticeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public NoticeUpdateServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//회원정보 수정용 데이터 꺼내오기
				int nNo = Integer.parseInt(request.getParameter("nNo"));
				int nCount = Integer.parseInt(request.getParameter("nCount"));
				String nTitle = request.getParameter("nTitle");
				String nWriter = request.getParameter("nWriter");
				String nDate = request.getParameter("nDate");
				String nContent = request.getParameter("nContent");
				
				String modifydate = request.getParameter("nModifyDate");
				String modifywriter = request.getParameter("nModifyWriter");
				String nYn = request.getParameter("nYn");
				
				
				
				Notice n = new Notice();
				
				Date nDate1 = null;
				
				if(modifydate != ""&& modifydate != null) {
					//날짜가 들어 왔을 때
//				2020-01-30 ==> 2020, 1, 30

					String[] dateArr1 = modifydate.split("-");
					int[] intArr1 = new int[dateArr1.length];
					
					//String -->int
					for(int i = 0; i<dateArr1.length;i++) {
						intArr1[i] = Integer.parseInt(dateArr1[i]);
					}
					
					nDate1 = new Date(new GregorianCalendar(
							intArr1[0],intArr1[1]-1,intArr1[2]
							).getTimeInMillis());
				}else {
					//날짜가 들어오지 않으면
					nDate1 = new Date(new GregorianCalendar().getTimeInMillis());
				}
				
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
			
				n.setnNo(nNo);
				n.setnTitle(nTitle);
				n.setnWriter(nWriter);
				n.setnDate(nDate1);
				n.setnCount(nCount);
				n.setnContent(nContent);
				n.setnModifyDate(writeDate);
				n.setnModifyWriter(modifywriter);
				n.setnYn(nYn);
				
				
				NoticeService ns = new NoticeService();
				
				
				int result = ns.updateNotice(n);
				
				if(result>0) {
					
					response.sendRedirect("/win/noticeRead.do");
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
