package com.sybercare.hospital.migrate.dao;

import java.util.List;

import com.sybercare.hospital.migrate.entity.GlouceMeter;
import com.sybercare.hospital.migrate.entity.SysEquipment;

public interface GlouceMeterDao {

	Long selectNewIdByOldId(Integer id);

	void insertSysEquipmentRelation(Long id, Integer id2);

	SysEquipment insertSysEquipment(SysEquipment equipment);

	void updateSysEquipment(SysEquipment equipment);

	List<GlouceMeter> selectGloceMeters();

}
