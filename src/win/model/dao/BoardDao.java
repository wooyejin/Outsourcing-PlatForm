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

import win.model.vo.Board;

import static win.common.JDBCTemplate.*;


public class BoardDao {

	private Properties prop;
	
	public BoardDao() {
		prop = new Properties();
		
		String filePath = BoardDao.class.getResource("/config/board-query.properties").getPath();
		
		try {
			prop.load(new FileReader(filePath));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * �Խñ� �ۼ�
	 * @param con
	 * @return
	 */
	public int insertBoard(Connection con, Board b) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertBoard");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, b.getBwriter());
			pstmt.setString(2, b.getBtitle());
			pstmt.setString(3, b.getBcontent());
			pstmt.setString(4, b.getBoardfile());
			
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	/**
	 * �� �Խñ� ��
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
			
			System.out.println(listCount);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
		return listCount;
	}

	/** 
	 * �Խñ� ��� ��ȸ
	 * @param
	 * @return
	 */
	public ArrayList<Board> selectList(Connection con) {
		ArrayList<Board> list = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		
		try {
			
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			list = new ArrayList<Board>();
			
			
			while(rset.next()) {
				Board b = new Board();
				
				b.setBno(rset.getInt("Q_NO"));
				b.setBtitle(rset.getString("Q_TITLE"));
				b.setBcontent(rset.getString("Q_CONTENT"));
				b.setBwriter(rset.getString("Q_WRITER"));
				b.setBcount(rset.getInt("Q_COUNT"));
				b.setBdate(rset.getDate("Q_DATE"));
				b.setBoardfile(rset.getString("Q_FILE"));
				
				list.add(b);
			}
			
			System.out.println(list);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		return list;
		
	}

	/**
	 * �Խñ� �� ����
	 * @param
	 * @return
	 */
	public Board selectOne(Connection con, int bno) {
		Board b = null;
		PreparedStatement pstmt =  null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectOne");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, bno);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				b = new Board();
				
				b.setBno(bno);
				b.setBtitle(rset.getString("Q_TITLE"));
				b.setBcontent(rset.getString("Q_CONTENT"));
				b.setBwriter(rset.getString("Q_WRITER"));
				b.setBcount(rset.getInt("Q_COUNT"));
				b.setBdate(rset.getDate("Q_DATE"));
				b.setBoardfile(rset.getString("Q_FILE"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
				
		return b;
	}
	
	/**
	 * �Խñ� ���� �Ϸ�
	 * 
	 * @param
	 * @return
	 */

	public int updateBoard(Connection con, Board b) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateBoard");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, b.getBtitle());
			pstmt.setString(2, b.getBcontent());
			pstmt.setString(3, b.getBoardfile());
			pstmt.setInt(4, b.getBno());
			
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	/**
	 * �Խñ� ����
	 * 
	 * @param
	 * @return
	 */
	public int deleteBoard(Connection con, int bno) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteBoard");
		
		try {
			pstmt =con.prepareStatement(sql);
			
			pstmt.setInt(1, bno);
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	/**
	 * �Խñ� ��ȸ�� ������
	 * 
	 * @param
	 * @return
	 */
	public int updateReadCount(Connection con, int bno) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateReadCount");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	

}
