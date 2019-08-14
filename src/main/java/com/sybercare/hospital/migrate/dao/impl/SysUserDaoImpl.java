package com.sybercare.hospital.migrate.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sybercare.hospital.common.ds.DynamicDataSourceAutowired;
import com.sybercare.hospital.common.utils.IHibernateBaseDao;
import com.sybercare.hospital.migrate.dao.SysUserDao;
import com.sybercare.hospital.migrate.entity.Prpsstaff;
import com.sybercare.hospital.migrate.entity.SysUser;

@Repository
@Transactional
public class SysUserDaoImpl implements SysUserDao {
	@Autowired
	private IHibernateBaseDao<Prpsstaff> prpsStaffBaseDao;
	@Autowired
	private IHibernateBaseDao<SysUser> sysUserBaseDao;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@DynamicDataSourceAutowired(name = "his")
	@Override
	public List<Prpsstaff> selectPrpsStaffs() {
		return prpsStaffBaseDao.getAll(Prpsstaff.class);
	}

	@Override
	public Long selectNewIdByOldId(String personid) {
		String sql = "SELECT new_id FROM sys_user_relation WHERE old_id=?";
		try {
			return jdbcTemplate.queryForObject(sql, Long.class, personid);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public SysUser insertSysUser(SysUser user) {
		return sysUserBaseDao.saveOrUpdate(user);
	}

	@Override
	public void insertSysUserRelation(Long user_id, String personid) {
		String sql = "INSERT INTO sys_user_relation(new_id,old_id) VALUES(?,?)";
		jdbcTemplate.update(sql, user_id, personid);
	}

	@Override
	public void updateSysUser(SysUser user) {
		sysUserBaseDao.update(user);
	}

	@Override
	public void insertSysUserRole(Long user_id, Long new_id) {
		String sql = "INSERT INTO sys_user_role(user_id,role_id) VALUES(?,?)";
		jdbcTemplate.update(sql, user_id, new_id);
	}

	@DynamicDataSourceAutowired(name = "his")
	@Override
	public String selectUserCodeByPersonId(String personId) {
		String sql = "SELECT userCode FROM prpsstaff WHERE personid=?";
		try {
			return jdbcTemplate.queryForObject(sql, String.class, personId);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@DynamicDataSourceAutowired(name = "his")
	@Override
	public String seleDoctorNameById(String id) {
		String sql = "SELECT personname FROM prpsstaff WHERE userCode=?";
		try {
			return jdbcTemplate.queryForObject(sql, String.class, id);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}
