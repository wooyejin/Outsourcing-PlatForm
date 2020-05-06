package com.winwin.jsp.member.model.service;

import static com.winwin.jsp.common.JDBCTemplate.close;
import static com.winwin.jsp.common.JDBCTemplate.getConnection;

import java.sql.Connection;

import com.winwin.jsp.member.model.dao.CompanyDao;
import com.winwin.jsp.member.model.vo.Company;

import win.exception.MemberException;

public class MemberService {
	
	private Connection con;
	private CompanyDao cDao = new CompanyDao();
	
	
	
	/**
	 * 기업 가입 정보 확인
	 * @param m
	 * @return
	 * @throws MemberException
	 */
	
	public Company selectCompany(Company c) throws MemberException {
		con = getConnection();
		
		Company result = cDao.selectComapny(con,c);
		
		close(con);
		
		if(result == null) {
			throw new MemberException("회원 아이디나 비밀번호가 올바르지 않습니다.");
		}
		return result;
	}
	

}
