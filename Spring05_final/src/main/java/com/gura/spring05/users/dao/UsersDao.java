package com.gura.spring05.users.dao;

import com.gura.spring05.users.dto.UsersDto;

public interface UsersDao {
	public boolean isExist(String inputId);
	public boolean insert(UsersDto dto);
	public UsersDto getData(String id);
	public void delete(String id);
	public void update(UsersDto dto);
	public boolean updatePwd(UsersDto dto);
	
}