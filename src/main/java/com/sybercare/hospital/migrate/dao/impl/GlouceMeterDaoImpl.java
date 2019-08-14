package com.sybercare.hospital.migrate.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sybercare.hospital.common.ds.DynamicDataSourceAutowired;
import com.sybercare.hospital.common.utils.IHibernateBaseDao;
import com.sybercare.hospital.migrate.dao.GlouceMeterDao;
import com.sybercare.hospital.migrate.entity.GlouceMeter;
import com.sybercare.hospital.migrate.entity.SysEquipment;

@Repository
@Transactional
public class GlouceMeterDaoImpl implements GlouceMeterDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private IHibernateBaseDao<SysEquipment> sysEquipmentBaseDao;
	@Autowired
	private IHibernateBaseDao<GlouceMeter> glouceMeterBaseDao;

	@Override
	public Long selectNewIdByOldId(Integer id) {
		String sql = "SELECT new_id FROM sys_equipment_relation WHERE old_id=?";
		try {
			return jdbcTemplate.queryForObject(sql, Long.class, id);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public void insertSysEquipmentRelation(Long newId, Integer oldId) {
		String sql = "INSERT INTO sys_equipment_relation(new_id,old_id) VALUES(?,?)";
		jdbcTemplate.update(sql, newId, oldId);
	}

	@Override
	public SysEquipment insertSysEquipment(SysEquipment equipment) {
		return sysEquipmentBaseDao.saveOrUpdate(equipment);
	}

	@Override
	public void updateSysEquipment(SysEquipment equipment) {
		sysEquipmentBaseDao.update(equipment);
	}

	@DynamicDataSourceAutowired(name = "his")
	@Override
	public List<GlouceMeter> selectGloceMeters() {
		return glouceMeterBaseDao.getAll(GlouceMeter.class);
	}

}
