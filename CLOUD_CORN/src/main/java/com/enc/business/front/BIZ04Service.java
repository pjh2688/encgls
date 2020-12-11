package com.enc.business.front;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enc.config.CODESET;
import com.enc.dto.CloudWmptLoc;
import com.enc.dto.User;
import com.enc.mapper.IServiceCloudMapper;

@Service
public class BIZ04Service {

	CODESET codeSet;
	
	@Autowired
	IServiceCloudMapper scm;
	
	public String statusInfo(String userid) {
		return scm.select_status(userid);
	}
	
	public List<CloudWmptLoc> cwlInfo() {
		return scm.select_cwl();
	}
	
	public int totalCnt() {
		return scm.total_cnt();
	}
	
	public User userInfo(String userid) {
		return scm.select_user(userid);
	}
	
	public int userUpdate(User user) {
		return scm.update_user(user);
	}
	
	public int isEmail(String input_email) {
		return scm.select_IsEmail(input_email);
	}
	
	public String userEmail(User user) {
		return scm.select_email(user);
	}
}
