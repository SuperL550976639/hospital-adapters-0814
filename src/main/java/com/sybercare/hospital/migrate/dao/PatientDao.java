package com.sybercare.hospital.migrate.dao;

import java.util.List;

import com.sybercare.hospital.migrate.entity.SysPatient;
import com.sybercare.hospital.migrate.entity.SysPatientRelation;
import com.sybercare.hospital.migrate.entity.User;
import com.sybercare.hospital.migrate.entity.UserPatient;

public interface PatientDao {

	List<User> selectUsers();

	List<UserPatient> selectUserPatients();

	UserPatient selectUserPatientByUserId(String userId);

	SysPatient insertSysPatient(SysPatient patient);

	SysPatient selectSysPatientByUserName(String patient_name);

	void updateSysPatient(SysPatient patient);

	SysPatientRelation insertSysPatientRelation(SysPatientRelation sysPatientRelation);

	Long selectNewIdByOldId(String userId);

	String selectPatientNameById(String user_id);

}