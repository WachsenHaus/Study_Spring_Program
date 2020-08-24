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
        ApplicationContext context=
                new ClassPathXmlApplicationContext("test/main5/init.xml");
        // spring bean 컨테이너로 부터 Messenger type 의 참조값 얻어오기 
        Messenger m=context.getBean(Messenger.class);
        // bean 의 메소드 사용해보기 
        m.sendGreeting("good afternoon!");
        m.sendGreeting("좋은 아침!");
        m.sendGreeting("바보야 좋은 아침!");
        String msg=m.getMessage();
        // bean 이 리턴한 데이터 확인해 보기 
        System.out.println("Messenger 객체가 리턴한 msg:"+msg);
	}
}
