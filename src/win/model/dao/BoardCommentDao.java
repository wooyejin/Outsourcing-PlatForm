package win.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import win.model.vo.BoardComment;
import static win.common.JDBCTemplate.*;

public class BoardCommentDao {

	private Properties prop;
	
	public BoardCommentDao() {
		prop = new Properties();
		
		String filePath = BoardCommentDao.class
					.getResource("/config/comment-query.properties")
					.getPath();
		
		try {
			prop.load(new FileReader(filePath));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	// 게시글
	public ArrayList<BoardComment> selectList(Connection con, int bno) {
		ArrayList<BoardComment> clist = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, bno);
			
			rset = pstmt.executeQuery();
			
			clist = new ArrayList<BoardComment>();
			
			while(rset.next()) {
				BoardComment bco = new BoardComment();
				
				bco.setCno(rset.getInt("EYE_NO"));
				bco.setBno(bno);
				bco.setCcontent(rset.getString("EYE_CONTENT"));
				bco.setCwriter(rset.getString("EYE_WRITER"));
//				bco.setCwriterId(rset.getString("EYE_WRITER"));
				bco.setCdate(rset.getDate("EYE_DATE"));
				
				clist.add(bco);
			}
			System.out.println(clist);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return clist;
	}


	public int insertComment(Connection con, BoardComment bco) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertComment");
		
		try {
			pstmt = con.prepareStatement(sql);
			
		
			pstmt.setString(1, bco.getCwriter());
			pstmt.setString(2, bco.getCcontent());
			pstmt.setInt(3, bco.getBno());
			
		
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}


	/**
	 * 게시글 답글 삭제
	 *@param
	 *@return
	 */
	
	public int deleteComment(Connection con, int cno) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteComment");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, cno);
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	
	
	
}
