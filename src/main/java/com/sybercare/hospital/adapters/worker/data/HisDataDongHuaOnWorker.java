package com.sybercare.hospital.adapters.worker.data;

import java.util.ArrayList;

import net.sf.json.xml.XMLSerializer;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.dhcc.DWBHISService;
import cn.com.dhcc.DWBHISServiceSoap;

import com.alibaba.fastjson.JSONObject;
import com.sybercare.hospital.common.utils.IDataOnWorker;
import com.sybercare.hospital.health.worker.SybWorkEvents;

/**
 * 功能：东华血糖仪接口调用
 * 
 * @author 任梁荣
 */
public class HisDataDongHuaOnWorker implements IDataOnWorker {

	protected static final Logger LOGGER = LoggerFactory.getLogger(HisDataDongHuaOnWorker.class);

	@Override
	public String versionName() {
		return String.valueOf("东华血糖仪数据实现");
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

	/**
	 * 功能：血糖数据上传
	 */
	@Override
	public boolean recvData(Object args) {
		try {
			if (args != null) {
				JSONObject json = (JSONObject) args;
				if (json != null && json.size() > 0) {
					StringBuffer sendMsg = new StringBuffer().append("<Request>").append("<Id>%s</Id>")
							.append("<Value>%s</Value>").append("<Status>%s</Status>")
							.append("<MeasureTime>%s</MeasureTime>").append("<PatientID>%s</PatientID>")
							.append("<CardNumber>%s</CardNumber>").append("<OpratorID>%s</OpratorID>")
							.append("<OpratorState>%s</OpratorState>").append("<OpratorType>%s</OpratorType>")
							.append("<Remark>%s</Remark>").append("</Request>");

					String id = json.getString("Id");// 血糖记录ID
					String value = json.getString("Value");// 血糖值
					String status = json.getString("Status");// 测量时间段
					String measureTime = json.getString("MeasureTime");// 测量时间。格式：1840-01-01
																		// 12:00:00
					String patientID = json.getString("PatientID");// 只给病人ID不够，东华系统需要AdmDR
					String cardNumber = json.getString("CardNumber");// 就诊号，每次住院新生成一个号
					String opratorID = json.getString("OpratorID");// 测量人ID，对应UserID,用户表ID
					String opratorState = json.getString("OpratorState");// 操作状态。0：未操作
																			// 1：已操作
					String opratorType = json.getString("OpratorType");// 操作类型。1：增加
																		// 2：修改
																		// 3：删除
					String remark = json.getString("Remark");// 备注
					String context = String.format(sendMsg.toString(), id, value, status, measureTime, patientID,
							cardNumber, opratorID, opratorState, opratorType, remark);
					System.out.println("上传血糖数据：" + context);
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 功能：获取病区信息
	 */
	private Object readWardareaHandler(Object params) {
		String result = String.valueOf("");
		String hospitalId = String.valueOf("");
		try {
			if (params != null && StringUtils.isNotBlank(params.toString())) {
				hospitalId = params.toString();
			}
			DWBHISService service = new DWBHISService();
			DWBHISServiceSoap soap = service.getDWBHISServiceSoap();
			String wards = soap
					.getWardList(String.format("<Request><HospitalID>%s</HospitalID></Request>", hospitalId));
			XMLSerializer serial = new XMLSerializer();
			result = serial.read(wards).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 功能：获取科室信息
	 */
	private Object readDepartmentHandler(Object params) {
		String result = String.valueOf("");
		String hospitalId = String.valueOf("");
		try {
			if (params != null && StringUtils.isNotBlank(params.toString())) {
				hospitalId = params.toString();
			}
			DWBHISService service = new DWBHISService();
			DWBHISServiceSoap soap = service.getDWBHISServiceSoap();
			String depts = soap.getDepList(String.format("<Request><HospitalID>%s</HospitalID></Request>", hospitalId));
			XMLSerializer serial = new XMLSerializer();
			result = serial.read(depts).toString();
			System.out.println("科室信息 = " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 功能：获取科室人员
	 */
	private Object readStaffHandler(Object params) {
		String depId = String.valueOf("");
		String result = String.valueOf("");
		try {
			if (params != null && StringUtils.isNotBlank(params.toString())) {
				depId = params.toString();
			}
			DWBHISService service = new DWBHISService();
			DWBHISServiceSoap soap = service.getDWBHISServiceSoap();
			String user = soap.getUserListByDep(String.format("<Request><DepID>%s</DepID></Request>", depId));
			XMLSerializer serial = new XMLSerializer();
			result = serial.read(user).toString();
		} catch (Exception e) {
		}
		return result;
	}

	/**
	 * 功能：获取患者信息
	 */
	private Object readPatientHandler(Object params) {
		String depId = String.valueOf("");
		String result = String.valueOf("");
		try {
			if (params != null && StringUtils.isNotBlank(params.toString())) {
				depId = params.toString();
			}
			DWBHISService service = new DWBHISService();
			DWBHISServiceSoap soap = service.getDWBHISServiceSoap();
			String patients = soap.getPatListByDep(String.format("<Request><DepID>%s</DepID></Request>", depId));
			XMLSerializer serial = new XMLSerializer();
			result = serial.read(patients).toString();
			System.out.println("科室患者params = " + params + "  返回 ： " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 功能：获取监测医嘱信息
	 */
	private Object readPotherHandler(Object params) {
		String admdr = String.valueOf("");
		String result = String.valueOf("");
		try {
			if (params != null && StringUtils.isNotBlank(params.toString())) {
				admdr = params.toString();
			}
			DWBHISService service = new DWBHISService();
			DWBHISServiceSoap soap = service.getDWBHISServiceSoap();
			String patients = soap.getOrderListByAdm(String.format("<Request><AdmDR>%s</AdmDR></Request>", admdr));
			XMLSerializer serial = new XMLSerializer();
			result = serial.read(patients).toString();
			System.out.println("患者医嘱params = " + params + "  返回 ： " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
