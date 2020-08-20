package test.tt;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.util.WritingUtil;

public class MainClass01 {
	public static void main(String[] args) {
		//init.xml 문서를 로딩해서 bean으로 관리할 개체를 관리한다.
		ApplicationContext context = new ClassPathXmlApplicationContext("test/tt/init.xml");
		
		//관리 되는 개채중에서 WritingUtil type 개체의 참조값을 얻어온다
		WritingUtil util = context.getBean(WritingUtil.class);
		//개체의 메소드 호출하기
		util.write1();
		util.write2();
		util.write3("tt");
	}
}
