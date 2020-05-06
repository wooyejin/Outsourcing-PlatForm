package admin.company.model.service;

import static admin.member.common.JDBCTemplate.close;
import static admin.member.common.JDBCTemplate.commit;
import static admin.member.common.JDBCTemplate.getConnection;
import static admin.member.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import admin.company.model.dao.CompanyDao;
import admin.company.model.vo.Company;
import admin.member.model.vo.Member;

public class CompanyService {

	private CompanyDao cDao = new CompanyDao();
	
	public ArrayList<Company> readCompany() {
		Connection con = getConnection();
		
		ArrayList<Company> clist = cDao.selectList(con);
		
		close(con);
		return clist;
	}

	public int updateCompany(Company c) {
		Connection con = getConnection();

		int result = cDao.updateCompany(con,c);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		return result;
	}
	public int insertCcount() {
		Connection con = getConnection();
		int result = 0;
		
		result = cDao.insertCcount(con);
		if(result > 0) {
			commit(con);
		}
		else rollback(con);
		
		
		close(con);
		return result;
	}
	
public Company selectOne(int cNo) {
		
		Connection con = getConnection();
		
		Company c = cDao.selectOne(con,cNo);
		
		if(c !=null) {
			
			
			commit(con);
			
		}else rollback(con);
		
		close(con);
		return c;
	}
}
