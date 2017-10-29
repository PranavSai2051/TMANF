package com.pranav.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Greeting {
	@RequestMapping("/greet")
	public @ResponseBody String greet() {
		return "welcome";
		
	}
	
}
