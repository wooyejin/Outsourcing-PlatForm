package win.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import win.model.dao.BoardCommentDao;
import win.model.vo.BoardComment;
import static win.common.JDBCTemplate.*;

public class BoardCommentService {
	
	private BoardCommentDao bcDao = new BoardCommentDao();

	
	/**
	 * �Խñۺ� ��� ��ȸ
	 *@param
	 *@return
	 */
	public ArrayList<BoardComment> selectList(int bno) {
		
		Connection con = getConnection();
	
		ArrayList<BoardComment> clist = bcDao.selectList(con,bno);
		
		close(con);
		
		return clist;
	}
	
	
	/**
	 * �Խñ� ��� �ۼ�
	 *@param
	 *@return
	 */
	public int insertComment(BoardComment bco) {
		Connection con = getConnection();
		int result = bcDao.insertComment(con,bco);
		
		if(result>0)commit(con);
		else rollback(con);
		
		return result;
	}

	
	/**
	 * �Խñ� ��� ����
	 *@param
	 *@return
	 *
	 */
	public int deleteComment(int cno) {
		Connection con = getConnection();
		
		int result = bcDao.deleteComment(con,cno);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		return result;
	}

}
