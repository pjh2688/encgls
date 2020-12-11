package com.enc.batch;

import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.enc.config.CODESET;
import com.enc.mapper.KtapiCommSQLMapper;
import com.enc.mapper.ServiceCloudSQLMapper;
import com.enc.mapper.ServiceContSQLMapper;
import com.enc.mapper.VmcBtcSQLMapper;
import com.google.common.collect.Lists;

/**
 * 
 * 초    |   분   |   시   |   일   |   월   |  요일  |   연도
 * 0~59 | 0~59 | 0~23 | 1~31 | 1~12  |   0~6  | 생략가능
 * 
 * 
 *요일 : 0 (일요일) ~ 6( 토요일)
 *
 *? : 설정 값 없을 때 - 일과 요일 에서만 사용가능
 *
 ** : 모든조건
 *
 *시작시간/단위 : 시작시간부터 해당 단위 때
 *
 *시작범위-끝범위 : 시작범위 부터 끝범위까지
 *
 *L : 마지막 - 일, 요일 에서만 사용가능
 *
 *W : 가장 가까운 평일 찾는다 - 일 에서만 사용가능
 *
 *ex) 10W
 *
 *-10일이 평일 일 때 : 10일에 실행
 *
 *-10일이 토요일 일 때 : 가장 가까운 평일인 금요일(9일)에 참
 *
 *-10일이 일요일 일 때 : 가장 가까운 평일인 월요일(11일)에 참
 *
 *# : 몇주 째인지 찾는다 - 요일 에서만 사용가능
 *
 *ex) 3#2 : 수요일#2째주 에 참
 * 
 * 
 * 
 * ********************************************
 * 예제
 * ********************************************
 * 
 * 1) 매월 10일 오전 1시 1분
 * 0  1  1  10  *  *
 * 
 * 2) 매일 오후 2시 5분 0초
 * 0  5  14  *  *  *
 * 
 * 3) 10분마다 도는 스케줄러 : 10분 0초, 20분 0초...
 * 0  0/10  *  *  *
 * 
 * 4) 조건에서만 실행되는 스케줄러 : 10분 0초, 11분 0초 ~ 15분 0초까지 실행
 * 
 * 0  10-15  *  *  *
 * 
 * 
 * 
 * cron = "* * * * * *"
 * 왼쪽부터 작은 단위 [초 분 시 일 월 요일 년(생략가능)]
 */

@Component
public class VMManageScheduler extends VMManageExt {
	private final org.slf4j.Logger LOGGER 			= org.slf4j.LoggerFactory.getLogger("TYPHOON_LOG");
	
	@Autowired
	private ServiceContSQLMapper serviceContSQLMapper;
	
	@Autowired
	private VmcBtcSQLMapper vmcBtcSQLMapper;
	
	@Autowired
	private KtapiCommSQLMapper ktapiCommSQLMapper;
	
	@Autowired
	private ServiceCloudSQLMapper serviceCloudSQLMapper;
	
	
	/**
	 * 멀티 스레드로 작업되는 업무를 하나의 리스트로 관리하여 중복 작업을 회피. 그러면서도 멀티 스레드가 진행될 수 있도록 구현 처리
	 * 
	 */
	private static final Map<Integer, JSONObject> dataRowMap 	= new HashMap<Integer, JSONObject>();
	
	/**
	 * 
	 */
	private static final Map<Integer, JSONObject> usingDataRowMap 	= new HashMap<Integer, JSONObject>();
	
	private int BAT_NEXT;
	
}
