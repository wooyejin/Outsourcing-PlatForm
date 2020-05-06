package com.winwin.jsp.projectComment.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class ProjectComment implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5234247216506762756L;
	private int cno;
	private int pno;
	private String econtent;
	private String ewriter1; // 개발자
	private String ewriter2; // 기업
	private String ewriterId;
	private Date edate;
	public ProjectComment() {
		super();
	}
	public ProjectComment(int pno, String econtent, String ewriter1, String ewriter2) {
		super();
		this.pno = pno;
		this.econtent = econtent;
		this.ewriter1 = ewriter1;
		this.ewriter2 = ewriter2;
	}
	public ProjectComment(int cno, int pno, String econtent, String ewriter1,String ewriter2, Date edate) {
		super();
		this.cno = cno;
		this.pno = pno;
		this.econtent = econtent;
		this.ewriter1 = ewriter1;
		this.edate = edate;
		this.ewriter2 = ewriter2;
	}
	public String getEwriter2() {
		return ewriter2;
	}
	public void setEwriter2(String ewriter2) {
		this.ewriter2 = ewriter2;
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getEcontent() {
		return econtent;
	}
	public void setEcontent(String econtent) {
		this.econtent = econtent;
	}
	public String getEwriter1() {
		return ewriter1;
	}
	public void setEwriter1(String ewriter1) {
		this.ewriter1 = ewriter1;
	}
	public String getEwriterId() {
		return ewriterId;
	}
	public void setEwriterId(String ewriterId) {
		this.ewriterId = ewriterId;
	}
	public Date getEdate() {
		return edate;
	}
	public void setEdate(Date edate) {
		this.edate = edate;
	}

}
