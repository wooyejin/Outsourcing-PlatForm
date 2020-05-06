package admin.project.model.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.project.model.service.ProjectService;
import admin.project.model.vo.Project;

/**
 * Servlet implementation class ProjectReadServlet
 */
@WebServlet("/pUpdate.do")
public class ProjectUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ProjectUpdateServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//회원정보 수정용 데이터 꺼내오기
				int pno = Integer.parseInt(request.getParameter("pNo"));
				String enro = request.getParameter("pEnro");
				String title = request.getParameter("pTitle");
				String bang = request.getParameter("pBang");
				String type = request.getParameter("pType");
				String detail = request.getParameter("pDetail");
				String cotx = request.getParameter("pCotx");
				int cost = Integer.parseInt(request.getParameter("pCost"));
				String start = request.getParameter("pStart");
				String end = request.getParameter("pEnd");
				String go = request.getParameter("pGo");
				String modifydate = request.getParameter("pModifyDate");
				String modifywriter = request.getParameter("pModifyWriter");
				String status = request.getParameter("status");
				String pAdsYn = request.getParameter("pAdsYn");
				int cno = Integer.parseInt(request.getParameter("cNo"));
				
				HttpSession session = request.getSession(false);
				
				Project p = new Project();
				
				Date enroDate = null;
				Date startDate = null;
				Date endDate = null;
				
				Date writeDate = null;
				
				if(enro != ""&& enro != null) {
					String[] dateArr1 = modifydate.split("-");
					int[] intArr1 = new int[dateArr1.length];
					for(int i = 0; i<dateArr1.length;i++) {
						intArr1[i] = Integer.parseInt(dateArr1[i]);
					}
					enroDate = new Date(new GregorianCalendar(
							intArr1[0],intArr1[1]-1,intArr1[2]
							).getTimeInMillis());
				}else {
					enroDate = new Date(new GregorianCalendar().getTimeInMillis());
				}
				
				
				if(start != ""&& start != null) {
					String[] dateArr2 = modifydate.split("-");
					int[] intArr2 = new int[dateArr2.length];
					for(int i = 0; i<dateArr2.length;i++) {
						intArr2[i] = Integer.parseInt(dateArr2[i]);
					}
					startDate = new Date(new GregorianCalendar(
							intArr2[0],intArr2[1]-1,intArr2[2]
							).getTimeInMillis());
				}else {
					startDate = new Date(new GregorianCalendar().getTimeInMillis());
				}
				
				
				if(end != ""&& end != null) {
					String[] dateArr3 = modifydate.split("-");
					int[] intArr3 = new int[dateArr3.length];
					for(int i = 0; i<dateArr3.length;i++) {
						intArr3[i] = Integer.parseInt(dateArr3[i]);
					}
					endDate = new Date(new GregorianCalendar(
							intArr3[0],intArr3[1]-1,intArr3[2]
							).getTimeInMillis());
				}else {
					endDate = new Date(new GregorianCalendar().getTimeInMillis());
				}
				
				if(modifydate != ""&& modifydate != null) {
					String[] dateArr4 = modifydate.split("-");
					int[] intArr4 = new int[dateArr4.length];
					for(int i = 0; i<dateArr4.length;i++) {
						intArr4[i] = Integer.parseInt(dateArr4[i]);
					}
					writeDate = new Date(new GregorianCalendar(
							intArr4[0],intArr4[1]-1,intArr4[2]
							).getTimeInMillis());
				}else {
					writeDate = new Date(new GregorianCalendar().getTimeInMillis());
				}
				
				
				
				
				//기존의 회원 정보를 새로운 값으로 변경하기
			
				p.setpNo(pno);
				p.setpEnro(enroDate);
				p.setpTitle(title);
				p.setpBang(bang);
				p.setpType(type);
				p.setpDetail(detail);
				p.setpCotx(cotx);
				p.setpCost(cost);
				p.setpStart(startDate);
				p.setpEnd(endDate);
				p.setpGo(go);
				p.setpModifyDate(writeDate);
				p.setpModifyWriter(modifywriter);
				p.setStatus(status);
				p.setpAdsYn(pAdsYn);
				p.setcNo(cno);
				
				System.out.println("변경한 프로젝트 정보 확인 : "+p);
				
				ProjectService ps = new ProjectService();
				
				
				
				int result = ps.updateProject(p);
				int result2 = ps.insultAsset(p);
				
				
				
				if(result>0 || result2>0) {
				
					
					
					response.sendRedirect("/win/projectRead.do");
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
