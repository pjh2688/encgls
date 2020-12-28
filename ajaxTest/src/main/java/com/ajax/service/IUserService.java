package com.ajax.service;

import java.util.List;

import com.ajax.dto.User;

public interface IUserService {
	public int join(User dto);
	public int userInfo(User dto);
	public List<User> findAll();
	public User findById(String userid);
}

/*
 	* service,dao(mapper)를 인터페이스와 클래스 파일 한 세트로 구현하는 이유 
 	 -> 확장성과 유연성이 좋아지기 때문이다. 이러한 방식은 하나의 소켓같은 개념이라 다른 서비스로 쉽게 교체할 수도 있고
 	        유지보수를 하기가 쉽다.
 */
