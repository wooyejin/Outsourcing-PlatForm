package com.winwin.jsp.developer.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class developer implements Serializable {
  /**
	 * 
	 */
	private static final long serialVersionUID = 4017401909435240459L;
private String uId; // 개발자아이디
  private String uPhoto; // 개발자 사진 프로필
  private String port; // 개발자 포트폴리오
  private int uNo; //개발자 번호
  private String uName ;// 개발자 이름 
  private String uPwd; // 개발자 비밀번호
  private String uIntro; // 개발자 자기소개
  private String eMail; // 개발자 메일
  private String phone; // 개발자 연락처
  private Date regDate; // 가입일자
  private Date modDate; // 정보 수정일자
  private String modWtr; // 수정자
  private String skill; // 주요 툴
  private String uyn; // 탈퇴여부
  private String portYN; //포폴등록여부
  private String img; // 사원포토
  private String intro; //자기소개
  private String title; //자기소개 제목
  
  
  
  
  public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getIntro() {
	return intro;
}
public void setIntro(String intro) {
	this.intro = intro;
}
public String getImg() {
	return img;
}
public void setImg(String img) {
	this.img = img;
}
public String getPortYN() {
	return portYN;
}
public void setPortYN(String portYN) {
	this.portYN = portYN;
}
public String getSkill() {
	return skill;
}
public void setSkill(String skill) {
	this.skill = skill;
}
public String getuId() {
	return uId;
}
public void setuId(String uId) {
	this.uId = uId;
}
public String getuPhoto() {
	return uPhoto;
}
public void setuPhoto(String uPhoto) {
	this.uPhoto = uPhoto;
}
public String getPort() {
	return port;
}
public void setPort(String port) {
	this.port = port;
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
public String geteMail() {
	return eMail;
}
public void seteMail(String eMail) {
	this.eMail = eMail;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public Date getRegDate() {
	return regDate;
}
public void setRegDate(Date regDate) {
	this.regDate = regDate;
}
public Date getModDate() {
	return modDate;
}
public void setModDate(Date modDate) {
	this.modDate = modDate;
}
public String getModWtr() {
	return modWtr;
}
public void setModWtr(String modWtr) {
	this.modWtr = modWtr;
}
public String getUyn() {
	return uyn;
}
public void setUyn(String uyn) {
	this.uyn = uyn;
}
  
  
}
