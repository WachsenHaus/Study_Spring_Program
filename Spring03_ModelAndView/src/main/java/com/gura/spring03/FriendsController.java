package com.gura.spring03;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FriendsController {
	
	@RequestMapping("/friends")
	public String friends(HttpServletRequest request) {
		//비즈니스 로직 수행 결과 모델
		List<String> list = new ArrayList<String>();
		list.add("김구라");
		list.add("해골");
		list.add("원숭이");
		request.setAttribute("friends", list);
		return "friends";
	}
	
	@RequestMapping("/friends2")
	public ModelAndView friends2() {
		List<String> list = new ArrayList<String>();
		list.add("김구라");
		list.add("해골");
		list.add("원숭이");
		
		//Model과 view
		ModelAndView mView = new ModelAndView();
		//request 영역에 담을 내용을 .addObject()메소드를 이용해서 담는다.
		mView.addObject("list",list);
		//view 페이지 정보를. setViewName()메소드를 이용해서 전달한다.
		mView.setViewName("friends");
		//model과 view페이지 정보를 모두 가지고 있는 ModelAndView 개체를 리턴한다.
		return mView;
	}
	@RequestMapping("/friends3")
	public ModelAndView friends3(ModelAndView mView) {
		List<String> list = new ArrayList<String>();
		list.add("김구라");
		list.add("해골");
		list.add("원숭이");
		//request 영역에 담을 내용을 .addObject()메소드를 이용해서 담는다.
		mView.addObject("list",list);
		//view 페이지 정보를. setViewName()메소드를 이용해서 전달한다.
		mView.setViewName("friends");
		//model과 view페이지 정보를 모두 가지고 있는 ModelAndView 개체를 리턴한다.
		return mView;
	}
	
}
