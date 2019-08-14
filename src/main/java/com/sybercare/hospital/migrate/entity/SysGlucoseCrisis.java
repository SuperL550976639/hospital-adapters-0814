package com.sybercare.hospital.migrate.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sys_glucose_crisis")
public class SysGlucoseCrisis {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;// bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
	private Long dept_id;// bigint(20) NOT NULL COMMENT '部门id',
	private Double high_value;// double DEFAULT NULL COMMENT '危机高值',
	private String high_color;// varchar(20) DEFAULT '' COMMENT '危机高值颜色',
	private Double low_value;// double DEFAULT NULL COMMENT '危机低值',
	private String low_color;// varchar(20) DEFAULT '' COMMENT '危机低值颜色',
	private String normal_color;// varchar(20) DEFAULT '' COMMENT '正常值颜色',
	private String status;// char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
	private String create_by;// varchar(64) DEFAULT '' COMMENT '创建者',
	private Date create_time;// datetime DEFAULT NULL COMMENT '创建时间',
	private String update_by;// varchar(64) DEFAULT '' COMMENT '更新者',
	private Date update_time;// datetime DEFAULT NULL COMMENT '更新时间',

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

	public Double getHigh_value() {
		return high_value;
	}

	public void setHigh_value(Double high_value) {
		this.high_value = high_value;
	}

	public String getHigh_color() {
		return high_color;
	}

	public void setHigh_color(String high_color) {
		this.high_color = high_color;
	}

	public Double getLow_value() {
		return low_value;
	}

	public void setLow_value(Double low_value) {
		this.low_value = low_value;
	}

	public String getLow_color() {
		return low_color;
	}

	public void setLow_color(String low_color) {
		this.low_color = low_color;
	}

	public String getNormal_color() {
		return normal_color;
	}

	public void setNormal_color(String normal_color) {
		this.normal_color = normal_color;
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

}
