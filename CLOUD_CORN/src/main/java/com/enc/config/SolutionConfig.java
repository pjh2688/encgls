package com.enc.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.typhoon.framework.config.TyphoonSolutionConfig;

@ConfigurationProperties(prefix = "typhoon")
public class SolutionConfig implements TyphoonSolutionConfig {
	private String rootdir;
	private String uploaddir;
	private String mailSender;
	private String mailPasswd;
	private String mailHost;
	private String mailPort;
    
	public String getRootdir() {
		return rootdir;
	}

	public void setRootdir(String rootdir) {
		this.rootdir = rootdir;
	}

	public String getUploaddir() {
		return uploaddir;
	}

	public void setUploaddir(String uploaddir) {
		this.uploaddir = uploaddir;
	}

	public String getMailSender() {
		return mailSender;
	}

	public void setMailSender(String mailSender) {
		this.mailSender = mailSender;
	}

	public String getMailPasswd() {
		return mailPasswd;
	}

	public void setMailPasswd(String mailPasswd) {
		this.mailPasswd = mailPasswd;
	}

	public String getMailHost() {
		return mailHost;
	}

	public void setMailHost(String mailHost) {
		this.mailHost = mailHost;
	}

	public String getMailPort() {
		return mailPort;
	}

	public void setMailPort(String mailPort) {
		this.mailPort = mailPort;
	}
}
