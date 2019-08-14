package com.sybercare.hospital.migrate.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sybercare.hospital.common.utils.DateUtils;
import com.sybercare.hospital.migrate.dao.SysDeptDao;
import com.sybercare.hospital.migrate.dao.SysUserDao;
import com.sybercare.hospital.migrate.entity.Prpscompany;
import com.sybercare.hospital.migrate.entity.SysDept;
import com.sybercare.hospital.migrate.entity.SysDeptRelation;
import com.sybercare.hospital.migrate.service.MigrateService;

@Service("sysDeptService")
public class SysDeptServiceImpl implements MigrateService {
	@Autowired
	private SysDeptDao sysDeptDao;
	@Autowired
	private SysUserDao sysUserDao;

	@Override
	public void doMigrate() {
		System.out.println(DateUtils.fmtDate(new Date(), 16) + "==========部门信息迁移开始==========");
		List<Prpscompany> prpscompanies = sysDeptDao.selectPrpscompanies();
		if (prpscompanies != null && !prpscompanies.isEmpty()) {
			for (Prpscompany prpscompany : prpscompanies) {
				SysDept dept = new SysDept();
				dept.setDept_name(prpscompany.getComcname());
				dept.setParent_name(sysDeptDao.selectParentNameByComcode(prpscompany.getUppercomcode()));
				dept.setOrder_num(0);
				dept.setLeader(prpscompany.getLeader());
				dept.setPhone(prpscompany.getPhone());
				dept.setEmail(prpscompany.getE_mail());
				if ("0".equals(prpscompany.getValidstatus())) {
					dept.setStatus("1");
				}
				if ("1".equals(prpscompany.getValidstatus())) {
					dept.setStatus("0");
				}
				dept.setDel_flag("0");
				String wristBandType = sysDeptDao.selectWristBandTypeByComcode(prpscompany.getComcode());
				if (wristBandType != null && !wristBandType.trim().isEmpty()) {
					dept.setWristband_type("1".equals(wristBandType) ? "1" : "2");
				}
				String userCode = sysUserDao.selectUserCodeByPersonId(prpscompany.getUpdatecode());
				if (userCode != null) {
					dept.setUpdate_by(userCode);
				}
				dept.setUpdate_time(prpscompany.getUpdatedate());
				Long newId = sysDeptDao.selectNewIdByOldId(prpscompany.getComcode());
				if (newId == null) {
					SysDept sysDept = sysDeptDao.insertSysDept(dept);
					sysDeptDao
							.insertSysDeptRelation(new SysDeptRelation(sysDept.getDept_id(), prpscompany.getComcode()));
				} else {
					dept.setDept_id(newId);
					sysDeptDao.updateSysDept(dept);
				}
			}
		}
		// 所有的新旧表ID对应关系都插入后再更新Ancestors
		List<SysDept> depts = sysDeptDao.selectSysdepts();
		if (depts != null && !depts.isEmpty()) {
			for (SysDept sysDept : depts) {
				// 查询新系统id对应的旧系统id
				String oldId = sysDeptDao.selectOldIdByNewId(sysDept.getDept_id());
				// 查询旧系统id对应的父部门id
				String oldParentId = sysDeptDao.selectUppercomcodeByComcode(oldId);
				if (oldParentId != null && !oldParentId.trim().isEmpty()) {
					// 查询旧系统父部门id对应新系统的id
					Long newId = sysDeptDao.selectNewIdByOldId(oldParentId);
					sysDept.setParent_id(newId);
					StringBuilder ancestors = new StringBuilder();
					ancestors = getAncestors(ancestors, oldId);
					StringBuilder sb = new StringBuilder(ancestors.substring(0, ancestors.lastIndexOf(","))).insert(0,
							"0,");
					sysDept.setAncestors(sb.toString());
				} else {
					sysDept.setParent_id(0L);
					sysDept.setAncestors("0");
				}

				sysDeptDao.updateSysDept(sysDept);
			}
		}
		System.out.println(DateUtils.fmtDate(new Date(), 16) + "==========部门信息迁移结束==========");
	}

	private StringBuilder getAncestors(StringBuilder ancestors, String comcode) {
		ancestors.insert(0, sysDeptDao.selectNewIdByOldId(comcode));
		String parentId = sysDeptDao.selectUppercomcodeByComcode(comcode);
		if (parentId != null && !parentId.trim().isEmpty()) {
			ancestors.insert(0, ",");
			getAncestors(ancestors, parentId);
		}
		return ancestors;
	}

}
