package admin.qna.model.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.qna.model.service.QnaService;
import admin.qna.model.vo.Qna;

/**
 * Servlet implementation class QnaUpdateServlet
 */
@WebServlet("/qUpdate.do")
public class QnaUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public QnaUpdateServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//회원정보 수정용 데이터 꺼내오기
				int qNo = Integer.parseInt(request.getParameter("qNo"));
				int qCount = Integer.parseInt(request.getParameter("qCount"));
				String qTitle = request.getParameter("qTitle");
				String qWriter = request.getParameter("qWriter");
				String qDate = request.getParameter("qDate");
				String qContent = request.getParameter("qContent");
				String qA = request.getParameter("qA");
				
				String modifydate = request.getParameter("qModifyDate");
				String modifywriter = request.getParameter("qModifyWriter");
				String qYn = request.getParameter("qYn");
				
				
				
				Qna q = new Qna();
				
				Date qDate1 = null;
				
				if(modifydate != ""&& modifydate != null) {
					//날짜가 들어 왔을 때
//				2020-01-30 ==> 2020, 1, 30

					String[] dateArr1 = modifydate.split("-");
					int[] intArr1 = new int[dateArr1.length];
					
					//String -->int
					for(int i = 0; i<dateArr1.length;i++) {
						intArr1[i] = Integer.parseInt(dateArr1[i]);
					}
					
					qDate1 = new Date(new GregorianCalendar(
							intArr1[0],intArr1[1]-1,intArr1[2]
							).getTimeInMillis());
				}else {
					//날짜가 들어오지 않으면
					qDate1 = new Date(new GregorianCalendar().getTimeInMillis());
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
			
				q.setqNo(qNo);
				q.setqTitle(qTitle);
				q.setqWriter(qWriter);
				q.setqDate(qDate1);
				q.setqCount(qCount);
				q.setqContent(qContent);
				q.setqModifyDate(writeDate);
				q.setqModifyWriter(modifywriter);
				q.setqA(qA);
				q.setqYn(qYn);
				
				
				QnaService qs = new QnaService();
				
				
				int result = qs.updateQna(q);
				
				if(result>0) {
					
					response.sendRedirect("/win/qnaRead.do");
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
