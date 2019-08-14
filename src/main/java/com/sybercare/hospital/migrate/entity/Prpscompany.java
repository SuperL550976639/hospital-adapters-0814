package com.sybercare.hospital.migrate.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "prpscompany")
public class Prpscompany {
	@Id
	@Column(name = "comcode")
	private String comcode;// varchar(50) NOT NULL COMMENT '机构代码',
	private String comcname;// varchar(60) NOT NULL COMMENT '机构中文名称',
	private String hiscode;// varchar(50) DEFAULT NULL,
	private String comename;// varchar(80) DEFAULT NULL COMMENT '机构英文名称',
	private String addresscname;// varchar(200) DEFAULT NULL COMMENT '地址中文名称',
	private String addressename;// varchar(80) DEFAULT NULL COMMENT '地址英文名称',
	private String country;// varchar(80) DEFAULT NULL COMMENT '所属国家',
	private String province;// varchar(60) DEFAULT NULL COMMENT '所属省份',
	private String city;// varchar(60) DEFAULT NULL COMMENT '所属城市',
	private String postcode;// varchar(6) DEFAULT NULL COMMENT '邮编',
	private String phone;// varchar(30) DEFAULT NULL COMMENT '电话',
	private String tel;// varchar(30) DEFAULT NULL COMMENT '手机',
	private String fax;// varchar(20) DEFAULT NULL COMMENT '传真',
	private String leader;// varchar(30) DEFAULT NULL COMMENT '负责人',
	private Date createdate;// datetime DEFAULT NULL COMMENT '成立日期',
	private String uppercomcode;// varchar(30) DEFAULT NULL COMMENT '上级机构代码',
	private String comtype;// varchar(10) DEFAULT NULL COMMENT '机构类型',
	private String comlevel;// varchar(1) DEFAULT NULL COMMENT '机构等级 3--病区 4--病房',
	private String licencecomcode;// varchar(20) DEFAULT NULL COMMENT '许可证机构编号',
	private String commerinstrumentno;// varchar(40) DEFAULT NULL COMMENT '营业执照注册号',
	private String organizationno;// varchar(20) DEFAULT NULL COMMENT '组织机构编码',
	private String taxregistno;// varchar(20) DEFAULT NULL COMMENT '税务登记证号',
	private String permitno;// varchar(20) DEFAULT NULL COMMENT '开户许可证编号',
	private String bank;// varchar(120) DEFAULT NULL COMMENT '开户行',
	private String account;// varchar(60) DEFAULT NULL COMMENT '银行账号',
	private String e_mail;// varchar(60) DEFAULT NULL COMMENT 'e_mail地址',
	private String microblog;// varchar(60) DEFAULT NULL COMMENT '微博地址',
	private String wechat;// varchar(60) DEFAULT NULL COMMENT '微信地址',
	private String remark;// text COMMENT '备注',
	private String validstatus;// varchar(1) NOT NULL COMMENT '有效状态',
	private String centerflag;// varchar(1) DEFAULT NULL COMMENT '核算单位标志',
	private String flag;// varchar(2) DEFAULT NULL COMMENT '标志位',
	private String applytype;// varchar(2) DEFAULT NULL COMMENT '申请类型1：新增 2：修改',
	private String verifystatus;// varchar(2) DEFAULT NULL COMMENT '审核状态 0-初始状态,9-待审核,1-审核通过,2-审核不通过',
	private String verifycode;// varchar(30) DEFAULT NULL COMMENT '审核人',
	private Date verifydate;// datetime DEFAULT NULL COMMENT '审核时间',
	private String reviews;// varchar(255) DEFAULT NULL COMMENT '审核意见',
	private String updatecode;// varchar(30) DEFAULT NULL COMMENT '修改人',
	private Date updatedate;// timestamp NULL DEFAULT NULL COMMENT '修改时间',
	private String logo;// varchar(200) DEFAULT NULL COMMENT '总公司机构logo路径',
	private Integer is_chronic_disease;// tinyint(2) DEFAULT NULL COMMENT '0-非慢病机构 1-慢病机构',
	private String treat_type;// varchar(200) DEFAULT NULL COMMENT '治疗类型',
	private String comcode_mode;// tinyint(4) DEFAULT NULL COMMENT '机构模式 0-药店模式 1-慢病模式',
	private String comcode_url;// varchar(1000) DEFAULT NULL COMMENT '机构URL',
	private String good_at_area;// text COMMENT '机构擅长领域',
	private String sort;// varchar(50) DEFAULT NULL COMMENT '机构排序',
	private String activate_msg;// varchar(200) DEFAULT NULL COMMENT '激活信息',

	public String getComcode() {
		return comcode;
	}

	public void setComcode(String comcode) {
		this.comcode = comcode;
	}

	public String getComcname() {
		return comcname;
	}

	public void setComcname(String comcname) {
		this.comcname = comcname;
	}

	public String getHiscode() {
		return hiscode;
	}

	public void setHiscode(String hiscode) {
		this.hiscode = hiscode;
	}

	public String getComename() {
		return comename;
	}

	public void setComename(String comename) {
		this.comename = comename;
	}

	public String getAddresscname() {
		return addresscname;
	}

	public void setAddresscname(String addresscname) {
		this.addresscname = addresscname;
	}

	public String getAddressename() {
		return addressename;
	}

	public void setAddressename(String addressename) {
		this.addressename = addressename;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getUppercomcode() {
		return uppercomcode;
	}

	public void setUppercomcode(String uppercomcode) {
		this.uppercomcode = uppercomcode;
	}

	public String getComtype() {
		return comtype;
	}

	public void setComtype(String comtype) {
		this.comtype = comtype;
	}

	public String getComlevel() {
		return comlevel;
	}

	public void setComlevel(String comlevel) {
		this.comlevel = comlevel;
	}

	public String getLicencecomcode() {
		return licencecomcode;
	}

	public void setLicencecomcode(String licencecomcode) {
		this.licencecomcode = licencecomcode;
	}

	public String getCommerinstrumentno() {
		return commerinstrumentno;
	}

	public void setCommerinstrumentno(String commerinstrumentno) {
		this.commerinstrumentno = commerinstrumentno;
	}

	public String getOrganizationno() {
		return organizationno;
	}

	public void setOrganizationno(String organizationno) {
		this.organizationno = organizationno;
	}

	public String getTaxregistno() {
		return taxregistno;
	}

	public void setTaxregistno(String taxregistno) {
		this.taxregistno = taxregistno;
	}

	public String getPermitno() {
		return permitno;
	}

	public void setPermitno(String permitno) {
		this.permitno = permitno;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getValidstatus() {
		return validstatus;
	}

	public void setValidstatus(String validstatus) {
		this.validstatus = validstatus;
	}

	public String getCenterflag() {
		return centerflag;
	}

	public void setCenterflag(String centerflag) {
		this.centerflag = centerflag;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getApplytype() {
		return applytype;
	}

	public void setApplytype(String applytype) {
		this.applytype = applytype;
	}

	public String getVerifystatus() {
		return verifystatus;
	}

	public void setVerifystatus(String verifystatus) {
		this.verifystatus = verifystatus;
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

	public String getReviews() {
		return reviews;
	}

	public void setReviews(String reviews) {
		this.reviews = reviews;
	}

	public String getUpdatecode() {
		return updatecode;
	}

	public void setUpdatecode(String updatecode) {
		this.updatecode = updatecode;
	}

	public Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Integer getIs_chronic_disease() {
		return is_chronic_disease;
	}

	public void setIs_chronic_disease(Integer is_chronic_disease) {
		this.is_chronic_disease = is_chronic_disease;
	}

	public String getTreat_type() {
		return treat_type;
	}

	public void setTreat_type(String treat_type) {
		this.treat_type = treat_type;
	}

	public String getComcode_mode() {
		return comcode_mode;
	}

	public void setComcode_mode(String comcode_mode) {
		this.comcode_mode = comcode_mode;
	}

	public String getComcode_url() {
		return comcode_url;
	}

	public void setComcode_url(String comcode_url) {
		this.comcode_url = comcode_url;
	}

	public String getGood_at_area() {
		return good_at_area;
	}

	public void setGood_at_area(String good_at_area) {
		this.good_at_area = good_at_area;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getActivate_msg() {
		return activate_msg;
	}

	public void setActivate_msg(String activate_msg) {
		this.activate_msg = activate_msg;
	}

}
