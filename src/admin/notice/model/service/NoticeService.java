package admin.notice.model.service;

import static admin.member.common.JDBCTemplate.close;
import static admin.member.common.JDBCTemplate.commit;
import static admin.member.common.JDBCTemplate.getConnection;
import static admin.member.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import admin.ads.model.vo.Ads;
import admin.member.model.vo.Member;
import admin.notice.model.dao.NoticeDao;
import admin.notice.model.vo.Notice;


public class NoticeService {
	

		private NoticeDao nDao = new NoticeDao();
		
		public ArrayList<Notice> readNotice() {
			Connection con = getConnection();
			
			ArrayList<Notice> nlist = nDao.selectList(con);
			
			close(con);
			return nlist;
		}
		
		public int insertNotice(Notice n) {
			Connection con = getConnection();

			int result = nDao.insertNotice(con,n);
			
			if(result > 0) commit(con);
			else rollback(con);
			
			close(con);
			return result;
		}
		
		public Notice selectOne(int nNo) {
			
			Connection con = getConnection();
			
			Notice n = nDao.selectOne(con,nNo);
			
			if(n !=null) {
				
				
				commit(con);
				
			}else rollback(con);
			
			close(con);
			return n;
		}
		
		public int updateNotice(Notice n) {
			Connection con = getConnection();

			int result = nDao.updateNotice(con,n);
			
			if(result > 0) commit(con);
			else rollback(con);
			
			close(con);
			return result;
		}
	}

