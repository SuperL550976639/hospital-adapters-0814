package com.sybercare.hospital.migrate.dao;

import java.util.List;

import com.sybercare.hospital.migrate.entity.Prpsstaff;
import com.sybercare.hospital.migrate.entity.SysUser;

public interface SysUserDao {

	List<Prpsstaff> selectPrpsStaffs();

	Long selectNewIdByOldId(String personid);

	SysUser insertSysUser(SysUser user);

	void insertSysUserRelation(Long user_id, String personid);

	void updateSysUser(SysUser user);

	void insertSysUserRole(Long user_id, Long new_id);

	String selectUserCodeByPersonId(String personId);

	String seleDoctorNameById(String id);

}
