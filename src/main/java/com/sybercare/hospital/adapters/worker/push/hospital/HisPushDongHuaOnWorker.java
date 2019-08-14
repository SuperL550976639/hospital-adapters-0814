package com.sybercare.hospital.adapters.worker.push.hospital;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sybercare.hospital.adapters.entity.HisDepartment;
import com.sybercare.hospital.adapters.entity.HisPatient;
import com.sybercare.hospital.adapters.entity.HisPrescriptionOther;
import com.sybercare.hospital.adapters.entity.HisStaff;
import com.sybercare.hospital.adapters.entity.HisWardarea;
import com.sybercare.hospital.adapters.worker.data.HisDataEvents;
import com.sybercare.hospital.adapters.worker.push.HisBasePushOnWorker;
import com.sybercare.hospital.common.utils.Constants;
import com.sybercare.hospital.health.worker.SybWorkEvents;

/**
 * 功能：东华血糖仪对接业务实现
 * 
 * @author 任梁荣
 * */
@SuppressWarnings("unused")
public class HisPushDongHuaOnWorker extends HisBasePushOnWorker {

	protected static final Logger LOGGER = LoggerFactory.getLogger(HisPushDongHuaOnWorker.class);

	@Override
	public String versionName() {
		return String.valueOf("东华血糖仪对接");
	}

	@Override
	public HisDataEvents dataSources() {
		return HisDataEvents.DONGHUA;
	}

	@Override
	public void update(Observable o, Object arg) {
		this.setBasicDataOnWorker(this);
		super.update(o, arg);
	}

	@Override
	public Object analysis(Object obList, Object params, Object woker) {
		JSONArray destJson = new JSONArray();
		if (woker != null && obList != null) {
			if (woker != null && woker instanceof SybWorkEvents) {
				SybWorkEvents events = (SybWorkEvents) woker;
				switch (events) {
				case SYBSTAFF:
					destJson = this.staffParse(obList, params);//科室员工
					break;
				case SYBPATIENT:
					destJson = this.patientParse(obList, params);//科室患者
					break;
				case SYBPOTHER:
					destJson = this.potherParse(obList, params);//患者医嘱
					break;
				case SYBDEPARTMENT:
					destJson = this.departemtParse(obList, params);//二级部门
					break;
				case SYBWARDAREA:
					destJson = this.wardareaParse(obList);//一级部门
					break;
				default:
					break;
				}
			}
		}
		return destJson;
	}

	/**
	 * 功能：患者医嘱数据
	 * */
	private JSONArray potherParse(Object obList, Object params) {
		JSONObject srcJson = JSONObject.parseObject(obList.toString());
		List<HisPrescriptionOther> potherList = new ArrayList<HisPrescriptionOther>();
		try {
			if (srcJson != null && srcJson.size() > 0) {
				String resultCode = srcJson.getString("ResultCode");
				JSONArray records = new JSONArray();
				if (srcJson.get("Records") instanceof JSONArray) {
					records = srcJson.getJSONArray("Records");
				} else {
					JSONObject $ = srcJson.getJSONObject("Records");
					records.add($);
				}
				if (resultCode.equals(String.valueOf(0)) && records != null && records.size() > 0) {
					for (Object o : records) {
						JSONObject json = (JSONObject) o;

						String orderID = json.getString("OrderID");//医嘱ID
						String orderPriorCode = json.getString("OrderPriorCode");//医嘱类型。STAT:即刻医嘱;NORM:临时医嘱;S:长期医嘱;PRN:必要时
						String orderFreqCode = json.getString("OrderFreqCode");//医嘱频次代码。例如：BID;QD
						String orderFreqFactor = json.getString("OrderFreqFactor");//医嘱频次数量。例如：1,2
						String orderMessage = json.getString("OrderMessage");//医嘱项说明；开医嘱时，提示给医生
						String orderInsertDate = json.getString("OrderInsertDate");//医嘱创建日期。格式：1840-01-01
						String orderSttDate = json.getString("OrderSttDate");//医嘱开始日期。格式：1840-01-01
						String orderEndDate = json.getString("OrderEndDate");//医嘱结束日期。格式：1840-01-01
						String orderDoctorID = json.getString("OrderDoctorID");//下医嘱医生ID
						String orderDoctorName = json.getString("OrderDoctorName");//下医嘱医生姓名
						String orderItemCode = json.getString("OrderItemCode");//医嘱项代码
						String orderItemCate = json.getString("OrderItemCate");//医嘱分类或子分类，取决于医院基础数据分类。例如：血糖检测，血压监测。
						String orderNotes = json.getString("OrderNotes");//医嘱备注 Remark，由医生填写
						String patientID = json.getString("PatientID");//病人ID，病人唯一标识。
						String patientNo = json.getString("PatientNo");//登记号。多数医院以此作为住院号、病人身份识别号、腕带号。
						String admDR = json.getString("AdmDR");//就诊号，每次住院新生成一个号；不是卡号
						String validFlag = json.getString("ValidFlag");//可用标志；0：作废；1：有效

						HisPrescriptionOther pother = new HisPrescriptionOther();
						pother.setPrescriptionId(orderID);
						pother.setPatientId(patientID);
						pother.setCreateDate(Constants.convert(orderInsertDate, Constants.format1));
						pother.setCardNumber(admDR);
						pother.setPrescriptionName(orderPriorCode);
						pother.setFrequency(orderFreqFactor);
						pother.setPrescriptionNotes(orderMessage);
						pother.setStartTime(Constants.convert(orderSttDate, Constants.format1));
						pother.setEndTime(Constants.convert(orderEndDate, Constants.format1));
						pother.setDoctorId(orderDoctorID);
						pother.setDoctorName(orderDoctorName);
						pother.setPrescriptionNo(orderItemCode);
						pother.setPrescriptionType(orderItemCate);
						pother.setRemark(orderNotes);
						potherList.add(pother);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (JSONArray) JSONArray.toJSON(potherList);
	}

	/**
	 * 功能：解析科室患者
	 * */
	private JSONArray patientParse(Object obList, Object params) {
		JSONObject srcJson = JSONObject.parseObject(obList.toString());
		List<String> patientParams = new ArrayList<String>();
		List<HisPatient> patientList = new ArrayList<HisPatient>();
		try {
			if (srcJson != null && srcJson.size() > 0) {
				String resultCode = srcJson.getString("ResultCode");
				JSONArray records = new JSONArray();
				if (srcJson.get("Records") instanceof JSONArray) {
					records = srcJson.getJSONArray("Records");
				} else {
					JSONObject $ = srcJson.getJSONObject("Records");
					records.add($);
				}
				if (resultCode.equals(String.valueOf(0)) && records != null && records.size() > 0) {
					for (Object o : records) {
						JSONObject json = (JSONObject) o;

						String patientID = json.getString("PatientID");//病人Id
						String patientNo = json.getString("PatientNo");//登记号（多数医院以此作为住院号）；病人身份识别号。
						String cardNo = json.getString("CardNo");//病人就诊卡号
						String admDR = json.getString("AdmDR");//就诊号，每次住院新生成一个号；不是卡号
						String inPatTimes = json.getString("InPatTimes");//住院次数
						String phone = json.getString("Phone");//手机号码
						String patientName = json.getString("PatientName");//病人姓名
						String iDCardNo = json.getString("IDCardNo");//身份证号码
						String gender = json.getString("Gender");//性别；男、女、不确定
						String birth = json.getString("Birth");//出生日期；格式：1840-01-01
						String address = json.getString("Address");//住址
						String admDate = json.getString("AdmDate");//入院日期；格式：1840-01-01
						String dischargeDate = json.getString("DischargeDate");//出院日期；格式：1840-01-01
						String dischargeFlag = json.getString("DischargeFlag");//出院标志；0：在院1：出院
						String depCode = json.getString("DepCode");//患者住院所属科室编码
						String wardCode = json.getString("WardCode");//患者住院所属病区编码	
						String roomDesc = json.getString("RoomDesc");//病房名称；东华床位名称和编码（RoomCode）一致	
						String bedCode = json.getString("BedCode");//床号名称	
						String doctorID = json.getString("DoctorID");//医生ID
						String doctorName = json.getString("DoctorName");//医生姓名
						String diabetesType = json.getString("DiabetesType");//糖尿病类型;暂无
						String diaDefDate = json.getString("DiaDefDate");//糖尿病确诊日期;暂无
						String familyHistory = json.getString("FamilyHistory");//家族病史；暂无
						String anamnesis = json.getString("Anamnesis");//既往病史；暂无
						String waist = json.getString("Waist");//腰围
						String height = json.getString("Height");//身高
						String weight = json.getString("Weight");//体重

						HisPatient patient = new HisPatient();
						patient.setPatientId(patientID);
						patient.setCardNumber(admDR);
						patient.setHospitalTimes(inPatTimes);
						patient.setPhone(phone);
						patient.setName(patientName);
						patient.setIdentifyCard(iDCardNo);
						patient.setGender(gender);
						patient.setBirth(Constants.convert(birth, Constants.format1));
						patient.setAddress(address);
						patient.setHospitalDate(Constants.convert(admDate, Constants.format1));
						patient.setDischargeDate(Constants.convert(dischargeDate, Constants.format1));
						patient.setHospitalState(dischargeFlag);
						patient.setGlucoseDiseaseType(diabetesType);
						patient.setFirstGlucoseDate(diaDefDate);
						patient.setDoctorId(doctorID);
						patient.setDoctorName(doctorName);
						patient.setFamilyhistory(familyHistory);
						patient.setChronicDisease(anamnesis);
						patient.setDepartment(depCode);
						patient.setWardArea(wardCode);
						patient.setWardNo(roomDesc);
						patient.setBedNumber(bedCode);
						patient.setWaist(Double.valueOf(waist));
						patient.setHeight(Double.valueOf(height));
						patient.setWeight(Double.valueOf(weight));
						patientList.add(patient);
						patientParams.add(admDR);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Constants.params.put(SybWorkEvents.SYBPOTHER, patientParams);
		return (JSONArray) JSONArray.toJSON(patientList);
	}

	/**
	 * 功能：解析一级部门
	 * */
	private JSONArray wardareaParse(Object obList) {
		JSONObject srcJson = JSONObject.parseObject(obList.toString());
		List<HisWardarea> wardsList = new ArrayList<HisWardarea>();
		try {
			if (srcJson != null && srcJson.size() > 0) {
				String resultCode = srcJson.getString("ResultCode");
				JSONArray records = new JSONArray();
				if (srcJson.get("Records") instanceof JSONArray) {
					records = srcJson.getJSONArray("Records");
				} else {
					JSONObject $ = srcJson.getJSONObject("Records");
					records.add($);
				}
				if (resultCode.equals(String.valueOf(0)) && records != null && records.size() > 0) {
					for (Object o : records) {
						JSONObject json = (JSONObject) o;

						Long wardID = json.getLong("WardID");//病区ID
						String wardCode = json.getString("WardCode");//病区代码
						String wardDesc = json.getString("WardDesc");//病区名称
						String depCode = json.getString("DepCode");//所属科室
						String validFlag = json.getString("ValidFlag");//可用标志；0：作废；1：有效

						HisWardarea wards = new HisWardarea();
						wards.setId(wardID);
						wards.setWardareaCode(wardCode);
						wards.setWardareaName(wardDesc);
						wards.setDepartmentCode(depCode);
						wards.setOrder(Long.valueOf(0));
						wards.setValidFlag(Integer.valueOf(validFlag));
						wardsList.add(wards);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (JSONArray) JSONArray.toJSON(wardsList);
	}

	/**
	 * 功能：解析二级部门
	 * */
	private JSONArray departemtParse(Object obList, Object params) {
		JSONObject srcJson = JSONObject.parseObject(obList.toString());
		List<String> deptParams = new ArrayList<String>();//寄存科室Id参数
		List<HisDepartment> deptList = new ArrayList<HisDepartment>();
		try {
			if (srcJson != null && srcJson.size() > 0) {
				String resultCode = srcJson.getString("ResultCode");
				if (srcJson.get("Records") != null && resultCode.equals(String.valueOf(0))) {
					if (srcJson.get("Records") instanceof JSONArray) {
						JSONArray records = srcJson.getJSONArray("Records");
						if (records.size() > 0) {
							for (Object o : records) {
								JSONObject json = (JSONObject) o;
								Long depId = json.getLong("DepID");//科室ID
								String depCode = json.getString("DepCode");//科室代码
								String depDesc = json.getString("DepDesc");//科室名称
								Integer validFlag = json.getInteger("ValidFlag");//可用标志；0：作废；1：有效
								HisDepartment depts = new HisDepartment();
								depts.setId(depId);
								depts.setDepartmentName(depDesc);
								depts.setDepartmentCode(depCode);
								depts.setValidFlag(validFlag);
								deptList.add(depts);
								String value = depId.toString();
								if (!deptParams.contains(value)) {
									deptParams.add(value);
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Constants.params.put(SybWorkEvents.SYBSTAFF, deptParams);
		Constants.params.put(SybWorkEvents.SYBPATIENT, deptParams);
		return (JSONArray) JSONArray.toJSON(deptList);
	}

	/**
	 * 功能：解析科室员工信息
	 * 
	 * @param params
	 * */
	private JSONArray staffParse(Object obList, Object params) {
		JSONObject srcJson = JSONObject.parseObject(obList.toString());
		List<HisStaff> staffList = new ArrayList<HisStaff>();
		try {
			if (srcJson != null && srcJson.size() > 0) {
				String resultCode = srcJson.getString("ResultCode");
				if (srcJson.get("Records") != null && resultCode.equals(String.valueOf(0))) {
					if (srcJson.get("Records") instanceof JSONArray) {
						JSONArray records = srcJson.getJSONArray("Records");
						if (records.size() > 0) {
							for (Object o : records) {
								JSONObject json = (JSONObject) o;
								String userID = json.getString("UserID");//员工Id
								String userCode = json.getString("UserCode");//员工工号
								String userName = json.getString("UserName");//姓名
								String userSex = json.getString("UserSex");//性别
								String depCode = json.getString("DepCode");//科室编码
								String wardCode = json.getString("WardCode");//病区编码
								String careProvType = json.getString("CareProvType");//医护级别描述（不是职务）
								String phoneNo = json.getString("PhoneNo");//电话;无此信息
								String internalType = json.getString("InternalType");//DOCTOR:医生;NURSE:护士;Technician:技师;Pharmacist:药师
								String validFlag = json.getString("ValidFlag");//可用标志；0：作废；1：有效

								HisStaff staff = new HisStaff();
								staff.setStaffId(userID);
								staff.setUsercode(userCode);
								staff.setPersonname(userName);
								if (StringUtils.isNotBlank(internalType) && internalType.equals("DOCTOR"))
									staff.setTitle(String.valueOf(0));
								else
									staff.setTitle(String.valueOf(1));
								if (StringUtils.isNotBlank(userSex) && !userSex.equals("[]"))
									staff.setSex(userSex);
								staff.setDepartment(depCode);
								if (StringUtils.isNotBlank(phoneNo) && !phoneNo.equals("[]"))
									staff.setMobile(phoneNo);
								if (StringUtils.isNotBlank(wardCode) && !wardCode.equals("[]"))
									staff.setWardArea(wardCode);
								staffList.add(staff);
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (JSONArray) JSONArray.toJSON(staffList);
	}
}
