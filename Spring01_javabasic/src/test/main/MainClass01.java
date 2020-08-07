package test.main;

import test.mypac.Weapon;
import test.mypac.WeaponImpl;

public class MainClass01 {
	public static void main(String[] args) {
		//Applictaion의 목적이 무언가를 공격하는게 목적이라면?
		//스프링을 사용하면 의존관계를  체계적으로 할 수 있다.
		
		//1. 목적을 달성하기 위해 필요한 핵심 의존 객체를 직접 생성해서.
		Weapon w = new WeaponImpl();
		//2. 메소드를 호출해서 목적을 달성한다.
		w.attack();
		
	}
}
