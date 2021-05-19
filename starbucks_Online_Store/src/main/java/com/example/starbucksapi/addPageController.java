package com.example.starbucksapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;


@Controller
public class addPageController{
	@GetMapping(value="/cardpage")
	public String getAction(){
		return "ActiveCardPage";
	}

}