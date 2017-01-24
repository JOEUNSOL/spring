package com.gura.spring.shop.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ShopDaoImpl implements ShopDao{
	@Autowired
	private SqlSession session;
	
	@Override
	public void deposit(String id, int money) {
		
		
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
