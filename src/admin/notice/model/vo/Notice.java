package admin.notice.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Notice implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2345414578572983633L;
	
	private int nNo;
	private String nTitle;
	private String nWriter;
	private Date nDate;
	private int nCount;
	private String nContent;
	private Date nModifyDate;
	private String nModifyWriter;
	private String nYn;
	
	public Notice() {
	}

	

	public Date getnModifyDate() {
		return nModifyDate;
	}



	public void setnModifyDate(Date nModifyDate) {
		this.nModifyDate = nModifyDate;
	}



	public String getnModifyWriter() {
		return nModifyWriter;
	}



	public void setnModifyWriter(String nModifyWriter) {
		this.nModifyWriter = nModifyWriter;
	}



	public Notice(int nNo, String nTitle, String nWriter, Date nDate, int nCount, String nContent, Date nModifyDate,
			String nModifyWriter,String nYn) {
		super();
		this.nNo = nNo;
		this.nTitle = nTitle;
		this.nWriter = nWriter;
		this.nDate = nDate;
		this.nCount = nCount;
		this.nContent = nContent;
		this.nModifyDate = nModifyDate;
		this.nModifyWriter = nModifyWriter;
		this.nYn = nYn;
	}



	public String getnYn() {
		return nYn;
	}



	public void setnYn(String nYn) {
		this.nYn = nYn;
	}



	public int getnNo() {
		return nNo;
	}

	public void setnNo(int nNo) {
		this.nNo = nNo;
	}

	public String getnTitle() {
		return nTitle;
	}

	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}

	public String getnWriter() {
		return nWriter;
	}

	public void setnWriter(String nWriter) {
		this.nWriter = nWriter;
	}

	public Date getnDate() {
		return nDate;
	}

	public void setnDate(Date nDate) {
		this.nDate = nDate;
	}

	public int getnCount() {
		return nCount;
	}

	public void setnCount(int nCount) {
		this.nCount = nCount;
	}

	public String getnContent() {
		return nContent;
	}

	public void setnContent(String nContent) {
		this.nContent = nContent;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Notice [nNo=" + nNo + ", nTitle=" + nTitle + ", nWriter=" + nWriter + ", nDate=" + nDate + ", nCount="
				+ nCount + ", nContent=" + nContent + "]";
	}

	}
