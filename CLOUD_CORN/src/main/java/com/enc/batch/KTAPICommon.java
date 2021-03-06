package com.enc.batch;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class KTAPICommon {
	private SimpleDateFormat KTAPI_DATE_FORMAT 		= new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'.000'");
	
	public static final String HMAC_SHA1_ALGORITHM 	= "HmacSHA1";
	public static final String SERVER_URLADDR 		= "https://api.ucloudbiz.olleh.com/server/v2/client/api?";
	public static final String LOADBALANCER 		= "https://api.ucloudbiz.olleh.com/loadbalancer/v2/client/api?";
	public static final String AUTOSCALING 			= "https://api.ucloudbiz.olleh.com/autoscaling/v2/client/api?";
	public static final String WATCH_URLADDR 		= "https://api.ucloudbiz.olleh.com/watch/v2/client/api?";
	public static final String SECRETKEY 			= "1zmUsFpw1oaqfuEK8qh2SRPUpxPw4CP7RJM-PxXXfXhCWvYnScgAfyg7Am-Obi47ZygNBdN28juHPIrJHSvsCA";
	public static final String APIKEY 				= "CTl-GqCYBH1SPPnWwsJ4KcGecZEDME-GkKpJ-76NQ_-rvKfC_H7lZ0lBIuTSCfxQBhn7DSSsgtq9yBEmr-S7xA";
	
	
	
	public KTAPICommon() {
		
	}
	
	/**
	 * KT클라우드로부터 받은 데이터에서 templateName과 동일한 템플릿의 정보를 반환
	 * 
	 * 
	 * 
	 * @param jsonObj
	 * @param templateName
	 * @return
	 * @throws Exception
	 */
	protected JSONObject getJSONObjectByTemplateName(JSONObject jsonObj, String templateName) throws Exception {
		JSONObject result 			= null;
		System.out.println(jsonObj.toJSONString());
		if (jsonObj.getJSONObject("listtemplatesresponse").getIntValue("count") > 0) {
			JSONArray list 			= jsonObj.getJSONObject("listtemplatesresponse").getJSONArray("template");
			int size 				= (list == null)? 0 : list.size();
			for (int i = 0; i < size; i++) {
				JSONObject row 		= list.getJSONObject(i);
				String tmpName 		= row.getString("name");
				if (tmpName != null && tmpName.equalsIgnoreCase(templateName)) {
					result 			= row;
					break;
				}
			}
		}
		
		return result;
	}
	
	/**
	 * JSON 스트링을 도깨비처럼 예쁘게 만들어준다
	 * 
	 * @param message
	 * @return
	 * @throws Exception
	 */
	protected String prettyPrinterForJson(String message) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		Object json 		= mapper.readValue(message, Object.class);

		String prettyMessage = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
		return prettyMessage;
	}
	
	/**
	 * 요청한 날짜를 더한 날짜 스트링을 반환한다
	 * 
	 * @param addDate
	 * @return
	 * @throws Exception
	 */
	protected String getCurrentTime(int field, int addDate) throws Exception {
		return getCurrentTime(KTAPI_DATE_FORMAT, field, addDate);
	}
	
	/**
	 * 요청한 날짜를 더한 날짜 스트링을 요청한 포멧팅하여 반환한다
	 * 
	 * @param formatter
	 * @param addDate
	 * @return
	 * @throws Exception 
	 */
	protected String getCurrentTime(SimpleDateFormat formatter, int field, int addDate) throws Exception {
		Calendar curCalendar 		= Calendar.getInstance(Locale.KOREA);
		curCalendar.add(field, addDate);
		
		return formatter.format(curCalendar.getTime());
	}
	
	public String toBase64String(byte[] bytes) {
		return Base64.getEncoder().encodeToString(bytes);
	}
	

	/**
	 * 요청한 주소로부터 API 결과값을 반환한다
	 * 
	 * @param address
	 * @return
	 * @throws Exception
	 */
	protected String getAPIInfo(String address) throws Exception {
		OkHttpClient client = new OkHttpClient();
		Response response 	= null;
		String message 		= null;
		
		try {
			Request request = new Request.Builder().url(address).build();
			response 		= client.newCall(request).execute();
			message 		= response.body().string();
		} catch(Exception e) {
			throw e;
		} finally {
			if (response != null) { try { response.close(); } catch(Exception e) { } }
		}
		
		return message;
	}
	
	/**
	 * VM 생성시 필요한 네트워크 정보를 반환
	 * 
	 * Enterprise security(or Finance User) user must be called with 'Networkids' parameter
	 * 
	 * 
	 *    {
	 *      "listnetworksresponse" : {
	 *        "network" : [ {
	 *          "id" : "c91ca272-b48a-4374-8a40-799845bfd333",
	 *          "name" : "ent2_nipa_encgl_Private_tier2",
	 *          "displaytext" : "ent2_nipa_encgl_Private_tier2",
	 *          "broadcastdomaintype" : "Vlan",
	 *          "traffictype" : "Guest",
	 *          "gateway" : "172.16.1.1",
	 *          "netmask" : "255.255.255.0",
	 *          "cidr" : "172.16.1.0/24",
	 *          "zoneid" : "d7d0177e-6cda-404a-a46f-a5b356d2874e",
	 *          "zonename" : "kr-md2-1",
	 *          "networkofferingid" : "2989c278-e9a0-4ccd-8036-aed01a7e533a",
	 *          "networkofferingname" : "networkoffering-cip-vrpod-2C512M",
	 *          "networkofferingdisplaytext" : "networkoffering-cip-vrpod-2C512M",
	 *          "networkofferingconservemode" : true,
	 *          "networkofferingavailability" : "Optional",
	 *          "issystem" : false,
	 *          "state" : "Setup",
	 *          "related" : "c91ca272-b48a-4374-8a40-799845bfd333",
	 *          "dns1" : "168.126.63.1",
	 *          "type" : "Shared",
	 *          "acltype" : "Domain",
	 *          "subdomainaccess" : true,
	 *          "domainid" : "3a8ffbd4-ccd7-49e6-bbd6-2fba7a6c9cf8",
	 *          "domain" : "ent2_nipa_encgl",
	 *          "service" : [ {
	 *            "name" : "UserData"
	 *          }, {
	 *            "name" : "Dhcp",
	 *            "capability" : [ {
	 *              "name" : "DhcpAccrossMultipleSubnets",
	 *              "value" : "true",
	 *              "canchooseservicecapability" : false
	 *            } ]
	 *          }, {
	 *            "name" : "Dns",
	 *            "capability" : [ {
	 *              "name" : "AllowDnsSuffixModification",
	 *              "value" : "true",
	 *              "canchooseservicecapability" : false
	 *            } ]
	 *          } ],
	 *          "networkdomain" : "cs1cloud.internal",
	 *          "physicalnetworkid" : "f86fd225-0d88-4849-8070-455918b1df67",
	 *          "restartrequired" : false,
	 *          "specifyipranges" : true,
	 *          "canusefordeploy" : true,
	 *          "ispersistent" : false,
	 *          "tags" : [ ],
	 *          "strechedl2subnet" : false
	 *        }, {
	 *          "id" : "8cce3f82-35b7-470d-9845-32f1f745e55d",
	 *          "name" : "ent2_nipa_encgl_DMZ_tier1",
	 *          "displaytext" : "ent2_nipa_encgl_DMZ_tier1",
	 *          "broadcastdomaintype" : "Vlan",
	 *          "traffictype" : "Guest",
	 *          "gateway" : "172.16.0.1",
	 *          "netmask" : "255.255.255.0",
	 *          "cidr" : "172.16.0.0/24",
	 *          "zoneid" : "d7d0177e-6cda-404a-a46f-a5b356d2874e",
	 *          "zonename" : "kr-md2-1",
	 *          "networkofferingid" : "2989c278-e9a0-4ccd-8036-aed01a7e533a",
	 *          "networkofferingname" : "networkoffering-cip-vrpod-2C512M",
	 *          "networkofferingdisplaytext" : "networkoffering-cip-vrpod-2C512M",
	 *          "networkofferingconservemode" : true,
	 *          "networkofferingavailability" : "Optional",
	 *          "issystem" : false,
	 *          "state" : "Setup",
	 *          "related" : "8cce3f82-35b7-470d-9845-32f1f745e55d",
	 *          "dns1" : "168.126.63.1",
	 *          "type" : "Shared",
	 *          "acltype" : "Domain",
	 *          "subdomainaccess" : true,
	 *          "domainid" : "3a8ffbd4-ccd7-49e6-bbd6-2fba7a6c9cf8",
	 *          "domain" : "ent2_nipa_encgl",
	 *          "service" : [ {
	 *            "name" : "UserData"
	 *          }, {
	 *            "name" : "Dhcp",
	 *            "capability" : [ {
	 *              "name" : "DhcpAccrossMultipleSubnets",
	 *              "value" : "true",
	 *              "canchooseservicecapability" : false
	 *            } ]
	 *          }, {
	 *            "name" : "Dns",
	 *            "capability" : [ {
	 *              "name" : "AllowDnsSuffixModification",
	 *              "value" : "true",
	 *              "canchooseservicecapability" : false
	 *            } ]
	 *          } ],
	 *          "networkdomain" : "cs1cloud.internal",
	 *          "physicalnetworkid" : "f86fd225-0d88-4849-8070-455918b1df67",
	 *          "restartrequired" : false,
	 *          "specifyipranges" : true,
	 *          "canusefordeploy" : true,
	 *          "ispersistent" : false,
	 *          "tags" : [ ],
	 *          "strechedl2subnet" : false
	 *        } ],
	 *        "count" : 2,
	 *        "externalnetworkid" : "80a1ce49-c1bf-4a42-ba26-54230b2955c6"
	 *      }
	 *    }
	 * 
	 * @return
	 * @throws Exception
	 */
	protected JSONObject getNetworkIds() throws Exception {
		JSONObject result 	= null;
		String jsonMessage 	= getAPIInfo(make(SERVER_URLADDR, "command=listNetworks&response=json"));
		JSONObject jsonObj 	= JSON.parseObject(jsonMessage, JSONObject.class);
		JSONArray jsonList 	= (jsonObj == null)? null : jsonObj.getJSONObject("listnetworksresponse").getJSONArray("network");
		int size 			= 0;
		if (jsonList != null && (size=jsonList.size()) > 0) {
			result 			= new JSONObject();
			for (int i = 0; i < size; i++) {
				JSONObject row 	= jsonList.getJSONObject(i);
				if (row.getString("name").toLowerCase().indexOf("dmz") != -1) {
					result.put("dmz", row.getString("id"));
				} else if (row.getString("name").toLowerCase().indexOf("private") != -1) {
					result.put("private", row.getString("id"));
				}
			}
		}
		
		return result;
	}
	
	protected String make(String url, String parameter) throws Exception {
		return url + makeParameter(parameter) + "&signature=" + makeSignature(parameter);
	}
	
	private String makeSignature(String parameter) throws Exception {
		List<String> cmdList 			= new ArrayList<String>();
		String[] list 		= parameter.split("&");
		int size 			= (list == null)? 0 : list.length;
		for (int i = 0; i < size; i++) {
			String[] param 	= list[i].split("=");
			int length 		= (param == null)? 0 : param.length;
			if (length == 2 && !param[1].isEmpty()) {
				String encodedTxt = URLEncoder.encode(param[1], "UTF-8");
				cmdList.add(URLEncoder.encode(param[0], "UTF-8").toLowerCase() + "=" + encodedTxt.toLowerCase());
			}
		}
		cmdList.add("apiKey=".toLowerCase() + URLEncoder.encode(APIKEY, "UTF-8").toLowerCase());
		
		Collections.sort(cmdList);
		
		StringBuilder resultAddress 	= new StringBuilder();
		int cnt 			= (cmdList == null)? 0 : cmdList.size();
		for (int i = 0; i < cnt; i++) {
			if (i > 0) {
				resultAddress.append("&");
			}
			resultAddress.append(cmdList.get(i));
		}
		
		return encryption(resultAddress.toString(), SECRETKEY);
	}
	
	
	private String makeParameter(String parameter) throws Exception {
		List<String> cmdList 			= new ArrayList<String>();
		String[] list 		= parameter.split("&");
		int size 			= (list == null)? 0 : list.length;
		for (int i = 0; i < size; i++) {
			String[] param 	= list[i].split("=");
			int length 		= (param == null)? 0 : param.length;
			if (length == 2 && !param[1].isEmpty()) {
				String encodedTxt = URLEncoder.encode(param[1], "UTF-8");
				cmdList.add(URLEncoder.encode(param[0], "UTF-8") + "=" + encodedTxt);
			}
		}
		cmdList.add("apiKey=" + URLEncoder.encode(APIKEY, "UTF-8"));
		
		StringBuilder resultAddress 	= new StringBuilder();
		int cnt 			= (cmdList == null)? 0 : cmdList.size();
		for (int i = 0; i < cnt; i++) {
			if (i > 0) {
				resultAddress.append("&");
			}
			resultAddress.append(cmdList.get(i));
		}
		
		return resultAddress.toString();
	}
	
	protected byte[] readFile(String absolutePath) throws Exception {
		return readFile(new File(absolutePath));
	}
	
	protected byte[] readFile(File file) throws Exception {
		if (file == null || !file.isFile()) return null;
		
		FileInputStream input 	= null;
		byte[] bytes 			= new byte[(int)file.length()];
		try {
			input 				= new FileInputStream(file);
			input.read(bytes);
		} catch(Exception e) {
			throw e;
		} finally {
			if (input != null) { try { input.close(); } catch(Exception e) { } }
		}
		
		return bytes;
	}
	
	/*
	public byte[] remove_r(byte[] bytes) throws Exception {
		ByteOutputStream stream 	= null;
		byte[] result 				= null;
		
		try {
			stream 					= new ByteOutputStream();
			int size 				= (bytes == null)? 0 : bytes.length;
			for (int i = 0; i < size; i++) {
				if (bytes[i] != '\r') {
					stream.write(bytes[i]);
				}
			}
		} catch(Exception e) {
			throw e;
		} finally {
			if (stream != null) {try { stream.close(); } catch(Exception e) { stream.close(); } }
		}
		
		result 					= stream.toByteArray();
		
		return result;
	}
	*/
	
	private String encryption(String data, String key) throws Exception {
		SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), HMAC_SHA1_ALGORITHM);
		Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
		mac.init(signingKey);
		
		return URLEncoder.encode(toBase64String(mac.doFinal(data.getBytes())), "UTF-8");
	}
	
	public byte[] remove_r(byte[] bytes) throws Exception {
		ByteArrayOutputStream stream = null;
		byte[] result 				= null;
		
		try {
			stream 					= new ByteArrayOutputStream();
			int size 				= (bytes == null)? 0 : bytes.length;
			for (int i = 0; i < size; i++) {
				if (bytes[i] != '\r') {
					stream.write(bytes[i]);
				}
			}
		} catch(Exception e) {
			throw e;
		} finally {
			if (stream != null) {try { stream.close(); } catch(Exception e) { stream.close(); } }
		}
		
		result 					= stream.toByteArray();
		
		return result;
	}
}
