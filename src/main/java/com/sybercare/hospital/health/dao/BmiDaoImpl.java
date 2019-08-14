package com.sybercare.hospital.health.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sybercare.hospital.adapters.entity.DataBeiTai;

@Repository
@Transactional
public class BmiDaoImpl implements BmiDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void insertDataBmi(DataBeiTai dataBeiTai, String userId) {
		double height = Double.parseDouble(dataBeiTai.getData().getHeight());
		BigDecimal bigDecimalHeight = new BigDecimal(height);
		double weight = Double.parseDouble(dataBeiTai.getData().getWeight());
		BigDecimal bigDecimalWeight = new BigDecimal(weight);
		BigDecimal bmi = bigDecimalWeight.divide(
				(bigDecimalHeight.divide(new BigDecimal(100))).multiply((bigDecimalHeight.divide(new BigDecimal(100)))),
				2, BigDecimal.ROUND_HALF_UP);
		String sql = "INSERT INTO "
				+ "data_bmi(height,weight,user_id,measure_time,device_sn,data_sn,opratorId,datasource,stamp_time,bmi) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, height, weight, userId, dataBeiTai.getData().getTime(), dataBeiTai.getDid(),
				dataBeiTai.getType(), userId, 2, new Date(), bmi);
	}

	public String selectUserIdByPhone(String phone) {
		String sql = "SELECT user_id FROM user WHERE user.phone=?";
		List<String> userIds = jdbcTemplate.queryForList(sql, String.class, phone);
		if (!userIds.isEmpty()) {
			return userIds.get(0);
		}
		return null;
	}

	@Override
	public void insertHisUser(DataBeiTai dataBeiTai, String userId) {
		String sql = "INSERT INTO user(user_id,phone,identify_card,status,create_time) VALUES(?,?,?,?,?)";
		jdbcTemplate.update(sql, userId, dataBeiTai.getPhone(), dataBeiTai.getIdcard(), 1, new Date());
	}

	@Override
	public void updateHisUser(DataBeiTai dataBeiTai) {
		String sql = "UPDATE user SET identify_card=?,update_time=? WHERE phone=?";
		jdbcTemplate.update(sql, dataBeiTai.getIdcard(), new Date(), dataBeiTai.getPhone());

	}

}
