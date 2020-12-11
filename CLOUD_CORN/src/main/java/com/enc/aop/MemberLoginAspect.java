package com.enc.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.typhoon.framework.aop.RESPONSE_TYPE;

/**
 * 로그인 여부를 체크
 * 
 * @author GOD
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MemberLoginAspect {
	RESPONSE_TYPE resType() default RESPONSE_TYPE.JSON;
	String loginPage() default "/biz/login";
}
