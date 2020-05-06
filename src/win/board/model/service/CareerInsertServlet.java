package win.board.model.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import win.board.model.vo.Career;

import win.model.vo.Member;

/**
 * Servlet implementation class CareerInsertServlet
 */
@WebServlet("/mCareer.me")
public class CareerInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CareerInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); 
        Member m = (Member)session.getAttribute("member");
        
        ArrayList<Career> clist = new ArrayList<Career>(); 
        
        int no = m.getNo(); 
   
        String name = m.getMemberType();
        
        CareerService cs = new CareerService();
        
        String title1 = request.getParameter("title1");
        String field1 = request.getParameter("field1");
        String position1 = request.getParameter("position1");
        String career1 = request.getParameter("career1");
        String work1 = request.getParameter("work1");
        
        String title2 = request.getParameter("title2");
        String field2 = request.getParameter("field2");
        String position2 = request.getParameter("position2");
        String career2 = request.getParameter("career2");
        String work2 = request.getParameter("work2");
        
        String title3 = request.getParameter("title3");
        String field3 = request.getParameter("field3");
        String position3 = request.getParameter("position3");
        String career3 = request.getParameter("career3");
        String work3 = request.getParameter("work3");
        
        String title4 = request.getParameter("title4");
        String field4 = request.getParameter("field4");
        String position4 = request.getParameter("position4");
        String career4 = request.getParameter("career4");
        String work4 = request.getParameter("work4");
        
        String title5 = request.getParameter("title5");
        String field5 = request.getParameter("field5");
        String position5 = request.getParameter("position5");
        String career5 = request.getParameter("career5");
        String work5 = request.getParameter("work5");
        
        Career c1 = new Career(title1,field1,position1,career1,work1,no);
        Career c2 = new Career(title2,field2,position2,career2,work2,no);
        Career c3 = new Career(title3,field3,position3,career3,work3,no);
        Career c4 = new Career(title4,field4,position4,career4,work4,no);
        Career c5 = new Career(title5,field5,position5,career5,work5,no);
        
        clist.add(c1);
        clist.add(c2);
        clist.add(c3);
        clist.add(c4);
        clist.add(c5);
 
        
        int result = new CareerService().insertCareer(clist,name,no);
        
 
        
        if(result >0) {
            
        	session.setAttribute("clist", clist);
            
            if(name.equals("D")) {
            response.sendRedirect("/win/page/myPage1.jsp"); } 
            
            else if(name.equals("C")) {
            response.sendRedirect("/win/page/mypage_company.jsp"); }
            
            }else { request.setAttribute("msg", "게시글 작성 실패");
            request.getRequestDispatcher("views/common/errorPage.jsp").forward(request,
            response);
            
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
