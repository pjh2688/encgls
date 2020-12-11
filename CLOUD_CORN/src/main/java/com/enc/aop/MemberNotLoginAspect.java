package com.enc.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.typhoon.framework.aop.RESPONSE_TYPE;

/**
 * 로그인 상태에서는 접근 금지
 * 
 * @author GOD
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MemberNotLoginAspect {
	RESPONSE_TYPE resType() default RESPONSE_TYPE.JSON;
	String movePage() default "/";
}
