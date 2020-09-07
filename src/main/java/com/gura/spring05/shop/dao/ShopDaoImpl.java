package com.gura.spring05.shop.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.spring05.shop.dto.ShopDto;

@Repository
public class ShopDaoImpl implements ShopDao{
    @Autowired
    private SqlSession session;
    
    @Override
    public List<ShopDto> getList() {
    	//상품 목록을 리턴해주는 메소드
    	List<ShopDto> list = session.selectList("shop.getList");
        return list;
    }

    @Override
    public void minusCount(int num) {
        //상품 재고를 감소 시키는 메소드
    	session.update("shop.minusCount",num);
    }

    @Override
    public void minusMoney(ShopDto dto) {
        //잔고 감소 시키는 메소드
    	//아이디를 어떻게 전달하지?서비스에서 받아온다 ? 
    	session.update("shop.minusMoney",dto);
    }

    @Override
    public void plusPoint(ShopDto dto) {
     //포인트를 더하는 메소드
    	session.update("shop.plusPoint",dto);
    }

    @Override
    public int getPrice(int num) {
    	//상품의 가격을 리턴해주는 메소드
    	int price = session.selectOne("shop.getPrice",num);
        return price;
    }

}