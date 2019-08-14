package com.sybercare.hospital.migrate.utils;

public enum Period {
	KF("空腹", "KF", 0), ZCH("早餐后", "ZCH", 1), WUCQ("午餐前", "WUCQ", 2), WUCH("午餐后", "WUCH", 3), WACQ("晚餐前", "WACQ", 4),
	WACH("晚餐后", "WACH", 5), SQ("睡前", "SQ", 6), LC("凌晨", "LC", 7), LC3("凌晨3点", "LC3", 7), SJ("随机", "SJ", 8);

	private String periods;

	private String pers;

	private int status;

	private Period(String periods, String pers, int status) {
		this.periods = periods;
		this.pers = pers;
		this.status = status;
	}

	public static String Periods(String value) {
		for (Period names : Period.values()) {
			if (names.getPeriods().equals(value)) {
				return names.getPers();
			}
		}
		return null;
	}

	public static String Status(int value) {

		for (Period names : Period.values()) {
			if (names.getStatus() == value) {
				return names.getPers();
			}
		}
		return null;
	}

	public static String Per(String value) {
		for (Period names : Period.values()) {
			if (names.getPers().equals(value)) {
				return names.getPers();
			}
		}
		return null;
	}

	public String getPeriods() {
		return periods;
	}

	public void setPeriods(String periods) {
		this.periods = periods;
	}

	public String getPers() {
		return pers;
	}

	public void setPers(String pers) {
		this.pers = pers;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
