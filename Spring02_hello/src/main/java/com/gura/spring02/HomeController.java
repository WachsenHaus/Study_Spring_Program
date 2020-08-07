package com.gura.spring02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//컨트롤러를 만들때 사용하는 어노테이션 꼭필수임.
@Controller
public class HomeController {
	
	//해당 메소드가 어떤 요청을 처리할 지 결정하는 어노테이션
	//.nhn 생략가능.
	//메소드는 마음대로 만들어라
	@RequestMapping("/home")
	public String home() {
		
		//forward 이동될 jsp페이지의 위치를 리턴해준다.
		//"WEB-INF/views/" + x + ".jsp"
		return "home";
	}
	
}
