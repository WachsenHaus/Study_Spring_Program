package com.gura.spring05.cafe.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring05.cafe.dto.CafeCommentDto;
import com.gura.spring05.cafe.dto.CafeDto;
import com.gura.spring05.cafe.service.CafeService;

@Controller
public class CafeController {
	@Autowired
	private CafeService cafeService;
	//카페 글 목록 보기 요청 처리 
	@RequestMapping("/cafe/list")
	public ModelAndView getList(HttpServletRequest request, 
			ModelAndView mView) {
		cafeService.getList(request);
		mView.setViewName("cafe/list");
		return mView;
	}
	
	@RequestMapping("/cafe/detail")
	public ModelAndView detail(HttpServletRequest request,
			ModelAndView mView) {
		cafeService.getDetail(request);
		mView.setViewName("cafe/detail");
		return mView;
	}
	
	@RequestMapping("/cafe/private/insertform")
	public ModelAndView insertForm(ModelAndView mView) {
		
		mView.setViewName("cafe/insertform");
		return mView;
	}
	
	@RequestMapping(value = "/cafe/private/insert", method=RequestMethod.POST)
	public ModelAndView insert(CafeDto dto, ModelAndView mView, HttpSession session) {
		//dto 에 글 작성자 담기 
		String id=(String)session.getAttribute("id");
		dto.setWriter(id);
		cafeService.saveContent(dto);
		mView.setViewName("cafe/insert");
		return mView;
	}
	
	
	@RequestMapping("/cafe/private/delete")
	public String delete(@RequestParam int num, HttpServletRequest request) {
		cafeService.delete(num,request);
		return "redirect:/cafe/list.do";
	}
	
	
	@RequestMapping(value = "/cafe/private/comment_insert",method = RequestMethod.POST)
	public ModelAndView commentInsert(HttpServletRequest request, ModelAndView mView,@RequestParam int ref_group) {
		//새 댓글을 저장하고
		cafeService.saveComment(request);
		//보고있던 글 자세히 보기로 다시 리다이렉트 이동시킨다.
		mView.setViewName("redirect:/cafe/detail.do?num="+ref_group);
		return mView;
	}
	
    @RequestMapping("/cafe/private/comment_delete")
    public ModelAndView commentDelete(HttpServletRequest request,
            ModelAndView mView, @RequestParam int ref_group) {
        cafeService.deleteComment(request);
        mView.setViewName("redirect:/cafe/detail.do?num="+ref_group);
        return mView;
    }
    
    //댓글수정 ajax 요청에 대한 응답
    @RequestMapping(value = "/cafe/private/comment_update", 
    		method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> commentUpdate(CafeCommentDto dto){
    	Map<String, Object> map = new HashMap<>();
    	map.put("num", dto.getNum());
    	map.put("content", dto.getContent());
    	return map;
    }
}






