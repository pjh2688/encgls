package com.ajax.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ajax.dto.TestDto;

@Mapper
public interface IUserMapper {

	List<TestDto> listUsers();
	void signUp(TestDto dto);
	int id_check(String userid);
	int ktIdCheck(String ktcloudid);
}
