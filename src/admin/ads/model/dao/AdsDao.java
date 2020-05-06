package admin.ads.model.dao;

import static admin.member.common.JDBCTemplate.close;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import admin.ads.model.vo.Ads;
import admin.ads.model.vo.Asset;

public class AdsDao {
	
	private Properties prop;
	
	

	public AdsDao() {
		prop = new Properties();
		
		String filePath = AdsDao.class.getResource("/config/Ads_query.properties").getPath();
		
		try {
			prop.load(new FileReader(filePath));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Ads> selectList(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Ads> alist = null;
		
		String sql = prop.getProperty("readAds");
		try {
			
			pstmt = con.prepareStatement(sql);
			rset=pstmt.executeQuery();
			
			alist = new ArrayList<Ads>();
			
			while(rset.next()) {
				Ads a = new Ads();
				
				a.setcNo(rset.getInt("CNO"));
				a.setpNo(rset.getInt("PNO"));
				a.setAdsStart(rset.getDate("ADS_START"));
				a.setAdsEnd(rset.getDate("ADS_END"));
				a.setAdsPrice(rset.getInt("ADS_PRICE"));
				a.setAdsModifyDate(rset.getDate("ADS_MODIFY_DATE"));
				a.setAdsModifyWriter(rset.getString("ADS_MODIFY_WRITER"));
				
				alist.add(a);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return alist;
	}
	
	public int insertAcount(Connection con) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		try {
				String sql = prop.getProperty("updateAcount");
				
				pstmt = con.prepareStatement(sql);
				
				
				
				result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
		
	}
	
	public Ads selectOne(Connection con, int cNo) {
		Ads a  = null;
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      
	      String sql = prop.getProperty("selectOne");
	      try {
	         pstmt = con.prepareStatement(sql);
	         
	         pstmt.setInt(1, cNo);
	         
	         
	         rset = pstmt.executeQuery();
	                  
	         // if, while
	         if(rset.next()) {
	        	 a = new Ads();
	        	 
					a.setcNo(cNo);
					a.setpNo(rset.getInt("PNO"));
					a.setAdsStart(rset.getDate("ADS_START"));
					a.setAdsEnd(rset.getDate("ADS_END"));
					a.setAdsPrice(rset.getInt("ADS_PRICE"));
					a.setAdsModifyDate(rset.getDate("ADS_MODIFY_DATE"));
					a.setAdsModifyWriter(rset.getString("ADS_MODIFY_WRITER"));
					
					

	         }
	         
	         
	      }catch(SQLException e) {
	         e.printStackTrace();
	      }finally {
	         close(rset);
	         close(pstmt);
	      }
	      return a;
	   }
	/**
	 * 회원정보 수정
	 * @param con
	 * @param n
	 * @return
	 */
	public int updateAds(Connection con, Ads a) {
	int result = 0;
	
	PreparedStatement pstmt = null;
	
	
	try {
		String sql = prop.getProperty("updateAds");
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, a.getpNo());
		pstmt.setDate(2, a.getAdsStart());
		pstmt.setDate(3, a.getAdsEnd());
		pstmt.setInt(4, a.getAdsPrice());
		pstmt.setDate(5, a.getAdsModifyDate());
		pstmt.setString(6, a.getAdsModifyWriter());
		pstmt.setInt(7, a.getcNo());
		
		result = pstmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		close(pstmt);
	}
		return result;
		
}
	public int insertAds(Connection con, Ads a) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		
		try {
			String sql = prop.getProperty("insertAds");
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, a.getcNo());
			pstmt.setInt(2, a.getpNo());
			pstmt.setDate(3, a.getAdsStart());
			pstmt.setDate(4, a.getAdsEnd());
			pstmt.setInt(5, a.getAdsPrice());
			pstmt.setString(6, a.getAdsModifyWriter());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
			return result;
			
	}

	public ArrayList<Asset> selectAs(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Asset> aslist = null;
		int total=0;
		int adsTotal=0;
		int RevenueTotal=0;
		
		String sql = prop.getProperty("readAs");
		try {
			
			pstmt = con.prepareStatement(sql);
			rset=pstmt.executeQuery();
			
			aslist = new ArrayList<Asset>();
			while(rset.next()) {
				Asset as = new Asset();
				
				as.setCount(rset.getInt("COUNT"));
				as.setcNo(rset.getInt("CNO"));
				as.setcName(rset.getString("CNAME"));
				as.setpNo(rset.getInt("PNO"));
				as.setpCost(rset.getInt("P_COST"));
				as.setAssetRevenue((int)(rset.getInt("P_COST")*0.05));
				as.setAssetAdsRevenue(rset.getInt("ADS_PRICE"));
				total+=(rset.getInt("P_COST"));
				RevenueTotal+=((int)(rset.getInt("P_COST")*0.05));
				adsTotal+=(rset.getInt("ADS_PRICE"));
					as.setAssetTotal(total);
					as.setAssetAdsTotal(adsTotal);
					as.setAssetRevenueTotal(RevenueTotal);
				as.setAssetUpdateDate(rset.getDate("ASSET_UPDATE_DATE"));
				
				
				aslist.add(as);
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		System.out.println("aslist");
		return aslist;
		}

}
