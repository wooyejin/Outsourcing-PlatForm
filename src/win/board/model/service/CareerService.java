package win.board.model.service;

import static win.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import win.board.model.dao.BoardDao;
import win.board.model.vo.Career;
import win.board.model.vo.Skill;

public class CareerService {
	private BoardDao bDao = new BoardDao();

	public int getListCount() {
		
		Connection con = getConnection();
		int listCount = bDao.getListCount(con);
		
		close(con);
		
		return listCount;
	}

	public int insertCareer(ArrayList<Career> clist, String name, int no) {
		Connection con = getConnection();
		
		int result2 = bDao.deleteCareer(con ,no);
		
		int result = bDao.insertCareer(con,clist,name);
		
		if(result >0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	public ArrayList<Career> selectList(String type2, String number) {
		Connection con = getConnection();
		
		ArrayList<Career> list = bDao.selectCareer(con,type2,number);
		
		close(con);
		
		return list;
	}
}
