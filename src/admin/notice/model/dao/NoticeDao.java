package admin.notice.model.dao;

import static admin.member.common.JDBCTemplate.close;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import admin.ads.model.vo.Ads;
import admin.member.model.vo.Member;
import admin.notice.model.vo.Notice;

public class NoticeDao {

	private Properties prop;
	
	public NoticeDao() {
		prop = new Properties();
		
		String filePath = NoticeDao.class.getResource("/config/Notice_query.properties").getPath();
		
		try {
			prop.load(new FileReader(filePath));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Notice> selectList(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Notice> nlist = null;
		
		String sql = prop.getProperty("readNotice");
		try {
			
			pstmt = con.prepareStatement(sql);
			rset=pstmt.executeQuery();
			
			nlist = new ArrayList<Notice>();
			
			while(rset.next()) {
				Notice n = new Notice();
				
				n.setnNo(rset.getInt("N_NO"));
				n.setnYn(rset.getString("N_YN"));
				n.setnTitle(rset.getString("N_TITLE"));
				n.setnWriter(rset.getString("N_WRITER"));
				n.setnDate(rset.getDate("N_DATE"));
				n.setnCount(rset.getInt("N_COUNT"));
				n.setnContent(rset.getString("N_CONTENT"));
				n.setnModifyDate(rset.getDate("N_MODIFY_DATE"));
				n.setnModifyWriter(rset.getString("N_MODIFY_WRITER"));
			
				
	
				nlist.add(n);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return nlist;
	}
	
	public int insertNotice(Connection con, Notice n) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		
		try {
			String sql = prop.getProperty("insertNotice");
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, n.getnTitle());
			pstmt.setString(2, n.getnWriter());
			pstmt.setString(3, n.getnContent());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
			return result;
			
	}
	
	public Notice selectOne(Connection con, int nNo) {
		Notice n  = null;
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      
	      String sql = prop.getProperty("selectOne");
	      try {
	         pstmt = con.prepareStatement(sql);
	         
	         pstmt.setInt(1, nNo);
	         
	         
	         rset = pstmt.executeQuery();
	                  
	         if(rset.next()) {
	        	 n = new Notice();
	        	 
					n.setnNo(nNo);
					n.setnTitle(rset.getString("N_TITLE"));
					n.setnWriter(rset.getString("N_WRITER"));
					n.setnDate(rset.getDate("N_DATE"));
					n.setnCount(rset.getInt("N_COUNT"));
					n.setnContent(rset.getString("N_CONTENT"));
					n.setnModifyDate(rset.getDate("N_MODIFY_DATE"));
					n.setnModifyWriter(rset.getString("N_MODIFY_WRITER"));
					n.setnYn(rset.getString("N_YN"));
					
					
					

	         }
	         
	         
	      }catch(SQLException e) {
	         e.printStackTrace();
	      }finally {
	         close(rset);
	         close(pstmt);
	      }
	      return n;
	   }
	/**
	 * 회원정보 수정
	 * @param con
	 * @param n
	 * @return
	 */
	public int updateNotice(Connection con, Notice n) {
	int result = 0;
	
	PreparedStatement pstmt = null;
	
	
	try {
		String sql = prop.getProperty("updateNotice");
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, n.getnTitle());
		pstmt.setString(2, n.getnWriter());
		pstmt.setDate(3, n.getnDate());
		pstmt.setInt(4, n.getnCount());
		pstmt.setString(5, n.getnContent());
		pstmt.setDate(6, n.getnModifyDate());
		pstmt.setString(7, n.getnModifyWriter());
		pstmt.setString(8, n.getnYn().toUpperCase());
		pstmt.setInt(9, n.getnNo());
		
		
		result = pstmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		close(pstmt);
	}
		return result;
		
}

}
