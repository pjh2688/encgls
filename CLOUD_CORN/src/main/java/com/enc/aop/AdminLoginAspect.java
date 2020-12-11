package com.enc.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.typhoon.framework.aop.RESPONSE_TYPE;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AdminLoginAspect {
	RESPONSE_TYPE resType() default RESPONSE_TYPE.JSON;
	String loginPage() default "/admin/login";
}
