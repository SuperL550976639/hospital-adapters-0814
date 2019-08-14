package com.sybercare.hospital.adapters.entity;

public class DataBeiTaiDetail {
	private String weight;
	private String height;
	private String time;
	private String medicId;
	private String physicalID;
	private Suggestion suggestion;

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getMedicId() {
		return medicId;
	}

	public void setMedicId(String medicId) {
		this.medicId = medicId;
	}

	public String getPhysicalID() {
		return physicalID;
	}

	public void setPhysicalID(String physicalID) {
		this.physicalID = physicalID;
	}

	public Suggestion getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(Suggestion suggestion) {
		this.suggestion = suggestion;
	}

	@Override
	public String toString() {
		return "DataBmiDetail [weight=" + weight + ", height=" + height + ", time=" + time + ", medicId=" + medicId
				+ ", physicalID=" + physicalID + ", suggestion=" + suggestion + "]";
	}

}
