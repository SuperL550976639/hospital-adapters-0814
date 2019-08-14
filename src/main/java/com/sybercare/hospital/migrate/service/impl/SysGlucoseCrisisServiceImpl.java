package com.sybercare.hospital.migrate.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sybercare.hospital.common.utils.DateUtils;
import com.sybercare.hospital.migrate.dao.SysDeptDao;
import com.sybercare.hospital.migrate.dao.SysGlucoseCrisisDao;
import com.sybercare.hospital.migrate.entity.CompanyEmergencyConfig;
import com.sybercare.hospital.migrate.entity.SysGlucoseCrisis;
import com.sybercare.hospital.migrate.service.MigrateService;

@Service("sysGlucoseCrisisService")
public class SysGlucoseCrisisServiceImpl implements MigrateService {
	@Autowired
	private SysGlucoseCrisisDao sysGlucoseCrisisDao;
	@Autowired
	private SysDeptDao sysDeptDao;

	@Override
	public void doMigrate() {
		System.out.println(DateUtils.fmtDate(new Date(), 16) + "==========危急值迁移开始==========");
		List<CompanyEmergencyConfig> configs = sysGlucoseCrisisDao.selectCompanyEmergencyConfigs();
		if (configs != null && !configs.isEmpty()) {
			for (CompanyEmergencyConfig config : configs) {
				if ("0".equals(config.getMeasure_type() + "")) {
					SysGlucoseCrisis crisis = new SysGlucoseCrisis();
					crisis.setDept_id(sysDeptDao.selectNewIdByOldId(config.getCom_code()));
					crisis.setHigh_value(config.getEmergency_high());
					crisis.setHigh_color("red");
					crisis.setLow_value(config.getEmergency_low());
					crisis.setLow_color("yellow");
					crisis.setStatus("1".equals(config.getStatus()) ? "0" : "1");
					Long newId = sysGlucoseCrisisDao.selectNewIdByOldId(config.getId());
					if (newId == null) {
						SysGlucoseCrisis glucoseCrisis = sysGlucoseCrisisDao.insertSysGlucoseCrisis(crisis);
						sysGlucoseCrisisDao.insertSysGlucoseCrisisRelation(glucoseCrisis.getId(), config.getId());
					} else {
						crisis.setId(newId);
						sysGlucoseCrisisDao.updateSysGlucoseCrisis(crisis);
					}
				}
			}
		}
		System.out.println(DateUtils.fmtDate(new Date(), 16) + "==========危急值迁移结束==========");
	}

}
