package win.board.model.dao;


import static win.common.JDBCTemplate.*;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.sun.corba.se.spi.orbutil.fsm.State;

import win.board.model.dao.BoardDao;
import win.board.model.vo.Board;
import win.board.model.vo.Career;
import win.board.model.vo.Introduce;
import win.board.model.vo.Skill;

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
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
		return listCount;
	}

	public int insertBoard(Connection con, Introduce i,String name,String no) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		
		try {
			
			String sql = "";
			
			if(name.equals("D")) {
				sql = prop.getProperty("D_Introduce");
				
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1,no);
				pstmt.setString(2, i.getIn_title());
				pstmt.setString(3, i.getIn_content());
				
				result = pstmt.executeUpdate();
			} else if(name.equals("C")) {
				sql = prop.getProperty("C_Introduce");
				
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1,no);
				pstmt.setString(2, i.getIn_title());
				pstmt.setString(3, i.getIn_content());
				
				result = pstmt.executeUpdate();
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public Introduce selectList(Connection con, String type2, String number) {
		
		Introduce in = null; 
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		try {
			String sql=""; 
			
			if(type2.equals("D")) {
				sql = prop.getProperty("selectMember");
				
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1,number);
				
				rset=pstmt.executeQuery();
				
				if(rset.next()) {
					in = new Introduce();
					
					in.setIn_title(rset.getString("IN_TITLE"));
					in.setIn_content(rset.getString("IN_CONTENT"));
					
				}
			} else if(type2.equals("C")) {
				sql = prop.getProperty("selectCompany");
				
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1,number);
				

				rset=pstmt.executeQuery();
				
				if(rset.next()) {
					in = new Introduce();
					
					in.setIn_title(rset.getString("CN_TITLE"));
					in.setIn_content(rset.getString("CN_CONTENT"));
					
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return in;
	}


	public int insertSkill(Connection con, ArrayList<Skill> slist, String name) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			
			String sql = "";
			
			if(name.equals("D")) {
			
			for(Skill s : slist)	{
				sql = prop.getProperty("D_Skill");
				
				pstmt = con.prepareStatement(sql);
				
				pstmt.setInt(1,s.getNo());
				pstmt.setString(2,s.getS_name());
				pstmt.setString(3,s.getS_lev());
				pstmt.setString(4,s.getS_ex());
				
				result = pstmt.executeUpdate();
			
			}	
				
			} else if(name.equals("C")) {
				
				for(Skill s : slist)	{
				sql = prop.getProperty("C_Skill");
				
				pstmt = con.prepareStatement(sql);
				
				pstmt.setInt(1,s.getNo());
				pstmt.setString(2,s.getS_name());
				pstmt.setString(3,s.getS_lev());
				pstmt.setString(4,s.getS_ex());
				
				result = pstmt.executeUpdate();
				}
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<Skill> selectSkill(Connection con, String type2, String name) {
		

		ArrayList<Skill> list = null; 
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		try {
			String sql=""; 
			
			if(type2.equals("D")) {
				sql = prop.getProperty("selectMemberSkill");
				
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, name);
				
				list = new ArrayList<Skill>();
				
				rset=pstmt.executeQuery();
				
				while(rset.next()) {
					Skill s = new Skill();
					
					s.setNo(rset.getInt("UNO"));
					s.setS_name(rset.getString("S_NAME"));
					s.setS_lev(rset.getString("S_LEV"));
					s.setS_ex(rset.getString("S_EX"));
					
					
					list.add(s);
				}
			} else if(type2.equals("C")) {
				sql = prop.getProperty("selectCompanySkill");
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, name);
				
				rset=pstmt.executeQuery();
				
				while(rset.next()) {
					Skill s = new Skill();
					
					s.setNo(rset.getInt("CNO"));
					s.setS_name(rset.getString("C_NAME"));
					s.setS_lev(rset.getString("C_LEV"));
					s.setS_ex(rset.getString("C_EX"));
					
					
					list.add(s);
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return list;
	}

	public int insertCareer(Connection con, ArrayList<Career> clist, String name) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			
			String sql = "";
			
			if(name.equals("D")) {
			
			for(Career c : clist)	{
				sql = prop.getProperty("D_Career");
				
				pstmt = con.prepareStatement(sql);
				
				pstmt.setInt(1,c.getNo());
				pstmt.setString(2,c.getCa_name());
				pstmt.setString(3,c.getCa_work());
				pstmt.setString(4,c.getCa_rank());
				pstmt.setString(5, c.getCa_exper());
				pstmt.setString(6,c.getStatus());
				
				result = pstmt.executeUpdate();
			
			}	
				
			} else if(name.equals("C")) {
				
				for(Career c : clist)	{
				sql = prop.getProperty("C_Career");
				
				pstmt = con.prepareStatement(sql);
				
				pstmt.setInt(1,c.getNo());
				pstmt.setString(2,c.getCa_name());
				pstmt.setString(3,c.getCa_work());
				pstmt.setString(4,c.getCa_rank());
				pstmt.setString(5, c.getCa_exper());
				pstmt.setString(6,c.getStatus());
				
				result = pstmt.executeUpdate();
				}
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<Career> selectCareer(Connection con, String type2, String number) {
		
		ArrayList<Career> list = null; 
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		try {
			String sql=""; 
			
			if(type2.equals("D")) {
				sql = prop.getProperty("selectMemberCareer");
				
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, number);
				
				list = new ArrayList<Career>();
				
				rset=pstmt.executeQuery();
				
				while(rset.next()) {
					Career c = new Career();
				
					
					c.setNo(rset.getInt("UNO"));
					c.setCa_name(rset.getString("D_NAME"));
					c.setCa_work(rset.getString("D_WORK"));
					c.setCa_rank(rset.getString("D_RANK"));
					c.setCa_exper(rset.getString("D_EXPER"));
					c.setStatus(rset.getString("D_STATUS"));
					
					list.add(c);
				}
			} else if(type2.equals("C")) {
				sql = prop.getProperty("selectCompanyCareer");
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, number);
				
				rset=pstmt.executeQuery();
				
				while(rset.next()) {
					Career c = new Career();
					
					c.setNo(rset.getInt("CNO"));
					c.setCa_name(rset.getString("C_NAME"));
					c.setCa_work(rset.getString("C_WORK"));
					c.setCa_rank(rset.getString("C_RANK"));
					c.setCa_exper(rset.getString("C_EXPER"));
					c.setStatus(rset.getString("C_STATUS"));
					
					
					list.add(c);
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return list;
	}
	
	
	

	/**
	 * @param con
	 * @param no 
	 * @return
	 * @작성자 : 문태환
	 * @내용  : SKILL 전체삭제
	 */
	public int deleteskill(Connection con, int no) {

		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String sql = prop.getProperty("deleteSkill");
		
		try {
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		
		return result;
	}

	/**
	 * @param title
	 * @param work
	 * @param ex
	 * @param con
	 * @return
	 * @작성자 : 문태환
	 * @내용  : 스킬선택 삭제
	 */
	public int deleteOneSkill(String title, String work, String ex, Connection con) {
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteOneSKill");
		
		int result = 0;
		
			try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, title);
			pstmt.setString(2, work);
			
			result = pstmt.executeUpdate();
			
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
		
		
		return result;
	}

	public int deleteCareer(Connection con, int no) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String sql = prop.getProperty("deleteCareer");
		
		try {

			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		
		return result;
	}

	public int deleteBoard(Connection con, String name, String no) {

		PreparedStatement pstmt =null;
		
		int result = 0;
		
		String sql = "";
		
		try {
			
			if(name.equals("D")) {
				sql = prop.getProperty("deleteBoardD");
				
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, no);
				
				result = pstmt.executeUpdate();
				
				
			} else if(name.equals("C")) {
				sql = prop.getProperty("deleteBoardC");
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, no);
				

				result = pstmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			
		}
		
		
		return result;
	}

	public ArrayList<Skill> selectAllList(Connection con) {

		Statement stmt = null;
		
		ResultSet rset= null;
		
		ArrayList<Skill> slist = null;
		
		String sql = prop.getProperty("selectAllSkill");
		
		try {
		
			stmt=con.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			slist = new ArrayList<Skill>();
			
			while(rset.next()) {
				Skill s = new Skill();
				
				s.setNo(rset.getInt("UNO"));
				s.setS_name(rset.getString("S_NAME"));
				s.setS_lev(rset.getString("S_LEV"));
				s.setS_ex(rset.getString("S_EX"));
				
				
				slist.add(s);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
			
		}
		
		
		return slist;
	}
	
}
