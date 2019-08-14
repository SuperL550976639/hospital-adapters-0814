package com.sybercare.hospital.migrate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sys_dept_relation")
public class SysDeptRelation implements Serializable {
	private static final long serialVersionUID = 4108319635839059345L;
	@Id
	@Column(name = "new_id")
	private Long new_id;// bigint(20) NOT NULL,
	@Id
	@Column(name = "old_id")
	private String old_id;// varchar(50) NOT NULL,

	public Long getNew_id() {
		return new_id;
	}

	public void setNew_id(Long new_id) {
		this.new_id = new_id;
	}

	public String getOld_id() {
		return old_id;
	}

	public void setOld_id(String old_id) {
		this.old_id = old_id;
	}

	public SysDeptRelation(Long new_id, String old_id) {
		super();
		this.new_id = new_id;
		this.old_id = old_id;
	}

	public SysDeptRelation() {
		super();
	}

}
