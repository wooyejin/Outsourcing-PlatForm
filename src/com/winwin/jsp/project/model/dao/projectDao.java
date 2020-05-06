package com.winwin.jsp.project.model.dao;

import static com.winwin.jsp.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.winwin.jsp.developer.model.dao.developerDao;
import com.winwin.jsp.project.model.exception.projectException;
import com.winwin.jsp.project.model.vo.Project;

import win.model.vo.Member;

public class projectDao {
	private Properties prop;
	
	public projectDao() {
		prop = new Properties();
		
		String filePath = projectDao.class.getResource("/config/Project_query.properties").getPath();
		
		try {
			prop.load(new FileReader(filePath));
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * � 프로젝트 등록
	 * @param con
	 * @param p
	 * @param m 
	 * @return
	 */
	public int insertProject(Connection con, Project p, Member m) throws projectException {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			String sql = prop.getProperty("insertProject");
			System.out.println(sql);
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, p.getPtitle());
			pstmt.setString(2, p.getPbang());
			pstmt.setString(3, p.getPtype());
			pstmt.setString(4, p.getPdetail());
			pstmt.setString(5, p.getPcotx());
			pstmt.setInt(6, p.getPcost());
			pstmt.setDate(7, p.getPstart());
			pstmt.setDate(8,p.getPend());
			pstmt.setInt(9, m.getNo());
			pstmt.setString(10, p.getPgo());
			pstmt.setString(11, p.getCareer());
			pstmt.setString(12, p.getMemcount());
		
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			throw new projectException(e.getMessage());
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	/**
	 * 프로젝트 리스트 조회
	 * @param con
	 * @param currentPage
	 * @param limit
	 * @return
	 */
	public ArrayList<Project> selectList(Connection con, int currentPage, int limit) {
		ArrayList<Project> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = con.prepareStatement(sql);
			int startRow = (currentPage-1)*limit + 1; 
			int endRow = startRow + limit -1;
			
			pstmt.setInt(1,  endRow);
			pstmt.setInt(2, startRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Project>();
			
			while(rset.next()) {
				Project p = new Project();
				
				p.setPtitle(rset.getString("P_TITLE"));
				p.setPenroll(rset.getDate("P_ENRO"));
				p.setPcost(rset.getInt("P_COST"));
				p.setPgo(rset.getString("P_GO"));
				p.setPend(rset.getDate("P_END"));
				p.setPbang(rset.getString("P_BANG"));
				p.setPstart(rset.getDate("P_START"));
				p.setPtype(rset.getString("P_TYPE"));
				p.setPdetail(rset.getString("P_DETAIL"));
				p.setPcotx(rset.getString("P_COTX"));
				p.setPno(rset.getInt("PNO"));
				p.setcId(rset.getString("C_ID"));
				p.setcContent(rset.getString("CN_CONTENT"));
				p.setcImg(rset.getString("C_CHANGENAME"));
				p.setCareer(rset.getString("P_CAREER"));
				p.setMemcount(rset.getString("P_MEMCOUNT"));
							
				
				list.add(p);
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	/**
	 * 프로젝트 갯수 파악 
	 * @param con
	 * @return
	 */
	public int getListCount(Connection con) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("listCount");
		
		try {
			stmt = con.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
		return listCount;
	}

	/**
	 * 프로젝트 조건 검색
	 * @param con
	 * @param category
	 * @param sort 
	 * @return
	 */
	public ArrayList<Project> searchProject(Connection con, int currentPage,int limit, String category,String keyword, String sort) {
		ArrayList<Project> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		if(category.equals("develop, design")) {
		
			category = "devdes";
		}else if(category.equals("develop, design, plan")) {
		
			category = "devdespl";
		}else if(category.equals("develop, plan")) {
			
			category="devpl";
		}else if(category.equals("design, plan")) {
			category="despl";
		}
	
		
		
		String sql = null;
		System.out.println("category1 : " +category);
		if(category == null || category == "" || category.isEmpty() == true){
			switch(sort) {
			case "sort1" : 
				sql= prop.getProperty("selectByKeyword");
				break;	
			case "sort2" : 
				sql= prop.getProperty("selectByKeywordbyCost");
				break;
			case "sort3" : 
				sql= prop.getProperty("selectByKeywordbyEnroll");
				break;
			case "sort4" : 
				sql= prop.getProperty("selectByKeywordbyEnd");
				break;
				
			}
			
			
			System.out.println("sql1 : " + sql);
				
				try {
					
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, keyword);
					
					rset = pstmt.executeQuery();
					
					list = new ArrayList<Project>();
					
					while(rset.next()) {
						Project p = new Project();
						
						p.setPtitle(rset.getString("P_TITLE"));
						p.setPenroll(rset.getDate("P_ENRO"));
						p.setPcost(rset.getInt("P_COST"));
						p.setPgo(rset.getString("P_GO"));
						p.setPend(rset.getDate("P_END"));
						p.setCount(rset.getInt("COUNT"));
						p.setPbang(rset.getString("P_BANG"));
						p.setPstart(rset.getDate("P_START"));
						p.setPtype(rset.getString("P_TYPE"));
						p.setPcotx(rset.getString("P_COTX"));
						p.setPno(rset.getInt("PNO"));
									
						
						list.add(p);
						
					}
					
				}catch(SQLException e) {
					e.printStackTrace();
				}finally {
					close(rset);
					close(pstmt);
				}
				
		
		}else if(category.length() > 0 && keyword.length()>0) {
			if(sort.equals("sort1") ) {
			switch(category) {
			case "plan": 
				sql = prop.getProperty("searchPlanProject");
				break;
			case "design" :
				sql = prop.getProperty("searchDesignProject");
				break;
			case "develop": 
				sql = prop.getProperty("searchDevelProject");
				break;
			case "devdespl" :
				sql = prop.getProperty("searchdevdesplProject");
				break;
			case "devdes":
				sql = prop.getProperty("searchdevdesProject");
				break;
			case "devpl" :
				sql = prop.getProperty("searchdevplProject");
				break;
			case "despl" :
				sql	= prop.getProperty("searchdesplProject");
				break;
			}
				
			}else if(sort.equals("sort2")) {
				switch(category) {
				case "plan": 
					sql = prop.getProperty("searchPlanProjectbyCost");
					break;
				case "design" :
					sql = prop.getProperty("searchDesignProjectbyCost");
					break;
				case "develop": 
					sql = prop.getProperty("searchDevelProjectbyCost");
					break;
				case "devdespl" :
					sql = prop.getProperty("searchdevdesplProjectbyCost");
					break;
				case "devdes":
					sql = prop.getProperty("searchdevdesProjectbyCost");
					break;
				case "devpl" :
					sql = prop.getProperty("searchdevplProjectbyCost");
					break;
				case "despl" :
					sql	= prop.getProperty("searchdesplProjectbyCost");
					break;
				}
			}else if(sort.equals("sort3")) {
					switch(category) {
					case "plan": 
						sql = prop.getProperty("searchPlanProjectbyEnroll");
						break;
					case "design" :
						sql = prop.getProperty("searchDesignProjectbyEnroll");
						break;
					case "develop": 
						sql = prop.getProperty("searchDevelProjectbyEnroll");
						break;
					case "devdespl" :
						sql = prop.getProperty("searchdevdesplProjectbyEnroll");
						break;
					case "devdes":
						sql = prop.getProperty("searchdevdesProjectbyEnroll");
						break;
					case "devpl" :
						sql = prop.getProperty("searchdevplProjectbyEnroll");
						break;
					case "despl" :
						sql	= prop.getProperty("searchdesplProjectbyEnroll");
						break;
				}
			}else if(sort.equals("sort4")) {
				switch(category) {
				case "plan": 
					sql = prop.getProperty("searchPlanProjectbyEnd");
					break;
				case "design" :
					sql = prop.getProperty("searchDesignProjectbyEnd");
					break;
				case "develop": 
					sql = prop.getProperty("searchDevelProjectbyEnd");
					break;
				case "devdespl" :
					sql = prop.getProperty("searchdevdesplProjectbyEnd");
					break;
				case "devdes":
					sql = prop.getProperty("searchdevdesProjectbyEnd");
					break;
				case "devpl" :
					sql = prop.getProperty("searchdevplProjectbyEnd");
					break;
				case "despl" :
					sql	= prop.getProperty("searchdesplProjectbyEnd");
					break;
			}
			}
			System.out.println("sql2 : " + sql);
			try {
				System.out.println(sql);
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, keyword);
				
				rset = pstmt.executeQuery();
				
				list = new ArrayList<Project>();
				
				while(rset.next()) {
					Project p = new Project();
					
					p.setPtitle(rset.getString("P_TITLE"));
					p.setPenroll(rset.getDate("P_ENRO"));
					p.setPcost(rset.getInt("P_COST"));
					p.setPgo(rset.getString("P_GO"));
					p.setPend(rset.getDate("P_END"));
					p.setCount(rset.getInt("COUNT"));
					p.setPbang(rset.getString("P_BANG"));
					p.setPstart(rset.getDate("P_START"));
					p.setPtype(rset.getString("P_TYPE"));
					p.setPcotx(rset.getString("P_COTX"));
					p.setPno(rset.getInt("PNO"));	
					
					list.add(p);
					
				}
				System.out.println("list : " + list);
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
		}
		else if(category.length()>0 || keyword.length() <=0){
			if(sort.equals("sort1")) {
			switch(category) {
			case "plan": 
				sql = prop.getProperty("searchPlanProject1");
				break;
			case "design" :
				sql = prop.getProperty("searchDesignProject1");
				break;
			case "develop": 
				sql = prop.getProperty("searchDevelProject1");
				break;
			case "devdespl" :
				sql = prop.getProperty("searchdevdesplProject1");
				break;
			case "devdes":
				sql = prop.getProperty("searchdevdesProject1");
				break;
			case "devpl" :
				sql = prop.getProperty("searchdevplProject1");
				break;
			case "despl" :
				sql	= prop.getProperty("searchdesplProject1");
				break;
			}
			}else if(sort.equals("sort2")) {
				switch(category) {
				case "plan": 
					sql = prop.getProperty("searchPlanProject1byCost");
					break;
				case "design" :
					sql = prop.getProperty("searchDesignProject1byCost");
					break;
				case "develop": 
					sql = prop.getProperty("searchDevelProject1byCost");
					break;
				case "devdespl" :
					sql = prop.getProperty("searchdevdesplProject1byCost");
					break;
				case "devdes":
					sql = prop.getProperty("searchdevdesProject1byCost");
					break;
				case "devpl" :
					sql = prop.getProperty("searchdevplProject1byCost");
					break;
				case "despl" :
					sql	= prop.getProperty("searchdesplProject1byCost");
					break;
				}
			}else if(sort.equals("sort3")) {
				switch(category) {
				case "plan": 
					sql = prop.getProperty("searchPlanProject1byEnroll");
					break;
				case "design" :
					sql = prop.getProperty("searchDesignProject1byEnroll");
					break;
				case "develop": 
					sql = prop.getProperty("searchDevelProject1byEnroll");
					break;
				case "devdespl" :
					sql = prop.getProperty("searchdevdesplProject1byEnroll");
					break;
				case "devdes":
					sql = prop.getProperty("searchdevdesProject1byEnroll");
					break;
				case "devpl" :
					sql = prop.getProperty("searchdevplProject1byEnroll");
					break;
				case "despl" :
					sql	= prop.getProperty("searchdesplProject1byEnroll");
					break;
				}
			}else if(sort.equals("sort4")) {
				switch(category) {
				case "plan": 
					sql = prop.getProperty("searchPlanProject1byEnd");
					break;
				case "design" :
					sql = prop.getProperty("searchDesignProject1byEnd");
					break;
				case "develop": 
					sql = prop.getProperty("searchDevelProject1byEnd");
					break;
				case "devdespl" :
					sql = prop.getProperty("searchdevdesplProject1byEnd");
					break;
				case "devdes":
					sql = prop.getProperty("searchdevdesProject1byEnd");
					break;
				case "devpl" :
					sql = prop.getProperty("searchdevplProject1byEnd");
					break;
				case "despl" :
					sql	= prop.getProperty("searchdesplProject1byEnd");
					break;
				}
			}
			
			System.out.println("sql3 : " + sql);
			try {
				System.out.println(sql);
				pstmt = con.prepareStatement(sql);
				
				
				rset = pstmt.executeQuery();
				
				list = new ArrayList<Project>();
				
				while(rset.next()) {
					Project p = new Project();
					
					p.setPtitle(rset.getString("P_TITLE"));
					p.setPenroll(rset.getDate("P_ENRO"));
					p.setPcost(rset.getInt("P_COST"));
					p.setPgo(rset.getString("P_GO"));
					p.setPend(rset.getDate("P_END"));
					p.setCount(rset.getInt("COUNT"));
					p.setPbang(rset.getString("P_BANG"));
					p.setPstart(rset.getDate("P_START"));
					p.setPtype(rset.getString("P_TYPE"));
					p.setPcotx(rset.getString("P_COTX"));
					p.setPno(rset.getInt("PNO"));
					
					list.add(p);
					
				}
				System.out.println("list : " + list);
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
		}
		
		
		
		
		return list;
		
	}

	/**
	 * 프로젝트 검색창 조회
	 * @param con
	 * @return
	 */
	public ArrayList<Project> SearchSelectList(Connection con) {
		ArrayList<Project> list = null; // 전달할 객체 선언
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList2");
		
		try {
			stmt = con.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			list = new ArrayList<Project>();
			
			// if, while
			while(rset.next()) {
				Project p = new Project();
				
				p.setPtitle(rset.getString("P_TITLE"));
				p.setPenroll(rset.getDate("P_ENRO"));
				p.setPcost(rset.getInt("P_COST"));
				p.setPgo(rset.getString("P_GO"));
				p.setPend(rset.getDate("P_END"));
				p.setCount(rset.getInt("COUNT"));
				p.setPbang(rset.getString("P_BANG"));
				p.setPstart(rset.getDate("P_START"));
				p.setPtype(rset.getString("P_TYPE"));
				p.setPcotx(rset.getString("P_COTX"));
							
				
				list.add(p);
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
		
		return list;
	}

	public Project selectOne(Connection con, int pno) {
		Project p = null;
		PreparedStatement pstmt =null;
		ResultSet rset= null;
		
		String sql = prop.getProperty("selectOne2");
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				p = new Project();
				
				p.setPtitle(rset.getString("P_TITLE"));
				p.setCname(rset.getString("CNAME"));
				p.setPcost(rset.getInt("P_COST"));
				p.setPgo(rset.getString("P_GO"));
				p.setPenroll(rset.getDate("P_ENRO"));
				p.setPstart(rset.getDate("P_START"));
				p.setPcotx(rset.getString("P_COTX"));
				p.setPno(pno);
				p.setPend(rset.getDate("P_END"));
				p.setPbang(rset.getString("P_BANG"));
				p.setPtype(rset.getString("P_TYPE"));
				p.setCareer(rset.getString("P_CAREER"));
				p.setPdetail(rset.getString("P_DETAIL"));
				p.setMemcount(rset.getString("P_MEMCOUNT"));
				
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return p;
	}

	public int selectCount(Connection con, int pno) {

		PreparedStatement pstmt =null;
		
		String sql = prop.getProperty("selectCount");
		
		ResultSet rset = null;
		
		int count = 0;
		
		try {
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, pno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
			count=rset.getInt(1);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		
		return count;
	}

	
	
}
