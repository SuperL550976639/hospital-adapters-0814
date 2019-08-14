package com.sybercare.hospital.adapters.entity;

public class Suggestion {
	private String food;
	private String sport;
	private String common;
	private String doctor;

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	public String getCommon() {
		return common;
	}

	public void setCommon(String common) {
		this.common = common;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "Suggestion [food=" + food + ", sport=" + sport + ", common=" + common + ", doctor=" + doctor + "]";
	}

}
