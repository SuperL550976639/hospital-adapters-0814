package com.sybercare.hospital.migrate.dao;

import java.util.List;

import com.sybercare.hospital.migrate.entity.DataBloodBgqc;
import com.sybercare.hospital.migrate.entity.SysBloodGlucoseQa;
import com.sybercare.hospital.migrate.entity.SysQaLiquid;

public interface SysBloodGlucoseQaDao {

	List<DataBloodBgqc> selectDataBloodBgqcs();

	String selectManuFacturerByMeterNumber(String meterNumber);

	String selectComcodeByMeterNumber(String meterNumber);

	Long selectNewIdByOldId(Integer id);

	SysBloodGlucoseQa insertSysBloodGlucoseQa(SysBloodGlucoseQa qa);

	void insertSysBloodGlucoseQaRelation(Long id, Integer id2);

	void updateSysBloodGlucoseQa(SysBloodGlucoseQa qa);

	String selectUserNameById(String oprator);

	SysQaLiquid insertSysQaLiquid(SysQaLiquid qaLiquid);

	Long selectQaLiquidByLiquidNum(String liquid_num);

	void updateSysQaLiquid(SysQaLiquid qaLiquid);

	String selectLoginNameById(String oprator);

}
