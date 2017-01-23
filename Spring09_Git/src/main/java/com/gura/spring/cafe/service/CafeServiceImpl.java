package com.gura.spring.cafe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring.cafe.dao.CafeDao;
import com.gura.spring.cafe.dto.CafeDto;

@Component
public class CafeServiceImpl implements CafeService{

	@Autowired
	private CafeDao cafeDao;
	
	@Override
	public ModelAndView getList() {
		List<CafeDto> list=cafeDao.getList();
		ModelAndView mview = new ModelAndView();
		mview.addObject("list", list);
		return mview;
	}

	@Override
	public void insert(CafeDto dto) {
		cafeDao.insert(dto);
		
	}

	@Override
	public ModelAndView getData(int num) {
		//1. 글정보를 얻어온다.
		CafeDto dto=cafeDao.getData(num);
		//2. 조회수를 올린다.
		cafeDao.increaseviewCount(num);
		//3. 글정보를 ModelAndView 객체에 담는다.
		ModelAndView mview =new ModelAndView();
		mview.addObject("dto" ,dto);
		return mview;
	}

	@Override
	public void update(CafeDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int num) {
		cafeDao.delete(num);
		
	}

}
