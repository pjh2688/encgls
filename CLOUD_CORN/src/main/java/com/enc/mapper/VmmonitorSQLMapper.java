package com.enc.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Mapper
public interface VmmonitorSQLMapper {
	/**
	 * 데이터 추가
	 *
	 * @return
	 * @throws Exception
	 */
	public int insert(JSONObject json) throws Exception;
	
	/**
	 * 데이터 개수
	 *
	 * @return
	 * @throws Exception
	 */
	public int count(JSONObject json) throws Exception;
	
	/**
	 * 목록 반환
	 *
	 * @return
	 * @throws Exception
	 */
	public JSONArray select(JSONObject json) throws Exception;
	
	/**
	 * 다이나믹 목록 반환
	 *
	 * @return
	 * @throws Exception
	 */
	public JSONArray select_dynamic(JSONObject json) throws Exception;
	
	/**
	 * 하나의 ROW 반환
	 * 
	 * @param json
	 * @return
	 * @throws Exception
	 */
	public JSONObject select_row(JSONObject json) throws Exception;
	
	/**
	 * 수정
	 * 
	 * @param json
	 * @return
	 * @throws Exception
	 */
	public int update(JSONObject json) throws Exception;
	
	
	public int insertORupdate(JSONObject json) throws Exception;
	
	/**
	 * 데이터 삭제
	 *
	 * @return
	 * @throws Exception
	 */
	public int delete(JSONObject json) throws Exception;
}
