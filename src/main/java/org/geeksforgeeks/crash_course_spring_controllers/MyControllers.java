package org.geeksforgeeks.crash_course_spring_controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyControllers {
	@GetMapping("/addTwoNumbers")
	public String addTwoNumbers(@RequestParam int a, @RequestParam int b) {
		int sum=a+b;
		return "sum:"+sum; 

}	

	@GetMapping("/multiplyTwoNumbers")
	public String multiplyTwoNumbers(@RequestParam int a, @RequestParam int b) {
		int product= a*b;
		return "multiply:"+product; 

}	
}