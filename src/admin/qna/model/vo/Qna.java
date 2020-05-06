package admin.qna.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Qna implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4030382962580989674L;
	
	private int qNo;
	private String qWriter;
	private String qTitle;
	private Date qDate;
	private int qCount;
	private String qContent;
	private String qA;
	private String qModifyWriter;
	private Date qModifyDate;
	private String qYn;
	
	public Qna() {
	}

	public Qna(int qNo, String qWriter, String qTitle, Date qDate, int qCount, String qContent, String qA,
			String qModifyWriter, Date qModifyDate, String qYn) {
		super();
		this.qNo = qNo;
		this.qWriter = qWriter;
		this.qTitle = qTitle;
		this.qDate = qDate;
		this.qCount = qCount;
		this.qContent = qContent;
		this.qA = qA;
		this.qModifyWriter = qModifyWriter;
		this.qModifyDate = qModifyDate;
		this.qYn = qYn;
	}

	public int getqNo() {
		return qNo;
	}

	public void setqNo(int qNo) {
		this.qNo = qNo;
	}

	public String getqWriter() {
		return qWriter;
	}

	public void setqWriter(String qWriter) {
		this.qWriter = qWriter;
	}

	public String getqTitle() {
		return qTitle;
	}

	public void setqTitle(String qTitle) {
		this.qTitle = qTitle;
	}

	public Date getqDate() {
		return qDate;
	}

	public void setqDate(Date qDate) {
		this.qDate = qDate;
	}

	public int getqCount() {
		return qCount;
	}

	public void setqCount(int qCount) {
		this.qCount = qCount;
	}

	public String getqContent() {
		return qContent;
	}

	public void setqContent(String qContent) {
		this.qContent = qContent;
	}

	public String getqA() {
		return qA;
	}

	public void setqA(String qA) {
		this.qA = qA;
	}

	public String getqModifyWriter() {
		return qModifyWriter;
	}

	public void setqModifyWriter(String qModifyWriter) {
		this.qModifyWriter = qModifyWriter;
	}

	public Date getqModifyDate() {
		return qModifyDate;
	}

	public void setqModifyDate(Date qModifyDate) {
		this.qModifyDate = qModifyDate;
	}

	public String getqYn() {
		return qYn;
	}

	public void setqYn(String qYn) {
		this.qYn = qYn;
	}

	@Override
	public String toString() {
		return "Qna [qNo=" + qNo + ", qWriter=" + qWriter + ", qTitle=" + qTitle + ", qDate=" + qDate + ", qCount="
				+ qCount + ", qContent=" + qContent + ", qA=" + qA + ", qModifyWriter=" + qModifyWriter
				+ ", qModifyDate=" + qModifyDate + ", qYn=" + qYn + "]";
	}
	
	
	
	
}
