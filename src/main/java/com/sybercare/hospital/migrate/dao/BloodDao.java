package com.sybercare.hospital.migrate.dao;

import java.util.List;

import com.sybercare.hospital.migrate.entity.DataBloodGlucose;
import com.sybercare.hospital.migrate.entity.Prpsstaff;
import com.sybercare.hospital.migrate.entity.SysBloodGlucose;
import com.sybercare.hospital.migrate.entity.SysBloodGlucoseRelation;
import com.sybercare.hospital.migrate.entity.SysDeptRelation;
import com.sybercare.hospital.migrate.entity.SysGlucosePeriod;
import com.sybercare.hospital.migrate.entity.SysPatientRelation;
import com.sybercare.hospital.migrate.entity.User;

public interface BloodDao {

	List<SysBloodGlucose> selectBloodG();

	SysBloodGlucoseRelation selectBloodGR(int old_id);

	List<DataBloodGlucose> selectDataB();

	User selectUserName(String user_id);

	SysBloodGlucose instertid(SysBloodGlucose bloodGlucose);

	void instertBloodR(SysBloodGlucoseRelation bloodGlucoseRelation);

	void updateBloodG(SysBloodGlucose bloodGlucose);

	SysPatientRelation selectuserid(String old_id);

	// SysPatient selectdept(int patient_id);

	// List<SysGlucosePeriod> selectperiod(int dept_id);

	SysGlucosePeriod selectperiod(Long dept_id, String measure_period);

	SysDeptRelation selectuserdept(String old_id);
	
	Prpsstaff selectStaffName(String personid);

}
