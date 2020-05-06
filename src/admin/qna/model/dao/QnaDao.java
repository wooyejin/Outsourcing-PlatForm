package admin.qna.model.dao;

import static admin.member.common.JDBCTemplate.close;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import admin.notice.model.vo.Notice;
import admin.qna.model.vo.Qna;

public class QnaDao {

	private Properties prop;
	
	public QnaDao() {
		prop = new Properties();
		
		String filePath = QnaDao.class.getResource("/config/Qna_query.properties").getPath();
		
		try {
			prop.load(new FileReader(filePath));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Qna> selectList(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Qna> qlist = null;
		
		String sql = prop.getProperty("readQna");
		try {
			
			pstmt = con.prepareStatement(sql);
			rset=pstmt.executeQuery();
			
			qlist = new ArrayList<Qna>();
			
			while(rset.next()) {
				Qna q = new Qna();
				
				q.setqNo(rset.getInt("Q_NO"));
				q.setqYn(rset.getString("Q_YN"));
				q.setqTitle(rset.getString("Q_TITLE"));
				q.setqWriter(rset.getString("Q_WRITER"));
				q.setqDate(rset.getDate("Q_DATE"));
				q.setqCount(rset.getInt("Q_COUNT"));
				q.setqContent(rset.getString("Q_CONTENT"));
				q.setqA(rset.getString("Q_A"));
				q.setqModifyDate(rset.getDate("Q_MODIFY_DATE"));
				q.setqModifyWriter(rset.getString("Q_MODIFY_WRITER"));
			
				
	
				qlist.add(q);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return qlist;
	}
	
	
	
	public Qna selectOne(Connection con, int qNo) {
		Qna q  = null;
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      
	      String sql = prop.getProperty("selectOne");
	      try {
	         pstmt = con.prepareStatement(sql);
	         
	         pstmt.setInt(1, qNo);
	         
	         
	         rset = pstmt.executeQuery();
	                  
	         if(rset.next()) {
	        	 q = new Qna();
	        	 
					q.setqNo(qNo);
					q.setqTitle(rset.getString("Q_TITLE"));
					q.setqWriter(rset.getString("Q_WRITER"));
					q.setqDate(rset.getDate("Q_DATE"));
					q.setqCount(rset.getInt("Q_COUNT"));
					q.setqContent(rset.getString("Q_CONTENT"));
					q.setqA(rset.getString("Q_A"));
					q.setqModifyDate(rset.getDate("Q_MODIFY_DATE"));
					q.setqModifyWriter(rset.getString("Q_MODIFY_WRITER"));
					q.setqYn(rset.getString("Q_YN"));
					
					
					

	         }
	         
	         
	      }catch(SQLException e) {
	         e.printStackTrace();
	      }finally {
	         close(rset);
	         close(pstmt);
	      }
	      return q;
	   }
	/**
	 * 회원정보 수정
	 * @param con
	 * @param n
	 * @return
	 */
	public int updateQna(Connection con, Qna q) {
	int result = 0;
	
	PreparedStatement pstmt = null;
	
	
	try {
		String sql = prop.getProperty("updateQna");
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, q.getqTitle());
		pstmt.setString(2, q.getqWriter());
		pstmt.setDate(3, q.getqDate());
		pstmt.setInt(4, q.getqCount());
		pstmt.setString(5, q.getqContent());
		pstmt.setString(6, q.getqA());
		pstmt.setDate(7, q.getqModifyDate());
		pstmt.setString(8, q.getqModifyWriter());
		pstmt.setString(9, q.getqYn().toUpperCase());
		pstmt.setInt(10, q.getqNo());
		
		
		result = pstmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		close(pstmt);
	}
		return result;
		
}

}
