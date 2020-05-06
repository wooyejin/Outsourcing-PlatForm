package win.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Board implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8289438182037006947L;
	
	
	private int bno; //�Խñ� ��ȣ
	private String btitle; // ����
	private String bcontent; // �Խñ� ����
	private String bwriter; // �Խñ� �ۼ���
	private String bwriterId; // DB�� ���� ������ �Խñ� �ۼ��� ���̵�
	private int bcount; // �Խñ� ��ȸ��
	private String boardfile; // �Խñ� ÷������
	private Date bdate; //�ۼ���
	private String statues; // ��������('Y'�̸� ���� X, 'N'�̸� ���� O)
	
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
