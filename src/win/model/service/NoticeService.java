package win.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import win.model.dao.NoticeDao;
import win.model.vo.Notice;
import static win.common.JDBCTemplate.*;

public class NoticeService {
	
	private NoticeDao nDao = new NoticeDao();


	/**
	 * 공지사항 목록 불러오기
	 * 
	 * @return
	 */
	public ArrayList<Notice> selectList() {
		Connection con = getConnection();
		
		ArrayList<Notice>list = nDao.selectList(con);
		
		close(con);
		
		return list;
	}


	/**
	 * 게시글 상세보기
	 * 
	 * @return
	 */
	public Notice selectOne(int nno) {
		Connection con = getConnection();
		
		Notice n = nDao.selectOne(con,nno);
		
		if(n != null) {
			int result = nDao.updateReadCount(con,nno);
			
			if(result > 0)
				commit(con);
			else
				rollback(con);
		}
		
		close(con);
		
		return n;
	}

}
