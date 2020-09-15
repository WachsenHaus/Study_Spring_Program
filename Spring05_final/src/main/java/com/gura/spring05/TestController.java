package com.gura.spring05;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.gura.spring05.users.dao.UsersDao;
import com.gura.spring05.users.dto.UsersDto;

@Controller
public class TestController {

	@Autowired
	private UsersDao dao;
	
	@RequestMapping("/api/get_info")
	@ResponseBody
	public JSONPObject jsonp(@RequestParam(defaultValue="callback") String callback) {
		//클라이언트에게 응답할 데이터를 Map 에 담는다.
		Map<String, Object> map=new HashMap<>();
		map.put("num", 1);
		map.put("name", "김구라");
		//JSONPObject 객체를 생성해서 콜백 함수명과 응답할 데이터를 담고 
		JSONPObject jp=new JSONPObject(callback, map);
		//JSONPObject 를 리턴해준다. 
		return jp;
	}
	
	@RequestMapping("/api/signin")
	@ResponseBody
	public JSONPObject jsonp2(@RequestParam(defaultValue="callback") String callback,
			@RequestParam(defaultValue="") String id,
			@RequestParam(defaultValue="") String pwd
			) 
	{
		System.out.println(id);
		System.out.println(pwd);
		String inputId = id;
		String inputPwd = pwd;
		boolean isSuccess = false;
		boolean isValid=false; //초기값 false
		UsersDto resultDto=dao.getData(inputId);
		if(resultDto != null) {
			String encodedPwd=resultDto.getPwd();
			inputPwd=inputPwd;
			isValid=BCrypt.checkpw(inputPwd, encodedPwd);
		}
		if(isValid) { 
			isSuccess = true;
		}
		Map<String, Object> map=new HashMap<>();
		map.put("isSuccess", isSuccess);
		JSONPObject jp=new JSONPObject(callback, map);
		return jp;
	}
}
