package com.sybercare.hospital.migrate.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sybercare.hospital.common.ds.DynamicDataSourceAutowired;
import com.sybercare.hospital.common.utils.IHibernateBaseDao;
import com.sybercare.hospital.migrate.dao.SysGlucoseCrisisDao;
import com.sybercare.hospital.migrate.entity.CompanyEmergencyConfig;
import com.sybercare.hospital.migrate.entity.SysGlucoseCrisis;

@Repository
@Transactional
public class SysGlucoseCrisisDaoImpl implements SysGlucoseCrisisDao {
	@Autowired
	private IHibernateBaseDao<CompanyEmergencyConfig> companyEmergencyConfig;
	@Autowired
	private IHibernateBaseDao<SysGlucoseCrisis> sysGlucoseCrisis;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@DynamicDataSourceAutowired(name = "his")
	@Override
	public List<CompanyEmergencyConfig> selectCompanyEmergencyConfigs() {
		return companyEmergencyConfig.getAll(CompanyEmergencyConfig.class);
	}

	@Override
	public Long selectNewIdByOldId(Long id) {
		String sql = "SELECT new_id FROM sys_glucose_crisis_relation WHERE old_id=?";
		try {
			return jdbcTemplate.queryForObject(sql, Long.class, id);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public SysGlucoseCrisis insertSysGlucoseCrisis(SysGlucoseCrisis crisis) {
		return sysGlucoseCrisis.saveOrUpdate(crisis);
	}

	@Override
	public void insertSysGlucoseCrisisRelation(Long newId, Long oldId) {
		String sql = "INSERT INTO sys_glucose_crisis_relation(new_id,old_id) VALUES(?,?)";
		jdbcTemplate.update(sql, newId, oldId);
	}

	@Override
	public void updateSysGlucoseCrisis(SysGlucoseCrisis crisis) {
		sysGlucoseCrisis.update(crisis);
	}

}
