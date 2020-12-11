package com.enc.batch;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public class VmMetric {
	private String dimensionValue;
	private String vmName;
	private long lastUpdateTime; 
	private Map<String, VmMeticBean> vmMeticMap;
	
	public VmMetric(String vmName, String dimensionValue) {
		this.vmName 			= vmName;
		this.dimensionValue 	= dimensionValue;
		this.vmMeticMap 		= new HashMap<String, VmMeticBean>();
		this.lastUpdateTime 	= System.currentTimeMillis();
	}
	
	public VmMeticBean getByInfo(String key) {
		return this.vmMeticMap.get(key);
	}

	public String getDimensionValue() {
		return dimensionValue;
	}

	public String getVmName() {
		return vmName;
	}

	public long getLastUpdateTime() {
		return lastUpdateTime;
	}
	
	public void put(String infoType, JSONObject value) {
		VmMeticBean bean 	= this.vmMeticMap.get(infoType);
		if (bean == null) {
			bean 			= new VmMeticBean(infoType);
			this.vmMeticMap.put(infoType, bean);
		}
		bean.setTimestamp(value.getString("timestamp"));
		bean.setUnit(value.getString("unit"));
		bean.setMaximum(value.getDoubleValue("maximum"));
		bean.setMinimum(value.getDoubleValue("minimum"));
		bean.setSum(value.getDoubleValue("sum"));
		bean.setAverage(value.getDoubleValue("average"));
		this.lastUpdateTime 	= System.currentTimeMillis();
	}
}
