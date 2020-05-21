package com.anubhab.restservices.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@RequestMapping(method = RequestMethod.GET, path = "/helloworld")
	public String helloWorld() {
		return "Hello World123";
	}
	
	@GetMapping("/hello")
	public String helloWorldAnother() {
		return "Hello World1";
	}
	
	@RequestMapping(method = RequestMethod.GET, path="/user")
	public UserDetail helloWorldBean() {
		return new UserDetail("Anubhab", "Mukherjee", "Kolkata");
	}
}
