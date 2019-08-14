package com.sybercare.hospital.adapters.worker.data;

import java.sql.Connection;
import java.util.ArrayList;

import org.apache.axis.AxisFault;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.intersys.jdbc.CacheDataSource;
import com.service.mysyy._interface.AKXTMgrSoapStub;
import com.sybercare.hospital.adapters.entity.DataBloodGlucose;
import com.sybercare.hospital.adapters.service.IDataCacheDBService;
import com.sybercare.hospital.common.utils.Constants;
import com.sybercare.hospital.common.utils.IDataOnWorker;
import com.sybercare.hospital.common.utils.WorkAutowired;
import com.sybercare.hospital.health.worker.SybWorkEvents;

public class HisDataCacheDBOnWorker implements IDataOnWorker {

	@WorkAutowired
	private IDataCacheDBService dataCacheDBService;

	private Connection getConnection() {
		Connection dbconn = null;
		try {
			Class.forName("com.intersys.jdbc.CacheDriver").newInstance();
			CacheDataSource ds = new CacheDataSource();
			ds.setURL("jdbc:Cache://10.0.0.137:1972/HSD");
			// dbconn = ds.getConnection("xtuser", "xtuser");
			dbconn = ds.getConnection("_SYSTEM", "SYS");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dbconn;
	}

	@Override
	public String versionName() {
		return String.valueOf("CacheDB数据实现");
	}

	@Override
	public Object readData(Object woker, Object params) {
		Object result = new ArrayList<Object>();
		if (woker != null && woker instanceof SybWorkEvents) {
			SybWorkEvents events = (SybWorkEvents) woker;
			switch (events) {
			case SYBSTAFF:
				result = this.readStaffHandler(params);
				break;
			case SYBPATIENT:
				result = this.readPatientHandler(params);
				break;
			case SYBPOTHER:
				result = this.readPotherHandler(params);
				break;
			case SYBDEPARTMENT:
				result = this.readDepartmentHandler(params);
				break;
			case SYBWARDAREA:
				result = this.readWardareaHandler(params);
				break;
			default:
				break;
			}
		}
		return result;
	}

	private Object readWardareaHandler(Object params) {
		return null;
	}

	private Object readDepartmentHandler(Object params) {
		return null;
	}

	private Object readPotherHandler(Object params) {
		return this.dataCacheDBService.readPother(this.getConnection(), params);
	}

	private Object readPatientHandler(Object params) {
		return this.dataCacheDBService.readPatient(this.getConnection(), params);
	}

	private Object readStaffHandler(Object params) {
		return this.dataCacheDBService.readStaff(this.getConnection(), params);
	}

	@Override
	public boolean recvData(Object args) {
		boolean res = false;
		try {
			java.net.URL url = new java.net.URL("http://10.0.0.137:57772/csp/hsd/HSI.BS.AKXTMgr.CLS");
			AKXTMgrSoapStub soap = new AKXTMgrSoapStub(url, null);
			if (args != null) {
				DataBloodGlucose bloodGlucose = JSON.parseObject(args.toString(), DataBloodGlucose.class);
				JSONObject blood = new JSONObject();
				blood.put("id", bloodGlucose.getId());// 血糖记录ID
				blood.put("value", bloodGlucose.getValue());// 血糖值
				String status = "";
				String statusname = "";
				switch (bloodGlucose.getStatus()) {
				case "0":
					status = "3";statusname = "空腹";
					break;
				case "1":
					status = "4";statusname = "早餐后2h";
					break;
				case "2":
					status = "5";statusname = "午餐前";
					break;
				case "3":
					status = "6";statusname = "午餐后2h";
					break;
				case "4":
					status = "7";statusname = "晚餐前";
					break;
				case "5":
					status = "8";statusname = "晚餐后2h";
					break;
				case "6":
					status = "9";statusname = "睡前";
					break;
				case "7":
					status = "1";statusname = "0点";
					break;
				case "8":
					status = "10";statusname = "随机";
					break;
				case "9":
					status = "2";statusname = "3AM";
					break;
				default:
					break;
				}
				blood.put("status", status);// 测量时间段
				blood.put("statusname", statusname);// 测量时间段
				blood.put("measure_time", Constants.convert(bloodGlucose.getMeasureTime(), Constants.format2));// 测量时间。格式：1840-01-01
				// 12:00:00
				blood.put("patient_id", bloodGlucose.getPatientId());// 只给病人ID不够，东华系统需要AdmDR
				blood.put("card_number", bloodGlucose.getCardNumber());// 住院号
				blood.put("oprator_id", bloodGlucose.getOpratorId());// 测量人ID，对应UserID,用户表ID
				if (bloodGlucose.getOperateState()==null ||
						"".equalsIgnoreCase(bloodGlucose.getOperateState().toString().trim()) ||
						"null".equalsIgnoreCase(bloodGlucose.getOperateState().toString().trim())) {// 操作状态。0：未操作 1：已操作
					blood.put("operate_state", "0");
				}else{
					blood.put("operate_state", bloodGlucose.getOperateState());
				}
				
				if (bloodGlucose.getOperateType() == null ||
						"".equalsIgnoreCase(bloodGlucose.getOperateType().toString().trim())||
						"null".equalsIgnoreCase(bloodGlucose.getOperateState().toString().trim())) {
					blood.put("operate_type", "1");
				}else{
					blood.put("operate_type", bloodGlucose.getOperateType());// 操作类型。1：增加 // 2：修改
				}
				
				// 3：删除
				blood.put("remark", bloodGlucose.getRemark());// 备注
				String result = soap.AKBloodGlucose(blood.toString());
				JSONObject resultJson = JSON.parseObject(result);
				if (resultJson.containsKey("code") && resultJson.getInteger("code") == 1) {
					res = true;
				} else {
					res = false;
				}
			}
		} catch (AxisFault e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

}
