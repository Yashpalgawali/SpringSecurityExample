package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class HelloWorldController {

	@GetMapping("hello-world")
	public String hellow() {
		return "Hello World";
	}
	
	@GetMapping("hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		
		throw new RuntimeException("Some Error Happened");
	}
	
	@GetMapping("hello-world-bean/{name}")
	public HelloWorldBean helloWorldBeanParam(@PathVariable("name")String name) {
		
		return new HelloWorldBean(String.format("Hello World %s", name));
	}
}
