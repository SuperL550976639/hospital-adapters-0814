package com.sybercare.hospital.adapters.worker;

/**
 * 功能：HIS医院
 * 
 * @author 任梁荣
 * */
public enum HisWorkEvents {

	HISBASIC("Basic"),
	HISCIXI("CiXi"),
	HISPUSHDONGHUA("PushDongHua"),
	HISRECVDONGHUA("RecvDongHua"),
	HISDAQING("DaQing"),
	HISMUDANJIANG("MuDanJiang"),
	HISNANJING("NanJing"),
	HISXINHUA("XinHua"),
	HISHENANXINXING("HeNanXinXing"),
	HISSICHUANYIXING("SiChuanYiXing"),
	HISTIANPENGHENGYU("TianPengHengYu"),
	HISRECVBASIC("RecvBasic"),
	HISPUSHMIANYANGSANYUAN("PushMianYangSanYuan"),
	HISRECVMIANYANGSANYUAN("RecvMianYangSanYuan"),
	HISPUSHWENZHOUYIYUAN("PushWenZhouYiYuan"),
	HISRECVWENZHOUYIYUAN("RecvWenZhouYiYuan"),
	HISPUSHEEDUOSIZXYIYUAN("PushEEDuoSiZXYiYuan"),
	HISPUSHWENZHOURENMINYIYUAN("PushWenZhouRenMinYiYuan"),
	HISPUSHHHHTDYRENMINYIYUAN("PUSHHHHTDYRENMINYIYUAN"),
	HISPUSHZHAOTONGSHIZHONGYIYUAN("PushZhaoTongShiZhongYiYuan"),
	HISPUSHYANGPUQUZHONGXINYIYUAN("PushYangPuQquZhongXinYiYuan"),
	HISRECVSHANGHAIYANGPUQUZHONGXINYIYUAN("HisRecvShangHaiYangPuQuZhongXinYiYuanOnWorker");

	private String values;

	private HisWorkEvents(String values) {
		this.values = values;
	}

	public static HisWorkEvents nvalueOf(String value) {
		for (HisWorkEvents names : HisWorkEvents.values()) {
			if (names.values.equals(value)) {
				return names;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return this.values;
	}
}
