package com.gura.spring05.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gura.spring05.cafe.dao.CafeDao;
import com.gura.spring05.cafe.dto.CafeDto;
import com.gura.spring05.exception.NotDeleteException;
import com.gura.spring05.file.dao.FileDao;
import com.gura.spring05.file.dto.FileDto;

import org.aspectj.lang.annotation.Aspect;

@Aspect
@Component
public class DeleteAspect {
	
	@Autowired
	private FileDao fileDao; //의존성을 주입바든ㄴ다.
	
	@Autowired
	private CafeDao cafeDao;
	
	
	@Around("execution(void com.gura.spring05.cafe.service.*.deleteContent(..))")
	public void checkCafeDelete(ProceedingJoinPoint joinPoint) throws Throwable {
		//메소드에 전달된 인자값을 저장
		int num =0;
		HttpServletRequest request = null; //변수를 선언한다.
		
		Object[] args = joinPoint.getArgs(); //모든 데이터를 일단 받아온다.
		for(Object tmp:args) {
			if(tmp instanceof Integer) { //전달된 인자중에서 정수(int) 찾기
				num=(int)tmp;
			}
			if(tmp instanceof HttpServletRequest) // HttpServletRequest 찾기
			{
				request = (HttpServletRequest)tmp;
			}
		}
		//삭제할 파일의 정보를 얻어온다.
		CafeDto cafeDto = cafeDao.getData(num);
		//세션에 저장된 아이디를 읽어온다(로그인된 아이디)
		String id = (String)request.getSession().getAttribute("id");
		if(!id.equals(cafeDto.getWriter())) {
			throw new NotDeleteException("남의글 지우기없기");
		}
		joinPoint.proceed(); 
		//메소드 정상 수행하기
	}
	
	
	
	@Around("execution(void com.gura.spring05.file.service.*.delete*(..))")
	public void checkFileDelete(ProceedingJoinPoint joinPoint) throws Throwable {
		//메소드에 전달된 인자값을 저장
		int num =0;
		HttpServletRequest request = null; //변수를 선언한다.
		
		
		Object[] args = joinPoint.getArgs(); //모든 데이터를 일단 받아온다.
		for(Object tmp:args) {
			if(tmp instanceof Integer) { //전달된 인자중에서 정수(int) 찾기
				num=(int)tmp;
			}
			if(tmp instanceof HttpServletRequest) // HttpServletRequest 찾기
			{
				request = (HttpServletRequest)tmp;
			}
		}
		//삭제할 파일의 정보를 얻어온다.
		FileDto fileDto = fileDao.getData(num);
		//세션에 저장된 아이디를 읽어온다(로그인된 아이디)
		String id = (String)request.getSession().getAttribute("id");
		if(!id.equals(fileDto.getWriter())) {
			throw new NotDeleteException("남의파일 지우기없기");
		}
		joinPoint.proceed(); 
		//메소드 정상 수행하기
		
	}
}
