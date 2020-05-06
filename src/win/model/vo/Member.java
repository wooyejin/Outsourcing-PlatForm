package win.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Member implements Serializable {
	
	private int no; // 기업이든 개발자든 고유번호
	private String memberType;
	private String email; // 이메일
	private String name; // 이름
	private String userId; // 아이디
	private String userPwd; // 비밀번호
	private String companyId; // 사업자 번호
	private Date enrollDate; // 가입날짜
	
	private String title; 
	private String workmanship;
	private String experience;
	
	private String changename;
	private String filepath;
	
	private String boardfile;
	private String fileYN;
	
	
	
	
	public Member() {}
	
	// 로그인용 생성자

	public Member emailName(String name, String email) {
		Member m=new Member();
		
		m.setEmail(email);
		m.setName(name);
		
		return m;
	}
	
	public Member(int no,String title, String workmanship, String experience) {
		super();
		this.no = no;
		this.title = title;
		this.workmanship = workmanship;
		this.experience = experience;
	}

	public Member(String userId, String userPwd) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
	}
	
	
	
	// 비밀번호 찾기
	public Member(String name, String userId, String email) {
		super();
		this.email = email;
		this.name = name;
		this.userId = userId;
	}

	// 회원가입용 생성자
	
	public Member(int no,String memberType, String email, String name, String userId, String userPwd, Date enrollDate) {
		super();
		this.no = no;
		this.memberType = memberType;
		this.email = email;
		this.name = name;
		this.userId = userId;
		this.userPwd = userPwd;
		this.enrollDate = enrollDate;
	}

	public Member(String memberType, String email, String name, String userId, String userPwd,
			String companyId) {
		super();
		this.memberType = memberType;
		this.email = email;
		this.name = name;
		this.userId = userId;
		this.userPwd = userPwd;
		this.companyId = companyId;
	}

	


	// 회원의 전체 데이터를 가져오는 생성자
	
	public Member(int no,String memberType, String email, String name, String userId, String userPwd,
			String companyId, Date enrollDate) {
		super();
		this.no = no;
		this.memberType = memberType;
		this.email = email;
		this.name = name;
		this.userId = userId;
		this.userPwd = userPwd;
		this.companyId = companyId;
		this.enrollDate = enrollDate;
	}

	
	public String getFileYN() {
		return fileYN;
	}

	public void setFileYN(String fileYN) {
		this.fileYN = fileYN;
	}

	public String getBoardfile() {
		return boardfile;
	}

	public void setBoardfile(String boardfile) {
		this.boardfile = boardfile;
	}

	public String getChangename() {
		return changename;
	}

	public void setChangename(String changename) {
		this.changename = changename;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWorkmanship() {
		return workmanship;
	}

	public void setWorkmanship(String workmanship) {
		this.workmanship = workmanship;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getMemberType() {
		return memberType;
	}
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	@Override
	public String toString() {
		return "Member [no=" + no + ", memberType=" + memberType + ", email=" + email + ", name=" + name + ", userId="
				+ userId + ", userPwd=" + userPwd + ", companyId=" + companyId + ", enrollDate=" + enrollDate
				+ ", title=" + title + ", workmanship=" + workmanship + ", experience=" + experience + "]";
	}

	
	

	

	
}
