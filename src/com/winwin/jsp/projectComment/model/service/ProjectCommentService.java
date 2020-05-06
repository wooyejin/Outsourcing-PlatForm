package com.winwin.jsp.projectComment.model.service;
import static com.winwin.jsp.common.JDBCTemplate.*;
import java.sql.Connection;
import java.util.ArrayList;

import com.winwin.jsp.projectComment.model.dao.ProjectCommentDao;
import com.winwin.jsp.projectComment.model.vo.ProjectComment;

public class ProjectCommentService {
	private ProjectCommentDao pcDao = new ProjectCommentDao();
	
	public ArrayList<ProjectComment> selectList(int pno){
		Connection con = getConnection();
		
		ArrayList<ProjectComment> plist = pcDao.selectList(con,pno);
		
		close(con);
		return plist;
	}
	
	public int insertComment(ProjectComment pco) {
		Connection con = getConnection();
		
		int result = pcDao.insertComment(con,pco);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}
}
