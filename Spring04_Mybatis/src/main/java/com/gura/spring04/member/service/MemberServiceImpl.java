package com.gura.spring04.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring04.member.dao.MemberDao;
import com.gura.spring04.member.dto.MemberDto;


//bean이 
@Service
public class MemberServiceImpl implements MemberService{

	
	//의존 개체 주입받기
	@Autowired
	private MemberDao dao;
	
	
	
	//회원정보를 추가하는 비즈니스 로직
	@Override
	public void addMemeber(MemberDto dto) {
		dao.insert(dto);
	}

	//회원정보를 수정하는 비즈니스 로직
	@Override
	public void updateMember(MemberDto dto) {
		dao.update(dto);
	}

	//회원정보를 삭제하는 비즈니스 로직
	@Override
	public void deleteMember(int num) {
		dao.delete(num);
	}

	//회원 한명의 정보를 불러와서 ModelAndView 개체에 담아주는 비즈니스 로직 처리
	@Override
	public void getMember(int num, ModelAndView mView) {
		MemberDto dto = dao.getData(num);
		mView.addObject("dto",dto);
	}
	//회원 목록을 불러와서 ModelAndView 개체 담아주는 비즈니스 로직 처리
	@Override
	public void getListMember(ModelAndView mView) {
		List<MemberDto> list = dao.getList();
		mView.addObject("list",list);
	}
}
