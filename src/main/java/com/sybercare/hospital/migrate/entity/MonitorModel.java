package com.sybercare.hospital.migrate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "monitor_model")
public class MonitorModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;// bigint(20) NOT NULL AUTO_INCREMENT,
	private String fpg_frequency_status;// varchar(10) DEFAULT NULL COMMENT '血糖表示空腹，血压无 critical选中，optional未选',
	private String fpg_frequency;// varchar(2) DEFAULT NULL COMMENT '空腹频率（/周）',
	private String after_breakfast_frequency_status;// varchar(10) DEFAULT NULL COMMENT '血糖表示早餐后，血压上午
													// critical选中，optional未选',
	private String after_breakfast_frequency;// varchar(2) DEFAULT NULL COMMENT '早餐后频率（/周）',
	private String before_lunch_frequency_status;// varchar(10) DEFAULT NULL COMMENT '血糖表示午餐前，血压无
													// critical选中，optional未选',
	private String before_lunch_frequency;// varchar(2) DEFAULT NULL COMMENT '午餐前频率（/周）',
	private String after_lunch_frequency_status;// varchar(10) DEFAULT NULL COMMENT '血糖表示午餐后，血压下午
												// critical选中，optional未选',
	private String after_lunch_frequency;// varchar(2) DEFAULT NULL COMMENT '午餐后频率（/周）',
	private String before_dinner_frequency_status;// varchar(10) DEFAULT NULL COMMENT '血糖表示晚餐前，血压无
													// critical选中，optional未选',
	private String before_dinner_frequency;// varchar(2) DEFAULT NULL COMMENT '晚餐前频率（/周）',
	private String after_dinner_frequency_status;// varchar(10) DEFAULT NULL COMMENT '血糖表示晚餐后，血压晚上
													// critical选中，optional未选',
	private String after_dinner_frequency;// varchar(2) DEFAULT NULL COMMENT '晚餐后频率（/周）',
	private String before_sleep_frequency_status;// varchar(10) DEFAULT NULL COMMENT '血糖表示睡前，血压睡前
													// critical选中，optional未选',
	private String before_sleep_frequency;// varchar(2) DEFAULT NULL COMMENT '睡前频率（/周）',
	private String during_night_frequency_status;// varchar(10) DEFAULT NULL COMMENT '血糖表示凌晨，血压凌晨
													// critical选中，optional未选',
	private String during_night_frequency;// varchar(2) DEFAULT NULL COMMENT '凌晨频率（/周）',
	private String dawn_frequency_status;// varchar(10) DEFAULT NULL COMMENT '血糖表示凌晨3点，血压无 critical选中，optional未选',

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFpg_frequency_status() {
		return fpg_frequency_status;
	}

	public void setFpg_frequency_status(String fpg_frequency_status) {
		this.fpg_frequency_status = fpg_frequency_status;
	}

	public String getFpg_frequency() {
		return fpg_frequency;
	}

	public void setFpg_frequency(String fpg_frequency) {
		this.fpg_frequency = fpg_frequency;
	}

	public String getAfter_breakfast_frequency_status() {
		return after_breakfast_frequency_status;
	}

	public void setAfter_breakfast_frequency_status(String after_breakfast_frequency_status) {
		this.after_breakfast_frequency_status = after_breakfast_frequency_status;
	}

	public String getAfter_breakfast_frequency() {
		return after_breakfast_frequency;
	}

	public void setAfter_breakfast_frequency(String after_breakfast_frequency) {
		this.after_breakfast_frequency = after_breakfast_frequency;
	}

	public String getBefore_lunch_frequency_status() {
		return before_lunch_frequency_status;
	}

	public void setBefore_lunch_frequency_status(String before_lunch_frequency_status) {
		this.before_lunch_frequency_status = before_lunch_frequency_status;
	}

	public String getBefore_lunch_frequency() {
		return before_lunch_frequency;
	}

	public void setBefore_lunch_frequency(String before_lunch_frequency) {
		this.before_lunch_frequency = before_lunch_frequency;
	}

	public String getAfter_lunch_frequency_status() {
		return after_lunch_frequency_status;
	}

	public void setAfter_lunch_frequency_status(String after_lunch_frequency_status) {
		this.after_lunch_frequency_status = after_lunch_frequency_status;
	}

	public String getAfter_lunch_frequency() {
		return after_lunch_frequency;
	}

	public void setAfter_lunch_frequency(String after_lunch_frequency) {
		this.after_lunch_frequency = after_lunch_frequency;
	}

	public String getBefore_dinner_frequency_status() {
		return before_dinner_frequency_status;
	}

	public void setBefore_dinner_frequency_status(String before_dinner_frequency_status) {
		this.before_dinner_frequency_status = before_dinner_frequency_status;
	}

	public String getBefore_dinner_frequency() {
		return before_dinner_frequency;
	}

	public void setBefore_dinner_frequency(String before_dinner_frequency) {
		this.before_dinner_frequency = before_dinner_frequency;
	}

	public String getAfter_dinner_frequency_status() {
		return after_dinner_frequency_status;
	}

	public void setAfter_dinner_frequency_status(String after_dinner_frequency_status) {
		this.after_dinner_frequency_status = after_dinner_frequency_status;
	}

	public String getAfter_dinner_frequency() {
		return after_dinner_frequency;
	}

	public void setAfter_dinner_frequency(String after_dinner_frequency) {
		this.after_dinner_frequency = after_dinner_frequency;
	}

	public String getBefore_sleep_frequency_status() {
		return before_sleep_frequency_status;
	}

	public void setBefore_sleep_frequency_status(String before_sleep_frequency_status) {
		this.before_sleep_frequency_status = before_sleep_frequency_status;
	}

	public String getBefore_sleep_frequency() {
		return before_sleep_frequency;
	}

	public void setBefore_sleep_frequency(String before_sleep_frequency) {
		this.before_sleep_frequency = before_sleep_frequency;
	}

	public String getDuring_night_frequency_status() {
		return during_night_frequency_status;
	}

	public void setDuring_night_frequency_status(String during_night_frequency_status) {
		this.during_night_frequency_status = during_night_frequency_status;
	}

	public String getDuring_night_frequency() {
		return during_night_frequency;
	}

	public void setDuring_night_frequency(String during_night_frequency) {
		this.during_night_frequency = during_night_frequency;
	}

	public String getDawn_frequency_status() {
		return dawn_frequency_status;
	}

	public void setDawn_frequency_status(String dawn_frequency_status) {
		this.dawn_frequency_status = dawn_frequency_status;
	}

}
