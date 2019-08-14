package com.sybercare.hospital.migrate.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sys_glucose_advice")
public class SysGlucoseAdvice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;// bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
	private Long patient_id;// bigint(20) NOT NULL COMMENT '患者id',
	private String patient_name;// varchar(64) DEFAULT NULL COMMENT '用户名',
	private String advice_type;// varchar(64) DEFAULT NULL COMMENT '医嘱类型(LongStandards-长期标准时段医嘱
								// LongNotStandards-长期非标准时段医嘱 Temporary-临时医嘱)',
	private String template_name;// varchar(200) DEFAULT '0' COMMENT '模板名称',
	private String advice_name;// varchar(100) DEFAULT NULL COMMENT '医嘱名称',
	private String advice_content;// varchar(500) DEFAULT NULL COMMENT '医嘱内容(json)',
	private Date start_time;// datetime DEFAULT NULL COMMENT '开始时间',
	private Date end_time;// datetime DEFAULT NULL COMMENT '结束时间',
	private String status;// char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
	private String remark;// varchar(500) DEFAULT NULL COMMENT '备注',
	private String create_by;// varchar(64) DEFAULT '' COMMENT '医嘱医生',
	private String create_name;// varchar(30) NOT NULL COMMENT '医生姓名',
	private Date create_time;// datetime DEFAULT NULL COMMENT '创建时间',
	private Date update_time;// datetime DEFAULT NULL COMMENT '更新时间',
	private Long dept_id;// bigint(20) DEFAULT NULL COMMENT '患者部门ID',

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

	public String getPatient_name() {
		return patient_name;
	}

	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}

	public String getAdvice_type() {
		return advice_type;
	}

	public void setAdvice_type(String advice_type) {
		this.advice_type = advice_type;
	}

	public String getTemplate_name() {
		return template_name;
	}

	public void setTemplate_name(String template_name) {
		this.template_name = template_name;
	}

	public String getAdvice_name() {
		return advice_name;
	}

	public void setAdvice_name(String advice_name) {
		this.advice_name = advice_name;
	}

	public String getAdvice_content() {
		return advice_content;
	}

	public void setAdvice_content(String advice_content) {
		this.advice_content = advice_content;
	}

	public Date getStart_time() {
		return start_time;
	}

	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}

	public Date getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getCreate_name() {
		return create_name;
	}

	public void setCreate_name(String create_name) {
		this.create_name = create_name;
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

	public Long getDept_id() {
		return dept_id;
	}

	public void setDept_id(Long dept_id) {
		this.dept_id = dept_id;
	}

}
