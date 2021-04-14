package com.example.demo.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	private final static Logger logger = Logger.getLogger(HomeController.class);

	@RequestMapping("/")
	public String index() {
		logger.error("!@#$%^&*()_+QWERTYUIOP{}ASDFGHJKL:ZXCVBNM<>?");
		return "Hello welcome vscode when u see this page!";

	}

}
