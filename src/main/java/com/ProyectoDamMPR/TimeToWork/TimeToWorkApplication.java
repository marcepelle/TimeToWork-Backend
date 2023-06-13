package com.ProyectoDamMPR.TimeToWork;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class TimeToWorkApplication {
	public static void main(String[] args) {
		SpringApplication.run(TimeToWorkApplication.class, args);
	}

	@GetMapping("/")
	@ResponseBody
	String home(){
		return "Hello World";
	}
}
