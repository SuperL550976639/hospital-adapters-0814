package com.sybercare.hospital.migrate.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sybercare.hospital.common.utils.UserException;
import com.sybercare.hospital.migrate.service.MigrateService;
import com.sybercare.hospital.migrate.utils.BeanUtils;
import com.sybercare.hospital.migrate.utils.Constants;

@Component
public class MigrateManager {
	private List<String> beanNames = new ArrayList<String>();

	public MigrateManager() {
		beanNames.add(Constants.ROLE_SERVICE);//角色
		beanNames.add(Constants.DEPT_SERVICE);//部门
		beanNames.add(Constants.USER_SERVICE);//员工
		beanNames.add(Constants.PATIENT_SERVICE);//患者
		beanNames.add(Constants.TEMPLATE_SERVICE);//医嘱模板
		beanNames.add(Constants.ADVICE_SERVICE);//医嘱
		beanNames.add(Constants.METER_SERVICE);//血糖仪
		beanNames.add(Constants.QA_SERVICE);//质控记录
		beanNames.add(Constants.CRISIS_SERVICE);//危机预警值
		beanNames.add(Constants.PERIOD_SERVICE);//测量时段
		beanNames.add(Constants.BLOOD_SERVICE);//血糖记录
	}

	public void executor() {
		for (String beanName : beanNames) {
			Object object = BeanUtils.getBean(beanName);
			if (object instanceof MigrateService) {
				MigrateService service = (MigrateService) object;
				try {
					service.doMigrate();
				} catch (UserException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
