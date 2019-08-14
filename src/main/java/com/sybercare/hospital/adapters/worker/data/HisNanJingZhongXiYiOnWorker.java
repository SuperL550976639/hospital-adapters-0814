package com.sybercare.hospital.adapters.worker.data;

import com.sybercare.hospital.common.utils.IDataOnWorker;

/**
 * 功能：南京中西医院对接数据实现
 *
 * @author 任梁荣
 * @version 创建时间：Oct 13, 2017 2:23:06 PM
 */
public class HisNanJingZhongXiYiOnWorker implements IDataOnWorker {

	@Override
	public String versionName() {
		return String.valueOf("南京中西医院");
	}

	@Override
	public Object readData(Object woker, Object params) {
//		WebInterfaceSoapProxy soap = new WebInterfaceSoapProxy();//医联通
		// soap.sendEmr("ZY01", sendXml, userCode);

//		EmrToExternalServiceSoapProxy emrsoap = new EmrToExternalServiceSoapProxy();//曼陀罗
		// emrsoap.saveRecruit3Xml(userId, formType, pageCount, hisId, formName,
		// returnXml, dateUpdate, errorMsg)

		return null;
	}

	@Override
	public boolean recvData(Object args) {

		return false;
	}

}
