package com.sybercare.hospital.health.dao;

import com.sybercare.hospital.adapters.entity.DataBeiTai;

public interface BmiDao {
	void insertDataBmi(DataBeiTai dataBeiTai, String userId);

	String selectUserIdByPhone(String phone);

	void insertHisUser(DataBeiTai dataBeiTai, String userId);

	void updateHisUser(DataBeiTai dataBeiTai);
}
