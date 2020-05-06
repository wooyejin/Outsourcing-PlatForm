package win.board.model.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import win.board.model.vo.Skill;
import win.exception.MemberException;
import win.model.service.MemberService;
import win.model.vo.Member;

/**
 * Servlet implementation class SkillInsertServlet
 */
@WebServlet("/mSkill.me")
public class SkillInsertServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SkillInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      
        HttpSession session = request.getSession(); 
        Member m = (Member)session.getAttribute("member");
        ArrayList<Skill> slist = new ArrayList<Skill>(); 
        
        int no = m.getNo(); 
   
        String name = m.getMemberType();
        
        SkillService ss = new SkillService();
        
        String title1 = request.getParameter("title1");
        String workmanship1 = request.getParameter("workmanship1");
        String experience1 = request.getParameter("experience1");
        
        String title2 = request.getParameter("title2");
        String workmanship2 = request.getParameter("workmanship2");
        String experience2 = request.getParameter("experience2");
        
        String title3 = request.getParameter("title3");
        String workmanship3 = request.getParameter("workmanship3");
        String experience3 = request.getParameter("experience3");
        
        String title4 = request.getParameter("title4");
        String workmanship4 = request.getParameter("workmanship4");
        String experience4 = request.getParameter("experience4");
        
        String title5 = request.getParameter("title5");
        String workmanship5 = request.getParameter("workmanship5");
        String experience5 = request.getParameter("experience5");
        
        
        
        Skill s1 = new Skill(title1, workmanship1, experience1,no);
        Skill s2 = new Skill(title2, workmanship2, experience2,no);
        Skill s3 = new Skill(title3, workmanship3, experience3,no);
        Skill s4 = new Skill(title4, workmanship4, experience4,no);
        Skill s5 = new Skill(title5, workmanship5, experience5,no);
       
        slist.add(s1);
        slist.add(s2);
        slist.add(s3);
        slist.add(s4);
        slist.add(s5);
       
        int result = new SkillService().insertSkill(slist,name,no);
        
        
        if(result >0) {
        
    
        if(name.equals("D")) {
        	
        session.setAttribute("slist", slist);
                 	
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