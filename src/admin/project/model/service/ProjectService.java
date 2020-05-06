package admin.project.model.service;

import static admin.member.common.JDBCTemplate.close;
import static admin.member.common.JDBCTemplate.commit;
import static admin.member.common.JDBCTemplate.getConnection;
import static admin.member.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import admin.project.model.dao.ProjectDao;
import admin.project.model.vo.Project;

public class ProjectService {

	private ProjectDao pDao = new ProjectDao();
	
	public ArrayList<Project> readProject() {
		Connection con = getConnection();
		
		ArrayList<Project> plist = pDao.selectList(con);
		
		close(con);
		return plist;
	}

	public int updateProject(Project p) {
		Connection con = getConnection();
		int result = 0;
		
		result = pDao.updateProject(con,p);
		System.out.println("result1실행");
		
		if(result > 0) {
			commit(con);
		}
	else rollback(con);
		
		close(con);
		return result;
	}
	
	
	public int insultAsset(Project p) {
		Connection con = getConnection();
		int result2 = 0;
		
		result2 = pDao.insultAsset(con,p);
		if(result2 > 0) {
			System.out.println("result2실행");
			commit(con);
		}
		else rollback(con);
		
		
		close(con);
		return result2;
	}
	
	
	
public Project selectOne(int pNo) {
		
		Connection con = getConnection();
		
		Project p = pDao.selectOne(con,pNo);
		
		if(p !=null) {
			
			
			commit(con);
			
		}else rollback(con);
		
		close(con);
		return p;
	}
}
