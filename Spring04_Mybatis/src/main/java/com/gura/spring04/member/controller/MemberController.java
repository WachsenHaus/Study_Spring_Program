package com.gura.spring04.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring04.member.dao.MemberDao;
import com.gura.spring04.member.dto.MemberDto;

@Controller
public class MemberController {

	//의존개체를 주입 받는다.
	//빈 컨테이너에서 mebmerdao타입이 있으면 dao에 넣어달라는 의미이다.
	@Autowired
	private MemberDao dao;
	
	
	@RequestMapping("/member/list")
	public ModelAndView list(ModelAndView mView) {
		//회원목록을 얻어온다.
		List<MemberDto> list = dao.getList();
		//model을 담는다.
		mView.addObject("list",list);
		//view 페이지 정보를 담고
		mView.setViewName("member/list");
		return mView; 
	}
}
