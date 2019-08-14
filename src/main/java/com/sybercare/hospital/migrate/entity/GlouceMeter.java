package com.sybercare.hospital.migrate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "glouce_meter")
public class GlouceMeter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;// int(20) NOT NULL AUTO_INCREMENT,
	private String number;// varchar(50) DEFAULT NULL COMMENT '血糖仪编号',
	private String manu_facturer;// varchar(50) DEFAULT NULL COMMENT '生产厂家',
	private String product_model;// varchar(50) DEFAULT NULL COMMENT '产品型号',
	private String start_date;// varchar(20) DEFAULT NULL COMMENT '启用日期',
	private String qualified;// varchar(2) DEFAULT '9' COMMENT '0-不合格，1-合格，9 未校验',
	private String status;// varchar(2) DEFAULT NULL COMMENT '0-无效，1：有效',
	private String comcode;// varchar(50) DEFAULT NULL COMMENT '所属机构',
	private String endemicArea;// varchar(20) DEFAULT NULL COMMENT '二级部门',

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getManu_facturer() {
		return manu_facturer;
	}

	public void setManu_facturer(String manu_facturer) {
		this.manu_facturer = manu_facturer;
	}

	public String getProduct_model() {
		return product_model;
	}

	public void setProduct_model(String product_model) {
		this.product_model = product_model;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getQualified() {
		return qualified;
	}

	public void setQualified(String qualified) {
		this.qualified = qualified;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComcode() {
		return comcode;
	}

	public void setComcode(String comcode) {
		this.comcode = comcode;
	}

	public String getEndemicArea() {
		return endemicArea;
	}

	public void setEndemicArea(String endemicArea) {
		this.endemicArea = endemicArea;
	}

}
