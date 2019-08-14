package com.sybercare.hospital.migrate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_patient")
public class UserPatient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;// int(11) NOT NULL AUTO_INCREMENT COMMENT '患者信息id',
	private String user_id;// varchar(50) NOT NULL,
	private String in_hospital_status;// varchar(1) DEFAULT NULL COMMENT '住院状态 0---住院 1--已出院',
	private String department;// varchar(50) DEFAULT NULL COMMENT '科室',
	private String ward_area;// varchar(50) DEFAULT NULL COMMENT '病区',
	private String ward_no;// varchar(50) DEFAULT NULL COMMENT '病房',
	private String bed_number;// varchar(50) DEFAULT NULL COMMENT '床号',
	private String card_number;// varchar(50) DEFAULT NULL,
	private String is_health_insurance;// varchar(1) DEFAULT NULL COMMENT '会否医保 0--是 1---否',
	private String health_insurance_number;// varchar(50) DEFAULT NULL COMMENT '医保号',
	private String qr_code;// varchar(200) DEFAULT NULL COMMENT '二维码图片',
	private String medication_type;// varchar(1) DEFAULT '' COMMENT '用药类型 0--无 1--口服 2--胰岛素 ',
	private String health_care_type;// varchar(50) DEFAULT NULL COMMENT '医保类型',
	private Integer hospital_times;// int(11) DEFAULT NULL COMMENT '住院次数',
	private String in_hospital_id;// varchar(50) DEFAULT NULL,
	private String create_time;// varchar(19) DEFAULT NULL COMMENT '创建时间',
	private String hospital_date;// varchar(19) DEFAULT NULL COMMENT '入院时间',
	private String discharge_date;// varchar(19) DEFAULT NULL COMMENT '出院时间',
	private String infant_id;// varchar(20) DEFAULT NULL COMMENT '婴儿ID',

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getIn_hospital_status() {
		return in_hospital_status;
	}

	public void setIn_hospital_status(String in_hospital_status) {
		this.in_hospital_status = in_hospital_status;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getWard_area() {
		return ward_area;
	}

	public void setWard_area(String ward_area) {
		this.ward_area = ward_area;
	}

	public String getWard_no() {
		return ward_no;
	}

	public void setWard_no(String ward_no) {
		this.ward_no = ward_no;
	}

	public String getBed_number() {
		return bed_number;
	}

	public void setBed_number(String bed_number) {
		this.bed_number = bed_number;
	}

	public String getCard_number() {
		return card_number;
	}

	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}

	public String getIs_health_insurance() {
		return is_health_insurance;
	}

	public void setIs_health_insurance(String is_health_insurance) {
		this.is_health_insurance = is_health_insurance;
	}

	public String getHealth_insurance_number() {
		return health_insurance_number;
	}

	public void setHealth_insurance_number(String health_insurance_number) {
		this.health_insurance_number = health_insurance_number;
	}

	public String getQr_code() {
		return qr_code;
	}

	public void setQr_code(String qr_code) {
		this.qr_code = qr_code;
	}

	public String getMedication_type() {
		return medication_type;
	}

	public void setMedication_type(String medication_type) {
		this.medication_type = medication_type;
	}

	public String getHealth_care_type() {
		return health_care_type;
	}

	public void setHealth_care_type(String health_care_type) {
		this.health_care_type = health_care_type;
	}

	public Integer getHospital_times() {
		return hospital_times;
	}

	public void setHospital_times(Integer hospital_times) {
		this.hospital_times = hospital_times;
	}

	public String getIn_hospital_id() {
		return in_hospital_id;
	}

	public void setIn_hospital_id(String in_hospital_id) {
		this.in_hospital_id = in_hospital_id;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public String getHospital_date() {
		return hospital_date;
	}

	public void setHospital_date(String hospital_date) {
		this.hospital_date = hospital_date;
	}

	public String getDischarge_date() {
		return discharge_date;
	}

	public void setDischarge_date(String discharge_date) {
		this.discharge_date = discharge_date;
	}

	public String getInfant_id() {
		return infant_id;
	}

	public void setInfant_id(String infant_id) {
		this.infant_id = infant_id;
	}

}
