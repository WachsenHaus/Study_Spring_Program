package com.gura.spring05.users.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.gura.spring05.users.dto.UsersDto;

public interface UsersService {
	public Map<String, Object> isExistId(String id);
	public boolean addUser(UsersDto dto);
	public void getInfo(HttpSession session, ModelAndView mView);
	public void loginProcess(UsersDto dto,ModelAndView mView,
			HttpSession session);
	
	public void deleteUsers(HttpSession session);
	
}
