package test.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MessengerAspect {
	
	//return type은 void이고 send로 시작하는 모든 메소드가 point cut이다..
	//포인트컷은 aop가 적용되는 그 위치를 말한다.
	@Around("execution(void send*(..))")
	public void checkGreeting(ProceedingJoinPoint joinPoint) 
		throws Throwable{
			//aop가 적용된 메소드 수행하기 이전에 해야할 작업
			
			
			joinPoint.proceed(); //aop가 적용된 메소드 수행하기
			
			//aop가 적용된 메소드 후행된 이후에 해야할 작업
		}
}
