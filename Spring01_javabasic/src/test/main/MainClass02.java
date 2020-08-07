package test.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.mypac.Weapon;
import test.mypac.WeaponImpl;

public class MainClass02 {
	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("test/main/init.xml");
		
		//관리 하고 있는 개체 중에서 id가 myweapon 인 개체의 참조값 얻어와서
		//인터페이스 type으로 casting 한다.
		Weapon w  = (Weapon)context.getBean("myWeapon");
		//필요한 기능 사용하기
		
		
		w.attack();
		w.attack();
		w.attack();
	}
}
