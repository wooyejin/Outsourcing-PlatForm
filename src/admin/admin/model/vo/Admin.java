package admin.admin.model.vo;

import java.io.Serializable;

public class Admin implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1002450202543701344L;

	private int cCount;
	private int uCount;
	private int eCount;
	private int aCount;
	private int ccCount;
	private int uuCount;
	private int eeCount;
	private int aaCount;
	private int enCount;
	public int getEnCount() {
		return enCount;
	}


	public void setEnCount(int enCount) {
		this.enCount = enCount;
	}


	public int getCcCount() {
		return ccCount;
	}


	public void setCcCount(int ccCount) {
		this.ccCount = ccCount;
	}


	public int getUuCount() {
		return uuCount;
	}


	public void setUuCount(int uuCount) {
		this.uuCount = uuCount;
	}


	public int getEeCount() {
		return eeCount;
	}


	public void setEeCount(int eeCount) {
		this.eeCount = eeCount;
	}


	public int getAaCount() {
		return aaCount;
	}


	public void setAaCount(int aaCount) {
		this.aaCount = aaCount;
	}

	private String aMemo;
	
	public Admin() {
	}

	
	public int getcCount() {
		return cCount;
	}

	public void setcCount(int cCount) {
		this.cCount = cCount;
	}

	public int getuCount() {
		return uCount;
	}

	public void setuCount(int uCount) {
		this.uCount = uCount;
	}

	public int geteCount() {
		return eCount;
	}

	public void seteCount(int eCount) {
		this.eCount = eCount;
	}

	public int getaCount() {
		return aCount;
	}

	public void setaCount(int aCount) {
		this.aCount = aCount;
	}

	public String getaMemo() {
		return aMemo;
	}

	public void setaMemo(String aMemo) {
		this.aMemo = aMemo;
	}


	
	@Override
	public String toString() {
		return "Admin [cCount=" + cCount + ", uCount=" + uCount + ", eCount=" + eCount + ", aCount=" + aCount
				+ ", ccCount=" + ccCount + ", uuCount=" + uuCount + ", eeCount=" + eeCount + ", aaCount=" + aaCount
				+ ", aMemo=" + aMemo +", enCount=" + enCount+ "]";
	}
	
	
	public Admin(int cCount, int uCount, int eCount, int aCount, int ccCount, int uuCount, int eeCount, int aaCount,
			String aMemo,int enCount) {
		super();
		this.cCount = cCount;
		this.uCount = uCount;
		this.eCount = eCount;
		this.aCount = aCount;
		this.ccCount = ccCount;
		this.uuCount = uuCount;
		this.eeCount = eeCount;
		this.aaCount = aaCount;
		this.aMemo = aMemo;
		this.enCount = enCount;
	}
}
