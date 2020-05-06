package com.winwin.jsp.projectComment.model.dao;
import static com.winwin.jsp.common.JDBCTemplate.*;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.winwin.jsp.projectComment.model.vo.ProjectComment;

public class ProjectCommentDao {
	private Properties prop;
	
	public ProjectCommentDao() {
		prop = new Properties();
		
		String filePath = ProjectCommentDao.class.getResource("/config/comment-query.properties").getPath();
		
		try {
			prop.load(new FileReader(filePath));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<ProjectComment> selectList(Connection con, int pno) {
		ArrayList<ProjectComment> plist = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, pno);
			
			rset = pstmt.executeQuery();
			
			plist = new ArrayList<ProjectComment>();
			
			while(rset.next()) {
				ProjectComment pco = new ProjectComment();
				
				pco.setCno(rset.getInt("EYE_NO"));
				
				pco.setPno(pno);
				pco.setEcontent(rset.getString("EYE_CONTENT"));
				pco.setEwriterId(rset.getString("EYE_WRITER"));
				pco.setEdate(rset.getDate("EYE_DATE"));
				
				pco.setEwriter1(rset.getString("USERNAME"));
				pco.setEwriter2(rset.getString("CNAME"));

				plist.add(pco);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return plist;
	}

	public int insertComment(Connection con, ProjectComment pco) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertComment1");
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, pco.getPno());
			pstmt.setString(2,  pco.getEcontent());
			pstmt.setString(3,pco.getEwriter1());
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

}
