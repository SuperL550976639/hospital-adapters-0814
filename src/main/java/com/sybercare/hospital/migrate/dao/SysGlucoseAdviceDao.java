package com.sybercare.hospital.migrate.dao;

import java.util.List;

import com.sybercare.hospital.migrate.entity.MonitorModel;
import com.sybercare.hospital.migrate.entity.MonitorScheme;
import com.sybercare.hospital.migrate.entity.SysGlucoseAdvice;

public interface SysGlucoseAdviceDao {

	MonitorModel selectMonitorModelById(Long monitor_model_id);

	List<MonitorScheme> selectMonitorSchemes();

	Long selectNewIdByOldId(Long monitor_scheme_id);


	void updateSysGlucoseAdvice(SysGlucoseAdvice advice);

	SysGlucoseAdvice insertSysGlucoseAdvice(SysGlucoseAdvice advice);

	void insertSysGlucoseAdviceRelation(Long id, Long monitor_scheme_id);

}
