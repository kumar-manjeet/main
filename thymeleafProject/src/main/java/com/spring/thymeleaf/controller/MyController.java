package com.spring.thymeleaf.controller;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MyController {
	
	
	@RequestMapping(value="/about", method=RequestMethod.GET)
	public String about(Model model) {
		System.out.println("Inside about handler");
	    model.addAttribute("name", "manjeet yadav");
	    model.addAttribute("current_date", new Date());
	    System.out.println("done.....................");
		return "about";
	}
	
	//loop
	@GetMapping("/example-loop")
	public String iteratorHandler(Model model) {
		List<String> names = List.of("manjeet", "sfurti", "sapna");
		model.addAttribute("names", names);
		return "iterator";
	}
	
	// handler for conditional statements
	
	
	@GetMapping("/condition")
	public String conditionalHandler(Model model) {
		System.out.println("condition execute handler");
		model.addAttribute("isActive", true);
		model.addAttribute("gender", "male");
		List<Integer> list = List.of(12);
		model.addAttribute("mylist",list);
		return "condition";
	}
	
	@GetMapping("/newAbout")
	public String newAbout() {
		return "aboutNew";
	}
	
	// handler for including fragments
	
	@GetMapping("/service")
	public String servicesHandler(Model model) {
		model.addAttribute("title","Hii This is manjeet");
		model.addAttribute("subtitle", LocalDateTime.now().toString());
		return "service";
	}

}
