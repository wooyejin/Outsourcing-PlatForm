package admin.company.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Company implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8047570094148722008L;
	
	private int cNo;
	private String cName;
	private String cId;
	private String cPwd;
	private String cEmail;
	private String cPhone;
	private String cIntro;
	private String cBus;
	private Date cRegDate;
	private Date cModifyDate;
	private String cModifyWriter;
	private String cYn;
	private String cProof;
	private int pNo;
	
	private String cChangeName;
	private String cFilePath;
	private String cPort;
	
	
	public Company() {
	}

	

	public Company(int cNo, String cName, String cId, String cPwd, String cEmail, String cPhone, String cIntro,
			String cBus, Date cRegDate, Date cModifyDate, String cModifyWriter, String cYn, String cProof, int pNo) {
		super();
		this.cNo = cNo;
		this.cName = cName;
		this.cId = cId;
		this.cPwd = cPwd;
		this.cEmail = cEmail;
		this.cPhone = cPhone;
		this.cIntro = cIntro;
		this.cBus = cBus;
		this.cRegDate = cRegDate;
		this.cModifyDate = cModifyDate;
		this.cModifyWriter = cModifyWriter;
		this.cYn = cYn;
		this.cProof = cProof;
		this.pNo = pNo;
	}



	public String getcChangeName() {
		return cChangeName;
	}



	public void setcChangeName(String cChangeName) {
		this.cChangeName = cChangeName;
	}



	public String getcFilePath() {
		return cFilePath;
	}



	public void setcFilePath(String cFilePath) {
		this.cFilePath = cFilePath;
	}



	public String getcPort() {
		return cPort;
	}



	public void setcPort(String cPort) {
		this.cPort = cPort;
	}



	public int getpNo() {
		return pNo;
	}



	public void setpNo(int pNo) {
		this.pNo = pNo;
	}



	public String getcProof() {
		return cProof;
	}

	public void setcProof(String cProof) {
		this.cProof = cProof;
	}

	public String getcYn() {
		return cYn;
	}

	public void setcYn(String cYn) {
		this.cYn = cYn;
	}

	public int getcNo() {
		return cNo;
	}

	public void setcNo(int cNo) {
		this.cNo = cNo;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcId() {
		return cId;
	}

	public void setcId(String cId) {
		this.cId = cId;
	}

	public String getcPwd() {
		return cPwd;
	}

	public void setcPwd(String cPwd) {
		this.cPwd = cPwd;
	}

	public String getcEmail() {
		return cEmail;
	}

	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}

	public String getcPhone() {
		return cPhone;
	}

	public void setcPhone(String cPhone) {
		this.cPhone = cPhone;
	}

	public String getcIntro() {
		return cIntro;
	}

	public void setcIntro(String cIntro) {
		this.cIntro = cIntro;
	}

	public String getcBus() {
		return cBus;
	}

	public void setcBus(String cBus) {
		this.cBus = cBus;
	}

	public Date getcRegDate() {
		return cRegDate;
	}

	public void setcRegDate(Date cRegDate) {
		this.cRegDate = cRegDate;
	}

	public Date getcModifyDate() {
		return cModifyDate;
	}

	public void setcModifyDate(Date cModifyDate) {
		this.cModifyDate = cModifyDate;
	}

	public String getcModifyWriter() {
		return cModifyWriter;
	}

	public void setcModifyWriter(String cModifyWriter) {
		this.cModifyWriter = cModifyWriter;
	}



	@Override
	public String toString() {
		return "Company [cNo=" + cNo + ", cName=" + cName + ", cId=" + cId + ", cPwd=" + cPwd + ", cEmail=" + cEmail
				+ ", cPhone=" + cPhone + ", cIntro=" + cIntro + ", cBus=" + cBus + ", cRegDate=" + cRegDate
				+ ", cModifyDate=" + cModifyDate + ", cModifyWriter=" + cModifyWriter + ", cYn=" + cYn + ", cProof="
				+ cProof + ", pNo=" + pNo + "]";
	}

	

	
	
	
	
}
