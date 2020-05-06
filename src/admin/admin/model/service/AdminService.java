package admin.admin.model.service;

import static admin.member.common.JDBCTemplate.close;
import static admin.member.common.JDBCTemplate.commit;
import static admin.member.common.JDBCTemplate.getConnection;
import static admin.member.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import admin.admin.model.dao.AdminDao;
import admin.admin.model.vo.Admin;
import admin.ads.model.vo.Ads;

public class AdminService {
private AdminDao adDao = new AdminDao();
	
	public ArrayList<Admin> readAdmin() {
		Connection con = getConnection();
		
		ArrayList<Admin> adlist = adDao.selectList(con);
		
		close(con);
		return adlist;
	}
	
	public int updateAdmin(Admin ad) {
		Connection con = getConnection();

		int result = adDao.updateAdmin(con,ad);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		return result;
	}

	public int insertAdmin(String aMemo) {
		Connection con = getConnection();
		int result = 0;
		
		result = adDao.insertAdmin(con,aMemo);
		if(result > 0) {
			commit(con);
		}
		else rollback(con);
		
		
		close(con);
		return result;
	}
}
