package com.sybercare.hospital.migrate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "data_blood_bgqc")

public class DataBloodBgqc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;// int(11) NOT NULL AUTO_INCREMENT COMMENT '血糖质控表id',
	private String meter_number;// varchar(50) DEFAULT NULL COMMENT '血糖仪编号',
	private String bgqc_number;// varchar(50) DEFAULT NULL COMMENT '质控液编号',
	private Double value;// double DEFAULT NULL COMMENT '测量值',
	private String measure_time;// varchar(19) DEFAULT NULL COMMENT '测量时间',
	private String oprator;// varchar(50) DEFAULT NULL COMMENT '操作人',
	private String result;// varchar(1) DEFAULT NULL COMMENT '质检结果 0--合格 1--不合格',
	private String remark;// varchar(200) DEFAULT NULL COMMENT '备注',
	private String bgqc_type;// varchar(20) DEFAULT NULL COMMENT '质控液类型',
	private String bgqc_paper_number;// varchar(20) DEFAULT NULL COMMENT '试纸编号',
	private Double bgqc_min;// float(20,1) DEFAULT NULL COMMENT '质控液范围最小值',
	private Double bgqc_max;// float(20,1) DEFAULT NULL COMMENT '质控液范围最大值',
	private String bgqc_paper_valid_time;// varchar(19) DEFAULT NULL COMMENT '试纸开启后有效期',
	private String bgqc_number_valid_time;// varchar(19) DEFAULT NULL COMMENT '质控液有效期',
	private Integer status;// tinyint(1) DEFAULT '1' COMMENT '状态(0--无效，1--正常)',

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMeter_number() {
		return meter_number;
	}

	public void setMeter_number(String meter_number) {
		this.meter_number = meter_number;
	}

	public String getBgqc_number() {
		return bgqc_number;
	}

	public void setBgqc_number(String bgqc_number) {
		this.bgqc_number = bgqc_number;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public String getMeasure_time() {
		return measure_time;
	}

	public void setMeasure_time(String measure_time) {
		this.measure_time = measure_time;
	}

	public String getOprator() {
		return oprator;
	}

	public void setOprator(String oprator) {
		this.oprator = oprator;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getBgqc_type() {
		return bgqc_type;
	}

	public void setBgqc_type(String bgqc_type) {
		this.bgqc_type = bgqc_type;
	}

	public String getBgqc_paper_number() {
		return bgqc_paper_number;
	}

	public void setBgqc_paper_number(String bgqc_paper_number) {
		this.bgqc_paper_number = bgqc_paper_number;
	}

	public Double getBgqc_min() {
		return bgqc_min;
	}

	public void setBgqc_min(Double bgqc_min) {
		this.bgqc_min = bgqc_min;
	}

	public Double getBgqc_max() {
		return bgqc_max;
	}

	public void setBgqc_max(Double bgqc_max) {
		this.bgqc_max = bgqc_max;
	}

	public String getBgqc_paper_valid_time() {
		return bgqc_paper_valid_time;
	}

	public void setBgqc_paper_valid_time(String bgqc_paper_valid_time) {
		this.bgqc_paper_valid_time = bgqc_paper_valid_time;
	}

	public String getBgqc_number_valid_time() {
		return bgqc_number_valid_time;
	}

	public void setBgqc_number_valid_time(String bgqc_number_valid_time) {
		this.bgqc_number_valid_time = bgqc_number_valid_time;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
