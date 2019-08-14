package com.sybercare.hospital.adapters.worker;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.sybercare.hospital.adapters.worker.push.HisBasePushOnWorker;
import com.sybercare.hospital.adapters.worker.push.hospital.HisPushYangPuQuZhongXinYiYuanOnWorker;
import com.sybercare.hospital.adapters.worker.recv.HisRecvShangHaiYangPuQuZhongXinYiYuanOnWorker;
import com.sybercare.hospital.common.utils.BaseObservable;
import com.sybercare.hospital.common.utils.BaseObserver;
import com.sybercare.hospital.common.utils.WorkAutowired;

/**
 * 功能：HIS医院
 * 
 * @author 任梁荣
 */
@Component
public class HisWorkManagers {

	/*
	 * public class HisPushEEDuoSiZXYiYuanOnWorker {
	 * 
	 * }
	 */

	@Autowired
	private ApplicationContext applicationContext;

	protected static final Logger logger = LoggerFactory.getLogger(HisWorkManagers.class);
	public static ConcurrentHashMap<HisWorkEvents, BaseObservable> events = new ConcurrentHashMap<HisWorkEvents, BaseObservable>();

	public synchronized boolean onEvents(HisWorkEvents names, Object... args) {
		try {
			if (events != null && events.size() == 0)
				this.onLoadEventListener();
			if (events.containsKey(names)) {
				BaseObservable base = events.get(names);
				base.setChanged();
				base.notifyObservers(args);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@SuppressWarnings("rawtypes")
	protected boolean addEventListener(HisWorkEvents names, Class clazz)
			throws InstantiationException, IllegalAccessException {
		if (!events.containsKey(names)) {
			try {
				BaseObservable baseObs = new BaseObservable();
				BaseObserver observer = (BaseObserver) clazz.newInstance();
				List<Field> fileds = new ArrayList<Field>() {
					private static final long serialVersionUID = -7153556867475157193L;
					{
						Class tempClass = clazz;
						while (tempClass != null) {
							addAll(Arrays.asList(tempClass.getDeclaredFields()));
							tempClass = tempClass.getSuperclass();
						}
					}
				};
				for (Field field : fileds) {
					if (field.isAnnotationPresent(WorkAutowired.class)) {
						Class<?> beanClass = field.getType();
						field.setAccessible(true);
						field.set(observer, getBean(beanClass));
					}
				}
				baseObs.addObserver(observer);
				events.put(names, baseObs);
				return true;
			} catch (InstantiationException | IllegalAccessException e) {
			}
		}
		return false;
	}

	protected void onLoadEventListener() throws InstantiationException, IllegalAccessException {
		this.addEventListener(HisWorkEvents.HISBASIC, HisBasePushOnWorker.class);
		this.addEventListener(HisWorkEvents.HISPUSHYANGPUQUZHONGXINYIYUAN, HisPushYangPuQuZhongXinYiYuanOnWorker.class);
		this.addEventListener(HisWorkEvents.HISRECVSHANGHAIYANGPUQUZHONGXINYIYUAN,
				HisRecvShangHaiYangPuQuZhongXinYiYuanOnWorker.class);
	}

	protected Object getBean(Class<?> bean) {
		return this.applicationContext.getBean(bean);
	}
}
