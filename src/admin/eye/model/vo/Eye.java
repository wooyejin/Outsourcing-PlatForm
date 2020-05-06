package admin.eye.model.vo;

import java.sql.Date;

public class Eye {

	private String eWriter;
	private Date eDate;
	private String eContent;
	private String eYn;
	private int eNo;
	
	@Override
	public String toString() {
		return "Eye [eWriter=" + eWriter + ", eDate=" + eDate + ", eContent=" + eContent + ", eYn=" + eYn + ", eNo="
				+ eNo + "]";
	}


	public Eye(String eWriter, Date eDate, String eContent, String eYn, int eNo) {
		super();
		this.eWriter = eWriter;
		this.eDate = eDate;
		this.eContent = eContent;
		this.eYn = eYn;
		this.eNo = eNo;
	}


	public int geteNo() {
		return eNo;
	}


	public void seteNo(int eNo) {
		this.eNo = eNo;
	}


	public Eye() {
	}

	
	public String geteWriter() {
		return eWriter;
	}

	public void seteWriter(String eWriter) {
		this.eWriter = eWriter;
	}

	public Date geteDate() {
		return eDate;
	}

	public void seteDate(Date eDate) {
		this.eDate = eDate;
	}

	public String geteContent() {
		return eContent;
	}

	public void seteContent(String eContent) {
		this.eContent = eContent;
	}

	public String geteYn() {
		return eYn;
	}

	public void seteYn(String eYn) {
		this.eYn = eYn;
	}


	
	
	
	
}
