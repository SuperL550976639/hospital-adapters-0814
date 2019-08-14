package com.sybercare.hospital.migrate.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sybercare.hospital.common.utils.DateUtils;
import com.sybercare.hospital.migrate.dao.SysDeptDao;
import com.sybercare.hospital.migrate.dao.SysRoleDao;
import com.sybercare.hospital.migrate.dao.SysUserDao;
import com.sybercare.hospital.migrate.entity.Prpsstaff;
import com.sybercare.hospital.migrate.entity.SysRoleRelation;
import com.sybercare.hospital.migrate.entity.SysUser;
import com.sybercare.hospital.migrate.service.MigrateService;
import com.sybercare.hospital.migrate.utils.MigrateUtils;

@Service("sysUserService")
public class SysUserServiceImpl implements MigrateService {
	@Autowired
	private SysUserDao sysUserDao;
	@Autowired
	private SysRoleDao sysRoleDao;
	@Autowired
	private SysDeptDao sysDeptDao;

	@Override
	public void doMigrate() {
		System.out.println(DateUtils.fmtDate(new Date(), 16) + "==========员工信息迁移开始==========");
		List<Prpsstaff> prpsstaffs = sysUserDao.selectPrpsStaffs();
		if (prpsstaffs != null && !prpsstaffs.isEmpty()) {
			for (Prpsstaff prpsstaff : prpsstaffs) {
				SysUser user = new SysUser();
				user.setDept_id(sysDeptDao.selectNewIdByOldId(prpsstaff.getComcode()));
				user.setLogin_name(prpsstaff.getUserCode());
				user.setUser_name(prpsstaff.getPersonname());
				user.setUser_type("00");
				user.setEmail(prpsstaff.getE_mail());
				user.setPhonenumber(prpsstaff.getMobile());
				user.setSex("9".equals(prpsstaff.getSex()) ? "2" : prpsstaff.getSex());
				user.setAvatar(prpsstaff.getAvatar());
				user.setSalt(MigrateUtils.randomSalt());
				user.setPassword(MigrateUtils.encryptPassword(user.getLogin_name(), "111111", user.getSalt()));
				user.setStatus("1".equals(prpsstaff.getValidstatus()) ? "0" : "1");
				user.setDel_flag("0");
				user.setCreate_by(sysUserDao.selectUserCodeByPersonId(prpsstaff.getOpercode()));
				user.setCreate_time(prpsstaff.getOpertime());
				user.setRemark(prpsstaff.getRemark());
				Long newId = sysUserDao.selectNewIdByOldId(prpsstaff.getPersonid());
				if (newId == null) {
					SysUser sysUser = sysUserDao.insertSysUser(user);
					SysRoleRelation sysRoleRelation = sysRoleDao
							.selectsysRoleRelationByOldId(Integer.parseInt(prpsstaff.getRole()));
					if (sysRoleRelation != null) {
						sysUserDao.insertSysUserRole(sysUser.getUser_id(), sysRoleRelation.getNew_id());
					}
					sysUserDao.insertSysUserRelation(sysUser.getUser_id(), prpsstaff.getPersonid());
				} else {
					user.setUser_id(newId);
					sysUserDao.updateSysUser(user);
				}
			}
		}
		System.out.println(DateUtils.fmtDate(new Date(), 16) + "==========员工信息迁移结束==========");
	}

}
