package com.sybercare.hospital.migrate.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sybercare.hospital.common.ds.DynamicDataSourceAutowired;
import com.sybercare.hospital.common.utils.IHibernateBaseDao;
import com.sybercare.hospital.migrate.dao.SysGlucoseAdviceDao;
import com.sybercare.hospital.migrate.entity.MonitorModel;
import com.sybercare.hospital.migrate.entity.MonitorScheme;
import com.sybercare.hospital.migrate.entity.SysGlucoseAdvice;

@Repository
@Transactional
public class SysGlucoseAdviceDaoImpl implements SysGlucoseAdviceDao {
	@Autowired
	private IHibernateBaseDao<MonitorModel> monitorModelBaseDao;
	@Autowired
	private IHibernateBaseDao<MonitorScheme> monitorSchemeBaseDao;
	@Autowired
	private IHibernateBaseDao<SysGlucoseAdvice> sysGlucoseAdviceBaseDao;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@DynamicDataSourceAutowired(name = "his")
	@Override
	public MonitorModel selectMonitorModelById(Long monitor_model_id) {
		return monitorModelBaseDao.get(MonitorModel.class, "id", monitor_model_id);
	}

	@DynamicDataSourceAutowired(name = "his")
	@Override
	public List<MonitorScheme> selectMonitorSchemes() {
		return monitorSchemeBaseDao.getAll(MonitorScheme.class);
	}

	@Override
	public Long selectNewIdByOldId(Long monitor_scheme_id) {
		String sql = "SELECT new_id FROM sys_glucose_advice_relation WHERE old_id=?";
		try {
			return jdbcTemplate.queryForObject(sql, Long.class, monitor_scheme_id);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public void insertSysGlucoseAdviceRelation(Long id, Long monitor_scheme_id) {
		String sql = "INSERT INTO  sys_glucose_advice_relation(new_id,old_id) VALUES(?,?)";
		jdbcTemplate.update(sql, id, monitor_scheme_id);
	}

	@Override
	public void updateSysGlucoseAdvice(SysGlucoseAdvice advice) {
		sysGlucoseAdviceBaseDao.update(advice);
	}

	@Override
	public SysGlucoseAdvice insertSysGlucoseAdvice(SysGlucoseAdvice advice) {
		return sysGlucoseAdviceBaseDao.saveOrUpdate(advice);
	}

}
