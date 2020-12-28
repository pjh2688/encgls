package com.ajax.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajax.dao.IUserMapper;
import com.ajax.dto.User;

@Service("IUserService")
public class UserServiceImpl implements IUserService {
	
	@Autowired
	IUserMapper um;

	@Override
	public int join(User dto) {
		// TODO Auto-generated method stub
		return um.insert(dto);
	}

	@Override
	public int userInfo(User dto) {
		// TODO Auto-generated method stub
		return um.count(dto);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findById(String userid) {
		// TODO Auto-generated method stub
		return um.select_row(userid);
	}

}
