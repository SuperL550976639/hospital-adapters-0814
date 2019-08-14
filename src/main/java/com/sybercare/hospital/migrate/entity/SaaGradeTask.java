package com.sybercare.hospital.migrate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "saa_gradetask")
public class SaaGradeTask {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;// int(19) NOT NULL AUTO_INCREMENT,
	private Integer gradeid;// int(19) DEFAULT NULL,
	private Integer taskid;// int(19) DEFAULT NULL,
	private String intranetvalue;// varchar(10) DEFAULT NULL,
	private String internetvalue;// varchar(10) DEFAULT NULL,

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGradeid() {
		return gradeid;
	}

	public void setGradeid(Integer gradeid) {
		this.gradeid = gradeid;
	}

	public Integer getTaskid() {
		return taskid;
	}

	public void setTaskid(Integer taskid) {
		this.taskid = taskid;
	}

	public String getIntranetvalue() {
		return intranetvalue;
	}

	public void setIntranetvalue(String intranetvalue) {
		this.intranetvalue = intranetvalue;
	}

	public String getInternetvalue() {
		return internetvalue;
	}

	public void setInternetvalue(String internetvalue) {
		this.internetvalue = internetvalue;
	}

}
