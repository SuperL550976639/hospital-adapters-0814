package com.sybercare.hospital.migrate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sys_patient_relation")
public class SysPatientRelation implements Serializable {
	private static final long serialVersionUID = 935291246656569801L;
	@Id
	@Column(name = "old_id")
	private String old_id;
	@Id
	@Column(name = "new_id")
	private Long new_id;

	public SysPatientRelation(String old_id, Long new_id) {
		super();
		this.old_id = old_id;
		this.new_id = new_id;
	}

	public String getOld_id() {
		return old_id;
	}

	public void setOld_id(String old_id) {
		this.old_id = old_id;
	}

	public Long getNew_id() {
		return new_id;
	}

	public void setNew_id(Long new_id) {
		this.new_id = new_id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public SysPatientRelation() {
		super();
	}

}
