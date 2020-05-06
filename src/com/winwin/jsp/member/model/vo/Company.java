package com.winwin.jsp.member.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Company implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8131386467509910936L;
	private int cno; // 기업번호
	private String cname; // 기업명
	private String cid; // 아이디
	private String cpwd; // 비밀번호
	private String cemail; // 이메일
	private String cphone; // 연락처
	private String cintro; // 기업소개
	private String cbus; // 사업자번호
	private Date reg; // 가입날짜
	private Date mod; // 수정날짜
	private String mod_wtr; // 수정자명
	
	/**
	 * 전체 조회용
	 * @param cno
	 * @param cname
	 * @param cid
	 * @param cpwd
	 * @param cemail
	 * @param cphone
	 * @param cintro
	 * @param cbus
	 * @param reg
	 * @param mod
	 * @param mod_wtr
	 */
	public Company(int cno, String cname, String cid, String cpwd, String cemail, String cphone, String cintro,
			String cbus, Date reg, Date mod, String mod_wtr) {
		super();
		this.cno = cno;
		this.cname = cname;
		this.cid = cid;
		this.cpwd = cpwd;
		this.cemail = cemail;
		this.cphone = cphone;
		this.cintro = cintro;
		this.cbus = cbus;
		this.reg = reg;
		this.mod = mod;
		this.mod_wtr = mod_wtr;
	}

	/**
	 * 기본 생성자
	 */
	public Company() {
		super();
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCpwd() {
		return cpwd;
	}

	public void setCpwd(String cpwd) {
		this.cpwd = cpwd;
	}

	public String getCemail() {
		return cemail;
	}

	public void setCemail(String cemail) {
		this.cemail = cemail;
	}

	public String getCphone() {
		return cphone;
	}

	public void setCphone(String cphone) {
		this.cphone = cphone;
	}

	public String getCintro() {
		return cintro;
	}

	public void setCintro(String cintro) {
		this.cintro = cintro;
	}

	public String getCbus() {
		return cbus;
	}

	public void setCbus(String cbus) {
		this.cbus = cbus;
	}

	public Date getReg() {
		return reg;
	}

	public void setReg(Date reg) {
		this.reg = reg;
	}

	public Date getMod() {
		return mod;
	}

	public void setMod(Date mod) {
		this.mod = mod;
	}

	public String getMod_wtr() {
		return mod_wtr;
	}

	public void setMod_wtr(String mod_wtr) {
		this.mod_wtr = mod_wtr;
	}
	
	
	
}
