package win.board.model.service;


import static win.common.JDBCTemplate.*;


import java.sql.Connection;
import java.util.ArrayList;

import win.board.model.vo.Board;
import win.board.model.vo.Introduce;
import win.board.model.vo.Skill;
import win.board.model.dao.BoardDao;

public class IntroduceService {
	private BoardDao bDao = new BoardDao();

	public int getListCount() {
		
		Connection con = getConnection();
		int listCount = bDao.getListCount(con);
		
		close(con);
		
		return listCount;
	}
	
	public int insertBoard(Introduce i, String name,String no) {
		Connection con = getConnection();
		
		int result2 = bDao.deleteBoard(con,name,no);
		
		int result = bDao.insertBoard(con,i,name,no);
		
		
		
		if(result >0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	public Introduce selectList(String type2, String number) {
		Connection con = getConnection();
		
		Introduce in= bDao.selectList(con,type2,number);
		
		close(con);
		
		return in;
	}

	public void deleteBoard(String no, String name) {

		
		
	}

	

}
