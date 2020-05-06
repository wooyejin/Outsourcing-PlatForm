package com.winwin.jsp.member.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import static com.winwin.jsp.common.JDBCTemplate.*;

import com.winwin.jsp.member.model.vo.Company;
public class CompanyDao {
	private Properties prop;
	public  CompanyDao() {
	prop = new Properties();
	
	String filePath = CompanyDao.class.getResource("/config/member-query.properties").getPath();
	
	try {
		prop.load(new FileReader(filePath));
	}catch(FileNotFoundException e) {
		e.printStackTrace();
	}catch(IOException e) {
		e.printStackTrace();
	}
	
	}
	public Company selectComapny(Connection con, Company c)  {
		Company result = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null; 
		
		try {
			String sql = prop.getProperty("selectCompany");
			
			pstmt = con.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}

}
