package com.sybercare.hospital.migrate.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sybercare.hospital.common.utils.DateUtils;
import com.sybercare.hospital.migrate.dao.SysRoleDao;
import com.sybercare.hospital.migrate.entity.SaaGrade;
import com.sybercare.hospital.migrate.entity.SaaGradeTask;
import com.sybercare.hospital.migrate.entity.SysRole;
import com.sybercare.hospital.migrate.entity.SysRoleRelation;
import com.sybercare.hospital.migrate.service.MigrateService;

@Service("sysRoleService")
public class SysRoleServiceImpl implements MigrateService {
	@Autowired
	private SysRoleDao sysRoleDao;

	@Override
	public void doMigrate() {
		System.out.println(DateUtils.fmtDate(new Date(), 16) + "==========角色信息迁移开始==========");
		List<SaaGrade> saaGrades = sysRoleDao.selectSaaGrades();
		if (saaGrades != null && !saaGrades.isEmpty()) {
			for (SaaGrade saaGrade : saaGrades) {
				// 迁移角色表
				SysRole role = new SysRole();
				role.setRole_name(saaGrade.getGradecname());
				role.setRole_sort(0);
				role.setStatus("1".equals(saaGrade.getValidstatus()) ? "0" : "1");
				role.setDel_flag("0");
				role.setCreate_by(sysRoleDao.selectLoginNameByUserId(saaGrade.getCreatorcode()));
				role.setCreate_time(saaGrade.getCreatetime());
				role.setUpdate_by(sysRoleDao.selectLoginNameByUserId(saaGrade.getUpdatercode()));
				role.setUpdate_time(saaGrade.getUpdatetime());
				role.setData_scope("3");
				SysRoleRelation sysRoleRelation = sysRoleDao.selectsysRoleRelationByOldId(saaGrade.getId());
				if (sysRoleRelation == null) {
					SysRole sysRole = sysRoleDao.insertSysRole(role);
					role.setRole_id(sysRole.getRole_id());
					sysRoleDao.insertSysRoleRelation(new SysRoleRelation(sysRole.getRole_id(), saaGrade.getId()));
					// 迁移角色和菜单对应表
					List<SaaGradeTask> gradeTasks = sysRoleDao.selectSaaGradeTasksByRoleId(saaGrade.getId());
					// 当前角色可以使用的菜单对应的新系统ID
					List<Long> newMenuId = new ArrayList<Long>();
					List<String> menuNames = new ArrayList<String>();
					boolean flag1 = false;
					boolean flag2 = false;
					boolean flag3 = false;
					if (gradeTasks != null && !gradeTasks.isEmpty()) {
						getMenu(gradeTasks, newMenuId, menuNames, flag1, flag2, flag3);
						// 添加角色和菜单关联到新系统
						sysRoleDao.insertSysRoleMenu(role.getRole_id(), newMenuId, menuNames);
					}
				} else {
					role.setRole_id(sysRoleRelation.getNew_id());
					sysRoleDao.updateSysRole(role);
				}

			}
		}
		System.out.println(DateUtils.fmtDate(new Date(), 16) + "==========角色信息迁移结束==========");
	}

	private void getMenu(List<SaaGradeTask> gradeTasks, List<Long> newMenuId, List<String> menuNames, boolean flag1,
			boolean flag2, boolean flag3) {
		for (SaaGradeTask saaGradeTask : gradeTasks) {
			// 查询菜单名
			String menuName = sysRoleDao.selectMenuNameById(saaGradeTask.getTaskid());
			switch (menuName) {
			case "今日医嘱":
				if (flag1) {
					break;
				}
				flag1 = true;
				newMenuId.add(sysRoleDao.selectMenuIdByName("住院患者"));
				break;
			case "患者医嘱":
				if (flag1) {
					break;
				}
				flag1 = true;
				newMenuId.add(sysRoleDao.selectMenuIdByName("住院患者"));
				break;
			case "住院患者":
				if (flag1) {
					break;
				}
				flag1 = true;
				newMenuId.add(sysRoleDao.selectMenuIdByName("住院患者"));
				break;
			case "新增患者":
				if (flag1) {
					break;
				}
				flag1 = true;
				newMenuId.add(sysRoleDao.selectMenuIdByName("住院患者"));
				break;
			case "出院患者":
				newMenuId.add(sysRoleDao.selectMenuIdByName("出院患者"));
				break;
			case "血糖数据":
				newMenuId.add(sysRoleDao.selectMenuIdByName("血糖数据"));
				break;
			case "危急数据":
				newMenuId.add(sysRoleDao.selectMenuIdByName("危机预警"));
				break;
			case "质控数据":
				newMenuId.add(sysRoleDao.selectMenuIdByName("质控记录"));
				break;
			case "血糖仪管理":
				newMenuId.add(sysRoleDao.selectMenuIdByName("仪器管理"));
				break;
			case "数据统计":
				newMenuId.add(sysRoleDao.selectMenuIdByName("患者统计"));
				menuNames.add("患者统计");
				break;
			case "医院配置":
				if (flag2) {
					break;
				}
				flag2 = true;
				newMenuId.add(sysRoleDao.selectMenuIdByName("医院及科室"));
				menuNames.add("医院及科室");
				break;
			case "部门配置":
				if (flag2) {
					break;
				}
				flag2 = true;
				newMenuId.add(sysRoleDao.selectMenuIdByName("医院及科室"));
				menuNames.add("医院及科室");
				break;
			case "员工配置":
				newMenuId.add(sysRoleDao.selectMenuIdByName("员工账号"));
				menuNames.add("员工账号");
				break;
			case "危急值配置":
				if (flag3) {
					break;
				}
				flag3 = true;
				newMenuId.add(sysRoleDao.selectMenuIdByName("参数配置"));
				break;
			case "监测时段配置":
				if (flag3) {
					break;
				}
				flag3 = true;
				newMenuId.add(sysRoleDao.selectMenuIdByName("参数配置"));
				break;
			case "监测模板配置":
				newMenuId.add(sysRoleDao.selectMenuIdByName("医嘱模版"));
				break;
			case "岗位管理":
				newMenuId.add(sysRoleDao.selectMenuIdByName("角色管理"));
				break;
			}
		}
	}

}
