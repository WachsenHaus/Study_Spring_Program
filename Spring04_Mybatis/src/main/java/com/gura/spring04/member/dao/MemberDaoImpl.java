package com.gura.spring04.member.dao;

import java.util.List;

import javax.websocket.Session;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.spring04.member.dto.MemberDto;

//dao를 bean으로 만들기 위한 어노테이션 (스프링 빈 커테이너에서 관리되게 하겠다.)
@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	private SqlSession session;
	
	@Override
	public void insert(MemberDto dto) {
		/*
		 * mapper namespace : member
		 * sql id : insert
		 * parameterType : memberdto
		 */
		session.insert("member.insert",dto);
	}

	@Override
	public void update(MemberDto dto) {
		session.update("member.update",dto);
	}

	@Override
	public void delete(int num) {
		/*
		 * mapper namespace: member
		 * sql id: delete
		 * parameterType : int or java.lang.Integer
		 */
		
		session.delete("member.delete",num);
	}

	@Override
	public MemberDto getData(int num) {
		/*
		 * mapper namespace : member
		 * sql id: getData
		 * parameterType : int
		 * resultType은 select된 row하나를 담을 데이터를 type을 의미한다.
		 * selectOne() 메소드는 resultType을 리턴해준다.
		 */
		//하나면 select원을하고.
		MemberDto dto = session.selectOne("member.getData",num);
		return dto;
	}

	@Override
	public List<MemberDto> getList() {
		/*
		 * resultType : MemberDto구나.
		 *  -reulstType은 select된 row하나를 담을 데이터를 type을 의미한다.
		 *  -selectList() 메소드는 List type을 리턴하고 List의 generic type이
		 *  resultType이 된다.
		 */
		//여러개면 selectlist를 하면된다.
		List<MemberDto> list =   session.selectList("member.getList");
		return list;
	}

}
