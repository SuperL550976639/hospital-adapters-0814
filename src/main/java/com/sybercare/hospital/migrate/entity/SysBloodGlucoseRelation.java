package com.sybercare.hospital.migrate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 55097 血糖对应表实体类
 */
@Entity
@Table(name = "sys_blood_glucose_relation")
public class SysBloodGlucoseRelation implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "new_id")
	private int new_id;

	@Id
	@Column(name = "old_id")
	private int old_id;

	public int getNew_id() {
		return new_id;
	}

	public void setNew_id(int new_id) {
		this.new_id = new_id;
	}

	public int getOld_id() {
		return old_id;
	}

	public void setOld_id(int old_id) {
		this.old_id = old_id;
	}

	public SysBloodGlucoseRelation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SysBloodGlucoseRelation(int new_id, int old_id) {
		super();
		this.new_id = new_id;
		this.old_id = old_id;
	}

}
