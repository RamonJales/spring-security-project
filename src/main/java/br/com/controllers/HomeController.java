package br.com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/index")
	public String login() {
		return "login";
	}
	
	@GetMapping("/private-page")
	public String privatePage() {
		return "private-page";
	}
}
