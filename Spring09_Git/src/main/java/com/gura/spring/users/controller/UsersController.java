package com.gura.spring.users.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	// "/users/signin_form.do"
	@RequestMapping("/users/signin_form")
	public String signinForm(HttpSession session){
		//세션 초기화
		session.invalidate();
		return "users/signin_form";
	}
	@RequestMapping("/users/signin")
	public ModelAndView signin(@ModelAttribute UsersDto dto,@RequestParam String uri,HttpSession session){
		boolean isValid = usersService.isValid(dto);
		ModelAndView mview = new ModelAndView();
		if(isValid){// 아이디 비밀번호가 맞는 정보인 경우
			//로그인 처리를 해준다.
			session.setAttribute("id",dto.getId());
			mview.addObject("msg",dto.getId()+"님 로그인 되었습니다.");
			mview.addObject("redirectUri",uri);
		}else{
			//아이디 혹은 비밀번호가 틀리다는 정보를 응답한다.
			mview.addObject("msg","아이디 혹은 비밀번호가 틀리다");
			
			
		}
		mview.setViewName("users/alert");
		return mview;
	}
	@RequestMapping("/users/signout")
	public ModelAndView signout(HttpSession session){
		session.invalidate();
		ModelAndView mview=new ModelAndView();
		mview.addObject("msg","로그아웃 되었습니다.");
		mview.addObject("redirectUri",session.getServletContext().getContextPath());
		mview.setViewName("users/alert");
		return mview;
	}
	@RequestMapping("/users/private/info")
	public ModelAndView info(HttpSession session){
		//1. 세션에 저장된 id 정보를 읽어온다.
		String id =(String)session.getAttribute("id");
		//2. UsersDto 가 담긴 ModelAndView 객체를 리턴받는다.
		ModelAndView mview=usersService.getData(id);
		//3. foward 이동할 경로를 담고
		mview.setViewName("users/private/info");
		
		return mview;
	}
	@RequestMapping("/users/private/updateform")
	public ModelAndView updatform(HttpSession session){
		//1. 세션에 아이디 정보를 얻어온다.
		String id=(String)session.getAttribute("id");
		//2. 수정할 회원의 정보를 담고있는 ModelAndview 객체를 얻어온다.
		ModelAndView mview =usersService.getData(id);
		//3. foward 이동할 정보를 담아서
		mview.setViewName("users/private/updateform");
		return mview;
	}
	@RequestMapping("/users/private/update")
	public ModelAndView update(@ModelAttribute UsersDto dto,HttpServletRequest request){
		usersService.update(dto);
		ModelAndView mview =new ModelAndView();
		mview.addObject("msg" ,dto.getId()+"님 회원정보를 수정했습니다.");
		String path=request.getContextPath()+"/users/private/info.do";
		mview.addObject("redirectUri",path);
		mview.setViewName("users/alert");
		return mview;
	}
	@RequestMapping("/users/private/delete")
	public ModelAndView delete(HttpSession session,HttpServletRequest request){
		String id= (String)session.getAttribute("id");
		usersService.delete(id);
		session.invalidate();
		ModelAndView mview=new ModelAndView();
		mview.addObject("msg","회원님의 탈퇴처리가 완료되었습니다.");
		String path= request.getContextPath()+"/home.do";
		mview.addObject("redirectUri",path);
		mview.setViewName("users/alert");
		return mview;
	}
}




















