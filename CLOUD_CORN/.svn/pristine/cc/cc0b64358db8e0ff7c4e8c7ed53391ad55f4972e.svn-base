package com.enc.business.front;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

@Controller
public class MonitoringController {
	private static final Pattern PATTERN_PREFIX_HOST = Pattern.compile("(\\w+)-(\\w+)-(\\w+)-(\\d+)");
	
	@Autowired
	private MonitoringService monitoringService;
	
    /**
     * 모니터링
     * 성공하건말건 결과는 상관없음
     * 
     * {"disk_percent":"14","hostname":"enc-cloud-portal-1","disk_used":"5213396","memory_percent":"25","disk_totoal":"35796472","memory_used":"2059196","memory_total":"8003560","cpu_percent":"1.6"}
     * 
     * @return
     */
	@PostMapping("/monitor")
	public @ResponseBody JSON monitoring(HttpServletRequest request, @RequestBody JSONObject paramJson) throws Exception {
		JSONObject resultJson 	= new JSONObject();
		resultJson.put("result", "ok");
		
		Matcher matcher = PATTERN_PREFIX_HOST.matcher(paramJson.getString("hostname"));
		if (matcher.find()) {
			paramJson.put("tophostname", matcher.group(0));
		}
		
		try {
			this.monitoringService.monitoring(paramJson);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return resultJson;
	}
	
	private static void test() {
		
		Matcher matcher = PATTERN_PREFIX_HOST.matcher("user-db-userid-11-cd");
		if (matcher.find()) {
			System.out.println(matcher.group(0));
		} else {
			System.out.println("not match");
		}
	}
	
	public static void main(String[] args) {
		test();
	}
}
