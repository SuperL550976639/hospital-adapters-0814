package com.sybercare.hospital.migrate.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sybercare.hospital.common.utils.DateUtils;
import com.sybercare.hospital.migrate.dao.PeriodDao;
import com.sybercare.hospital.migrate.entity.CompanyInterval;
import com.sybercare.hospital.migrate.entity.SysGlucosePeriod;
import com.sybercare.hospital.migrate.entity.SysPeriodRelation;
import com.sybercare.hospital.migrate.service.MigrateService;
import com.sybercare.hospital.migrate.utils.Period;

@Service("PeriodServiceImpl")
public class PeriodServiceImpl implements MigrateService {

	@Autowired
	private PeriodDao perioddao;

	@Override
	public void doMigrate() {
		// TODO Auto-generated method stub
		System.out.println(DateUtils.fmtDate(new Date(), 16) + "==========时段模板迁移开始==========");

		List<CompanyInterval> Coms = perioddao.selectOldPeriod();
		if (Coms != null && !Coms.isEmpty()) {
			for (CompanyInterval companyInterval : Coms) {
				try {

					// System.out.println(companyInterval.getTime_interval());
					// 判断时段是否为通用时段
					String per = Period.Periods((companyInterval.getTime_interval()));
					if (per != null && companyInterval.getStatus().equals("1")
							&& companyInterval.getMeasure_type().equals("0")) {

						SysGlucosePeriod glucosePeriod = new SysGlucosePeriod();
						// glucosePeriod.setMeasure_period((Period.Per(companyInterval.getTime_interval_code())).toString());
						Long Comcode = perioddao.selectDeptRe(companyInterval.getCom_code()).getNew_id();
						glucosePeriod.setDept_id(Comcode);
						glucosePeriod.setMeasure_period(Period.Per(per));
						glucosePeriod.setDisplay_name(companyInterval.getTime_interval());
						glucosePeriod.setStart_time(companyInterval.getStart_time());
						glucosePeriod.setEnd_time(companyInterval.getEnd_time());
						glucosePeriod.setMax_value(companyInterval.getMax_value());
						glucosePeriod.setMin_value(companyInterval.getMin_value());
						glucosePeriod.setStatus(companyInterval.getStatus());
						glucosePeriod.setCreate_by("合思管理员");
						glucosePeriod.setHigh_Color("red");
						glucosePeriod.setLow_Color("blue");

						String count = perioddao.selectrepeat(Comcode, Period.Per(per));
						//System.out.println(count);
						// 判断新表对应是否存在主键id
						SysPeriodRelation sysp = perioddao.selectPer(companyInterval.getId());
						if (count.equals("0")) {
							if (sysp == null) {
								SysGlucosePeriod glucosePeriod2 = perioddao.insertinto(glucosePeriod);
								SysPeriodRelation sysPeriodRelation = new SysPeriodRelation();
								sysPeriodRelation.setNew_id(glucosePeriod2.getId());
								sysPeriodRelation.setOld_id(companyInterval.getId());
								glucosePeriod.setCreate_time((DateUtils.nowDate()));
								perioddao.insertinto(sysPeriodRelation);
							} else {
								glucosePeriod.setId(sysp.getNew_id());
								glucosePeriod.setUpdate_time((DateUtils.nowDate()));
								glucosePeriod.setUpdate_by("合思管理员");
								glucosePeriod.setCreate_time(glucosePeriod.getCreate_time());
								// glucosePeriod.setUpdate_time((DateUtils.nowDate()));
								perioddao.update(glucosePeriod);
							}
						}

					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
		System.out.println(DateUtils.fmtDate(new Date(), 16) + "==========时段模板迁移结束==========");
	}

}
