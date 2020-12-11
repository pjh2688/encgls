package com.enc.aop;

import java.io.PrintWriter;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.UrlPathHelper;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.enc.config.MemberSession;
import com.typhoon.framework.HttpServletResponseUtil;
import com.typhoon.framework.aop.RESPONSE_TYPE;
import com.typhoon.framework.json.JSONResMessage;
import com.typhoon.framework.json.JSONValidation;


@EnableAspectJAutoProxy
@Aspect
@Component
public class AspectImpl {
	@Around("@annotation(com.enc.aop.MemberLoginAspect)")
	public Object MemberLoginAspect(ProceedingJoinPoint joinPoint) throws Throwable {
		ServletRequestAttributes attributes 	= (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
		HttpServletRequest request 				= attributes.getRequest();
		HttpServletResponse response 			= attributes.getResponse();
		MethodSignature signature 				= (MethodSignature)joinPoint.getSignature();
		Method method 							= signature.getMethod();
		MemberLoginAspect validator 			= method.getAnnotation(MemberLoginAspect.class);
		RESPONSE_TYPE resType 					= validator.resType();
		String loginPage 						= validator.loginPage();
		
		boolean isLogon 						= MemberSession.isLogged(request);
		String path 							= (new UrlPathHelper()).getPathWithinApplication(request);
		System.out.println("PATH:" + path);
		// PATH 기반의 권한체크 추가 할 것
		
		if (isLogon) {
			return joinPoint.proceed();
		} else {
			return sendResponseMessage(response, resType, "로그인후 이용할 수 있습니다", request.getContextPath() + loginPage);
		}
	}
	
	@Around("@annotation(com.enc.aop.AdminLoginAspect)")
	public Object AdminLoginAspect(ProceedingJoinPoint joinPoint) throws Throwable {
		ServletRequestAttributes attributes 	= (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
		HttpServletRequest request 				= attributes.getRequest();
		HttpServletResponse response 			= attributes.getResponse();
		MethodSignature signature 				= (MethodSignature)joinPoint.getSignature();
		Method method 							= signature.getMethod();
		AdminLoginAspect validator 				= method.getAnnotation(AdminLoginAspect.class);
		RESPONSE_TYPE resType 					= validator.resType();
		String loginPage 						= validator.loginPage();
		
		boolean isLogon 						= MemberSession.isLogged(request);
		if (isLogon && MemberSession.isAdmin(request)) {
			return joinPoint.proceed();
		} else {
			return sendResponseMessage(response, resType, "로그인후 이용할 수 있습니다", request.getContextPath() + loginPage);
		}
	}
	
	@Around("@annotation(com.enc.aop.ValidationAspect)")
	public Object ValidationAspect(ProceedingJoinPoint joinPoint) throws Throwable {
		MethodSignature signature 				= (MethodSignature)joinPoint.getSignature();
		Method method 							= signature.getMethod();
		ValidationAspect validator 				= method.getAnnotation(ValidationAspect.class);
		RESPONSE_TYPE resType 					= validator.resType();
		String movePage 						= validator.movePage();
		
		ServletRequestAttributes attributes 	= (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
		HttpServletRequest request 				= attributes.getRequest();
		HttpServletResponse response 			= attributes.getResponse();
		JSONObject requestJson 					= null;
		Object[] requestParams 					= joinPoint.getArgs();
		if (requestParams != null && requestParams.length > 0) {
			//System.out.println("Object2: " + requestParams[1]);
			for (Object object : requestParams) {
				if (JSONObject.class.equals(object.getClass())) {
					requestJson = (JSONObject) object;
					//System.out.println("Json Object: " + requestJson);
					break;
				}
			}
		}
		
		if (requestJson != null) {
			String message 						= JSONValidation.validBlank(requestJson, validator.stringIds(), validator.stringTitles());
			if (message != null) {
				return sendResponseMessage(response, resType, message + " 작성하세요", request.getContextPath() + movePage);
			} else if (validator.numberIds() != null && (message= JSONValidation.validNumber(requestJson, validator.numberIds(), validator.numberTitles())) != null) {
				return sendResponseMessage(response, resType, message + " 숫자만 작성하세요", request.getContextPath() + movePage);
			} else if (validator.digitIds() != null && (message= JSONValidation.validDigitNumber(requestJson, validator.digitIds(), validator.digitTitles())) != null) {
				return sendResponseMessage(response, resType, message + " 숫자만 작성하세요", request.getContextPath() + movePage);
			}
		}
		
		return joinPoint.proceed();
	}
	
	@Around("@annotation(com.enc.aop.DataTablesPagingAspect)")
	public Object DataTablesPagingAspect(ProceedingJoinPoint joinPoint) throws Throwable {
		JSONObject requestJson 					= null;
		Object[] requestParams 					= joinPoint.getArgs();
		if (requestParams != null && requestParams.length > 0) {
			for (Object object : requestParams) {
				if (JSONObject.class.equals(object.getClass())) {
					requestJson = (JSONObject) object;
					break;
				}
			}
		}
		
		if (requestJson != null) {
			MethodSignature signature 			= (MethodSignature)joinPoint.getSignature();
			Method method 						= signature.getMethod();
			DataTablesPagingAspect dataTable 	= method.getAnnotation(DataTablesPagingAspect.class);
			
			String dbType 						= dataTable.dbtype();
			if ("mysql".equalsIgnoreCase(dbType)) {
				requestJson.put("iDisplayStart", requestJson.getIntValue("start"));
				requestJson.put("iDisplayEnd", requestJson.getIntValue("length"));
			} else { 	// oracle
				requestJson.put("iDisplayStart", requestJson.getIntValue("start"));
				requestJson.put("iDisplayEnd", requestJson.getIntValue("start") + requestJson.getIntValue("length"));
			}
			
			JSONArray orders 				= requestJson.getJSONArray("order");
			if (orders != null) { 			// 정렬 지원
				JSONObject orderInfo 		= orders.getJSONObject(0);
				int columnNumber 			= orderInfo.getIntValue("column");
				String sortValue 			= orderInfo.getString("dir");
				
				JSONArray columns 			=  requestJson.getJSONArray("columns");
				if (columns != null && columns.size() > columnNumber) {
					JSONObject columnInfo 	= columns.getJSONObject(columnNumber);
					String columnName 		= columnInfo.getString("name");
					
					requestJson.put("SORT", columnName + " " + sortValue);
					requestJson.put("SORT_COLUMN", columnName);
					requestJson.put("SORT_DIR", sortValue);
					requestJson.put("SORT_NUM", columnNumber);
					
					//System.out.println("[SORT:" + (columnName + " " + sortValue) + "], [SORT_COLUMN:" + columnName + "], [SORT_DIR:" + sortValue + "][SORT_NUM:" + columnNumber + "]");
				}
			}
		}
		
		return joinPoint.proceed();
	}
	
	
	private Object sendResponseMessage(HttpServletResponse response, RESPONSE_TYPE resType, String message, String movePage) throws Exception {
		if (resType == RESPONSE_TYPE.JSON) {
			JSONResMessage resJson 				= new JSONResMessage();
			resJson.setStatusAndMessage(JSONResMessage.FAIL, message);
			return resJson.getResponseMessage();
		} else if (resType == RESPONSE_TYPE.HTML) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out 		= response.getWriter();
			out.println(HttpServletResponseUtil.getAlertMessage(message));
			return null;
		} else if (resType == RESPONSE_TYPE.MOVE) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out 		= response.getWriter();
			out.println(HttpServletResponseUtil.getAlertMessageMove(null, movePage));
			return null;
		} else return null;
	}
}
