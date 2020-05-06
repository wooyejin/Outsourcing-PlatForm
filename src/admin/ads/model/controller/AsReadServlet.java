package admin.ads.model.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.ads.model.service.AdsService;
import admin.ads.model.vo.Ads;
import admin.ads.model.vo.Asset;

/**
 * Servlet implementation class AdsReadServlet
 */
@WebServlet("/asRead.do")
public class AsReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AsReadServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Asset> aslist = new ArrayList<Asset>();
		AdsService as = new AdsService();
		int result = 0;
		
		aslist = as.readAs();
		String page = null;
		
		if(aslist!=null) {
			
			result=as.insertAcount();
			if(result>0) {
			page= "asset.jsp";
			request.setAttribute("aslist", aslist);
		}else {
			page = "errorPage.jsp";
			request.setAttribute("msg", "회계정보 불러오기 에러!");
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
