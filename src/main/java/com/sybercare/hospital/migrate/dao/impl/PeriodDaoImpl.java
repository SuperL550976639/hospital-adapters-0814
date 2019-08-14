package com.sybercare.hospital.migrate.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sybercare.hospital.common.ds.DynamicDataSourceAutowired;
import com.sybercare.hospital.common.utils.IHibernateBaseDao;
import com.sybercare.hospital.migrate.dao.PeriodDao;
import com.sybercare.hospital.migrate.entity.CompanyInterval;
import com.sybercare.hospital.migrate.entity.SysDeptRelation;
import com.sybercare.hospital.migrate.entity.SysGlucosePeriod;
import com.sybercare.hospital.migrate.entity.SysPeriodRelation;

@Repository
@Transactional
public class PeriodDaoImpl implements PeriodDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private IHibernateBaseDao<SysPeriodRelation> sysPeriodDao;

	@Autowired
	private IHibernateBaseDao<SysDeptRelation> sysdeptDao;

	@Autowired
	private IHibernateBaseDao<SysGlucosePeriod> sysGlucoseDao;

	@Autowired
	private IHibernateBaseDao<SysPeriodRelation> sysPeriodReDao;

	@Override
	public List<SysGlucosePeriod> selectNewPeriod() {
		// TODO Auto-generated method stub
		String sql = "select * from sys_glucose_period";
		List<SysGlucosePeriod> sysClucoses = jdbcTemplate.query(sql,
				new BeanPropertyRowMapper<SysGlucosePeriod>(SysGlucosePeriod.class));
		return sysClucoses;
	}

	@DynamicDataSourceAutowired(name = "his")
	@Override
	public List<CompanyInterval> selectOldPeriod() {
		// TODO Auto-generated method stub
		String sql = "Select * from company_interval";
		List<CompanyInterval> companyIs = jdbcTemplate.query(sql,
				new BeanPropertyRowMapper<CompanyInterval>(CompanyInterval.class));
		return companyIs;
	}

	@Override
	public SysGlucosePeriod insertinto(SysGlucosePeriod sysGlu) {
		// TODO Auto-generated method stub
		return sysGlucoseDao.saveOrUpdate(sysGlu);
	}

	@Override
	public void insertinto(SysPeriodRelation sysPer) {
		// TODO Auto-generated method stub
		sysPeriodDao.save(sysPer);
	}

	@Override
	public List<SysDeptRelation> selectDept() {
		// TODO Auto-generated method stub
		String sql = "Select * from sys_dept_relation";
		List<SysDeptRelation> sysdepts = jdbcTemplate.query(sql,
				new BeanPropertyRowMapper<SysDeptRelation>(SysDeptRelation.class));
		return sysdepts;
	}

	@Override
	public SysDeptRelation selectDeptRe(String old_id) {
		// TODO Auto-generated method stub
		return sysdeptDao.get(SysDeptRelation.class, "old_id", old_id);
	}

	@Override
	public SysPeriodRelation selectPer(int old_id) {
		// TODO Auto-generated method stub
		return sysPeriodReDao.get(SysPeriodRelation.class, "old_id", old_id);
	}

	@Override
	public void update(SysGlucosePeriod sysGlucosePeriod) {
		// TODO Auto-generated method stub
		sysGlucoseDao.update(sysGlucosePeriod);
	}

	@Override
	public String selectrepeat(Long dept_id, String measure_period) {
		// TODO Auto-generated method stub
		String sql = "Select count(*) from sys_glucose_period where dept_id = \""+dept_id+"\""+" and measure_period = \""+measure_period+"\"";
		//System.out.println(sql);
		String count = jdbcTemplate.queryForObject(sql, String.class);
		return count;
	}

}
