package com.vasutin.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vasutin.model.User;
import com.vasutin.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/index")
	public String setupForm(Map<String, Object> map){
		User user = new User();
		map.put("user", user);
		map.put("userList", userService.getAllUsers());
		return "user";
	}
	
	@RequestMapping(value="/user.do", method=RequestMethod.POST)
	public String doActions(@ModelAttribute User user, BindingResult result, @RequestParam String action, Map<String, Object> map){
		User userResult = new User();
		switch(action.toLowerCase()){	//only in Java7 you can put String in switch
		case "add":
			userService.add(user);
			userResult = user;
			break;
		case "edit":
			userService.edit(user);
            userResult = user;
			break;
		case "delete":
			userService.delete(user.getId());
			userResult = new User();
			break;
		case "search":
			User searchedUser = userService.getUser(user.getId());
			userResult = searchedUser!=null ? searchedUser : new User();
			break;
		}
		map.put("user", userResult);
		map.put("userList", userService.getAllUsers());
		return "user";
	}
	
	@RequestMapping(value="/list")
    public ModelAndView listOfUsers(@RequestParam(required = false) Integer page) {
        ModelAndView modelAndView = new ModelAndView("user");

        List<User> users = userService.getAllUsers();
        PagedListHolder<User> pagedListHolder = new PagedListHolder<>(users);
        pagedListHolder.setPageSize(5);
        modelAndView.addObject("maxPages", pagedListHolder.getPageCount());

        if(page==null || page < 1 || page > pagedListHolder.getPageCount())page=1;

        modelAndView.addObject("page", page);
        if(page == null || page < 1 || page > pagedListHolder.getPageCount()){
            pagedListHolder.setPage(0);
            modelAndView.addObject("users", pagedListHolder.getPageList());
        }
        else if(page <= pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(page-1);
            modelAndView.addObject("users", pagedListHolder.getPageList());
        }

        return modelAndView;
    }
    
	
	
}
