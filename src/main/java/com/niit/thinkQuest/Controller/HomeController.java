package com.niit.thinkQuest.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.thinkQuest.Service.IEventService;
import com.niit.thinkQuest.Service.IFriendService;
import com.niit.thinkQuest.Service.IUserService;
import com.niit.thinkQuest.model.User;

@Controller
public class HomeController {
	
	@Autowired
	IUserService iUserService;
	
	@Autowired
	IEventService iEventService;
	
	@Autowired
	IFriendService iFriendService;
	
	@RequestMapping(value = { "/","home" })
	public ModelAndView home() {
		System.out.println("home");
		return new ModelAndView("home");
	}
    		
	@RequestMapping(value = { "login" })
	public ModelAndView Login() {
		System.out.println("Login");
		return new ModelAndView("login","command",new User());
	}
		
	@RequestMapping(value = { "register" })
	public ModelAndView signup() {
		System.out.println("signup");
		return new ModelAndView("register","command",new User());
	}
			
	}