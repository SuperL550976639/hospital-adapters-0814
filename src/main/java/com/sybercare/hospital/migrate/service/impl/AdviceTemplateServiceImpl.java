package com.sybercare.hospital.migrate.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sybercare.hospital.common.utils.DateUtils;
import com.sybercare.hospital.migrate.dao.AdviceTemplateDao;
import com.sybercare.hospital.migrate.dao.SysDeptDao;
import com.sybercare.hospital.migrate.entity.MonitorTemplate;
import com.sybercare.hospital.migrate.entity.SysAdviceTemplate;
import com.sybercare.hospital.migrate.service.MigrateService;

@Service("adviceTemplateService")
public class AdviceTemplateServiceImpl implements MigrateService {
	@Autowired
	private AdviceTemplateDao adviceTemplateDao;
	@Autowired
	private SysDeptDao sysDeptDao;

	@Override
	public void doMigrate() {
		System.out.println(DateUtils.fmtDate(new Date(), 16) + "==========医嘱模板迁移开始==========");
		List<MonitorTemplate> monitorTemplates = adviceTemplateDao.selectMonitorTemplates();
		if (monitorTemplates != null && !monitorTemplates.isEmpty()) {
			for (MonitorTemplate monitorTemplate : monitorTemplates) {
				if ("1".equals(monitorTemplate.getMeasure_type() + "")) {
					continue;
				}
				SysAdviceTemplate adviceTemplate = new SysAdviceTemplate();
				adviceTemplate.setDept_id(sysDeptDao.selectNewIdByOldId(monitorTemplate.getComcode()));
				adviceTemplate.setTemplate_name(monitorTemplate.getMonitor_template_name());
				if ("0".equals(monitorTemplate.getMonitor_template_type())) {
					adviceTemplate.setTemplate_type("LongStandards");
				}
				if ("1".equals(monitorTemplate.getMonitor_template_type())) {
					adviceTemplate.setTemplate_type("Temporary");
				}
				adviceTemplate.setStatus("0");
				StringBuilder content = new StringBuilder("[");
				content.append("1".equals(monitorTemplate.getFpg_frequency_status())
						? "{\"value\":\"KF\",\"label\":\"空腹\",\"checked\":true},"
						: "");
				content.append("1".equals(monitorTemplate.getAfter_breakfast_frequency_status())
						? "{\"value\":\"ZCH\",\"label\":\"早餐后\",\"checked\":true},"
						: "");
				content.append("1".equals(monitorTemplate.getBefore_lunch_frequency_status())
						? "{\"value\":\"WUCQ\",\"label\":\"午餐前\",\"checked\":true},"
						: "");
				content.append("1".equals(monitorTemplate.getAfter_lunch_frequency_status())
						? "{\"value\":\"WUCH\",\"label\":\"午餐后\",\"checked\":true},"
						: "");
				content.append("1".equals(monitorTemplate.getBefore_dinner_frequency_status())
						? "{\"value\":\"WACQ\",\"label\":\"晚餐前\",\"checked\":true},"
						: "");
				content.append("1".equals(monitorTemplate.getAfter_dinner_frequency_status())
						? "{\"value\":\"WACH\",\"label\":\"晚餐后\",\"checked\":true},"
						: "");
				content.append("1".equals(monitorTemplate.getBefore_sleep_frequency_status())
						? "{\"value\":\"SQ\",\"label\":\"睡前\",\"checked\":true},"
						: "");
				content.append("1".equals(monitorTemplate.getDuring_night_frequency_status())
						? "{\"value\":\"LC\",\"label\":\"凌晨\",\"checked\":true},"
						: "");
				content.append("1".equals(monitorTemplate.getDawn_frequency_status())
						? "{\"value\":\"LC3\",\"label\":\"凌晨3点\",\"checked\":true}"
						: "");
				if (content.length() < 2) {
					content.append("{\"value\":\"WU\",\"label\":\"无\",\"checked\":true}");
				} else {
					if (!content.toString().contains("LC3")) {
						content.deleteCharAt(content.lastIndexOf(","));
					}
				}
				content.append("]");
				adviceTemplate.setTemplate_content(content.toString());
				Long newId = adviceTemplateDao.selectNewIdByOldId(monitorTemplate.getId());
				if (newId == null) {
					SysAdviceTemplate sysAdviceTemplate = adviceTemplateDao.insertSysAdviceTemplate(adviceTemplate);
					adviceTemplateDao.insertSysAdviceTemplateRelation(sysAdviceTemplate.getId(),
							monitorTemplate.getId());
				} else {
					adviceTemplate.setId(newId);
					adviceTemplateDao.updateSysAdviceTemplate(adviceTemplate);
				}
			}
		}
		System.out.println(DateUtils.fmtDate(new Date(), 16) + "==========医嘱模板迁移结束==========");
	}

}
