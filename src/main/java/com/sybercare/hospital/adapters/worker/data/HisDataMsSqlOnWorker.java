package com.sybercare.hospital.adapters.worker.data;

import java.util.List;

import com.sybercare.hospital.adapters.service.ITuserService;
import com.sybercare.hospital.common.utils.IDataOnWorker;
import com.sybercare.hospital.common.utils.WorkAutowired;

/**
 * 功能：HIS对接业务实现,MSSQL版
 * 
 * @author 任梁荣
 * */
public class HisDataMsSqlOnWorker implements IDataOnWorker {

	@WorkAutowired
	private ITuserService tuserService;

	@Override
	public String versionName() {
		return String.valueOf("MSSQL实现版本");
	}
	
	@Override
	public List<?> readData(Object woker, Object params) {
		return this.tuserService.readTuserList();
	}

	@Override
	public boolean recvData(Object args) {
		
		return false;
	}
}
