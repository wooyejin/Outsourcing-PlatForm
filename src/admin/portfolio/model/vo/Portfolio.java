package admin.portfolio.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Portfolio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7970817910987135579L;
	private int portNo;
	private int uNo;
	private String Port;
	private Date poModifyDate;
	private String poYn;
	private String poModifyWriter;
	
	public Portfolio() {
	}

	public Portfolio(int portNo, int uNo, String port, Date poModifyDate, String poModifyWriter, String poYn) {
		super();
		this.portNo = portNo;
		this.uNo = uNo;
		Port = port;
		this.poYn = poYn;
		this.poModifyDate = poModifyDate;
		this.poModifyWriter = poModifyWriter;
	}

	public String getPoYn() {
		return poYn;
	}

	public void setPoYn(String poYn) {
		this.poYn = poYn;
	}

	public int getPortNo() {
		return portNo;
	}

	public void setPortNo(int portNo) {
		this.portNo = portNo;
	}

	public int getuNo() {
		return uNo;
	}

	public void setuNo(int uNo) {
		this.uNo = uNo;
	}

	public String getPort() {
		return Port;
	}

	public void setPort(String port) {
		Port = port;
	}

	public Date getPoModifyDate() {
		return poModifyDate;
	}

	public void setPoModifyDate(Date poModifyDate) {
		this.poModifyDate = poModifyDate;
	}

	public String getPoModifyWriter() {
		return poModifyWriter;
	}

	public void setPoModifyWriter(String poModifyWriter) {
		this.poModifyWriter = poModifyWriter;
	}

	@Override
	public String toString() {
		return "Portfolio [portNo=" + portNo + ", uNo=" + uNo + ", Port=" + Port + ", poModifyDate=" + poModifyDate
				+ ", poModifyWriter=" + poModifyWriter + "]";
	}
	
	
}
