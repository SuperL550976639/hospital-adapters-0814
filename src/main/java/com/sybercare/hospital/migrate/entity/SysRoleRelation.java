package com.sybercare.hospital.migrate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sys_role_relation")
public class SysRoleRelation implements Serializable {
	private static final long serialVersionUID = 8393210927451359691L;
	@Id
	@Column(name = "new_id")
	private Long new_id;// bigint(20) NOT NULL,
	@Id
	@Column(name = "old_id")
	private Integer old_id;// int(19) NOT NULL,

	public Long getNew_id() {
		return new_id;
	}

	public void setNew_id(Long new_id) {
		this.new_id = new_id;
	}

	public Integer getOld_id() {
		return old_id;
	}

	public void setOld_id(Integer old_id) {
		this.old_id = old_id;
	}

	public SysRoleRelation(Long new_id, Integer old_id) {
		super();
		this.new_id = new_id;
		this.old_id = old_id;
	}

	public SysRoleRelation() {
		super();
	}

}
