package com.sybercare.hospital.health.worker.recv;

import java.util.Date;
import java.util.Observable;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sybercare.hospital.adapters.entity.HisStaff;
import com.sybercare.hospital.common.utils.BaseObserver;
import com.sybercare.hospital.common.utils.Constants;
import com.sybercare.hospital.common.utils.WorkAutowired;
import com.sybercare.hospital.health.service.IStaffService;

/**
 * 功能：接收处理医院人员信息
 * 
 * @author 任梁荣
 * */
public class SybRecvStaffOnWorker implements BaseObserver {

	@WorkAutowired
	private IStaffService staffService;

	@Override
	public void update(Observable o, Object arg) {
		Object[] args = (Object[]) arg;
		if (args != null && args.length > 0) {
			JSONArray json = (JSONArray) args[0];
			if (json != null) {
				System.out.println("医生 护士 开始同步 ："+ Constants.convert(new Date(), Constants.format2));
				json.forEach(staff -> {
					HisStaff $staff = JSONObject.parseObject(staff.toString(), HisStaff.class);
					this.staffService.doStaff($staff);
					
//					System.out.println("staff "+$staff.getStaffId() + " "+$staff.getSex()+"  "+$staff.getDepartment()+"  "+$staff.getTitle());
				});
				System.out.println("医生 护士 结束同步："+ Constants.convert(new Date(), Constants.format2));
			}
		}
	}
}
