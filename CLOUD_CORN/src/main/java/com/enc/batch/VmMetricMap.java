package com.enc.batch;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

import com.alibaba.fastjson.JSONObject;

public class VmMetricMap extends ConcurrentHashMap<String, VmMetric> {
	public VmMetricMap() { 
		
	}
	
	public void put(String infoType, String dimensionValue, String vmname, JSONObject getmetricstatisticsresponse) {
		if (getmetricstatisticsresponse.getIntValue("count") > 0) {
			VmMetric bean 		= this.get(dimensionValue);
			if (bean == null) {
				bean 			= new VmMetric(vmname, dimensionValue);
				this.put(dimensionValue, bean);
			}
			bean.put(infoType, getmetricstatisticsresponse.getJSONArray("metricstatistics").getJSONObject(0));
		}
	}
	
	public Iterator<String> getkeyIterator() {
		Iterator<String> iterator 	= this.keySet().iterator();
		//while (iterator.hasNext()) {
		//	System.out.println(iterator.next());
		//}
		
		return iterator;
	}
}
