package com.sybercare.hospital.migrate.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sybercare.hospital.common.ds.DynamicDataSourceAutowired;
import com.sybercare.hospital.common.utils.IHibernateBaseDao;
import com.sybercare.hospital.migrate.dao.BloodDao;
import com.sybercare.hospital.migrate.entity.DataBloodGlucose;
import com.sybercare.hospital.migrate.entity.Prpsstaff;
import com.sybercare.hospital.migrate.entity.SysBloodGlucose;
import com.sybercare.hospital.migrate.entity.SysBloodGlucoseRelation;
import com.sybercare.hospital.migrate.entity.SysDeptRelation;
import com.sybercare.hospital.migrate.entity.SysGlucosePeriod;
import com.sybercare.hospital.migrate.entity.SysPatientRelation;
import com.sybercare.hospital.migrate.entity.User;

@Repository
@Transactional
public class BloodDaoImpl implements BloodDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private IHibernateBaseDao<SysBloodGlucose> sysBloodGlucosedao;

	@Autowired
	private IHibernateBaseDao<SysBloodGlucoseRelation> sysBloodGlucoseRelationdao;

	@Autowired
	private IHibernateBaseDao<User> userdao;

	@Autowired
	private IHibernateBaseDao<SysPatientRelation> patientiddao;

	@Autowired
	private IHibernateBaseDao<DataBloodGlucose> dataBloodGluosedao;

	@Autowired
	private IHibernateBaseDao<Prpsstaff> prpsstaffdao;

	/*
	 * @Autowired private IHibernateBaseDao<SysPatient> patientdao;
	 */

	@Autowired
	private IHibernateBaseDao<SysDeptRelation> deptdao;

	@Override
	public List<SysBloodGlucose> selectBloodG() {
		// TODO Auto-generated method stub
		String sql = "Select * from sys_blood_glucose";
		List<SysBloodGlucose> bloodGlucoses = jdbcTemplate.query(sql,
				new BeanPropertyRowMapper<SysBloodGlucose>(SysBloodGlucose.class));
		return bloodGlucoses;
	}

	@Override
	public SysBloodGlucoseRelation selectBloodGR(int old_id) {
		// TODO Auto-generated method stub
		// String sql = "Select * from sys_blood_glucose_relation where old_id =
		// \""+old_id+"\"";
		// System.out.println(sql);
		// SysBloodGlucoseRelation bloodGlucoseRelation =
		// jdbcTemplate.queryForObject(sql, new
		// BeanPropertyRowMapper<SysBloodGlucoseRelation>(SysBloodGlucoseRelation.class));
		// return sysBloodGlucoseRelationdao.get(SysBloodGlucoseRelation.class,
		// "old_id", old_id);
		return sysBloodGlucoseRelationdao.get(SysBloodGlucoseRelation.class, "old_id", old_id);
	}

	@DynamicDataSourceAutowired(name = "his")
	@Override
	public User selectUserName(String user_id) {
		// TODO Auto-generated method stub
		return userdao.get(User.class, "user_id", user_id);
	}

	@Override
	public SysBloodGlucose instertid(SysBloodGlucose bloodGlucose) {
		// TODO Auto-generated method stub
		return sysBloodGlucosedao.saveOrUpdate(bloodGlucose);
	}

	@Override
	public void instertBloodR(SysBloodGlucoseRelation bloodGlucoseRelation) {
		// TODO Auto-generated method stub
		sysBloodGlucoseRelationdao.saveOrUpdate(bloodGlucoseRelation);
	}

	@Override
	public void updateBloodG(SysBloodGlucose bloodGlucose) {
		// TODO Auto-generated method stub
		sysBloodGlucosedao.update(bloodGlucose);
	}

	@DynamicDataSourceAutowired(name = "his")
	@Override
	public List<DataBloodGlucose> selectDataB() {
		// TODO Auto-generated method stub
		/*
		 * String sql = "Select * from data_blood_glucose"; List<DataBloodGlucose>
		 * dataBloodGlucoses = jdbcTemplate.query(sql, new
		 * BeanPropertyRowMapper<DataBloodGlucose>(DataBloodGlucose.class));
		 */
		return dataBloodGluosedao.getAll(DataBloodGlucose.class);
	}

	@Override
	public SysPatientRelation selectuserid(String old_id) {
		// TODO Auto-generated method stub
		return patientiddao.get(SysPatientRelation.class, "old_id", old_id);
	}

	/*
	 * @Override public SysPatient selectdept(int patient_id) { // TODO
	 * Auto-generated method stub return patientdao.get(SysPatient.class,
	 * "patient_id", patient_id); }
	 */

	@Override
	public SysGlucosePeriod selectperiod(Long dept_id, String measure_period) {
		// TODO Auto-generated method stub
		String sql = "Select * from sys_glucose_period where dept_id=" + dept_id + " and measure_period=\""
				+ measure_period + "\"";
		// System.out.println(sql);
		SysGlucosePeriod glucosePeriod = jdbcTemplate.queryForObject(sql,
				new BeanPropertyRowMapper<SysGlucosePeriod>(SysGlucosePeriod.class));
		return glucosePeriod;
	}

	@Override
	public SysDeptRelation selectuserdept(String old_id) {
		// TODO Auto-generated method stub
		/*
		 * String sql =
		 * "Select new_id from sys_dept_relation where old_id=\""+old_id+"\"";
		 * SysDeptRelation deptRelation = jdbcTemplate.queryForObject(sql, new
		 * BeanPropertyRowMapper<SysDeptRelation>(SysDeptRelation.class));
		 */
		return deptdao.get(SysDeptRelation.class, "old_id", old_id);
	}

	@DynamicDataSourceAutowired(name = "his")
	@Override
	public Prpsstaff selectStaffName(String personid) {
		// TODO Auto-generated method stub
		/*
		 * String sql =
		 * "Select personname from prpsstaff where personid = \""+person_id+"\"";
		 * Prpsstaff prpsstaff = jdbcTemplate.queryForObject(sql, new
		 * BeanPropertyRowMapper<Prpsstaff>(Prpsstaff.class));
		 */
		return prpsstaffdao.get(Prpsstaff.class, "personid", personid);
	}

}
