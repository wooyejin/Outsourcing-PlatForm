package win.board.model.service;

import static win.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import win.board.model.dao.BoardDao;
import win.board.model.vo.Introduce;
import win.board.model.vo.Skill;

public class SkillService {
	private BoardDao bDao = new BoardDao();

	public int getListCount() {
		
		Connection con = getConnection();
		int listCount = bDao.getListCount(con);
		
		close(con);
		
		return listCount;
	}

	public int insertSkill(ArrayList<Skill> slist, String name, int no) {
		Connection con = getConnection();
		
		int result2 = bDao.deleteskill(con,no);
		
		int result = bDao.insertSkill(con,slist,name);
		
		if(result >0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
		
	}
	
	public ArrayList<Skill> selectList(String type2,String name) {
		Connection con = getConnection();
		
		ArrayList<Skill> list = bDao.selectSkill(con,type2,name);
		
		close(con);
		
		return list;
	}

	/**
	 * @param title
	 * @param work
	 * @param ex
	 * @return
	 * @작성자 : 문태환
	 * @내용  : 선택스킬 삭제
	 */
	public int deleteSkill(String title, String work, String ex) {

		Connection con = getConnection();
		
		int result = bDao.deleteOneSkill(title,work,ex,con);
		
		
		close(con);
		
		return result;
	}

	public ArrayList<Skill> selectAllList() {
		Connection con = getConnection();
		
		
		ArrayList<Skill> slist = bDao.selectAllList(con);
		
		close(con);
		
		
		return slist;
	}
}
