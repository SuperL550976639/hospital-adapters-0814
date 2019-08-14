package com.sybercare.hospital.adapters.entity;

import java.util.Date;

public class HisRecvBlood {

	/** 病人ID */
	private String patientId;
	/** 病人住院号 */
	private String eventNo;
	/** 病人测量时间 */
	private Date inputDate;
	/** 测量人 */
	private String lastOperator;
	/** 测量人id */
	private String lastOperatorId;
	/** 空腹 */
	private String before_breakfast;
	/** 早餐后 */
	private String after_breakfast;
	/** 午餐前 */
	private String before_lunch;
	/** 午餐后 */
	private String after_lunch;
	/** 晚餐前 */
	private String before_supper;
	/** 晚餐后 */
	private String after_supper;
	/** 睡前 */
	private String before_sleep;
	/** 凌晨 */
	private String early;
	/** 凌晨3点 */
	private String three;
	/** 其他情况 */
	private String others;
	/** 备注 */
	private String note;
	
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getEventNo() {
		return eventNo;
	}
	public void setEventNo(String eventNo) {
		this.eventNo = eventNo;
	}
	public Date getInputDate() {
		return inputDate;
	}
	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}
	public String getLastOperator() {
		return lastOperator;
	}
	public void setLastOperator(String lastOperator) {
		this.lastOperator = lastOperator;
	}
	public String getLastOperatorId() {
		return lastOperatorId;
	}
	public void setLastOperatorId(String lastOperatorId) {
		this.lastOperatorId = lastOperatorId;
	}
	public String getBefore_breakfast() {
		return before_breakfast;
	}
	public void setBefore_breakfast(String before_breakfast) {
		this.before_breakfast = before_breakfast;
	}
	public String getAfter_breakfast() {
		return after_breakfast;
	}
	public void setAfter_breakfast(String after_breakfast) {
		this.after_breakfast = after_breakfast;
	}
	public String getBefore_lunch() {
		return before_lunch;
	}
	public void setBefore_lunch(String before_lunch) {
		this.before_lunch = before_lunch;
	}
	public String getAfter_lunch() {
		return after_lunch;
	}
	public void setAfter_lunch(String after_lunch) {
		this.after_lunch = after_lunch;
	}
	public String getBefore_supper() {
		return before_supper;
	}
	public void setBefore_supper(String before_supper) {
		this.before_supper = before_supper;
	}
	public String getAfter_supper() {
		return after_supper;
	}
	public void setAfter_supper(String after_supper) {
		this.after_supper = after_supper;
	}
	public String getBefore_sleep() {
		return before_sleep;
	}
	public void setBefore_sleep(String before_sleep) {
		this.before_sleep = before_sleep;
	}
	public String getEarly() {
		return early;
	}
	public void setEarly(String early) {
		this.early = early;
	}
	public String getThree() {
		return three;
	}
	public void setThree(String three) {
		this.three = three;
	}
	public String getOthers() {
		return others;
	}
	public void setOthers(String others) {
		this.others = others;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
}
