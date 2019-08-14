package com.sybercare.hospital.migrate.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sybercare.hospital.common.ds.DynamicDataSourceAutowired;
import com.sybercare.hospital.common.utils.IHibernateBaseDao;
import com.sybercare.hospital.migrate.dao.SysBloodGlucoseQaDao;
import com.sybercare.hospital.migrate.entity.DataBloodBgqc;
import com.sybercare.hospital.migrate.entity.SysBloodGlucoseQa;
import com.sybercare.hospital.migrate.entity.SysQaLiquid;

@Repository
@Transactional
public class SysBloodGlucoseQaDaoImpl implements SysBloodGlucoseQaDao {
	@Autowired
	private IHibernateBaseDao<SysBloodGlucoseQa> sysBloodGlucoseQabaseDao;
	@Autowired
	private IHibernateBaseDao<DataBloodBgqc> dataBloodBgqcbaseDao;
	@Autowired
	private IHibernateBaseDao<SysQaLiquid> sysQaLiquidBaseDao;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@DynamicDataSourceAutowired(name = "his")
	@Override
	public List<DataBloodBgqc> selectDataBloodBgqcs() {
		return dataBloodBgqcbaseDao.getAll(DataBloodBgqc.class);
	}

	@DynamicDataSourceAutowired(name = "his")
	@Override
	public String selectManuFacturerByMeterNumber(String meterNumber) {
		String sql = "SELECT manu_facturer FROM glouce_meter WHERE number=?";
		try {
			return jdbcTemplate.queryForObject(sql, String.class, meterNumber);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@DynamicDataSourceAutowired(name = "his")
	@Override
	public String selectComcodeByMeterNumber(String meterNumber) {
		String sql = "SELECT comcode FROM glouce_meter WHERE number=?";
		try {
			return jdbcTemplate.queryForObject(sql, String.class, meterNumber);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public Long selectNewIdByOldId(Integer id) {
		String sql = "SELECT new_id FROM sys_blood_glucose_qa_relation WHERE old_id=?";
		try {

			return jdbcTemplate.queryForObject(sql, Long.class, id);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public SysBloodGlucoseQa insertSysBloodGlucoseQa(SysBloodGlucoseQa qa) {
		return sysBloodGlucoseQabaseDao.saveOrUpdate(qa);
	}

	@Override
	public void insertSysBloodGlucoseQaRelation(Long newId, Integer oldId) {
		String sql = "INSERT INTO sys_blood_glucose_qa_relation(new_id,old_id) VALUES(?,?)";
		jdbcTemplate.update(sql, newId, oldId);
	}

	@Override
	public void updateSysBloodGlucoseQa(SysBloodGlucoseQa qa) {
		sysBloodGlucoseQabaseDao.update(qa);
	}

	@DynamicDataSourceAutowired(name = "his")
	@Override
	public String selectUserNameById(String oprator) {
		String sql = "SELECT personname FROM prpsstaff WHERE personid=?";
		try {
			return jdbcTemplate.queryForObject(sql, String.class, oprator);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public SysQaLiquid insertSysQaLiquid(SysQaLiquid qaLiquid) {
		return sysQaLiquidBaseDao.saveOrUpdate(qaLiquid);
	}

	@Override
	public Long selectQaLiquidByLiquidNum(String liquid_num) {
		String sql = "SELECT id FROM sys_qa_liquid WHERE liquid_num=?";
		try {
			return jdbcTemplate.queryForObject(sql, Long.class, liquid_num);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public void updateSysQaLiquid(SysQaLiquid qaLiquid) {
		sysQaLiquidBaseDao.update(qaLiquid);
	}

	@DynamicDataSourceAutowired(name = "his")
	@Override
	public String selectLoginNameById(String oprator) {
		String sql = "SELECT userCode FROM prpsstaff WHERE personid=?";
		try {
			return jdbcTemplate.queryForObject(sql, String.class, oprator);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}
