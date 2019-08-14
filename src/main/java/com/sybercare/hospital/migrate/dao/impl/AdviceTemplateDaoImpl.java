package com.sybercare.hospital.migrate.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sybercare.hospital.common.ds.DynamicDataSourceAutowired;
import com.sybercare.hospital.common.utils.IHibernateBaseDao;
import com.sybercare.hospital.migrate.dao.AdviceTemplateDao;
import com.sybercare.hospital.migrate.entity.MonitorTemplate;
import com.sybercare.hospital.migrate.entity.SysAdviceTemplate;

@Repository
@Transactional
public class AdviceTemplateDaoImpl implements AdviceTemplateDao {
	@Autowired
	private IHibernateBaseDao<SysAdviceTemplate> sysAdviceTemplateBaseDao;
	@Autowired
	private IHibernateBaseDao<MonitorTemplate> monitorTemplateBaseDao;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@DynamicDataSourceAutowired(name = "his")
	@Override
	public List<MonitorTemplate> selectMonitorTemplates() {
		List<MonitorTemplate> monitorTemplates = monitorTemplateBaseDao.getAll(MonitorTemplate.class);
		return monitorTemplates;
	}

	@Override
	public SysAdviceTemplate insertSysAdviceTemplate(SysAdviceTemplate adviceTemplate) {
		return sysAdviceTemplateBaseDao.saveOrUpdate(adviceTemplate);

	}

	@Override
	public Long selectNewIdByOldId(Long id) {
		String sql = "SELECT new_id FROM sys_advice_template_relation WHERE old_id=?";
		try {
			return jdbcTemplate.queryForObject(sql, Long.class, id);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public void insertSysAdviceTemplateRelation(Long id, Long id2) {
		String sql = "INSERT INTO sys_advice_template_relation(new_id,old_id) VALUES(?,?)";
		jdbcTemplate.update(sql, id, id2);
	}

	@Override
	public void updateSysAdviceTemplate(SysAdviceTemplate adviceTemplate) {
		sysAdviceTemplateBaseDao.update(adviceTemplate);
	}

}
