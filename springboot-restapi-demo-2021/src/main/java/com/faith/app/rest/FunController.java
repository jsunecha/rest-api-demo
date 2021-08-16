package com.faith.app.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunController {
	
	@Value("${coach.name}")
	private String coachName; // application.properties
	
	@GetMapping("/")
	public String sayHello() {
		return "Hi Giys! " + coachName + " Time is now at Server : " + LocalDateTime.now();
	}
	
	@RequestMapping("/workout")
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}
	
	@RequestMapping("/fortune")
	public String getDailyFortune() {
		return "Guys! Today is your lucky day ! :-)";
	}
	

}
