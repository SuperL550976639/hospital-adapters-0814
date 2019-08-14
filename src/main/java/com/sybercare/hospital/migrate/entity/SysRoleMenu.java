package com.sybercare.hospital.migrate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sys_role_menu")
public class SysRoleMenu implements Serializable {
	private static final long serialVersionUID = -8423460622904171488L;
	@Id
	@Column(name = "role_id")
	private Long role_id;// bigint(20) NOT NULL COMMENT '角色ID',
	@Id
	@Column(name = "menu_id")
	private Long menu_id;// bigint(20) NOT NULL COMMENT '菜单ID',

	public Long getRole_id() {
		return role_id;
	}

	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}

	public Long getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(Long menu_id) {
		this.menu_id = menu_id;
	}

	public SysRoleMenu() {
		super();
	}

	public SysRoleMenu(Long role_id, Long menu_id) {
		super();
		this.role_id = role_id;
		this.menu_id = menu_id;
	}

}
