package com.example.demo.democontr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeApplication {

	public String index(){
		return "Hello Welcome Vscode";
	}

}
