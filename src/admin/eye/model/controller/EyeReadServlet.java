package admin.eye.model.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.eye.model.service.EyeService;
import admin.eye.model.vo.Eye;

/**
 * Servlet implementation class EyeReadServlet
 */
@WebServlet("/eyeRead.do")
public class EyeReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public EyeReadServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Eye> elist = new ArrayList<Eye>();
		EyeService es = new EyeService();
		int result =0;
		
		elist = es.readEye();
		String page = null;
		
		
		if(elist!=null) {
			result=es.insertEcount();
			if(result>0) {
			page= "eye.jsp";
			request.setAttribute("elist", elist);
			
		}else {
			page = "errorPage.jsp";
			request.setAttribute("msg", "회원 목록 불러오기 에러!");
		}
		}
		request.getRequestDispatcher(page).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
