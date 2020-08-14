package test.main4;

import java.util.Scanner;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class MainClass02 {
	
	public static void main(String[] args) {
		String pwd = "abcd1234";
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		//db에 저장된 비밀번호라고 가정하자.
		String savedPwd = encoder.encode(pwd);
		
		//로그인 폼에 입력한 비밀번호라고 가정한다.
		String inputPwd = new Scanner(System.in).nextLine();
		
		//boolean isEqual = inputPwd.equals(savedPwd); //불가능
		boolean isEqual =  BCrypt.checkpw(inputPwd, savedPwd);
		if(isEqual)
		{
			System.out.println("비밀번호가 일치해요!");
		}
		else
		{
			System.out.println("비밀번호가 틀려요!");
		}
	}
}
