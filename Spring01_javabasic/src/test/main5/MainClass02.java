package test.main5;

import org.aspectj.bridge.Message;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.util.Messenger;

public class MainClass02 {
	int a = 2;
	int b = 4;
	static int c = 8;
	
	
	public class testc{
		public void print(String msg) {
			System.out.println(msg);
		}
		public void main() {
			System.out.println("aaaa");
		}
	}	
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("test/main5/init.xml");
		//spring bean 컨테이너로부터 messenger type의 참조값 얻어오기
		//System.out.println(a);
		MainClass02 mc2 = new MainClass02();
		System.out.println(mc2.a);
		System.out.println(c);
		Messenger m = context.getBean(Messenger.class);
		//bean의 메소드 사용해보기
		m.sendGreeting("good afternoon!");
		String msg = m.getMessage();
		//bean이 리턴한 데이터 확인해보기
		System.out.println("Messenger 개체가 리턴한 msg:" + msg);
	}
}
