package com.sybercare.hospital.migrate.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sys_blood_glucose")
public class SysBloodGlucose {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id; // bigint(20) NOT NULL AUTO_INCREMENT COMMENT 主键id,
	private Long patient_id; // bigint(20) NOT NULL COMMENT 患者id,
	private String name; // varchar(64) DEFAULT NULL COMMENT 患者姓名,
	private String measure_period; // varchar(64) DEFAULT NULL COMMENT 测量时段(KF-空腹 ZCH-早餐后 WUCQ-午餐前 WUCH-午餐后
									// WACQ-晚餐前 WACH-晚餐后 SQ-睡前LC-凌晨 LC3-凌晨3点 SJ-随机),
	private Date measure_time; // datetime DEFAULT NULL COMMENT 测量时间,
	private Double meature_value; // double DEFAULT NULL COMMENT 测量值,
	private String equipment_sn; // varchar(50) DEFAULT NULL COMMENT 测量设备编号,
	private String status; // char(1) DEFAULT 0 COMMENT 状态（0正常 1停用）,
	private String data_source; // varchar(2) DEFAULT NULL COMMENT 数据来源(0移动端录入1管理后台录入 2设备上传),
	private String measure_status; // varchar(20) DEFAULT NULL COMMENT 测量状态（Normal-正常血压 NormalHigh-正常高值 High1-一级高血压
									// High2-二级高血压 High3-三级高血压）,
	private String abnormal_result; // varchar(20) DEFAULT NULL COMMENT 异常结果(),
	private String remark; // varchar(500) DEFAULT NULL COMMENT 备注,
	private String create_by; // varchar(64) DEFAULT COMMENT 创建者,
	private Date create_time; // datetime DEFAULT NULL COMMENT 创建时间,
	private String update_by; // varchar(64) DEFAULT COMMENT 更新者,
	private Date update_time; // datetime DEFAULT NULL COMMENT 更新时间,
	private Long dept_id; // bigint(20) DEFAULT NULL COMMENT 部门id,
	private String other_remark; // varchar(200) DEFAULT NULL COMMENT 其他原因,
	private String color; // varchar(20) DEFAULT NULL COMMENT 测量颜色,

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMeasure_period() {
		return measure_period;
	}

	public void setMeasure_period(String measure_period) {
		this.measure_period = measure_period;
	}

	public Date getMeasure_time() {
		return measure_time;
	}

	public void setMeasure_time(Date measure_time) {
		this.measure_time = measure_time;
	}

	public Double getMeature_value() {
		return meature_value;
	}

	public void setMeature_value(Double meature_value) {
		this.meature_value = meature_value;
	}

	public String getEquipment_sn() {
		return equipment_sn;
	}

	public void setEquipment_sn(String equipment_sn) {
		this.equipment_sn = equipment_sn;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getData_source() {
		return data_source;
	}

	public void setData_source(String data_source) {
		this.data_source = data_source;
	}

	public String getMeasure_status() {
		return measure_status;
	}

	public void setMeasure_status(String measure_status) {
		this.measure_status = measure_status;
	}

	public String getAbnormal_result() {
		return abnormal_result;
	}

	public void setAbnormal_result(String abnormal_result) {
		this.abnormal_result = abnormal_result;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(Long patient_id) {
		this.patient_id = patient_id;
	}

	public Long getDept_id() {
		return dept_id;
	}

	public void setDept_id(Long dept_id) {
		this.dept_id = dept_id;
	}

	public String getOther_remark() {
		return other_remark;
	}

	public void setOther_remark(String other_remark) {
		this.other_remark = other_remark;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
