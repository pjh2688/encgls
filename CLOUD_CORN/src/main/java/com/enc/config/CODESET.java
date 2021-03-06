package com.enc.config;

public class CODESET {
	/**
	 * 관리자 관련
	 * 
	 */
	public static final int ADMIN_MAX_LOGIN_FAIL_CNT 			= 3; 	// 관리자 최대 로그인 실패 허용 횟수
	public static final int ADMIN_EXPIRE_TERMS 					= 30; 	// 꽌리자 패스워드 만료 기간
	
	
	/**
	 * 문서타입
	 */
	public static final String DOC_TYPE_HTML 					= "H";
	public static final String DOC_TYPE_TEXT 					= "T";
	
	/**
	 * 맴버 등급
	 * 관리자와 일반유저 구분코드
	 * 
	 */
	public static final String MEMBER_GRADE_ADMIN 				= "A"; 	// 관리자
	public static final String MEMBER_GRADE_USER 				= "U"; 	// 일반사용자
	public final static String[] MEMBER_GRADE 					= {MEMBER_GRADE_ADMIN, MEMBER_GRADE_USER};
	
	/**
	 * 서비스 타입 종류
	 * 
	 */
	public final static String SERVICE_TYPE_LITE6 				= "L6"; 	// LIGHT 6
	public final static String SERVICE_TYPE_LITE8 				= "L8"; 	// LIGHT 8
	public final static String SERVICE_TYPE_LITE10 				= "L10"; 	// LIGHT 10
	public final static String SERVICE_TYPE_PREMIUM 			= "P"; 		// PREMIUM
	
	
	
	public static final String MEMBER_STATUSCD_NORMAL 			= "N"; 	// 정상
	public static final String MEMBER_STATUSCD_FIRED 			= "F"; 	// 탈퇴
	public static final String MEMBER_STATUSCD_PAUSE 			= "P"; 	// 일시정지
	public static final String MEMBER_STATUSCD_EXPIRED 			= "E"; 	// 사용기간 만료
	
	
	public static final String SERVICE_STATUS_APPLY 			= "A"; 	// 서비스 신청(서비스 신청 및 VM 자동 생성중)
	public static final String SERVICE_STATUS_ERROR          	= "E";  // 서비스 생성중 에러 발생
	public static final String SERVICE_STATUS_COMPLETE 			= "C"; 	// 서비스 신청 완료
	public static final String SERVICE_STATUS_DESTROY           = "D";  // 서비스 계약 종료, 완료일 업데이트할 것
	
	/* 사용자 서비스 신청에 따른 VM 추가 단계 */
	public static final String VMCBAT_STATUS_READY 				= "R"; 	// 실행대기
	public static final String VMCBAT_STATUS_WORKING			= "W"; 	// 실행중
	public static final String VMCBAT_STATUS_CHECK				= "C"; 	// ASYNC로 인한 검증 단계
	public static final String VMCBAT_STATUS_ERROR 				= "E"; 	// 에러발생
	public static final String VMCBAT_STATUS_COMPLETE 			= "F"; 	// 완료
	
	public static final int VMCBAT_STEP_MKDBVM 					= 10; 	// DBVM생성
	public static final int VMCBAT_STEP_MKVM 					= 11; 	// VM생성
	public static final int VMCBAT_STEP_MKL4 					= 12; 	// L4 신청
	public static final int VMCBAT_STEP_COMPLETE 				= 100; 	// 작업완료
	
	
	public static final String getVmBatStepMessage(int vmWorkStep) {
		String message 	= null;
		
		switch(vmWorkStep) {
			case VMCBAT_STEP_MKDBVM 	: message = "DBVM생성"; break;	
			case VMCBAT_STEP_MKVM 		: message = "VM생성"; break;
			case VMCBAT_STEP_MKL4 		: message = "L4신청"; break;
			case VMCBAT_STEP_COMPLETE 	: message = "작업완료"; break;
			default : message = "알수없는단계";
		}
		
		return message;
	}
}
