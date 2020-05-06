package win.model.service;



import static com.winwin.jsp.common.JDBCTemplate.close;
import static com.winwin.jsp.common.JDBCTemplate.commit;
import static com.winwin.jsp.common.JDBCTemplate.getConnection;
import static com.winwin.jsp.common.JDBCTemplate.rollback;
import static win.common.JDBCTemplate.*;


import java.sql.Connection;
import java.util.ArrayList;

import win.exception.MemberException;
import win.model.vo.Member;

import win.model.dao.MemberDao;

public class MemberService {
	
	private Connection con;
	private MemberDao mDao = new MemberDao();
	
	/**
	 * 가입 정보 확인
	 * @param m
	 * @return
	 * @throws MemberException
	 */
	
	public Member selectMember(Member m) {
		con = getConnection();
		
		Member result = mDao.selectMember(con,m);
		
		close(con);
		
		/*
		 * if(result == null) { throw new MemberException("회원 아이디나 비밀번호가 올바르지 않습니다."); }
		 */
		return result;
	}
	
	/**
	 * 회원 가입
	 * @param m
	 * @return
	 * @throws MemberException 
	 */
	public int insertMember(Member m) throws MemberException {
		con = getConnection();
		int result = mDao.insertMember(con,m);
		
		if(result >0 ) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	public int updateMember(Member m) throws MemberException{
		con = getConnection();
		int result = mDao.updateMember(con,m);
		
		if(result >0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
		
	}

	public int updateViewMember(Member m) throws MemberException {
		con = getConnection();
		int result = mDao.updateViewMember(con,m);
		
		if(result >0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
		
	}

	public int updateProfileMember(Member mem) throws MemberException {

		con = getConnection();
		int result = mDao.updateProfileMember(con,mem);
		
		if(result >0) commit(con);
		else rollback(con);
		
		
		
		
		close(con);
		
		return result;
		
		
		
	}

	public int idDupCheck(String id) {
		Connection con = getConnection();
		
		int result = mDao.idDupCheck(con,id);
		int result2 = mDao.idDupCheck2(con, id);
		close(con);
		
		int result3 = result + result2;
		
		return result3;
		
	}

	public int insertPorto(Member mem) throws MemberException {
		con = getConnection();
		int result = mDao.updatePortMember(con,mem);
		
		if(result >0) commit(con);
		else rollback(con);
		
		
		int result2 = mDao.updatePortMember2(con,mem);
		
		if(result2>0) commit(con);
		else rollback(con);
		
		
		close(con);
		
		return result;
	}
	
	/**
	    * 아이디 찾기
	    * @param m
	    * @return
	    * @throws MemberException
	    */
	   public Member findId(String userId, String email) throws MemberException{
	      con = getConnection();
	      
	      Member result = mDao.findId(con,userId,email);
	      
	      
	      close(con);
	      
	      if(result == null) {
	         throw new MemberException("존재하지 않는 회원입니다");
	      }
	      
	      return result;
	   }
	
	   /**
	    * 비밀번호 변경
	    * @param m
	    * @return
	    * @throws MemberException
	    */

	   public int updatePwd(Member m) throws MemberException{
	      con = getConnection();
	      int result = mDao.updatePwd(con,m);
	      
	      if(result > 0) commit(con);
	      else rollback(con);
	      
	      close(con);
	      
	      return result;
	   }
	   /**
	    * 비밀번호 찾기
	    * @param m
	    * @return
	    * @throws MemberException
	    */
	   
	   public Member findPwd(Member m)throws MemberException{
	      con = getConnection();
	      
	      Member result = mDao.findPwd(con,m);
	      
	      close(con);
	      
	      if(result == null) {
	         throw new MemberException("존재하지 않는 회원입니다");
	      }
	      
	      return result;
	   }

	public void insertMemberPort(Member m) {

		Connection con = getConnection();
		
		
		
		int result2 = mDao.insertMemberPort(con,m);
		
		if(result2 > 0) commit(con);
		else rollback(con);
		
		close(con);
	}

	public Member selectMember2(String selnumber, String seltype) {

		Connection con = getConnection();
		
		Member m = mDao.selectMember2(con, selnumber,seltype);
	
		close(con);
		
		
		return m;
	}

	public int insertApp(int uno, int pno) {
		
		Connection con  = getConnection();
		
		int result = mDao.insertApp(con,pno,uno);
		
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public ArrayList<Member> updateCompany(Member m) {
		Connection con = getConnection();
		
		ArrayList<Member> ulist = mDao.updateCompany(con,m);
		 
		close(con);
		
		return ulist;
	}
}
