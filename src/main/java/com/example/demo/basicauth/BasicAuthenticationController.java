package com.example.demo.basicauth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class BasicAuthenticationController {

	
	@GetMapping("basicauth")
	public AuthenticationBean helloWorldBean() {
		
		return new AuthenticationBean("You are authenticated");
	}
	
}