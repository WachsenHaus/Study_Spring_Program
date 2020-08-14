package com.gura.spring05.users.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.spring05.users.dto.UsersDto;


@Repository
public class UsersDaoImpl implements UsersDao{
	
	@Autowired
	private SqlSession session;

	@Override
	public boolean isExist(String inputId) {
		//입력한 아이디가 존재하는지 id를 select 해 본다.
		String id = session.selectOne("users.isExist",inputId);
		if( id != null ) {
			return true;
		}
		return false;
	}

	@Override
	public boolean insert(UsersDto dto) {
		//성공적으로 가입이 완료되면 TRUE를 반환한다.
		boolean result = false;
		try {
			int row = session.insert("users.insert",dto);
			System.out.println("반환된 row는?");
			System.out.println(row);
			result = true;
		}
		catch (Exception e) {
			result = false;
			System.out.println("회원가입오류");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public UsersDto getData(String id) {
		UsersDto dto  = session.selectOne("users.getData",id);
		return dto;
	}

	@Override
	public void delete(String id) {
		session.delete("users.delete",id);
	}

	@Override
	public void update(UsersDto dto) {
		session.update("users.update", dto);
	}

	@Override
	public boolean updatePwd(UsersDto dto) {
		//update 문의 영향을 받은 row의 갯수가 리턴된다.
		int result = session.update("users.updatePwd",dto);
		if(result > 0) {
			return true;
		}else {
			return false;
		}
	}
}
