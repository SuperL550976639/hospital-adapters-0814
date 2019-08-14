package com.sybercare.hospital.adapters.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sybercare.hospital.adapters.entity.DataBeiTai;
import com.sybercare.hospital.adapters.service.BmiService;
import com.sybercare.hospital.health.dao.BmiDao;

@Service("bmiService")
public class BmiServiceImpl implements BmiService {
	@Autowired
	private BmiDao bmiDAO;

	@Override
	public void save(DataBeiTai dataBeiTai) {

		String userId = bmiDAO.selectUserIdByPhone(dataBeiTai.getPhone());
		if (null == userId) {
			// user不存在，插入
			userId = UUID.randomUUID().toString();
			bmiDAO.insertHisUser(dataBeiTai, userId);
		} else {
			// user存在，更新
			bmiDAO.updateHisUser(dataBeiTai);
		}
		// 插入bmi
		bmiDAO.insertDataBmi(dataBeiTai, userId);

	}

}
