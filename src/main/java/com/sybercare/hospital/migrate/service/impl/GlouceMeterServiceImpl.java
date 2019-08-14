package com.sybercare.hospital.migrate.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sybercare.hospital.common.utils.DateUtils;
import com.sybercare.hospital.migrate.dao.GlouceMeterDao;
import com.sybercare.hospital.migrate.dao.SysDeptDao;
import com.sybercare.hospital.migrate.entity.GlouceMeter;
import com.sybercare.hospital.migrate.entity.SysEquipment;
import com.sybercare.hospital.migrate.service.MigrateService;

@Service("glouceMeterService")
public class GlouceMeterServiceImpl implements MigrateService {
	@Autowired
	private GlouceMeterDao glouceMeterDao;
	@Autowired
	private SysDeptDao sysDeptDao;

	@Override
	public void doMigrate() {
		System.out.println(DateUtils.fmtDate(new Date(), 16) + "==========血糖仪信息迁移开始==========");
		List<GlouceMeter> meters = glouceMeterDao.selectGloceMeters();
		if (meters != null && !meters.isEmpty()) {
			for (GlouceMeter meter : meters) {
				SysEquipment equipment = new SysEquipment();
				equipment.setDept_id(sysDeptDao.selectNewIdByOldId(meter.getComcode()));
				equipment.setEquipment_type("glucose");
				equipment.setEquipment_sn(meter.getNumber());
				equipment.setManufactor(meter.getManu_facturer());
				equipment.setProduct_model(meter.getProduct_model());
				equipment.setStatus("1".equals(meter.getStatus()) ? "0" : "1");
				Long newId = glouceMeterDao.selectNewIdByOldId(meter.getId());
				if (newId == null) {
					SysEquipment sysEquipment = glouceMeterDao.insertSysEquipment(equipment);
					glouceMeterDao.insertSysEquipmentRelation(sysEquipment.getId(), meter.getId());
				} else {
					equipment.setId(newId);
					glouceMeterDao.updateSysEquipment(equipment);
				}

			}
		}
		System.out.println(DateUtils.fmtDate(new Date(), 16) + "==========血糖仪信息迁移结束==========");
	}

}
