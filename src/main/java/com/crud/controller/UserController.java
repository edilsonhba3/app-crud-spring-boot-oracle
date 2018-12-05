package com.crud.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.crud.model.entities.User;
import com.crud.model.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController 
{
	private UserService userService;
	
	public UserController(UserService userService)
	{
		this.userService = userService;
	}
	
	@GetMapping("/add")
    public ModelAndView add()
    {
        ModelAndView mav = new ModelAndView();        
        mav.setViewName("useradd");
        mav.addObject("newUser", new User());
        return mav;
    }
	
    @GetMapping("/findAll")
    @ResponseBody
    public List<User> findAll()
    {
        return userService.findAllOrder();
    }
    
    @PostMapping("/save")
    public String save(@ModelAttribute User newUser)
    {
    	User user = newUser;
    	user.setActive("1");
    	userService.saveUser(user);
        return "redirect:/";
    }
    
    @PostMapping("/update")
    @ResponseBody
    public User update(@RequestParam Integer id,
    		@RequestParam String email,
    		@RequestParam String firstname,
    		@RequestParam String lastname)
    {
    	User user = userService.findOne(id);
    	user.setEmail(email);
    	user.setName(firstname);
    	user.setLastName(lastname);
        return userService.saveUser(user);
    }
    
    @PostMapping("/findOne")
    @ResponseBody
    public User finOneById(@RequestParam Integer id)
    {
        return userService.findOne(id);
    }
    
    @PostMapping("/remove")
    @ResponseBody
    public Boolean remove(@RequestParam Integer id)
    {
    	Boolean result = Boolean.FALSE;
        try
        {
        	userService.remove(id);
        	result = Boolean.TRUE;	
        }
        catch(Exception e)
        {
        	result = Boolean.FALSE;	
        }
        return result;
    }
}
