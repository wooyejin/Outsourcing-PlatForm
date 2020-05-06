package win.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import win.model.dao.BoardDao;
import win.model.vo.Board;

import static win.common.JDBCTemplate.*;

public class BoardService {

	private BoardDao bDao = new BoardDao();

	public int getListCount() {
		Connection con = getConnection();
		int listCount = bDao.getListCount(con);

		close(con);

		return listCount;
	}

	/**
	 * �Խñ� �߰�
	 * 
	 * @param b
	 * @return
	 */
	public int insertBoard(Board b) {
		Connection con = getConnection();

		int result = bDao.insertBoard(con, b);

		if (result > 0)
			commit(con);
		else
			rollback(con);

		close(con);

		return result;
	}

	/**
	 * �Խñ� ��� ��ȸ
	 * 
	 * @param
	 * @return
	 */
	public ArrayList<Board> selectList() {
		Connection con = getConnection();
		ArrayList<Board> list = bDao.selectList(con);

		close(con);

		return list;

	}

	/**
	 * �Խñ� �󼼺���
	 * 
	 * @param
	 * @return
	 */
	public Board selectOne(int bno) {
		Connection con = getConnection();

		Board b = bDao.selectOne(con, bno);
		
		if(b != null) {
			int result = bDao.updateReadCount(con,bno);
			
			if(result > 0)
				commit(con);
			else
				rollback(con);
		}

		close(con);
		return b;
	}

	
	/**
	 * �Խñ� ����
	 * 
	 * @param
	 * @return
	 */
	public Board updateView(int bno) {
		Connection con = getConnection();
		
		Board b = bDao.selectOne(con,bno);
		close(con);
		
		return b;
	}
	
	
	/**
	 * �Խñ� �����Ϸ�
	 * 
	 * @param
	 * @return
	 */
	public int updateBoard(Board b) {
		Connection con = getConnection();
		
		int result = bDao.updateBoard(con,b);
		
		if(result > 0 ) 
			commit(con);
		else 
			rollback(con);
		
		close(con);
		
		return result;
	}
	
	
	/**
	 * �Խñ� ����
	 * 
	 * @param
	 * @return
	 */
	public int deleteBoard(int bno) {
		Connection con = getConnection();
		
		int result = bDao.deleteBoard(con,bno);
		System.out.println("result :" + result);
		if(result > 0)
			commit(con);
		else {
			rollback(con);
		}
		return result;
	}

}
