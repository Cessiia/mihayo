package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeApplication {

	@RequestMapping("/Test")
	public String index(){
		return "Hello Welcome Vscode";
	}

}
