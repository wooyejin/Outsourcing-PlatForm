package admin.member.model.service;

import static admin.member.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import admin.member.model.dao.MemberDao;
import admin.member.model.vo.Member;

public class MemberService {

	private MemberDao mDao = new MemberDao();
	
	public ArrayList<Member> readMember() {
		Connection con = getConnection();
		
		ArrayList<Member> mlist = mDao.selectList(con);
		
		close(con);
		return mlist;
	}
	
	public int updateMember(Member m) {
		Connection con = getConnection();

		int result = mDao.updateMember(con,m);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		return result;
	}
	
	public int insertUcount() {
		Connection con = getConnection();
		int result = 0;
		
		
		result = mDao.insertUcount(con);
		if(result > 0) {
			commit(con);
		}
		else rollback(con);
		
		
		close(con);
		return result;
	}
	
public Member selectOne(int uNo) {
		
		Connection con = getConnection();
		
		Member m = mDao.selectOne(con,uNo);
		
		if(m !=null) {
			
			
			commit(con);
			
		}else rollback(con);
		
		close(con);
		return m;
	}
}
