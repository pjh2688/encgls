package com.enc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.enc.dto.CloudWmptLoc;
import com.enc.dto.User;

@Mapper
public interface IServiceCloudMapper {
	public int total_cnt();
	
	public String select_status(String userid);
	
	public List<CloudWmptLoc> select_cwl();
	
	public User select_user(String userid);
	
	public int update_user(User user);
	
	public int select_IsEmail(String input_email);
	
	public String select_email(User user);
	
	
}
