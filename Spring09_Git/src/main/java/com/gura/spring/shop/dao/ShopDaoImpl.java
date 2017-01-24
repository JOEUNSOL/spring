package com.gura.spring.shop.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ShopDaoImpl implements ShopDao{
	@Autowired
	private SqlSession session;
	
	@Override
	public void deposit(String id, int money) {
		//아이디와 금액을 Map에 담는다.
		
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("id",id);
		param.put("money",money);
		session.insert("shop.deposit",param);
		
		
		
	}

	@Override
	public void widthDraw(String id, int money) {
		
		
	}

	@Override
	public void addPoint(String id, int point) {
	
			
	}

	@Override
	public void deliveryRequest() {
		
		
	}

	

}
