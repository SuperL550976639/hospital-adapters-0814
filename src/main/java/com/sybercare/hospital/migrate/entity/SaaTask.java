package com.sybercare.hospital.migrate.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "saa_task")
public class SaaTask {
	@Id
	@Column(name = "id")
	private Integer id;// int(19) NOT NULL,
	private String taskcode;// varchar(255) NOT NULL,
	private String parentcode;// varchar(255) NOT NULL,
	private String taskcname;// varchar(255) DEFAULT NULL,
	private String tasktname;// varchar(255) DEFAULT NULL,
	private String taskename;// varchar(255) DEFAULT NULL,
	private String creatorcode;// varchar(50) DEFAULT NULL,
	private Date createtime;// date DEFAULT NULL,
	private String updatercode;// varchar(50) DEFAULT NULL,
	private Date updatetime;// date DEFAULT NULL,
	private String validstatus;// varchar(1) DEFAULT NULL,

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTaskcode() {
		return taskcode;
	}

	public void setTaskcode(String taskcode) {
		this.taskcode = taskcode;
	}

	public String getParentcode() {
		return parentcode;
	}

	public void setParentcode(String parentcode) {
		this.parentcode = parentcode;
	}

	public String getTaskcname() {
		return taskcname;
	}

	public void setTaskcname(String taskcname) {
		this.taskcname = taskcname;
	}

	public String getTasktname() {
		return tasktname;
	}

	public void setTasktname(String tasktname) {
		this.tasktname = tasktname;
	}

	public String getTaskename() {
		return taskename;
	}

	public void setTaskename(String taskename) {
		this.taskename = taskename;
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

}
