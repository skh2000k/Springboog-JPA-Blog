package com.cos.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempControllerTest {

	@GetMapping("/temp/home")
	public String tempHome() {
		System.out.println("temp home");
		return "test";
	}
	
	@GetMapping("/temp/img")
	public String tempImg() {
		return "/a.jpg";
	}
}
