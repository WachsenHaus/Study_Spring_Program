package test.util;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Component //컴포넌트 스캔을 했을 때 bean이 될 수 있도록
public class WritingUtil {
	
	//메소드가 수행되기 바로 이전에 적용 될 수 있도록 설정하는 어노테이션
	
	public void write1() {
		System.out.println("편지를 써요");
	}
	
	public void write2() {
		System.out.println("보고서를 써요");
	}
	
	public void write3(String call) {
		System.out.println(call+"일기를 써요");
	}
}
