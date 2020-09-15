package com.gura.spring05.file.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.spring05.file.dto.FileDto;

//
@Repository
public class FileDaoImpl implements FileDao {
	
	//의존성 주입. sqlsession을 찾아서 사용하겠다.
	@Autowired
	private SqlSession session;
	
	
	//파일 목록을 리턴하는 메소드
	public List<FileDto> getList(FileDto dto)
	{
		List<FileDto> list = session.selectList("file.getList",dto);
		return list;
	}
	@Override
	public int getCount(FileDto dto) {
		return session.selectOne("file.getCount",dto);
	}
	@Override
	public void insert(FileDto dto) {
		session.insert("file.insert",dto);
	}

	//인자로 전달되는 번호에 해당하는 파일 정보를 리턴하는 메소드
	@Override
	public FileDto getData(int num) {
		return session.selectOne("file.getData",num);
	}
	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub
		 session.selectOne("file.delete",num);
		
	}

}
