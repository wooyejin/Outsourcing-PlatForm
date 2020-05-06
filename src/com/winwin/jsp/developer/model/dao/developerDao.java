package com.winwin.jsp.developer.model.dao;

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

import com.winwin.jsp.developer.model.vo.developer;
import com.winwin.jsp.project.model.vo.Project;
import com.winwin.jsp.developer.model.dao.developerDao;
import com.winwin.jsp.developer.model.vo.developer;

public class developerDao {
private Properties prop;
	
	public developerDao() {
		prop = new Properties();
		
		String filePath = developerDao.class.getResource("/config/developer-query.properties").getPath();
		
		try {
			prop.load(new FileReader(filePath));
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
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


	public ArrayList<developer> selectList(Connection con, int currentPage, int limit) {
		ArrayList<developer> list = null;
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
			
			list = new ArrayList<developer>();
			
			while(rset.next()) {
				developer d = new developer();
				
				d.setuId(rset.getString("U_ID"));
				d.setuName(rset.getString("UNAME"));
				d.setuPhoto(rset.getString("U_PROFILE"));
				d.setuIntro(rset.getString("U_INTRO"));
				d.setuNo(rset.getInt("UNO"));
				d.setUyn(rset.getString("U_YN"));
				d.setPortYN(rset.getString("D_PORT"));
				d.setImg(rset.getString("CHANGENAME"));
				d.setIntro(rset.getString("IN_CONTENT"));
				d.setTitle(rset.getString("IN_TITLE"));
								
							
				
				list.add(d);
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}


	public ArrayList<developer> searchDeveloper(Connection con, int currentPage, int limit, String keyword) {
		ArrayList<developer> list =null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = null;
		sql = prop.getProperty("searchDevel");
		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, keyword);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<developer>();
			System.out.println("Sql : " + sql);
			System.out.println("시작 : " + currentPage);
			System.out.println("끝 : "+ limit);
			System.out.println("검색어 : " + keyword);
			
			while(rset.next()) {
				developer d = new developer();
				
				d.setuId(rset.getString("U_ID"));
				d.setuPhoto(rset.getString("U_PROFILE"));
				d.setuIntro(rset.getString("U_INTRO"));
				d.setuNo(rset.getInt("UNO"));			
				d.setUyn(rset.getString("U_YN"));
				
				list.add(d);
				System.out.println("daolist : " +list.toString());
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}


	public developer selectOne(Connection con, int dno) {
		developer d = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectOne");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				d = new developer();
				d.setuNo(dno);
				
				
							
				
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return d;
		
	}

}
