package com.sybercare.hospital.migrate.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "monitor_scheme")
public class MonitorScheme {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "monitor_scheme_id")
	private Long monitor_scheme_id;// bigint(20) NOT NULL AUTO_INCREMENT COMMENT '监测方案ID',
	private String monitor_scheme_name;// varchar(100) DEFAULT NULL COMMENT '监测方案名称',
	private String monitor_scheme_content;// varchar(100) DEFAULT NULL COMMENT '监测方案描述',
	private String user_id;// varchar(50) DEFAULT NULL COMMENT '用户ID',
	private String person_id;// varchar(30) DEFAULT NULL COMMENT '创建者编号',
	private String doctor_id;// varchar(30) DEFAULT NULL COMMENT '医生ID',
	private Date record_date;// datetime DEFAULT NULL COMMENT '方案日期',
	private String stamp_time;// varchar(19) DEFAULT NULL COMMENT '时间戳',
	private Integer monitor_scheme_type;// tinyint(2) DEFAULT NULL COMMENT '监测方案类型 1-长期方案 2-临时方案',
	private Integer status;// tinyint(2) DEFAULT NULL COMMENT '方案状态 1-使用中 2-已使用',
	private Date start_date;// datetime DEFAULT NULL COMMENT '起始日期',
	private Date end_date;// datetime DEFAULT NULL COMMENT '截止日期',
	private String Monday;// varchar(10) DEFAULT NULL COMMENT '测量日期（8个bit位代表8个时段）',
	private String Tuesday;// varchar(10) DEFAULT NULL COMMENT '测量日期（8个bit位代表8个时段）',
	private String Wednesday;// varchar(10) DEFAULT NULL COMMENT '测量日期（8个bit位代表8个时段）',
	private String Thursday;// varchar(10) DEFAULT NULL COMMENT '测量日期（8个bit位代表8个时段）',
	private String Friday;// varchar(10) DEFAULT NULL COMMENT '测量日期（8个bit位代表8个时段）',
	private String Saturday;// varchar(10) DEFAULT NULL COMMENT '测量日期（8个bit位代表8个时段）',
	private String Sunday;// varchar(10) DEFAULT NULL COMMENT '测量日期（8个bit位代表8个时段）',
	private String comcode;// varchar(50) DEFAULT NULL COMMENT '机构代码',
	private Long monitor_model_id;// int(10) DEFAULT NULL COMMENT '监测模型ID',
	private String ext1;// varchar(200) DEFAULT NULL COMMENT '扩展字段1',
	private String ext2;// varchar(500) DEFAULT NULL COMMENT '扩展字段2',
	private String ext3;// varchar(1000) DEFAULT NULL COMMENT '扩展字段3',
	private String monitor_scheme_remark;// varchar(200) DEFAULT NULL COMMENT '监测方案备注',
	private Integer measure_type;// int(1) DEFAULT NULL COMMENT '测量类型 0--血糖 1--血压',

	public Long getMonitor_scheme_id() {
		return monitor_scheme_id;
	}

	public void setMonitor_scheme_id(Long monitor_scheme_id) {
		this.monitor_scheme_id = monitor_scheme_id;
	}

	public String getMonitor_scheme_name() {
		return monitor_scheme_name;
	}

	public void setMonitor_scheme_name(String monitor_scheme_name) {
		this.monitor_scheme_name = monitor_scheme_name;
	}

	public String getMonitor_scheme_content() {
		return monitor_scheme_content;
	}

	public void setMonitor_scheme_content(String monitor_scheme_content) {
		this.monitor_scheme_content = monitor_scheme_content;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPerson_id() {
		return person_id;
	}

	public void setPerson_id(String person_id) {
		this.person_id = person_id;
	}

	public String getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(String doctor_id) {
		this.doctor_id = doctor_id;
	}

	public Date getRecord_date() {
		return record_date;
	}

	public void setRecord_date(Date record_date) {
		this.record_date = record_date;
	}

	public String getStamp_time() {
		return stamp_time;
	}

	public void setStamp_time(String stamp_time) {
		this.stamp_time = stamp_time;
	}

	public Integer getMonitor_scheme_type() {
		return monitor_scheme_type;
	}

	public void setMonitor_scheme_type(Integer monitor_scheme_type) {
		this.monitor_scheme_type = monitor_scheme_type;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public String getMonday() {
		return Monday;
	}

	public void setMonday(String monday) {
		Monday = monday;
	}

	public String getTuesday() {
		return Tuesday;
	}

	public void setTuesday(String tuesday) {
		Tuesday = tuesday;
	}

	public String getWednesday() {
		return Wednesday;
	}

	public void setWednesday(String wednesday) {
		Wednesday = wednesday;
	}

	public String getThursday() {
		return Thursday;
	}

	public void setThursday(String thursday) {
		Thursday = thursday;
	}

	public String getFriday() {
		return Friday;
	}

	public void setFriday(String friday) {
		Friday = friday;
	}

	public String getSaturday() {
		return Saturday;
	}

	public void setSaturday(String saturday) {
		Saturday = saturday;
	}

	public String getSunday() {
		return Sunday;
	}

	public void setSunday(String sunday) {
		Sunday = sunday;
	}

	public String getComcode() {
		return comcode;
	}

	public void setComcode(String comcode) {
		this.comcode = comcode;
	}

	public Long getMonitor_model_id() {
		return monitor_model_id;
	}

	public void setMonitor_model_id(Long monitor_model_id) {
		this.monitor_model_id = monitor_model_id;
	}

	public String getExt1() {
		return ext1;
	}

	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}

	public String getExt2() {
		return ext2;
	}

	public void setExt2(String ext2) {
		this.ext2 = ext2;
	}

	public String getExt3() {
		return ext3;
	}

	public void setExt3(String ext3) {
		this.ext3 = ext3;
	}

	public String getMonitor_scheme_remark() {
		return monitor_scheme_remark;
	}

	public void setMonitor_scheme_remark(String monitor_scheme_remark) {
		this.monitor_scheme_remark = monitor_scheme_remark;
	}

	public Integer getMeasure_type() {
		return measure_type;
	}

	public void setMeasure_type(Integer measure_type) {
		this.measure_type = measure_type;
	}

}
