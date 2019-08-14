package com.sybercare.hospital.adapters.worker.data;

import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.sybercare.hospital.common.utils.IDataOnWorker;
import com.sybercare.hospital.common.utils.WorkAutowired;

/**
 * 功能：适配层数据来源实现管理
 * 
 * @author 任梁荣
 * */
@Component
public class HisDataManagers {

	@Autowired
	private ApplicationContext applicationContext;

	public static ConcurrentHashMap<HisDataEvents, IDataOnWorker> events = new ConcurrentHashMap<HisDataEvents, IDataOnWorker>();

	public IDataOnWorker proxy(HisDataEvents ds) {
		try {
			if (events != null && events.size() == 0)
				this.onLoadEventListener();
			if (events.containsKey(ds)) {
				return events.get(ds);
			}
		} catch (Exception e) {
		}
		return null;
	}

	@SuppressWarnings("rawtypes")
	protected boolean addEventListener(HisDataEvents ds, Class clazz) throws InstantiationException, IllegalAccessException {
		if (!events.containsKey(ds)) {
			try {
				IDataOnWorker bean = (IDataOnWorker) clazz.newInstance();
				Field[] fileds = clazz.getDeclaredFields();
				for (Field field : fileds) {
					if (field.isAnnotationPresent(WorkAutowired.class)) {
						Class<?> beanClass = field.getType();
						field.setAccessible(true);
						field.set(bean, getBean(beanClass));
					}
				}
				events.put(ds, bean);
				return true;
			} catch (InstantiationException | IllegalAccessException e) {
			}
		}
		return false;
	}
	
	protected void onLoadEventListener() throws InstantiationException, IllegalAccessException {
		this.addEventListener(HisDataEvents.MYSQL, HisDataMySqlOnWorker.class);
		this.addEventListener(HisDataEvents.MSSQL, HisDataMsSqlOnWorker.class);
		this.addEventListener(HisDataEvents.ORACLE, HisDataOracleOnWorker.class);
		this.addEventListener(HisDataEvents.DONGHUA, HisDataDongHuaOnWorker.class);
		this.addEventListener(HisDataEvents.MIANYANGSANYUAN, HisDataCacheDBOnWorker.class);
	}

	protected Object getBean(Class<?> bean) {
		return this.applicationContext.getBean(bean);
	}

}
