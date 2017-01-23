package com.gura.spring.cafe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring.cafe.service.CafeService;

@Controller
public class CafeController {
	
	@Autowired
	private CafeService cafeService;
	
	@RequestMapping("/cafe/list")
	public ModelAndView list(){
		//글목록이 담겨있는 ModelAndView 객체를 리턴 받는다.
		ModelAndView mview=cafeService.getList();
		//뷰페이지의 정보를 설정하고 
		mview.setViewName("cafe/list");
		//리턴해준다.
		return mview;
	}
}
