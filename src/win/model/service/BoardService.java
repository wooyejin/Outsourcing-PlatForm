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
	 * 게시글 추가
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
	 * 게시글 목록 조회
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
	 * 게시글 상세보기
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
	 * 게시글 수정
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
	 * 게시글 수정완료
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
	 * 게시글 삭제
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
