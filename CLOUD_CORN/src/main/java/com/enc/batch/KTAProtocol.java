package com.enc.batch; 

public class KTAProtocol {
	private String apiCommand;
	private String origianlPath;
	private String requestPath;
	private String responseJson;
	
	public KTAProtocol() {
		
	}
	
	public KTAProtocol(String apiCommand, String origianlPath, String requestPath, String responseJson) {
		this.apiCommand 		= apiCommand;
		this.origianlPath 		= origianlPath;
		this.requestPath 		= requestPath;
		this.responseJson 		= responseJson;
	}

	public String getApiCommand() {
		return apiCommand;
	}

	public String getOrigianlPath() {
		return origianlPath;
	}

	public String getRequestPath() {
		return requestPath;
	}

	public String getResponseJson() {
		return responseJson;
	}

	@Override
	public String toString() {
		return "KTAProtocol [origianlPath=" + origianlPath + ", requestPath=" + requestPath + ", responseJson=" + responseJson + "]";
	}
}
