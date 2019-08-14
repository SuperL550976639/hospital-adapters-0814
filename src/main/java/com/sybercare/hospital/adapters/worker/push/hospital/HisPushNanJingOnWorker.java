package com.sybercare.hospital.adapters.worker.push.hospital;

import java.util.Observable;

import com.sybercare.hospital.adapters.worker.push.HisBasePushOnWorker;

/**
 * 功能：南京HIS对接业务实现
 * 
 * @author 任梁荣
 * */
public class HisPushNanJingOnWorker extends HisBasePushOnWorker {

	@Override
	public void update(Observable o, Object arg) {
		super.setBasicDataOnWorker(this);
		super.update(o, arg);
	}

	@Override
	public String versionName() {
		return String.valueOf("南京养老院");
	}
}
