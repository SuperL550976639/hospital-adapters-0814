package com.sybercare.hospital.migrate.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sybercare.hospital.common.utils.DateUtils;
import com.sybercare.hospital.common.utils.UserException;
import com.sybercare.hospital.migrate.dao.PatientDao;
import com.sybercare.hospital.migrate.dao.SysDeptDao;
import com.sybercare.hospital.migrate.dao.SysUserDao;
import com.sybercare.hospital.migrate.entity.SysPatient;
import com.sybercare.hospital.migrate.entity.SysPatientRelation;
import com.sybercare.hospital.migrate.entity.User;
import com.sybercare.hospital.migrate.entity.UserPatient;
import com.sybercare.hospital.migrate.service.MigrateService;

@Service("patientService")
public class PatientServiceImpl implements MigrateService {

	@Autowired
	private PatientDao patientDao;
	@Autowired
	private SysDeptDao sysDeptDao;
	@Autowired
	private SysUserDao sysUserDao;

	@Override
	public void doMigrate() throws UserException {
		System.out.println(DateUtils.fmtDate(new Date(), 16) + "==========患者信息迁移开始==========");
		List<User> users = patientDao.selectUsers();
		if (users != null && !users.isEmpty()) {
			for (User user : users) {
				UserPatient userPatient = patientDao.selectUserPatientByUserId(user.getUser_id());
				if (userPatient != null) {
					SysPatient patient = new SysPatient();
					patient.setDept_id(sysDeptDao.selectNewIdByOldId(userPatient.getDepartment()) + "");
					patient.setAvatar(user.getAvatar());
					patient.setLogin_name(user.getAccount());
					patient.setPatient_name(user.getName());
					patient.setMobile(user.getPhone());
					patient.setPassword(user.getPassword());
					if (user.getBirth() != null) {
						patient.setBirth(DateUtils.parse(user.getBirth(), 13));
					}
					patient.setSex(user.getGender() + "");
					patient.setHospitalized_num(user.getIn_hospital_id());
					if (userPatient.getHospital_date() != null) {
						patient.setHospitalized_date(DateUtils.parse(userPatient.getHospital_date(), 16));
					}
					if (userPatient.getDischarge_date() != null) {
						patient.setLeave_date(DateUtils.parse(userPatient.getDischarge_date(), 16));
					}
					if ("0".equals(userPatient.getIn_hospital_status())) {
						patient.setHospitalized_type("1");
					}
					if ("1".equals(userPatient.getIn_hospital_status())) {
						patient.setHospitalized_type("2");
					}
					patient.setWristband_code(user.getWrist_band_code());
					patient.setBed_num(userPatient.getBed_number());
					patient.setDoctor_id(sysUserDao.selectNewIdByOldId(user.getServicePersonId()));
					patient.setDoctor_name(user.getDoctor_name());
					patient.setAddress(user.getAddress());
					if (user.getIdentify_card() != null) {
						patient.setCard_type("1");
						patient.setId_card(user.getIdentify_card());
					} else if (userPatient.getCard_number() != null) {
						patient.setCard_type("2");
						patient.setCard_num(userPatient.getCard_number());
					} else {
						patient.setCard_type("3");
						patient.setCard_num(userPatient.getCard_number());
					}
					if ("0".equals(user.getStatus() + "")) {
						patient.setStatus("1");
					}
					if ("1".equals(user.getStatus() + "")) {
						patient.setStatus("0");
					}

					patient.setCreate_time(user.getCreate_time());
					patient.setUpdate_time(user.getUpdate_time());
					patient.setRemark(user.getRemark());

					Long newId = patientDao.selectNewIdByOldId(user.getUser_id());
					if (newId == null) {
						SysPatient sysPatient = patientDao.insertSysPatient(patient);
						patientDao.insertSysPatientRelation(
								new SysPatientRelation(user.getUser_id(), sysPatient.getPatient_id()));
					} else {
						patient.setPatient_id(newId);
						patientDao.updateSysPatient(patient);
					}
				}

			}

		}
		System.out.println(DateUtils.fmtDate(new Date(), 16) + "==========患者信息迁移结束==========");
	}

}
