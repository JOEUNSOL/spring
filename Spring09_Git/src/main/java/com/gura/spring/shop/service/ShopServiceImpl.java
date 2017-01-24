package com.gura.spring.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gura.spring.shop.dao.ShopDao;

@Component
public class ShopServiceImpl implements ShopService{

	@Autowired
	private ShopDao shopDao;
	
	@Override
	public void deposit(String id, int money) {
		//가상의 입금 작업을 하는 메소드
		
	}

	@Override
	public void buy(String id, int price) {
		//가상의 구입을 작업을 하는 메소드
		
	}

}
