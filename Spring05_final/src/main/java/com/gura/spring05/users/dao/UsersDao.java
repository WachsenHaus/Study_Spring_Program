package com.gura.spring05.users.dao;

import com.gura.spring05.users.dto.UsersDto;

public interface UsersDao {
	public boolean isExist(String inputId);
	public boolean insert(UsersDto dto);
	public boolean isValid(UsersDto dto);
	
}
