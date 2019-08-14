package com.sybercare.hospital.migrate.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sys_role")
public class SysRole {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private Long role_id;// bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
	private String role_name;// varchar(30) NOT NULL COMMENT '角色名称',
	private String role_key;// varchar(100) DEFAULT NULL COMMENT '角色权限字符串',
	private Integer role_sort;// int(4) NOT NULL COMMENT '显示顺序',
	private String data_scope;// char(1) DEFAULT '1' COMMENT '数据范围（1：全部数据权限 2：自定数据权限）',
	private String status;// char(1) NOT NULL COMMENT '角色状态（0正常 1停用）',
	private String del_flag;// char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
	private String create_by;// varchar(64) DEFAULT '' COMMENT '创建者',
	private Date create_time;// datetime DEFAULT NULL COMMENT '创建时间',
	private String update_by;// varchar(64) DEFAULT '' COMMENT '更新者',
	private Date update_time;// datetime DEFAULT NULL COMMENT '更新时间',
	private String remark;// varchar(500) DEFAULT NULL COMMENT '备注',

	public Long getRole_id() {
		return role_id;
	}

	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public String getRole_key() {
		return role_key;
	}

	public void setRole_key(String role_key) {
		this.role_key = role_key;
	}

	public Integer getRole_sort() {
		return role_sort;
	}

	public void setRole_sort(Integer role_sort) {
		this.role_sort = role_sort;
	}

	public String getData_scope() {
		return data_scope;
	}

	public void setData_scope(String data_scope) {
		this.data_scope = data_scope;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDel_flag() {
		return del_flag;
	}

	public void setDel_flag(String del_flag) {
		this.del_flag = del_flag;
	}

	public String getCreate_by() {
		return create_by;
	}

	public void setCreate_by(String create_by) {
		this.create_by = create_by;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public String getUpdate_by() {
		return update_by;
	}

	public void setUpdate_by(String update_by) {
		this.update_by = update_by;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
