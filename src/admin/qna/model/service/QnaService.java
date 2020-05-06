package admin.qna.model.service;

import static admin.member.common.JDBCTemplate.close;
import static admin.member.common.JDBCTemplate.commit;
import static admin.member.common.JDBCTemplate.getConnection;
import static admin.member.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import admin.qna.model.dao.QnaDao;
import admin.qna.model.vo.Qna;


public class QnaService {
	

		private QnaDao qDao = new QnaDao();
		
		public ArrayList<Qna> readQna() {
			Connection con = getConnection();
			
			ArrayList<Qna> qlist = qDao.selectList(con);
			
			close(con);
			return qlist;
		}
		
		
		
		public Qna selectOne(int qNo) {
			
			Connection con = getConnection();
			
			Qna q = qDao.selectOne(con,qNo);
			
			if(q !=null) {
				
				
				commit(con);
				
			}else rollback(con);
			
			close(con);
			return q;
		}
		
		public int updateQna(Qna q) {
			Connection con = getConnection();

			int result = qDao.updateQna(con,q);
			
			if(result > 0) commit(con);
			else rollback(con);
			
			close(con);
			return result;
		}
	}

