package win.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import win.model.vo.Notice;
import static win.common.JDBCTemplate.*;

public class NoticeDao {
	
	private Properties prop;
	
	public NoticeDao() {
		prop = new Properties();
		
		String filePath = Notice.class.getResource("/config/notice-query.properties").getPath();
		
		try {
			prop.load(new FileReader(filePath));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 공지사항 목록
	 * 
	 * @return
	 */
	public ArrayList<Notice> selectList(Connection con) {
		ArrayList<Notice> list = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			list = new ArrayList<Notice>();
			
			while(rset.next()) {
				Notice n = new Notice();
				
				n.setNno(rset.getInt(1));
				n.setNtitle(rset.getString("N_TITLE"));
				n.setNwriter(rset.getString("N_WRITER"));
				n.setNcontent(rset.getString("N_CONTENT"));
				n.setNcount(rset.getInt("N_COUNT"));
				n.setNdate(rset.getDate("N_DATE"));
				
				list.add(n);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		return list;
	}


	/**
	 * 공지사항 상세
	 * 
	 * @return
	 */
	public Notice selectOne(Connection con, int nno) {
		Notice result = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null; 
		
		String sql = prop.getProperty("selectOne");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, nno);
			
			rset = pstmt.executeQuery();
					
			if(rset.next()) {
				result = new Notice();
				
				result.setNno(nno);
				result.setNtitle(rset.getString("N_TITLE"));
				result.setNwriter(rset.getString("N_WRITER"));
				result.setNcontent(rset.getString("N_CONTENT"));
				result.setNcount(rset.getInt("N_COUNT"));
				result.setNdate(rset.getDate("N_DATE"));	
			}
			System.out.println("notice 확인 : " + result);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	/**
	 * 공지사항 조회수 증가용
	 * @param con
	 * @param nno
	 * @return
	 */
	public int updateReadCount(Connection con, int nno) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateReadCount");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, nno);
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}


}
