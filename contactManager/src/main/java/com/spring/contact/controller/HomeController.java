package com.spring.contact.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.contact.dao.UserRepository;
import com.spring.contact.entities.User;
import com.spring.contact.helper.Message;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("title", "Home-contact manager");
		return "home";
	}

	@RequestMapping("/about")
	public String about(Model model) {
		model.addAttribute("title", "About-contact manager");
		return "about";
	}
	
	@RequestMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("title", "Register-contact manager");
		model.addAttribute("user", new User());
		return "signup";
	}
	
	// handler for registering user
	@RequestMapping(value="/do_register", method=RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result1, @RequestParam(value="agreement",
	defaultValue="false") boolean agreement, Model model, HttpSession session) {
		try {
			
			if(result1.hasErrors()) {
				System.out.println("Error" + result1.toString());
				model.addAttribute("user", user);
				return "signup";
			}
			if(!agreement) {
				System.out.println("you have not agreed terms and conditions");
				throw new Exception("you have not agreed terms and conditions");
			}
			
			user.setRole("ROLE_USER");
			user.setEnabled(true);
			user.setImageUrl("default.png");
			User result = this.userRepository.save(user);
			model.addAttribute("user", new User());
			session.setAttribute("message", new Message("Successfully Registered", "alert-success"));
    		model.addAttribute("user", user);
			return "signup";
		}
		catch(Exception e) {
			model.addAttribute("user", user);
			session.setAttribute("message", new Message("something went wrong!!"+e.getMessage(),"alert-danger"));
			e.printStackTrace();
			return "signup";
		}
	}
	
	@GetMapping("/signin")
	public String customLoginHandler(Model model) {
		model.addAttribute("login", "Logint page");
		return "login";
	}
}
