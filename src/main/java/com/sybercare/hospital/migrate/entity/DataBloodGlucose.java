package com.sybercare.hospital.migrate.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "data_blood_glucose")
public class DataBloodGlucose {

	@Id
	@Column(name = "id")
	private Integer id; // bigInteger(20) NOT NULL AUTO_INCREMENT,
	private Double value; // double DEFAULT NULL COMMENT '血糖值
							// 999--其他(理由存reason)，998--拒测，997--外出，996--食晚，991--HI,990--Lo',
	private Integer status; // Integer(4) DEFAULT NULL COMMENT '999-时段为无',
	private String measure_time; // varchar(19) DEFAULT NULL,
	private String remark; // varchar(200) DEFAULT NULL,
	private String user_id; // varchar(50) DEFAULT NULL,
	private String device_sn; // varchar(50) DEFAULT NULL,
	private String stamp_time; // varchar(19) DEFAULT NULL,
	private String opratorId; // varchar(50) DEFAULT NULL COMMENT '操作人Id',
	private String datasource; // varchar(2) DEFAULT NULL COMMENT '0:手动,1住院,2门诊,3自费',
	private String gsn_time; // varchar(20) DEFAULT NULL COMMENT '蓝牙网关时间',
	private Long data_sn; // bigInteger(20) DEFAULT NULL COMMENT '数据序列号',
	private Date create_time; // datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	private Date last_update_time; // datetime DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
	private Boolean evaluation; // tinyInteger(4) DEFAULT '0' COMMENT '评测结果',
	private String message; // varchar(255) DEFAULT NULL COMMENT '消息',
	private String opt_comment; // varchar(255) DEFAULT NULL COMMENT '运营批注',
	private Boolean operate_type; // tinyInteger(4) DEFAULT NULL COMMENT '操作类型1:增加 2:修改 3.删除',
	private Boolean operate_state; // tinyInteger(4) DEFAULT NULL COMMENT '操作类型0：未操作 1：已操作',
	private String bgqc_paper_number; // varchar(30) DEFAULT NULL COMMENT '试纸编号',
	private Date etl_time; // datetime DEFAULT NULL COMMENT '向院外同步时间',
	private Integer value_status; // Integer(2) DEFAULT NULL COMMENT '0--无效，1--有效',
	private String valid_status; // varchar(1) NOT NULL COMMENT '数据是否有效 0-无效 1-有效',
	private String reason; // varchar(50) DEFAULT NULL COMMENT '拒测原因',

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMeasure_time() {
		return measure_time;
	}

	public void setMeasure_time(String measure_time) {
		this.measure_time = measure_time;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getDevice_sn() {
		return device_sn;
	}

	public void setDevice_sn(String device_sn) {
		this.device_sn = device_sn;
	}

	public String getStamp_time() {
		return stamp_time;
	}

	public void setStamp_time(String stamp_time) {
		this.stamp_time = stamp_time;
	}

	public String getOpratorId() {
		return opratorId;
	}

	public void setOpratorId(String opratorId) {
		this.opratorId = opratorId;
	}

	public String getDatasource() {
		return datasource;
	}

	public void setDatasource(String datasource) {
		this.datasource = datasource;
	}

	public String getGsn_time() {
		return gsn_time;
	}

	public void setGsn_time(String gsn_time) {
		this.gsn_time = gsn_time;
	}

	public Long getData_sn() {
		return data_sn;
	}

	public void setData_sn(Long data_sn) {
		this.data_sn = data_sn;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Date getLast_update_time() {
		return last_update_time;
	}

	public void setLast_update_time(Date last_update_time) {
		this.last_update_time = last_update_time;
	}

	public Boolean getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(Boolean evaluation) {
		this.evaluation = evaluation;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getOpt_comment() {
		return opt_comment;
	}

	public void setOpt_comment(String opt_comment) {
		this.opt_comment = opt_comment;
	}

	public Boolean getOperate_type() {
		return operate_type;
	}

	public void setOperate_type(Boolean operate_type) {
		this.operate_type = operate_type;
	}

	public Boolean getOperate_state() {
		return operate_state;
	}

	public void setOperate_state(Boolean operate_state) {
		this.operate_state = operate_state;
	}

	public String getBgqc_paper_number() {
		return bgqc_paper_number;
	}

	public void setBgqc_paper_number(String bgqc_paper_number) {
		this.bgqc_paper_number = bgqc_paper_number;
	}

	public Date getEtl_time() {
		return etl_time;
	}

	public void setEtl_time(Date etl_time) {
		this.etl_time = etl_time;
	}

	public Integer getValue_status() {
		return value_status;
	}

	public void setValue_status(Integer value_status) {
		this.value_status = value_status;
	}

	public String getValid_status() {
		return valid_status;
	}

	public void setValid_status(String valid_status) {
		this.valid_status = valid_status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

}
