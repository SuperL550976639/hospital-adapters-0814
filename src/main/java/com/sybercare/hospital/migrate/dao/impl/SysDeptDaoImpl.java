package com.sybercare.hospital.migrate.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sybercare.hospital.common.ds.DynamicDataSourceAutowired;
import com.sybercare.hospital.common.utils.IHibernateBaseDao;
import com.sybercare.hospital.migrate.dao.SysDeptDao;
import com.sybercare.hospital.migrate.entity.Prpscompany;
import com.sybercare.hospital.migrate.entity.SysDept;
import com.sybercare.hospital.migrate.entity.SysDeptRelation;

@Repository
@Transactional
public class SysDeptDaoImpl implements SysDeptDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private IHibernateBaseDao<Prpscompany> prpscompanyDao;
	@Autowired
	private IHibernateBaseDao<SysDept> sysDeptDao;
	@Autowired
	private IHibernateBaseDao<SysDeptRelation> sysDeptRelationDao;

	@DynamicDataSourceAutowired(name = "his")
	@Override
	public List<Prpscompany> selectPrpscompanies() {
		return prpscompanyDao.getAll(Prpscompany.class);
	}

	@DynamicDataSourceAutowired(name = "his")
	@Override
	public String selectParentNameByComcode(String comcode) {
		String sql = "SELECT comcname FROM prpscompany WHERE comcode=?";
		try {
			return jdbcTemplate.queryForObject(sql, String.class, comcode);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@DynamicDataSourceAutowired(name = "his")
	@Override
	public String selectWristBandTypeByComcode(String comcode) {
		String sql = "SELECT num_task_type FROM company_configure WHERE comcode=?";
		try {
			return jdbcTemplate.queryForObject(sql, String.class, comcode);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@DynamicDataSourceAutowired(name = "his")
	@Override
	public String selectUppercomcodeByComcode(String comcode) {
		String sql = "SELECT uppercomcode FROM prpscompany WHERE comcode=?";
		try {
			return jdbcTemplate.queryForObject(sql, String.class, comcode);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public SysDept insertSysDept(SysDept dept) {
		return sysDeptDao.saveOrUpdate(dept);
	}

	@Override
	public void insertSysDeptRelation(SysDeptRelation sysDeptRelation) {
		sysDeptRelationDao.save(sysDeptRelation);
	}

	@Override
	public void updateSysDept(SysDept dept) {
		sysDeptDao.update(dept);
	}

	@Override
	public List<SysDept> selectSysdepts() {
		return sysDeptDao.getAll(SysDept.class);
	}

	@Override
	public String selectOldIdByNewId(Long dept_id) {
		String sql = "SELECT old_id FROM sys_dept_relation WHERE new_id=?";
		try {
			return jdbcTemplate.queryForObject(sql, String.class, dept_id);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public Long selectNewIdByOldId(String comcode) {
		String sql = "SELECT new_id FROM sys_dept_relation WHERE old_id=?";
		try {
			return jdbcTemplate.queryForObject(sql, Long.class, comcode);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}
