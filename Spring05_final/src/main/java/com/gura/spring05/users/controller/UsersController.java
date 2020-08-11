package com.gura.spring05.users.controller;

import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring05.users.dto.UsersDto;

import com.gura.spring05.users.service.UsersService;

@Controller
public class UsersController {
	@Autowired
	private UsersService service;
	
	
	@RequestMapping("/users/signup_form")
	public String signupForm() {
		//web-inf/views/users/signp_form.jsp 페이지로 forward 이동해서 응답
		return "users/signup_form";
	}
	
	@RequestMapping("/users/checkid")
	@ResponseBody
	public Map<String, Object> checkid(@RequestParam String inputId){
		//service가 리턴해주는 Map 개체를 리턴한다.
		return service.isExistId(inputId);
	}
	
	
	//회원 가입 요청 처리
	@RequestMapping("/users/signup")
	public ModelAndView signup(UsersDto dto, ModelAndView mView) {
		boolean result = service.addUser(dto); 
		if(result)
		{
			mView.setViewName("users/signup");
			return mView;
		}
		mView.setViewName("users/error");
		return mView;
	}
	
	@RequestMapping("/users/loginform")
	public String loginform(HttpServletRequest request){
		//로그인후 가야하는 정보.
		//이 url은. 예를들어 다른페이지에서 로그인하기를 눌렀을경우. url을 기억하고있는것이다.
		String url = request.getParameter("url");
		System.out.println("url은 ? " + url);
		if(url==null) { //메인페이지, 즉 홈페이지에서 로그인하기를 누르면 null이기 때문에 기본설정인 /home.do를 한것이다.
			String cPath = request.getContextPath();
			url = cPath + "/home.do";
		}
		//request의 url 키에 url값을 할당한다. 이는 loginform에서 EL태그로 쓰게 될 것이다
		request.setAttribute("url", url);
		System.out.println("url은 ? " + url);
		String springVersion = org.springframework.core.SpringVersion.getVersion();

		System.out.println("스프링 프레임워크 버전 : " + springVersion);
		return "users/loginform";
	}
	
	@RequestMapping("/users/login")
	public ModelAndView login(UsersDto dto, ModelAndView mView,HttpSession session, HttpServletRequest request) {
		String url = request.getParameter("url");
		String encodedUrl = URLEncoder.encode(url);
		mView.addObject("url",url);
		mView.addObject("encodedUrl",encodedUrl);
				
		service.loginProcess(dto, mView, session);
		mView.setViewName("users/login");
		return mView;
	}
	
	@RequestMapping("/users/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/home.do";
	}
	
}
