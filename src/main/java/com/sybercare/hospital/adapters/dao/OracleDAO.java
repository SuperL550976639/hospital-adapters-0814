package com.sybercare.hospital.adapters.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSON;
import com.sybercare.hospital.adapters.entity.DataBloodGlucose;
import com.sybercare.hospital.adapters.entity.HisPatient;
import com.sybercare.hospital.adapters.entity.HisPrescriptionOther;
import com.sybercare.hospital.adapters.entity.HisStaff;
import com.sybercare.hospital.common.ds.DynamicDataSourceAutowired;
import com.sybercare.hospital.common.utils.Constants;

/**
 * 功能：oracle数据库业务实现
 *
 * @author 任梁荣
 * @version 创建时间：Sep 25, 2017 2:39:22 PM
 */
@Repository
public class OracleDAO {

	protected static final Logger LOGGER = LoggerFactory.getLogger(OracleDAO.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@DynamicDataSourceAutowired(name = "his")
	public Object readWardareaList() {

		return null;
	}

	@DynamicDataSourceAutowired(name = "his")
	public Object readDepartmentList() {

		return null;
	}

	@DynamicDataSourceAutowired(name = "his")
	public Object readPotherList() {
		List<HisPrescriptionOther> result = new ArrayList<HisPrescriptionOther>();
		StringBuffer sql = new StringBuffer().append(
				"Select * from HIS_PRESCRIPTION_OTHER where creat_date > TO_DATE('2019-3-10','yyyy-mm-dd') AND PRESCRIPTION_NAME like '%血糖%' ");

		result = this.jdbcTemplate.query(sql.toString(), new RowMapper<HisPrescriptionOther>() {
			@Override
			public HisPrescriptionOther mapRow(ResultSet rs, int rowNum) throws SQLException {
				HisPrescriptionOther Pother = new HisPrescriptionOther();
				Pother.setPrescriptionId(rs.getString("PRESCRIPTION_ID"));
				Pother.setPatientId(rs.getString("PATIENT_ID"));
				Pother.setCreateDate(rs.getTimestamp("CREAT_DATE"));
				Pother.setCardNumber(rs.getString("CARD_NUMBER"));
				Pother.setPrescriptionName(rs.getString("PRESCRIPTION_NAME"));
				Pother.setFrequency(rs.getString("FREQUENCY"));
				Pother.setPrescriptionNotes(rs.getString("PRESCRIPTION_NOTES"));
				Pother.setStartTime(rs.getTimestamp("START_TIME"));
				Pother.setEndTime(rs.getTimestamp("END_TIME"));
				Pother.setDoctorId(rs.getString("DOCTOR_ID"));
				Pother.setPrescriptionNo(rs.getString("PRESCRIPTION_NO"));
				Pother.setPrescriptionType(rs.getString("PRESCRIPTION_TYPE"));
				Pother.setRemark(rs.getString("REMARK"));
				Pother.setPrescriptionStatus(rs.getString("PRESCRIPTION_STATUS"));
				return Pother;
			}
		});
		return result;
	}

	@DynamicDataSourceAutowired(name = "his")
	public Object readPatientList() {
		List<HisPatient> result = new ArrayList<HisPatient>();
		StringBuffer sql = new StringBuffer().append("Select * from HIS_PATIENT");

		result = this.jdbcTemplate.query(sql.toString(), new RowMapper<HisPatient>() {
			@Override
			public HisPatient mapRow(ResultSet rs, int rowNum) throws SQLException {
				HisPatient Patient = new HisPatient();
				Patient.setPatientId(rs.getString("PATIENT_ID"));
				Patient.setCardNumber(rs.getString("CARD_NUMBER"));
				Patient.setHospitalTimes(rs.getString("HOSPITAL_TIMES"));
				Patient.setPhone(rs.getString("PHONE"));
				Patient.setName(rs.getString("NAME"));
				Patient.setIdentifyCard(rs.getString("IDENTIFY_CARD"));
				Patient.setGender(rs.getString("GENDER"));
				Patient.setBirth(rs.getDate("BIRTH"));
				Patient.setAddress(rs.getString("ADDRESS"));
				Patient.setHospitalDate(rs.getTimestamp("HOSPITAL_DATE"));
				Patient.setDischargeDate(rs.getTimestamp("DISCHARGE_DATE"));
				Patient.setHospitalState(rs.getString("HOSPITAL_STATE"));
				Patient.setGlucoseDiseaseType(rs.getString("GLUCOSE_DISEASE_TYPE"));
				Patient.setFirstGlucoseDate(rs.getString("FIRST_GLUCOSE_DATE"));
				Patient.setDoctorId(rs.getString("DOCTOR_ID"));
				Patient.setDoctorName(rs.getString("DOCTOR_NAME"));
				Patient.setFamilyhistory(rs.getString("FAMILYHISTORY"));
				Patient.setChronicDisease(rs.getString("CHRONIC_DISEASE"));
				Patient.setWardArea(rs.getString("WARD_AREA"));
				Patient.setDepartment(rs.getString("DEPARTMENT"));
				Patient.setWardNo(rs.getString("WARD_NO"));
				Patient.setBedNumber(rs.getString("BED_NUMBER"));
				Patient.setProfession(rs.getString("PROFESSION"));
				Patient.setWaist(rs.getDouble("WAIST"));
				Patient.setHeight(rs.getDouble("HEIGHT"));
				Patient.setWeight(rs.getDouble("WEIGHT"));
				return Patient;
			}
		});
		return result;
	}

	@DynamicDataSourceAutowired(name = "his")
	public Object readStaffList() {
		List<HisStaff> result = new ArrayList<HisStaff>();
		StringBuffer sql = new StringBuffer().append("Select * from HIS_STAFF");

		result = this.jdbcTemplate.query(sql.toString(), new RowMapper<HisStaff>() {
			@Override
			public HisStaff mapRow(ResultSet rs, int rowNum) throws SQLException {
				HisStaff staff = new HisStaff();
				staff.setStaffId(rs.getString("STAFF_ID"));
				staff.setUsercode(rs.getString("USER_CODE"));
				staff.setPersonname(rs.getString("PERSONNAME"));
				staff.setSex(rs.getString("SEX"));
				staff.setDepartment(rs.getString("DEPARTMENT"));
				staff.setWardArea(rs.getString("WARD_AREA"));
				staff.setTitle(rs.getString("TITLE"));
				staff.setMobile(rs.getString("MOBLIE"));
				staff.setDoctorLevel(rs.getString("DOCTOR_LEVEL"));
				return staff;
			}
		});
		return result;
	}

	@DynamicDataSourceAutowired(name = "his")
	public boolean saveBloodGlucoseList(Object args) {
		if (null != args) {
			Connection conn = null;
			CallableStatement statement = null;
			try {
				DataBloodGlucose bloodGlucose = JSON.parseObject(args.toString(), DataBloodGlucose.class);
				String id = bloodGlucose.getId().toString();
				Number visit_id = 1;
				String value = bloodGlucose.getValue(); // 值
				String status = bloodGlucose.getStatus(); // 时间段
				String measureTime = Constants.convert(bloodGlucose.getMeasureTime(), Constants.format2);
				; // 时间
				String patientId = bloodGlucose.getPatientId(); // 患者id
//				String cardNumber = bloodGlucose.getCardNumber(); // 患者住院号
				String units = "mmol/L"; // 单位
				String text_range = "0.6-33.3"; // 范围
//				String opratorId = bloodGlucose.getOpratorId(); // 测量人id
				Integer opratorState = bloodGlucose.getOperateState(); // 状态 0:未修改 1:已修改
				Integer opratorType = bloodGlucose.getOperateType(); // 状态 1:增加 2:修改 3:删除
//				String remark = bloodGlucose.getRemark(); // 备注
				String opratorName = bloodGlucose.getOpratorName(); // 测量人姓名

				if (value.equals("991.0")) {
					value = "HI";
				}
				if (value.equals("990.0")) {
					value = "Lo";
				}
				if (value.equals("996.0")) {
					value = "食晚";
				}
				if (value.equals("997.0")) {
					value = "外出";
				}
				if (value.equals("998.0")) {
					value = "拒测";
				}
				if (value.equals("999.0")) {
					value = "其他";
				}

				// int res = 0;
				String note = "";

				switch (status) {
				case "0":
					note = "空腹";
					break;
				case "1":
					note = "早餐后";
					break;
				case "2":
					note = "午餐前";
					break;
				case "3":
					note = "午餐后";
					break;
				case "4":
					note = "晚餐前";
					break;
				case "5":
					note = "晚餐后";
					break;
				case "6":
					note = "睡前";
					break;
				case "7":
					note = "凌晨";
					break;
				case "9":
					note = "凌晨三点";
					break;
				default:
					note = "随机";
					break;
				}

				String cancleFlag = "";

				if (opratorType == 3) {

					cancleFlag = "1";
				}

				if (opratorState == 0) {

					String sql = "{call comm.blood_sugar_sh(?,?,?,?,?,?,?,?,?,?,?,?)}";

					conn = this.jdbcTemplate.getDataSource().getConnection();

					statement = conn.prepareCall(sql);

					statement.setString(1, patientId);
					statement.setInt(2, (int) visit_id);
					statement.setString(3, id);
					statement.setString(4, measureTime);
					statement.setString(5, value);
					statement.setString(6, units);
					statement.setString(7, text_range);
					statement.setString(8, opratorName);
					statement.setString(9, note);
					statement.setString(10, cancleFlag);

					statement.registerOutParameter(11, oracle.jdbc.OracleTypes.NUMBER);
					statement.registerOutParameter(12, oracle.jdbc.OracleTypes.VARCHAR);

					statement.execute();

					System.out.println(
							"1:" + patientId + "2:" + visit_id + "3:" + id + "4:" + measureTime + "5:" + value + "6:"
									+ units + "7:" + text_range + "8:" + opratorName + "9" + note + "10:" + cancleFlag);

					System.out.println(statement.getString(11) + "-|-" + statement.getString(12));
				}

				/*
				 * if(opratorType == 1 && opratorState ==0){ res = this.jdbcTemplate.update(
				 * " insert into ZEMR_BLOOD_MONITOR( " +
				 * " patient_id, event_no, recording_date, last_operator, last_operator_id, item_result, note, id, recording_time, flag) "
				 * + " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", patientId, cardNumber,
				 * measureTime, opratorName, opratorId, value, note, id, note, opratorType);
				 */
				/*
				 * if(opratorType == 1 && opratorState ==0){ res = this.jdbcTemplate.update(
				 * " insert into ZEMR_BLOOD_MONITOR( " +
				 * " patient_id, event_no, recording_date, last_operator, last_operator_id, item_result, note, id, recording_time, flag) "
				 * + " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", patientId, measureTime,
				 * opratorName, value, note, note, opratorType);
				 * 
				 * }
				 */

				if (statement.getString(11) != null && statement.getString(11).equals("1")) {
					return true;
				} else {
					return false;
				}
			} catch (Exception e) {
				e.printStackTrace();
				LOGGER.debug("saveBloodGlucoseList: " + e);
			} finally {
				try {
					if (conn != null) {
						conn.close();
					}
					if (statement != null) {
						statement.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}
		return false;
	}
}
