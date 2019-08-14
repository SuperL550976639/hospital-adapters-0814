package com.sybercare.hospital.health.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sybercare.hospital.common.utils.IHibernateBaseDao;
import com.sybercare.hospital.health.entity.MonitorModel;
import com.sybercare.hospital.health.entity.MonitorScheme;
import com.sybercare.hospital.health.entity.MonitorTemplate;
import com.sybercare.hospital.health.entity.PrescriptionOther;
import com.sybercare.hospital.health.entity.UserTask;

/**
 * 功能：监测医嘱数据处理
 *
 * @author 任梁荣
 * @version 创建时间：Sep 22, 2017 6:25:06 PM
 */
@Repository
@Transactional
public class PrescriptionOtherDAO {

	protected static final Logger LOGGER = LoggerFactory.getLogger(PrescriptionOtherDAO.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private IHibernateBaseDao<PrescriptionOther> hibernatePrescriptionOtherDao;

	@Autowired
	private IHibernateBaseDao<MonitorTemplate> hibernateMonitorTemplateDao;

	@Autowired
	private IHibernateBaseDao<MonitorModel> hibernateMonitorModelDao;

	@Autowired
	private IHibernateBaseDao<MonitorScheme> hibernateMonitorSchemeDao;

	public PrescriptionOther readPrescriptionOther(String prescriptionId) {
		PrescriptionOther prescriptionOther = null;
		try {
			if (StringUtils.isNotBlank(prescriptionId)) {
				prescriptionOther = this.hibernatePrescriptionOtherDao.get(PrescriptionOther.class, "prescriptionId",
						prescriptionId);
			}
		} catch (Exception e) {
			LOGGER.debug("readPrescriptionOther: " + e);
		}
		return prescriptionOther;
	}

	public void savePrescriptionOther(PrescriptionOther prescriptionOther) {
		try {
			if (null != prescriptionOther) {
				this.hibernatePrescriptionOtherDao.save(prescriptionOther);
			}
		} catch (Exception e) {
			LOGGER.debug("savePrescriptionOther: " + e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<MonitorTemplate> readMonitorTemplate(String comcode, String monitorSchemeName) {
		List<MonitorTemplate> monitorTemplateList = null;
		try {
			String hql = "from MonitorTemplate where comCode = ? and monitoreTemplateName = ?";
			Query query = this.hibernateMonitorTemplateDao.createQuery(hql, comcode, monitorSchemeName);
			monitorTemplateList = query.list();
		} catch (Exception e) {
			LOGGER.debug("readMonitorTemplate: " + e);
		}
		return monitorTemplateList;
	}

	public void saveNewMonitorModel(MonitorModel monitorModel) {
		try {
			if (null != monitorModel) {
				this.hibernateMonitorModelDao.save(monitorModel);
			}
		} catch (Exception e) {
			LOGGER.debug("saveNewMonitorModel: " + e);
		}
	}

	public void saveNewMonitorScheme(MonitorScheme monitorScheme) {
		try {
			if (null != monitorScheme) {
				this.hibernateMonitorSchemeDao.save(monitorScheme);
			}
		} catch (Exception e) {
			LOGGER.debug("saveNewMonitorScheme: " + e);
		}
	}

	public void updatePrescriptionOther(PrescriptionOther prescriptionOther) {
		try {
			if (null != prescriptionOther) {
				this.hibernatePrescriptionOtherDao.update(prescriptionOther);
			}
		} catch (Exception e) {
			LOGGER.debug("updatePrescriptionOther: " + e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Long> getPrescriptionIdsByUserId(String userId) {
		List<Long> monitorSchemeIds = new ArrayList<Long>();
		try {
			String hql = "from MonitorScheme where userId = ? and (status = 1 or status = 2)";
			Query query = this.hibernateMonitorSchemeDao.createQuery(hql, userId);
			List<MonitorScheme> list = query.list();
			if(null != list && list.size() > 0){
				for (int i = 0; i < list.size(); i++) {
					MonitorScheme MonitorScheme = list.get(i);
					monitorSchemeIds.add(MonitorScheme.getMonitorSchemeId());
				}
			}
		} catch (Exception e) {
			LOGGER.debug("getPrescriptionIdsByUserId: " + e);
		}
		return monitorSchemeIds;
	}
	
	public MonitorScheme getMonitorSchemeByMonitorSchemeId(String monitorSchemeId) {
		MonitorScheme monitorScheme = null;
		try {
			if (StringUtils.isNotBlank(monitorSchemeId)) {
				monitorScheme = this.hibernateMonitorSchemeDao.get(MonitorScheme.class, "monitorSchemeId",
						monitorSchemeId);
			}
		} catch (Exception e) {
			LOGGER.debug("getMonitorSchemeByMonitorSchemeId: " + e);
		}
		return monitorScheme;
	}
	
	public void updateMonitorScheme(MonitorScheme monitorScheme) {
		try {
			if (null != monitorScheme) {
				this.hibernateMonitorSchemeDao.update(monitorScheme);
			}
		} catch (Exception e) {
			LOGGER.debug("updateMonitorScheme: " + e);
		}
	}
	
	public void updateMonitorSchemeStatus(Short status, Long monitorSchemeId) {
		this.jdbcTemplate.update("update monitor_scheme set status = ? where monitor_scheme_id = ?",
				status, monitorSchemeId);
	}
	
	@SuppressWarnings("unchecked")
	public List<UserTask> getUserTaskByMonitorSchemeId(Integer monitorSchemeId) {
		List<UserTask> userTaskList = null;
		try {
			String hql = "from UserTask where monitorSchemeId = ? ";
			Query query = this.hibernateMonitorSchemeDao.createQuery(hql, monitorSchemeId);
			userTaskList = query.list();
		} catch (Exception e) {
			LOGGER.debug("getUserTaskByMonitorSchemeId: " + e);
		}
		return userTaskList;
	}
	
	public void updateUserTaskStatus(String status, Integer monitorSchemeId) {
		this.jdbcTemplate.update("update user_task set status = ? where id = ?",
				status, monitorSchemeId);
	}
}
