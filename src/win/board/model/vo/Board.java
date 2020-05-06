package win.board.model.vo;

import java.sql.Date;

public class Board {
	private int rno; // 게시글 번호
	private String rtitle; // 게시글 제목
	private Date rdate; // 작성날짜
	private String status;  // 삭제 여부
	
	public Board() {}

	public Board(int rno, String rtitle, String status) {
		super();
		this.rno = rno;
		this.rtitle = rtitle;
		this.status = status;
	}

	public Board(int rno, String rtitle, Date rdate, String status) {
		super();
		this.rno = rno;
		this.rtitle = rtitle;
		this.rdate = rdate;
		this.status = status;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public String getRtitle() {
		return rtitle;
	}

	public void setRtitle(String rtitle) {
		this.rtitle = rtitle;
	}

	public Date getRdate() {
		return rdate;
	}

	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Board [rno=" + rno + ", rtitle=" + rtitle + ", rdate=" + rdate + ", status=" + status + "]";
	}
	
	
	
}
