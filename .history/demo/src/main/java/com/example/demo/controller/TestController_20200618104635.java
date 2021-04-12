package com.example.demo.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
 
 /**
  * 本地访问内容地址 ：http://localhost:8080/hello
  * @param map
  * @return
  */
 @RequestMapping("/hello")
 public String helloHtml(HashMap<String, Object> map) {
  map.put("hello", "欢迎进入HTML页面");
  return "/index";
 }
}