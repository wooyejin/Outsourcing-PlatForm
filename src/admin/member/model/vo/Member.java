package admin.member.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Member implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7487643460817190566L;

	private int uNo;
	private int fNo;
	private String uName;
	private String uId;
	private String uPwd;
	private String uIntro;
	private String uProfile;
	private String uEmail;
	private String uPhone;
	private Date uRegDate;
	private Date uModifyDate;
	private String uModifyWriter;
	private String uYn;

	public Member() {
	}

	public int getfNo() {
		return fNo;
	}

	public void setfNo(int fNo) {
		this.fNo = fNo;
	}

	public Member(int uNo, int fNo, String uName, String uId, String uPwd, String uIntro, String uProfile,
			String uEmail, String uPhone, Date uRegDate, Date uModifyDate, String uModifyWriter, String uYn) {
		super();
		this.uNo = uNo;
		this.fNo = fNo;
		this.uName = uName;
		this.uId = uId;
		this.uPwd = uPwd;
		this.uIntro = uIntro;
		this.uProfile = uProfile;
		this.uEmail = uEmail;
		this.uPhone = uPhone;
		this.uRegDate = uRegDate;
		this.uModifyDate = uModifyDate;
		this.uModifyWriter = uModifyWriter;
		this.uYn = uYn;
	}

	public String getuYn() {
		return uYn;
	}

	public void setuYn(String uYn) {
		this.uYn = uYn;
	}

	@Override
	public String toString() {
		return "Member [uNo=" + uNo + ", fNo=" + fNo + ", uName=" + uName + ", uId=" + uId + ", uPwd=" + uPwd
				+ ", uIntro=" + uIntro + ", uProfile=" + uProfile + ", uEmail=" + uEmail + ", uPhone=" + uPhone
				+ ", uRegDate=" + uRegDate + ", uModifyDate=" + uModifyDate + ", uModifyWriter=" + uModifyWriter
				+ ", uYn=" + uYn + "]";
	}

	public int getuNo() {
		return uNo;
	}

	public void setuNo(int uNo) {
		this.uNo = uNo;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public String getuPwd() {
		return uPwd;
	}

	public void setuPwd(String uPwd) {
		this.uPwd = uPwd;
	}

	public String getuIntro() {
		return uIntro;
	}

	public void setuIntro(String uIntro) {
		this.uIntro = uIntro;
	}

	public String getuProfile() {
		return uProfile;
	}

	public void setuProfile(String uProfile) {
		this.uProfile = uProfile;
	}

	public String getuEmail() {
		return uEmail;
	}

	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}

	public String getuPhone() {
		return uPhone;
	}

	public void setuPhone(String uPhone) {
		this.uPhone = uPhone;
	}

	public Date getuRegDate() {
		return uRegDate;
	}

	public void setuRegDate(Date uRegDate) {
		this.uRegDate = uRegDate;
	}

	public Date getuModifyDate() {
		return uModifyDate;
	}

	public void setuModifyDate(Date uModifyDate) {
		this.uModifyDate = uModifyDate;
	}

	public String getuModifyWriter() {
		return uModifyWriter;
	}

	public void setuModifyWriter(String uModifyWriter) {
		this.uModifyWriter = uModifyWriter;
	}

}
