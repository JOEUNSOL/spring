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
		// TODO Auto-generated method stub
		
	}

	@Override
	public ModelAndView getData(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(CafeDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub
		
	}

}
