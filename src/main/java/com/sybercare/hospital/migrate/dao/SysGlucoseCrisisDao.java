package com.sybercare.hospital.migrate.dao;

import java.util.List;

import com.sybercare.hospital.migrate.entity.CompanyEmergencyConfig;
import com.sybercare.hospital.migrate.entity.SysGlucoseCrisis;

public interface SysGlucoseCrisisDao {

	List<CompanyEmergencyConfig> selectCompanyEmergencyConfigs();

	Long selectNewIdByOldId(Long id);

	SysGlucoseCrisis insertSysGlucoseCrisis(SysGlucoseCrisis crisis);

	void insertSysGlucoseCrisisRelation(Long newId, Long oldId);

	void updateSysGlucoseCrisis(SysGlucoseCrisis crisis);

}
