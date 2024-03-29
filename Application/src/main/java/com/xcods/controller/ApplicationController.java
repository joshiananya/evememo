package com.xcods.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xcods.model.User;
import com.xcods.services.UserService;

@Controller
public class ApplicationController {

	@Autowired
	private UserService userService;
	@ResponseBody
	@RequestMapping("/home")
	public String Hello() {
		return "Hi I will complete ";
	}
	@RequestMapping("/welcome")
	public String Welcome(HttpServletRequest request)
	{
		request.setAttribute("mode","MODE_HOME");
		return "welcomepage";
	}

	@RequestMapping("/upload")
	public String upload(HttpServletRequest request)
	{
		request.setAttribute("logged","IN");
		request.setAttribute("mode","UPLOAD_FILES");
		
		return "welcomepage";
	}
	@RequestMapping("/register")
	public String registration(HttpServletRequest request)
	{
		request.setAttribute("mode","MODE_REGISTER");
		return "welcomepage";
	}
	@PostMapping("/save-user")
	public String registerUser(@ModelAttribute User user,BindingResult bindingResult,HttpServletRequest request)
	{
		userService.saveMyUser(user);
		request.setAttribute("mode","MODE_HOME");
		return "welcomepage";
	}
	@GetMapping("/show-users")
	public String showAllUsers(HttpServletRequest request)
	{
		request.setAttribute("users",userService.showAllUsers());
		request.setAttribute("mode","ALL_USERS");
		return "welcomepage";
	}
	@RequestMapping("/delete-user")
	public String deleteUser(@RequestParam int id,HttpServletRequest request)
	{
		userService.deleteMyUser(id);
		request.setAttribute("users",userService.showAllUsers());
		request.setAttribute("mode","ALL_USERS");
		return "welcomepage";
	}
	@RequestMapping("/edit-user")
	public String editUser(@RequestParam int id,HttpServletRequest request)
	{
//		request.setAttribute("user",userService.editMyUser(id));

		request.setAttribute("mode","MODE_UPDATE");
		return "welcomepage";
		
	}
	@RequestMapping("/login")
	public String login(HttpServletRequest request)
	{
		request.setAttribute("mode","MODE_LOGIN");
		return "welcomepage";
	}
	
	@RequestMapping("/login-user")
	public String loginUser(@ModelAttribute User user,HttpServletRequest request)
	{
		if(userService.findByUsernameAndPassword(user.getUsername(),user.getPassword())!=null)
				{
			request.setAttribute("logged","IN");
			
			if((user.getUsername()).equalsIgnoreCase("admin")&&user.getPassword().equalsIgnoreCase("admin"))
					{

				request.setAttribute("users",userService.showAllUsers());
				request.setAttribute("mode","ALL_USERS");
				return "welcomepage";
					}
			 		return "homepage";
				}
		else
		{
			request.setAttribute("error","invalid username or password");
			request.setAttribute("mode","MODE_LOGIN");
			return "welcomepage";
		}
	}
}
