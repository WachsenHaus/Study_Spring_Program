package test.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/*
 * Aspect: 공통관심사(횡단 관심사)
 * 핵심 비즈니스 로직과는 상관없는 공통관심사를 따로 작성한다.
 */

/*
 * 	-Aspectj Expression
 *  ..    모든지 와도 상관없다
 *  execution(java.lang.string *(..)
 *  *(..) 모든 메소드
 *  test.service.cafeservice.*(..)    서비스패키지의 카페서비스 클래스의 모든 메소드
 *  test.service.cafeservice.add*(..) 카페서비스클래스의 add로시작하는 모든 메소드
 *  *(*)인자 1개
 *  *(*,*)인자 2개
 *  write*() 전달인자가 반드시 업성야한다.
 *  
 *  (..) 있어도 되고 없어도 됨
 *  (*) 반드시 인자 1개
 *  (*,*) 반드시 2개
 *  (*,*,*) 반드시 3개 ...	
 *  
 * 	1. execution(* *(..)) => 접근 가능한 모든 메소드가 
 * 	   point cut
 * 	2. execution(* test.service.*.*(..)) 
 * 		=> test.service 패키지의 모든 메소드 point cut
 * 	3. execution(void insert*(..))
 * 		=>리턴 type 은 void 이고 메소드명이 
 * 		insert 로 시작하는 모든 메소드가 point cut
 * 	4. execution(* delete*(*))
 * 		=> 메소드 명이 delete 로 시작하고 인자로 1개 전달받는 
 *      메소드가 point cut (aop 가 적용되는 위치)
 * 	5. execution(* delete*(*,*))
 * 		=> 메소드 명이 delete 로 시작하고 인자로 2개 전달받는 
 *      메소드가 point cut (aop 가 적용되는 위치)
 *      
 *  6. execution ( String update*(Integer,*))
 *  => 메소드 명이 update로 시작하고 리턴타입은 string
 *  메소드의 첫번째 인자는 integer type, 두번째 인자는 아무 type 다되는 메소드가 point cut(aop가 적용되는 위치)
 */
@Aspect
@Component
public class WritingAspect {
	
	@Before("execution(void test.util.WritingUtil.write*())")
	public void prepare() {
		System.out.println("pen을 준비해요");
	}
	@After("execution(void test.util.WritingUtil.write*())")
	public void end() {
		System.out.println("다 사용한 pen을 마무리해요.");
	}
	
	
}
