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
	
	/* 생성 */
	public int insert(User dto);
	
	/* 조회 */
	public int select(User dto);
	
	/* 단건 조회 1 */
	public int select_row(User dto);
	
	/* 단건 조회 2 */
	public User select_row(String userid);
	
	/* 수정 */
	public int update(User dto);
	
	/* 삭제 */
	public int delete(User dto);
	
	/* 사용자 수 조회 */
	public int count(User dto);
	
	int id_check(String userid);
	int ktIdCheck(String ktcloudid);
	
}
