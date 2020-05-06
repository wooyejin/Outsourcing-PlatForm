package com.winwin.jsp.project.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Project implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2244802554517727050L;
	private int pno; // 프로젝트 번호
	private Date penroll; // 등록날짜
	private String ptitle; // 프로젝트명
	private String pbang; // 구분
	private String ptype; // 분류
	private String pdetail; // 상세분류
	private String pcotx; // 내용
	private int pcost; // 예상비용
	private Date pstart; //예상시작일
	private Date pend; // 예상마감일
	private String pgo; // 진행기간
	private Date pmodate; // 수정날짜
	private String pmodwtr; // 수정작성자
	private int cno; // 기업 번호
	private String conf1; // 예산 협의
	private String conf2; // 착수 일자 협의
	private int count; // 등록자 현황
	private String cname; // 회사명
	private String cId;
	private String cContent; // 기업소개
	private String cImg; // 기업 사진
	private String career; //경력
	private String memcount; //모집인원
	
	
	
	
	
	

	public String getMemcount() {
		return memcount;
	}

	public void setMemcount(String memcount) {
		this.memcount = memcount;
	}

	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}

	public String getcImg() {
		return cImg;
	}

	public void setcImg(String cImg) {
		this.cImg = cImg;
	}

	public String getcId() {
		return cId;
	}

	public void setcId(String cId) {
		this.cId = cId;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	/**
	 * 프로젝트 리스트 열람용
	 * @param penroll
	 * @param ptitle
	 * @param pbang
	 * @param ptype
	 * @param pcotx
	 * @param pcost
	 * @param pstart
	 * @param pend
	 * @param pgo
	 * @param count
	 */
	public Project(Date penroll, String ptitle, String pbang, String ptype, String pcotx, int pcost, Date pstart,
			Date pend, String pgo, int count) {
		super();
		this.penroll = penroll;
		this.ptitle = ptitle;
		this.pbang = pbang;
		this.ptype = ptype;
		this.pcotx = pcotx;
		this.pcost = pcost;
		this.pstart = pstart;
		this.pend = pend;
		this.pgo = pgo;
		this.count = count;
	}

	/**
	 * 프로젝트 등록용1
	 * @param ptitle
	 * @param pbang
	 * @param ptype
	 * @param pdetail
	 * @param pcotx
	 * @param pstart
	 * @param pend
	 * @param pgo
	 * @param conf1
	 * @param conf2
	 */
	public Project(String ptitle, String pbang, String ptype, String pdetail, String pcotx, Date pstart, Date pend,
			String pgo, String conf1, String conf2) {
		super();
		this.ptitle = ptitle;
		this.pbang = pbang;
		this.ptype = ptype;
		this.pdetail = pdetail;
		this.pcotx = pcotx;
		this.pstart = pstart;
		this.pend = pend;
		this.pgo = pgo;
		this.conf1 = conf1;
		this.conf2 = conf2;
	}
	
	public Project() {
		super();
	}

	/**
	 * 프로젝트 등록용2
	 * @param ptitle
	 * @param pbang
	 * @param ptype
	 * @param pdetail
	 * @param pcotx
	 * @param pcost
	 * @param pstart
	 * @param pend
	 * @param pgo
	 * @param conf1
	 * @param conf2
	 */
	public Project(String ptitle, String pbang, String ptype, String pdetail, String pcotx, int pcost, Date pstart,
			Date pend, String pgo, String conf1, String conf2) {
		super();
		this.ptitle = ptitle;
		this.pbang = pbang;
		this.ptype = ptype;
		this.pdetail = pdetail;
		this.pcotx = pcotx;
		this.pcost = pcost;
		this.pstart = pstart;
		this.pend = pend;
		this.pgo = pgo;
		this.conf1 = conf1;
		this.conf2 = conf2;
	}

	
	public String getcContent() {
		return cContent;
	}

	public void setcContent(String cContent) {
		this.cContent = cContent;
	}

	public String getConf1() {
		return conf1;
	}
	public void setConf1(String conf1) {
		this.conf1 = conf1;
	}
	public String getConf2() {
		return conf2;
	}
	public void setConf2(String conf2) {
		this.conf2 = conf2;
	}
	public Project(int pno, Date penroll, String ptitle, String pbang, String ptype, String pdetail, String pcotx,
			int pcost, Date pstart, Date pend, String pgo, Date pmodate, String pmodwtr, int cno) {
		super();
		this.pno = pno;
		this.penroll = penroll;
		this.ptitle = ptitle;
		this.pbang = pbang;
		this.ptype = ptype;
		this.pdetail = pdetail;
		this.pcotx = pcotx;
		this.pcost = pcost;
		this.pstart = pstart;
		this.pend = pend;
		this.pgo = pgo;
		this.pmodate = pmodate;
		this.pmodwtr = pmodwtr;
		this.cno = cno;
	}
	public Project(String ptitle, String pbang, String ptype, String pdetail, String pcotx, Date pstart, Date pend,
			String pgo) {
		super();
		this.ptitle = ptitle;
		this.pbang = pbang;
		this.ptype = ptype;
		this.pdetail = pdetail;
		this.pcotx = pcotx;
		this.pstart = pstart;
		this.pend = pend;
		this.pgo = pgo;
	}
	public Project(String ptitle, String pbang, String ptype, String pdetail, String pcotx, int pcost, Date pstart,
			Date pend, String pgo) {
		super();
		this.ptitle = ptitle;
		this.pbang = pbang;
		this.ptype = ptype;
		this.pdetail = pdetail;
		this.pcotx = pcotx;
		this.pcost = pcost;
		this.pstart = pstart;
		this.pend = pend;
		this.pgo = pgo;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public Date getPenroll() {
		return penroll;
	}
	public void setPenroll(Date penroll) {
		this.penroll = penroll;
	}
	public String getPtitle() {
		return ptitle;
	}
	public void setPtitle(String ptitle) {
		this.ptitle = ptitle;
	}
	public String getPbang() {
		return pbang;
	}
	public void setPbang(String pbang) {
		this.pbang = pbang;
	}
	public String getPtype() {
		return ptype;
	}
	public void setPtype(String ptype) {
		this.ptype = ptype;
	}
	public String getPdetail() {
		return pdetail;
	}
	public void setPdetail(String pdetail) {
		this.pdetail = pdetail;
	}
	public String getPcotx() {
		return pcotx;
	}
	public void setPcotx(String pcotx) {
		this.pcotx = pcotx;
	}
	public int getPcost() {
		return pcost;
	}
	public void setPcost(int pcost) {
		this.pcost = pcost;
	}
	public Date getPstart() {
		return pstart;
	}
	public void setPstart(Date pstart) {
		this.pstart = pstart;
	}
	public Date getPend() {
		return pend;
	}
	public void setPend(Date pend) {
		this.pend = pend;
	}
	public String getPgo() {
		return pgo;
	}
	public void setPgo(String pgo) {
		this.pgo = pgo;
	}
	public Date getPmodate() {
		return pmodate;
	}
	public void setPmodate(Date pmodate) {
		this.pmodate = pmodate;
	}
	public String getPmodwtr() {
		return pmodwtr;
	}
	public void setPmodwtr(String pmodwtr) {
		this.pmodwtr = pmodwtr;
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Project [pno=" + pno + ", penroll=" + penroll + ", ptitle=" + ptitle + ", pbang=" + pbang + ", ptype="
				+ ptype + ", pdetail=" + pdetail + ", pcotx=" + pcotx + ", pcost=" + pcost + ", pstart=" + pstart
				+ ", pend=" + pend + ", pgo=" + pgo + ", pmodate=" + pmodate + ", pmodwtr=" + pmodwtr + ", cno=" + cno
				+ ", conf1=" + conf1 + ", conf2=" + conf2 + ", count=" + count + ", cname=" + cname + "]";
	}
	

	
}
