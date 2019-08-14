package com.sybercare.hospital.migrate.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	@Column(name = "user_id")
	private String user_id;// varchar(50) NOT NULL COMMENT '用户ID',
	private String username;// varchar(50) DEFAULT NULL COMMENT '用户名',
	private String nickname;// varchar(20) DEFAULT NULL COMMENT '昵称',
	private String password;// varchar(200) DEFAULT NULL COMMENT '密码',
	private String email;// varchar(50) DEFAULT NULL COMMENT '邮箱',
	private String phone;// varchar(20) DEFAULT NULL COMMENT '手机',
	private String avatar;// varchar(200) DEFAULT NULL COMMENT '头像（路径）',
	private String name;// varchar(20) DEFAULT NULL COMMENT '姓名',
	private String identify_card;// varchar(18) DEFAULT NULL COMMENT '身份证号',
	private Integer gender;// tinyint(2) DEFAULT NULL COMMENT '性别',
	private String nation;// varchar(50) DEFAULT NULL COMMENT '民族',
	private String birth;// varchar(50) DEFAULT '2016-09-23' COMMENT '出生日期',
	private String address;// varchar(500) DEFAULT NULL COMMENT '通讯地址',
	private Integer status;// tinyint(4) DEFAULT NULL COMMENT '用户状态',
	private Date create_time;// datetime DEFAULT NULL COMMENT '注册时间',
	private Date update_time;// datetime DEFAULT NULL COMMENT '更新时间',
	private String is_Medical_Insurance;// varchar(1) DEFAULT '' COMMENT '是否医保',
	private String glucose_disease_Type;// varchar(20) DEFAULT '' COMMENT '疾病类型',
	private String contact_Person;// varchar(50) DEFAULT NULL COMMENT '紧急联系人',
	private String contact_person_phone;// varchar(50) DEFAULT NULL COMMENT '紧急联系人电话',
	private String view_comcode;// varchar(50) DEFAULT NULL COMMENT '当前查看的机构',
	private String servicePersonId;// varchar(30) DEFAULT NULL COMMENT '服务人员代码',
	private String bloodType;// varchar(2) DEFAULT NULL COMMENT 'A-A,B-B,AB-AB,O-O,OT-不详',
	private String familyhistory;// varchar(500) DEFAULT NULL COMMENT '家族史',
	private Date first_visit_date;// date DEFAULT NULL COMMENT '初诊日期',
	private String verifymsg;// varchar(10) DEFAULT NULL COMMENT '短信码',
	private String verifytime;// varchar(19) DEFAULT NULL COMMENT '验证码获取时间',
	private String countryCode;// varchar(10) DEFAULT NULL COMMENT '国家码',
	private String stamp_time;// varchar(19) DEFAULT NULL COMMENT '时间戳',
	private String source_comcode;// varchar(50) DEFAULT NULL COMMENT '用户来源机构',
	private String telephone;// varchar(20) DEFAULT NULL,
	private String card_number;// varchar(50) DEFAULT NULL COMMENT '住院号',
	private Double waist;// double DEFAULT NULL,
	private Integer degree;// tinyint(2) DEFAULT NULL COMMENT
							// '1-文盲及半文盲，2-小学，3-初中，4-高中/技校/中专，5-大学专科及以上，0不详',
	private String profession;// varchar(200) DEFAULT NULL,
	private Integer pregnancy_status;// tinyint(2) DEFAULT NULL COMMENT '0-“未孕”、1-“计划妊娠”、2-“妊娠”、3-“哺乳”',
	private Date delivery_time;// datetime DEFAULT NULL,
	private String chronic_disease;// varchar(500) DEFAULT NULL,
	private String chronic_disease_other;// varchar(500) DEFAULT NULL,
	private String rule_family_history;// varchar(200) DEFAULT NULL,
	private String remark;// varchar(500) DEFAULT NULL,
	private String rule_drug_contraindication;// varchar(200) DEFAULT NULL COMMENT '规则药物禁忌症',
	private String other_drug_contraindication;// varchar(500) DEFAULT NULL COMMENT '其他药物禁忌症',
	private String account;// varchar(50) DEFAULT NULL COMMENT '账号',
	private Integer is_chronic_disease;// tinyint(1) DEFAULT NULL COMMENT '是否慢病会员 0-否 1-是',
	private Integer milk_powder;// tinyint(4) DEFAULT NULL COMMENT '是否奶粉会员 0-否 1-是',
	private String milk_powder_date;// varchar(19) DEFAULT NULL COMMENT '奶粉建档时间',
	private Integer health_protection_user;// tinyint(4) DEFAULT NULL COMMENT '是否保健品会员 0-否 1-是 9-不详',
	private String health_protection_date;// varchar(19) DEFAULT NULL COMMENT '保健品会员建档时间',
	private String user_type;// varchar(10) DEFAULT NULL COMMENT '会员类型',
	private String diagnose;// varchar(500) DEFAULT NULL COMMENT '疾病诊断',
	private Double survival_period;// double DEFAULT NULL COMMENT '生存期',
	private Integer first_login;// tinyint(2) DEFAULT NULL COMMENT '0-未登陆过 1-已登陆过',
	private Date first_login_time;// datetime DEFAULT NULL COMMENT '会员首页登录时间',
	private Float data_integrity;// float DEFAULT NULL COMMENT '资料完整度',
	private Date cataloging_date;// datetime DEFAULT NULL COMMENT '建档时间',
	private Integer liveness;// tinyint(2) DEFAULT NULL COMMENT '活跃度，0-不活跃，1-活跃',
	private Integer attention_type;// tinyint(2) DEFAULT NULL COMMENT '关注类型 0-普通会员 1-关注会员 2-vip会员',
	private String memberIntegral;// varchar(300) DEFAULT NULL COMMENT '会员积分',
	private Date cardTime;// datetime DEFAULT NULL COMMENT '办卡时间',
	private Integer integral;// int(11) DEFAULT NULL COMMENT '会员活跃度积分',
	private Integer is_high_blood_pressure;// tinyint(4) DEFAULT '4' COMMENT '高血压类型：9：不详；0：不是高血压；1：是高血压；4：正常',
	private Integer age;// int(4) DEFAULT NULL COMMENT '年龄',
	private Float HbAlc;// float(11,2) DEFAULT NULL COMMENT '入院糖化血红蛋白',
	private Double height;// double(11,4) DEFAULT NULL COMMENT '身高',
	private Double weight;// double(11,4) DEFAULT NULL COMMENT '体重',
	private String doctor_name;// varchar(20) DEFAULT NULL COMMENT '主治医生姓名',
	private String in_hospital_id;// varchar(50) DEFAULT NULL,
	private String province;// varchar(50) DEFAULT NULL COMMENT '籍贯',
	private String contact_person_relation;// varchar(50) DEFAULT NULL COMMENT '紧急联系人关系',
	private Date etl_time;// datetime DEFAULT NULL COMMENT '向院外同步时间',
	private String wrist_band_code;// varchar(50) DEFAULT NULL COMMENT '腕带打印二维码中的信息',

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdentify_card() {
		return identify_card;
	}

	public void setIdentify_card(String identify_card) {
		this.identify_card = identify_card;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	public String getIs_Medical_Insurance() {
		return is_Medical_Insurance;
	}

	public void setIs_Medical_Insurance(String is_Medical_Insurance) {
		this.is_Medical_Insurance = is_Medical_Insurance;
	}

	public String getGlucose_disease_Type() {
		return glucose_disease_Type;
	}

	public void setGlucose_disease_Type(String glucose_disease_Type) {
		this.glucose_disease_Type = glucose_disease_Type;
	}

	public String getContact_Person() {
		return contact_Person;
	}

	public void setContact_Person(String contact_Person) {
		this.contact_Person = contact_Person;
	}

	public String getContact_person_phone() {
		return contact_person_phone;
	}

	public void setContact_person_phone(String contact_person_phone) {
		this.contact_person_phone = contact_person_phone;
	}

	public String getView_comcode() {
		return view_comcode;
	}

	public void setView_comcode(String view_comcode) {
		this.view_comcode = view_comcode;
	}

	public String getServicePersonId() {
		return servicePersonId;
	}

	public void setServicePersonId(String servicePersonId) {
		this.servicePersonId = servicePersonId;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public String getFamilyhistory() {
		return familyhistory;
	}

	public void setFamilyhistory(String familyhistory) {
		this.familyhistory = familyhistory;
	}

	public Date getFirst_visit_date() {
		return first_visit_date;
	}

	public void setFirst_visit_date(Date first_visit_date) {
		this.first_visit_date = first_visit_date;
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

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getStamp_time() {
		return stamp_time;
	}

	public void setStamp_time(String stamp_time) {
		this.stamp_time = stamp_time;
	}

	public String getSource_comcode() {
		return source_comcode;
	}

	public void setSource_comcode(String source_comcode) {
		this.source_comcode = source_comcode;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getCard_number() {
		return card_number;
	}

	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}

	public Double getWaist() {
		return waist;
	}

	public void setWaist(Double waist) {
		this.waist = waist;
	}

	public Integer getDegree() {
		return degree;
	}

	public void setDegree(Integer degree) {
		this.degree = degree;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public Integer getPregnancy_status() {
		return pregnancy_status;
	}

	public void setPregnancy_status(Integer pregnancy_status) {
		this.pregnancy_status = pregnancy_status;
	}

	public Date getDelivery_time() {
		return delivery_time;
	}

	public void setDelivery_time(Date delivery_time) {
		this.delivery_time = delivery_time;
	}

	public String getChronic_disease() {
		return chronic_disease;
	}

	public void setChronic_disease(String chronic_disease) {
		this.chronic_disease = chronic_disease;
	}

	public String getChronic_disease_other() {
		return chronic_disease_other;
	}

	public void setChronic_disease_other(String chronic_disease_other) {
		this.chronic_disease_other = chronic_disease_other;
	}

	public String getRule_family_history() {
		return rule_family_history;
	}

	public void setRule_family_history(String rule_family_history) {
		this.rule_family_history = rule_family_history;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRule_drug_contraindication() {
		return rule_drug_contraindication;
	}

	public void setRule_drug_contraindication(String rule_drug_contraindication) {
		this.rule_drug_contraindication = rule_drug_contraindication;
	}

	public String getOther_drug_contraindication() {
		return other_drug_contraindication;
	}

	public void setOther_drug_contraindication(String other_drug_contraindication) {
		this.other_drug_contraindication = other_drug_contraindication;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Integer getIs_chronic_disease() {
		return is_chronic_disease;
	}

	public void setIs_chronic_disease(Integer is_chronic_disease) {
		this.is_chronic_disease = is_chronic_disease;
	}

	public Integer getMilk_powder() {
		return milk_powder;
	}

	public void setMilk_powder(Integer milk_powder) {
		this.milk_powder = milk_powder;
	}

	public String getMilk_powder_date() {
		return milk_powder_date;
	}

	public void setMilk_powder_date(String milk_powder_date) {
		this.milk_powder_date = milk_powder_date;
	}

	public Integer getHealth_protection_user() {
		return health_protection_user;
	}

	public void setHealth_protection_user(Integer health_protection_user) {
		this.health_protection_user = health_protection_user;
	}

	public String getHealth_protection_date() {
		return health_protection_date;
	}

	public void setHealth_protection_date(String health_protection_date) {
		this.health_protection_date = health_protection_date;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	public String getDiagnose() {
		return diagnose;
	}

	public void setDiagnose(String diagnose) {
		this.diagnose = diagnose;
	}

	public Double getSurvival_period() {
		return survival_period;
	}

	public void setSurvival_period(Double survival_period) {
		this.survival_period = survival_period;
	}

	public Integer getFirst_login() {
		return first_login;
	}

	public void setFirst_login(Integer first_login) {
		this.first_login = first_login;
	}

	public Date getFirst_login_time() {
		return first_login_time;
	}

	public void setFirst_login_time(Date first_login_time) {
		this.first_login_time = first_login_time;
	}

	public Float getData_integrity() {
		return data_integrity;
	}

	public void setData_integrity(Float data_integrity) {
		this.data_integrity = data_integrity;
	}

	public Date getCataloging_date() {
		return cataloging_date;
	}

	public void setCataloging_date(Date cataloging_date) {
		this.cataloging_date = cataloging_date;
	}

	public Integer getLiveness() {
		return liveness;
	}

	public void setLiveness(Integer liveness) {
		this.liveness = liveness;
	}

	public Integer getAttention_type() {
		return attention_type;
	}

	public void setAttention_type(Integer attention_type) {
		this.attention_type = attention_type;
	}

	public String getMemberIntegral() {
		return memberIntegral;
	}

	public void setMemberIntegral(String memberIntegral) {
		this.memberIntegral = memberIntegral;
	}

	public Date getCardTime() {
		return cardTime;
	}

	public void setCardTime(Date cardTime) {
		this.cardTime = cardTime;
	}

	public Integer getIntegral() {
		return integral;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}

	public Integer getIs_high_blood_pressure() {
		return is_high_blood_pressure;
	}

	public void setIs_high_blood_pressure(Integer is_high_blood_pressure) {
		this.is_high_blood_pressure = is_high_blood_pressure;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Float getHbAlc() {
		return HbAlc;
	}

	public void setHbAlc(Float hbAlc) {
		HbAlc = hbAlc;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getDoctor_name() {
		return doctor_name;
	}

	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}

	public String getIn_hospital_id() {
		return in_hospital_id;
	}

	public void setIn_hospital_id(String in_hospital_id) {
		this.in_hospital_id = in_hospital_id;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getContact_person_relation() {
		return contact_person_relation;
	}

	public void setContact_person_relation(String contact_person_relation) {
		this.contact_person_relation = contact_person_relation;
	}

	public Date getEtl_time() {
		return etl_time;
	}

	public void setEtl_time(Date etl_time) {
		this.etl_time = etl_time;
	}

	public String getWrist_band_code() {
		return wrist_band_code;
	}

	public void setWrist_band_code(String wrist_band_code) {
		this.wrist_band_code = wrist_band_code;
	}

}
