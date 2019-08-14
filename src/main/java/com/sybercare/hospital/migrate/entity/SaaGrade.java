package com.sybercare.hospital.migrate.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "saa_grade")
public class SaaGrade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;// int(19) NOT NULL AUTO_INCREMENT,
	private String gradecname;// varchar(255) DEFAULT NULL,
	private String gradetname;// varchar(255) DEFAULT NULL,
	private String gradeename;// varchar(255) DEFAULT NULL,
	private String commongrade;// varchar(1) NOT NULL,
	private String comcode;// varchar(50) NOT NULL,
	private String creatorcode;// varchar(50) DEFAULT NULL,
	private Date createtime;// date DEFAULT NULL,
	private String updatercode;// varchar(50) DEFAULT NULL,
	private Date updatetime;// date DEFAULT NULL,
	private String validstatus;// varchar(1) DEFAULT NULL,
	private String systemtypename;// varchar(20) DEFAULT NULL,
	private String gradecode;// varchar(50) DEFAULT NULL COMMENT '对应院内职位编码',

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGradecname() {
		return gradecname;
	}

	public void setGradecname(String gradecname) {
		this.gradecname = gradecname;
	}

	public String getGradetname() {
		return gradetname;
	}

	public void setGradetname(String gradetname) {
		this.gradetname = gradetname;
	}

	public String getGradeename() {
		return gradeename;
	}

	public void setGradeename(String gradeename) {
		this.gradeename = gradeename;
	}

	public String getCommongrade() {
		return commongrade;
	}

	public void setCommongrade(String commongrade) {
		this.commongrade = commongrade;
	}

	public String getComcode() {
		return comcode;
	}

	public void setComcode(String comcode) {
		this.comcode = comcode;
	}

	public String getCreatorcode() {
		return creatorcode;
	}

	public void setCreatorcode(String creatorcode) {
		this.creatorcode = creatorcode;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getUpdatercode() {
		return updatercode;
	}

	public void setUpdatercode(String updatercode) {
		this.updatercode = updatercode;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public String getValidstatus() {
		return validstatus;
	}

	public void setValidstatus(String validstatus) {
		this.validstatus = validstatus;
	}

	public String getSystemtypename() {
		return systemtypename;
	}

	public void setSystemtypename(String systemtypename) {
		this.systemtypename = systemtypename;
	}

	public String getGradecode() {
		return gradecode;
	}

	public void setGradecode(String gradecode) {
		this.gradecode = gradecode;
	}

}
