package com.gura.spring04.json.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JSONTestController {

		@RequestMapping("/json01")
		public String json01() {
			return "json01";
		}
		
		@RequestMapping(value = "/json02", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
		@ResponseBody //리턴하는 문자열을 클라이언트에게 출력하겠다는 의미
		public String json02() {
			return "{\"num\":1,\"name\":\"kimgura\"}";
		}
		
		
		/*
		 * 1. jackson-databind 라이브러리가 dependency에 명시가 되어 있고
		 * 2. servlet-context.xml에 <annotation-driven/>이 명시 되어 있고
		 * 3. 컨트롤러의 메소드에 @Responsebody 어노테이션이 붙어 있으면
		 * Map 개체에 담긴 내용이 json 문자열로 변한되어 응답된다.
		 */
		
		@RequestMapping("/json03")
		@ResponseBody
		public Map<String,Object> json03(){
			Map<String, Object> map = new HashMap<>();
			map.put("num", 1);
			map.put("name", "김구라");
			map.put("isMan",true);
			return map;
		}
		
		@RequestMapping("/json04")
		@ResponseBody
		public List<String> json04(){
			List<String> list = new ArrayList<>();
			list.add("김구라");
			list.add("해골");
			list.add("원숭이");
			return list;
		}
		
		@RequestMapping("/json05")
		@ResponseBody
		public Map<String,Object> json05(){
			Map<String,Object> map = new HashMap<>();
			map.put("email", "aaa@naver.com");
			
			List<String> hobby = new ArrayList<>();
			hobby.add("java");
			hobby.add("jsp");
			hobby.add("spring");
			map.put("hobby", hobby);
			return map;
		}
}
