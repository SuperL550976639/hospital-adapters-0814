package com.sybercare.hospital.adapters.entity;

public class DataBeiTai {
	private String idcard;
	private String phone;
	private String type;
	private String dtype;
	private String did;
	private DataBeiTaiDetail data;

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDtype() {
		return dtype;
	}

	public void setDtype(String dtype) {
		this.dtype = dtype;
	}

	public String getDid() {
		return did;
	}

	public void setDid(String did) {
		this.did = did;
	}

	public DataBeiTaiDetail getData() {
		return data;
	}

	public void setData(DataBeiTaiDetail data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "DataBmi [idcard=" + idcard + ", phone=" + phone + ", type=" + type + ", dtype=" + dtype + ", did=" + did
				+ ", data=" + data + "]";
	}

}
