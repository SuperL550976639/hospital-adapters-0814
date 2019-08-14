package com.sybercare.hospital.migrate.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sybercare.hospital.common.utils.DateUtils;
import com.sybercare.hospital.common.utils.UserException;
import com.sybercare.hospital.migrate.dao.PatientDao;
import com.sybercare.hospital.migrate.dao.SysDeptDao;
import com.sybercare.hospital.migrate.dao.SysGlucoseAdviceDao;
import com.sybercare.hospital.migrate.dao.SysUserDao;
import com.sybercare.hospital.migrate.entity.MonitorModel;
import com.sybercare.hospital.migrate.entity.MonitorScheme;
import com.sybercare.hospital.migrate.entity.SysGlucoseAdvice;
import com.sybercare.hospital.migrate.service.MigrateService;

@Service("sysGlucoseAdviceService")
public class SysGlucoseAdviceServiceImpl implements MigrateService {
	@Autowired
	private SysGlucoseAdviceDao adviceDao;
	@Autowired
	private PatientDao patientDao;
	@Autowired
	private SysUserDao sysUserDao;
	@Autowired
	private SysDeptDao sysDeptDao;

	@Override
	public void doMigrate() throws UserException {
		System.out.println(DateUtils.fmtDate(new Date(), 16) + "==========医嘱迁移开始==========");
		List<MonitorScheme> monitorSchemes = adviceDao.selectMonitorSchemes();
		if (monitorSchemes != null && !monitorSchemes.isEmpty()) {
			for (MonitorScheme monitorScheme : monitorSchemes) {
				SysGlucoseAdvice advice = new SysGlucoseAdvice();
				advice.setPatient_id(patientDao.selectNewIdByOldId(monitorScheme.getUser_id()));
				advice.setPatient_name(patientDao.selectPatientNameById(monitorScheme.getUser_id()));
				advice.setAdvice_type(monitorScheme.getMonitor_scheme_type() == 1 ? "LongStandards" : "Temporary");
				advice.setTemplate_name(monitorScheme.getMonitor_scheme_content());
				advice.setAdvice_name(monitorScheme.getMonitor_scheme_name());
				MonitorModel model = adviceDao.selectMonitorModelById(monitorScheme.getMonitor_model_id());
				if (monitorScheme.getMonitor_scheme_type() == 1 && model != null) {
					advice.setAdvice_content(getAdviceContent(model));
				}
				advice.setStart_time(monitorScheme.getStart_date());
				advice.setEnd_time(monitorScheme.getEnd_date());
				advice.setStatus(monitorScheme.getStatus() == 3 ? "1" : "0");
				advice.setRemark(monitorScheme.getMonitor_scheme_remark());
				advice.setCreate_by(sysUserDao.selectUserCodeByPersonId(monitorScheme.getPerson_id()));
				String doctorName = sysUserDao
						.seleDoctorNameById(monitorScheme.getDoctor_id() != null ? monitorScheme.getDoctor_id()
								: monitorScheme.getPerson_id());
				advice.setCreate_name(doctorName == null ? "" : doctorName);
				advice.setCreate_time(monitorScheme.getRecord_date());
				advice.setDept_id(sysDeptDao.selectNewIdByOldId(monitorScheme.getComcode()));
				Long newId = adviceDao.selectNewIdByOldId(monitorScheme.getMonitor_scheme_id());
				if (newId == null) {
					SysGlucoseAdvice sysGlucoseAdvice = adviceDao.insertSysGlucoseAdvice(advice);
					adviceDao.insertSysGlucoseAdviceRelation(sysGlucoseAdvice.getId(),
							monitorScheme.getMonitor_scheme_id());
				} else {
					advice.setId(newId);
					adviceDao.updateSysGlucoseAdvice(advice);
				}
			}
		}
		System.out.println(DateUtils.fmtDate(new Date(), 16) + "==========医嘱迁移结束==========");
	}

	private String getAdviceContent(MonitorModel model) {
		StringBuilder content = new StringBuilder("[");
		content.append("critical".equals(model.getFpg_frequency_status())
				? "{\"checked\":true,\"label\":\"空腹\",\"value\":\"KF\"},"
				: "{\"checked\":false,\"label\":\"空腹\",\"value\":\"KF\"},");
		content.append("critical".equals(model.getAfter_breakfast_frequency_status())
				? "{\"checked\":true,\"label\":\"早餐后\",\"value\":\"ZCH\"},"
				: "{\"checked\":false,\"label\":\"早餐后\",\"value\":\"ZCH\"},");
		content.append("critical".equals(model.getBefore_lunch_frequency_status())
				? "{\"checked\":true,\"label\":\"午餐前\",\"value\":\"WUCQ\"},"
				: "{\"checked\":false,\"label\":\"午餐前\",\"value\":\"WUCQ\"},");
		content.append("critical".equals(model.getAfter_lunch_frequency_status())
				? "{\"checked\":true,\"label\":\"午餐后\",\"value\":\"WUCH\"},"
				: "{\"checked\":false,\"label\":\"午餐后\",\"value\":\"WUCH\"},");
		content.append("critical".equals(model.getBefore_dinner_frequency_status())
				? "{\"checked\":true,\"label\":\"晚餐前\",\"value\":\"WACQ\"},"
				: "{\"checked\":false,\"label\":\"晚餐前\",\"value\":\"WACQ\"},");
		content.append("critical".equals(model.getAfter_dinner_frequency_status())
				? "{\"checked\":true,\"label\":\"晚餐后\",\"value\":\"WACH\"},"
				: "{\"checked\":false,\"label\":\"晚餐后\",\"value\":\"WACH\"},");
		content.append("critical".equals(model.getBefore_sleep_frequency_status())
				? "{\"checked\":true,\"label\":\"睡前\",\"value\":\"SQ\"},"
				: "{\"checked\":false,\"label\":\"睡前\",\"value\":\"SQ\"},");
		content.append("critical".equals(model.getDuring_night_frequency_status())
				? "{\"checked\":true,\"label\":\"凌晨\",\"value\":\"LC\"},"
				: "{\"checked\":false,\"label\":\"凌晨\",\"value\":\"LC\"},");
		content.append("critical".equals(model.getDawn_frequency_status())
				? "{\"checked\":true,\"label\":\"凌晨3点\",\"value\":\"LC3\"}]"
				: "{\"checked\":fa;se,\"label\":\"凌晨3点\",\"value\":\"LC3\"}]");
		return content.toString();
	}

}
