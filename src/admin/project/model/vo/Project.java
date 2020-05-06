package admin.project.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Project implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2338955191399187015L;
	private int pNo;
	private Date pEnro;
	private String pTitle;
	private String pBang;
	private String pType;
	private String pDetail;
	private String pCotx;
	private int pCost;
	private Date pStart;
	private Date pEnd;
	private String pGo;
	private Date pModifyDate;
	private String pModifyWriter;
	private String status;
	private String pAdsYn;
	private int cNo;
	
	public Project() {
	}

	

	public Project(int pNo, Date pEnro, String pTitle, String pBang, String pType, String pDetail, String pCotx,
			int pCost, Date pStart, Date pEnd, String pGo, Date pModifyDate, String pModifyWriter, String status,
			int cNo,String pAdsYn) {
		super();
		this.pNo = pNo;
		this.pEnro = pEnro;
		this.pTitle = pTitle;
		this.pBang = pBang;
		this.pType = pType;
		this.pDetail = pDetail;
		this.pCotx = pCotx;
		this.pCost = pCost;
		this.pStart = pStart;
		this.pEnd = pEnd;
		this.pGo = pGo;
		this.pModifyDate = pModifyDate;
		this.pModifyWriter = pModifyWriter;
		this.status = status;
		this.pAdsYn = pAdsYn;
		this.cNo = cNo;
	}



	public String getpAdsYn() {
		return pAdsYn;
	}



	public void setpAdsYn(String pAdsYn) {
		this.pAdsYn = pAdsYn;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public int getpNo() {
		return pNo;
	}

	public void setpNo(int pNo) {
		this.pNo = pNo;
	}

	public Date getpEnro() {
		return pEnro;
	}

	public void setpEnro(Date pEnro) {
		this.pEnro = pEnro;
	}

	public String getpTitle() {
		return pTitle;
	}

	public void setpTitle(String pTitle) {
		this.pTitle = pTitle;
	}

	public String getpBang() {
		return pBang;
	}

	public void setpBang(String pBang) {
		this.pBang = pBang;
	}

	public String getpType() {
		return pType;
	}

	public void setpType(String pType) {
		this.pType = pType;
	}

	public String getpDetail() {
		return pDetail;
	}

	public void setpDetail(String pDetail) {
		this.pDetail = pDetail;
	}

	public String getpCotx() {
		return pCotx;
	}

	public void setpCotx(String pCotx) {
		this.pCotx = pCotx;
	}

	public int getpCost() {
		return pCost;
	}

	public void setpCost(int pCost) {
		this.pCost = pCost;
	}

	public Date getpStart() {
		return pStart;
	}

	public void setpStart(Date pStart) {
		this.pStart = pStart;
	}

	public Date getpEnd() {
		return pEnd;
	}

	public void setpEnd(Date pEnd) {
		this.pEnd = pEnd;
	}

	public String getpGo() {
		return pGo;
	}

	public void setpGo(String pGo) {
		this.pGo = pGo;
	}

	public Date getpModifyDate() {
		return pModifyDate;
	}

	public void setpModifyDate(Date pModifyDate) {
		this.pModifyDate = pModifyDate;
	}

	public String getpModifyWriter() {
		return pModifyWriter;
	}

	public void setpModifyWriter(String pModifyWriter) {
		this.pModifyWriter = pModifyWriter;
	}

	public int getcNo() {
		return cNo;
	}

	public void setcNo(int cNo) {
		this.cNo = cNo;
	}



	@Override
	public String toString() {
		return "Project [pNo=" + pNo + ", pEnro=" + pEnro + ", pTitle=" + pTitle + ", pBang=" + pBang + ", pType="
				+ pType + ", pDetail=" + pDetail + ", pCotx=" + pCotx + ", pCost=" + pCost + ", pStart=" + pStart
				+ ", pEnd=" + pEnd + ", pGo=" + pGo + ", pModifyDate=" + pModifyDate + ", pModifyWriter="
				+ pModifyWriter + ", status=" + status + ", cNo=" + cNo + "]";
	}


	
	
	
}