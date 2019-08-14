package com.sybercare.hospital.migrate.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 55097
 *
 */
@Entity
@Table(name = "sys_glucose_period")
public class SysGlucosePeriod {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	private Long dept_id; // bigint(20) NOT NULL COMMENT '部门id',
	private String measure_period; // varchar(64) DEFAULT NULL COMMENT '测量时段(KF-空腹 ZCH-早餐后 WUCQ-午餐前 WUCH-午餐后
									// WACQ-晚餐前 WACH-晚餐后 SQ-睡前LC-凌晨 LC3-凌晨3点 SJ-随机)',
	private String display_name; // varchar(64) DEFAULT '' COMMENT '显示名称',
	private String start_time; // varchar(32) DEFAULT NULL COMMENT '开始时间',
	private String end_time; // varchar(32) DEFAULT NULL COMMENT '结束时间',
	private Double max_value;// double DEFAULT NULL COMMENT '最大测量值',
	private Double min_value; // double DEFAULT NULL COMMENT '最小测量值',
	private String status; // char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
	private String create_by; // varchar(64) DEFAULT '' COMMENT '创建者',
	private Date create_time; // datetime DEFAULT NULL COMMENT '创建时间',
	private String update_by; // varchar(64) DEFAULT '' COMMENT '更新者',
	private Date update_time;// datetime DEFAULT NULL COMMENT '更新时间',
	private String high_Color; // varchar(20) DEFAULT NULL COMMENT '偏高值颜色',
	private String low_Color; // varchar(20) DEFAULT NULL COMMENT '偏低值颜色',

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Long getDept_id() {
		return dept_id;
	}

	public void setDept_id(Long dept_id) {
		this.dept_id = dept_id;
	}

	public String getMeasure_period() {
		return measure_period;
	}

	public void setMeasure_period(String measure_period) {
		this.measure_period = measure_period;
	}

	public String getDisplay_name() {
		return display_name;
	}

	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
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

	public String getHigh_Color() {
		return high_Color;
	}

	public void setHigh_Color(String high_Color) {
		this.high_Color = high_Color;
	}

	public String getLow_Color() {
		return low_Color;
	}

	public void setLow_Color(String low_Color) {
		this.low_Color = low_Color;
	}

}
