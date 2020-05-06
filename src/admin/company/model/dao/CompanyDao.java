package admin.company.model.dao;

import static admin.member.common.JDBCTemplate.close;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import admin.company.model.vo.Company;
import admin.member.model.vo.Member;

public class CompanyDao {

	private Properties prop;
	
	public CompanyDao() {
		prop = new Properties();
		
		String filePath = CompanyDao.class.getResource("/config/Company_query.properties").getPath();
		
		try {
			prop.load(new FileReader(filePath));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Company> selectList(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Company> clist = null;
		
		String sql = prop.getProperty("readCompany");
		try {
			
			pstmt = con.prepareStatement(sql);
			rset=pstmt.executeQuery();
			
			clist = new ArrayList<Company>();
			
			while(rset.next()) {
				Company c = new Company();
				
				c.setcNo(rset.getInt("CNO"));
				c.setpNo(rset.getInt("C_PNO"));
				c.setcName(rset.getString("CNAME"));
				c.setcId(rset.getString("C_ID"));
				c.setcPwd(rset.getString("C_PWD"));
				c.setcEmail(rset.getString("C_EMAIL"));
				c.setcPhone(rset.getString("C_PHONE"));
				c.setcIntro(rset.getString("C_INTRO"));
				c.setcBus(rset.getString("C_BUS"));
				c.setcRegDate(rset.getDate("C_REG_DATE"));
				c.setcYn(rset.getString("C_YN"));
				c.setcModifyDate(rset.getDate("C_MODIFY_DATE"));
				c.setcModifyWriter(rset.getString("C_MODIFY_WRITER"));
				c.setcProof(rset.getString("C_PROOF"));
				c.setcChangeName(rset.getString("C_CHANGENAME"));
				c.setcFilePath(rset.getString("C_FILEPATH"));
				c.setcPort(rset.getString("C_PORT"));
				
				clist.add(c);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return clist;
	}
	
	public int insertCcount(Connection con) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		try {
				String sql = prop.getProperty("updateCcount");
				
				pstmt = con.prepareStatement(sql);
				
				
				
				result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
		
	}
	
	public Company selectOne(Connection con, int cNo) {
		Company c  = null;
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      
	      String sql = prop.getProperty("selectOne");
	      try {
	         pstmt = con.prepareStatement(sql);
	         
	         pstmt.setInt(1, cNo);
	         
	         
	         // INSERT, UPDATE, DELETE : executeUpdate();
	         // SELECT : executeQuery();
	         rset = pstmt.executeQuery();
	                  
	         // if, while
	         if(rset.next()) {
	        	 c = new Company();
	        	 
					c.setcNo(cNo);
					c.setpNo(rset.getInt("C_PNO"));
					c.setcName(rset.getString("CNAME"));
					c.setcId(rset.getString("C_ID"));
					c.setcPwd(rset.getString("C_PWD"));
					c.setcEmail(rset.getString("C_EMAIL"));
					c.setcPhone(rset.getString("C_PHONE"));
					c.setcIntro(rset.getString("C_INTRO"));
					c.setcBus(rset.getString("C_BUS"));
					c.setcRegDate(rset.getDate("C_REG_DATE"));
					c.setcModifyDate(rset.getDate("C_MODIFY_DATE"));
					c.setcModifyWriter(rset.getString("C_MODIFY_WRITER"));
					c.setcYn(rset.getString("C_YN"));
					c.setcProof(rset.getString("C_PROOF"));
					
					

	         }
	         
	         
	      }catch(SQLException e) {
	         e.printStackTrace();
	      }finally {
	         close(rset);
	         close(pstmt);
	      }
	      return c;
	   }
	/**
	 * 회원정보 수정
	 * @param con
	 * @param n
	 * @return
	 */
	public int updateCompany(Connection con, Company c) {
	int result = 0;
	
	PreparedStatement pstmt = null;
	
	
	try {
		String sql = prop.getProperty("updateCompany");
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, c.getcName());
		pstmt.setString(2, c.getcId());
		pstmt.setString(3, c.getcPwd());
		pstmt.setString(6, c.getcEmail());
		pstmt.setString(7, c.getcPhone());
		pstmt.setString(4, c.getcIntro());
		pstmt.setString(5, c.getcBus());
		pstmt.setDate(8, c.getcModifyDate());
		pstmt.setString(9, c.getcModifyWriter());
		pstmt.setString(10, c.getcYn().toUpperCase());
		pstmt.setString(11, c.getcProof().toUpperCase());
		pstmt.setInt(12, c.getpNo());
		pstmt.setInt(13, c.getcNo());
		
		result = pstmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		close(pstmt);
	}
		return result;
		
}

}
