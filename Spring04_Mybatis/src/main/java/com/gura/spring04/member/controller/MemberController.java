package com.gura.spring04.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring04.member.dao.MemberDao;
import com.gura.spring04.member.dto.MemberDto;

@Controller
public class MemberController {

	
	
	@Autowired
	private MemberDao dao;
	
	
	//회원정보 추가 요청 처리
	@RequestMapping("/member/insert")
	public ModelAndView insert(MemberDto dto) {
		
		
		return null;
	}
}
