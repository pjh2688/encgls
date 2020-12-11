package com.enc.batch;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class VMManageExt extends KTAPICommon {
	public VMManageExt() {
		
	}
	
	/**
	 * std_cent 7.6 64bit en_2x2
	 * 
	 * @param templateName
	 * @throws Exception
	 */
	public KTAProtocol makeVmByTemplateCentOs76_2x2(String templateName, String hostName, boolean isDmz, String base64EncodedUserdata) throws Exception {
		return makeVmByTemplate(templateName, "4564364d-0bf7-415c-8779-b92f08c3e075", hostName, isDmz, base64EncodedUserdata);
	}
	
	/**
	 * std_cent 7.6 64bit en_2x4
	 * 
	 * @param templateName
	 * @throws Exception
	 */
	public KTAProtocol makeVmByTemplateCentOs76_2x4(String templateName, String hostName, boolean isDmz, String base64EncodedUserdata) throws Exception {
		return makeVmByTemplate(templateName, "919c59cf-fe26-497c-b37c-c5edf4cb53f9", hostName, isDmz, base64EncodedUserdata);
	}
	
	/**
	 * std_cent 7.6 64bit en_4x4
	 * 
	 * @param templateName 
	 * @throws Exception
	 */
	public KTAProtocol makeVmByTemplateCentOs76_4x4(String templateName, String hostName, boolean isDmz, String base64EncodedUserdata) throws Exception {
		return makeVmByTemplate(templateName, "919c59cf-fe26-497c-b37c-c5edf4cb53f9", hostName, isDmz, base64EncodedUserdata);
	}
	
	/**
	 * std_cent 7.6 64bit en_4x8
	 * 
	 * @param templateName 
	 * @throws Exception
	 */
	public KTAProtocol makeVmByTemplateCentOs76_4x8(String templateName, String hostName, boolean isDmz, String base64EncodedUserdata) throws Exception {
		return makeVmByTemplate(templateName, "919c59cf-fe26-497c-b37c-c5edf4cb53f9", hostName, isDmz, base64EncodedUserdata);
	}
	
	/**
	 * std_cent 7.6 64bit en_4x16
	 * 
	 * @param templateName
	 * @throws Exception
	 */
	public KTAProtocol makeVmByTemplateCentOs76_4x16(String templateName, String hostName, boolean isDmz, String base64EncodedUserdata) throws Exception {
		return makeVmByTemplate(templateName, "919c59cf-fe26-497c-b37c-c5edf4cb53f9", hostName, isDmz, base64EncodedUserdata);
	}
	
	/**
	 * std_cent 7.6 64bit en_8x8
	 * 
	 * @param templateName 
	 * @throws Exception
	 */
	public KTAProtocol makeVmByTemplateCentOs76_8x8(String templateName, String hostName, boolean isDmz, String base64EncodedUserdata) throws Exception {
		return makeVmByTemplate(templateName, "919c59cf-fe26-497c-b37c-c5edf4cb53f9", hostName, isDmz, base64EncodedUserdata);
	}
	
	/**
	 * std_cent 7.6 64bit en_8x36
	 * 
	 * @param templateName
	 * @throws Exception
	 */
	public KTAProtocol makeVmByTemplateCentOs76_8x32(String templateName, String hostName, boolean isDmz, String base64EncodedUserdata) throws Exception {
		return makeVmByTemplate(templateName, "919c59cf-fe26-497c-b37c-c5edf4cb53f9", hostName, isDmz, base64EncodedUserdata);
	}
	
	/**
	 * std_cent 7.6 64bit en_16x32
	 * 
	 * @param templateName
	 * @throws Exception
	 */
	public KTAProtocol makeVmByTemplateCentOs76_16x32(String templateName, String hostName, boolean isDmz, String base64EncodedUserdata) throws Exception {
		return makeVmByTemplate(templateName, "919c59cf-fe26-497c-b37c-c5edf4cb53f9", hostName, isDmz, base64EncodedUserdata);
	}
	
	
	/**
	 * 템블릿을 기반으로 VM 생성
	 * 
	 * ServiceOfferingId : VM 인스턴스에게 허용할 CPU 성능, 메모리 크기 등을 분류한 숫자 아이디
	 * DiskOfferingId : VM 인스턴스를 만들때 사용할 루트 볼륨의 디스크 오퍼링 아이디.
	 * 
	 * @param templateName
	 * @param isDmz
	 * @param hostName
	 * @param serviceofferingid
	 * @param base64EncodedUserdata
	 * @return
	 * @throws Exception
	 */
	public KTAProtocol makeVmByTemplate(String templateName, String serviceofferingid, String hostName, boolean isDmz, String base64EncodedUserdata) throws Exception {
		JSONObject templateJson 	= getJSONObjectByTemplateName(listVmTemplate(), templateName);
		
		if (templateJson == null) {
			throw new Exception("요청한 템플릿이 존재하지않음");
		} else {
			JSONObject networkIds 	= getNetworkIds();
			if (networkIds == null) {
				throw new Exception("네트워크 정보가 존재하지 않음");
			} else {
				String usageplantypeParam 	= "&usageplantype=hourly"; // 시간당:hourly(기본값), 월단위:monthly
				String networkZoneParam 	= "&networkids=" + ((isDmz)? networkIds.getString("dmz") : networkIds.getString("private"));
				String userdataParam 		= (base64EncodedUserdata == null || base64EncodedUserdata.trim().length() <= 0)? "" : "&userdata=" + base64EncodedUserdata;
				
				StringBuilder buffer 		= new StringBuilder();
				buffer.append("command=deployVirtualMachine");
				buffer.append("&serviceofferingid=" + serviceofferingid);
				buffer.append("&templateid=" + templateJson.getString("id"));
				buffer.append("&zoneid=" + templateJson.getString("zoneid"));
				buffer.append(networkZoneParam);
				buffer.append("&name=" + hostName);
				buffer.append("&displayname=" + hostName);
				buffer.append(usageplantypeParam);
				buffer.append(userdataParam);
				buffer.append("&response=json");
				
				String requestFullAddress 	= make(SERVER_URLADDR, buffer.toString());
				String deployJson 			= prettyPrinterForJson(getAPIInfo(requestFullAddress));
				
				return new KTAProtocol("deployVirtualMachine", buffer.toString(), requestFullAddress, deployJson);
			}
		}
	}
	
	/**
	 * VM을 생성요청후 jobid를 반환
	 * 
	 * @param jsonTxt
	 * @return
	 * @throws Exception
	 */
	public String getJobIdAfterDeployVirtualMachine(String jsonTxt) throws Exception {
		if (jsonTxt == null) {
			return null;
		} else {
			JSONObject resJson 			= JSONObject.parseObject(jsonTxt).getJSONObject("deployvirtualmachineresponse");
			
			return resJson.getString("jobid");
		}
	}
	
	/**
	 * VM 생성/정지 결과에 대한 Asynch 결과를 반환한다
	 * 
	 * @param jobid
	 * @return
	 * @throws Exception
	 */
	public KTAProtocol getVmQueryAsyncJobResult(String jobid) throws Exception {
		StringBuilder buffer 		= new StringBuilder();
		buffer.append("command=queryAsyncJobResult");
		buffer.append("&jobid=" + jobid);
		buffer.append("&response=json");
		
		String requestFullAddress 	= make(SERVER_URLADDR, buffer.toString());
		String deployJson 			= prettyPrinterForJson(getAPIInfo(requestFullAddress));
		
		return new KTAProtocol("queryAsyncJobResult", buffer.toString(), requestFullAddress, deployJson);
	}
	

	/**
	 * VM을 정지
	 * 
	 * @param vmId
	 * @return
	 * @throws Exception
	 */
	public KTAProtocol stopVm(String vmId) throws Exception {
		StringBuilder buffer 		= new StringBuilder();
		buffer.append("command=stopVirtualMachine");
		buffer.append("&id=" + vmId);
		buffer.append("&response=json");
		
		String requestFullAddress 	= make(SERVER_URLADDR, buffer.toString());
		String deployJson 			= prettyPrinterForJson(getAPIInfo(requestFullAddress));
		
		return new KTAProtocol("stopVirtualMachine", buffer.toString(), requestFullAddress, deployJson);
	}
	
	/**
	 * VM 시작
	 * 
	 * @param vmId
	 * @return
	 * @throws Exception
	 */
	public KTAProtocol startVm(String vmId) throws Exception {
		StringBuilder buffer 		= new StringBuilder();
		buffer.append("command=startVirtualMachine");
		buffer.append("&id=" + vmId);
		buffer.append("&response=json");
		
		String requestFullAddress 	= make(SERVER_URLADDR, buffer.toString());
		String deployJson 			= prettyPrinterForJson(getAPIInfo(requestFullAddress));
		
		return new KTAProtocol("startVirtualMachine", buffer.toString(), requestFullAddress, deployJson);
	}
	
	/**
	 * VM을 삭제
	 * 
	 * @param vmId
	 * @return
	 * @throws Exception
	 */
	public KTAProtocol removeVm(String vmId) throws Exception {
		StringBuilder buffer 		= new StringBuilder();
		buffer.append("command=destroyVirtualMachine");
		buffer.append("&id=" + vmId);
		buffer.append("&response=json");
		
		String requestFullAddress 	= make(SERVER_URLADDR, buffer.toString());
		String deployJson 			= prettyPrinterForJson(getAPIInfo(requestFullAddress));
		
		return new KTAProtocol("destroyVirtualMachine", buffer.toString(), requestFullAddress, deployJson);
	}

	
	/**
	 * 공인IP 생성요청후 jobid를 반환
	 * 
	 * @param jsonTxt
	 * @return
	 * @throws Exception
	 */
	public String getJobIdAfterPublicIP(String jsonTxt) throws Exception {
		if (jsonTxt == null) {
			return null;
		} else {
			JSONObject resJson 			= JSONObject.parseObject(jsonTxt).getJSONObject("associateipaddressresponse");
			
			return resJson.getString("jobid");
		}
	}
	
	/**
	 * 외부 아이피 생성
	 * ${API_URL}command=associateIpAddress&zoneid=8f6d3a05-e64d-4c42-b6fc-e4628499c352&apiKey=hmL3yALU4r&signature=UcL0H%2FSKjc7yeiEHw%2BlmJnWpOzY%3D
	 * 
		KTAProtocol [origianlPath=command=associateIpAddress&zoneid=d7d0177e-6cda-404a-a46f-a5b356d2874e&response=json, requestPath=https://api.ucloudbiz.olleh.com/server/v2/client/api?command=associateIpAddress&zoneid=d7d0177e-6cda-404a-a46f-a5b356d2874e&response=json&apiKey=CTl-GqCYBH1SPPnWwsJ4KcGecZEDME-GkKpJ-76NQ_-rvKfC_H7lZ0lBIuTSCfxQBhn7DSSsgtq9yBEmr-S7xA&signature=nm61ZXRA9f3PC0w21aGi4gpcMLI%3D, responseJson={
		  "associateipaddressresponse" : {
		    "jobid" : "8ae13acc-2b19-4dcb-82ca-16592fe882f4"
		  }
		}]

	 * jobid : 현재 보류중인 비동기 작업 ID
	 * 
	 * @return
	 * @throws Exception
	 */
	public KTAProtocol makeAssociateIp() throws Exception {
		StringBuilder buffer 		= new StringBuilder();
		buffer.append("command=associateIpAddress");
		buffer.append("&zoneid=d7d0177e-6cda-404a-a46f-a5b356d2874e");
		buffer.append("&response=json");
		
		String requestFullAddress 	= make(SERVER_URLADDR, buffer.toString());
		String deployJson 			= prettyPrinterForJson(getAPIInfo(requestFullAddress));
		
		return new KTAProtocol("associateIpAddress", buffer.toString(), requestFullAddress, deployJson);
	}
	
	/**
	 * 외부아이피 삭제
	 * 
	 * @return
	 * @throws Exception
	 */
	public KTAProtocol disassociateIpAddress() throws Exception {
		StringBuilder buffer 		= new StringBuilder();
		buffer.append("command=disassociateIpAddress");
		buffer.append("&zoneid=d7d0177e-6cda-404a-a46f-a5b356d2874e");
		buffer.append("&response=json");
		
		String requestFullAddress 	= make(SERVER_URLADDR, buffer.toString());
		String deployJson 			= prettyPrinterForJson(getAPIInfo(requestFullAddress));
		
		return new KTAProtocol("disassociateIpAddress", buffer.toString(), requestFullAddress, deployJson);
	}
	
	/**
	 * 로그밸런서 생성
	 * 
	 * Ex) {API_URL}command=createLoadBalancer &zoneid=8f6d3a05-e64e-4c42-b6fee4628499c352&name=lb1&loadbalanceroption=roundrobin& serviceip=14.63.252.225&serviceport=80&servicetype=http&helpchecktype=http&helpcheckurl=naver.com&apiKey=h6KXWcRAtdqfwF3xA&signature=bfyTUy4BdOcPk%3D
	 * 
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public KTAProtocol makeL4(String name) throws Exception {
		return makeL4(name, "sourceiphash", null, 80, "http", "http", "/");
	}
	
	/**
	 * 로그밸런서 생성
	 * 
	 * @param name
	 * @param serviceip
	 * @return
	 * @throws Exception
	 */
	public KTAProtocol makeL4(String name, String serviceip) throws Exception {
		return makeL4(name, "sourceiphash", serviceip, 80, "http", "http", "/");
	}
	
	/**
	 * 로그밸런서 생성
	 * 
	 * ${API_URL}command=createLoadBalancer&zoneid=8f6d3a05-e64e-4c42-b6fee4628499c352&name=lb1&loadbalanceroption=roundrobin& serviceip=14.63.252.225&serviceport=80&servicetype=http&helpchecktype=http&helpcheckurl=naver.com&apiKey=h6KXWcRAtdqfwF3xA&signature=bfyTUy4BdOcPk%3D 																																						
	 * 
	 * @param name
	 * @param loadbalanceroption roundrobin | leastconnection|leastresponse|sourceiphash | srcipsrcporthash
	 * @param serviceip
	 * @param serviceport
	 * @param servicetype
	 * @param helpchecktype
	 * @param helpcheckurl
	 * @return
	 * @throws Exception
	 */
	public KTAProtocol makeL4(String name, String loadbalanceroption, String serviceip, int serviceport, String servicetype, String healthchecktype, String healthcheckurl) throws Exception {
		StringBuilder buffer 		= new StringBuilder();
		buffer.append("command=createLoadBalancer");
		buffer.append("&zoneid=d7d0177e-6cda-404a-a46f-a5b356d2874e");
		buffer.append("&networkid=8cce3f82-35b7-470d-9845-32f1f745e55d");
		//buffer.append("&zoneid=KOR-Seoul M2");
		buffer.append("&name=" + name);
		buffer.append("&loadbalanceroption=" + loadbalanceroption);
		if (serviceip != null && serviceip.length() > 0) buffer.append("&serviceip=" + serviceip);
		if (serviceport > 0) buffer.append("&serviceport=" + serviceport);
		if (servicetype != null && servicetype.length() > 0) buffer.append("&servicetype=" + servicetype);
		if (healthchecktype != null && healthchecktype.length() > 0) buffer.append("&healthchecktype=" + healthchecktype);
		if (healthcheckurl != null && healthcheckurl.length() > 0) buffer.append("&healthcheckurl=" + healthcheckurl);
		buffer.append("&response=json");
		
		
		String requestFullAddress 	= make(LOADBALANCER, buffer.toString());
		String deployJson 			= prettyPrinterForJson(getAPIInfo(requestFullAddress));
		//System.out.println(deployJson);
		
		return new KTAProtocol("createLoadBalancer", buffer.toString(), requestFullAddress, deployJson);
	}
	
	/**
	 * 주어진 ip 에 대한 static nat 를 활성화
	 * 
	 * @param publicIpaddressid
	 * @param virtualmachineid
	 * @return
	 * @throws Exception
	 */
	public KTAProtocol enableL4StaticNat(String publicIpaddressid, String virtualmachineidOrL4machineId) throws Exception {
		StringBuilder buffer 		= new StringBuilder();
		buffer.append("command=enableStaticNat");
		buffer.append("&ipaddressid=" + publicIpaddressid);
		buffer.append("&virtualmachineid=" + virtualmachineidOrL4machineId);
		buffer.append("&response=json");
		
		
		String requestFullAddress 	= make(SERVER_URLADDR, buffer.toString());
		String deployJson 			= prettyPrinterForJson(getAPIInfo(requestFullAddress));
		
		return new KTAProtocol("enableStaticNat", buffer.toString(), requestFullAddress, deployJson);
	}
	
	/**
	 * 주어진 ip 에 대한 static nat 를 제거
	 * 
	 * @param publicIpaddressid
	 * @param virtualmachineid
	 * @return
	 * @throws Exception
	 */
	public KTAProtocol disableStaticNat(String publicIpaddressid) throws Exception {
		StringBuilder buffer 		= new StringBuilder();
		buffer.append("command=disableStaticNat");
		buffer.append("&ipaddressid=" + publicIpaddressid);
		buffer.append("&response=json");
		
		
		String requestFullAddress 	= make(LOADBALANCER, buffer.toString());
		String deployJson 			= prettyPrinterForJson(getAPIInfo(requestFullAddress));
		
		return new KTAProtocol("disableStaticNat", buffer.toString(), requestFullAddress, deployJson);
	}
	
	
	
	public KTAProtocol addL4WebServer(String loadbalancerid, String virtualmachineid, String vmPublicIpaddress) throws Exception {
		return addL4WebServer(loadbalancerid, virtualmachineid, vmPublicIpaddress, "80");
	}
	
	/**
	 * 로드밸런서에 웹서버 추가
	 * 
	 * @param loadbalancerid
	 * @param virtualmachineid
	 * @param vmPublicIpaddress
	 * @param vmPublicPort
	 * @return
	 * @throws Exception
	 */
	public KTAProtocol addL4WebServer(String loadbalancerid, String virtualmachineid, String vmPublicIpaddress, String vmPublicPort) throws Exception {
		StringBuilder buffer 		= new StringBuilder();
		buffer.append("command=addLoadBalancerWebServer");
		buffer.append("&loadbalancerid=" + loadbalancerid);
		buffer.append("&virtualmachineid=" + virtualmachineid);
		if (vmPublicIpaddress != null) {
			buffer.append("&ipaddress=" + vmPublicIpaddress);
		}
		buffer.append("&publicport=" + vmPublicPort);
		buffer.append("&response=json");
		
		
		String requestFullAddress 	= make(LOADBALANCER, buffer.toString());
		String deployJson 			= prettyPrinterForJson(getAPIInfo(requestFullAddress));
		
		return new KTAProtocol("addLoadBalancerWebServer", buffer.toString(), requestFullAddress, deployJson);
	}
	
	/**
	 * L4삭제
	 * 
	 * REQUEST
	 * ${API_URL}command=deleteLoadBalancer&loadbalancerid=100&apiKey=h6KXWcRAtdqfwF3xA&signature=bfyTUy4BdOcPk%3D
	 * 
	 * RESPONSE
	 * {"deleteLoadBalancerresponse":{ "success": true,"displaytext": "109 loadbalancer is deleted."}}	
	 * 
	 * @param name
	 * @return
	 */
	public KTAProtocol removeL4ByL4Id(String loadbalancerid) throws Exception {
		StringBuilder buffer 		= new StringBuilder();
		buffer.append("command=deleteLoadBalancer");
		buffer.append("&loadbalancerid=" + loadbalancerid);
		buffer.append("&response=json");
		
		
		String requestFullAddress 	= make(LOADBALANCER, buffer.toString());
		String deployJson 			= prettyPrinterForJson(getAPIInfo(requestFullAddress));
		//System.out.println(deployJson);
		
		return new KTAProtocol("deleteLoadBalancer", buffer.toString(), requestFullAddress, deployJson);
	}
	

	/**
	 * 로드밸런서 리스트 확인
	 * 
	 * REQUEST
	 * ${API_URL}command=listLoadBalancers& loadbalancerid =100&apiKey=h6KXWcRAtdqfwF3xA&signature=bfyTUy4BdOcPk%3D
	 * 
	 * RESPONSE
	 * 
	 * @throws Exception
	 */
	public KTAProtocol listL4(String name, String loadbalancerid, String serviceip, String memid) throws Exception {
		StringBuilder buffer 		= new StringBuilder();
		buffer.append("command=listLoadBalancers");
		buffer.append("&zoneid=d7d0177e-6cda-404a-a46f-a5b356d2874e");
		if (name != null && name.length() > 0) buffer.append("&name=" + name);
		if (loadbalancerid != null && loadbalancerid.length() > 0) buffer.append("&loadbalancerid=" + loadbalancerid);
		if (serviceip != null && serviceip.length() > 0) buffer.append("&serviceip=" + serviceip);
		if (memid != null && memid.length() > 0) buffer.append("&memid=" + memid);
		buffer.append("&response=json");
		
		String requestFullAddress 	= make(LOADBALANCER, buffer.toString());
		String deployJson 			= prettyPrinterForJson(getAPIInfo(requestFullAddress));
		
		return new KTAProtocol("listLoadBalancers", buffer.toString(), requestFullAddress, deployJson);
	}
	
	
	/**
	 * 템블릿 목록을 JSONObject 형태로 반환
	 * 
	 * @return
	 * @throws Exception
	 */
	public JSONObject listVmTemplate() throws Exception {
		String listTemplateJson 	= prettyPrinterForJson(getAPIInfo(make(SERVER_URLADDR, "command=listTemplates&templatefilter=selfexecutable&response=json"))); // self|selfexecutable : 차이점이 뭐지???
		return JSON.parseObject(listTemplateJson, JSONObject.class);
	}
	
	/**
	 * 서버에 구축된 모든 VM의 목록을 반환
	 * 
	 * {"memory":4096,"templatedisplaytext":"test-img-wms","securitygroup":[],"nic":[{"ipaddress":"172.16.0.67","broadcasturi":"vlan://2862","type":"Shared","isolationuri":"vlan://2862","netmask":"255.255.255.0","secondaryip":[],"networkname":"ent2_nipa_encgl_DMZ_tier1","networkid":"8cce3f82-35b7-470d-9845-32f1f745e55d","traffictype":"Guest","macaddress":"1e:00:27:03:16:42","id":"b27a1af9-6bde-4a18-9ea5-e70e38af139a","isdefault":true,"gateway":"172.16.0.1"}],"affinitygroup":[],"guestosid":"5c0e89a8-ff26-11e6-8781-1402ec8ff68c","userid":"d6de3af1-b990-463f-9193-dbbc91297530","domainid":"3a8ffbd4-ccd7-49e6-bbd6-2fba7a6c9cf8","passwordenabled":true,"hypervisor":"XenServer","serviceofferingname":"cpod 2core 4GB Instance. Virtual Networking","templatename":"test-img-wms","isdynamicallyscalable":false,"id":"1ab7f62e-1f8b-41bf-9444-8b0bf0c8e6d9","state":"Running","cpuspeed":2000,"created":"2020-11-13T16:08:34+0900","ostypeid":201,"rootdevicetype":"ROOT","templateid":"c74558cf-9a33-471c-9a6f-83d3038c27c0","zonename":"kr-md2-1","rootdeviceid":0,"tags":[],"serviceofferingid":"919c59cf-fe26-497c-b37c-c5edf4cb53f9","displayname":"corn-vm-testuser","domain":"ent2_nipa_encgl","haenable":true,"name":"corn-vm-testuser","zoneid":"d7d0177e-6cda-404a-a46f-a5b356d2874e","cpunumber":2,"account":"ent2_nipa_encgl_001","username":"ent2_nipa_encgl_001"}
	 * 
	 * @return
	 * @throws Exception
	 */
	public JSONArray getVmList() throws Exception {
		StringBuilder buffer 		= new StringBuilder();
		buffer.append("command=listVirtualMachines");
		buffer.append("&response=json");
		
		String requestFullAddress 	= make(SERVER_URLADDR, buffer.toString());
		String deployTxt 			= prettyPrinterForJson(getAPIInfo(requestFullAddress));
		if (deployTxt == null || deployTxt.length() <= 0) {
			return null;
		} else {
			JSONObject resJson 		= JSONObject.parseObject(deployTxt).getJSONObject("listvirtualmachinesresponse");
			if (resJson != null) {
				return resJson.getJSONArray("virtualmachine");
			} else return null;
		}
	}
	

	/**
	 * 요청한 공인IP에 파이어월 규칙을 적용
	 * 
	 * ${API_URL}command=createFirewallRule&ipaddressid=5d285295-ec19-4f37-8487-d27c7de83a0c
	 * &protocol=TCP&cidrlist=211.62.41.35%2F32&startport=9080&apiKey=hmL3yALU4r &signature=C35bT7gh44KpkGKH0CN0hezhwMo%3D
	 * 
	 * @param ipaddressid
	 * @param protocol
	 * @param cidrlist source cidrlist
	 * @return
	 */
	public KTAProtocol createFirewallRule(String ipaddressid, int port) throws Exception {
		StringBuilder buffer 		= new StringBuilder();
		buffer.append("command=createFirewallRule");
		buffer.append("&action=allow");
		// 출발지를 안적으면 external이다
		buffer.append("&dstnetworkid=8cce3f82-35b7-470d-9845-32f1f745e55d"); 	// dmz, 목적지
		//buffer.append("&dstnetworkid=8cce3f82-35b7-470d-9845-32f1f745e55d"); 	// external 출발지
		buffer.append("&protocol=TCP");
		
		buffer.append("&ipaddressid=" + ipaddressid);
		buffer.append("&protocol=TCP");
		buffer.append("&startport=" + port);
		buffer.append("&endport=" + port);
		buffer.append("&response=json");
		
		String requestFullAddress 	= make(SERVER_URLADDR, buffer.toString());
		String deployJson 			= prettyPrinterForJson(getAPIInfo(requestFullAddress));
		
		return new KTAProtocol("createFirewallRule", buffer.toString(), requestFullAddress, deployJson);
	}
	
	/**
	 * Firewall 규칙을 삭제
	 * 
	 * @return
	 */
	public KTAProtocol deleteFirewallRule(String firewallId) throws Exception {
		StringBuilder buffer 		= new StringBuilder();
		buffer.append("command=deleteFirewallRule");
		buffer.append("&id=" + firewallId);
		buffer.append("&response=json");
		
		String requestFullAddress 	= make(SERVER_URLADDR, buffer.toString());
		String deployJson 			= prettyPrinterForJson(getAPIInfo(requestFullAddress));
		
		return new KTAProtocol("deleteFirewallRule", buffer.toString(), requestFullAddress, deployJson);
	}
	
	/**
	 * 오토스케일링 VM 정보 생성
	 * 
	 * @param launchConfigurationName VM 자동 생성시 지정할 앞글자
	 * @param templateName
	 * @param serviceofferingid
	 * @param diskOfferingid
	 * @param base64EncodedUserdata
	 * @return
	 * @throws Exception
	 */
	public KTAProtocol autoScaleingCreateLaunchConfiguration(String launchConfigurationNamePrefix, String templateName, String serviceofferingid, String diskOfferingid, String base64EncodedUserdata) throws Exception {
		JSONObject templateJson 	= getJSONObjectByTemplateName(listVmTemplate(), templateName);
		
		if (templateJson == null) {
			throw new Exception("요청한 템플릿이 존재하지않음");
		} else {
			String userdataParam 		= (base64EncodedUserdata == null || base64EncodedUserdata.trim().length() <= 0)? "" : "&userdata=" + base64EncodedUserdata;
			
			StringBuilder buffer 		= new StringBuilder();
			buffer.append("command=createLaunchConfiguration");
			buffer.append("&launchconfigurationname=" + launchConfigurationNamePrefix);
			buffer.append("&serviceofferingid=" + serviceofferingid);
			buffer.append("&templateid=" + templateJson.getString("id"));
			if (diskOfferingid != null) {
				buffer.append("&diskOfferingid=" + diskOfferingid);
			}
			buffer.append(userdataParam);
			buffer.append("&response=json");
			
			String requestFullAddress 	= make(AUTOSCALING, buffer.toString());
			String deployJson 			= prettyPrinterForJson(getAPIInfo(requestFullAddress));
			
			return new KTAProtocol("createLaunchConfiguration", buffer.toString(), requestFullAddress, deployJson);
		}
	}
	
	/**
	 * 
	 * 
	 * @param groupName 오토스케일링 그룹이름
	 * @param launchConfigurationName 오토스케일림 VM 컨피그 이름
	 * @param maxsize VM최대갯수
	 * @param minsize VM최소갯수
	 * @param l4Id L4아이디
	 * @param l4IpId
	 * @return
	 * @throws Exception
	 */
	public KTAProtocol autoScalingCreateGroup(String groupName, String launchConfigurationName, int maxsize, int minsize, String l4Id, String l4IpAddrId) throws Exception {
		StringBuilder buffer 		= new StringBuilder();
		buffer.append("command=createAutoScalingGroup");
		buffer.append("&autoscalinggroupname=" + groupName);
		buffer.append("&availabilityzones.member.1=d7d0177e-6cda-404a-a46f-a5b356d2874e");
		buffer.append("&launchconfigurationname=" + launchConfigurationName);
		//buffer.append("&defaultCooldown=12");
		buffer.append("&maxsize=" + maxsize);
		buffer.append("&minsize=" + minsize);
		
		buffer.append("&loadbalancers.member.1.LoadBalancerId=" + l4Id);
		buffer.append("&loadbalancers.member.1.LoadBalancerType=MPX");
		buffer.append("&loadbalancers.member.1.IpAddressId=" + l4IpAddrId);
		buffer.append("&loadbalancers.member.1.PublicPortRangeFrom=80");
		buffer.append("&loadbalancers.member.1.PublicPortRangeTo=80");
		buffer.append("&loadbalancers.member.1.PrivatePort=80");
		
		buffer.append("&desiredCapacity=0");
		buffer.append("&response=json");
		
		String requestFullAddress 	= make(AUTOSCALING, buffer.toString());
		String deployJson 			= prettyPrinterForJson(getAPIInfo(requestFullAddress));
		
		return new KTAProtocol("createAutoScalingGroup", buffer.toString(), requestFullAddress, deployJson);
	}
	
	/**
	 * 오토스케일링 그룹의 설정을 변경
	 * 
	 * @param groupName
	 * @param launchConfigurationName
	 * @param maxsize
	 * @param minsize
	 * @param l4Id
	 * @param l4IpAddrId
	 * @return
	 * @throws Exception
	 */
	public KTAProtocol autoScalingUpdateGroup(String groupName, String launchConfigurationName, int maxsize, int minsize, String l4Id, String l4IpAddrId) throws Exception {
		StringBuilder buffer 		= new StringBuilder();
		buffer.append("command=updateAutoScalingGroup");
		buffer.append("&autoscalinggroupname=" + groupName);
		buffer.append("&availabilityzones.member.1=d7d0177e-6cda-404a-a46f-a5b356d2874e");
		buffer.append("&launchconfigurationname=" + launchConfigurationName);
		//buffer.append("&defaultCooldown=12");
		buffer.append("&maxsize=" + maxsize);
		buffer.append("&minsize=" + minsize);
		buffer.append("&desiredCapacity=0");
		buffer.append("&response=json");
		
		String requestFullAddress 	= make(AUTOSCALING, buffer.toString());
		String deployJson 			= prettyPrinterForJson(getAPIInfo(requestFullAddress));
		
		return new KTAProtocol("updateAutoScalingGroup", buffer.toString(), requestFullAddress, deployJson);
	}
	
	/**
	 * 새로운 스케일링 정책을 생성하거나, 기존 스케일링 정책을 수정
	 * ChangeInCapacity, ExactCapacity, PercentChangeInCapacity
	 * 
	 * @return
	 * @throws Exception
	 */
	public KTAProtocol autoScalingScalingPolicy(String autoScalingGroupName, String policyName, String launchConfigurationName, boolean isIncreament) throws Exception {
		StringBuilder buffer 		= new StringBuilder();
		buffer.append("command=putScalingPolicy");
		buffer.append("&autoscalinggroupname=" + autoScalingGroupName);
		buffer.append("&policyname=" + policyName);
		buffer.append("&adjustmenttype=" + launchConfigurationName);
		buffer.append("&scalingadjustment=" + (isIncreament? "1" : "-1"));
		buffer.append("&response=json");
		
		String requestFullAddress 	= make(AUTOSCALING, buffer.toString());
		String deployJson 			= prettyPrinterForJson(getAPIInfo(requestFullAddress));
		
		return new KTAProtocol("putScalingPolicy", buffer.toString(), requestFullAddress, deployJson);
	}
	
	/**
	 * 오토 스케일링 그룹을 삭제
	 * 
	 * updateAutoScalingGroup 을 통해 MinSize 와 MaxSize 를 0 으로 설정하면 모든 VM 인스턴스를 제거
	 * 
	 * @return
	 */
	public KTAProtocol deleteAutoScalingGroup(String autoScalingGroupName) throws Exception {
		StringBuilder buffer 		= new StringBuilder();
		buffer.append("command=deleteAutoScalingGroup");
		buffer.append("&autoscalinggroupname=" + autoScalingGroupName);
		buffer.append("&forcedelete=true");
		buffer.append("&response=json");
		
		String requestFullAddress 	= make(AUTOSCALING, buffer.toString());
		String deployJson 			= prettyPrinterForJson(getAPIInfo(requestFullAddress));
		
		return new KTAProtocol("deleteAutoScalingGroup", buffer.toString(), requestFullAddress, deployJson);
	}
	
	/**
	 * 오토스케일링을 위한 메트릭스를 수집
	 * 오토 스케일링 그룹의 구동 설정 중 InstanceMonitoring 값이 True 인 경우만 이 API 를 통해 메트릭 수집을 허용할 수 있다
	 * 
	 * @param autoScalingGroupName
	 * @return
	 * @throws Exception
	 */
	public KTAProtocol enableMetricsCollection(String autoScalingGroupName) throws Exception {
		StringBuilder buffer 		= new StringBuilder();
		buffer.append("command=enableMetricsCollection");
		buffer.append("&autoscalinggroupname=" + autoScalingGroupName);
		buffer.append("&granularity=1Minute");
		buffer.append("&metrics.member.1=GroupMinSize");
		buffer.append("&metrics.member.2=GroupMaxSize");
		buffer.append("&metrics.member.3=GroupDesiredCapacity");
		buffer.append("&metrics.member.4=GroupInServiceInstances");
		buffer.append("&metrics.member.5=GroupPendingInstances");
		buffer.append("&metrics.member.6=GroupTerminatingInstances");
		buffer.append("&metrics.member.7=GroupTotalInstances");
		buffer.append("&response=json");
		
		String requestFullAddress 	= make(AUTOSCALING, buffer.toString());
		String deployJson 			= prettyPrinterForJson(getAPIInfo(requestFullAddress));
		
		return new KTAProtocol("deleteAutoScalingGroup", buffer.toString(), requestFullAddress, deployJson);
	}
	
	/**
	 * 오토스케일링 정책을 삭제
	 * 
	 * @param autoScalingGroupName
	 * @param policyname
	 * @return
	 * @throws Exception
	 */
	public KTAProtocol deletePolicy(String autoScalingGroupName, String policyname) throws Exception {
		StringBuilder buffer 		= new StringBuilder();
		buffer.append("command=deletePolicy");
		buffer.append("&autoscalinggroupname=" + autoScalingGroupName);
		buffer.append("&policyname=" + policyname);
		buffer.append("&response=json");
		
		String requestFullAddress 	= make(AUTOSCALING, buffer.toString());
		String deployJson 			= prettyPrinterForJson(getAPIInfo(requestFullAddress));
		
		return new KTAProtocol("deletePolicy", buffer.toString(), requestFullAddress, deployJson);
	}
	
	
	public static void main(String[] args) {
		VMManageExt app 	= new VMManageExt();
		try {
//			JSONArray list 	= app.getVmList();
//			String deployJson 			= app.prettyPrinterForJson(list.toJSONString());
//			System.out.println(deployJson);
			
			
//			System.out.println("-----------------------정지");
//			KTAProtocol stopProtocol 	= app.stopVm("02f89ca2-26a2-4848-aa58-ffe901d00143");
//			//System.out.println(app.prettyPrinterForJson(stopProtocol.getResponseJson()));
//			System.out.println(stopProtocol.toString());
//			
			/*
			System.out.println("-----------------------시작");
			KTAProtocol startProtocol 	= app.startVm("02f89ca2-26a2-4848-aa58-ffe901d00143");
			System.out.println(app.prettyPrinterForJson(startProtocol.getResponseJson()));
			*/
			
			
//			System.out.println("-----------------------삭제");
//			KTAProtocol removeProtocol 	= app.removeVm("02f89ca2-26a2-4848-aa58-ffe901d00143");
//			//System.out.println(app.prettyPrinterForJson(removeProtocol.getResponseJson()));
//			System.out.println(removeProtocol.toString());
			
			//KTAProtocol checkProtocol 	= app.makeL4("l4-test-portal");
			KTAProtocol checkProtocol 		= app.autoScaleingCreateLaunchConfiguration("scaling-test", "db-light8-bo-ix", "919c59cf-fe26-497c-b37c-c5edf4cb53f9", null, null);
			
			
			//System.out.println("-----------------------체크");
			//KTAProtocol checkProtocol 	= app.getVmQueryAsyncJobResult("446c588a-75ff-42b6-adb3-89c400e528cd");
			System.out.println(app.prettyPrinterForJson(checkProtocol.getResponseJson()));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
