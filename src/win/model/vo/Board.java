package win.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Board implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8289438182037006947L;
	
	
	private int bno; //게시글 번호
	private String btitle; // 제목
	private String bcontent; // 게시글 내용
	private String bwriter; // 게시글 작성자
	private String bwriterId; // DB로 부터 가져올 게시글 작성자 아이디
	private int bcount; // 게시글 조회수
	private String boardfile; // 게시글 첨부파일
	private Date bdate; //작성일
	private String statues; // 삭제여부('Y'이면 삭제 X, 'N'이면 삭제 O)
	
	public Board() {

	}

	public Board(String bwriter, String bwriterId, String boardfile) {
		super();
		this.bwriter = bwriter;
		this.bwriterId = bwriterId;
		this.boardfile = boardfile;
	}

	public Board(int bno, String btitle, String bcontent, String bwriter, String bwriterId, int bcount,
			String boardfile, Date bdate, String statues) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bwriter = bwriter;
		this.bwriterId = bwriterId;
		this.bcount = bcount;
		this.boardfile = boardfile;
		this.bdate = bdate;
		this.statues = statues;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	public String getBwriter() {
		return bwriter;
	}

	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}

	public String getBwriterId() {
		return bwriterId;
	}

	public void setBwriterId(String bwriterId) {
		this.bwriterId = bwriterId;
	}

	public int getBcount() {
		return bcount;
	}

	public void setBcount(int bcount) {
		this.bcount = bcount;
	}

	public String getBoardfile() {
		return boardfile;
	}

	public void setBoardfile(String boardfile) {
		this.boardfile = boardfile;
	}

	public Date getBdate() {
		return bdate;
	}

	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}

	public String getStatues() {
		return statues;
	}

	public void setStatues(String statues) {
		this.statues = statues;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Board [bno=" + bno + ", btitle=" + btitle + ", bcontent=" + bcontent + ", bwriter=" + bwriter
				+ ", bwriterId=" + bwriterId + ", bcount=" + bcount + ", boardfile=" + boardfile + ", bdate=" + bdate
				+ ", statues=" + statues + "]";
	}
	
	
	
}
