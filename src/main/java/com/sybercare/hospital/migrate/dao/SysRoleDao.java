package com.sybercare.hospital.migrate.dao;

import java.util.List;

import com.sybercare.hospital.migrate.entity.SaaGrade;
import com.sybercare.hospital.migrate.entity.SaaGradeTask;
import com.sybercare.hospital.migrate.entity.SysRole;
import com.sybercare.hospital.migrate.entity.SysRoleRelation;

public interface SysRoleDao {

	List<SaaGrade> selectSaaGrades();

	SysRoleRelation selectsysRoleRelationByOldId(Integer id);

	SysRole insertSysRole(SysRole role);

	void insertSysRoleRelation(SysRoleRelation sysRoleRelation);

	void updateSysRole(SysRole role);

	String selectLoginNameByUserId(String userId);

	List<SaaGradeTask> selectSaaGradeTasksByRoleId(Integer id);

	String selectMenuNameById(Integer taskid);

	Long selectMenuIdByName(String menuName);

	void insertSysRoleMenu(Long role_id, List<Long> newMenuId, List<String> menuNames);

}
