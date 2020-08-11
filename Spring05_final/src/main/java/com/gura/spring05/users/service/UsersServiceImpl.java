package com.gura.spring05.users.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring05.users.dao.UsersDao;
import com.gura.spring05.users.dto.UsersDto;

@Service
public class UsersServiceImpl  implements UsersService{

		@Autowired
		private UsersDao dao;

		@Override
		public Map<String, Object> isExistId(String inputId) {
			//dao를 이용해서 아이디 존재 여부를 알아내서 변수에 할당한다. 
			boolean isExist = dao.isExist(inputId);
			//아이디가 존재하는지 여부를 Map에 담아서 리턴해 준다.
			Map<String,Object> map = new HashMap<>();
			map.put("isExit", isExist);
			return map;
		}

		@Override
		public boolean addUser(UsersDto dto) {
			return dao.insert(dto);
		}

		@Override
		public void loginProcess(UsersDto dto, ModelAndView mView, HttpSession session) {
			//dao 개체를 이용해서 id,pwd가 유효한 정보인지 여부를 얻어낸다.
			boolean isValid = dao.isValid(dto);
			if(isValid) { //만일 유효한 정보이면
				//로그인 처리를 한다.
				session.setAttribute("id", dto.getId());
				//view 페이지에서 사용할 정보
				mView.addObject("isSuccess",true);
			}else { //아니면 
				mView.addObject("isSuccess",false);
			}
		}
		
}
