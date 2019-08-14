package com.sybercare.hospital.migrate.dao;


import java.util.List;

import com.sybercare.hospital.migrate.entity.CompanyInterval;
import com.sybercare.hospital.migrate.entity.SysDeptRelation;
import com.sybercare.hospital.migrate.entity.SysGlucosePeriod;
import com.sybercare.hospital.migrate.entity.SysPeriodRelation;

public interface PeriodDao {
	
	List<SysGlucosePeriod> selectNewPeriod();
	
	List<CompanyInterval> selectOldPeriod();
	
	SysGlucosePeriod insertinto(SysGlucosePeriod sysGlu);
	
	void insertinto(SysPeriodRelation sysPer);
	
	List<SysDeptRelation> selectDept();
	
	SysDeptRelation selectDeptRe(String old_id);
	
	SysPeriodRelation selectPer(int old_id);
	
	void update(SysGlucosePeriod sysGlucosePeriod);
	
	String selectrepeat(Long dept_id, String measure_period);

}

