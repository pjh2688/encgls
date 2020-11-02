package com.ajax.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ajax.dto.Member;

@Mapper
public interface IMemberMapper {

	List<Member> listMembers();
}
