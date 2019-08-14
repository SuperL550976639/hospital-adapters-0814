package com.sybercare.hospital.migrate.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sys_dept")
public class SysDept {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dept_id")
	private Long dept_id;// bigint(20) NOT NULL AUTO_INCREMENT COMMENT '部门id',
	private Long parent_id;// bigint(20) DEFAULT '0' COMMENT '父部门id',
	private String parent_name;// varchar(30) DEFAULT '' COMMENT '父部门名称',
	private String ancestors;// varchar(50) DEFAULT '' COMMENT '祖级列表',
	private String dept_name;// varchar(30) DEFAULT '' COMMENT '部门名称',
	private Integer order_num;// int(4) DEFAULT '0' COMMENT '显示顺序',
	private String leader;// varchar(20) DEFAULT NULL COMMENT '负责人',
	private String phone;// varchar(11) DEFAULT NULL COMMENT '联系电话',
	private String email;// varchar(50) DEFAULT NULL COMMENT '邮箱',
	private String status;// char(1) DEFAULT '0' COMMENT '部门状态（0正常 1停用）',
	private String del_flag;// char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
	private String wristband_type;// varchar(10) DEFAULT NULL COMMENT '腕带类型',
	private String report_type;// varchar(10) DEFAULT NULL COMMENT '报表类型',
	private String create_by;// varchar(64) DEFAULT '' COMMENT '创建者',
	private Date create_time;// datetime DEFAULT NULL COMMENT '创建时间',
	private String update_by;// varchar(64) DEFAULT '' COMMENT '更新者',
	private Date update_time;// datetime DEFAULT NULL COMMENT '更新时间',

	public Long getDept_id() {
		return dept_id;
	}

	public void setDept_id(Long dept_id) {
		this.dept_id = dept_id;
	}

	public Long getParent_id() {
		return parent_id;
	}

	public void setParent_id(Long parent_id) {
		this.parent_id = parent_id;
	}

	public String getParent_name() {
		return parent_name;
	}

	public void setParent_name(String parent_name) {
		this.parent_name = parent_name;
	}

	public String getAncestors() {
		return ancestors;
	}

	public void setAncestors(String ancestors) {
		this.ancestors = ancestors;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public Integer getOrder_num() {
		return order_num;
	}

	public void setOrder_num(Integer order_num) {
		this.order_num = order_num;
	}

	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getWristband_type() {
		return wristband_type;
	}

	public void setWristband_type(String wristband_type) {
		this.wristband_type = wristband_type;
	}

	public String getReport_type() {
		return report_type;
	}

	public void setReport_type(String report_type) {
		this.report_type = report_type;
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

}
