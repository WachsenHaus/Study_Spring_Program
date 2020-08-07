package test.main2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.mypac.Weapon;

public class MainClass01 {
	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("test/main2/init.xml");
		
		//spring bean container에서 weapon type의 참조값 얻어오기
		//타입을 전달하는 방법이다.
		
		Weapon w = context.getBean(Weapon.class);
		useWeapon(w);
		
	}
	
	public static void useWeapon(Weapon w) {
		w.attack();
		w.attack();
		w.attack();
		w.attack();
		
	}
}	
