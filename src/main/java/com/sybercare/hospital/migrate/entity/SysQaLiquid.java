package com.sybercare.hospital.migrate.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sys_qa_liquid")
public class SysQaLiquid {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;// bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
	private Long dept_id;// bigint(20) NOT NULL COMMENT '部门id',
	private String liquid_type;// varchar(10) DEFAULT '0' COMMENT '质控液类型(1-高 2-中 3-低)',
	private String liquid_num;// varchar(100) DEFAULT '' COMMENT '质控液批次号',
	private String manufactor;// varchar(100) DEFAULT '' COMMENT '生产厂家',
	private Double max_value;// double DEFAULT NULL COMMENT '最大测量值',
	private Double min_value;// double DEFAULT NULL COMMENT '最小测量值',
	private String status;// char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
	private String create_by;// varchar(64) DEFAULT '' COMMENT '创建者',
	private Date create_time;// datetime DEFAULT NULL COMMENT '创建时间',
	private String update_by;// varchar(64) DEFAULT '' COMMENT '更新者',
	private Date update_time;// datetime DEFAULT NULL COMMENT '更新时间',
	private Date expiredTime;// datetime DEFAULT NULL COMMENT '失效时间',

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public Date getExpiredTime() {
		return expiredTime;
	}

	public void setExpiredTime(Date expiredTime) {
		this.expiredTime = expiredTime;
	}

}
