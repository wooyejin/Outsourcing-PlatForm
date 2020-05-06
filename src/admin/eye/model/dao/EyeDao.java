package admin.eye.model.dao;

import static admin.member.common.JDBCTemplate.close;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import admin.eye.model.vo.Eye;
import admin.qna.model.vo.Qna;

public class EyeDao {

	private Properties prop;
	
	public EyeDao() {
		prop = new Properties();
		
		String filePath = EyeDao.class.getResource("/config/Eye_query.properties").getPath();
		
		try {
			prop.load(new FileReader(filePath));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Eye> selectList(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Eye> elist = null;
		
		String sql = prop.getProperty("readEye");
		try {
			
			pstmt = con.prepareStatement(sql);
			rset=pstmt.executeQuery();
			
			elist = new ArrayList<Eye>();
			
			while(rset.next()) {
				Eye e = new Eye();
				
				e.seteNo(rset.getInt("EYE_NO"));
				e.seteYn(rset.getString("EYE_YN"));
				e.seteWriter(rset.getString("EYE_WRITER"));
				e.seteDate(rset.getDate("EYE_DATE"));
				e.seteContent(rset.getString("EYE_CONTENT"));
			
				
	
				elist.add(e);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return elist;
	}
	
	public int insertEcount(Connection con) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		try {
				String sql = prop.getProperty("updateEcount");
				
				pstmt = con.prepareStatement(sql);
				
				
				
				result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
		
	}
	
	
	
	public Eye selectOne(Connection con, int eNo) {
		Eye e  = null;
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      
	      String sql = prop.getProperty("selectOne");
	      try {
	         pstmt = con.prepareStatement(sql);
	         
	         pstmt.setInt(1, eNo);
	         
	         
	         rset = pstmt.executeQuery();
	                  
	         if(rset.next()) {
	        	 e = new Eye();
	        	 
					e.seteNo(eNo);
					e.seteWriter(rset.getString("Q_WRITER"));
					e.seteDate(rset.getDate("Q_DATE"));
					e.seteContent(rset.getString("Q_CONTENT"));
					e.seteYn(rset.getString("Q_YN"));
				
					
					

	         }
	         
	         
	      }catch(SQLException a) {
	         a.printStackTrace();
	      }finally {
	         close(rset);
	         close(pstmt);
	      }
	      return e;
	   }
	/**
	 * 회원정보 수정
	 * @param con
	 * @param eNo 
	 * @param n
	 * @return
	 */
	public int updateEye(Connection con, Eye e, String eNo) {
	int result = 0;
	
	PreparedStatement pstmt = null;
	
	
	try {
		String sql = prop.getProperty("updateEye");
		
		pstmt = con.prepareStatement(sql);
		System.out.println("dao"+e.geteNo());
		System.out.println("dao"+e.geteYn());
		
		pstmt.setString(1, e.geteYn());
		pstmt.setString(2, eNo);
		
		
		result = pstmt.executeUpdate();
	} catch (SQLException a) {
		a.printStackTrace();
	}finally {
		close(pstmt);
	}
		return result;
		
}

}
