package com.enc.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;
import com.typhoon.framework.session.SessionAb;

public class MemberSession extends SessionAb {

	/**
	 * 멤버 고유 아이디
	 * 
	 */
	private static final String SESSION_MEMBER_UUID 			= "SESSION_MEMBER_UUID";
	
	/**
	 * 멤버 아이디
	 * 
	 */
	private static final String SESSION_MEMBER_USERID 			= "MEMBER_USERID";
	
	/**
	 * 멤버 이름
	 * 
	 */
	private static final String SESSION_MEMBER_NAME 			= "MEMBER_NAME";
	
	/**
	 * 맴버 등급
	 * 
	 * A:관리자, U:일반유저
	 */
	private static final String SESSION_MEMBER_GRADE 			= "MEMBER_GRADE";
	public static final String MEMBER_GRADE_ADMIN 				= CODESET.MEMBER_GRADE_ADMIN;
	public static final String MEMBER_GRADE_USER 				= CODESET.MEMBER_GRADE_USER;
	
	
	/**
	 * 로그인 여부 반환
	 * 
	 * @param session
	 * @return
	 */
	public static boolean isLogged(HttpServletRequest request) {
    	return getMemberId(request) != null;
    }
	
	public static void setMemberId(HttpServletRequest request, String value) {
		HttpSession session 				= request.getSession();
		setMemberId(session, value);
	}
	
	public static void setMemberId(HttpSession session, String value) {
		session.setAttribute(SESSION_MEMBER_USERID, value);
	}
	
	public static String getMemberId(HttpServletRequest request) {
		HttpSession session 				= request.getSession();
		return getStringSessionValue(session, SESSION_MEMBER_USERID);
	}
	
	/**
	 * 회원 등급 반환
	 * 
	 * @param request
	 * @return
	 */
	public static String getMemberGrade(HttpServletRequest request) {
		HttpSession session 				= request.getSession();
		return getStringSessionValue(session, SESSION_MEMBER_GRADE);
	}
	
	/**
	 * 관리자인지 여부 반환
	 * 
	 * @param request
	 * @return
	 */
	public static boolean isAdmin(HttpServletRequest request) {
		String grade 						= getMemberGrade(request);
		return MEMBER_GRADE_ADMIN.equals(grade);
	}
	
	
	
	public static void setMemberInfo(HttpServletRequest request, String grade, long memberUid, String memberId, String memberName) {
		HttpSession session 				= request.getSession();
		session.setAttribute(SESSION_MEMBER_UUID, memberUid);
		session.setAttribute(SESSION_MEMBER_USERID, memberId);
		session.setAttribute(SESSION_MEMBER_NAME, memberName);
		session.setAttribute(SESSION_MEMBER_GRADE, grade);
	}
	
	public static void setMemberInfo(HttpServletRequest request, String grade, String memberId, String memberName) {
		HttpSession session 				= request.getSession();
		session.setAttribute(SESSION_MEMBER_USERID, memberId);
		session.setAttribute(SESSION_MEMBER_NAME, memberName);
		session.setAttribute(SESSION_MEMBER_GRADE, grade);
	}
	
	public static void setMemberName(HttpServletRequest request, String value) {
		HttpSession session 				= request.getSession();
		setMemberName(session, value);
	}
	
	public static void setMemberName(HttpSession session, String value) {
		session.setAttribute(SESSION_MEMBER_NAME, value);
	}

	/**
	 * 사용자 고유번호 반환
	 * 
	 * @param request
	 * @return
	 */
	public static long getMemberUuid(HttpServletRequest request) {
		return getLongSessionValue(request.getSession(), SESSION_MEMBER_UUID);
	}
	
	/**
	 * 사용자 이름 반환
	 * 
	 * @param request
	 * @return
	 */
	public static String getMemberName(HttpServletRequest request) {
		return getStringSessionValue(request.getSession(), SESSION_MEMBER_NAME);
	}
	
	/**
	 * 사용자 세션ID 반환
	 * 
	 * @param request
	 * @return
	 */
	public static String getSessionId(HttpServletRequest request) {
		HttpSession session 				= request.getSession();
		return (session == null)? null : session.getId();
	}
}