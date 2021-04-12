package com.example.demo.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
 
 /**
  * text spring boot
  * @param map
  * @return
  */
 @RequestMapping("/hello")
 public String helloHtml(HashMap<String, Object> map) {
  map.put("hello", "欢迎进入HTML页面");
  return "/index";
 }
}