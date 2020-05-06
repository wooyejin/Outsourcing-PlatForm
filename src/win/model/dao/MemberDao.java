package win.model.dao;


import static com.winwin.jsp.common.JDBCTemplate.close;
import static win.common.JDBCTemplate.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import win.exception.MemberException;
import win.model.vo.Member;

import win.model.dao.MemberDao;

public class MemberDao {

private Properties prop;
	
	public MemberDao() {
		prop = new Properties();
		
		String filePath = MemberDao.class.getResource("/config/member-query.properties").getPath();
		
		try {
			prop.load(new FileReader(filePath));
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 가입정보확인
	 * @param con
	 * @param m
	 * @return
	 * @throws MemberException
	 */
	public Member selectMember(Connection con, Member m)  {
		Member result = null; // 결과를 담을 객체
		PreparedStatement pstmt = null;
		ResultSet rset = null;	// Select의 결과를 담은 객체
		
		try {
			
			String sql ="";
			
			System.out.println(m.getMemberType());
			
			if(m.getMemberType().equals("D")) {
				sql = prop.getProperty("selectMember");
				
			
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, m.getUserId());
				pstmt.setString(2, m.getUserPwd());
			
				rset = pstmt.executeQuery();
			
			// if while
			if(rset.next()) {
				result = new Member();
				
				result.setNo(rset.getInt("UNO"));
				result.setName(rset.getString("UNAME"));
				result.setUserId(rset.getString("U_ID"));
				result.setUserPwd(rset.getString("U_PWD"));
				result.setEmail(rset.getString("U_EMAIL"));
			    result.setChangename(rset.getString("CHANGENAME"));
			    result.setBoardfile(rset.getString("D_PORT"));
			    result.setFileYN(rset.getString("FILEYN"));
			    result.setMemberType("D");
			    
			}
		}	else if(m.getMemberType().equals("C")) {
			sql = prop.getProperty("selectCompany");
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
		
			rset = pstmt.executeQuery();
			
			System.out.println("아디:"+m.getUserId());
			System.out.println("비번:" + m.getUserPwd());
		// if while
		if(rset.next()) {
		
			result = new Member();
			
			result.setNo(rset.getInt("CNO"));
			result.setName(rset.getString("CNAME"));
			result.setUserId(rset.getString("C_ID"));
			result.setUserPwd(rset.getString("C_PWD"));
			result.setEmail(rset.getString("C_EMAIL"));
			result.setCompanyId(rset.getString("C_BUS"));
			result.setChangename(rset.getString("C_CHANGENAME"));
			result.setBoardfile(rset.getString("C_PORT"));
			 result.setMemberType("C");
		
			}
		}
	}catch(SQLException e) {
			e.printStackTrace();
		
		}finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}

	
	/**
	 * 회원 가입 메소드 
	 * @param con
	 * @param m
	 * @return
	 * @throws MemberException 
	 */
	public int insertMember(Connection con, win.model.vo.Member m) throws MemberException {
		// 결과 확인을 위한 변수 result 생성
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			String sql ="";
			
			System.out.println(m.toString());
			
			if(m.getMemberType().equals("D")) {
				
				sql = prop.getProperty("insertMember");
				System.out.println("D");
				
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, m.getName());
				pstmt.setString(2, m.getUserId());
				pstmt.setString(3,m.getUserPwd());
				pstmt.setString(4,m.getEmail());
				
				result = pstmt.executeUpdate();
				
			} else if(m.getMemberType().equals("C")) {
				sql = prop.getProperty("insertCompany");
				
				System.out.println("C");
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, m.getName());
				pstmt.setString(2, m.getUserId());
				pstmt.setString(3,m.getUserPwd());
				pstmt.setString(4,m.getEmail());
				pstmt.setString(5,m.getCompanyId());
				
				result = pstmt.executeUpdate();
				
				System.out.println(result);
			}
		}catch(SQLException e) {
			throw new MemberException(e.getMessage());
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	public int updateMember(Connection con, Member m) throws MemberException {
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			String sql ="";
			
				if(m.getMemberType().equals("D")) {
				
				sql = prop.getProperty("updateMember");
				System.out.println("D");
				
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1,m.getEmail());
				pstmt.setString(2, m.getUserPwd());
				pstmt.setString(3,m.getUserId());
				
				result = pstmt.executeUpdate();
				
		}else if(m.getMemberType().equals("C")) {
			sql = prop.getProperty("updateCompany");
			
			System.out.println("C");
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,m.getEmail());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getUserId());
			result = pstmt.executeUpdate();
		}
		
		}catch(SQLException e) {
			throw new MemberException(e.getMessage());
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int updateViewMember(Connection con, Member m) throws MemberException {
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			String sql ="";
			
				if(m.getMemberType().equals("D")) {
				
				sql = prop.getProperty("updateMember2");
				System.out.println("D");
				
				pstmt = con.prepareStatement(sql);
				
				
				pstmt.setString(1,m.getUserId());
				
				result = pstmt.executeUpdate();
				
		}else if(m.getMemberType().equals("C")) {
			sql = prop.getProperty("updateCompany2");
			
			System.out.println("C");
			pstmt = con.prepareStatement(sql);
			
			
			pstmt.setString(1, m.getUserId());
			result = pstmt.executeUpdate();
		}
		
		}catch(SQLException e) {
			throw new MemberException(e.getMessage());
		}finally {
			close(pstmt);
		}
		return result;
	}
	public int updateProfileMember(Connection con, Member mem) throws MemberException {
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			String sql ="";
			
				if(mem.getMemberType().equals("D")) {
				
				sql = prop.getProperty("updateProfileMember");
				System.out.println("D");
				
				pstmt = con.prepareStatement(sql);
				
				
				pstmt.setString(1, mem.getChangename());
				pstmt.setString(2, mem.getFilepath());
				pstmt.setInt(3, mem.getNo());
				
				result = pstmt.executeUpdate();
				
		}else if(mem.getMemberType().equals("C")) {
			sql = prop.getProperty("updateProfileCompany");
			
			System.out.println("C");
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, mem.getChangename());
			pstmt.setString(2, mem.getFilepath());
			pstmt.setInt(3, mem.getNo());
			
			result = pstmt.executeUpdate();
			
		}
		
		}catch(SQLException e) {
			throw new MemberException(e.getMessage());
		}finally {
			close(pstmt);
		}
		return result;
	}
	public int idDupCheck(Connection con, String id) {
		int result = -1;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("idDupCheck");
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				// -1 : 에러!
				// 0 : id중복 사용자 없음
				// 1 : id를 누군가 이미 사용 중임
				result = rset.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}
	public int idDupCheck2(Connection con, String id) {
		int result = -1;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("idDupCheck2");
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				// -1 : 에러!
				// 0 : id중복 사용자 없음
				// 1 : id를 누군가 이미 사용 중임
				result = rset.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}
	public int updatePortMember(Connection con, Member mem) throws MemberException {
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			String sql ="";
			
				if(mem.getMemberType().equals("D")) {
				
				sql = prop.getProperty("updatePortMember");
				System.out.println("D");
				
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1,mem.getBoardfile());
				pstmt.setInt(2, mem.getNo());
				
				result = pstmt.executeUpdate();
				
		}else if(mem.getMemberType().equals("C")) {
			sql = prop.getProperty("updatePortCompany");
			
			System.out.println("C");
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,mem.getBoardfile());
			pstmt.setInt(2, mem.getNo());
			
			result = pstmt.executeUpdate();
			
		}
		
		}catch(SQLException e) {
			throw new MemberException(e.getMessage());
		}finally {
			close(pstmt);
		}
		return result;
	
	}
	
	/**
	    * 아이디 찾기
	    * @param con
	    * @param m
	    * @throws MemberException
	    */
	   public Member findId(Connection con, String userId,String email) throws MemberException {
	      Member result = null; // 결과를 담을 객체
	      PreparedStatement pstmt = null;
	      PreparedStatement pstmt2 = null;
	      ResultSet rset = null; // find 의 결과를 담은 객체 
	      ResultSet rset2 = null;
	      
	      String id="";
	      
	      try {
	         String sql = prop.getProperty("findId");
	   
	         pstmt = con.prepareStatement(sql);
	         pstmt.setString(1, userId);
	         pstmt.setString(2, email);
	         
	         rset = pstmt.executeQuery();
	         
	         
	         if(rset.next()) {
	            id=rset.getString("u_id");
	         }
	         if(id == null) {
	         
	         String sql2 = prop.getProperty("findId2");
	         System.out.println(sql2);
	         pstmt2 = con.prepareStatement(sql2);
	         pstmt2.setString(1, userId);
	         pstmt2.setString(2, email);
	         
	         rset2 = pstmt2.executeQuery();
	         
	         
	         if(rset2.next()) {
	            id=rset2.getString("c_id");
	         }
	         }

	         result = new Member();
	         result.setUserId(id);
	         
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }finally {
	         close(rset);
	         close(rset2);
	         close(pstmt);
	         close(pstmt2);
	      }
	      
	      return result;
	   }
	   /**
	    * 비밀번호 변경
	    * @param con
	    * @param m
	    * @throws MemberException
	    */

	   public int updatePwd(Connection con, Member m) throws MemberException {
		   int result = 0;
//	      int temp = 0;
//	      int temp2 = 0;
	      
	      PreparedStatement pstmt = null;
	      
	      try {
	         
	          
	         String sql = prop.getProperty("updatePwd");
	         
	         pstmt = con.prepareStatement(sql);
	         
	         System.out.println("DAO updateEmail : " + m.getEmail());
	         System.out.println("DAO updatePwd : " + m.getUserPwd());
	         
	         pstmt.setString(1,m.getUserPwd());
	         pstmt.setString(2, m.getEmail());
	         
	         System.out.println(sql);
	         
	         result = pstmt.executeUpdate();
	         
	      }catch(SQLException e) {
	         e.printStackTrace();
	      }finally {
	         close(pstmt);
	      }
	      if(result>0) {
	         return result;
	      }
	      
	      PreparedStatement pstmt2 = null;
	      try {
	      
	         ///////////////////////////////////////////
	         
	         
	         String sql2 = prop.getProperty("updatePwd2");
	         
	         
	         pstmt2 = con.prepareStatement(sql2);
	         
	         System.out.println("DAO updateEmail : " + m.getEmail());
	         System.out.println("DAO updatePwd : " + m.getUserPwd());
	         
	         pstmt2.setString(1,m.getUserPwd());
	         pstmt2.setString(2, m.getEmail());
	         
	         
	         result = pstmt2.executeUpdate();
	         
//	         System.out.println(temp+" / "+temp2);
	         
	         
	      }catch(SQLException e) {
	         e.printStackTrace();
	      }finally {
	         close(pstmt2);
	      }
	      
	      return result;
	   }
	   
	   /**
	    * 비밀번호 찾기
	    * @param con
	    * @param m
	    * @throws MemberException
	    */


	   public Member findPwd(Connection con, Member m) throws MemberException{
	      Member result = null; // 결과를 담을 객체
	      PreparedStatement pstmt = null;
	      PreparedStatement pstmt2 = null;
	      ResultSet rset = null; // find 의 결과를 담은 객체 
	      ResultSet rset2 = null;
	      
	      try {
	         String sql = prop.getProperty("findId");
	         
	         pstmt = con.prepareStatement(sql);
	         pstmt.setString(1, m.getName());
	         pstmt.setString(2, m.getEmail());
	         
	         rset = pstmt.executeQuery();
	         
	         if(rset.next()) {
	            result = new Member();
	            result.setUserId(rset.getString("u_id"));
	            result.setUserPwd(rset.getString("U_PWD"));
	            result.setName(rset.getString("UNAME"));
	            result.setEmail(rset.getString("U_EMAIL"));
	         }
	      
	         String sql2 = prop.getProperty("findId2");
	         
	         pstmt2 = con.prepareStatement(sql2);
	         pstmt2.setString(1, m.getName());
	         pstmt2.setString(2, m.getEmail());
	         
	         rset2 = pstmt2.executeQuery();
	         
	         
	         if(rset2.next()) {
	            result = new Member();
	            result.setUserId(rset2.getString("c_id"));
	            result.setUserPwd(rset2.getString("C_PWD"));
	            result.setName(rset2.getString("CNAME"));
	            result.setEmail(rset2.getString("C_EMAIL"));
	         }


	      
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }finally {
	         close(rset);
	         close(rset2);
	         close(pstmt);
	         close(pstmt2);
	      }
	      
	      return result;
	   }
	public int insertMemberPort(Connection con, Member mem) {

		PreparedStatement pstmt = null;
		
		int result = 0;
		String sql = prop.getProperty("insertPortfolio");
		
		try {

			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, mem.getNo());
			pstmt.setInt(2, mem.getNo());
	
			
			result=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			
		}
				
		return result;
	}
	public int updatePortMember2(Connection con, Member mem) {
		PreparedStatement pstmt = null;
		int result2 = 0;
		
		String sql =prop.getProperty("updateMemberfolio");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, mem.getBoardfile());
			pstmt.setInt(2, mem.getNo());
			
			result2 = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result2;
	}
	public Member selectMember2(Connection con, String selnumber, String seltype) {

		Member  result = new Member();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMember2");		
		
		try {

			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, selnumber);

			rset = pstmt.executeQuery();
			
				
				if(rset.next()) {
					result = new Member();
					
					result.setNo(rset.getInt("UNO"));
					result.setName(rset.getString("UNAME"));
					result.setUserId(rset.getString("U_ID"));
					result.setUserPwd(rset.getString("U_PWD"));
					result.setEmail(rset.getString("U_EMAIL"));
				    result.setChangename(rset.getString("CHANGENAME"));
				    result.setBoardfile(rset.getString("D_PORT"));
				    result.setFileYN(rset.getString("FILEYN"));
				}
			
			rset = pstmt.executeQuery();
			
		} catch (SQLException e) {	
		  e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}
	public int insertApp(Connection con, int pno, int uno) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String sql =prop.getProperty("insertApp");
		
		try {
		
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, pno);
			pstmt.setInt(2, uno);
			
			result = pstmt.executeUpdate();
		
		
		
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			close(pstmt);
		}
		return result;
	
	}
	public ArrayList<Member> updateCompany(Connection con, Member m) {
		
		ArrayList<Member> ulist = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectUlist");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, m.getNo());
			
			
			rset = pstmt.executeQuery();
			ulist = new ArrayList<Member>();
			while(rset.next()) {
				
				Member mem = new Member();
				
				mem.setUserId(rset.getString(3));
				mem.setTitle(rset.getString(22));
				mem.setNo(rset.getInt(1));
				ulist.add(mem);
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		return ulist;
	}
}




