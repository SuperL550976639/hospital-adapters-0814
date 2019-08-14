package com.sybercare.hospital.migrate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "company_emergency_config")
public class CompanyEmergencyConfig {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;// bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
	private String com_code;// varchar(50) DEFAULT NULL COMMENT '机构',
	private String status;// varchar(1) DEFAULT NULL COMMENT '0:不可用 1：可用',
	private Integer measure_type;// int(1) DEFAULT NULL COMMENT '测量类型 0--血糖 1--血压 2--体温',
	private Double emergency_high;// double DEFAULT NULL COMMENT '危急高值',
	private Double emergency_low;// double DEFAULT NULL COMMENT '危急低值',

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCom_code() {
		return com_code;
	}

	public void setCom_code(String com_code) {
		this.com_code = com_code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getMeasure_type() {
		return measure_type;
	}

	public void setMeasure_type(Integer measure_type) {
		this.measure_type = measure_type;
	}

	public Double getEmergency_high() {
		return emergency_high;
	}

	public void setEmergency_high(Double emergency_high) {
		this.emergency_high = emergency_high;
	}

	public Double getEmergency_low() {
		return emergency_low;
	}

	public void setEmergency_low(Double emergency_low) {
		this.emergency_low = emergency_low;
	}

}
