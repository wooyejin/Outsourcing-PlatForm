package admin.portfolio.model.dao;

import static admin.member.common.JDBCTemplate.close;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;


import admin.portfolio.model.vo.Portfolio;
import win.model.vo.Member;

public class PortfolioDao {

	private Properties prop;
	
	public PortfolioDao() {
		prop = new Properties();
		
		String filePath = PortfolioDao.class.getResource("/config/Portfolio_query.properties").getPath();
		
		try {
			prop.load(new FileReader(filePath));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Portfolio> selectList(Connection con) {
	
		Statement stmt= null;
		
		ResultSet rset = null;
		ArrayList<Portfolio> flist = null;
		
		String sql = prop.getProperty("readPortfolio");
		try {
			stmt= con.createStatement();
			
			rset=stmt.executeQuery(sql);
			
			flist = new ArrayList<Portfolio>();
			
			while(rset.next()) {
				Portfolio f = new Portfolio();
				
				f.setPortNo(rset.getInt(1));
				f.setuNo(rset.getInt(3));
				f.setPort(rset.getString(2));
				f.setPoYn(rset.getString(4));
				f.setPoModifyDate(rset.getDate(5));
				f.setPoModifyWriter(rset.getString(6));
				
	
				flist.add(f);
			}
			System.out.println("flist:"+flist);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return flist;
	}
	public Portfolio selectOne(Connection con, int portNo) {
		Portfolio f  = null;
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      
	      String sql = prop.getProperty("selectOne");
	      try {
	         pstmt = con.prepareStatement(sql);
	         
	         pstmt.setInt(1, portNo);
	         
	         
	         // INSERT, UPDATE, DELETE : executeUpdate();
	         // SELECT : executeQuery();
	         rset = pstmt.executeQuery();
	                  
	         // if, while
	         if(rset.next()) {
	        	 f = new Portfolio();
	        	 
	        	 f.setPortNo(rset.getInt("PORTNO"));
					f.setuNo(rset.getInt("UNO"));
					f.setPort(rset.getString("PORT"));
					f.setPoYn(rset.getString("PO_YN"));
					f.setPoModifyDate(rset.getDate("PO_MODIFY_DATE"));
					f.setPoModifyWriter(rset.getString("PO_MODIFY_WRITER"));
					
					
					

	         }
	         
	         
	      }catch(SQLException e) {
	         e.printStackTrace();
	      }finally {
	         close(rset);
	         close(pstmt);
	      }
	      System.out.println(portNo);
	      return f;
	   }
	/**
	 * 회원정보 수정
	 * @param con
	 * @param m 
	 * @param n
	 * @return
	 */
	public int updatePortfolio(Connection con, Portfolio f,Member m) {
	int result = 0;
	int result2 = 0;
	int result3 = 0;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt2 = null;
	
	
	try {
		String sql = prop.getProperty("updatePortfolio");
		
		pstmt = con.prepareStatement(sql);
		
		
		pstmt.setString(1, f.getPort());
		pstmt.setString(2, f.getPoYn().toUpperCase());
		pstmt.setDate(3, f.getPoModifyDate());
		pstmt.setString(4, f.getPoModifyWriter());
		pstmt.setInt(5, f.getPortNo());
		
		result = pstmt.executeUpdate();
		
		String sql2 = prop.getProperty("updateMemberPort");
		
		pstmt2 = con.prepareStatement(sql2);
		
		pstmt2.setString(1, m.getFileYN());
		pstmt2.setInt(2, m.getNo());
		
		result2 = pstmt2.executeUpdate();
		
		 result3 = result+result2;
		
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		close(pstmt);
		close(pstmt2);
	}
	System.out.println("포폴업뎃디에이오");
	System.out.println(result);

		return result3;
		
}

}
