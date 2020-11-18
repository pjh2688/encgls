package com.ajax.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ajax.dto.TestDto;
import com.ajax.dto.User;

@Mapper  // Repository랑 같은 개념
public interface IUserMapper {

	// test 용
	List<TestDto> listUsers();
	void signUp(TestDto dto);
	// test 용
	

	public int insertUser(User dto);
	
	public int selectUser(User dto);
	
	int id_check(String userid);
	int ktIdCheck(String ktcloudid);
	
}
