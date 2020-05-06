package admin.ads.model.vo;

import java.sql.Date;

public class Ads {
	
	private int cNo;
	private int pNo;
	private Date adsStart;
	private Date adsEnd;
	private int adsPrice;
	private Date adsModifyDate;
	private String adsModifyWriter;
	
	
	public Ads() {
	}

	public Ads(int cNo, int pNo, Date adsStart, Date adsEnd, int adsPrice, Date adsModifyDate, String adsModifyWriter) {
		super();
		this.cNo = cNo;
		this.pNo = pNo;
		this.adsStart = adsStart;
		this.adsEnd = adsEnd;
		this.adsPrice = adsPrice;
		this.adsModifyDate = adsModifyDate;
		this.adsModifyWriter = adsModifyWriter;
	}

	public int getcNo() {
		return cNo;
	}

	public void setcNo(int cNo) {
		this.cNo = cNo;
	}

	public int getpNo() {
		return pNo;
	}

	public void setpNo(int pNo) {
		this.pNo = pNo;
	}

	public Date getAdsStart() {
		return adsStart;
	}

	public void setAdsStart(Date adsStart) {
		this.adsStart = adsStart;
	}

	public Date getAdsEnd() {
		return adsEnd;
	}

	public void setAdsEnd(Date adsEnd) {
		this.adsEnd = adsEnd;
	}

	public int getAdsPrice() {
		return adsPrice;
	}

	public void setAdsPrice(int adsPrice) {
		this.adsPrice = adsPrice;
	}

	public Date getAdsModifyDate() {
		return adsModifyDate;
	}

	public void setAdsModifyDate(Date adsModifyDate) {
		this.adsModifyDate = adsModifyDate;
	}

	public String getAdsModifyWriter() {
		return adsModifyWriter;
	}

	public void setAdsModifyWriter(String adsModifyWriter) {
		this.adsModifyWriter = adsModifyWriter;
	}

	@Override
	public String toString() {
		return "Ads [cNo=" + cNo + ", pNo=" + pNo + ", adsStart=" + adsStart + ", adsEnd=" + adsEnd + ", adsPrice="
				+ adsPrice + ", adsModifyDate=" + adsModifyDate + ", adsModifyWriter=" + adsModifyWriter + "]";
	}
	
	
}
