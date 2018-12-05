package com.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.crud.model.service.UserService;

@Controller
public class FrontController 
{
	@Autowired
	private UserService userService;
	
    @GetMapping({"/", "/home"})
    public ModelAndView index()
    {
        ModelAndView mav = new ModelAndView();        
        mav.setViewName("home");
        mav.addObject("userList", userService.findAll());
        return mav;
    }
}
