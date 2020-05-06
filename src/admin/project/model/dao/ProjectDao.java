package admin.project.model.dao;

import static admin.member.common.JDBCTemplate.close;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import admin.member.model.vo.Member;
import admin.project.model.vo.Project;

public class ProjectDao {

	private Properties prop;

	public ProjectDao() {
		prop = new Properties();

		String filePath = ProjectDao.class.getResource("/config/Project_query.properties").getPath();

		try {
			prop.load(new FileReader(filePath));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Project> selectList(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Project> plist = null;

		String sql = prop.getProperty("readProject");
		try {

			pstmt = con.prepareStatement(sql);
			rset = pstmt.executeQuery();

			plist = new ArrayList<Project>();

			while (rset.next()) {
				Project p = new Project();

				p.setpNo(rset.getInt("PNO"));
				p.setpEnro(rset.getDate("P_ENRO"));
				p.setStatus(rset.getString("P_STATUS"));
				p.setpAdsYn(rset.getString("P_ADS_YN"));
				p.setpTitle(rset.getString("P_TITLE"));
				p.setpBang(rset.getString("P_BANG"));
				p.setpType(rset.getString("P_TYPE"));
				p.setpDetail(rset.getString("P_DETAIL"));
				p.setpCotx(rset.getString("P_COTX"));
				p.setpCost(rset.getInt("P_COST"));
				p.setpStart(rset.getDate("P_START"));
				p.setpEnd(rset.getDate("P_END"));
				p.setpModifyDate(rset.getDate("P_MODIFY_DATE"));
				p.setpModifyWriter(rset.getString("P_MODIFY_WRITER"));
				p.setcNo(rset.getInt("CNO"));
				p.setpGo(rset.getString("P_GO"));

				plist.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return plist;
	}

	public Project selectOne(Connection con, int pNo) {
		Project p = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("selectOne");
		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, pNo);

			// INSERT, UPDATE, DELETE : executeUpdate();
			// SELECT : executeQuery();
			rset = pstmt.executeQuery();

			// if, while
			if (rset.next()) {
				p = new Project();

				p.setpNo(pNo);
				p.setpEnro(rset.getDate("P_ENRO"));
				p.setpTitle(rset.getString("P_TITLE"));
				p.setStatus(rset.getString("P_STATUS"));
				p.setpAdsYn(rset.getString("P_ADS_YN"));
				p.setpBang(rset.getString("P_BANG"));
				p.setpType(rset.getString("P_TYPE"));
				p.setpDetail(rset.getString("P_DETAIL"));
				p.setpCotx(rset.getString("P_COTX"));
				p.setpCost(rset.getInt("P_COST"));
				p.setpStart(rset.getDate("P_START"));
				p.setpEnd(rset.getDate("P_END"));
				p.setpModifyDate(rset.getDate("P_MODIFY_DATE"));
				p.setpModifyWriter(rset.getString("P_MODIFY_WRITER"));
				p.setcNo(rset.getInt("CNO"));
				p.setpGo(rset.getString("P_GO"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return p;
	}

	/**
	 * 회원정보 수정
	 * 
	 * @param con
	 * @param n
	 * @return
	 */
	public int updateProject(Connection con, Project p) {
		int result = 0;

		PreparedStatement pstmt = null;

		try {
			String sql = prop.getProperty("updateProject");

			pstmt = con.prepareStatement(sql);

			pstmt.setDate(1, p.getpEnro());
			pstmt.setString(2, p.getpTitle());
			pstmt.setString(3, p.getpBang());
			pstmt.setString(4, p.getpType());
			pstmt.setString(5, p.getpDetail());
			pstmt.setString(6, p.getpCotx());
			pstmt.setInt(7, p.getpCost());
			pstmt.setDate(8, p.getpStart());
			pstmt.setDate(9, p.getpEnd());
			pstmt.setString(10, p.getpGo());
			pstmt.setDate(11, p.getpModifyDate());
			pstmt.setString(12, p.getpModifyWriter());
			pstmt.setInt(13, p.getcNo());
			pstmt.setString(14, p.getStatus().toUpperCase());
			pstmt.setString(15, p.getpAdsYn().toUpperCase());
			pstmt.setInt(16, p.getpNo());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int insultAsset(Connection con, Project p) {
		int result = 0;

		PreparedStatement pstmt = null;

		try {
			if (p.getStatus().equals("Y")) {
				String sql = prop.getProperty("insertAs");

				pstmt = con.prepareStatement(sql);

				System.out.println("트리거기능??");


				pstmt.setInt(1, p.getcNo());
				pstmt.setInt(2, p.getpNo());
				result = pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;

	}
	

}
