package com.gura.spring.cafe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring.cafe.dto.CafeDto;
import com.gura.spring.cafe.service.CafeService;

@Controller
public class CafeController {
	
	@Autowired
	private CafeService cafeService;
	
	//파라미터로 페이지 번호가 넘어올수도 있고 안넘어 올수도 있다.
	//만일 안넘어오면 default 값으로 1을 넣어준다.
	@RequestMapping("/cafe/list")
	public ModelAndView list(@RequestParam(defaultValue="1") int pageNum){
		
		
		
		//글목록이 담겨있는 ModelAndView 객체를 리턴 받는다.
		ModelAndView mview=cafeService.getList(pageNum);
		//뷰페이지의 정보를 설정하고 
		mview.setViewName("cafe/list");
		//리턴해준다.
		return mview;
	}
	
	@RequestMapping("/cafe/private/insertform")
	public String insertform(){
		
		
		return "cafe/private/insertform";
	}
	@RequestMapping("/cafe/private/insert")
	public String insert(@ModelAttribute CafeDto dto){
		cafeService.insert(dto);
		
		return "redirect:/cafe/list.do";
	}
	@RequestMapping("/cafe/detail")
	public ModelAndView detail(@RequestParam int num){
		ModelAndView mview= cafeService.getData(num);
		mview.setViewName("cafe/detail");
		
		
		return mview;
	}
	//글 삭제 요청 처리
	@RequestMapping("/cafe/private/delete")
	public String delete(@RequestParam int num){
		cafeService.delete(num);
		
		return "redirect:/cafe/list.do";
	}
	
	@RequestMapping("/cafe/private/updateform")
	public ModelAndView updateform(@RequestParam int num){
		ModelAndView mview = cafeService.updateForm(num);
		mview.setViewName("cafe/private/updateform");
		return mview;
	}
	@RequestMapping("/cafe/private/update")
	public String update(@ModelAttribute CafeDto dto){
		cafeService.update(dto);
		return "redirect:/cafe/list.do";
	}
}
