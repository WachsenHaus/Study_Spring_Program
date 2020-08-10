package com.gura.spring04.xml.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gura.spring04.Data;

@Controller
public class XMLTestController {

	@RequestMapping("/xml01")
	public String xml01() {
		return "xml01";
	}
	
	
	@RequestMapping("/xml02")
	@ResponseBody
	public Data xml02() {
		//xml과 관련된 어노테이션으로 설계된 클래스로 개체를 생성하고  
		Data d= new Data();
		//data를 담고
		d.setNum(1);
		d.setName("김구라");
		//리턴해주면 xml문서가 응답된다.
		return d;
	}
	
}
