package com.winwin.jsp.developer.model.service;

import static com.winwin.jsp.common.JDBCTemplate.close;
import static com.winwin.jsp.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.winwin.jsp.developer.model.dao.developerDao;
import com.winwin.jsp.developer.model.exception.developerException;
import com.winwin.jsp.developer.model.vo.developer;


public class developerService {
	private Connection con;
	private developerDao dDao = new developerDao();
	
	
	public int getListCount() {
		con = getConnection();
		int listCount = dDao.getListCount(con);
		
		close(con);
		return listCount;
	}
	public ArrayList<developer> selectList(int currentPage, int limit) {
		con = getConnection();
		ArrayList<developer> list = dDao.selectList(con,currentPage,limit);
		System.out.println("list : "+list.toString());
		close(con);
		
		return list;
	}
	/*public ArrayList<developer> selectList(int currentPage, int limit) {
		con = getConnection();
		ArrayList<developer> list = dDao.selectList(con,currentPage,limit);
		
		close(con);
		
		return list;
	}*/
	public ArrayList<developer> searchdeveloper(int currentPage, int limit, String keyword) {
		con = getConnection();
		
		ArrayList<developer> list = null;
		
		if(keyword.isEmpty() == true) {
			list = dDao.selectList(con, currentPage, limit);
			
		}else {
			list = dDao.searchDeveloper(con,currentPage,limit,keyword);
			
		}
		return list;
	}
	public developer selectOne(int dno) {
	con = getConnection();
	
	developer d = dDao.selectOne(con,dno);
		return d;
	}
}
