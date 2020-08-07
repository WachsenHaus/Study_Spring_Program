package com.gura.spring03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DeleteController {
	
	@RequestMapping("/delete")
	public String delete() {
		//가상의 삭제 비즈니스 로직 수행
		System.out.println("친구 정보를 삭제합니다.");
		//삭제후 친구 목록 보기로 리다이렉트
		return "redirect:/friends.do";
	}
	@RequestMapping("/delete2")
	public ModelAndView delete2(ModelAndView mView)
	{
		System.out.println("삭제!");
		mView.setViewName("redirect:friends.do");
		return mView;
	}
}
