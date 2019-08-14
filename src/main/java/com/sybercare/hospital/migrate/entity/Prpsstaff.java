package com.sybercare.hospital.migrate.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "prpsstaff")
public class Prpsstaff {
	@Id
	@Column(name = "personid")
	private String personid;// varchar(30) NOT NULL DEFAULT '' COMMENT '员工编号',
	private String personname;// varchar(60) DEFAULT NULL COMMENT '员工名称',
	private String comcode;// varchar(50) DEFAULT NULL COMMENT '归属机构代码',
	private Date partintime;// datetime DEFAULT NULL COMMENT '入司时间',
	private String validstatus;// char(1) DEFAULT NULL COMMENT '有效状态',
	private Date opertime;// timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '操作时间',
	private String opercode;// varchar(30) DEFAULT NULL COMMENT '操作人',
	private String sex;// varchar(1) DEFAULT NULL COMMENT '性别',
	private String identifynumber;// varchar(20) DEFAULT NULL COMMENT '身份证号',
	private String nationality;// varchar(20) DEFAULT NULL COMMENT '民族',
	private Date birthday;// date DEFAULT NULL COMMENT '出生年月',
	private String homephone;// varchar(30) DEFAULT NULL COMMENT '电话',
	private String mobile;// varchar(30) NOT NULL COMMENT '手机',
	private String bank;// varchar(120) DEFAULT NULL COMMENT '开户行',
	private String account;// varchar(60) DEFAULT NULL COMMENT '银行账号',
	private String e_mail;// varchar(60) DEFAULT NULL COMMENT 'e_mail地址',
	private String microblog;// varchar(60) DEFAULT NULL COMMENT '微博地址',
	private String wechat;// varchar(60) DEFAULT NULL COMMENT '微信地址',
	private String homeaddress;// varchar(1000) DEFAULT NULL COMMENT '家庭地址',
	private String maritalstatus;// varchar(10) DEFAULT NULL COMMENT '婚姻状况',
	private String qualifications;// varchar(60) DEFAULT NULL COMMENT '最高学历',
	private String schools;// varchar(60) DEFAULT NULL COMMENT '毕业院校',
	private Date graduationdate;// datetime DEFAULT NULL COMMENT '毕业时间',
	private String professional;// varchar(30) DEFAULT NULL COMMENT '专业名称',
	private String certificate;// varchar(20) DEFAULT NULL COMMENT '专业执照',
	private Date certificateStartDate;// date DEFAULT NULL COMMENT '执照起始日期',
	private Date certificateEndDate;// date DEFAULT NULL COMMENT '执照结束日期',
	private String remark;// varchar(200) DEFAULT NULL COMMENT '备注',
	private String PASSWORD;// varchar(64) DEFAULT NULL COMMENT '密码',
	private Date passwdsetdate;// datetime DEFAULT NULL COMMENT '密码设定日期',
	private Date passwordexpiredate;// datetime DEFAULT NULL COMMENT '密码失效日期',
	private Date validdate;// datetime DEFAULT NULL COMMENT '有效日期',
	private String applytype;// varchar(2) DEFAULT NULL COMMENT '申请类型1：新增 2：修改',
	private String verifycode;// varchar(30) DEFAULT NULL COMMENT '审核人',
	private Date verifydate;// datetime DEFAULT NULL COMMENT '审核时间',
	private String verifystatus;// varchar(2) DEFAULT NULL COMMENT '审核状态',
	private String reviews;// varchar(255) DEFAULT NULL COMMENT '审核意见',
	private Integer operatetimes;// int(11) DEFAULT NULL COMMENT '操作次数',
	private String userCode;// varchar(50) DEFAULT NULL COMMENT '工号',
	private String avatar;// varchar(200) DEFAULT NULL COMMENT '头像路径',
	private String role;// varchar(2) DEFAULT NULL COMMENT '用户角色',
	private String verifymsg;// varchar(10) DEFAULT NULL COMMENT '短信码',
	private String verifytime;// varchar(19) DEFAULT NULL COMMENT '验证码获取时间',
	private String stamp_time;// varchar(19) DEFAULT NULL COMMENT '时间戳',
	private String hospital;// varchar(100) DEFAULT NULL COMMENT '就职医院',
	private Integer isdoctor;// tinyint(2) DEFAULT NULL COMMENT '是否为医生',
	private String tiitleCertificate;// varchar(100) DEFAULT NULL COMMENT '职称证书附件',
	private String tiitleCertificateNo;// varchar(100) DEFAULT NULL COMMENT '职称整数编号',
	private String vocationalcertificate;// varchar(100) DEFAULT NULL COMMENT '职业证书附件',
	private String vocationalcertificateNo;// varchar(100) DEFAULT NULL COMMENT '职业整数编号',
	private String personalpassport;// varchar(100) DEFAULT NULL COMMENT '个人证件照附件',
	private String admintitle;// varchar(100) DEFAULT NULL COMMENT '行政职称',
	private String teachtitle;// varchar(100) DEFAULT NULL COMMENT '教学职称',
	private String department;// varchar(100) DEFAULT NULL COMMENT '科室',
	private String therapeuticrange;// varchar(200) DEFAULT NULL COMMENT '治疗范围',
	private String adept;// varchar(500) DEFAULT NULL COMMENT '擅长',
	private Integer is_login;// tinyint(2) DEFAULT NULL COMMENT '0-未登陆过 1-已登陆过',
	private Date first_login_time;// datetime DEFAULT NULL COMMENT '首次登录时间',
	private Integer applogintimes;// int(11) DEFAULT '0' COMMENT 'APP登陆次数',

	public String getPersonid() {
		return personid;
	}

	public void setPersonid(String personid) {
		this.personid = personid;
	}

	public String getPersonname() {
		return personname;
	}

	public void setPersonname(String personname) {
		this.personname = personname;
	}

	public String getComcode() {
		return comcode;
	}

	public void setComcode(String comcode) {
		this.comcode = comcode;
	}

	public Date getPartintime() {
		return partintime;
	}

	public void setPartintime(Date partintime) {
		this.partintime = partintime;
	}

	public String getValidstatus() {
		return validstatus;
	}

	public void setValidstatus(String validstatus) {
		this.validstatus = validstatus;
	}

	public Date getOpertime() {
		return opertime;
	}

	public void setOpertime(Date opertime) {
		this.opertime = opertime;
	}

	public String getOpercode() {
		return opercode;
	}

	public void setOpercode(String opercode) {
		this.opercode = opercode;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIdentifynumber() {
		return identifynumber;
	}

	public void setIdentifynumber(String identifynumber) {
		this.identifynumber = identifynumber;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getHomephone() {
		return homephone;
	}

	public void setHomephone(String homephone) {
		this.homephone = homephone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	public String getMicroblog() {
		return microblog;
	}

	public void setMicroblog(String microblog) {
		this.microblog = microblog;
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public String getHomeaddress() {
		return homeaddress;
	}

	public void setHomeaddress(String homeaddress) {
		this.homeaddress = homeaddress;
	}

	public String getMaritalstatus() {
		return maritalstatus;
	}

	public void setMaritalstatus(String maritalstatus) {
		this.maritalstatus = maritalstatus;
	}

	public String getQualifications() {
		return qualifications;
	}

	public void setQualifications(String qualifications) {
		this.qualifications = qualifications;
	}

	public String getSchools() {
		return schools;
	}

	public void setSchools(String schools) {
		this.schools = schools;
	}

	public Date getGraduationdate() {
		return graduationdate;
	}

	public void setGraduationdate(Date graduationdate) {
		this.graduationdate = graduationdate;
	}

	public String getProfessional() {
		return professional;
	}

	public void setProfessional(String professional) {
		this.professional = professional;
	}

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public Date getCertificateStartDate() {
		return certificateStartDate;
	}

	public void setCertificateStartDate(Date certificateStartDate) {
		this.certificateStartDate = certificateStartDate;
	}

	public Date getCertificateEndDate() {
		return certificateEndDate;
	}

	public void setCertificateEndDate(Date certificateEndDate) {
		this.certificateEndDate = certificateEndDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}

	public Date getPasswdsetdate() {
		return passwdsetdate;
	}

	public void setPasswdsetdate(Date passwdsetdate) {
		this.passwdsetdate = passwdsetdate;
	}

	public Date getPasswordexpiredate() {
		return passwordexpiredate;
	}

	public void setPasswordexpiredate(Date passwordexpiredate) {
		this.passwordexpiredate = passwordexpiredate;
	}

	public Date getValiddate() {
		return validdate;
	}

	public void setValiddate(Date validdate) {
		this.validdate = validdate;
	}

	public String getApplytype() {
		return applytype;
	}

	public void setApplytype(String applytype) {
		this.applytype = applytype;
	}

	public String getVerifycode() {
		return verifycode;
	}

	public void setVerifycode(String verifycode) {
		this.verifycode = verifycode;
	}

	public Date getVerifydate() {
		return verifydate;
	}

	public void setVerifydate(Date verifydate) {
		this.verifydate = verifydate;
	}

	public String getVerifystatus() {
		return verifystatus;
	}

	public void setVerifystatus(String verifystatus) {
		this.verifystatus = verifystatus;
	}

	public String getReviews() {
		return reviews;
	}

	public void setReviews(String reviews) {
		this.reviews = reviews;
	}

	public Integer getOperatetimes() {
		return operatetimes;
	}

	public void setOperatetimes(Integer operatetimes) {
		this.operatetimes = operatetimes;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getVerifymsg() {
		return verifymsg;
	}

	public void setVerifymsg(String verifymsg) {
		this.verifymsg = verifymsg;
	}

	public String getVerifytime() {
		return verifytime;
	}

	public void setVerifytime(String verifytime) {
		this.verifytime = verifytime;
	}

	public String getStamp_time() {
		return stamp_time;
	}

	public void setStamp_time(String stamp_time) {
		this.stamp_time = stamp_time;
	}

	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	public Integer getIsdoctor() {
		return isdoctor;
	}

	public void setIsdoctor(Integer isdoctor) {
		this.isdoctor = isdoctor;
	}

	public String getTiitleCertificate() {
		return tiitleCertificate;
	}

	public void setTiitleCertificate(String tiitleCertificate) {
		this.tiitleCertificate = tiitleCertificate;
	}

	public String getTiitleCertificateNo() {
		return tiitleCertificateNo;
	}

	public void setTiitleCertificateNo(String tiitleCertificateNo) {
		this.tiitleCertificateNo = tiitleCertificateNo;
	}

	public String getVocationalcertificate() {
		return vocationalcertificate;
	}

	public void setVocationalcertificate(String vocationalcertificate) {
		this.vocationalcertificate = vocationalcertificate;
	}

	public String getVocationalcertificateNo() {
		return vocationalcertificateNo;
	}

	public void setVocationalcertificateNo(String vocationalcertificateNo) {
		this.vocationalcertificateNo = vocationalcertificateNo;
	}

	public String getPersonalpassport() {
		return personalpassport;
	}

	public void setPersonalpassport(String personalpassport) {
		this.personalpassport = personalpassport;
	}

	public String getAdmintitle() {
		return admintitle;
	}

	public void setAdmintitle(String admintitle) {
		this.admintitle = admintitle;
	}

	public String getTeachtitle() {
		return teachtitle;
	}

	public void setTeachtitle(String teachtitle) {
		this.teachtitle = teachtitle;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getTherapeuticrange() {
		return therapeuticrange;
	}

	public void setTherapeuticrange(String therapeuticrange) {
		this.therapeuticrange = therapeuticrange;
	}

	public String getAdept() {
		return adept;
	}

	public void setAdept(String adept) {
		this.adept = adept;
	}

	public Integer getIs_login() {
		return is_login;
	}

	public void setIs_login(Integer is_login) {
		this.is_login = is_login;
	}

	public Date getFirst_login_time() {
		return first_login_time;
	}

	public void setFirst_login_time(Date first_login_time) {
		this.first_login_time = first_login_time;
	}

	public Integer getApplogintimes() {
		return applogintimes;
	}

	public void setApplogintimes(Integer applogintimes) {
		this.applogintimes = applogintimes;
	}

}
