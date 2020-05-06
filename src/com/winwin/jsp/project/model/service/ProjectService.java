package com.winwin.jsp.project.model.service;

import static com.winwin.jsp.common.JDBCTemplate.close;
import static com.winwin.jsp.common.JDBCTemplate.commit;
import static com.winwin.jsp.common.JDBCTemplate.getConnection;
import static com.winwin.jsp.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.winwin.jsp.project.model.dao.projectDao;
import com.winwin.jsp.project.model.exception.projectException;
import com.winwin.jsp.project.model.vo.Project;

import win.model.vo.Member;

public class ProjectService {
	
		
		private Connection con;
		private projectDao pDao = new projectDao();
		
		/**
		 * 프로젝트 등록
		 * @param p
		 * @param m 
		 * @return
		 * @throws projectExcepiton
		 */
		public int insertProject(Project p, Member m) throws projectException{
			con = getConnection();
			int result = pDao.insertProject(con,p,m);
			
			if(result > 0) commit(con);
			else rollback(con);
			
			close(con);
			
			return result;
		}
		
		/**
		 * 프로젝트 갯수 파악
		 * @return
		 */
		public int getListCount() {
			con = getConnection();
			int listCount = pDao.getListCount(con);
			
			close(con);
			return listCount;
		}
		
		/**
		 * 프로젝트 찾기창 리스트 조회
		 * @param currentPage
		 * @param limit
		 * @return
		 */
		public ArrayList<Project> selectList(int currentPage, int limit){
			con = getConnection();
			ArrayList<Project> list = pDao.selectList(con,currentPage,limit);
			
			close(con);
			
			return list;
		}

		public ArrayList<Project> selectList(String keyword,String category  ,int currentPage, int limit){
			con = getConnection();
			ArrayList<Project> list = pDao.selectList(con,currentPage,limit);
			
			close(con);
			
			return list;
		}

		
		/**
		 * 조건을 걸어 검색
		 * @param category
		 * @param sort 
		 * @return
		 */
		public ArrayList<Project> searchProject(int currentPage,int limit, String category,String keyword, String sort) {
			con = getConnection();
			
			ArrayList<Project> list = null;
			
			if(sort.equals("sort1") && keyword.isEmpty() == true && category.isEmpty() == true) {
				System.out.println("category1 : "+ category);
				System.out.println("keyword1 : " + keyword);
				list = pDao.selectList(con,currentPage,limit);
				
			}else /*if(category.length() > 0 || keyword.length()>0 || sort.isEmpty() != true)*/ {
				System.out.println("category2 : "+ category);
				System.out.println("keyword2 : " + keyword);
				list = pDao.searchProject(con,currentPage,limit,category,keyword,sort);
			}
			
			/*if(category.length() > 0 || keyword.length()>0) {
				
				
				list = pDao.searchProject(con,currentPage,limit,category,keyword,sort);
			}else {
				
				System.out.println(2);
				list = pDao.selectList(con,currentPage,limit);
			}*/
			
			close(con);
			return list;
		}

		public Project selectOne(int pno) {
			Connection con = getConnection();
			
			Project p = pDao.selectOne(con, pno);
			
			
			close(con);
			return p;
		}

		public int selectCount(int pno) {
			Connection con = getConnection();
			
			int count  = pDao.selectCount(con,pno);
			
			close(con);
			
			return count;
		}
}
