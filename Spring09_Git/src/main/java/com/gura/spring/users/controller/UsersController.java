package com.gura.spring.users.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring.users.dto.UsersDto;
import com.gura.spring.users.service.UsersService;

// component 스켄시 bean 이되고 또한 컨트롤러 역활을 할수 있도록
@Controller
public class UsersController {
	//의존 객체 주입 되도록 
	@Autowired
	private UsersService usersService;
	
	// ajax "/users/checkid.do" 요청 처리
	@RequestMapping("/users/checkid")
	@ResponseBody
	public Map<String, Object> checkid(@RequestParam String inputId){
		Map<String, Object> map=usersService.canUseId(inputId);
		// json 문자열 응답하기 
		return map;
	}
	
	@RequestMapping("/users/signup_form")
	public String signupForm(){
		
		return "users/signup_form";
	}
	@RequestMapping("/users/signup")
	public ModelAndView signin(HttpServletRequest request, @ModelAttribute UsersDto dto){
		//서비스를 이용해서 회원정보를 저장한다.
		usersService.insert(dto);
		
		ModelAndView mview =new ModelAndView();
		mview.addObject("msg",dto.getId()+"회원님 가입 되었습니다.");
		mview.addObject("redirectUri",request.getContextPath());
		mview.setViewName("users/alert");
		return mview;
	}
}




















