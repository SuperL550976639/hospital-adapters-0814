package com.sybercare.hospital.migrate.dao;

import java.util.List;

import com.sybercare.hospital.migrate.entity.Prpscompany;
import com.sybercare.hospital.migrate.entity.SysDept;
import com.sybercare.hospital.migrate.entity.SysDeptRelation;

public interface SysDeptDao {

	List<Prpscompany> selectPrpscompanies();

	String selectParentNameByComcode(String comcode);

	String selectWristBandTypeByComcode(String comcode);

	String selectUppercomcodeByComcode(String comcode);

	SysDept insertSysDept(SysDept dept);

	void insertSysDeptRelation(SysDeptRelation sysDeptRelation);

	void updateSysDept(SysDept dept);

	List<SysDept> selectSysdepts();

	String selectOldIdByNewId(Long dept_id);

	Long selectNewIdByOldId(String comcode);

}
