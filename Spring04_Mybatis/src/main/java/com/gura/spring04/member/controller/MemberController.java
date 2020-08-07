package com.gura.spring04.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring04.member.dao.MemberDao;
import com.gura.spring04.member.dto.MemberDto;

@Controller
public class MemberController {

	//의존개체를 주입 받는다.
	//bean 컨테이너에서 mebmerdao타입이 있으면 dao에 넣어달라는 의미이다. memberimpl이 bean 컨테이너에 들어가있음 어노테이션은 ? 뭘로 ? repository로
	@Autowired
	private MemberDao dao;
	
	
	@RequestMapping("/member/insertform")
	public String insertform() {
		return "member/insertform";
	}
	
	@RequestMapping("/member/insert")
	public String insert(@ModelAttribute MemberDto dto) {
		dao.insert(dto);
		return "redirect:/member/list.do";
	}
	
	@RequestMapping("/member/delete")
	public String delete(@RequestParam int num) {
		dao.delete(num);
		return "redirect:/member/list.do";
	}
	
	
	@RequestMapping(value = "/member/updateform",
			method = RequestMethod.GET)
	public ModelAndView update(@RequestParam int num, ModelAndView mView) {
		MemberDto dto = dao.getData(num);
		mView.addObject("dto",dto);
		mView.setViewName("member/updateform");
		return mView;
	}
	
	
	@RequestMapping(value = "/member/update", method=RequestMethod.POST)
	public String update(@ModelAttribute MemberDto dto) {
		dao.update(dto);
		return "member/update";
	}
	
	
	@RequestMapping("/member/list")
	public ModelAndView list(ModelAndView mView) {
		//데이터를 담아서, 뷰에게 뿌려준다.
		//회원목록을 얻어온다.
		List<MemberDto> list = dao.getList();
		//model을 담는다.
		mView.addObject("list",list);
		//view 페이지 정보를 담고
		mView.setViewName("member/list");
		return mView; 
	}
}
