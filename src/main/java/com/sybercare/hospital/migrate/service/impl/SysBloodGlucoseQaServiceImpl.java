package com.sybercare.hospital.migrate.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sybercare.hospital.common.utils.DateUtils;
import com.sybercare.hospital.common.utils.UserException;
import com.sybercare.hospital.migrate.dao.SysBloodGlucoseQaDao;
import com.sybercare.hospital.migrate.dao.SysDeptDao;
import com.sybercare.hospital.migrate.entity.DataBloodBgqc;
import com.sybercare.hospital.migrate.entity.SysBloodGlucoseQa;
import com.sybercare.hospital.migrate.entity.SysQaLiquid;
import com.sybercare.hospital.migrate.service.MigrateService;

@Service("sysBloodGlucoseQaService")
public class SysBloodGlucoseQaServiceImpl implements MigrateService {
	@Autowired
	private SysBloodGlucoseQaDao sysBloodGlucoseQaDao;
	@Autowired
	private SysDeptDao sysDeptDao;

	@Override
	public void doMigrate() throws UserException {
		System.out.println(DateUtils.fmtDate(new Date(), 16) + "==========质控记录迁移开始==========");
		List<DataBloodBgqc> bgqcs = sysBloodGlucoseQaDao.selectDataBloodBgqcs();
		if (bgqcs != null && !bgqcs.isEmpty()) {
			for (DataBloodBgqc bgqc : bgqcs) {

				SysBloodGlucoseQa qa = new SysBloodGlucoseQa();
				SysQaLiquid qaLiquid = new SysQaLiquid();
				qaLiquid.setStatus("0");

				Long deptId = getDeptId(bgqc.getMeter_number());
				qa.setDept_id(deptId == null ? -1L : deptId);
				qaLiquid.setDept_id(deptId == null ? -1L : deptId);

				String liquidType = getLiquidType(bgqc.getBgqc_type());
				qa.setLiquid_type(liquidType);
				qaLiquid.setLiquid_type(liquidType);

				String liquidNum = bgqc.getBgqc_number();
				qa.setLiquid_num(liquidNum);
				qaLiquid.setLiquid_num(liquidNum);

				String manufactor = sysBloodGlucoseQaDao.selectManuFacturerByMeterNumber(bgqc.getMeter_number());
				qa.setManufactor(manufactor);
				qaLiquid.setManufactor(manufactor);

				Double maxValue = bgqc.getBgqc_max();
				qa.setMax_value(maxValue);
				qaLiquid.setMax_value(maxValue);

				Double minValue = bgqc.getBgqc_min();
				qa.setMin_value(minValue);
				qaLiquid.setMin_value(minValue);

				if (bgqc.getBgqc_number_valid_time() != null && !bgqc.getBgqc_number_valid_time().trim().isEmpty()) {
					Date liquidDate = DateUtils.parse(bgqc.getBgqc_number_valid_time(), 13);
					qa.setLiquid_date(liquidDate);
					qaLiquid.setExpiredTime(liquidDate);
				}
				if (bgqc.getMeasure_time() != null && !bgqc.getMeasure_time().trim().isEmpty()) {
					qa.setQa_time(DateUtils.parse(bgqc.getMeasure_time(), 15));
				}

				if (bgqc.getBgqc_paper_valid_time() != null && !bgqc.getBgqc_paper_valid_time().trim().isEmpty()) {
					qa.setTest_paper_date(DateUtils.parse(bgqc.getBgqc_paper_valid_time(), 13));
				}
				qa.setEquipment_sn(bgqc.getMeter_number());
				qa.setQa_value(bgqc.getValue());
				qa.setTest_paper_num(bgqc.getBgqc_paper_number());
				qa.setQa_result(bgqc.getResult());
				qa.setCreate_by(sysBloodGlucoseQaDao.selectLoginNameById(bgqc.getOprator()));
				qa.setCreate_name(sysBloodGlucoseQaDao.selectUserNameById(bgqc.getOprator()));
				qa.setRemark(bgqc.getRemark());
				Long newId = sysBloodGlucoseQaDao.selectNewIdByOldId(bgqc.getId());
				if (newId == null) {
					SysBloodGlucoseQa bloodGlucoseQa = sysBloodGlucoseQaDao.insertSysBloodGlucoseQa(qa);
					Long qaLiquidId = sysBloodGlucoseQaDao.selectQaLiquidByLiquidNum(qaLiquid.getLiquid_num());
					if (qaLiquidId == null) {
						// 迁移质控液
						sysBloodGlucoseQaDao.insertSysQaLiquid(qaLiquid);
					} else {
						qaLiquid.setId(qaLiquidId);
						sysBloodGlucoseQaDao.updateSysQaLiquid(qaLiquid);
					}
					// 质控数据id关联表
					sysBloodGlucoseQaDao.insertSysBloodGlucoseQaRelation(bloodGlucoseQa.getId(), bgqc.getId());
				} else {
					qa.setId(newId);
					sysBloodGlucoseQaDao.updateSysBloodGlucoseQa(qa);
				}

			}
		}
		System.out.println(DateUtils.fmtDate(new Date(), 16) + "==========质控记录迁移结束==========");
	}

	private String getLiquidType(String bgqc_type) {
		switch (bgqc_type) {
		case "低":
			return "low";
		case "中":
			return "middle";
		case "高":
			return "high";
		}
		return null;

	}

	private Long getDeptId(String meterNumber) {
		return sysDeptDao.selectNewIdByOldId(sysBloodGlucoseQaDao.selectComcodeByMeterNumber(meterNumber));
	}

}
