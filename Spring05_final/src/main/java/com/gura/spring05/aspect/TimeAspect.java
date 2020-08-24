package com.gura.spring05.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Aspect
@Component
public class TimeAspect {
	
	
	@Around("execution(* com.gura.spring05.file.controller.*.*(..))")
	public Object checkTime(ProceedingJoinPoint joinPoint) throws Throwable
	{
		//로그를 출력할 객체의 참조값 얻어오기
		org.slf4j.Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
		logger.info("요청처리 시작!");
		long startTime = System.currentTimeMillis();
		Object obj=  joinPoint.proceed();
		long endTime = System.currentTimeMillis();
		long time = endTime - startTime;
		logger.info("time:" + time);;
		logger.info("요청처리 끝!");
		
		ModelAndView mView = null;
		if(obj instanceof ModelAndView) {
			mView=(ModelAndView)obj;
//			mView.setViewName("redirect:/home.do");
		}
		
		return mView;
	}
}
