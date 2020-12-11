package com.enc.business.admin;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.enc.aop.AdminLoginAspect;
import com.enc.batch.UsageVmAnalyze;
import com.enc.batch.VmMeticBean;
import com.enc.batch.VmMetric;
import com.enc.business.front.MonitoringService;
import com.enc.config.SolutionConfig;
import com.typhoon.framework.aop.RESPONSE_TYPE;
import com.typhoon.framework.json.JSONResMessage;

@Controller
@RequestMapping({"/admin/01"})
public class ADM01Controller {
	private final org.slf4j.Logger LOGGER 			= org.slf4j.LoggerFactory.getLogger("TYPHOON_LOG");
	
	@Autowired
    private SolutionConfig solutionConfig;
	
	@Autowired
	private MonitoringService monitoringService;
	
    /**
     * 관리자/대시보드
     * 
     * @return
     */
    @GetMapping({"", "/", "/index", "/01"})
    @AdminLoginAspect(resType = RESPONSE_TYPE.MOVE)
	public ModelAndView adm01_01(HttpServletRequest request) {
    	ModelAndView mv = new ModelAndView("/admin/01/01");
		return mv;
	}
    
	@PostMapping("/01AL")
	@AdminLoginAspect
	public @ResponseBody JSON adm_01AL(HttpServletRequest request, @RequestBody JSONObject paramJson) throws Exception {
		JSONResMessage resJson 		= new JSONResMessage(JSONResMessage.SUCCESS);
		JSONArray list 				= null;
		
		try {
			list 					= monitoringService.getServerMonitorList();
			int size 				= (list == null)? 0 : list.size();
			
			Iterator<String> iterator 	= UsageVmAnalyze.VMMETRICMAP.getkeyIterator();
    		while (iterator.hasNext()) {
    			String key 				= iterator.next();
    			VmMetric metric 		= UsageVmAnalyze.VMMETRICMAP.get(key);
    			for (int i = 0; i < size; i++) {
    				JSONObject bean 	= list.getJSONObject(i);
    				String hostName 	= bean.getString("HOSTNAME");
    				System.out.println("key:" + key + ", hostname:" + hostName);
    				if (hostName.equalsIgnoreCase(metric.getVmName())) {
    					bean.put(VmMeticBean.INFO_TYPE_DISKR, metric.getByInfo(VmMeticBean.INFO_TYPE_DISKR));
    					bean.put(VmMeticBean.INFO_TYPE_DISKW, metric.getByInfo(VmMeticBean.INFO_TYPE_DISKW));
    					bean.put(VmMeticBean.INFO_TYPE_NETI, metric.getByInfo(VmMeticBean.INFO_TYPE_NETI));
    					bean.put(VmMeticBean.INFO_TYPE_NETO, metric.getByInfo(VmMeticBean.INFO_TYPE_NETO));
    					break;
    				}
    			}
    		}
    		
    		resJson.put("metrics", list);
		} catch(Exception e) {
			LOGGER.error("adm_01AL", e);
			resJson 				= new JSONResMessage(JSONResMessage.FAIL, "요청작업 처리중 오류가 발생했습니다");
		}
		
		return resJson.getResponseMessage();
	}
	
	@PostMapping("/01AL_20201203")
	@AdminLoginAspect
	public @ResponseBody JSON adm01AL_20201203(HttpServletRequest request, @RequestBody JSONObject paramJson) throws Exception {
		JSONResMessage resJson 		= new JSONResMessage(JSONResMessage.SUCCESS);
		JSONArray list 				= new JSONArray();
		
		try {
			
			Iterator<String> iterator 	= UsageVmAnalyze.VMMETRICMAP.getkeyIterator();
    		while (iterator.hasNext()) {
    			String key 			= iterator.next();
    			VmMetric metric 	= UsageVmAnalyze.VMMETRICMAP.get(key);
    			JSONArray subList 	= new JSONArray();
    			if (metric != null) {
    				int length 		= VmMeticBean.INFO_TYPE.length;
    				for (int i = 0; i < length; i++) {
    					JSONObject bean = new JSONObject();
        				bean.put("vmname", metric.getVmName());
        				bean.put("type", VmMeticBean.INFO_TYPE[i]);
        				bean.put("metric", metric.getByInfo(VmMeticBean.INFO_TYPE[i]));
        				subList.add(bean);
    				}
    			}
    			
    			list.add(subList);
    		}
    		resJson.put("metrics", list);
		} catch(Exception e) {
			LOGGER.error("adm_01AL", e);
			resJson 				= new JSONResMessage(JSONResMessage.FAIL, "요청작업 처리중 오류가 발생했습니다");
		}
		
		return resJson.getResponseMessage();
	}
	
}
