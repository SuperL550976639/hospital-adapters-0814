package com.sybercare.hospital.migrate.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sybercare.hospital.common.ds.DynamicDataSourceAutowired;
import com.sybercare.hospital.common.utils.IHibernateBaseDao;
import com.sybercare.hospital.migrate.dao.SysRoleDao;
import com.sybercare.hospital.migrate.entity.SaaGrade;
import com.sybercare.hospital.migrate.entity.SaaGradeTask;
import com.sybercare.hospital.migrate.entity.SysRole;
import com.sybercare.hospital.migrate.entity.SysRoleMenu;
import com.sybercare.hospital.migrate.entity.SysRoleRelation;

@Repository
@Transactional
public class SysRoleDaoImpl implements SysRoleDao {
	@Autowired
	private IHibernateBaseDao<SysRole> sysRoleBaseDao;
	@Autowired
	private IHibernateBaseDao<SysRoleMenu> sysRoleMenuBaseDao;
	@Autowired
	private IHibernateBaseDao<SaaGrade> saaGradeBaseDao;
	@Autowired
	private IHibernateBaseDao<SysRoleRelation> sysRoleRelationBaseDao;
	@Autowired
	private IHibernateBaseDao<SaaGradeTask> saaGradeTaskBaseDao;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@DynamicDataSourceAutowired(name = "his")
	@Override
	public List<SaaGrade> selectSaaGrades() {
		return saaGradeBaseDao.getAll(SaaGrade.class);
	}

	@DynamicDataSourceAutowired(name = "his")
	@Override
	public String selectLoginNameByUserId(String userId) {
		String sql = "SELECT userCode FROM prpsstaff WHERE personid=?";
		try {
			return jdbcTemplate.queryForObject(sql, String.class, userId);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public SysRoleRelation selectsysRoleRelationByOldId(Integer id) {

		return sysRoleRelationBaseDao.get(SysRoleRelation.class, "old_id", id);
	}

	@Override
	public SysRole insertSysRole(SysRole role) {
		return sysRoleBaseDao.saveOrUpdate(role);
	}

	@Override
	public void insertSysRoleRelation(SysRoleRelation sysRoleRelation) {
		sysRoleRelationBaseDao.save(sysRoleRelation);
	}

	@Override
	public void updateSysRole(SysRole role) {
		sysRoleBaseDao.update(role);
	}

	@DynamicDataSourceAutowired(name = "his")
	@Override
	public List<SaaGradeTask> selectSaaGradeTasksByRoleId(Integer id) {
		return saaGradeTaskBaseDao.getList(SaaGradeTask.class, "gradeid", id);
	}

	@DynamicDataSourceAutowired(name = "his")
	@Override
	public String selectMenuNameById(Integer taskid) {
		String sql = "SELECT taskcname FROM saa_task WHERE id=?";
		try {
			return jdbcTemplate.queryForObject(sql, String.class, taskid);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

	}

	@Override
	public Long selectMenuIdByName(String menuName) {
		String sql = "SELECT menu_id FROM sys_menu WHERE menu_name=?";
		try {
			return jdbcTemplate.queryForObject(sql, Long.class, menuName);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public void insertSysRoleMenu(Long role_id, List<Long> newMenuId, List<String> menuNames) {
		if (!menuNames.isEmpty()) {
			if (menuNames.contains("患者统计")) {
				newMenuId.add(selectMenuIdByName("统计分析"));
			} else if (menuNames.contains("医院及科室") && menuNames.contains("员工账号")) {
				newMenuId.add(selectMenuIdByName("医院管理"));
			}
		}
		if (!newMenuId.isEmpty()) {
			for (Long menuId : newMenuId) {
				sysRoleMenuBaseDao.save(new SysRoleMenu(role_id, menuId));
			}
		}
	}

}
