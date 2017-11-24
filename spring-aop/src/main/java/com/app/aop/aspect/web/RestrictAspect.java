package com.app.aop.aspect.web;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.app.aop.annotation.Restrict;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class RestrictAspect {
	@Before("@annotation(com.app.aop.annotation.Restrict) && execution(public * *(..))")
	public void restrict(final JoinPoint joinPoint) throws Throwable {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Restrict annotation = signature.getMethod().getAnnotation(Restrict.class);

		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
				.getRequest();

		if (annotation.admin() && !isAdmin(request)) {
			throw new Exception("Need admin access");
		}

		if (annotation.localOnly() && !request.getRemoteAddr().equals("127.0.0.1")
				&& !request.getRemoteAddr().equals("0:0:0:0:0:0:0:1")) {
			throw new Exception("Only possible from localhost");
		}
	}

	private static boolean isAdmin(final HttpServletRequest request) {
		String authorization = request.getHeader("Authorization");
		log.info("if admin then authorize the user");
		return authorization != null && authorization.replace("Bearer ", "").equalsIgnoreCase("admin");
	}
}