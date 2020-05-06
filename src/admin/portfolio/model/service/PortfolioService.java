package admin.portfolio.model.service;

import static admin.member.common.JDBCTemplate.close;
import static admin.member.common.JDBCTemplate.commit;
import static admin.member.common.JDBCTemplate.getConnection;
import static admin.member.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import admin.portfolio.model.dao.PortfolioDao;
import admin.portfolio.model.vo.Portfolio;
import win.model.vo.Member;

public class PortfolioService {

	private PortfolioDao fDao = new PortfolioDao();
	
	public ArrayList<Portfolio> readPortfolio() {
		Connection con = getConnection();
		
		ArrayList<Portfolio> flist = fDao.selectList(con);
		
		close(con);
		return flist;
	}
	
	public int updatePortfolio(Portfolio f, Member m) {
		Connection con = getConnection();

		int result = fDao.updatePortfolio(con,f,m);
		
		if(result > 1) commit(con);
		else rollback(con);
		System.out.println("서비스업데이트 "+result);

		close(con);
		return result;
	}
	
public Portfolio selectOne(int portNo) {
		
		Connection con = getConnection();
		
		Portfolio f = fDao.selectOne(con,portNo);
		
		if(f !=null) {
			
			
			commit(con);
			
		}else rollback(con);
		
		close(con);
		return f;
	}
}
