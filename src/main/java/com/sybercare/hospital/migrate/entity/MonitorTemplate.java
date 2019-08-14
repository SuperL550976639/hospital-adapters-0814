package com.sybercare.hospital.migrate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="monitor_template")
public class MonitorTemplate {
	@Id
	@Column(name = "id")
	private Long id;// bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '模版id',
	private String monitor_template_name;// varchar(30) DEFAULT NULL COMMENT '模版名称',
	private String monitor_scheme_content;// varchar(200) DEFAULT NULL COMMENT '备注',
	private String fpg_frequency_status;// varchar(2) DEFAULT NULL COMMENT '血糖表示空腹，血压无 1选中，0未选',
	private String after_breakfast_frequency_status;// varchar(2) DEFAULT NULL COMMENT '血糖表示早餐后，血压上午 1选中，0未选',
	private String before_lunch_frequency_status;// varchar(2) DEFAULT NULL COMMENT '血糖表示午餐前，血压无 1选中，0未选',
	private String after_lunch_frequency_status;// varchar(2) DEFAULT NULL COMMENT '血糖表示午餐后，血压下午 1选中，0未选',
	private String before_dinner_frequency_status;// varchar(2) DEFAULT NULL COMMENT '血糖表示晚餐前，血压无 1选中，0未选',
	private String after_dinner_frequency_status;// varchar(2) DEFAULT NULL COMMENT '血糖表示晚餐后，血压晚上 1选中，0未选',
	private String before_sleep_frequency_status;// varchar(2) DEFAULT NULL COMMENT '血糖表示睡前，血压睡前 1选中，0未选',
	private String during_night_frequency_status;// varchar(2) DEFAULT NULL COMMENT '血糖表示凌晨，血压凌晨 1选中，0未选',
	private String comcode;// varchar(50) DEFAULT NULL COMMENT '医院',
	private String monitor_template_type;// varchar(2) DEFAULT NULL COMMENT '模板类型 0：长期模板 1：临时模板',
	private Integer measure_type;// int(1) DEFAULT NULL COMMENT '测量类型 0--血糖 1--血压',
	private String dawn_frequency_status;// varchar(2) DEFAULT NULL COMMENT '血糖表示凌晨3点，血压无 1选中，0未选',

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMonitor_template_name() {
		return monitor_template_name;
	}

	public void setMonitor_template_name(String monitor_template_name) {
		this.monitor_template_name = monitor_template_name;
	}

	public String getMonitor_scheme_content() {
		return monitor_scheme_content;
	}

	public void setMonitor_scheme_content(String monitor_scheme_content) {
		this.monitor_scheme_content = monitor_scheme_content;
	}

	public String getFpg_frequency_status() {
		return fpg_frequency_status;
	}

	public void setFpg_frequency_status(String fpg_frequency_status) {
		this.fpg_frequency_status = fpg_frequency_status;
	}

	public String getAfter_breakfast_frequency_status() {
		return after_breakfast_frequency_status;
	}

	public void setAfter_breakfast_frequency_status(String after_breakfast_frequency_status) {
		this.after_breakfast_frequency_status = after_breakfast_frequency_status;
	}

	public String getBefore_lunch_frequency_status() {
		return before_lunch_frequency_status;
	}

	public void setBefore_lunch_frequency_status(String before_lunch_frequency_status) {
		this.before_lunch_frequency_status = before_lunch_frequency_status;
	}

	public String getAfter_lunch_frequency_status() {
		return after_lunch_frequency_status;
	}

	public void setAfter_lunch_frequency_status(String after_lunch_frequency_status) {
		this.after_lunch_frequency_status = after_lunch_frequency_status;
	}

	public String getBefore_dinner_frequency_status() {
		return before_dinner_frequency_status;
	}

	public void setBefore_dinner_frequency_status(String before_dinner_frequency_status) {
		this.before_dinner_frequency_status = before_dinner_frequency_status;
	}

	public String getAfter_dinner_frequency_status() {
		return after_dinner_frequency_status;
	}

	public void setAfter_dinner_frequency_status(String after_dinner_frequency_status) {
		this.after_dinner_frequency_status = after_dinner_frequency_status;
	}

	public String getBefore_sleep_frequency_status() {
		return before_sleep_frequency_status;
	}

	public void setBefore_sleep_frequency_status(String before_sleep_frequency_status) {
		this.before_sleep_frequency_status = before_sleep_frequency_status;
	}

	public String getDuring_night_frequency_status() {
		return during_night_frequency_status;
	}

	public void setDuring_night_frequency_status(String during_night_frequency_status) {
		this.during_night_frequency_status = during_night_frequency_status;
	}

	public String getComcode() {
		return comcode;
	}

	public void setComcode(String comcode) {
		this.comcode = comcode;
	}

	public String getMonitor_template_type() {
		return monitor_template_type;
	}

	public void setMonitor_template_type(String monitor_template_type) {
		this.monitor_template_type = monitor_template_type;
	}

	public Integer getMeasure_type() {
		return measure_type;
	}

	public void setMeasure_type(Integer measure_type) {
		this.measure_type = measure_type;
	}

	public String getDawn_frequency_status() {
		return dawn_frequency_status;
	}

	public void setDawn_frequency_status(String dawn_frequency_status) {
		this.dawn_frequency_status = dawn_frequency_status;
	}

}
