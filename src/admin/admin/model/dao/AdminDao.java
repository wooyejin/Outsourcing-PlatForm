package admin.admin.model.dao;

import static admin.member.common.JDBCTemplate.close;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import admin.admin.model.vo.Admin;
import admin.ads.model.vo.Ads;

public class AdminDao {

	private Properties prop;
	
	
	public AdminDao() {
		prop = new Properties();
		
		String filePath = AdminDao.class.getResource("/config/Admin_query.properties").getPath();
		
		try {
			prop.load(new FileReader(filePath));
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public ArrayList<Admin> selectList(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Admin> adlist = null;
		
		String sql = prop.getProperty("readAdmin");
		try {
			
			pstmt = con.prepareStatement(sql);
			rset=pstmt.executeQuery();
			
			adlist = new ArrayList<Admin>();
			
			while(rset.next()) {
				Admin ad = new Admin();
				
				ad.setcCount(rset.getInt("C_COUNT"));
				ad.setaCount(rset.getInt("A_COUNT"));
				ad.setuCount(rset.getInt("U_COUNT"));
				ad.seteCount(rset.getInt("E_COUNT"));
				ad.setCcCount(rset.getInt("CC_COUNT"));
				ad.setAaCount(rset.getInt("AA_COUNT"));
				ad.setUuCount(rset.getInt("UU_COUNT"));
				ad.setEeCount(rset.getInt("EE_COUNT"));
				
				ad.setaMemo(rset.getString("A_MEMO"));
				
				adlist.add(ad);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return adlist;
	}
	
	public int updateAdmin(Connection con, Admin ad) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		
		try {
			String sql = prop.getProperty("updateAdmin");
			
			pstmt = con.prepareStatement(sql);
		
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
			return result;
			
	}
	
	public int insertAdmin(Connection con,String aMemo) {
		int result = 0;
		PreparedStatement pstmt = null;
	      
	      String sql = prop.getProperty("insertAdmin");
		try {
				
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, aMemo);
		         
				
				result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
		
	}
}
