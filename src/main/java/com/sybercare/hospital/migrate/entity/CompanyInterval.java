package com.sybercare.hospital.migrate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 55097
 *
 */
@Entity
@Table(name = "company_interval")
public class CompanyInterval {
	@Id
	@Column(name = "id")
	private int id; // bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
	private String com_code; // varchar(50) DEFAULT NULL COMMENT '机构',
	private String time_interval_code; /// varchar(20) DEFAULT NULL COMMENT '时段code',
	private String time_interval; // varchar(20) DEFAULT NULL COMMENT '时段名',
	private String status; // varchar(1) DEFAULT NULL COMMENT '0:不使用 1：使用',
	private String start_time; // varchar(19) DEFAULT NULL,
	private String end_time; // varchar(19) DEFAULT NULL,
	private String measure_type; // int(1) DEFAULT NULL COMMENT '测量类型 0--血糖 1--血压 2--体温 3--胰岛素',
	private Double max_value; // double DEFAULT NULL COMMENT '正常最大值',
	private Double min_value; // double DEFAULT NULL COMMENT '正常最小值',
	private String standard_interval_name; // varchar(20) DEFAULT NULL COMMENT '标准时段名称',

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCom_code() {
		return com_code;
	}

	public void setCom_code(String com_code) {
		this.com_code = com_code;
	}

	public String getTime_interval_code() {
		return time_interval_code;
	}

	public void setTime_interval_code(String time_interval_code) {
		this.time_interval_code = time_interval_code;
	}

	public String getTime_interval() {
		return time_interval;
	}

	public void setTime_interval(String time_interval) {
		this.time_interval = time_interval;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getMeasure_type() {
		return measure_type;
	}

	public void setMeasure_type(String measure_type) {
		this.measure_type = measure_type;
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

	public String getStandard_interval_name() {
		return standard_interval_name;
	}

	public void setStandard_interval_name(String standard_interval_name) {
		this.standard_interval_name = standard_interval_name;
	}

}
