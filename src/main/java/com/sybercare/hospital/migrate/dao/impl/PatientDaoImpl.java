package com.sybercare.hospital.migrate.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sybercare.hospital.common.ds.DynamicDataSourceAutowired;
import com.sybercare.hospital.common.utils.IHibernateBaseDao;
import com.sybercare.hospital.migrate.dao.PatientDao;
import com.sybercare.hospital.migrate.entity.SysPatient;
import com.sybercare.hospital.migrate.entity.SysPatientRelation;
import com.sybercare.hospital.migrate.entity.User;
import com.sybercare.hospital.migrate.entity.UserPatient;

@Repository
@Transactional
public class PatientDaoImpl implements PatientDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private IHibernateBaseDao<SysPatient> sysPatientDao;
	@Autowired
	private IHibernateBaseDao<SysPatientRelation> sysPatientRelationDao;

	@DynamicDataSourceAutowired(name = "his")
	@Override
	public List<User> selectUsers() {
		String sql = "SELECT * FROM user";
		List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
		return users;
	}

	@DynamicDataSourceAutowired(name = "his")
	@Override
	public List<UserPatient> selectUserPatients() {
		String sql = "SELECT * FROM user_patient";
		List<UserPatient> userPatients = jdbcTemplate.query(sql,
				new BeanPropertyRowMapper<UserPatient>(UserPatient.class));
		return userPatients;
	}

	@DynamicDataSourceAutowired(name = "his")
	@Override
	public UserPatient selectUserPatientByUserId(String userId) {
		String sql = "SELECT * FROM user_patient WHERE user_id=?";
		UserPatient userPatient = jdbcTemplate.queryForObject(sql,
				new BeanPropertyRowMapper<UserPatient>(UserPatient.class), userId);
		return userPatient;
	}

	@Override
	public SysPatient insertSysPatient(SysPatient patient) {
		return sysPatientDao.saveOrUpdate(patient);
	}

	@Override
	public SysPatient selectSysPatientByUserName(String patient_name) {
		return sysPatientDao.get(SysPatient.class, "patient_name", patient_name);
	}

	@Override
	public void updateSysPatient(SysPatient patient) {
		sysPatientDao.update(patient);
	}

	@Override
	public SysPatientRelation insertSysPatientRelation(SysPatientRelation sysPatientRelation) {
		return sysPatientRelationDao.saveOrUpdate(sysPatientRelation);
	}

	@Override
	public Long selectNewIdByOldId(String userId) {
		String sql = "SELECT new_id FROM sys_patient_relation WHERE old_id=?";
		try {
			return jdbcTemplate.queryForObject(sql, Long.class, userId);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	@DynamicDataSourceAutowired(name="his")
	@Override
	public String selectPatientNameById(String user_id) {
		String sql = "SELECT name FROM user WHERE user_id=?";
		try {
			return jdbcTemplate.queryForObject(sql, String.class, user_id);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}
