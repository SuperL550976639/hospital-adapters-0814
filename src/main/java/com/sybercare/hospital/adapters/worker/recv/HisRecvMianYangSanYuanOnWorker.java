package com.sybercare.hospital.adapters.worker.recv;

import java.util.Observable;

import com.sybercare.hospital.adapters.worker.data.HisDataEvents;

public class HisRecvMianYangSanYuanOnWorker extends HisBaseRecvOnWorker{
	@Override
	public String versionName() {
		return String.valueOf("绵阳三医院业务对接数据上传实现");
	}

	@Override
	public void update(Observable o, Object arg) {
		super.update(o, arg);
	}

	@Override
	public Object dataSources() {
		return HisDataEvents.MIANYANGSANYUAN;
	}
}
