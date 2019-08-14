package com.sybercare.hospital.common.jobs;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sybercare.hospital.common.utils.DateUtils;
import com.sybercare.hospital.migrate.manager.MigrateManager;

/**
 * 功能：运行定时业务
 * 
 * @author 任梁荣
 */
@Component
public class Jobs {
	public final static long ONE_Minute = 60 * 1000;

//	@Autowired
//	private SybWorkManagers sybWorkManagers;

//	@Autowired
//	private HisWorkManagers hisWorkManagers;
	@Autowired
	private MigrateManager migrateManager;
	boolean isStaffRun = false;
	boolean isPatientRun = false;
	boolean flag = false;

	@Scheduled(cron = "0/1 * * * * ?")
	public void doMigrateRole() {
		if (flag) {
			return;
		}
		flag = true;
		System.out.println(DateUtils.fmtDate(new Date(), 16) + "===============迁移开始===============");
		migrateManager.executor();
		System.out.println(DateUtils.fmtDate(new Date(), 16) + "===============迁移结束===============");

	}

//	@Scheduled(cron = "0 0/30 * * * ?")
//	public void doStaffIt() {
//		isStaffRun = true;
//		System.out.println("job 员工定时器：" + Constants.convert(new Date(), Constants.format2));
//		this.hisWorkManagers.onEvents(HisWorkEvents.HISPUSHYANGPUQUZHONGXINYIYUAN, SybWorkEvents.SYBSTAFF);
//	}
//
//	@Scheduled(cron = "0 0/1 * * * ?")
//	public void doPatientIt() {
//		isPatientRun = true;
//		if (!isStaffRun) {
//			doStaffIt();
//		}
//		System.out.println("job 患者定时器：" + Constants.convert(new Date(), Constants.format2));
//		this.hisWorkManagers.onEvents(HisWorkEvents.HISPUSHYANGPUQUZHONGXINYIYUAN, SybWorkEvents.SYBPATIENT);
//	}

//	@Scheduled(cron = "0 0/3 * * * ?")
//	public void doPotherIt() {
//
//		System.out.println("job 医嘱定时器：" + Constants.convert(new Date(), Constants.format2));
//		this.hisWorkManagers.onEvents(HisWorkEvents.HISPUSHYANGPUQUZHONGXINYIYUAN, SybWorkEvents.SYBPOTHER);
//	}

//	@Scheduled(cron = "0 0/1 * * * ?")
//	public void doXueTangIt() {
//		System.out.println("job 血糖定时器：" + Constants.convert(new Date(), Constants.format2));
//		this.sybWorkManagers.onEvents(SybWorkEvents.SYBPUSHXUETANG,
//				HisWorkEvents.HISRECVSHANGHAIYANGPUQUZHONGXINYIYUAN);// 血糖数据上传
//	}
}