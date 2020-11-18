package com.ajax.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajax.dao.IUserMapper;
import com.ajax.dto.User;

@Service("UserService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	IUserMapper um;

	@Override
	public int join(User dto) {
		// TODO Auto-generated method stub
		return um.insertUser(dto);
	}

}
