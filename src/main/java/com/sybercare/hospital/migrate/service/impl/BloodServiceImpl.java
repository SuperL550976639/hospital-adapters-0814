package com.sybercare.hospital.migrate.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sybercare.hospital.common.utils.DateUtils;
import com.sybercare.hospital.common.utils.UserException;
import com.sybercare.hospital.migrate.dao.BloodDao;
import com.sybercare.hospital.migrate.entity.DataBloodGlucose;
import com.sybercare.hospital.migrate.entity.Prpsstaff;
import com.sybercare.hospital.migrate.entity.SysBloodGlucose;
import com.sybercare.hospital.migrate.entity.SysBloodGlucoseRelation;
import com.sybercare.hospital.migrate.entity.SysDeptRelation;
import com.sybercare.hospital.migrate.entity.SysGlucosePeriod;
import com.sybercare.hospital.migrate.entity.SysPatientRelation;
import com.sybercare.hospital.migrate.entity.User;
import com.sybercare.hospital.migrate.service.MigrateService;
import com.sybercare.hospital.migrate.utils.BloodUtils;
import com.sybercare.hospital.migrate.utils.Period;

@Service("BloodServiceImpl")
public class BloodServiceImpl implements MigrateService {

	@Autowired
	private BloodDao blooddao;

	@Override
	public void doMigrate() {
		System.out.println(DateUtils.fmtDate(new Date(), 16) + "==========患者血糖迁移开始==========");

		// TODO Auto-generated method stub
		List<DataBloodGlucose> dataBloodGlucoses = blooddao.selectDataB();

		// 判断旧表血糖值是否为空
		if (dataBloodGlucoses != null && !dataBloodGlucoses.isEmpty()) {
			for (DataBloodGlucose dataBloodGlucose : dataBloodGlucoses) {

				try {
					// 判断血糖患者对应的部门是否存在
					SysPatientRelation patientRelation = blooddao.selectuserid((dataBloodGlucose.getUser_id()));
					if (patientRelation != null) {
						SysBloodGlucose bloodGlucose = new SysBloodGlucose();
						User user = blooddao.selectUserName(dataBloodGlucose.getUser_id());
						String status = Period.Status(dataBloodGlucose.getStatus());
						Date Measure_time = null;
						String ab = BloodUtils.Value(dataBloodGlucose.getValue());
						SysDeptRelation sysDeptRelation = blooddao.selectuserdept(user.getSource_comcode());
						try {
							Measure_time = DateUtils.parse(dataBloodGlucose.getMeasure_time(), 16);
						} catch (UserException e) {
							e.printStackTrace();
						}

						bloodGlucose.setPatient_id(patientRelation.getNew_id());
						bloodGlucose.setName(user.getName());
						bloodGlucose.setEquipment_sn(dataBloodGlucose.getDevice_sn());
						bloodGlucose.setMeasure_period(status);
						bloodGlucose.setMeasure_time(Measure_time);
						bloodGlucose.setMeature_value(dataBloodGlucose.getValue());
						bloodGlucose.setStatus("1");
						bloodGlucose.setData_source("0");
						if (ab != null) {
							bloodGlucose
									.setAbnormal_result(Double.toString(dataBloodGlucose.getValue()).substring(0, 3));
							if (ab == "999") {
								bloodGlucose.setOther_remark(dataBloodGlucose.getReason());
							} else {
								bloodGlucose.setOther_remark(null);
							}
						}
						if (sysDeptRelation != null) {
							bloodGlucose.setDept_id(Long.valueOf(sysDeptRelation.getNew_id()));

							if (status != null) {
								SysGlucosePeriod glucosePeriod = blooddao
										.selectperiod(Long.valueOf(sysDeptRelation.getNew_id()), status);
								if (glucosePeriod != null) {
									if (glucosePeriod.getMax_value() < dataBloodGlucose.getValue()) {
										bloodGlucose.setColor("red");
										bloodGlucose.setMeasure_status("3");
									} else if (glucosePeriod.getMin_value() > dataBloodGlucose.getValue()) {
										bloodGlucose.setColor("blue");
										bloodGlucose.setMeasure_status("1");
									} else {
										bloodGlucose.setColor(null);
										bloodGlucose.setMeasure_status("2");
									}
								}
							}else {
								bloodGlucose.setColor(null);
								bloodGlucose.setMeasure_status("2");
							}
							SysBloodGlucoseRelation bloodGlucoseRelation = blooddao
									.selectBloodGR(dataBloodGlucose.getId());
							if (bloodGlucoseRelation == null) {
								// System.out.println("开始新增");
								Prpsstaff prpsstaff = blooddao.selectStaffName(dataBloodGlucose.getOpratorId());
								if (prpsstaff != null) {
									bloodGlucose.setCreate_by(prpsstaff.getPersonname());
								} else {
									bloodGlucose.setCreate_by(null);
								}
								bloodGlucose.setCreate_time(dataBloodGlucose.getCreate_time());
								SysBloodGlucose glucose = blooddao.instertid(bloodGlucose);
								SysBloodGlucoseRelation glucoseRelation = new SysBloodGlucoseRelation();
								glucoseRelation.setNew_id(Integer.parseInt(glucose.getId() + ""));
								glucoseRelation.setOld_id(dataBloodGlucose.getId());
								blooddao.instertBloodR(glucoseRelation);

							} else {
								// System.out.println("开始更新");
								bloodGlucose.setId(Long.parseLong(bloodGlucoseRelation.getNew_id() + ""));
								bloodGlucose.setUpdate_by("合思超级管理员");
								bloodGlucose.setUpdate_time(DateUtils.nowDate());
								blooddao.updateBloodG(bloodGlucose);
							}

							// 未判断是否已保存
						}

					}

				} catch (Exception e) { // TODO: handle exception
					e.printStackTrace();
					System.out.println("患者血糖值id: " + dataBloodGlucose.getId() + " 迁移失败");
				}

			}
		}
		System.out.println(DateUtils.fmtDate(new Date(), 16) + "==========患者血糖迁移结束==========");
	}

}
