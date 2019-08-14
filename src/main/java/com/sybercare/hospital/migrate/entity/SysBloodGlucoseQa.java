package com.sybercare.hospital.migrate.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sys_blood_glucose_qa")
public class SysBloodGlucoseQa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;// bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
	private Long dept_id;// bigint(20) NOT NULL COMMENT '部门id',
	private String equipment_sn;// varchar(50) DEFAULT NULL COMMENT '质控设备编号',
	private String liquid_type;// varchar(10) DEFAULT '1' COMMENT '质控液类型(1-高 2-中 3-低)',
	private String liquid_num;// varchar(100) DEFAULT '' COMMENT '质控液批次号',
	private String manufactor;// varchar(100) DEFAULT '' COMMENT '生产厂家',
	private Double max_value;// double DEFAULT NULL COMMENT '最大测量值',
	private Double min_value;// double DEFAULT NULL COMMENT '最小测量值',
	private Date liquid_date;// datetime DEFAULT NULL COMMENT '质控液有效期',
	private Date qa_time;// datetime DEFAULT NULL COMMENT '质控时间',
	private Double qa_value;// double DEFAULT NULL COMMENT '质控值',
	private String test_paper_num;// varchar(100) DEFAULT '' COMMENT '试纸批次号',
	private Date test_paper_date;// datetime DEFAULT NULL COMMENT '试纸有效期',
	private String qa_result;// char(1) DEFAULT '0' COMMENT '质控结果（0合格 1不合格 2 未质控）',
	private String create_by;// varchar(64) DEFAULT '' COMMENT '执行人',
	private String create_name;// varchar(30) NOT NULL COMMENT '执行人姓名',
	private Date create_time;// datetime DEFAULT NULL COMMENT '创建时间',
	private Date update_time;// datetime DEFAULT NULL COMMENT '更新时间',
	private String remark;// varchar(500) DEFAULT NULL COMMENT '备注',

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDept_id() {
		return dept_id;
	}

	public void setDept_id(Long dept_id) {
		this.dept_id = dept_id;
	}

	public String getEquipment_sn() {
		return equipment_sn;
	}

	public void setEquipment_sn(String equipment_sn) {
		this.equipment_sn = equipment_sn;
	}

	public String getLiquid_type() {
		return liquid_type;
	}

	public void setLiquid_type(String liquid_type) {
		this.liquid_type = liquid_type;
	}

	public String getLiquid_num() {
		return liquid_num;
	}

	public void setLiquid_num(String liquid_num) {
		this.liquid_num = liquid_num;
	}

	public String getManufactor() {
		return manufactor;
	}

	public void setManufactor(String manufactor) {
		this.manufactor = manufactor;
	}

	public Double getMax_value() {
		return max_value;
	}

	public void setMax_value(Double max_value) {
		this.max_value = max_value;
	}

	public Double getMin_value() {
		return min_value;
	}

	public void setMin_value(Double min_value) {
		this.min_value = min_value;
	}

	public Date getLiquid_date() {
		return liquid_date;
	}

	public void setLiquid_date(Date liquid_date) {
		this.liquid_date = liquid_date;
	}

	public Date getQa_time() {
		return qa_time;
	}

	public void setQa_time(Date qa_time) {
		this.qa_time = qa_time;
	}

	public Double getQa_value() {
		return qa_value;
	}

	public void setQa_value(Double qa_value) {
		this.qa_value = qa_value;
	}

	public String getTest_paper_num() {
		return test_paper_num;
	}

	public void setTest_paper_num(String test_paper_num) {
		this.test_paper_num = test_paper_num;
	}

	public Date getTest_paper_date() {
		return test_paper_date;
	}

	public void setTest_paper_date(Date test_paper_date) {
		this.test_paper_date = test_paper_date;
	}

	public String getQa_result() {
		return qa_result;
	}

	public void setQa_result(String qa_result) {
		this.qa_result = qa_result;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
