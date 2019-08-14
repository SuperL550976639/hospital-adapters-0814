package com.sybercare.hospital.migrate.utils;

public enum BloodUtils {

	Lo("Lo", "990.0"), Hi("Hi", "991.0"), SW("食晚", "996.0"), WC("外出", "997.0"), JC("拒测", "998.0"), QT("其他", "999.0");

	private String Bkey;

	private String Bvalue;

	private BloodUtils(String Bkey, String Bvalue) {
		this.Bkey = Bkey;
		this.Bvalue = Bvalue;
	}

	public static String Value(Double ab) {
		for (BloodUtils names : BloodUtils.values()) {
			if (names.getBvalue().equals(Double.toString(ab))) {
				return names.getBvalue();
			}
		}
		return null;
	}

	public String getBkey() {
		return Bkey;
	}

	public void setBkey(String bkey) {
		Bkey = bkey;
	}

	public String getBvalue() {
		return Bvalue;
	}

	public void setBvalue(String bvalue) {
		Bvalue = bvalue;
	}

}
