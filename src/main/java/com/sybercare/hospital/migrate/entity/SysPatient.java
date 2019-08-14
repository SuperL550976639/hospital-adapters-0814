package com.sybercare.hospital.migrate.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sys_patient")
public class SysPatient {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "patient_id")
	private Long patient_id;// bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
	private String dept_id;// varchar(20) DEFAULT NULL COMMENT '归属部门',
	private String avatar;// varchar(200) DEFAULT NULL COMMENT '头像地址',
	private String login_name;// varchar(30) DEFAULT NULL COMMENT '登录账号',
	private String patient_name;// varchar(64) DEFAULT NULL COMMENT '用户名',
	private String mobile;// varchar(20) DEFAULT NULL COMMENT '手机号',
	private String password;// varchar(64) DEFAULT NULL COMMENT '密码',
	private Date birth;// date DEFAULT NULL COMMENT '出生日期',
	private String sex;// varchar(5) DEFAULT NULL COMMENT '性别(0男 1女 2未知)',
	private String hospitalized_num;// varchar(64) DEFAULT NULL COMMENT '住院号',
	private Date hospitalized_date;// datetime DEFAULT NULL COMMENT '入院日期',
	private Date leave_date;// datetime DEFAULT NULL COMMENT '出院日期',
	private String hospitalized_type;// char(1) DEFAULT '1' COMMENT '住院状态(1 住院 2 出院)',
	private String wristband_code;// varchar(64) DEFAULT NULL COMMENT '腕带码',
	private String bed_num;// varchar(64) DEFAULT NULL COMMENT '床号',
	private Long doctor_id;// bigint(20) DEFAULT NULL COMMENT '住院医生编号',
	private String doctor_name;// varchar(64) DEFAULT NULL COMMENT '医生姓名',
	private String address;// varchar(200) DEFAULT NULL COMMENT '住址',
	private String card_type;// varchar(10) DEFAULT NULL COMMENT '卡类型(1-身份证 2-医保卡 3-就诊卡)',
	private String id_card;// varchar(20) DEFAULT NULL COMMENT '身份证号',
	private String card_num;// varchar(20) DEFAULT NULL COMMENT '医保卡/就诊卡号',
	private String status;// char(1) DEFAULT NULL COMMENT '状态(0-正常 1-禁用)',
	private String login_ip;// varchar(50) DEFAULT '' COMMENT '最后登陆IP',
	private Date login_date;// datetime DEFAULT NULL COMMENT '最后登陆时间',
	private String create_by;// varchar(64) DEFAULT '' COMMENT '创建者',
	private Date create_time;// datetime DEFAULT NULL COMMENT '创建时间',
	private String update_by;// varchar(64) DEFAULT '' COMMENT '更新者',
	private Date update_time;// datetime DEFAULT NULL COMMENT '更新时间',
	private String remark;// varchar(500) DEFAULT '' COMMENT '备注',

	public Long getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(Long patient_id) {
		this.patient_id = patient_id;
	}

	public String getDept_id() {
		return dept_id;
	}

	public void setDept_id(String dept_id) {
		this.dept_id = dept_id;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getLogin_name() {
		return login_name;
	}

	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}

	public String getPatient_name() {
		return patient_name;
	}

	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getHospitalized_num() {
		return hospitalized_num;
	}

	public void setHospitalized_num(String hospitalized_num) {
		this.hospitalized_num = hospitalized_num;
	}

	public Date getHospitalized_date() {
		return hospitalized_date;
	}

	public void setHospitalized_date(Date hospitalized_date) {
		this.hospitalized_date = hospitalized_date;
	}

	public Date getLeave_date() {
		return leave_date;
	}

	public void setLeave_date(Date leave_date) {
		this.leave_date = leave_date;
	}

	public String getHospitalized_type() {
		return hospitalized_type;
	}

	public void setHospitalized_type(String hospitalized_type) {
		this.hospitalized_type = hospitalized_type;
	}

	public String getWristband_code() {
		return wristband_code;
	}

	public void setWristband_code(String wristband_code) {
		this.wristband_code = wristband_code;
	}

	public String getBed_num() {
		return bed_num;
	}

	public void setBed_num(String bed_num) {
		this.bed_num = bed_num;
	}

	public Long getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(Long doctor_id) {
		this.doctor_id = doctor_id;
	}

	public String getDoctor_name() {
		return doctor_name;
	}

	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCard_type() {
		return card_type;
	}

	public void setCard_type(String card_type) {
		this.card_type = card_type;
	}

	public String getId_card() {
		return id_card;
	}

	public void setId_card(String id_card) {
		this.id_card = id_card;
	}

	public String getCard_num() {
		return card_num;
	}

	public void setCard_num(String card_num) {
		this.card_num = card_num;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLogin_ip() {
		return login_ip;
	}

	public void setLogin_ip(String login_ip) {
		this.login_ip = login_ip;
	}

	public Date getLogin_date() {
		return login_date;
	}

	public void setLogin_date(Date login_date) {
		this.login_date = login_date;
	}

	public String getCreate_by() {
		return create_by;
	}

	public void setCreate_by(String create_by) {
		this.create_by = create_by;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public String getUpdate_by() {
		return update_by;
	}

	public void setUpdate_by(String update_by) {
		this.update_by = update_by;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "NewPatient [patient_id=" + patient_id + ", dept_id=" + dept_id + ", avatar=" + avatar + ", login_name="
				+ login_name + ", patient_name=" + patient_name + ", mobile=" + mobile + ", password=" + password
				+ ", birth=" + birth + ", sex=" + sex + ", hospitalized_num=" + hospitalized_num
				+ ", hospitalized_date=" + hospitalized_date + ", leave_date=" + leave_date + ", hospitalized_type="
				+ hospitalized_type + ", wristband_code=" + wristband_code + ", bed_num=" + bed_num + ", doctor_id="
				+ doctor_id + ", doctor_name=" + doctor_name + ", address=" + address + ", card_type=" + card_type
				+ ", id_card=" + id_card + ", card_num=" + card_num + ", status=" + status + ", login_ip=" + login_ip
				+ ", login_date=" + login_date + ", create_by=" + create_by + ", create_time=" + create_time
				+ ", update_by=" + update_by + ", update_time=" + update_time + ", remark=" + remark
				+ ", getPatient_id()=" + getPatient_id() + ", getDept_id()=" + getDept_id() + ", getAvatar()="
				+ getAvatar() + ", getLogin_name()=" + getLogin_name() + ", getPatient_name()=" + getPatient_name()
				+ ", getMobile()=" + getMobile() + ", getPassword()=" + getPassword() + ", getBirth()=" + getBirth()
				+ ", getSex()=" + getSex() + ", getHospitalized_num()=" + getHospitalized_num()
				+ ", getHospitalized_date()=" + getHospitalized_date() + ", getLeave_date()=" + getLeave_date()
				+ ", getHospitalized_type()=" + getHospitalized_type() + ", getWristband_code()=" + getWristband_code()
				+ ", getBed_num()=" + getBed_num() + ", getDoctor_id()=" + getDoctor_id() + ", getDoctor_name()="
				+ getDoctor_name() + ", getAddress()=" + getAddress() + ", getCard_type()=" + getCard_type()
				+ ", getId_card()=" + getId_card() + ", getCard_num()=" + getCard_num() + ", getStatus()=" + getStatus()
				+ ", getLogin_ip()=" + getLogin_ip() + ", getLogin_date()=" + getLogin_date() + ", getCreate_by()="
				+ getCreate_by() + ", getCreate_time()=" + getCreate_time() + ", getUpdate_by()=" + getUpdate_by()
				+ ", getUpdate_time()=" + getUpdate_time() + ", getRemark()=" + getRemark() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
