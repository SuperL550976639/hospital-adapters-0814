package com.sybercare.hospital.migrate.dao;

import java.util.List;

import com.sybercare.hospital.migrate.entity.MonitorTemplate;
import com.sybercare.hospital.migrate.entity.SysAdviceTemplate;

public interface AdviceTemplateDao {

	List<MonitorTemplate> selectMonitorTemplates();

	SysAdviceTemplate insertSysAdviceTemplate(SysAdviceTemplate adviceTemplate);

	Long selectNewIdByOldId(Long id);

	void insertSysAdviceTemplateRelation(Long id, Long id2);

	void updateSysAdviceTemplate(SysAdviceTemplate adviceTemplate);

}
